package rl;

/**
 * An exploration strategy
 * @author Andrew Guillory gtg008g@mail.gatech.edu
 * @version 1.0
 */
public interface ExplorationStrategy {
    /**
     * Draw an action from the strategy
     * @param qvalues the qvalues
     */
    int action(double[] qvalues);
}
