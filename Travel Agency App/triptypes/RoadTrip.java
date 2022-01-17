// COURSE: CSCI1620
// TERM: Fall 2020
// 
// NAME: Godwin Djossou
// RESOURCES: CSLC, Edward
package triptypes;

/**
 * This class represents a RoadTrip vacation that includes a 
 * rental car, overnight lodging, and fuel cost estimation.
 * @author gdjossou
 *
 */
public class RoadTrip extends VacationPackage
{
	/**
	 * String array that hold the stops for the RoadTrip.
	 */
	private String[] tripStops;
	/**
	 * double value for the cost of the fuel in dollars.
	 */
	private double tripFuelCost;
	/**
	 * integer value for the amount of miles for the trip.
	 */
	private int tripMiles;
	/**
	 * integer value for the max people in a room.
	 */
	private int tripMax;
	/**
	 * integer value for the stars of the hotel.
	 */
	private int tripStars;
	/**
	 * Final double value for the base price of the rooms.
	 */
	private final double basePrice = 35.20;
	/**
	 * final double value for the rental car cost with 1 or 2 passengers.
	 */
	private final double carCostOne = 36.75;
	/**
	 * final double value for the rental car cost with 3 or 4 passengers.
	 */
	private final double carCostTwo = 50.13;
	/**
	 * final double value for the rental car cost with 5 or 6 passengers.
	 */
	private final double carCostThree = 60.25;
	/**
	 * final double value for the rental car cost with 7 or 8 passengers.
	 */
	private final double carCostFour = 70.50;
	/**
	 * final double value for the rental car cost with more than 8 passengers.
	 */
	private final double carCostFive = 150.00;
	/**
	 * final double value for the default fuel cost.
	 */
	private final double defaultFuel = 2.50;
	/**
	 * final double value for the fuel range for 1 to 2 passengers.
	 */
	private final double tiny = 45.00;
	/**
	 * final double value for the fuel range for 3 to 4 passengers.
	 */
	private final double small = 32.00;
	/**
	 * final double value for the fuel range for 5 to 6 passengers.
	 */
	private final double medium = 28.00;
	/**
	 * final double value for the fuel range for 7 to 8 passengers.
	 */
	private final double normal = 22.00;
	/**
	 * final double value for the fuel range over 8 passengers.
	 */
	private final double big = 15.00;
	
	/**
	 * Creates a newly initialized RoadTrip object using the parameter data.
	 * @param name The promotional name to use for this RoadTrip in the travel agency system.
	 * @param numDays The number of days required for this RoadTrip.
	 * @param stops A list of destinations that will be visited along the way on this RoadTrip.
	 * @param fuelCost The estimated cost of fuel in US Dollars per Gallon based on current rates.
	 * @param miles The total number of miles for this RoadTrip, assuming people follow the intended route.
	 * @param maxPersons The number of people for whom this trip package will be budgeted.
	 * @param hotelStars The quality level of the hotels used during the RoadTrip, 
	 * ranging from1..5 stars, inclusive. Star values outside this 
	 * range will be adjusted to the closest valid value.
	 */
	public RoadTrip(java.lang.String name,
			int numDays,
			java.lang.String[] stops,
			double fuelCost,
			int miles,
			int maxPersons,
			int hotelStars)
	{
		super(name, numDays);
		this.tripStops = stops;
		
		if (fuelCost > 0)
		{
			this.tripFuelCost = fuelCost;
		}
		else
		{
			this.tripFuelCost = defaultFuel;
		}
		this.tripMiles = miles;
		this.tripMax = maxPersons;
		if (hotelStars == 1
				|| hotelStars == 2
				|| hotelStars == 3
				|| hotelStars == 4
				|| hotelStars == 5)
		{
			this.tripStars = hotelStars;
		}
		else if (hotelStars > 5)
		{
			this.tripStars = 5;
		}
		else
		{
			this.tripStars = 1;
		}
	}
	
	/**
	 * Retrieves the hotel quality level attached to this RoadTrip package.
	 * @return The number of stars for hotel stays.
	 */
	public int getHotelStars()
	{
		return this.tripStars;
	}
	
	/**
	 * Retrieves the amount of miles for this trip.
	 * @return The number of miles for the trip.
	 */
	public int getMiles()
	{
		return this.tripMiles;
	}
	
	/**
	 * Provides the full price of this RoadTrip object. 
	 * RoadTrip prices are computed based on the 
	 * total rental car, lodging, and fuel estimated costs.
	 * @return The price of a vacation package in US Dollars.
	 */
	public double getPrice()
	{
		double finalPrice = this.getCarCost() 
				+ this.getLodgingCost() 
				+ this.getEstimatedFuelCost();
		
		return finalPrice;
	}
	
	/**
	 * Provides the required deposit amount for this RoadTrip object. 
	 * The required deposit for a Road trip includes the 
	 * full lodging cost plus the full rental car cost.
	 * @return The deposit amount required in US Dollars.
	 */
	public double getDepositAmount()
	{
		double fullAmount = this.getLodgingCost() + this.getCarCost();
		return fullAmount;
	}
	
	/**
	 * All RoadTrips must be fully paid in advance, 
	 * with the exception of fuel costs.Fuel costs are 
	 * paid to the gas station, and not the travel agent. 
	 * Thus, the balance due on RoadTrips is always 0.
	 * @return The remaining balance to pay the travel agency.
	 */
	public double getAmountDue()
	{
		return 0.0;
	}
	
