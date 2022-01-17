package tests;

import travelgui.VacationPackageCollection;
import triptypes.AllInclusiveResort;
import triptypes.Cruise;
import triptypes.Flight;
import triptypes.RoadTrip;
import triptypes.VacationPackage;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.junit.Test;

public class VacationPackageCollectionTest 
{

	@Test
	public void testConstructor() 
	{
		
		VacationPackageCollection one = new VacationPackageCollection();
		assertEquals(0, one.getNumTrips());
	}

	
	@Test
	public void testAddVacations()
	{
		VacationPackageCollection one = new VacationPackageCollection();
		SimpleDateFormat pretty = new SimpleDateFormat("HH:mm MM-dd-YYYY");
		
		
		Calendar cal = Calendar.getInstance();
		cal.set(2005, 11, 3, 20, 50);
		
		Calendar two = Calendar.getInstance();
		two.set(2005, 11, 15, 22, 45);
		Cruise three = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		
		one.addVacation(three);
		assertEquals("$  145.50  Beach Trip (Flight Not Included)\n" + 
				"           Cruising from Miami on the Red", one.getAllVacations()[0].toString());
	}
	
	@Test
	public void testAddVacationsNull()
	{
		VacationPackageCollection one = new VacationPackageCollection();
		SimpleDateFormat pretty = new SimpleDateFormat("HH:mm MM-dd-YYYY");
		
		
		Calendar cal = Calendar.getInstance();
		cal.set(2005, 11, 3, 20, 50);
		
		Calendar two = Calendar.getInstance();
		two.set(2005, 11, 15, 22, 45);
		Cruise three = null;
		
		one.addVacation(three);
		assertEquals(0, one.getNumTrips());
	}
	
	@Test
	public void testAddVacationsFull()
	{
		VacationPackageCollection one = new VacationPackageCollection();
		SimpleDateFormat pretty = new SimpleDateFormat("HH:mm MM-dd-YYYY");
		
		
		Calendar cal = Calendar.getInstance();
		cal.set(2005, 11, 3, 20, 50);
		
		Calendar two = Calendar.getInstance();
		two.set(2005, 11, 15, 22, 45);
		Cruise a = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		Cruise b = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		Cruise c = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		Cruise d = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		Cruise e = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		Cruise f = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		Cruise g = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		Cruise h = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		Cruise i = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		Cruise j = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		Cruise k = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		Cruise l = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		Cruise m = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		Cruise n = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		Cruise o = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		Cruise p = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		Cruise q = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		Cruise r = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		Cruise s = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		Cruise t = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		Cruise u = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		Cruise v = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		Cruise w = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		Cruise x = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		Cruise y = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		Cruise z = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		Cruise ab = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		Cruise ac = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		Cruise ad = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		Cruise ae = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		
		
		
		
		
		
		
		
		one.addVacation(a);
		one.addVacation(b);
		one.addVacation(c);
		one.addVacation(d);
		one.addVacation(e);
		one.addVacation(f);
		one.addVacation(g);
		one.addVacation(h);
		one.addVacation(i);
		one.addVacation(j);
		one.addVacation(k);
		one.addVacation(l);
		one.addVacation(m);
		one.addVacation(n);
		one.addVacation(o);
		one.addVacation(p);
		one.addVacation(q);
		one.addVacation(r);
		one.addVacation(s);
		one.addVacation(t);
		one.addVacation(u);
		one.addVacation(v);
		one.addVacation(w);
		one.addVacation(x);
		one.addVacation(y);
		one.addVacation(z);
		one.addVacation(ab);
		one.addVacation(ac);
		one.addVacation(ad);
		one.addVacation(ae);
		
		assertEquals(25, one.getNumTrips());
	}
	
	
	@Test
	public void testFilterVacationsForCruise()
	{
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
		
		assertEquals("$  145.50  Beach Trip (Flight Not Included)\n" + 
				"           Cruising from Miami on the Red", one.filterVacationsFor(2).getAllVacations()[0].toString());
		
		assertEquals("$  185.00  Lake Trip (Flight Not Included)\n" + 
				"           Cruising from Vegas on the Red", one.filterVacationsFor(2).getAllVacations()[1].toString());
		assertEquals("$   75.75  Mountain Trip (Flight Not Included)\n" + 
				"           Cruising from Dallas on the Red", one.filterVacationsFor(2).getAllVacations()[2].toString());
		
	}
	
	
	@Test
	public void testFilterVacationsForRoadTrip()
	{
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
		
		assertEquals("$ 4540.60  Forest\n" + 
				"           A road trip with stops at Kansas, Nebraska, Wyoming", one.filterVacationsFor(1).getAllVacations()[0].toString());
		
		assertEquals("$ 8433.00  Pond\n" + 
				"           A road trip with stops at Kansas, Nebraska, Wyoming", one.filterVacationsFor(1).getAllVacations()[1].toString());
		assertEquals("$ 3067.32  Ice Fields\n" + 
				"           A road trip with stops at Kansas, Nebraska, Wyoming", one.filterVacationsFor(1).getAllVacations()[2].toString());
		
	}
	
	
	@Test
	public void testFilterVacationsForAllInclusiveResorts()
	{
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
		
		assertEquals("$ 1132.50  Ski Trip (Flight Not Included)\n" + 
				"           An all-inclusive stay at Oakridge for 6 people!", one.filterVacationsFor(3).getAllVacations()[0].toString());
		
		assertEquals("$  650.00  Rocky Mountains (Flight Not Included)\n" + 
				"           An all-inclusive stay at Grand Casino for 9 people!", one.filterVacationsFor(3).getAllVacations()[1].toString());
		assertEquals("$  381.00  Vegas (Flight Not Included)\n" + 
				"           An all-inclusive stay at Lightning for 3 people!", one.filterVacationsFor(3).getAllVacations()[2].toString());
		
	}
	
	
	
