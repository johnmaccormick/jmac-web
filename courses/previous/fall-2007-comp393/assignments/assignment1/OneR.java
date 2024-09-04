import java.io.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.util.Hashtable;
import java.lang.StringBuilder;

class Attribute {
    String name;
    String[] values;

    public Attribute(String name, String[] values) {
        this.name = name;
        this.values = values;
    }

    public void print() {
        StringBuilder builder = new StringBuilder();
        builder.append(name + ": ");
        for(String value: values)
            builder.append(value + " ");
        System.out.println(builder);
    }
}

class AttributeSet {
    // A list of the attributes in this AttributeSet
    ArrayList<Attribute> attributes;

    // Key is attribute name, value is the index of this attribute in
    // the ArrayList attributes
    Hashtable<String, Integer> attributeIndices;

    // The name of the attribute that determines the machine learning
    // class of an instance
    String classAttribute;

    // Index of the classAttribute in the ArrayList attributes
    int classAttributeIndex;

    public AttributeSet() {
        attributes = new ArrayList<Attribute>();
        attributeIndices = new Hashtable<String, Integer>();
    }

    public void addAttribute(Attribute attribute) {
        attributes.add(attribute);
        attributeIndices.put(attribute.name, attributes.size() - 1);
    }

    void setClassAttribute(String name) {
        classAttribute = name;
        classAttributeIndex = getAttributeIndex(classAttribute);
    }

    int getAttributeIndex(Attribute attribute) {
        return attributeIndices.get(attribute.name);
    }

    int getAttributeIndex(String name) {
        return attributeIndices.get(name);
    }

    Attribute getAttribute(String name) {
        return attributes.get(getAttributeIndex(name));
    }

    // the machine learning class attribute is the final attribute, by
    // default
    void setDefaultClassAttribute() {
        setClassAttribute(attributes.get(attributes.size()-1).name);
    }

    public void print() {
        for(Attribute attribute: attributes)
            attribute.print();
        System.out.println("Class attribute is " + classAttribute);
    }
}

class Instance {
    String[] values;

    public Instance(String[] values) {
        this.values = values;
    }

    public void print() {
        StringBuilder builder = new StringBuilder();
        for(String value: values )
            builder.append(value + ", ");
        // remove the final ", "
        builder.delete(builder.length()-2, builder.length());
        System.out.println( builder );
    }
}

class ClassFrequencies {
    // Key is the name of the machine learning class, value is the
    // number of instances for which this machine learning class was
    // observed
    public Hashtable<String, Integer> num = new Hashtable<String, Integer>();

    ClassFrequencies(Attribute classAttribute) {
        // Initialize frequency of every machine learning class to 0
        for(String value: classAttribute.values )
            num.put(value, 0);
    }

    void increment(String mlClass) {
        int new_value = num.get(mlClass) + 1;
        num.put(mlClass, new_value);
    }

    String maxName() {
        int max = 0;
        String max_name = null;
        for(String mlClass: num.keySet()) {
            int frequency = num.get(mlClass);
            if (frequency >= max) {
                max = frequency;
                max_name = mlClass;
            }
        }
        return max_name;
    }

    int maxValue() {
        return num.get(maxName());
    }

    int totalFrequencies() {
        int total = 0;
        for(String mlClass: num.keySet()) {
            int frequency = num.get(mlClass);
            total += frequency;
        }  
        return total;
    }

    void print() {
        for(String mlClass: num.keySet()) {
            System.out.print(" " + mlClass + ": " + num.get(mlClass));
        }
        System.out.println();
    }
}

class SingleAttributeRule {
    // the attribute and associated index for which this rule is built
    Attribute attribute;
    int attributeIndex;

    // Some fields from the training set which it's convenient to keep
    // a local copy of
    Attribute classAttribute;
    int classAttributeIndex;
    AttributeSet attributeSet;
    ArrayList<Instance> instances;

    // Key is attribute value, value is a table of frequencies of each
    // machine learning class observed for instances whose attribute
    // value is the given key
    public Hashtable<String, ClassFrequencies> frequencies;

    // Key is attribute value, value is the class assigned to that
    // attribute value by this single attribute rule
    public Hashtable<String, String> decisions;

    // key is attribute value, value is the number of errors made by
    // this rule on the training set
    public Hashtable<String, Integer> numErrors;

    SingleAttributeRule(TrainingSet trainingSet, Attribute attribute) {
        this.attributeSet = trainingSet.attributeSet;
        this.attribute = attribute;
        this.attributeIndex = attributeSet.getAttributeIndex(attribute);
        this.classAttribute = attributeSet.getAttribute(attributeSet.classAttribute);
        this.classAttributeIndex = attributeSet.getAttributeIndex(classAttribute);
        this.instances = trainingSet.instances;

        buildFrequencies();
        computeDecisionsAndErrors();
    }

    private void buildFrequencies() {
        // create the empty frequencies Hashtable
        frequencies = new Hashtable<String, ClassFrequencies>();
        for(String value: attribute.values ) {
            frequencies.put( value, new ClassFrequencies(classAttribute));
        }

        // Loop over all instances, incrementing the relevant frequency
        for( Instance instance: instances ) {
            String mlClass = instance.values[classAttributeIndex];
            String this_attribute_value = instance.values[attributeIndex];
            ClassFrequencies table_to_modify = frequencies.get(this_attribute_value);
            table_to_modify.increment(mlClass);
        }
    }

