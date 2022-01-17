package tests;
import triptypes.CabinType;
import triptypes.Cruise;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

import static org.junit.Assert.*;

import org.junit.Test;


public class CruiseTest {
	
	private static final double DOUBLE_TOLERANCE = 0.001;

	@Test
	public void testConstructor() 
	{
		SimpleDateFormat pretty = new SimpleDateFormat("HH:mm MM-dd-YYYY");
		
		
		Calendar cal = Calendar.getInstance();
		cal.set(2005, 11, 3, 20, 50);
		
		Calendar two = Calendar.getInstance();
		two.set(2005, 11, 15, 22, 45);
		Cruise one = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		
		assertEquals("Beach Trip", one.getName());
		assertEquals(14, one.getNumDays());
		assertEquals("Red", one.getVesselName());
		assertEquals("Miami", one.getHomePort());
		assertEquals("20:50 12-03-2005", pretty.format(cal.getTime()));
		assertEquals("22:45 12-15-2005", pretty.format(two.getTime()));
		assertEquals(145.50, one.getLodgingCost(), DOUBLE_TOLERANCE);
		
	}
	
	@Test
	public void testAddExcursion()
	{
		SimpleDateFormat pretty = new SimpleDateFormat("HH:mm MM-dd-YYYY");
		
		Calendar cal = Calendar.getInstance();
		cal.set(2005, 11, 3, 20, 50);
		
		Calendar two = Calendar.getInstance();
		two.set(2005, 11, 15, 22, 45);
		Cruise one = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		
		one.addExcursion("Pizza", 15.40);
		assertEquals("[Pizza]", Arrays.toString(one.getExcursions()));
		
	}
	
	@Test
	public void testSetCabin()
	{
		SimpleDateFormat pretty = new SimpleDateFormat("HH:mm MM-dd-YYYY");
		
		Calendar cal = Calendar.getInstance();
		cal.set(2005, 11, 3, 20, 50);
		
		Calendar two = Calendar.getInstance();
		two.set(2005, 11, 15, 22, 45);
		Cruise one = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		
		one.setCabinType(CabinType.BALCONY);
		assertEquals(CabinType.BALCONY, one.getCabinType());
	}
	
	@Test
	public void testSetCabinOcean()
	{
		SimpleDateFormat pretty = new SimpleDateFormat("HH:mm MM-dd-YYYY");
		
		Calendar cal = Calendar.getInstance();
		cal.set(2005, 11, 3, 20, 50);
		
		Calendar two = Calendar.getInstance();
		two.set(2005, 11, 15, 22, 45);
		Cruise one = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		
		one.setCabinType(CabinType.OCEAN_VIEW);
		assertEquals(CabinType.OCEAN_VIEW, one.getCabinType());
	}
	
	
	@Test
	public void testGetHomePort()
	{
		SimpleDateFormat pretty = new SimpleDateFormat("HH:mm MM-dd-YYYY");
		
		Calendar cal = Calendar.getInstance();
		cal.set(2005, 11, 3, 20, 50);
		
		Calendar two = Calendar.getInstance();
		two.set(2005, 11, 15, 22, 45);
		Cruise one = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		
		assertEquals("Miami", one.getHomePort());
	}
	
	@Test
	public void testGetDepartureDate()
	{
		SimpleDateFormat pretty = new SimpleDateFormat("HH:mm MM-dd-YYYY");
		
		Calendar cal = Calendar.getInstance();
		cal.set(2005, 11, 3, 20, 50);
		
		Calendar two = Calendar.getInstance();
		two.set(2005, 11, 15, 22, 45);
		Cruise one = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		
		assertEquals("20:50 12-03-2005", pretty.format(one.getDepartureDate().getTime()));
	}
	
	@Test
	public void testGetReturnDate()
	{
		SimpleDateFormat pretty = new SimpleDateFormat("HH:mm MM-dd-YYYY");
		
		Calendar cal = Calendar.getInstance();
		cal.set(2005, 11, 3, 20, 50);
		
		Calendar two = Calendar.getInstance();
		two.set(2005, 11, 15, 22, 45);
		Cruise one = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		
		assertEquals("22:45 12-15-2005", pretty.format(one.getReturnDate().getTime()));
	}
	
