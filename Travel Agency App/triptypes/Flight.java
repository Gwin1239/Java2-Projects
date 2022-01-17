// COURSE: CSCI1620
// TERM: Fall 2020
// 
// NAME: Godwin Djossou
// RESOURCES: CSLC, Edward
package triptypes;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * This class represents a single flight within the travel agency system.
 * @author gdjossou
 *
 */
public class Flight 
{

	/**
	 * String that contains the Flight Code.
	 */
	private String flightName;
	/**
	 * String that contains the flight number.
	 */
	private int flightNumber;
	/**
	 * String that contains the airport code for the departure airport.
	 */
	private String depart;
	/**
	 * String that contains the airport code for the arrival airport.
	 */
	private String arrive;
	/**
	 * Calendar object that contains the Departure Time.
	 */
	private java.util.Calendar departTime;
	/**
	 * Calendar object that contains the Arrival Time.
	 */
	private java.util.Calendar arriveTime;
	/**
	 * Double variable that contain the flight price.
	 */
	private double flightPrice;
	
	
	/**
	 * Creates a new flight leg in the system.
	 * @param airline The two letter airline code (e.g, "DL", "AA")
	 * @param flightNum The unique flight number on a given day
	 * @param from The three letter airport code for the departure airport (e.g, "OMA")
	 * @param to The three letter airport code for the arrival airport (e.g., "CDG")
	 * @param leavesAt The departure time
	 * @param arrives The arrival time
	 * @param price The price for this flight in US Dollars.
	 */
	public Flight(java.lang.String airline,
			int flightNum,
			java.lang.String from,
			java.lang.String to,
			java.util.Calendar leavesAt,
			java.util.Calendar arrives,
			double price)
	{
		this.flightName = airline;
		this.flightNumber = flightNum;
		this.depart = from;
		this.arrive = to;
		this.departTime = leavesAt;
		this.arriveTime = arrives;
		this.flightPrice = price;
	}
	
	/**
	 * Retrieves the two letter flight code.
	 * @return The two letter flight code.
	 */
	public String getFlightName()
	{
		return this.flightName;
	}
	
	/**
	 * Retrieves the flight number.
	 * @return The flight number.
	 */
	public int getFlightNumber()
	{
		return this.flightNumber;
	}
	
	/**
	 * Retrieves the departure city.
	 * @return The departure city.
	 */
	public String getDepartureFrom()
	{
		return this.depart;
	}
	
	/**
	 * Retrieves the arrival city.
	 * @return The arrival city.
	 */
	public String getArriveFrom()
	{
		return this.arrive;
	}
	
	/**
	 * Retrieves the time of departure.
	 * @return The time of departure.
	 */
	public Calendar getDepartTime()
	{
		return this.departTime;
	}
	
	/**
	 * Retrieves the time of arrival.
	 * @return The time of arrival.
	 */
	public Calendar getArriveTime()
	{
		return this.arriveTime;
	}
	
	/**
	 * Retrieves the price of this flight.
	 * @return The price in US Dollars.
	 */
	public double getPrice()
	{
		return this.flightPrice;
	}
	
	
	/**
	 * Retrieves a formatted string summarizing this Flight. 
	 * Strings will be formatted as: XX#### Departs: AIR at HH:mm MM-dd-YYYY; 
	 * Arrives POR at HH:mm MM-dd-YYYY
	 * Where XX is the two letter airline abbreviation and #### is the 
	 * flight number, which may be1-4 digits in length and is 
	 * right aligned in a 4 character wide field. AIR and POR are the 
	 * departure and arrival airport codes, respectively.
	 * The HH:mm MM-dd-YYYY values correspond to the departure and arrival time formats using a 24-hourclock. 
	 * (see, e.g., java.util.SimpleDateFormat). 
	 * @Override toString in class java.lang.Object
	 * @return Formatted String containing Flight information
	 */
	public java.lang.String toString()
	{
		 
		SimpleDateFormat pretty = new SimpleDateFormat("HH:mm MM-dd-YYYY");
		return String.format(this.flightName + "%4d " + "Departs: " + this.depart 
				+ " at " + pretty.format(this.departTime.getTime())
				+ "; Arrives " + this.arrive + " at "
				+ pretty.format(this.arriveTime.getTime()), this.flightNumber,
				this.departTime, this.arriveTime);
	}
	 
	
	
	
}
