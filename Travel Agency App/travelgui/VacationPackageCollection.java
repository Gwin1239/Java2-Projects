// COURSE: CSCI1620
// TERM: Fall 2020
// 
// NAME: Godwin Djossou
// RESOURCES: CSLC, Edward
package travelgui;

import triptypes.VacationPackage;
import triptypes.RoadTrip;
import triptypes.Cruise;
import triptypes.FlightOptionalPackage;
import triptypes.AllInclusiveResort;

/**
 * This class serves as a collection to store, filter, and 
 * explore VacationPackages within the trip search user interface. 
 * Up to 25 VacationPackages can be stored in a single collection.
 * @author gdjossou
 *
 */
public class VacationPackageCollection 
{

	/**
	 * Final integer that stores the max packages for a Vacation Package Collection.
	 */
	private final int maxPackages = 25;
	/**
	 * VacationPackage Array that holds the new vacations added.
	 */
	private VacationPackage[] newVacation;
	/**
	 * Integer that hold the amount of vacations added.
	 */
	private int vacationCount = 0;

	
	/**
	 * Creates a new empty VacationPackageCollection.
	 */
	public VacationPackageCollection()
	{
		newVacation = new VacationPackage[maxPackages];
	}
	
	/**
	 * Retrieves the number of trip packages that have been added to this collection for purchase.
	 * @return The total number of available packages.
	 */
	public int getNumTrips()
	{
		return this.vacationCount;
	}
	
	
	/**
	 * Retrieves an array of all available packages from the collection. 
	 * Valid packages are guaranteed to be stored contiguously in the left most array cells. 
	 * Any empty cells will appear to the right of the last valid VacationPackage. 
	 * Unless a sort has occurred, packages will appear in the order in which they were added.
	 * @return The list of available packages, or null if no packages exist.
	 */
	public VacationPackage[] getAllVacations()
	{
		return newVacation;
	}
	
	/**
	 * Adds a single trip package to the collection at the next available position. 
	 * If adding this trip would result in more than 25 total packages, 
	 * it will not be added to the collection.
	 * @param trip trip The trip to add to the collection.
	 */
	public void addVacation(VacationPackage trip)
	{
		if (this.vacationCount < maxPackages)
		{
			if (trip != null)
			{
				this.newVacation[vacationCount] = trip;
				
				this.vacationCount++;
			}
		}
	}
	
	/**
	 * Retrieves a filtered subcollection of trips corresponding to a specific subtype. 
	 * Should no trips of a specified type be present in this VacationPackageCollectionan 
	 * empty collection containing zero packages will be returned.
	 * @param selection An integer signaling what type of packages to extract. 
	 * 1 represents RoadTrips, 2 represents Cruises, and 3 represents All-Inclusive Resort packages.
	 * @return The filtered subcollection of packages, or an empty collection 
	 * if no matching packages exist in this collection.
	 */
	public VacationPackageCollection filterVacationsFor(int selection)
	{
		VacationPackageCollection filteredCollection = new VacationPackageCollection();
		
		if (selection == 1)
		{
			for (int i = 0; i < this.getNumTrips(); i++)
			{
				if (this.getItemAt(i) instanceof RoadTrip)
				{
					filteredCollection.addVacation(this.getItemAt(i));
				}
			}
		}
		
		else if (selection == 2)
		{
			for (int i = 0; i < this.getNumTrips(); i++)
			{
				if (this.getItemAt(i) instanceof Cruise)
				{
					filteredCollection.addVacation(this.getItemAt(i));
				}
			}
		}
		
		
		else if (selection == 3)
		{
			for (int i = 0; i < this.getNumTrips(); i++)
			{
				if (this.getItemAt(i) instanceof AllInclusiveResort)
				{
					filteredCollection.addVacation(this.getItemAt(i));
				}
			}
		}
		
		
		
		return filteredCollection;
		
		
		
		
		
		
		
	}
	
