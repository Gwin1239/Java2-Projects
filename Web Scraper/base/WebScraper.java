// COURSE: CSCI1620
// TERM: Fall 2020
// 
// NAME: Godwin Djossou
// RESOURCES: CSLC
package scraper.base;



import scraper.utils.Document;
import scraper.utils.Elements;
import scraper.utils.PageHistory;
import scraper.utils.ResultSet;

/**
 * This class provides a simple mechanism to crawl a series of webpages 
 * recursively and extract all of the images that arefound on the pages visited.
 * 
 * @author gdjossou
 */
public class WebScraper 
{
	/**
	 * String that contains the url for the search.
	 */
	private String newUrl;
	
	/**
	 * Integer for the depth of the search.
	 */
	private int depth;
	
	/**
	 * PageHistory for the history of the search.
	 */
	private PageHistory history;
	
	/**
	 * Document object for the search.
	 */
	private Document doct;
	
	/**
	 * Builds a new WebScraper that should start at the provided URL 
	 * and will by default explore that page at a depth of 0. 
	 * This allows extracting just the details from this page and nothing else.
	 * @param urlIn The URL to explore for images.
	 */
	public WebScraper(java.lang.String urlIn)
	{
		this.newUrl = urlIn;
		this.depth = 0;
		this.doct = new Document();
		this.history = new PageHistory();
	}
	
	/**
	 * Builds a new WebScraper that should start at the provided URL 
	 * and will explore recursively to a specified depth.
	 * @param urlIn The URL to begin exploring for images.
	 * @param depthIn The recursive depth to explore, 
	 * must be >= 0.Negative values will be treated as equivalent to 0.
	 */
	public WebScraper(java.lang.String urlIn,
					int depthIn)
	{
		this.newUrl = urlIn;
		
		if (depthIn >= 0)
		{
			this.depth = depthIn;
		}
		else
		{
			this.depth = 0;
		}
		
		this.doct = new Document();
		this.history = new PageHistory();
	}
	
	/**
	 * Updates this WebScraper to explore to a new depth.
	 * @param depthIn The recursive depth to explore, must be >= 0.
	 * Negative values will be treated as equivalent to 0.
	 */
	public void setDepth(int depthIn)
	{
		if (depthIn >= 0)
		{
			this.depth = depthIn;
		}
		else
		{
			this.depth = 0;
		}
	}
	
	/**
	 * Retrieves the exploration depth of this WebScraper.
	 * @return The depth stored in this WebScraper.
	 */
	public int getDepth()
	{
		return this.depth;
	}
	
	
	/**
	 * Updates the base URL to explore for this WebScraper.
	 * @param url The new URL to explore. 
	 * The WebScraper url is only changed if the url value is valid (not null or empty).
	 */
	public void setURL(java.lang.String url)
	{
		if (url != null && !url.equals(""))
		{
			this.newUrl = url;
		}
	}
	
	/**
	 * Retrieves the base url for exploration by this WebScraper.
	 * @return The base url.
	 */
	public java.lang.String getURL()
	{
		return this.newUrl;
	}
	
	/**
	 * Retrieves the set of images found directly at the initial base URL for this WebScraper. 
	 * This method will not explore any links found at the base page. 
	 * Image information should bestored in the order in which their 
	 * corresponding <img> tags appear in the source HTML code. 
	 * If an image appears more than once in a page, only one entry should appear in the ResultSet.
	 * @return A collection of ImageEntry objects for the images found at the base url location.
	 */
	public scraper.utils.ResultSet getImages()
	{
		//int i = 0;
		Document doc = new Document();
		doc.loadPageFromURL(this.newUrl);
		//int numImg = doc.getElementsByTag("img").size();
		
		Elements elements = doc.getElementsByTag("img");
		
		
		ResultSet results = new ResultSet();
		
		while (elements.hasNextElement())
		{
			//Element element = elements.getNextElement();
			
			String src = elements.getNextElement().getAttributeValue("src");
			
			if (!results.contains(src))
			{
				ImageEntry image = new ImageEntry(this.newUrl, src);
				results.addResult(image);
			}
		}	
		
		return results;
	}
	
	/**
	 * This method will recursively explore pages starting at the base url defined 
	 * for this WebScraper to the depth for which the scraper is configured. 
	 * The ResultSet will contain all images discovered along the way, 
	 * with images from a page being explored stored in the ResultSet prior to any images found on linked pages. 
	 * ImageEntries will always appear in the ResultSetin the order in which the corresponding <img> tags are 
	 * given in the HTML files. Only the first occurrence of a particular image 
	 * (by absoluteURL) is stored in the ResultSet. 
	 * Links on a page will be explored in the sequential order in which their 
	 * corresponding a tags appear in the HTML file. 
	 * The same URLshould never be crawled more than once, even if it is linked 
	 * from itself for another later page.
	 * @return The set of ImageEntry objects resulting from this recursive crawl.
	 */
	public scraper.utils.ResultSet crawlPage()
	{
		return this.crawlPageHelper(this.newUrl, this.depth);
	}
	
	/**
	 * The recursive helper method for the crawlPage method.
	 * @param urlIn The URL to begin exploring for images.
	 * @param depthIn The recursive depth to explore
	 * @return The set of ImageEntry objects resulting from this recursive crawl.
	 */
	public scraper.utils.ResultSet crawlPageHelper(String urlIn, int depthIn)
	{
		
		
		WebScraper web = new WebScraper(urlIn);
		
		
		this.history.markVisited(urlIn);
		//doct.loadPageFromURL(urlIn);
		
		if (this.doct.loadPageFromURL(urlIn))
		{
			ResultSet results;
			Elements elements = this.doct.getElementsByTag("a");
			
			String first;
			
			results = web.getImages();
			if (depthIn > 0)
			{
				while (elements.hasNextElement())
				{
					first = elements.getNextElement().getAttributeValue("href");
					
					if (!this.history.visited(first))
					{
						ResultSet another = this.crawlPageHelper(first, depthIn - 1);
						results = results.merge(another);
						
					}
				}
			}
			return results;
			
		}
		return new ResultSet();
	}
	
	/**
	 * Retrieves the historical trail of pages visited during the last top-level call to crawlPage.
	 * @return The most recent collection of pages visited. 
	 * If the crawlPagemethod has not been previously called, the PageHistory object will be empty.
	 */
	public scraper.utils.PageHistory getPageHistory()
	{
		return this.history;
	}
	
	
	
}
