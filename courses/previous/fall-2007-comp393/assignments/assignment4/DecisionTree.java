import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Implements a simple decision tree classifier with no pruning.
 * 
 * @author jmac
 * 
 */
public class DecisionTree extends Classifier {

	// the root node of the decision tree
	private DecisionTreeNode root;

	/**
	 * @param attributeSet
	 *            the set of attributes to be used by this classifier
	 */
	public DecisionTree(AttributeSet attributeSet) {
		super(attributeSet);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Classifier#computeClassProbabilities(Instance)
	 */
	@Override
	public Hashtable<String, Double> computeClassProbabilities(Instance instance)
			throws Exception {
		DecisionTreeNode matchingLeaf = root.getMatchingLeaf(instance);
		return matchingLeaf.getClassProbabilities();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Classifier#decide(Instance)
	 */
	@Override
	public String decide(Instance instance) throws Exception {
		DecisionTreeNode matchingLeaf = root.getMatchingLeaf(instance);
		return matchingLeaf.getDecision();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Classifier#learn(InstanceSet)
	 */
	@Override
	public void learn(InstanceSet trainingSet) throws Exception {
		ArrayList<Attribute> nonClassAttributes = generateNonClassAttributes();
		root = new DecisionTreeNode(nonClassAttributes, 0, "root", trainingSet);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Classifier#print()
	 */
	@Override
	public void print() throws Exception {
		root.print();
	}

	// return a list of all attributes except for the machine learning class
	// attribute
	@SuppressWarnings("unchecked")
	private ArrayList<Attribute> generateNonClassAttributes() {
		Attribute mlClassAttribute = attributeSet.getClassAttribute();
		ArrayList<Attribute> nonClassAttributes = (ArrayList<Attribute>) attributeSet
				.getAttributes().clone();
		nonClassAttributes.remove(mlClassAttribute);
		return nonClassAttributes;
	}
}