	@Test
	public void testGetVesselName()
	{
		SimpleDateFormat pretty = new SimpleDateFormat("HH:mm MM-dd-YYYY");
		
		Calendar cal = Calendar.getInstance();
		cal.set(2005, 11, 3, 20, 50);
		
		Calendar two = Calendar.getInstance();
		two.set(2005, 11, 15, 22, 45);
		Cruise one = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		
		assertEquals("Red", one.getVesselName());
	}
	
	@Test
	public void testGetExcursionCosts()
	{
		SimpleDateFormat pretty = new SimpleDateFormat("HH:mm MM-dd-YYYY");
		
		Calendar cal = Calendar.getInstance();
		cal.set(2005, 11, 3, 20, 50);
		
		Calendar two = Calendar.getInstance();
		two.set(2005, 11, 15, 22, 45);
		Cruise one = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		
		one.addExcursion("Pizza", 15.40);
		one.addExcursion("A", 4.60);
		one.addExcursion("B", 1.25);
		one.addExcursion("C", 3.35);
		
		
		assertEquals(24.6, one.getExcursionCosts(), DOUBLE_TOLERANCE);
	}

	
	@Test
	public void testGetNumExcursions()
	{
		SimpleDateFormat pretty = new SimpleDateFormat("HH:mm MM-dd-YYYY");
		
		Calendar cal = Calendar.getInstance();
		cal.set(2005, 11, 3, 20, 50);
		
		Calendar two = Calendar.getInstance();
		two.set(2005, 11, 15, 22, 45);
		Cruise one = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		
		one.addExcursion("Pizza", 15.40);
		one.addExcursion("A", 4.60);
		one.addExcursion("B", 1.25);
		one.addExcursion("C", 3.35);
		
		
		assertEquals(4, one.getNumExcursions());
	}
	
	@Test
	public void testGetLodgingCost()
	{
		SimpleDateFormat pretty = new SimpleDateFormat("HH:mm MM-dd-YYYY");
		
		Calendar cal = Calendar.getInstance();
		cal.set(2005, 11, 3, 20, 50);
		
		Calendar two = Calendar.getInstance();
		two.set(2005, 11, 15, 22, 45);
		Cruise one = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		one.setCabinType(CabinType.SUITE);
		
		assertEquals(727.50, one.getLodgingCost(), DOUBLE_TOLERANCE);
	}
	
	@Test
	public void testGetPrice()
	{
		SimpleDateFormat pretty = new SimpleDateFormat("HH:mm MM-dd-YYYY");
		
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
		
		assertEquals(752.1, one.getPrice(), DOUBLE_TOLERANCE);
	}
	
	@Test
	public void testGetDepositAmount()
	{
		SimpleDateFormat pretty = new SimpleDateFormat("HH:mm MM-dd-YYYY");
		
		Calendar cal = Calendar.getInstance();
		cal.set(2005, 11, 3, 20, 50);
		
		Calendar two = Calendar.getInstance();
		two.set(2005, 11, 15, 22, 45);
		Cruise one = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		one.setCabinType(CabinType.SUITE);
		
		
		assertEquals(363.75, one.getDepositAmount(), DOUBLE_TOLERANCE);
	}
	
