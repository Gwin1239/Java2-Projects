package tests;

import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;
import reports.CompanyReport;
import reports.DataNotProcessedException;

public class CompanyReportTest {

	@Test
	public void unprocessedToStringTest()
	{
		CompanyReport c = new CompanyReport(new File("fortune500.csv"), "Nike");
		String expected = "Fortune 500 Report for Nike ranked 0 times\n" + 
				"Revenue\n" + 
				"Min: nul Max: nul Avg: nul StD: nul\n" + 
				"Profit\n" + 
				"Min: nul Max: nul Avg: nul StD: nul\n" + 
				"Rank\n" + 
				"Min: null Max: null Avg: nul StD: nul";
		
		assertEquals("Problem in CompanyReport basic toString format, check spelling, capitalization, spacing, and format",
				expected, c.toString());
	}
	
	@Test
	public void testConstuctor()
	{
		CompanyReport c = new CompanyReport(new File("fortune500.csv"), "Exxon Mobil");
		assertEquals("Exxon Mobil", c.getCompany());
	}
	
	
	@Test
	public void testFileNotFound()
	{
		CompanyReport c = new CompanyReport(new File("dhdhdf.csv"), "Exxon Mobil");
		assertEquals(false, c.processReport());
	}
	
	@Test
	public void testProcessReport()
	{
		CompanyReport c = new CompanyReport(new File("fortune500.csv"), "Exxon Mobil");
		assertEquals(true, c.processReport());
	}
	
	//produces error 
	@Test
	public void testWriteReport()
	{
		CompanyReport c = new CompanyReport(new File("fortune500.csv"), "Exxon Mobil");
		//c.processReport();
		
		try
		{
			assertEquals(true, c.writeReport(new File("new.txt")));
		}
		catch (Exception a)
		{
			a.printStackTrace();
		}
	}
	
	//thus too
	@Test
	public void testNotProcessed()
	{
		CompanyReport c = new CompanyReport(new File("fortune500.csv"), "Exxon Mobil");
		
		
		try
		{
			assertEquals(false, c.writeReport(new File("new.txt")));
		}
		catch (DataNotProcessedException an)
		{
			an.getStackTrace();
			assertTrue(true);
		}
	}
	
	@Test
	public void testdToString()
	{
		CompanyReport c = new CompanyReport(new File("fortune500.csv"), "Exxon Mobil");
		c.processReport();
		String expected = "Fortune 500 Report for Exxon Mobil ranked 26 times\n" + 
				"Revenue\n" + 
				"Min: 5661.400 Max: 79106.500 Avg: 21761.404 StD: 19601.635\n" + 
				"Profit\n" + 
				"Min: 562.500 Max: 4295.200 Avg: 1486.715 StD: 941.235\n" + 
				"Rank\n" + 
				"Min: 1 Max: 3 Avg: 1.923 StD: 0.474";
		
		assertEquals("Problem in CompanyReport basic toString format, check spelling, capitalization, spacing, and format",
				expected, c.toString());
	}
	

}
