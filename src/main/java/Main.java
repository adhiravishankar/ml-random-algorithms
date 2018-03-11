import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import func.nn.backprop.BackPropagationNetwork;
import func.nn.backprop.BackPropagationNetworkFactory;
import opt.OptimizationAlgorithm;
import opt.RandomizedHillClimbing;
import opt.SimulatedAnnealing;
import opt.example.NeuralNetworkOptimizationProblem;
import opt.ga.StandardGeneticAlgorithm;
import opt.prob.MIMIC;
import shared.DataSet;
import shared.ErrorMeasure;
import shared.Instance;
import shared.SumOfSquaresError;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String [] args) throws IOException {
        BackPropagationNetworkFactory factory = new BackPropagationNetworkFactory();
        ErrorMeasure measure = new SumOfSquaresError();


        List<Instance> instances = getInstances();
        DataSet set = getDataset(instances);

        int hiddenLayer = 38;
        int inputLayer = 40;
        int outputLayer = 1;
        BackPropagationNetwork network = factory.createClassificationNetwork(new int[] {inputLayer, hiddenLayer, outputLayer});
        NeuralNetworkOptimizationProblem nnop = new NeuralNetworkOptimizationProblem(set, network, measure);

        // RandomizedHillClimbing rhc = new RandomizedHillClimbing(nnop);
        // runNetwork("Randomized Hill Climbing", measure, instances, set, network, rhc);

        // SimulatedAnnealing sa = new SimulatedAnnealing(1E11, .95, nnop);
        // runNetwork("Simulated Annealing", measure, instances, set, network, sa);

        // MIMIC mimic = new MIMIC(1000, 1000, nnop);
        // runNetwork("MIMIC", measure, instances, set, network, mimic);

        StandardGeneticAlgorithm sga = new StandardGeneticAlgorithm(10000, 5000, 500, nnop);
        runNetwork("Standard Genetic Algorithm", measure, instances, set, network, sga);

    }

    private static void runNetwork(String name, ErrorMeasure measure, List<Instance> instances, DataSet set, BackPropagationNetwork network, OptimizationAlgorithm oa) {
        double start = System.nanoTime(), end, trainingTime, testingTime, correct = 0, incorrect = 0;
        train(oa, network, name, measure, set.getInstances());
        end = System.nanoTime();
        trainingTime = end - start;
        trainingTime /= Math.pow(10,9);

        Instance optimalInstance = oa.getOptimal();
        network.setWeights(optimalInstance.getData());

        double predicted, actual;
        start = System.nanoTime();
        for (Instance instance : instances) {
            network.setInputValues(instance.getData());
            network.run();

            predicted = Double.parseDouble(instance.getLabel().toString());
            actual = Double.parseDouble(network.getOutputValues().toString());

            double trash = Math.abs(predicted - actual) < 0.5 ? correct++ : incorrect++;

        }
        end = System.nanoTime();
        testingTime = end - start;
        testingTime /= Math.pow(10,9);

        System.out.println("\nResults for " + name + ": \nCorrectly classified " + correct + " instances." +
                "\nIncorrectly classified " + incorrect + " instances.\nPercent correctly classified: "
                + (correct/(correct+incorrect)*100) + "%\nTraining time: " + (trainingTime)
                + " seconds\nTesting time: " + (testingTime) + " seconds\n");
    }

    private static DataSet getDataset(List<Instance> instances) {
        Instance[] instancesArray = new Instance[instances.size()];
        instances.toArray(instancesArray);
        return new DataSet(instancesArray);
    }

    private static List<Instance> getInstances() throws IOException {
        File file = new File("census-income-processed.data.csv");
        CsvMapper mapper = new CsvMapper();

        CsvSchema schema = mapper.schemaFor(CensusRecord.class).withoutHeader();
        MappingIterator<CensusRecord> emailRecordMappingIterator = mapper.readerFor(CensusRecord.class).with(schema).readValues(file);
        List<Instance> instances = new ArrayList<>();
        while (emailRecordMappingIterator.hasNextValue()) {
            instances.add(emailRecordMappingIterator.nextValue().convertToInstance());
        }
        return instances;
    }

    private static void train(OptimizationAlgorithm oa, BackPropagationNetwork network, String name, ErrorMeasure measure, Instance[] instances) {
        System.out.println("\nError results for " + name + "\n---------------------------");

        int trainingIterations = 1000;
        AtomicInteger atomicInteger;
        for(int i = 0; i < trainingIterations; i++) {
            oa.train();

            double error = 0;
            atomicInteger = new AtomicInteger(0);
            for (Instance instance : instances) {
                network.setInputValues(instance.getData());
                network.run();

                Instance output = instance.getLabel(), example = new Instance(network.getOutputValues());
                example.setLabel(new Instance(Double.valueOf(network.getOutputValues().toString())));
                atomicInteger.addAndGet((int) measure.value(output, example));
            }

            System.out.println(error);
        }
    }

}
