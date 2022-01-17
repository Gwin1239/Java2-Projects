package tests;
import triptypes.AllInclusiveResort;
import triptypes.Flight;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Calendar;

import org.junit.Test;

public class AllInclusiveResortTest {
	
	private static final double DOUBLE_TOLERANCE = 0.001;
	
	
	@Test
	public void testConstructor() 
	{
		String[] testOne = {"swimming", "racing"};
		AllInclusiveResort one = new AllInclusiveResort("Mountain Trip", 16, "Oakridge", 6, 75.50, testOne);
		
		assertEquals("Mountain Trip", one.getName());
		assertEquals(16, one.getNumDays());
		assertEquals("Oakridge", one.getResortName());
		assertEquals(6, one.getGuestsPerRoom());
		assertEquals(75.50, one.getPricePerNight(), DOUBLE_TOLERANCE);
		assertEquals("swimming, racing", one.getAmenities());
		
	}
	
	@Test
	public void testConstructorNameNull() 
	{
		String[] testOne = {"swimming", "racing"};
		String a = null;
		AllInclusiveResort one = new AllInclusiveResort(a, 16, "Oakridge", 6, 75.50, testOne);
		
		assertEquals("PACKAGE NAME TBD", one.getName());
		
	}
	
	
	@Test
	public void testConstructorNameEmpty() 
	{
		String[] testOne = {"swimming", "racing"};
		String a = "";
		AllInclusiveResort one = new AllInclusiveResort(a, 16, "Oakridge", 6, 75.50, testOne);
		
		assertEquals("PACKAGE NAME TBD", one.getName());
		
	}
	
	@Test
	public void testSetNameEmpty() 
	{
		String[] testOne = {"swimming", "racing"};
		AllInclusiveResort one = new AllInclusiveResort("Mountain Trip", 16, "Oakridge", 6, 75.50, testOne);
		one.setName("");
		
		assertEquals("PACKAGE NAME TBD", one.getName());
		
	}
	
	@Test
	public void testSetNameNull() 
	{
		String[] testOne = {"swimming", "racing"};
		AllInclusiveResort one = new AllInclusiveResort("Mountain Trip", 16, "Oakridge", 6, 75.50, testOne);
		one.setName(null);
		
		assertEquals("PACKAGE NAME TBD", one.getName());
		
	}
	
	@Test
	public void testSetName() 
	{
		String[] testOne = {"swimming", "racing"};
		AllInclusiveResort one = new AllInclusiveResort("Mountain Trip", 16, "Oakridge", 6, 75.50, testOne);
		one.setName("Beaches");
		
		assertEquals("Beaches", one.getName());
		
	}
	
	
	@Test
	public void testConstructorDaysUnder() 
	{
		String[] testOne = {"swimming", "racing"};
		AllInclusiveResort one = new AllInclusiveResort("Mountain Trip", -16, "Oakridge", 6, 75.50, testOne);
		
		assertEquals(1, one.getNumDays());
		
	}

	
	@Test
	public void testSetLength() 
	{
		String[] testOne = {"swimming", "racing"};
		AllInclusiveResort one = new AllInclusiveResort("Mountain Trip", 16, "Oakridge", 6, 75.50, testOne);
		
		one.setLength(8);
		
		assertEquals(8, one.getNumDays());
		
	}
	
	
	@Test
	public void testSetLengthWrong() 
	{
		String[] testOne = {"swimming", "racing"};
		AllInclusiveResort one = new AllInclusiveResort("Mountain Trip", 16, "Oakridge", 6, 75.50, testOne);
		
		one.setLength(-8);
		
		assertEquals(1, one.getNumDays());
		
	}
	
	
	@Test
	public void testGetAmountDue() 
	{
		String[] testOne = {"swimming", "racing"};
		AllInclusiveResort one = new AllInclusiveResort("Mountain Trip", 16, "Oakridge", 6, 75.50, testOne);
		
		
		assertEquals(566.25, one.getAmountDue(), DOUBLE_TOLERANCE);
		

	}
	
	@Test
	public void testGetAmenitiesFail() 
	{
		String[] testOne = {""};
		AllInclusiveResort one = new AllInclusiveResort("Mountain Trip", 16, "Oakridge", 6, 75.50, testOne);
		
		assertEquals("", one.getAmenities());
		
	}
	
	
	
	
	
	@Test
	public void testGetPrice() 
	{
		String[] testOne = {"swimming, racing"};
		AllInclusiveResort one = new AllInclusiveResort("Mountain Trip", 16, "Oakridge", 6, 75.50, testOne);
		
		assertEquals(1132.5, one.getPrice(), DOUBLE_TOLERANCE);
		
	}
	
