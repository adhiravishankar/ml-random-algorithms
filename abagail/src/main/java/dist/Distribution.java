package dist;

import java.io.Serializable;
import java.util.Random;

import shared.DataSet;
import shared.Instance;

/**
 * A interface for distributions
 * @author Andrew Guillory gtg008g@mail.gatech.edu
 * @version 1.0
 */
public interface Distribution extends Serializable { 
    /**
     * A random number generator
     */
    Random random = new Random();
    /**
     * Get the probability of i
     * @param i the discrete value to get the probability of
     * @return the probability of i
     */
    double p(Instance i);
    /**
     * Calculate the log likelihood
     * @param i the instance
     * @return the log likelihood
     */
    double logp(Instance i);
    
    /**
     * Generate a random value
     * @param i the conditional values or null
     * @return the value
     */
    Instance sample(Instance i);
    
    /**
     * Generate a random value
     * @return the value
     */
    Instance sample();
    
    /**
     * Get the mode of the distribution
     * @param i the instance
     * @return the mode
     */
    Instance mode(Instance i);
    
    /**
     * Get the mode of the distribution
     * @return the mode
     */
    Instance mode();
    
    /**
     * Estimate the distribution from data
     * @param set the data set to estimate from
     */
    void estimate(DataSet set);

}