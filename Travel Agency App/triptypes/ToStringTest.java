package triptypes;
import java.util.Arrays;
import java.util.Calendar;

import travelgui.VacationPackageCollection;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;

public class ToStringTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Calendar cal = Calendar.getInstance();
		cal.set(Calendar.MONTH, Calendar.MAY);
		cal.set(Calendar.YEAR, 1988);
		
		Calendar two = Calendar.getInstance();
		two.set(2005, 12, 15);
		
		Flight one = new Flight("DL", 123, "OMA", "ATL", cal, two, 1245.32);
		
		System.out.println(one);*/
		
		
		/*
		String[] yes = {"first", "second"};
		
		
		
		RoadTrip one = new RoadTrip("Train", 14, yes, 2.15, 400, 6, 4);
		System.out.println(one);
		*/
		
		/*SimpleDateFormat pretty = new SimpleDateFormat("HH:mm MM-dd-YYYY");
		
		Calendar cal = Calendar.getInstance();
		cal.set(2005, 11, 3, 20, 50);
		
		Calendar two = Calendar.getInstance();
		two.set(2005, 11, 15, 22, 45);
		Cruise one = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		one.setCabinType(CabinType.SUITE);
		
		one.addExcursion("Pizza", 15.40);
		one.addExcursion("A", 4.60);
		one.addExcursion("B", 1.25);
		one.addExcursion("C", 3.35);
		
		System.out.println(one);*/
		
		/*
		Calendar cal = Calendar.getInstance();
		cal.set(2005, 11, 3, 20, 50);
		
		Calendar two = Calendar.getInstance();
		two.set(2005, 11, 15, 22, 45);
		
		Flight five = new Flight("LR", 321, "LA", "OMA", cal, two, 355.50);
		
		String[] testOne = {"swimming, racing"};
		AllInclusiveResort one = new AllInclusiveResort("Mountain Trip", 16, "Oakridge", 6, 75.50, testOne);
		one.addFlightLeg(null);
		
		
		System.out.println(one.getFlightItinerary()[0]);
		*/
		/*String[] testArr = {"Kansas", "Nebraska", "Wyoming"};
		RoadTrip one = new RoadTrip("Forest", 8, testArr, 2.15, 350, 8, 4);
		
		one.getEstimatedFuelCost();*/
		
		/*Calendar cal = Calendar.getInstance();
		cal.set(2005, 11, 3, 20, 50);
		
		Calendar two = Calendar.getInstance();
		two.set(2005, 11, 15, 22, 45);
		
		Flight one = new Flight("LR", 321, "LA", "OMA", cal, two, 355.50);
		
		System.out.println(one);*/
		
		//String[] testArr = {""};
		//RoadTrip one = new RoadTrip("Forest", 8, testArr, 2.15, 350, 8, 4);
		
		
		
		/*VacationPackageCollection one = new VacationPackageCollection();
		SimpleDateFormat pretty = new SimpleDateFormat("HH:mm MM-dd-YYYY");
		
		
		Calendar cal = Calendar.getInstance();
		cal.set(2005, 11, 3, 20, 50);
		
		Calendar two = Calendar.getInstance();
		two.set(2005, 11, 15, 22, 45);
		Cruise three = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		
		one.addVacation(three);
		System.out.println(one.getAllVacations()[0]);*/
		
		
		
		
		
		
		/*
		
		
		VacationPackageCollection one = new VacationPackageCollection();
		SimpleDateFormat pretty = new SimpleDateFormat("HH:mm MM-dd-YYYY");
		
		
		Calendar cal = Calendar.getInstance();
		cal.set(2005, 11, 3, 20, 50);
		
		Calendar two = Calendar.getInstance();
		two.set(2005, 11, 15, 22, 45);
		Cruise a = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		Cruise b = new Cruise("Lake Trip", 4, "Red", "Vegas", cal, two, 185.00);
		Cruise c = new Cruise("Mountain Trip", 8, "Red", "Dallas", cal, two, 75.75);
		
		String[] testArr = {"Kansas", "Nebraska", "Wyoming"};
		RoadTrip d = new RoadTrip("Forest", 8, testArr, 2.15, 350, 8, 4);
		RoadTrip e = new RoadTrip("Pond", 9, testArr, 2.15, 300, 9, 5);
		RoadTrip f = new RoadTrip("Ice Fields", 12, testArr, 2.15, 275, 5, 2);
		
		String[] testOne = {"swimming", "racing"};
		AllInclusiveResort g = new AllInclusiveResort("Ski Trip", 16, "Oakridge", 6, 75.50, testOne);
		AllInclusiveResort h = new AllInclusiveResort("Rocky Mountains", 6, "Grand Casino", 9, 130, testOne);
		AllInclusiveResort i = new AllInclusiveResort("Vegas", 5, "Lightning", 3, 95.25, testOne);
		
		one.addVacation(a);
		one.addVacation(b);
		one.addVacation(c);
		one.addVacation(d);
		one.addVacation(e);
		one.addVacation(f);
		one.addVacation(g);
		one.addVacation(h);
		one.addVacation(i);
		
		Flight fi = new Flight("LR", 321, "LA", "OMA", cal, two, 355.50);
		Flight fo = new Flight("LV", 971, "ATL", "LA", cal, two, 490.50);
		
		a.addFlightLeg(fi);
		a.addFlightLeg(fo);
		
		//System.out.println(one.filterVacationsFor(3).getAllVacations()[2].toString());
		
		one.sortCollection(true);
		
		System.out.println(one.getItemAt(8).toString());
		
		*/
	
		
		SimpleDateFormat pretty = new SimpleDateFormat("HH:mm MM-dd-YYYY");
		
		Calendar cal = Calendar.getInstance();
		cal.set(2005, 11, 3, 20, 50);
		
		Calendar two = Calendar.getInstance();
		two.set(2005, 11, 15, 22, 45);
		Cruise one = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		one.setCabinType(CabinType.SUITE);
	
		String nine = "";
		
		
		for (CabinType c : CabinType.values())
		{
			nine = c.toString();
			
		    //System.out.println(c);
		}
		
		
		System.out.println(nine);
		
		System.out.println(one.getCabinType().valueOf("BALCONY"));
		
	}

}
