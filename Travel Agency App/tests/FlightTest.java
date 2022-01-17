package tests;

import triptypes.Flight;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;

import static org.junit.Assert.*;

import org.junit.Test;

public class FlightTest 
{

	
	private static final double DOUBLE_TOLERANCE = 0.001;
	
	
	@Test
	public void testConstructor() 
	{
		SimpleDateFormat pretty = new SimpleDateFormat("HH:mm MM-dd-YYYY");
		
		Calendar cal = Calendar.getInstance();
		cal.set(2005, 11, 3, 20, 50);
		
		Calendar two = Calendar.getInstance();
		two.set(2005, 11, 15, 22, 45);
		
		Flight one = new Flight("LR", 321, "LA", "OMA", cal, two, 355.50);
		assertEquals("LR", one.getFlightName());
		assertEquals(321, one.getFlightNumber());
		assertEquals("LA", one.getDepartureFrom());
		assertEquals("OMA", one.getArriveFrom());
		assertEquals("20:50 12-03-2005", pretty.format(one.getDepartTime().getTime()));
		assertEquals("22:45 12-15-2005", pretty.format(one.getArriveTime().getTime()));
		assertEquals(355.50, one.getPrice(), DOUBLE_TOLERANCE);
		
	}
	
	
	
	@Test
	public void testToString()
	{
		SimpleDateFormat pretty = new SimpleDateFormat("HH:mm MM-dd-YYYY");
		
		Calendar cal = Calendar.getInstance();
		cal.set(2005, 11, 3, 20, 50);
		
		Calendar two = Calendar.getInstance();
		two.set(2005, 11, 15, 22, 45);
		
		Flight one = new Flight("LR", 321, "LA", "OMA", cal, two, 355.50);
		
		assertEquals("LR 321 Departs: LA at 20:50 12-03-2005; Arrives OMA at 22:45 12-15-2005",
				one.toString());
	}

}
