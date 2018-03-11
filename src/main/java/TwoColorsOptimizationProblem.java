import dist.Distribution;
import func.nn.NeuralNetwork;
import opt.ContinuousAddOneNeighbor;
import opt.EvaluationFunction;
import opt.HillClimbingProblem;
import opt.NeighborFunction;
import opt.example.NeuralNetworkEvaluationFunction;
import opt.example.NeuralNetworkWeightDistribution;
import opt.example.TwoColorsEvaluationFunction;
import opt.ga.*;
import opt.prob.ProbabilisticOptimizationProblem;
import shared.DataSet;
import shared.ErrorMeasure;
import shared.Instance;

public class TwoColorsOptimizationProblem implements HillClimbingProblem, GeneticAlgorithmProblem, ProbabilisticOptimizationProblem {

    /**
     * The evaluation function
     */
    private EvaluationFunction eval;
    /**
     * The cross over function
     */
    private CrossoverFunction crossover;
    /**
     * The neighbor function
     */
    private NeighborFunction neighbor;
    /**
     * The mutation function
     */
    private MutationFunction mutate;
    /**
     * The distribution
     */
    private Distribution dist;

    /**
     * Make a new neural network optimization
     * @param examples the examples
     * @param network the neural network
     * @param measure the error measure
     */
    public TwoColorsOptimizationProblem(DataSet examples,
                                            NeuralNetwork network, ErrorMeasure measure) {
        eval = new TwoColorsEvaluationFunction();
        crossover = new UniformCrossOver();
        neighbor = new ContinuousAddOneNeighbor();
        mutate = new ContinuousAddOneMutation();
        dist = new NeuralNetworkWeightDistribution(network.getLinks().size());
    }

    /**
     * @see opt.OptimizationProblem#value(opt.OptimizationData)
     */
    public double value(Instance d) {
        return eval.value(d);
    }

    /**
     * @see opt.OptimizationProblem#random()
     */
    public Instance random() {
        return dist.sample(null);
    }

    /**
     * @see opt.OptimizationProblem#neighbor(opt.Instance)
     */
    public Instance neighbor(Instance d) {
        return neighbor.neighbor(d);
    }


    /**
     * @see opt.GeneticAlgorithmProblem#mate(opt.Instance, opt.Instance)
     */
    public Instance mate(Instance da, Instance db) {
        return crossover.mate(da, db);
    }

    /**
     * @see opt.GeneticAlgorithmProblem#mutate(opt.Instance)
     */
    public void mutate(Instance d) {
        mutate.mutate(d);
    }

    /**
     * @see opt.Mimic#mutate(opt.Instance)
     */
    @Override
    public Distribution getDistribution() {
        return dist;
    }
}