	@Test
	public void testGetFlightDetails()
	{
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
		
		
		assertEquals("LR 321 Departs: LA at 20:50 12-03-2005; Arrives OMA at 22:45 12-15-2005\n" + 
				"LV 971 Departs: ATL at 20:50 12-03-2005; Arrives LA at 22:45 12-15-2005\n",
				one.getFlightDetails(0));
		
		
		
	}
	
	@Test
	public void testGetFlightDetailsOutOfRange()
	{
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
		
		
		assertEquals("ERROR: Index is out of range!",
				one.getFlightDetails(45));
		
		
		
	}
	
	
	
	@Test
	public void testGetFlightDetailsNoInformation()
	{
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
		
		//a.addFlightLeg(fi);
		//a.addFlightLeg(fo);
		
		
		assertEquals("ERROR: The selected trip has no flight information.",
				one.getFlightDetails(0));
		
		
		
	}
	
	
	
	@Test
	public void testGetFlightDetailsRoadTrip()
	{
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
		
		
		assertEquals("ERROR: No flights are allowed for this type of trip!",
				one.getFlightDetails(4));
		
		
		
	}
	
	
	
	@Test
	public void testGetItemAt()
	{
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
		
		
		assertEquals("$   75.75  Mountain Trip (Flight Not Included)\n" + 
				"           Cruising from Dallas on the Red",
				one.getItemAt(2).toString());
		
		
	}
	
	@Test
	public void testGetItemOver()
	{
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
		
		
		assertEquals(null, one.getItemAt(-1));
		
		
	}
	
	
	@Test
	public void testGetItemUnder()
	{
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
		
		
		assertEquals(null, one.getItemAt(20));
		
		
	}
	
	
	@Test
	public void testSortCollectionByPrice()
	{
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
		
		
		one.sortCollection(true);
		
		assertEquals("$   75.75  Mountain Trip (Flight Not Included)\n" + 
				"           Cruising from Dallas on the Red" , one.getItemAt(0).toString());
		assertEquals("$ 8433.00  Pond\n" + 
				"           A road trip with stops at Kansas, Nebraska, Wyoming", one.getItemAt(8).toString());
		
		
		
		
	}
	
	
	@Test
	public void testNoSortByPrice()
	{
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
		
		
		one.sortCollection(false);
		
		assertEquals("$  991.50  Beach Trip (Flight Included)\n" + 
				"           Cruising from Miami on the Red" , one.getItemAt(0).toString());
		assertEquals("$  381.00  Vegas (Flight Not Included)\n" + 
				"           An all-inclusive stay at Lightning for 3 people!", one.getItemAt(8).toString());
		
		
		
		
	}
	
	
	
}
