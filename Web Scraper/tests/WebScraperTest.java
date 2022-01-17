package scraper.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import scraper.base.WebScraper;;

public class WebScraperTest {

	@Test
	public void testDefaultConstructor() 
	{
		
		WebScraper one = new WebScraper("http://kreestman.unomaha.community/hw3testpage/page1.html");
		
		assertEquals("http://kreestman.unomaha.community/hw3testpage/page1.html",one.getURL());
		assertEquals(0, one.getDepth());
	}
	

	@Test
	public void testSpecificConstructor() 
	{
		
		WebScraper one = new WebScraper("http://kreestman.unomaha.community/hw3testpage/page1.html", 2);
		
		assertEquals("http://kreestman.unomaha.community/hw3testpage/page1.html",one.getURL());
		assertEquals(2, one.getDepth());
	}
	
	@Test
	public void testSpecificConstructorDepth() 
	{
		
		WebScraper one = new WebScraper("http://kreestman.unomaha.community/hw3testpage/page1.html", -2);
		
		assertEquals("http://kreestman.unomaha.community/hw3testpage/page1.html",one.getURL());
		assertEquals(0, one.getDepth());
	}
	
	@Test
	public void testSetDepth() 
	{
		
		WebScraper one = new WebScraper("http://kreestman.unomaha.community/hw3testpage/page1.html", 2);
		
		one.setDepth(4);
		assertEquals(4, one.getDepth());
	}
	
	@Test
	public void testSetDepthInvalid() 
	{
		
		WebScraper one = new WebScraper("http://kreestman.unomaha.community/hw3testpage/page1.html", 2);
		
		one.setDepth(-2);
		assertEquals(0, one.getDepth());
	}
	
	
	@Test
	public void testSetURL()
	{
		
		WebScraper one = new WebScraper("http://kreestman.unomaha.community/hw3testpage/page1.html", 2);
		
		one.setURL("http://kreestman.unomaha.community/hw3testpage/page2.html");
		assertEquals("http://kreestman.unomaha.community/hw3testpage/page2.html",
				one.getURL());
	}
	
	@Test
	public void testGetImages()
	{
		
		WebScraper one = new WebScraper("http://kreestman.unomaha.community/hw3testpage/page1.html", 2);
		
		
		assertEquals("http://kreestman.unomaha.community/hw3testpage/imgs/brodieBolt.jpg",
				one.getImages().getAllResults()[0].toString());
		
	
	}
	
	@Test
	public void testCrawlPage()
	{
		
		WebScraper one = new WebScraper("http://kreestman.unomaha.community/hw3testpage/page1.html", 2);
		
		
		assertEquals("http://kreestman.unomaha.community/hw3testpage/imgs/Palm_Tree_Emoji_42x42.png",
				one.crawlPage().getAllResults()[2].toString());
	
	}
	
	@Test
	public void testCrawlPageZero()
	{
		
		WebScraper one = new WebScraper("http://kreestman.unomaha.community/hw3testpage/page1.html", 0);
		
		
		assertEquals("http://kreestman.unomaha.community/hw3testpage/imgs/logo_uno.png",
				one.crawlPage().getAllResults()[1].toString());
	
	}
	
	@Test
	public void testPageHistory()
	{
		
		WebScraper one = new WebScraper("http://kreestman.unomaha.community/hw3testpage/page1.html", 2);
		
		one.crawlPage();
		
		assertEquals("http://kreestman.unomaha.community/hw3testpage/page2.html",
				one.getPageHistory().getHistory()[1]);
		
		
		
	
	}
	
	
}
