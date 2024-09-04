import java.util.ArrayList;
import java.util.Hashtable;

/**
 * A DecisionTreeNode represents a single node in a decision tree. A node is
 * either a leaf or an internal node. Leaf nodes have a fixed "decision" for any
 * instance that matches them, whereas internal nodes have a number of children
 * nodes, and a "split attribute" on which a matching instance can be "split".
 * The instance's value for the given split attribute is used to pass the
 * instance on to the corresponding child node.
 * 
 * @author jmac
 * 
 */
public class DecisionTreeNode {
	// a list of attributes on which this node is permitted to split
	private ArrayList<Attribute> availableAttributes;

	// the depth of this node in the decision tree (the root node has level 0,
	// its children have level 1, and so on)
	private int level;

	// the attribute value that would appear on the edge leading to this node's
	// parent, in the conventional way of drawing decision trees -- see for
	// example Figure 4.4 of Witten and Frank (second edition)
	private String selectionValue;

	// is this node a leaf node or internal node?
	private boolean isLeaf;

	// the distribution of the machine learning classes of all training
	// instances used to create this node
	private Distribution classDistribution;

	// the decision (i.e. machine learning class) assigned to all instances
	// matching this node -- valid for leaf nodes only
	private String decision;

	// the attribute on which this node splits its set of instances and assigns
	// them to children nodes -- valid for internal nodes only
	private Attribute splitAttribute;

	// the index (in the relevant AttributeSet of the split attribute) -- valid
	// for internal nodes only
	private int splitAttributeIndex;

	// a decision stump used to decide which attribute to split on -- valid for
	// internal nodes only
	private DecisionStump decisionStump;

	// A table mapping the possible values of the split attribute to their
	// corresponding child nodes.
	// For example, if the split attribute was "outlook", the keys of this table
	// would be "rainy", "sunny", etc., and the child node corresponding to
	// "rainy" would be created from all instances in this node's training set
	// whose "outlook" is "rainy".
	private Hashtable<String, DecisionTreeNode> children;

	/**
	 * @param availableAttributes
	 *            a list of attributes on which this node is permitted to split
	 * @param level
	 *            the depth of this node in the decision tree (the root node has
	 *            level 0, its children have level 1, and so on)
	 * @param selectionValue
	 *            the attribute value that would appear on the edge leading to
	 *            this node's parent, in the conventional way of drawing
	 *            decision trees -- see for example Figure 4.4 of Witten and
	 *            Frank (second edition)
	 * @param instanceSet
	 *            the set of instances on which this node is to be trained
	 */
	public DecisionTreeNode(ArrayList<Attribute> availableAttributes,
			int level, String selectionValue, InstanceSet instanceSet) {
		this.availableAttributes = availableAttributes;
		this.level = level;
		this.selectionValue = selectionValue;
		classDistribution = makeClassDistribution(instanceSet);

		if (isPure() || availableAttributes.size() == 0) {
			isLeaf = true;
			decision = classDistribution.getNameOfMaxFrequency();
		} else {
			isLeaf = false;
			decision = null;
			children = new Hashtable<String, DecisionTreeNode>();
			doSplit(instanceSet);
		}
	}

	/**
	 * @param instance
	 *            the instance whose matching node is to be found
	 * @return the leaf node in which the given instance would end up if it
	 *         walked down the decision tree from this point, at each node
	 *         choosing the child whose selectionValue field matches the
	 *         instance's value for this node's split attribute
	 */
	public DecisionTreeNode getMatchingLeaf(Instance instance) {
		if (isLeaf) {
			return this;
		} else {
			String relevantValue = instance.getValues()[splitAttributeIndex];
			DecisionTreeNode relevantChild = children.get(relevantValue);
			return relevantChild.getMatchingLeaf(instance);
		}
	}

	/**
	 * print some details about this DecisionTreeNode
	 */
	public void print() {
		String node_type;
		if (isLeaf)
			node_type = "leaf";
		else
			node_type = "internal";

		// insert some spaces to indent this node by an amount proportional to
		// its level in the tree
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < level; i++) {
			builder.append("   ");
		}

		// print the selection value, level, and node type
		builder.append(selectionValue + ": level " + level + " " + node_type
				+ " node, ");

		// if we're a leaf, print our decision and number of errors; otherwise
		// print our split attribute
		if (isLeaf) {
			int num_errors = classDistribution.getTotalFrequencies()
					- classDistribution.getValueOfMaxFrequency();
			builder.append("decision is " + decision + " (" + num_errors
					+ " errors)");
		} else {
			builder.append("split on attribute " + splitAttribute.getName());
		}
		System.out.println(builder);

