package tests;

import static org.junit.Assert.*;
import java.io.File;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import reports.DataNotProcessedException;
import reports.YearNotFoundException;
import reports.YearReport;

public class YearReportTest {

	 @Rule
	 public final ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testConstructor()
	{
		YearReport y = new YearReport(new File("fortune500.csv"), 1961);
		assertEquals(1961, y.getYear());
		
	}
	
	@Test
	public void testProcessReport()
	{
		YearReport y = new YearReport(new File("fortune500.csv"), 1961);
		
		assertEquals(true, y.processReport());
	}
	
	@Test(expected = YearNotFoundException.class)
	public void testProcessReportYearNotFound()
	{
		YearReport y = new YearReport(new File("fortune500.csv"), 2020);
		y.processReport();
		
		exception.expect(YearNotFoundException.class);
		
	}
	
	
	@Test
	public void testWriteReport()
	{
		YearReport y = new YearReport(new File("fortune500.csv"), 1961);
		y.processReport();
		
		assertEquals(true, y.writeReport(new File("output1.txt")));
	}
	
	
	@Test(expected = DataNotProcessedException.class) 
	public void testWriteReportDataNot()
	{
		YearReport y = new YearReport(new File("fortune500.csv"), 1961);
		
		y.writeReport(new File("fakee.txt"));
		
		exception.expect(DataNotProcessedException.class);
	}
	
	
	
	@Test
	public void unprocessedToStringTest()
	{
		YearReport y = new YearReport(new File("fortune500.csv"), 2020);
		String expected = "Fortune 500 Report for 2020\n" + 
				"Revenue\n" + 
				"Min: nul Max: nul Avg: nul StD: nul\n" + 
				"Profit\n" + 
				"Min: nul Max: nul Avg: nul StD: nul";
		
		assertEquals("Problem in YearReport basic toString format, check spelling, capitalization, spacing, and format",
				expected, y.toString());
	}
	
	@Test
	public void testToString()
	{
		YearReport y = new YearReport(new File("fortune500.csv"), 1961);
		y.processReport();
		
		String expected = "Fortune 500 Report for 1961\n" + 
				"Revenue\n" + 
				"Min: 72.400 Max: 12736.000 Avg: 409.447 StD: 849.889\n" + 
				"Profit\n" + 
				"Min: -42.900 Max: 959.000 Avg: 23.247 StD: 68.299";
		
		assertEquals("Problem in YearReport basic toString format, check spelling, capitalization, spacing, and format",
				expected, y.toString());
	}

}

