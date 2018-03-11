import dist.DiscreteDependencyTree;
import dist.DiscretePermutationDistribution;
import dist.Distribution;
import opt.*;
import opt.ga.*;
import opt.prob.GenericProbabilisticOptimizationProblem;
import opt.prob.MIMIC;
import opt.prob.ProbabilisticOptimizationProblem;
import shared.FixedIterationTrainer;

import java.util.Random;

/**
 * 
 * @author kmandal
 * @version 1.0
 */
public class MaxKColoringTest {
    /** The n value */
    private static final int N = 50; // number of vertices
    private static final int L =4; // L adjacent nodes per vertex
    private static final int K = 8; // K possible colors
    /**
     * The test main
     * @param args ignored
     */
    public static void main(String[] args) {
        int[] iterations = {5, 10, 25, 50, 100, 250, 500, 750, 1000, 2000, 5000, 10000, 20000, 50000, 100000, 250000};
        Random random = new Random(N*L);
        // create the random velocity
        Vertex[] vertices = new Vertex[N];
        for (int i = 0; i < N; i++) {
            Vertex vertex = new Vertex();
            vertices[i] = vertex;	
            vertex.setAdjMatrixSize(L);
            for(int j = 0; j <L; j++ ){
            	 vertex.getAadjacencyColorMatrix().add(random.nextInt(N*L));
            }
        }
        /*for (int i = 0; i < N; i++) {
            Vertex vertex = vertices[i];
            System.out.println(Arrays.toString(vertex.getAadjacencyColorMatrix().toArray()));
        }*/
        // for rhc, sa, and ga we use a permutation based encoding
        MaxKColorFitnessFunction ef = new MaxKColorFitnessFunction(vertices);
        Distribution odd = new DiscretePermutationDistribution(K);
        HillClimbingProblem hcp = new GenericHillClimbingProblem(ef, odd, new SwapNeighbor());
        GeneticAlgorithmProblem gap = new GenericGeneticAlgorithmProblem(ef, odd, new SwapMutation(), new SingleCrossOver());
        
        Distribution df = new DiscreteDependencyTree(.1); 
        ProbabilisticOptimizationProblem pop = new GenericProbabilisticOptimizationProblem(ef, odd, df);

        for (int iterator : iterations) {
            rhc(ef, hcp, iterator);
            sa(ef, hcp, iterator);
            sga(ef, gap, iterator);
            mimic(ef, pop, iterator);
        }
    }

    private static void rhc(MaxKColorFitnessFunction ef, HillClimbingProblem hcp, int iterations) {
        long starttime = System.nanoTime();
        RandomizedHillClimbing rhc = new RandomizedHillClimbing(hcp);
        FixedIterationTrainer fit = new FixedIterationTrainer(rhc, iterations);
        fit.train();
        System.out.println("RHC: " + ef.value(rhc.getOptimal()));
        System.out.println(ef.foundConflict());
        System.out.println("Time : "+ (System.nanoTime() - starttime));

        System.out.println("============================");
    }

    private static void mimic(MaxKColorFitnessFunction ef, ProbabilisticOptimizationProblem pop, int iterations) {
        long starttime;
        FixedIterationTrainer fit;
        starttime = System.nanoTime();
        MIMIC mimic = new MIMIC(200, 100, pop);
        fit = new FixedIterationTrainer(mimic, iterations);
        fit.train();
        System.out.println("MIMIC: " + ef.value(mimic.getOptimal()));
        System.out.println(ef.foundConflict());
        System.out.println("Time : "+ (System.nanoTime() - starttime));
    }

    private static void sga(MaxKColorFitnessFunction ef, GeneticAlgorithmProblem gap, int iterations) {
        long starttime;
        FixedIterationTrainer fit;
        starttime = System.nanoTime();
        StandardGeneticAlgorithm ga = new StandardGeneticAlgorithm(200, 10, 60, gap);
        fit = new FixedIterationTrainer(ga, iterations);
        fit.train();
        System.out.println("GA: " + ef.value(ga.getOptimal()));
        System.out.println(ef.foundConflict());
        System.out.println("Time : "+ (System.nanoTime() - starttime));

        System.out.println("============================");
    }

    private static void sa(MaxKColorFitnessFunction ef, HillClimbingProblem hcp, int iterations) {
        long starttime;
        FixedIterationTrainer fit;
        starttime = System.nanoTime();
        SimulatedAnnealing sa = new SimulatedAnnealing(1E12, .1, hcp);
        fit = new FixedIterationTrainer(sa, iterations);
        fit.train();
        System.out.println("SA: " + ef.value(sa.getOptimal()));
        System.out.println(ef.foundConflict());
        System.out.println("Time : "+ (System.nanoTime() - starttime));

        System.out.println("============================");
    }
}