    private void computeDecisionsAndErrors() {
        decisions = new Hashtable<String, String>();
        numErrors = new Hashtable<String, Integer>();
        for(String value: attribute.values) {
            // Compute decision as most frequent machine learning
            // class for this value
            ClassFrequencies classFrequencies = frequencies.get(value);
            String decision = classFrequencies.maxName();
            decisions.put(value, decision);

            // Compute number of errors as total frequency less
            // the number classified correctly
            int total = classFrequencies.totalFrequencies();
            int num_correct = classFrequencies.maxValue();
            int num_errors = total - num_correct;
            numErrors.put(value, num_errors);
        }        
    }

    //  return the total number of errors made on all instances in the
    //  training set
    int getTotalErrors() {
        int total = 0;
        for(String value: attribute.values) 
            total += numErrors.get(value);
        return total;
    }

    void print() {
        System.out.println("frequencies, decisions, and errors for attribute " + attribute.name + ":");
        for(String value: attribute.values ) {
            System.out.print("  " + value + ": ");
            frequencies.get(value).print();
            System.out.println("    decision: " + decisions.get(value));
            System.out.println("    errors: " + numErrors.get(value));
        }
        System.out.println("  Total errors: " + getTotalErrors());
    }
    
}

class TrainingSet {
    AttributeSet attributeSet = new AttributeSet();
    ArrayList<Instance> instances = new ArrayList<Instance>();

    
    public TrainingSet(String inputFilename) throws FileNotFoundException,IOException,Exception
    {
        parseInputFile(inputFilename);
    }

    private void parseInputFile(String inputFilename) throws FileNotFoundException,IOException,Exception
    {
        BufferedReader reader = new BufferedReader(new FileReader(inputFilename));

        // Input file comprises a "preamble" followed by "data".
        // Data segment is demarcated by a line consisting of the string "@data".
        // We parse the preamble first, constructing attributes and the like.
        String line = reader.readLine();
        while(!parsePreambleLine(line)) {
            line = reader.readLine();
        }
        attributeSet.setDefaultClassAttribute();

        System.out.println("\nFinished processing preamble, attribute set is:");
        this.attributeSet.print();

        // Now parse the data
        line = reader.readLine();
        while(line != null) {
            parseDataLine(line);
            line = reader.readLine();
        }
        reader.close();

        System.out.println("\nFinished processing data, " + instances.size() + 
                           " instances found:");
        for( Instance instance: instances )
            instance.print();
        System.out.println();
    }

    // Return true if this line is the start of the data segment,
    // otherwise return false
    private boolean parsePreambleLine(String line) throws Exception
    {
        if(line.equals(""))
            return false;
        else if(line.startsWith("@relation"))
            return false;
        else if(line.startsWith("@attribute")) {
            parseAttribute(line);
            return false;
        }
        else if(line.startsWith("@data"))
            return true;
        else
            throw new Exception("unexpected line: " + line);
    }

    private void parseAttribute(String line)
    {
        // split on whitespace to extract attribute name
        String[] split_line = line.split("\\s+");
        String attribute_name = split_line[1];

        // Extract the part in braces, which is the list of possible
        // attribute values.
        // To keep things simple, we will split on all brace
        // characters, thus assuming that the only place either
        // brace character appears is at the start and end of the
        // attribute value list
        split_line = line.split("[{}]");
        String value_list = split_line[1];

        // To get the actual values out of value_list, split on commas
        // and whitespace
        String[] values = value_list.split("[,\\s]+");

        // Construct the attribute and add it to the attribute set
        Attribute attribute = new Attribute(attribute_name, values);
        this.attributeSet.addAttribute(attribute);
    }

    private void parseDataLine(String line)
    {
        // Line of data values should be comma-separated with no
        // whitespace, so split on commas
        String[] values = line.split(",");
        Instance instance = new Instance(values);
        this.instances.add(instance);
    }
}


public class OneR {
    TrainingSet trainingSet;
    ArrayList<SingleAttributeRule> rules = new ArrayList<SingleAttributeRule>();
    SingleAttributeRule bestRule;

    void makeRules() {
        for(Attribute attribute: trainingSet.attributeSet.attributes) {
            // Don't build a rule for the machine learning class attribute
            if (attribute.name.equals(trainingSet.attributeSet.classAttribute)) {
                continue;
            }
            SingleAttributeRule rule = new SingleAttributeRule(trainingSet, attribute);
            rules.add(rule);
        }
    }

    void computeBestAttribute() {
        int best_num_errors = Integer.MAX_VALUE;
        for(SingleAttributeRule rule: rules) {
            int num_errors = rule.getTotalErrors();
            if (num_errors <= best_num_errors) {
                best_num_errors = num_errors;
                bestRule = rule;
            }
        }
    }

    public OneR(TrainingSet trainingSet) {
        this.trainingSet = trainingSet;
        makeRules();
        computeBestAttribute();
    }

    void print() {
        for(SingleAttributeRule rule: rules) {
            rule.print();
        }
        System.out.println("Best attribute is " + bestRule.attribute.name
                            + ", error rate " + bestRule.getTotalErrors() 
                           + "/" + trainingSet.instances.size());
    }

    public static void main(String[] arguments)
    {
        try {
            if(arguments.length != 1) {
                throw new Exception("must provide name of input file as the only argument");
            }
            String inputFilename = arguments[0];
            TrainingSet trainingSet = new TrainingSet(inputFilename);
            OneR oneR = new OneR(trainingSet);
            oneR.print();
        }
        catch(Exception exception) {
            exception.printStackTrace();
        }
    }
}