	@Test
	public void testToString()
	{
		SimpleDateFormat pretty = new SimpleDateFormat("HH:mm MM-dd-YYYY");
		
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
		
		assertEquals("$  752.10  Beach Trip (Flight Not Included)\n" + 
				"           Cruising from Miami on the Red (includes 4 excursions)",
				one.toString());
	}
	
	
	@Test
	public void testToStringNoExcursions()
	{
		SimpleDateFormat pretty = new SimpleDateFormat("HH:mm MM-dd-YYYY");
		
		Calendar cal = Calendar.getInstance();
		cal.set(2005, 11, 3, 20, 50);
		
		Calendar two = Calendar.getInstance();
		two.set(2005, 11, 15, 22, 45);
		Cruise one = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		one.setCabinType(CabinType.SUITE);
		
		assertEquals("$  727.50  Beach Trip (Flight Not Included)\n" + 
				"           Cruising from Miami on the Red" ,
				one.toString());
	}
	
	
	@Test
	public void testAddExcursionsOver()
	{
		SimpleDateFormat pretty = new SimpleDateFormat("HH:mm MM-dd-YYYY");
		
		Calendar cal = Calendar.getInstance();
		cal.set(2005, 11, 3, 20, 50);
		
		Calendar two = Calendar.getInstance();
		two.set(2005, 11, 15, 22, 45);
		Cruise one = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		
		one.addExcursion("Pizza", 15.40);
		one.addExcursion("A", 4.60);
		one.addExcursion("B", 1.25);
		one.addExcursion("C", 3.35);
		one.addExcursion("A", 4.60);
		one.addExcursion("A", 4.60);
		one.addExcursion("A", 4.60);
		one.addExcursion("A", 4.60);
		one.addExcursion("A", 4.60);
		one.addExcursion("A", 4.60);
		one.addExcursion("A", 4.60);
		one.addExcursion("A", 4.60);
		one.addExcursion("A", 4.60);
		
		assertEquals(10, one.getNumExcursions());
	}
	
	@Test
	public void testAddExcursionsNull()
	{
		SimpleDateFormat pretty = new SimpleDateFormat("HH:mm MM-dd-YYYY");
		
		Calendar cal = Calendar.getInstance();
		cal.set(2005, 11, 3, 20, 50);
		
		Calendar two = Calendar.getInstance();
		two.set(2005, 11, 15, 22, 45);
		Cruise one = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		
		one.addExcursion("Pizza", 15.40);
		one.addExcursion("A", 4.60);
		one.addExcursion("B", 1.25);
		
		String a = null;
		Double b = 3.50;
		one.addExcursion(a, b);
		
		
		assertEquals(3, one.getNumExcursions());
	}
	
	@Test
	public void testAddExcursionsEmpty()
	{
		SimpleDateFormat pretty = new SimpleDateFormat("HH:mm MM-dd-YYYY");
		
		Calendar cal = Calendar.getInstance();
		cal.set(2005, 11, 3, 20, 50);
		
		Calendar two = Calendar.getInstance();
		two.set(2005, 11, 15, 22, 45);
		Cruise one = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		
		one.addExcursion("Pizza", 15.40);
		one.addExcursion("A", 4.60);
		one.addExcursion("B", 1.25);
		
		String a = "";
		Double b = 3.50;
		one.addExcursion(a, b);
		
		
		assertEquals(3, one.getNumExcursions());
	}
	
	
	@Test
	public void testAddExcursionsPriceUnder()
	{
		SimpleDateFormat pretty = new SimpleDateFormat("HH:mm MM-dd-YYYY");
		
		Calendar cal = Calendar.getInstance();
		cal.set(2005, 11, 3, 20, 50);
		
		Calendar two = Calendar.getInstance();
		two.set(2005, 11, 15, 22, 45);
		Cruise one = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		
		one.addExcursion("Pizza", 15.40);
		one.addExcursion("A", 4.60);
		one.addExcursion("B", 1.25);
		
		String a = "Mall";
		Double b = -3.50;
		one.addExcursion(a, b);
		
		
		assertEquals(21.25, one.getExcursionCosts(), DOUBLE_TOLERANCE);
	}
	
	
	@Test
	public void testCabinTypeValues()
	{
		String nine = "";
		for (CabinType c : CabinType.values())
		{
			nine = c.toString();
			
		    //System.out.println(c);
		}
		
		assertEquals("SUITE", nine);
		
	}
	
	
	@Test
	public void testCabinTypeValuesOf()
	{
		SimpleDateFormat pretty = new SimpleDateFormat("HH:mm MM-dd-YYYY");
		
		Calendar cal = Calendar.getInstance();
		cal.set(2005, 11, 3, 20, 50);
		
		Calendar two = Calendar.getInstance();
		two.set(2005, 11, 15, 22, 45);
		Cruise one = new Cruise("Beach Trip", 14, "Red", "Miami", cal, two, 145.50);
		one.setCabinType(CabinType.SUITE);
		assertEquals("BALCONY", one.getCabinType().valueOf("BALCONY").toString());
		
	}
	
	
}

