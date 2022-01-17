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
 * A report for a single year of Fortune 500 data.
 * Report includes the minimum, maximum, average, and standard deviation of revenues and profits
 *  for all ranked companies of the report's year.
 * @author gdjossou
 *
 */
public class YearReport implements Report
{
	/**
	 * Year to process Year Report.
	 */
	private int year;
	
	/**
	 * File to process Year Report.
	 */
	private File input;
	
	/**
	 * Double array that contains revenue.
	 */
	private Double[] revenuee;
	
	/**
	 * Double array that contains profit.
	 */
	private Double[] profitt;
	
	/**
	 * Boolean that declares if the file was passed and processed.
	 */
	private boolean passedd;
	
	/**
	 * ArrayList for the Year Report.
	 */
	private ArrayList<String[]> arrr = new ArrayList<String[]>();
	
	/**
	 * Creates new YearReport for given year; data to be read from given file.
	 * @param inputFileIn - File containing Fortune 500 data for this report.
	 * @param yearIn - Year to report Fortune 500 data.
	 */
	public YearReport(File inputFileIn, int yearIn)
	{
		input = inputFileIn;
		year = yearIn;
		profitt = new Double[4];
		revenuee = new Double[4];
		passedd = false;
	}

	/**
	 * Reads data from Fortune 500 data file; processes the data.
	 * The file is a csv file and can be assumed is formatted correctly.
	 * See supplemental document for details on reading from csv files.
	 * Calculates the minimum, maximum, average, and standard deviation of revenues and profits
	 *  for all ranked companies of the report's year using tools in the Data class.
	 * @throws YearNotFoundException - Thrown if the report's year is not present in the data file.
	 * @return true if processing successful, false if the input file does not exist.
	 */
	public boolean processReport() throws YearNotFoundException
	{
		ArrayList<Double> rev = new ArrayList<Double>();
		ArrayList<Double> money = new ArrayList<Double>();
		
		try
		{
			Scanner one = new Scanner(input);
			
			while (one.hasNextLine())
			{
				String alt = one.nextLine();
				String[] altArr = alt.split(",");
				
				if (altArr[Report.YEAR_LOC].equals(String.valueOf(year)))
				{
					arrr.add(altArr);
				}
				
			}
			one.close();
			
			if (arrr.size() == 0)
			{
				throw new YearNotFoundException();
			}
			
			
		}
		
		catch (FileNotFoundException c)
		{
			return false;
		}
		
		for (int i = 0; i < arrr.size(); i++)
		{
			rev.add(Double.parseDouble(arrr.get(i)[Report.REVENUE_LOC]));
			money.add(Double.parseDouble(arrr.get(i)[Report.PROFIT_LOC]));
		}
		
		revenuee = calcultorr(rev);
		profitt = calcultorr(money);
		
		passedd = true;
		
		return true;
	}

	/**
	 * Writes the processed report to the given file.
	 * The given file's contents will look like the result of calling YearReport's toString.
	 * @param outputFile - File to write report to.
	 * @throws DataNotProcessedException - Thrown if write attempted and report has not yet been processed.
	 * @return true if write successful, false if file cannot be created.
	 */
	public boolean writeReport(File outputFile) throws DataNotProcessedException
	{
		boolean yur = true;
		
		try
		{
			if (!passedd)
			{
				throw new DataNotProcessedException();
			}
			
			PrintWriter one = new PrintWriter(outputFile);
			
			one.print(toString());
			one.close();
		}
		catch (FileNotFoundException f)
		{
			yur = false;
		}
		
		return yur;
	}

	/**
	 * Returns a formatted String of this report suitable for writing to an output file. String is of the form:
	 * 
	 * Fortune 500 Report for YEAR
	 * Revenue
	 * Min: MINREV Max: MAXREV Avg: AVGREV StD: STDREV
	 * Profit
	 * Min: MINPRO Max: MAXPRO Avg: AVGPRO StD: STDPRO
	 * 
	 * Where YEAR is the year of the report, MINREV, MAXREV, AVGREV, STDREV are the
	 *  minimum, maximum, average, and standard deviation of revenues, and
	 *  MINPRO, MAXPRO, AVGPRO, STDPRO are the minimum, maximum, average, and standard deviation of profits.
	 * These are all floating point values formatted to exactly three decimals
	 *  except for YEAR which is a whole number value.
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
		String one = "Fortune 500 Report for " + year;
		String two = "Revenue\n" + toStringHelperr(revenuee);
		String three = "Profit\n" + toStringHelperr(profitt);
		return one + "\n" + two + "\n" + three;
	}

	/**
	 * Helper to calculate for the toString method.
	 * @param data data to assist us in calculations.
	 * @return calculated String.
	 */
	private String toStringHelperr(Double[] data)
	{
		String max;
		String min;
		String avg;
		String stdev;
		
		min = "Min: " + String.format("%.3f", data[0]);
		max = " Max: " + String.format("%.3f", data[1]);
		avg = " Avg: " + String.format("%.3f", data[3]);
		stdev = " StD: " + String.format("%.3f", data[2]);
		
		return min + max + avg + stdev;
	}
	
	/**
	 * Method that uses the methods in the Data class to calculate data.
	 * @param data variable used to size method call and calculate.
	 * @return finished calculated value.
	 */
	private Double[] calcultorr(ArrayList<Double> data)
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
	 * Returns the year of this report.
	 * @return Year of this report.
	 */
	public int getYear()
	{
		return year;
	}

}