	/**
	 * Provides the total lodging cost for a RoadTrip object. 
	 * Lodging is computed based on the length of the vacation, 
	 * the quality of the hotel (in stars),the number of rooms 
	 * needed for the party and a base charge of $35.20 per room per night. 
	 * Lodging costs assume a maximum 2 person occupancy per room.
	 * @return The lodging subtotal in US Dollars. 
	 */
	public double getLodgingCost()
	{
		int people;
		if (tripMax % 2 == 0)
		{
			people = tripMax / 2;
		}
		else
		{
			people = (tripMax / 2) + 1;
		}
		
			
		double lodgeCost = basePrice * this.tripStars * (this.getNumDays() - 1) * people;
		return lodgeCost;
	}
	
	/**
	 * Provides the total cost for the rental car 
	 * based on the trip duration and the size of car needed. 
	 * Rental cars are billed based on full days, with no partial day 
	 * rentals allowed. Further, the travel agency uses a standard daily 
	 * rental car charge based on the number of occupants riding along: 
	 * $ 36.75   1-2 passengers
	 * $ 50.13   3-4 passengers
	 * $ 60.25   5-6 passengers
	 * $ 70.50   7-8 passengers
	 * $150.00    9+ passengers (since you'll need a bus)
	 * @return The total rental car cost for this trip.
	 */
	public double getCarCost()
	{
		double rentalCar = 0.0;
		if (tripMax < 3)
		{
			rentalCar = carCostOne * this.getNumDays();
		}
		if (tripMax > 2 && tripMax < 5)
		{
			rentalCar = carCostTwo * this.getNumDays();
		}
		if (tripMax > 4 && tripMax < 7)
		{
			rentalCar = carCostThree * this.getNumDays();
		}
		if (tripMax > 6 && tripMax < 9)
		{
			rentalCar = carCostFour * this.getNumDays();
		}
		if (tripMax > 8)
		{
			rentalCar = carCostFive * this.getNumDays();
		}
		
		return rentalCar;
	}
	
	/**
	 * Retrieves the number of stops along the route for this RoadTrip.
	 * @return The number of intermediate destinations.
	 */
	public int getNumStops()
	{
		return tripStops.length;
	}
	
	/**
	 * Updates the number of people to be used for budgeting 
	 * this RoadTrip within the travel agency.
	 * @param maxPeople The new number of people to use in calculations.
	 */
	public void setPersons(int maxPeople)
	{
		this.tripMax = maxPeople;
	}
	
	/**
	 * Retrieves the number of people included for 
	 * budget calculations by thisRoadTrip.
	 * @return The number of persons.
	 */
	public int getNumPersons()
	{
		return this.tripMax;
	}
	
	/**
	 * Updates the cost of fuel in US dollars per gallon. 
	 * This value is used for projecting out costs for this RoadTrip. 
	 * Prices must be positive values,and a default assumption of 
	 * $2.50 per gallon will be used if an invalid price is specified.
	 * @param pricePerGallon The new price to use for cost projections.
	 */
	public void setFuelPrice(double pricePerGallon)
	{
		if (pricePerGallon > 0)
		{
			this.tripFuelCost = pricePerGallon;
		}
		else
		{
			this.tripFuelCost = defaultFuel;
		}
	}
	
	/**
	 * Retrieves the current fuel price used for cost projections.
	 * @return The fuel price in US dollars per gallon.
	 */
	public double getFuelPrice()
	{
		return this.tripFuelCost;
	}
	
	/**
	 * Provides a projection of the total fuel cost for this trip 
	 * based on the total number of miles to be traveled, 
	 * the fuel efficiency of the rental car, and the cost of fuel. 
	 * Standard rental cars used have decreasing fuel efficiency as the size gets bigger. 
	 * Thus, efficiency is a function of passenger count. 
	 * We assume the following projections: 45mpg   1-2 passengers
	 * 32mpg   3-4 passengers
	 * 28mpg   5-6 passengers
	 * 22mpg   7-8 passengers
	 * 15mpg    9+ passengers (buses aren't very efficient)
	 * @return The projected fuel cost in US dollars.
	 */
	public double getEstimatedFuelCost()
	{
		double fuelFinalCost = 0.0;
		if (tripMax < 3)
		{
			fuelFinalCost = (this.getMiles() / tiny) * this.getFuelPrice();
		}
		if (tripMax > 2 && tripMax < 5)
		{
			fuelFinalCost = (this.getMiles() / small) * this.getFuelPrice();
		}
		if (tripMax > 4 && tripMax < 7)
		{
			fuelFinalCost = (this.getMiles() / medium) * this.getFuelPrice();
		}
		if (tripMax > 6 && tripMax < 9)
		{
			fuelFinalCost = (this.getMiles() / normal) * this.getFuelPrice();
		}
		if (tripMax > 8)
		{
			fuelFinalCost = (this.getMiles() / big) * this.getFuelPrice();
		}
		
		return fuelFinalCost;
	}
	
	/**
	 * Retrieves the list of stops on this RoadTip as a single string 
	 * with values separated by a comma and a single space. 
	 * The last stop has no punctuation after it.
	 * @return The list of stops.
	 */
	public java.lang.String getStops()
	{
		
		int i = 1;
		String allStops = String.format(tripStops[0]);
		if (tripStops.length > 1)
		{
			do
			{
				allStops += String.format(", " + tripStops[i]);
				i++;
			} while (i < tripStops.length);
		}
		
	
		return allStops;
	}
	
	/**
	 * Provides a string summary of this RoadTrip. 
	 * Promotional details and trip duration are provided as 
	 * with all VacationPackages, followed by a summary message 
	 * about the stops to be made on the following line with each stop separated by a comma. 
	 * The second line should be prefixed with 11 blank spaces for alignment below the trip name.
	 * @Override toString in class VacationPackage
	 * @return The formatted string summary.
	 */
	@Override
	public java.lang.String toString()
	{
		return super.toString()
				+ "\n           "
				+ "A road trip with stops at "
				+ this.getStops();
	}
	 
	
}