	@Test
	public void testGetLodgingCost() 
	{
		String[] testOne = {"swimming, racing"};
		AllInclusiveResort one = new AllInclusiveResort("Mountain Trip", 16, "Oakridge", 6, 75.50, testOne);
		
		assertEquals(1132.5, one.getLodgingCost(), DOUBLE_TOLERANCE);
		
	}
	
	@Test
	public void testGetDepositAmount() 
	{
		String[] testOne = {"swimming, racing"};
		AllInclusiveResort one = new AllInclusiveResort("Mountain Trip", 16, "Oakridge", 6, 75.50, testOne);
		
		assertEquals(566.25, one.getDepositAmount(), DOUBLE_TOLERANCE);
		
	}
	
	@Test
	public void testToStringNoFlight() 
	{
		String[] testOne = {"swimming, racing"};
		AllInclusiveResort one = new AllInclusiveResort("Mountain Trip", 16, "Oakridge", 6, 75.50, testOne);
		
		assertEquals("$ 1132.50  Mountain Trip (Flight Not Included)\n" + 
				"           An all-inclusive stay at Oakridge for 6 people!",
				one.toString());
		
	
	}
	
	/*do later 
	@Test
	public void testVacationPackageToString() 
	{
		String[] testOne = {"swimming, racing"};
		AllInclusiveResort one = new AllInclusiveResort("Mountain Trip", 16, "Oakridge", 6, 75.50, testOne);
		
		assertEquals("$1132.50 Mountain Trip (Flight Not Included)\n" + 
				"           An all-inclusive stay at Mountain Trip for 6 people!",
				one.toString());
		
		
	
	}*/
	
	@Test
	public void testEquals() 
	{
		String[] testOne = {"swimming, racing"};
		AllInclusiveResort one = new AllInclusiveResort("Mountain Trip", 16, "Oakridge", 6, 75.50, testOne);
		
		String[] testTwo = {"swimming, racing"};
		AllInclusiveResort two = new AllInclusiveResort("Mountain Trip", 16, "Oakridge", 6, 75.50, testTwo);
		
		assertEquals(true, one.equals(two));
		
	
	}
	
	
	@Test
	public void testEqualsNull() 
	{
		String[] testOne = {"swimming, racing"};
		AllInclusiveResort one = new AllInclusiveResort("Mountain Trip", 16, "Oakridge", 6, 75.50, testOne);
		
		String[] testTwo = {"swimming, racing"};
		AllInclusiveResort two = null;
		
		assertEquals(false, one.equals(two));
		
	
	}
	
