/*
 *    This program is free software; you can redistribute it and/or modify
 *    it under the terms of the GNU General Public License as published by
 *    the Free Software Foundation; either version 2 of the License, or
 *    (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program; if not, write to the Free Software
 *    Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */

/*
 *    SelectiveNaiveBayes.java
 *    Copyright (C) 1999 Eibe Frank,Len Trigg
 *
 */

package weka.classifiers.bayes;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;
import java.io.IOException;
import java.util.*;

import weka.core.*;

/**
 * Class for a Selective Naive Bayes classifier. The selective Naive Bayes
 * classifier chooses a subset of attributes on which to operate, by starting
 * with the empty set of attributes and greedily adding the single attribute
 * that results in the most improved performance, as measured by the error rate
 * of a standard Naive Bayes classifier on the training set. If no attribute
 * improves the error rate, the current subset of attributes is frozen and used
 * later for classification (again using a standard Naive Bayes classifier). In
 * this simple implementation, the default Weka Naive Bayes classifier is always
 * used -- no options may be passed to it.
 * 
 * @author John MacCormick
 * @version 10-19-2007
 */
@SuppressWarnings("serial")
public class SelectiveNaiveBayes extends Classifier {

	// a list of the attributes retained for use by the Selective Naive Bayes
	// classifier (includes the machine learning class attribute)
	private ArrayList<Attribute> attributesToKeep;

	// a filter that is a set up to remove the irrelevant attributes (i.e. those
	// that were not selected by the Selective Naive Bayes classifier) from any
	// Instance or Instances object
	private Remove removeFilter;

	// a standard Naive Bayes classifier learned from the training instances
	// after the removeFilter has been applied to them
	private NaiveBayes naiveBayes;

	/**
	 * Returns a string describing this classifier
	 * 
	 * @return a description of the classifier suitable for displaying in the
	 *         explorer/experimenter gui
	 */
	public String globalInfo() {
		return "Class for a Selective Naive Bayes classifier.";
	}

	/**
	 * Generates the classifier.
	 * 
	 * @param instances
	 *            set of instances serving as training data
	 * @exception Exception
	 *                if the classifier has not been generated successfully
	 */
	public void buildClassifier(Instances instances) throws Exception {
        // TODO:  implement this method
	}

	/**
	 * Calculates the class membership probabilities for the given test
	 * instance.
	 * 
	 * @param instance
	 *            the instance to be classified
	 * @return predicted class probability distribution
	 * @exception Exception
	 *                if there is a problem generating the prediction
	 */
	public double[] distributionForInstance(Instance instance) throws Exception {
        // TODO:  implement this method
		return null;
	}

	/**
	 * Returns a description of the classifier.
	 * 
	 * @return a description of the classifier as a string.
	 */
	public String toString() {

		StringBuffer text = new StringBuffer();

		text.append("Selective Naive Bayes Classifier:\n");
		text.append("  selected " + this.attributesToKeep.size()
				+ " attributes (including class attribute)");
		text.append(" in the following order:\n        ");
		for (Attribute attribute : this.attributesToKeep) {
			text.append(attribute.name() + " ");
		}
		text.append("\n\nThe Naive Bayes Classifier "
				+ "learned from these attributes is as follows:\n\n");
		text.append(this.naiveBayes.toString());

		return text.toString();
	}

	// return the number of training instances classified correctly from the
	// parameter @instances, if a naïve based classifier is learned from only
	// the attributes whose indices are specified by @indicesToKeep.
	// Returns a double so that weighted instances are also valid.
	private double getNumCorrectUsingDesiredAttributes(
			ArrayList<Integer> indicesToKeep, Instances instances)
			throws Exception {
		Instances filtered_instances = removeUnwantedAttributesFromInstances(
				indicesToKeep, instances);
		NaiveBayes naiveBayes = new NaiveBayes();
		naiveBayes.buildClassifier(filtered_instances);
		Evaluation evaluation = new Evaluation(filtered_instances);
		evaluation.evaluateModel(naiveBayes, filtered_instances);
		return evaluation.correct();
	}

	// return an ArrayList of the attributes whose indices are specified by
	// @indicesToKeep, assuming the set of attributes as that used by the given
	// @instances
	private ArrayList<Attribute> getAttributesUsingIndices(
			ArrayList<Integer> indicesToKeep, Instances instances) {
		ArrayList<Attribute> attributes_to_keep = new ArrayList<Attribute>();
		for (int i : indicesToKeep) {
			attributes_to_keep.add(instances.attribute(i));
		}
		return attributes_to_keep;
	}

	// Return a new set of instances which is obtained from the given
	// @instances by retaining only the attributes whose indices are
	// specified by @indicesToKeep
	private Instances removeUnwantedAttributesFromInstances(
			ArrayList<Integer> indicesToKeep, Instances instances)
			throws Exception {
		int classIndex = instances.classIndex();
		Remove remove_filter = makeRemoveFilter(indicesToKeep, instances);
		Instances copy = new Instances(instances);
		copy.setClassIndex(classIndex);
		remove_filter.setInputFormat(copy);

		Instances filtered_instances = Filter.useFilter(copy, remove_filter);
		if (filtered_instances == null
				|| filtered_instances.numAttributes() < 1) {
			throw new Exception("Dataset is empty.");
		}
		return filtered_instances;
	}

	// Return a "Remove"-type Weka filter that can be used to remove all
	// attributes except those specified by @indicesToKeep
	private Remove makeRemoveFilter(ArrayList<Integer> indicesToKeep,
			Instances instances) throws Exception {
		Remove remove_filter = new Remove();
		remove_filter.setInvertSelection(true);
		remove_filter
				.setAttributeIndicesArray(getIntArrayListAsPrimitiveArray(indicesToKeep));
		remove_filter.setInputFormat(instances);
		return remove_filter;
	}

	// Return a new instance obtained from the given @instance by applying the
	// filter stored in this object's removeFilter field -- this has the effect
	// of removing "unwanted" attributes from the given @instance
	private Instance removeUnwantedAttributesFromInstance(Instance instance)
			throws Exception {
		Instance copy = (Instance) instance.copy();
		removeFilter.input(copy);
		Instance filtered_instance = removeFilter.output();
		if (filtered_instance == null || filtered_instance.numAttributes() < 1) {
			throw new Exception("Instance is empty.");
		}
		return filtered_instance;
	}

	// Return a "primitive array" of integers with the same contents as the
	// given ArrayList of integers -- needed for use with some Weka functions
	// which require primitive arrays rather than ArrayLists.
	// (The toArray(T[]) method of ArrayList looks like it is meant to do this,
	// but I was unable to make it work with int[].)
	private int[] getIntArrayListAsPrimitiveArray(ArrayList<Integer> array) {
		int[] primitive_array = new int[array.size()];
		for (int i = 0; i < array.size(); i++) {
			primitive_array[i] = array.get(i);
		}
		return primitive_array;
	}

	/**
	 * Main method for testing this class.
	 * 
	 * @param argv
	 *            the options
	 * @throws IOException
	 */
	public static void main(String[] argv) throws IOException {

		try {
			System.out.println(Evaluation.evaluateModel(
					new SelectiveNaiveBayes(), argv));
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
	}
}
