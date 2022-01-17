// COURSE: CSCI1620
// TERM: Fall 2020
// 
// NAME: Godwin Djossou
// RESOURCES: CSLC, Edward
package triptypes;
//import java.util.ArrayList;
//import java.util.Calendar;

/**
 * This class represents a cruise package within the travel agency.
 * It stores required information about the cruise ship, including departure and arrival times. 
 * It allows for optional off-ship excursion packages to be added to a trip for an additional price.
 * @author gdjossou
 *
 */
public class Cruise extends FlightOptionalPackage
{


	/**
	 * String that contains the shipname. 
	 */
	private String shipName;
	/**
	 * String that contains the cityname.
	 */
	private String cityName;
	/**
	 * Calendar object for the departure date.
	 */
	private java.util.Calendar leave;
	/**
	 * Calendar object for the arrival date.
	 */
	private java.util.Calendar comeBack;
	/**
	 * Double that contains the cabinprice.
	 */
	private double cabinPrice;
	/**
	 * Integer that contains the number of excursions.
	 */
	private int excursionCount;
	/**
	 * String array that contains the excursions.
	 */
	private String[] excursionArray;
	/**
	 * CabinType Object for the Cruise.
	 */
	private CabinType newCabin;
	/**
	 * Double that contains the total excursion cost.
	 */
	private double totalExcursionCost;
	/**
	 * Double for the OceanView cabin price addition.
	 */
	private final double oceanPrice = 1.5;
	/**
	 * Double for the deposit Amount halving.
	 */
	private final double half = 0.50;
	/**
	 * Creates a new Cruise trip with specified values for all data except optional excursions.
	 * @param name The promotional name of the travel package.
	 * @param numDays The number of days for this travel package.
	 * @param vesselName The ship name for this Cruise.
	 * @param portCity The departure port for this Cruise.
	 * @param departs The time and date of departure from the port.
	 * @param returns The time and date of return to the port.
	 * @param basePrice The base price for the cheapest tier cabin (interior) on the ship.
	 * Cabin upgrades can be accommodated through a subsequent setter call.
	 */
	public Cruise(java.lang.String name,
			int numDays,
			java.lang.String vesselName,
			java.lang.String portCity,
			java.util.Calendar departs,
			java.util.Calendar returns,
			double basePrice)
	{
		super(name, numDays);
		this.shipName = vesselName;
		this.cityName = portCity;
		this.leave = departs;
		this.comeBack = returns;
		this.cabinPrice = basePrice;
		this.newCabin = CabinType.INTERIOR;
		this.excursionArray = new String[10];
		this.excursionCount = 0;
	}
	
	/**
	 * Adds a named excursion to this Cruise. 
	 * Excursions may or may not have an additional charge associated. 
	 * A maximum of 10 excursions can be added.
	 * @param excursion The name of the excursion to add to this package.
	 * Empty excursion values are invalid and should not 
	 * result in a change to the Cruise package configuration.
	 * @param price The price of the excursion. 
	 * Prices must be >= 0, with any negative values being treated as equivalent to 0.
	 */
	public void addExcursion(java.lang.String excursion,
			double price)
	{
		if (excursionCount < 10)
		{
			if (excursion != null && !excursion.equals(""))
			{
				this.excursionArray[excursionCount] = excursion;
				excursionCount++;
				
				if (price >= 0)
				{
					totalExcursionCost += price;
				}
				
			}
			
			
			
			
		}
	}
	
	/**
	 * Retrieves an array containing all of the excursions which have 
	 * been added to this Cruise, in the order in which they were added.
	 * @return The list of excursions.
	 */
	public java.lang.String[] getExcursions()
	{
		
		String[] copyArray = new String[excursionCount];
		for (int i = 0; i < excursionCount; i++)
		{
			copyArray[i] = excursionArray[i];
		}
		return copyArray;
	}
	
