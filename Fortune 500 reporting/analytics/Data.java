// COURSE: CSCI1620
// TERM: Fall 2020
// 
// NAME: Godwin Djossou
// RESOURCES: CSLC, Canvas document.

package analytics;

/**
 * Set of useful reusable tools for analyzing sets of data.
 * @author gdjossou
 *
 */
public class Data
{
	/**
	 * Creates data constructor.
	 */
	public Data()
	{
		//empty constructor
	}
	
	
	/**
	 * Finds the minimum value in the passed array.
	 * NOTE: The array does not need to be completely populated.
	 * All relevant data to be processed starts at index 0.
	 * Unused elements will be null and should not be considered in computations.
	 * Once the first null is encountered it is assumed remaining elements are unused.
	 * @param <E> - Type of data passed. The type must implement the Comparable interface.
	 * @param data - Collection of data to find minimum value of.
	 * @return Minimum value in passed data.
	 */
	public static <E extends java.lang.Comparable<E>> E minimum(E[] data)
	{
		E min;
		if (data.length == 0)
		{
			min = null;
		}
		else
		{
			min = data[0];
		}
		for (int i = 1; i < data.length; i++)
		{
			if (data[i] == null)
			{
				break;
			}
			else if (min.compareTo(data[i]) > 0)
			{
				min = data[i];
			}
		}
        
		return min;
	}

	/**
	 * Finds the maximum value in the passed array.
	 * NOTE: The array does not need to be completely populated.
	 * All relevant data to be processed starts at index 0.
	 * Unused elements will be null and should not be considered in computations.
	 * Once the first null is encountered it is assumed remaining elements are unused.
	 * @param <E> - Type of data passed. The type must implement the Comparable interface.
	 * @param data - Collection of data to find maximum value of.
	 * @return Maximum value in passed data.
	 */
	public static <E extends java.lang.Comparable<E>> E maximum(E[] data)
	{
		E max;
		if (data.length == 0)
		{
			max = null;
		}
		else
		{
			max = data[0];
		}
		for (int i = 1; i < data.length; i++)
		{
			if (data[i] == null)
			{
				break;
			}
			else if (max.compareTo(data[i]) < 0)
			{
				max = data[i];
			}
		}
        
		return max;
	}
	
	/**
	 * Finds the average of values in the passed array.
	 * NOTE: The array does not need to be completely populated.
	 * All relevant data to be processed starts at index 0.
	 * Unused elements will be null and should not be considered in computations.
	 * Once the first null is encountered it is assumed remaining elements are unused.
	 *  @param <N> - Type of data passed. The type must extend the Number class.
	 *  See the assignment supplemental for useful information on the Number class
	 * @param data - Collection of data to find average of.
	 * @return Average of passed data. Regardless of type passed will always return a Double.
	 *  This means if no results are in data it will return Double's "Divide By 0" value, NaN,
	 *  which it should do automatically.
	 */
	public static <N extends java.lang.Number> java.lang.Double average(N[] data)
	{
		double avg = 0;
		for (int i = 0; i < data.length; i++)
		{
			if (data != null)
			{
				avg += data[i].doubleValue();
			}
		}
		
		avg = avg / data.length;
		
		return avg;
	}
	
	/**
	 * Finds the population standard deviation of values in the passed array.
	 * NOTE: The array does not need to be completely populated.
	 * All relevant data to be processed starts at index 0.
	 * Unused elements will be null and should not be considered in computations.
	 * Once the first null is encountered it is assumed remaining elements are unused. 
	 *  @param <N> - Type of data passed. The type must extend the Number class.
	 *  See the assignment supplemental for useful information on the Number class.
	 * @param data - Collection of data to find standard deviation of.
	 * @return Population Standard Deviation of passed data. Regardless of type passed will always return a Double.
	 *  This means if no results are in data it will return Double's "Divide By 0" value, NaN,
	 *  which it should do automatically.

	 */
	public static <N extends java.lang.Number> java.lang.Double standardDeviation(N[] data)
	{
		double avg = 0;
		for (int i = 0; i < data.length; i++)
		{
			if (data != null)
			{
				avg += data[i].doubleValue();
			}
		}
		
		avg = avg / data.length;
		
		double dev = 0;
		for (int i = 0; i < data.length; i++)
		{
			dev += (data[i].doubleValue() - avg) * (data[i].doubleValue() - avg);
		}
		
		dev = Math.sqrt(dev / data.length);
		return dev;
		
	}
}
