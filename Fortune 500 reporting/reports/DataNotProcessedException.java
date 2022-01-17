// COURSE: CSCI1620
// TERM: Fall 2020
// 
// NAME: Godwin Djossou
// RESOURCES: CSLC, Canvas document.

package reports;

/**
 * An Exception to be thrown if it is attempted to write a report that has not been processed.
 * The "serialVersionUID" warning can be suppressed.
 * @author gdjossou
 *
 */
@SuppressWarnings("serial")
public class DataNotProcessedException extends RuntimeException
{
	/**
	 * Sets the message of the Exception to "Data not processed, cannot write report".
	 */
	public DataNotProcessedException()
	{
		super("Data not processed, cannot write report");
	}

}
