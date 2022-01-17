// COURSE: CSCI1620
// TERM: Fall 2020
// 
// NAME: Godwin Djossou
// RESOURCES: CSLC, Edward
package triptypes;

/**
 * This class encapsulates information about travel packages that can include optional flight arrangements. 
 * Trips that have this format price flight information as an additional charge to a base 
 * package price captured in a concrete subclass of FlightOptionalPackage.
 * @author gdjossou
 *
 */
public abstract class FlightOptionalPackage extends VacationPackage
{
	/**
	 * Final integer that holds the maximum flight number for the Flight array.
	 */
	private final int flightMax = 12;
	/**
	 * Integer value that holds the amount of flights added.
	 */
	private int flightCount;
	/**
	 * Flight array that holds the new flights added.
	 */
	private Flight[] newFlights;
	
	
	/**
	 * Initializes details for a newly created FlightOptionalPackage.
	 * Upon creation, this package will contain no flight bookings.
	 * However, flight legs can be added at a later point.
	 * @param name The promotional name of this package.
	 * @param numDays The number of days this travel package covers.
	 */
	public FlightOptionalPackage(java.lang.String name,
			int numDays)
	{
		super(name, numDays);
		this.newFlights = new Flight[flightMax];
	}
	
	/**
	 * Adds a single one-way flight to this package. 
	 * Round trips and layovers are handled by multiple calls to 
	 * addFlightLeg with one call for each flight. 
	 * Flights must be added in chronological order, 
	 * with the soonest flight added first. 
	 * A maximum of up to 12flights can be stored within a FlightOptionalPackage.
	 * @param details A valid flight object to append to this itinerary.
	 * Invalid values (ie, null) or flights in excess of the 12 maximum will be 
	 * ignored and will not impact this FlightOptionalPackage object.
	 */
	public void addFlightLeg(Flight details)
	{
		if (details != null && flightCount < flightMax)
		{
			this.newFlights[flightCount] = details;
			++flightCount;
		
			
		}
	}
	
	/**
	 * A predicate method for identifying whether a concrete 
	 * object has at least one flight attached to it.
	 * @return true when at least one flight has been added, false otherwise.
	 */
	public boolean hasFlights()
	{
		boolean yesFlights = false;
		
		for (int i = 0; i < newFlights.length; i++)
		{
			if (this.newFlights[i] != null)
			{
				yesFlights = true;
			}
		}
		
		return yesFlights;
	}
	
	/**
	 * Returns the amount of flights added.
	 * @return the amount of flights added.
	 */
	public int getFlightCount()
	{
		return this.flightCount;
	}
	
	/**
	 * Retrieves the current itinerary for this travel package. 
	 * Flights are positioned in the returned array in the order 
	 * in which they were added to this FlightOptionalPackage.
	 * @return The current itinerary array of Flight objects. 
	 * null when no flights have been added yet.
	 */
	public Flight[] getFlightItinerary()
	{
		if (newFlights != null && this.flightCount > 0)
		{
			return newFlights;
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * The total cost of all legs in this FlightOptionalPackage.
	 * @return The sum of all individual flight costs in this package.
	 */
	public double getFlightCosts()
	{
		double totalCost = 0.0;
		if (!this.hasFlights())
		{
			totalCost = 0;
		}
		else
		{
			for (int i = 0; i < flightCount; i++)
			{
				if (this.newFlights[i] != null)
				{
					totalCost += newFlights[i].getPrice();
				}
			}
		}
		
		
		return totalCost;
	}
	
	/**
	 * Retrieves a formatted string summary of this travel package. 
	 * This string will be formatted exactly as prescribed by the TravelPackage class, 
	 * with a postfix indicating whether flight information is included or not. 
	 * @Override toString in class VacationPackage
	 * @return The formatted string summary.
	 */
	public java.lang.String toString()
	{
		String flightString = "";
		if (this.hasFlights())
		{
			flightString = super.toString() 
					+ " (Flight Included)";
		}
		else
		{
			flightString = super.toString()
					+ " (Flight Not Included)";
		}
		
		return flightString;
	}
	
}
