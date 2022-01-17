package reports;

import java.io.File;

public class HwTest {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		
		CompanyReport c = new CompanyReport(new File("fortune500.csv"), "Exxon Mobil");
		c.processReport();
		
		//System.out.println(c.toString());
		
		YearReport y = new YearReport(new File("fortune500.csv"), 1961);
		y.processReport();
		
		System.out.println(y.toString());
	}

}