	/**
	 * Updates the cabin configuration for this Cruise. 
	 * This method can be used to upgrade a cruise from the base price 
	 * corresponding to the cheapest cabin (an interior cabin without any ocean view).
	 * @param cabin A valid alternate cabin level for this package.
	 */
	public void setCabinType(CabinType cabin)
	{
		
		this.newCabin = cabin;
		if (this.newCabin.equals(CabinType.OCEAN_VIEW))
		{
			this.cabinPrice *= oceanPrice;
		}
		if (this.newCabin.equals(CabinType.BALCONY))
		{
			this.cabinPrice *= 3.0;
		}
		if (this.newCabin.equals(CabinType.SUITE))
		{
			this.cabinPrice *= 5.0;
		}
	}
	
	/**
	 * Retrieves the cabin level currently associated with this Cruise package.
	 * @return The current cabin level.
	 */
	public CabinType getCabinType()
	{
		return newCabin;
	}
	
	/**
	 * Retrieves the home port of the cruise ship for this package.
	 * @return The city from which this Cruise departs.
	 */
	public java.lang.String getHomePort()
	{
		return cityName;
	}
	
	/**
	 * Retrieves the date and time of departure for this Cruise.
	 * @return The departure time at the port.
	 */
	public java.util.Calendar getDepartureDate()
	{
		return leave;
	}
	
	/**
	 * Retrieves the date and time of arrival for this Cruise.
	 * @return The arrival time at the port.
	 */
	public java.util.Calendar getReturnDate()
	{
		return comeBack;
	}
	
	/**
	 * Retrieves the name of ship sailing for this Cruise.
	 * @return The ship name.
	 */
	public java.lang.String getVesselName()
	{
		return shipName;
	}
	
	/**
	 * Retrieves the total cost for all added excursions on this Cruise.
	 * @return The excursions total in US Dollars.
	 */
	public double getExcursionCosts()
	{
		return totalExcursionCost;
	}
	
	/**
	 * Retrieves the number of excursions which have been added to this Cruise package.
	 * @return The number of excursions.
	 */
	public int getNumExcursions()
	{
		return excursionCount;
	}
	
	/**
	 * Retrieves the full price of this Cruise package, 
	 * including pre-cruise flight arrangements (as applicable), 
	 * full lodging costs, and any additional excursion costs.
	 * @return The price of a vacation package in US Dollars.
	 */
	public double getPrice()
	{
		double fullPrice = super.getFlightCosts() + this.getLodgingCost() + this.getExcursionCosts();
		return fullPrice;
	}
	
	/**
	 * Retrieves the deposit amount required up front for this Cruise.
	 * Cruise packages require that all applicable flight costs and 50%
	 * of expected lodging costs are paid at the time of booking.
	 * Optional excursion costs are not included in the deposit amount,
	 * but must be paid prior to departure.
	 * @return The deposit amount required in US Dollars.
	 */
	public double getDepositAmount()
	{
		double depositCost = this.getFlightCosts() + (this.getLodgingCost() * half);
		return depositCost;
	}
	
	/**
	 * Retrieves the lodging charge for this Cruise package. 
	 * Calculated from the base price scaled based on the cabin 
	 * level according to the following fee schedule: 
	 * Interior Room:     100% of base price
	 * Ocean View Room:   150% of base price
	 * Balcony Room:      300% of base price
	 * Luxury Suite:      500% of base price
	 * @return The lodging subtotal in US Dollars.
	 */
	public double getLodgingCost()
	{
		return this.cabinPrice;
	}
	/**
	 * Retrieves a formatted string summarizing this Cruise package. 
	 * The required format for this string includes information as 
	 * described by FlightOptionalPackage followed by cruise details on the next line. 
	 * The second line should be prefixed with 11 blankspaces for alignment below the trip name
	 * If optional excursions have been added, a parenthetical suffix will 
	 * be added indicating how many excursions are included
	 * @Override toString in class FlightOptionalPackage
	 * @return The formatted string summary.
	 */
	@Override
	public java.lang.String toString() 
	{
		String fullString = "";
		if (this.excursionCount > 0)
		{
			fullString = String.format(super.toString()
					+ "\n           "
					+ "Cruising from " + this.cityName
					+ " on the "
					+ this.shipName
					+ " (includes " + this.excursionCount
					+ " excursions)");
		}
		else
		{
			fullString = String.format(super.toString()
					+ "\n           "
					+ "Cruising from " + this.cityName
					+ " on the "
					+ this.shipName);
		}
		return fullString;
	}
	
}
