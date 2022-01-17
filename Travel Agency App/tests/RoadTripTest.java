package tests;

import triptypes.RoadTrip;

import static org.junit.Assert.*;

import org.junit.Test;

public class RoadTripTest 
{

	private static final double DOUBLE_TOLERANCE = 0.0001;
	
	@Test
	public void testConstructor() 
	{
		
		String[] testArr = {"Kansas", "Nebraska", "Wyoming"};
		RoadTrip one = new RoadTrip("Forest", 8, testArr, 2.15, 350, 8, 4);
		assertEquals("Forest", one.getName());
		assertEquals(8, one.getNumDays());
		assertEquals("Kansas, Nebraska, Wyoming", one.getStops());
		assertEquals(2.15, one.getFuelPrice(), DOUBLE_TOLERANCE);
		assertEquals(350, one.getMiles());
		assertEquals(8, one.getNumPersons());
		assertEquals(4, one.getHotelStars());
	}
	
	
	
	@Test
	public void testCarCostOneToTwo() 
	{
		
		String[] testArr = {"Kansas", "Nebraska", "Wyoming"};
		RoadTrip one = new RoadTrip("Forest", 8, testArr, 2.15, 350, 2, 4);
		assertEquals(294.00, one.getCarCost(), DOUBLE_TOLERANCE);
		
	}
	
	
	@Test
	public void testCarCostThreeToFour() 
	{
		
		String[] testArr = {"Kansas", "Nebraska", "Wyoming"};
		RoadTrip one = new RoadTrip("Forest", 8, testArr, 2.15, 350, 4, 4);
		assertEquals(401.04, one.getCarCost(), DOUBLE_TOLERANCE);
		
	}
	
	
	@Test
	public void testCarCostFiveToSix() 
	{
		
		String[] testArr = {"Kansas", "Nebraska", "Wyoming"};
		RoadTrip one = new RoadTrip("Forest", 8, testArr, 2.15, 350, 6, 4);
		assertEquals(482, one.getCarCost(), DOUBLE_TOLERANCE);
		
	}
	
	@Test
	public void testCarCostSevenToEight() 
	{
		
		String[] testArr = {"Kansas", "Nebraska", "Wyoming"};
		RoadTrip one = new RoadTrip("Forest", 8, testArr, 2.15, 350, 8, 4);
		assertEquals(564, one.getCarCost(), DOUBLE_TOLERANCE);
		
	}
	
	@Test
	public void testCarCostAboveEight() 
	{
		
		String[] testArr = {"Kansas", "Nebraska", "Wyoming"};
		RoadTrip one = new RoadTrip("Forest", 8, testArr, 2.15, 350, 9, 4);
		assertEquals(1200.00, one.getCarCost(), DOUBLE_TOLERANCE);
		
	}
	
	@Test
	public void testLodgingCost() 
	{
		
		String[] testArr = {"Kansas", "Nebraska", "Wyoming"};
		RoadTrip one = new RoadTrip("Forest", 8, testArr, 2.15, 350, 8, 4);
		assertEquals(3942.40, one.getLodgingCost(), DOUBLE_TOLERANCE);
		
	}
	
	@Test
	public void testLodgingCostOdd() 
	{
		
		String[] testArr = {"Kansas", "Nebraska", "Wyoming"};
		RoadTrip one = new RoadTrip("Forest", 8, testArr, 2.15, 350, 9, 4);
		assertEquals(4928, one.getLodgingCost(), DOUBLE_TOLERANCE);
		
	}
	
	@Test
	public void testGetNumStops() 
	{
		
		String[] testArr = {"Kansas", "Nebraska", "Wyoming"};
		RoadTrip one = new RoadTrip("Forest", 8, testArr, 2.15, 350, 8, 4);
		assertEquals(3, one.getNumStops());
		
	}
	