	/**
	 * Produces a summary of flight information inside a VacationPackagefor detail display elsewhere. 
	 * In addition to properly extracting flight details when the given index corresponds to a 
	 * FlightOptionalPackage with one or more flight legs, this method will also detect various error conditions. 
	 * In erroneous situations, one of the following strings will be produced: 
	 * ERROR: Index is out of range!
	 * ERROR: No flights are allowed for this type of trip!
	 * ERROR: The selected trip has no flight information.
	 * Each of these errors corresponds to invalid range input, packages for which flights cannot be added 
	 * in the first place, and packages which potentially could (but do not yet) have flight data.
	 * @param index The index position in the collection from which to extract flightinformation.
	 * @return The formatted flight details, with one Flight per line and eachFlight 
	 * displayed as detailed in Flight.toString.
	 */
	public java.lang.String getFlightDetails(int index)
	{
		String result = "";
		
		/*if (((FlightOptionalPackage) this.newVacation[index]).hasFlights())
		{
			result = ((FlightOptionalPackage) newVacation[index]).getFlightItinerary().toString();
		}
		else if (!((FlightOptionalPackage) this.newVacation[index]).hasFlights())
		{
			result = "ERROR: The selected trip has no flight information.";
		}
		else if (index > this.vacationCount - 1)
		{
			result = "ERROR: Index is out of range!";

		}
		else
		{
			result = "ERROR: No flights are allowed for this type of trip!";

		}*/
		
		
		if (index > this.newVacation.length || index < 0)
		{
			result = "ERROR: Index is out of range!";
		}
		
		else if (this.newVacation[index] instanceof RoadTrip)
		{
			result = "ERROR: No flights are allowed for this type of trip!";
		}
		
		else if (!((FlightOptionalPackage) newVacation[index]).hasFlights() 
				|| ((FlightOptionalPackage) newVacation[index]) == null)
		{
			result = "ERROR: The selected trip has no flight information.";
		}
		
		
		else
		{
			/*int i = 1;
			result += ((FlightOptionalPackage) newVacation[index]).getFlightItinerary()[0];
			if (((FlightOptionalPackage) 
					newVacation[index]).getFlightItinerary().length > 1)
			{
				do 
				{
					result += "\n" + ((FlightOptionalPackage) 
							newVacation[index]).getFlightItinerary()[i];
					i++;
				} while (i < newVacation.length);
			
			}
			
			return result;*/
			
			
			
			
			for (int i = 0; i < ((FlightOptionalPackage) newVacation[index]).getFlightCount(); i++)
			{
				if (i < ((FlightOptionalPackage) newVacation[index]).getFlightCount() - 1)
				{
					result += ((FlightOptionalPackage) 
							newVacation[index]).getFlightItinerary()[i] + "\n";
				}
				else
				{
					result += ((FlightOptionalPackage) 
							newVacation[index]).getFlightItinerary()[i] + "\n";
				}
			}
		}
		
		return result;
	}
	
	
	
	
	/**
	 * Provides 0-based indexed access to the VacationPackageCollection.
	 * @param index The index position whose VacationPackage should be returned.
	 * @return The selected VacationPackage when index is valid. The method will return null otherwise.
	 */
	public VacationPackage getItemAt(int index)
	{
		if (index >= 0 && index < this.vacationCount)
		{
			return newVacation[index];
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * Produces a stable sort of the contents of this VacationPackageCollection, 
	 * with the sort order determined by an externally specified criteria. 
	 * When byPrice is true, the method will sort all available packages in ascending order by 
	 * total package price. When false, the method sorts packages in standard 
	 * lexicographically ascending order by package name(see, https://en.wikipedia.org/wiki/Lexicographical_order).
	 * @param byPrice A flag which sets the sort criteria as described above.
	 */
	public void sortCollection(boolean byPrice)
	{
		VacationPackage sort;
		int first;
		int second;
		
		if (byPrice)
		{
			// outer loop
			for (first = 0; first < this.vacationCount; ++first)
			{
				//inner loop
				for (second = 0; second < this.vacationCount; ++second)
				{
					//logic for price
					if (this.newVacation[first].getPrice() < this.newVacation[second].getPrice())
					{
						sort = this.newVacation[second];
						this.newVacation[second] = this.newVacation[first];
						this.newVacation[first] = sort;
					}
				}
			}
		}
		
		
		else
		{
			for (first = 0; first < this.vacationCount; ++first)
			{
				for (second = 0; second < this.vacationCount; ++second)
				{
					if (this.newVacation[second].getName().
							compareToIgnoreCase(this.newVacation[first].getName()) > 0)
					{
						sort = this.newVacation[first];
						this.newVacation[first] = this.newVacation[second];
						this.newVacation[second] = sort;
					}
				}
			}
		}
		
		
	}
	
}
