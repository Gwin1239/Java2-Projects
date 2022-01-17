// COURSE: CSCI1620
// TERM: Fall 2020
// 
// NAME: Godwin Djossou
// RESOURCES: CSLC, Edward
package triptypes;

/**
 * This class serves as the base class of all types of vacation packages within the travel agency program.
 * @author gdjossou
 *
 */
public abstract class VacationPackage 
{

	/**
	 * String that holds the Package Name.
	 */
	private String packageName;
	/**
	 * Integer that holds the amount of Days for the Package.
	 */
	private int packageDays = 1;
	
	
	/**
	 * Initializes a VacationPackage with provided values.
	 * @param name The promotional marketing name for this package.
	 * @param numDays The number of days included in this VacationPackage trip.
	 */
	public VacationPackage(java.lang.String name,
			int numDays)
	{
		if (name == null || name.equals(""))
		{
			this.packageName = "PACKAGE NAME TBD";
		}
		else
		{
			this.packageName = name;
		}
		
		if (numDays >= 1)
		{
			this.packageDays = numDays;
		}
	}
	
	/**
	 * Updates the VacationPackage's externally facing promotional name. 
	 * Due to travel agency policy, 
	 * this name is never allowed to be empty as it would be 
	 * confusing for agents and customers interacting with the system. 
	 * Names that do not comply with this policy will be ignored and 
	 * the package will be given the name "PACKAGE NAME TBD" 
	 * as a placeholder.
	 * @param name The updated name to use for this package.
	 */
	public void setName(java.lang.String name)
	{
		if (name == null || name.equals(""))
		{
			this.packageName = "PACKAGE NAME TBD";
		}
		else
		{
			this.packageName = name;
		}
	}
	
	/**
	 * Updates the length of this VacationPackage. 
	 * All packages must have a minimum of one day.
	 * @param numDays The new number of days for this package.
	 */
	public void setLength(int numDays)
	{
		if (numDays >= 1)
		{
			this.packageDays = numDays;
		}
		else
		{
			this.packageDays = 1;
		}
	}
	
	/**
	 * Retrieves the promotional name of this package.
	 * @return The name.
	 */
	public java.lang.String getName()
	{
		return packageName;
	}
	
	/**
	 * Retrieves the number of days included in this package.
	 * @return The number of days for this trip.
	 */
	public int getNumDays()
	{
		return packageDays;
	}
	
	/**
	 * This method provides the full price of a vacation package, 
	 * which is must be computed based on the specific 
	 * kind of trip being booked.
	 * @return The price of a vacation package in US Dollars.
	 */
	public abstract double getPrice();
	
	
	/**
	 * This method provides the required up front deposit amount for a given vacation. 
	 * This must be computed based on rules determined by specific package types, 
	 * per travel agency policies.
	 * @return The deposit amount required in US Dollars.
	 */
	public abstract double getDepositAmount();
	
	
	/**
	 * This method provides the remaining amount due to the 
	 * travel agent for this trip less any deposit made up front.
	 * @return The remaining balance to pay the travel agency.
	 */
	public double getAmountDue()
	{
		double amountDue = this.getPrice() - this.getDepositAmount();
		return amountDue;
	}
	
	/**
	 * This method provides the sub total for a trip related to lodging expenses 
	 * (ie, not including flights, meals, and incidentals).
	 * Lodging rates are determined by specific package types.
	 * @return The lodging subtotal in US Dollars.
	 */
	public abstract double getLodgingCost();
	
	
	
	/**
	 * This method produces a String summary of a VacationPackage. 
	 * Strings will be prefixed with the $ symbol, 
	 * followed by trip total price rounded to two decimal places 
	 * in a 8 character wide field. Price details should be followed 
	 * by two spaces and the promotional name of this trip
	 * @Override toString in class java.lang.Object
	 * @return The formatted string summary.
	 */
	@Override
	public java.lang.String toString()
	{
		return String.format("$%8.2f  " + this.packageName, this.getPrice());
	}
	
	
	
	/**
	 * Provides a logical equality comparison for VacationPackages and any other object type.
	 * @Override equals in class java.lang.Object
	 * @param other A reference to another object to be compared with this one.
	 * @return true if and only if this VacationPackage shares the same 
	 * promotional name as one referred to by other. false when other is not 
	 * a valid VacationPackage object or the names do not match
	 */
	public boolean equals(java.lang.Object other)
	{
		boolean vacationEquals = false;
		if (other instanceof VacationPackage)
		{
			VacationPackage one = (VacationPackage) other;
			if (one.getName().equals(this.getName()))
			{
				vacationEquals = true;
			}
		}
		return vacationEquals;
	}
	
	
}