		// print the children if there are any
		if (!isLeaf) {
			for (DecisionTreeNode child : children.values()) {
				child.print();
			}
		}
	}

	// return true if the distribution of machine learning classes in this
	// node's training set is pure
	private boolean isPure() {
		if (classDistribution.getTotalFrequencies() == classDistribution
				.getValueOfMaxFrequency())
			return true;
		else
			return false;
	}

	// make a distribution from the machine learning classes of the given
	// instance set
	private Distribution makeClassDistribution(InstanceSet instanceSet) {
		int classAttributeIndex = instanceSet.getAttributeSet()
				.getClassAttributeIndex();
		Attribute classAttribute = instanceSet.getAttributeSet()
				.getClassAttribute();
		Distribution theClassDistribution = new Distribution(classAttribute);
		for (Instance instance : instanceSet.getInstances()) {
			String instanceClass = instance.getValues()[classAttributeIndex];
			theClassDistribution.incrementFrequency(instanceClass);
		}
		theClassDistribution.moveFrequenciesToNormalizedProbabilities();
		return theClassDistribution;
	}

	// choose the best split attribute for the given instance set, and perform
	// the split: create the necessary children and pass them their matching
	// instances from the instance set
	private void doSplit(InstanceSet instanceSet) {
		// create and learn a decision stump for this set of instances
		decisionStump = new DecisionStump(instanceSet.getAttributeSet(),
				availableAttributes);
		decisionStump.learn(instanceSet);

		// store the split attribute and its index
		splitAttribute = decisionStump.getBestAttribute();
		splitAttributeIndex = instanceSet.getAttributeSet().getAttributeIndex(
				splitAttribute);

		// generate a list of attributes that excludes the split attribute
		ArrayList<Attribute> remainingAttributes = generateRemainingAttributes(splitAttribute);

		// loop over the possible values of the split attribute, creating a
		// child node for each value, based on the instances which match this
		// value
		for (String attributeValue : splitAttribute.getValues()) {
			InstanceSet matchingInstanceSet = extractMatchingInstances(
					instanceSet, splitAttribute, attributeValue);
			DecisionTreeNode child = new DecisionTreeNode(remainingAttributes,
					level + 1, attributeValue, matchingInstanceSet);
			children.put(attributeValue, child);
		}

	}

	// return a new instance set consisting of all elements of the parameter
	// instanceSet whose attribute value (for the attribute given by parameter
	// "attribute") matches matchValue. For example, if parameter "attribute" is the
	// "Outlook" attribute and matchValue is "rainy", we return all instances
	// whose "Outlook" is "rainy".
	private InstanceSet extractMatchingInstances(InstanceSet instanceSet,
			Attribute attribute, String matchValue) {
		int attributeIndex = instanceSet.getAttributeSet().getAttributeIndex(
				attribute);
		ArrayList<Instance> matchingInstances = new ArrayList<Instance>();

		// loop of all instances, adding them to matchingInstances if they match
		for (Instance instance : instanceSet.getInstances()) {
			String instance_value = instance.getValues()[attributeIndex];
			if (matchValue.equals(instance_value)) {
				matchingInstances.add(instance);
			}
		}

		// create and return the new instance set
		InstanceSet matchingInstanceSet = new InstanceSet(instanceSet
				.getAttributeSet(), matchingInstances);

		return matchingInstanceSet;
	}

	// return a new list of attributes generated by taking the
	// availableAttributes list, and removing attributeToRemove -- this is
	// useful when we want to create a child node whose availableAttributes will
	// be the same as the current node, except with one attribute (this node's
	// split attribute) removed
	@SuppressWarnings("unchecked")
	private ArrayList<Attribute> generateRemainingAttributes(
			Attribute attributeToRemove) {
		ArrayList<Attribute> remainingAttributes = (ArrayList<Attribute>) availableAttributes
				.clone();
		remainingAttributes.remove(attributeToRemove);
		return remainingAttributes;
	}

	/**
	 * @return the decision made by this node, provided the node is a leaf
	 * @throws Exception
	 *             if the node is an internal node
	 */
	public String getDecision() throws Exception {
		if (!isLeaf)
			throw new Exception(
					"internal DecisionTreeNode cannot make a decision, only leaf nodes can");

		return decision;
	}

	/**
	 * @return the table mapping class values to their probabilities, provided
	 *         this node is a leaf
	 * @throws Exception
	 *             if the node is an internal node
	 */
	public Hashtable<String, Double> getClassProbabilities() throws Exception {
		if (!isLeaf)
			throw new Exception(
					"internal DecisionTreeNode cannot assign class probabilities, only leaf nodes can");

		return classDistribution.getProbabilities();
	}

}
