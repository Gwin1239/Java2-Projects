// COURSE: CSCI1620
// TERM: Fall 2020
// 
// NAME: Godwin Djossou
// RESOURCES: CSLC, Canvas document.

package reports;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import analytics.Data;

/**
 * A report for a single company of Fortune 500 data.
 * Report includes the minimum, maximum, average, and standard deviation of revenues, profits, and rank
 *  for all years in which the company was ranked in the Fortune 500.
 * @author gdjossou
 *
 */
public class CompanyReport implements Report
{
	/**
	 * Double array that contains rank.
	 */
	private Double[] rank;
	
	/**
	 * Double array that contains revenue.
	 */
	private Double[] revenue;
	
	/**
	 * Double array that contains profit.
	 */
	private Double[] profit;
	
	/**
	 * Integer for the counter.
	 */
	private int count;
	
	/**
	 * String for the Company.
	 */
	private String report;
	
	/**
	 * Boolean that declares if the file was passed and processed.
	 */
	private boolean passed;
	
	/**
	 * File for input of the report.
	 */
	private File input;
	
	
	/**
	 * Creates new CompanyReport for given company; data to be read from given file.
	 * @param inputFileIn - File containing Fortune 500 data for this report.
	 * @param companyIn - Company to report Fortune 500 data.
	 */
	public CompanyReport(File inputFileIn, String companyIn)
	{
		report = companyIn;
		input = inputFileIn;
		rank = new Double[4];
		profit = new Double[4];
		revenue = new Double[4];
		count = 0;
		passed = false;
	}
	
	/**
	 * Reads data from Fortune 500 data file; processes the data.
	 * The file is a csv file and can be assumed is formatted correctly.
	 * See supplemental document for details on reading from csv files.
	 * Calculates the minimum, maximum, average, and standard deviation of revenues, profits, and rank
	 *  for all years the company is ranked using tools in the Data class.
	 * @return true if processing successful, false if the input file does not exist.
	 */
	public boolean processReport()
	{
		ArrayList<String[]> company1 = new ArrayList<String[]>();
		ArrayList<Double> ranks = new ArrayList<Double>();
		ArrayList<Double> money = new ArrayList<Double>();
		ArrayList<Double> rev = new ArrayList<Double>();
		
		
		
		
		try
		{
			Scanner one = new Scanner(input);
			
			while (one.hasNextLine())
			{
				//if (one.hasNextLine())
				//{
				String nextt = one.nextLine();
				String[] arr = nextt.split(",");
				if (arr[Report.COMPANY_LOC].equals(report))
				{
					company1.add(arr);
				}
					
				//}
				
				
			}
			one.close();
		}
			
		catch (FileNotFoundException a)
		{
			return false;
			
		}
			
		for (int i = 0; i < company1.size(); i++)
		{
			rev.add(Double.parseDouble(company1.get(i)[Report.REVENUE_LOC]));
			money.add(Double.parseDouble(company1.get(i)[Report.PROFIT_LOC]));
			ranks.add(Double.parseDouble(company1.get(i)[Report.RANK_LOC]));
		}
		count = ranks.size();
			
		
		revenue = calculator(rev);
		rank = calculator(ranks);
		profit = calculator(money);
			
		passed = true;

		
		
		return true;
			
	}

	/**
	 * Writes the processed report to the given file.
	 * The given file's contents will look like the result of calling CompanyReport's toString.
	 * @param outputFile - File to write report to.
	 * @throws DataNotProcessedException - Thrown if write attempted and report has not yet been processed.
	 * @return true if write successful, false if file cannot be created.
	 */
	public boolean writeReport(File outputFile)
	{
		boolean yur = true;
		try
		{
			if (!passed)
			{
				throw new DataNotProcessedException();
			}
			PrintWriter one = new PrintWriter(outputFile);
			
			one.print(toString());
			one.close();
		}
		catch (FileNotFoundException b)
		{
			yur = false;
		}
		
		return yur;
	}
	
	/**
	 * Returns a formatted String of this report suitable for writing to an output file. String is of the form:
	 * 
	 * Fortune 500 Report for COMPANY ranked RANKED times
	 * Revenue
	 * Min: MINREV Max: MAXREV Avg: AVGREV StD: STDREV
	 * Profit
	 * Min: MINPRO Max: MAXPRO Avg: AVGPRO StD: STDPRO
	 * Rank
	 * Min: MINRANK Max: MAXRANK Avg: AVGRANK StD: STDRANK
	 * 
	 * Where COMPANY is the company, RANKED is the number of times the company has been ranked in the file,
	 *  MINREV, MAXREV, AVGREV, STDREV are the minimum, maximum, average, and standard deviation of revenues,
	 *  MINPRO, MAXPRO, AVGPRO, STDPRO are the minimum, maximum, average, and standard deviation of profits,
	 *  and MINRANK, MAXRANK, AVGRANK, STDRANK are the minimum, maximum, average, and standard deviation of rank.
	 * These are all floating point values formatted to exactly three decimals except for MINRANK and MAXRANK
	 *  which are whole number values.
	 * NOTE: There are no blank lines before, after, or between the lines, 
	 * and the String DOES NOT end in a new line.
	 *  If your toString is not formatted exactly most tests will fail.
	 *  A JUnit test for this method is provided in the tests package to ensure your formatting is correct.
	 *  Additionally, remember that all are formatted to exactly three decimal places,
	 *   which will explain any "nul"s you see in the provided test case.
	 */
	@Override
	public String toString()
	{
		String one = "Fortune 500 Report for " + report + " ranked " + count + " times";
		String two = "Revenue\n" + toStringHelper(revenue);
		String three = "Profit\n" + toStringHelper(profit);
		String four = "Rank\n" + toStringHelper(rank);
		return one + "\n" + two + "\n" + three + "\n" + four;
	}

	/**
	 * Helper to calculate for the toString method.
	 * @param data data to assist us in calculations.
	 * @return calculated String.
	 */
	private String toStringHelper(Double[] data)
	{
		String min;
		String max;
		String avg;
		String stdev;
		
		
		min = "Min: " + String.format("%.3f", data[0]);
		max = " Max: " + String.format("%.3f", data[1]);
		stdev = " StD: " + String.format("%.3f", data[2]);
		avg = " Avg: " + String.format("%.3f", data[3]);
		
		
		if (data.equals(rank))
		{
			if (data[0] != null)
			{
				min = "Min: " + String.format("%.0f", data[0]);
				max = " Max: " + String.format("%.0f", data[1]);
			}
			else
			{
				min = "Min: " + data[0];
				max = " Max: " + data[1];
			}
		}
		return min + max + avg + stdev;
	}
	
	/**
	 * Method that uses the methods in the Data class to calculate data.
	 * @param data variable used to size method call and calculate.
	 * @return finished calculated value.
	 */
	private Double[] calculator(ArrayList<Double> data)
	{
		Double[] resultt = new Double[data.size()];
		for (int i = 0; i < data.size(); i++)
		{
			resultt[i] = data.get(i);
		}
		
		Double[] value = new Double[4];
		value[0] = Data.minimum(resultt);
		value[1] = Data.maximum(resultt);
		value[2] = Data.standardDeviation(resultt);
		value[3] = Data.average(resultt);
		
		
		return value;
	}
	
	
	
	/**
	 * Returns the company of this report.
	 * @return Company of this report.
	 */
	public String getCompany()
	{
		return report;
	}

}