	@Test
	public void testNotEquals() 
	{
		String[] testOne = {"swimming, racing"};
		AllInclusiveResort one = new AllInclusiveResort("Mountain Trip", 16, "Oakridge", 6, 75.50, testOne);
		
		String[] testTwo = {"swimming"};
		AllInclusiveResort two = new AllInclusiveResort("Beach Trip", 16, "Oakridge", 6, 75.50, testTwo);
		
		assertEquals(false, one.equals(two));
		
	
	}
	
	
	@Test
	public void testToStringYesFlight() 
	{
		Calendar cal = Calendar.getInstance();
		cal.set(2005, 11, 3, 20, 50);
		
		Calendar two = Calendar.getInstance();
		two.set(2005, 11, 15, 22, 45);
		
		Flight five = new Flight("LR", 321, "LA", "OMA", cal, two, 355.50);
		
		
		String[] testOne = {"swimming, racing"};
		AllInclusiveResort one = new AllInclusiveResort("Mountain Trip", 16, "Oakridge", 6, 75.50, testOne);
		
		one.addFlightLeg(five);
		
		assertEquals("$ 1488.00  Mountain Trip (Flight Included)\n" + 
				"           An all-inclusive stay at Oakridge for 6 people!",
				one.toString());
		
	
	}
	
	
	@Test
	public void testGetFlightItinerary()
	{
		Calendar cal = Calendar.getInstance();
		cal.set(2005, 11, 3, 20, 50);
		
		Calendar two = Calendar.getInstance();
		two.set(2005, 11, 15, 22, 45);
		
		Flight five = new Flight("LR", 321, "LA", "OMA", cal, two, 355.50);
		
		
		String[] testOne = {"swimming, racing"};
		AllInclusiveResort one = new AllInclusiveResort("Mountain Trip", 16, "Oakridge", 6, 75.50, testOne);
		
		one.addFlightLeg(five);
		
		assertEquals("LR 321 Departs: LA at 20:50 12-03-2005; Arrives OMA at 22:45 12-15-2005" ,
				one.getFlightItinerary()[0].toString());
	}
	
	
	@Test
	public void testAddFlightLegNull()
	{
		
		Calendar cal = Calendar.getInstance();
		cal.set(2005, 11, 3, 20, 50);
		
		Calendar two = Calendar.getInstance();
		two.set(2005, 11, 15, 22, 45);
		
		Flight five = new Flight("LR", 321, "LA", "OMA", cal, two, 355.50);
		
		String[] testOne = {"swimming, racing"};
		AllInclusiveResort one = new AllInclusiveResort("Mountain Trip", 16, "Oakridge", 6, 75.50, testOne);
		
		one.addFlightLeg(five);
		one.addFlightLeg(null);
		
		
		assertEquals(1, one.getFlightCount());
		
		
	}
	
	
	@Test
	public void testAddFlightLegOver()
	{
		
		Calendar cal = Calendar.getInstance();
		cal.set(2005, 11, 3, 20, 50);
		
		Calendar two = Calendar.getInstance();
		two.set(2005, 11, 15, 22, 45);
		
		Flight a = new Flight("LR", 321, "LA", "OMA", cal, two, 355.50);
		Flight b = new Flight("LR", 321, "LA", "OMA", cal, two, 355.50);
		Flight c = new Flight("LR", 321, "LA", "OMA", cal, two, 355.50);
		Flight d = new Flight("LR", 321, "LA", "OMA", cal, two, 355.50);
		Flight e = new Flight("LR", 321, "LA", "OMA", cal, two, 355.50);
		Flight f = new Flight("LR", 321, "LA", "OMA", cal, two, 355.50);
		Flight g = new Flight("LR", 321, "LA", "OMA", cal, two, 355.50);
		Flight h = new Flight("LR", 321, "LA", "OMA", cal, two, 355.50);
		Flight i = new Flight("LR", 321, "LA", "OMA", cal, two, 355.50);
		Flight j = new Flight("LR", 321, "LA", "OMA", cal, two, 355.50);
		Flight k = new Flight("LR", 321, "LA", "OMA", cal, two, 355.50);
		Flight l = new Flight("LR", 321, "LA", "OMA", cal, two, 355.50);
		Flight m = new Flight("LR", 321, "LA", "OMA", cal, two, 355.50);
		Flight n = new Flight("LR", 321, "LA", "OMA", cal, two, 355.50);
		
		String[] testOne = {"swimming, racing"};
		AllInclusiveResort one = new AllInclusiveResort("Mountain Trip", 16, "Oakridge", 6, 75.50, testOne);
		
		one.addFlightLeg(a);
		one.addFlightLeg(b);
		one.addFlightLeg(c);
		one.addFlightLeg(d);
		one.addFlightLeg(e);
		one.addFlightLeg(f);
		one.addFlightLeg(g);
		one.addFlightLeg(h);
		one.addFlightLeg(i);
		one.addFlightLeg(j);
		one.addFlightLeg(k);
		one.addFlightLeg(l);
		one.addFlightLeg(m);
		one.addFlightLeg(n);
		
		
		assertEquals(12, one.getFlightCount());
		
		
	}
	
	
	
	
	@Test
	public void testGetFlightCostsNull()
	{
		
		Calendar cal = Calendar.getInstance();
		cal.set(2005, 11, 3, 20, 50);
		
		Calendar two = Calendar.getInstance();
		two.set(2005, 11, 15, 22, 45);
		
		Flight five = new Flight("LR", 321, "LA", "OMA", cal, two, 355.50);
		
		String[] testOne = {"swimming, racing"};
		AllInclusiveResort one = new AllInclusiveResort("Mountain Trip", 16, "Oakridge", 6, 75.50, testOne);
		
		one.addFlightLeg(five);
		one.addFlightLeg(null);
		
		
		assertEquals(355.50, one.getFlightCosts(), DOUBLE_TOLERANCE);
		
	}

	
	@Test
	public void testGetFlightIteneraryNull()
	{
		
		Calendar cal = Calendar.getInstance();
		cal.set(2005, 11, 3, 20, 50);
		
		Calendar two = Calendar.getInstance();
		two.set(2005, 11, 15, 22, 45);
		
		Flight five = new Flight("LR", 321, "LA", "OMA", cal, two, 355.50);
		
		String[] testOne = {"swimming, racing"};
		AllInclusiveResort one = new AllInclusiveResort("Mountain Trip", 16, "Oakridge", 6, 75.50, testOne);
		
		one.addFlightLeg(five);
		one.addFlightLeg(null);
		
		
		assertEquals(null, one.getFlightItinerary()[1]);
		
	}
	
}
