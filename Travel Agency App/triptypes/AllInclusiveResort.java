// COURSE: CSCI1620
// TERM: Fall 2020
// 
// NAME: Godwin Djossou
// RESOURCES: CSLC, Edward
package triptypes;

/**
 * This class encapsulates details related to an all-inclusive resort vacation package. 
 * Flight information to/from the resort location can be added an additional price. 
 * Once at the resort, all-inclusive packages are billed using a flat fee, 
 * regardless of the number of included amenities.
 * @author gdjossou
 *
 */
public class AllInclusiveResort extends FlightOptionalPackage
{

	/**
	 * String that contains the Resort Name.
	 */
	private String resortName;
	/**
	 * Integer that contains the number of Guests per room.
	 */
	private int resortGuests;
	/**
	 * Double that contains the Resort price per night.
	 */
	private double resortPricePerNight;
	/**
	 * String array that contains the Amenities list.
	 */
	private String[] funList;
	/**
	 * Double for the deposit Amount halving.
	 */
	private final double half = 0.50;
	
	/**
	 * Creates a new AllInclusiveResort package.
	 * @param name The promotional name for this package.
	 * @param numDays The number of days included in this vacation package.
	 * @param resort The name of the resort.
	 * @param guestsPerRoom The number of guests allowed per room at the included price.
	 * @param pricePerNight The price of the stay per night.
	 * @param amenitiesList A list of amenities available for free at the resort.
	 */
	public AllInclusiveResort(java.lang.String name,
			int numDays,
			java.lang.String resort,
			int guestsPerRoom,
			double pricePerNight,
			java.lang.String[] amenitiesList)
	{
		super(name, numDays);
		this.resortName = resort;
		this.resortGuests = guestsPerRoom;
		this.resortPricePerNight = pricePerNight;
		this.funList = amenitiesList;
		
	}
	
	/**
	 * Retrieves a single String containing all of the available amenities at the resort. 
	 * Individual amenities should be separated by a single comma and space character, 
	 * with no such separator at the end of the string.
	 * @return The amenities list.
	 */
	public java.lang.String getAmenities()
	{
		int i = 1;
		String allStops = String.format(funList[0]);
		if (funList.length > 1)
		{
			do 
			{
				allStops += String.format(", " + funList[i]);
				i++;
			} while (i < funList.length);
		
		}
		
		return allStops;
		
	}
	
	/**
	 * Retrieves the price per night of the resort.
	 * @return Price per night of the resort.
	 */
	public double getPricePerNight() 
	{
		return this.resortPricePerNight;
	}
	
	/**
	 * Retrieves the number of guests allowed per room at the specified rate.
	 * @return The number of guests per room.
	 */
	public int getGuestsPerRoom()
	{
		return resortGuests;
	}
	
	/**
	 * Retrieves the Resort Name.
	 * @return The Resort Name.
	 */
	public String getResortName()
	{
		return resortName;
	}
	
	/**
	 * The full price for this all-inclusive package, including any optional flight pricing.
	 * @return The price of a vacation package in US Dollars.
	 */
	public double getPrice()
	{
		double totalResortPrice = (super.getNumDays() - 1)
				* this.resortPricePerNight + super.getFlightCosts();
		return totalResortPrice;
		
	}
	
	/**
	 * The required deposit amount to be made at the time of booking. 
	 * All up front flight-related costs and 50% of the total lodging costs 
	 * for this trip must be paid as a deposit.
	 * @return The deposit amount required in US Dollars.
	 */
	public double getDepositAmount()
	{
		double fullDeposit = this.getFlightCosts() + (half * this.getLodgingCost());
		return fullDeposit;
	}
	
	/**
	 * A formatted summary string with details about this all-inclusive resort package. 
	 * The string will contain information as described by FlightOptionalPackage 
	 * followed by details about the resort and the number of people included at the specified price. 
	 * The second line should be prefixed with 11 blank spaces for alignment below the trip name.
	 * @Override toString in class FlightOptionalPackage
	 * @return The formatted string summary.
	 */
	@Override
	public java.lang.String toString()
	{
		return String.format(super.toString()
				+ "\n           "
				+ "An all-inclusive stay at " + this.getResortName() 
				+ " for " + this.getGuestsPerRoom() + " people!");
	}
	
	/**
	 * Retrieves the subtotal for lodging associated with this 
	 * all inclusive resort stay based on the number of nights 
	 * in the package and the base price.
	 * @return The lodging subtotal in US Dollars.
	 */
	public double getLodgingCost()
	{
		double lodging = (this.getNumDays() - 1) * this.resortPricePerNight;
		return lodging;
	}
	
	
}
