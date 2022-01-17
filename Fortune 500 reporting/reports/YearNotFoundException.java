// COURSE: CSCI1620
// TERM: Fall 2020
// 
// NAME: Godwin Djossou
// RESOURCES: CSLC, Canvas document.

package reports;

/**
 * An Exception to be thrown if a requested year is not present in the data set.
 * The "serialVersionUID" warning can be suppressed.
 * @author gdjossou
 *
 */
@SuppressWarnings("serial")
public class YearNotFoundException extends RuntimeException
{
	/**
	 * Sets the message of the Exception to "Requested year not in file".
	 */
	public YearNotFoundException()
	{
		super("Requested year not in file");
	}
}