	@Test
	public void testSetFuelPrice() 
	{
		
		String[] testArr = {"Kansas", "Nebraska", "Wyoming"};
		RoadTrip one = new RoadTrip("Forest", 8, testArr, 2.15, 350, 8, 4);
		
		one.setFuelPrice(2.75);
		assertEquals(2.75, one.getFuelPrice(), DOUBLE_TOLERANCE);
		
	}
	
	
	@Test
	public void testSetFuelPriceBelow() 
	{
		
		String[] testArr = {"Kansas", "Nebraska", "Wyoming"};
		RoadTrip one = new RoadTrip("Forest", 8, testArr, 2.15, 350, 8, 4);
		
		one.setFuelPrice(-20.15);
		assertEquals(2.50, one.getFuelPrice(), DOUBLE_TOLERANCE);
		
	}
	
	@Test
	public void testSetPersons() 
	{
		
		String[] testArr = {"Kansas", "Nebraska", "Wyoming"};
		RoadTrip one = new RoadTrip("Forest", 8, testArr, 2.15, 350, 8, 4);
		
		one.setPersons(10);
		assertEquals(10, one.getNumPersons());
		
	}
	
	@Test
	public void testGetAmountDue() 
	{
		
		String[] testArr = {"Kansas", "Nebraska", "Wyoming"};
		RoadTrip one = new RoadTrip("Forest", 8, testArr, 2.15, 350, 8, 4);
		
		assertEquals(0, one.getAmountDue(), DOUBLE_TOLERANCE);
		
	}
	
	
	@Test
	public void testGetEstimatedFuelCostOneToTwo()
	{
		
		String[] testArr = {"Kansas", "Nebraska", "Wyoming"};
		RoadTrip one = new RoadTrip("Forest", 8, testArr, 2.15, 350, 2, 4);
		
		assertEquals(16.7222, one.getEstimatedFuelCost(), DOUBLE_TOLERANCE);
		
	}
	
	@Test
	public void testGetEstimatedFuelCostThreeToFour()
	{
		
		String[] testArr = {"Kansas", "Nebraska", "Wyoming"};
		RoadTrip one = new RoadTrip("Forest", 8, testArr, 2.15, 350, 4, 4);
		
		assertEquals(23.5156, one.getEstimatedFuelCost(), DOUBLE_TOLERANCE);
		
	}
	
	@Test
	public void testGetEstimatedFuelCostFiveToSix()
	{
		
		String[] testArr = {"Kansas", "Nebraska", "Wyoming"};
		RoadTrip one = new RoadTrip("Forest", 8, testArr, 2.15, 350, 6, 4);
		
		assertEquals(26.875, one.getEstimatedFuelCost(), DOUBLE_TOLERANCE);
		
	}
	
	
	@Test
	public void testGetEstimatedFuelCostSevenToEight() 
	{
		
		String[] testArr = {"Kansas", "Nebraska", "Wyoming"};
		RoadTrip one = new RoadTrip("Forest", 8, testArr, 2.15, 350, 8, 4);
		
		assertEquals(34.2045, one.getEstimatedFuelCost(), DOUBLE_TOLERANCE);
		
	}
	
	@Test
	public void testGetEstimatedFuelCostAboveEight() 
	{
		
		String[] testArr = {"Kansas", "Nebraska", "Wyoming"};
		RoadTrip one = new RoadTrip("Forest", 8, testArr, 2.15, 350, 9, 4);
		
		assertEquals(50.1666, one.getEstimatedFuelCost(), DOUBLE_TOLERANCE);
		
	}
	
	
	@Test
	public void testGetDepositAmount() 
	{
		
		String[] testArr = {"Kansas", "Nebraska", "Wyoming"};
		RoadTrip one = new RoadTrip("Forest", 8, testArr, 2.15, 350, 8, 4);
		
		assertEquals(4506.40, one.getDepositAmount(), DOUBLE_TOLERANCE);
		
	}
	
	@Test
	public void testGetPrice() 
	{
		
		String[] testArr = {"Kansas", "Nebraska", "Wyoming"};
		RoadTrip one = new RoadTrip("Forest", 8, testArr, 2.15, 350, 8, 4);
		
		assertEquals(4540.6045, one.getPrice(), DOUBLE_TOLERANCE);
		
	}
	
	
	@Test
	public void testGetStopsEmpty() 
	{
		
		String[] testArr = {""};
		RoadTrip one = new RoadTrip("Forest", 8, testArr, 2.15, 350, 8, 4);
		
		assertEquals("", one.getStops());
		
	}
	

}
