import weka.associations.Apriori;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.meta.FilteredClassifier;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

public class DataMining {

	public static void main(String[] args) throws Exception {
		DataSource trainSource = new DataSource("TrainingData.arff");
		Instances train = trainSource.getDataSet();
		if (train.classIndex() == -1) {
			train.setClassIndex(train.numAttributes() - 1);
		}
		DataSource testSource = new DataSource("TestingData.arff");
		Instances test = testSource.getDataSet();
		if (test.classIndex() == -1) {
			test.setClassIndex(test.numAttributes() - 1);
		}
		// classifier
		J48 j = new J48();
		// meta-classifier
		FilteredClassifier classifier = new FilteredClassifier();
		classifier.setClassifier(j);
		// train and make predictions
		classifier.buildClassifier(train);
		System.out.println(classifier.toString());
		for (int i = 0; i < test.numInstances(); i++) {
			double pred = classifier.classifyInstance(test.instance(i));
			String check = "";
			if (test.classAttribute().value((int) pred) != test.classAttribute()
					.value((int) test.instance(i).classValue())) {
				check = "<< incorrect";
			}
			System.out.println(i + ". actual: "
					+ test.classAttribute().value((int) test.instance(i).classValue()) + ", predicted: "
					+ test.classAttribute().value((int) pred) + " " + check);
		}
	}

}
