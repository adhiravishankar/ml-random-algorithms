package func;

import shared.DataSet;
import shared.Instance;

/**
 * 
 * @author Andrew Guillory gtg008g@mail.gatech.edu
 * @version 1.0
 */
public interface FunctionApproximater {
    
    /**
     * Estimate from the given data set
     * @param set the data set
     */
    void estimate(DataSet set);
    
    /**
     * Evaluate the function
     * @param i the input
     * @return the value
     */
    Instance value(Instance i);

}
