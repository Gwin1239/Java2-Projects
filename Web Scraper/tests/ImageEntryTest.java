package scraper.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import scraper.base.ImageEntry;
import scraper.utils.ResultSet;



public class ImageEntryTest {

	@Test
	public void testConstructor() 
	{
		
		ImageEntry one = new ImageEntry("http://kreestman.unomaha.community/hw3testpage/page1.html",
				"http://kreestman.unomaha.community/hw3testpage/imgs/logo_uno.png");
		
		assertEquals("http://kreestman.unomaha.community/hw3testpage/page1.html",
				one.getPageLocation());
		
		assertEquals("http://kreestman.unomaha.community/hw3testpage/imgs/logo_uno.png",
				one.getImgLocation());
		
	}

	
	@Test
	public void testEquals() 
	{
		
		ImageEntry one = new ImageEntry("http://kreestman.unomaha.community/hw3testpage/page1.html",
				"http://kreestman.unomaha.community/hw3testpage/imgs/logo_uno.png");
		
		ImageEntry two = new ImageEntry("http://kreestman.unomaha.community/hw3testpage/page1.html",
				"http://kreestman.unomaha.community/hw3testpage/imgs/logo_uno.png");
		
		assertEquals(true, one.equals(two));
		
	}
	
	@Test
	public void testEqualsIMG() 
	{
		
		ImageEntry one = new ImageEntry("http://kreestman.unomaha.community/hw3testpage/page1.html",
				"http://kreestman.unomaha.community/hw3testpage/imgs/logo_uno.png");
		
		ImageEntry two = new ImageEntry("http://kreestman.unomaha.community/hw3testpage/page2.html",
				"http://kreestman.unomaha.community/hw3testpage/imgs/logo_uno.png");
		
		assertEquals(true, one.equals(two));
		
	}
	
	
	@Test
	public void testEqualsInstance() 
	{
		
		ImageEntry one = new ImageEntry("http://kreestman.unomaha.community/hw3testpage/page1.html",
				"http://kreestman.unomaha.community/hw3testpage/imgs/logo_uno.png");
		
		ResultSet two = new ResultSet();
		
		assertEquals(false, one.equals(two));
		
	}
	
	@Test
	public void testEqualsFalse() 
	{
		
		ImageEntry one = new ImageEntry("http://kreestman.unomaha.community/hw3testpage/page1.html",
				"http://kreestman.unomaha.community/hw3testpage/imgs/logo_uno.png");
		
		ImageEntry two = new ImageEntry("http://kreestman.unomaha.community/hw3testpage/page2.html",
				"http://kreestman.unomaha.community/hw3testpage/imgs/brodieBolt.jpg");
		
		assertEquals(false, one.equals(two));
		
	}
	
	
	@Test
	public void testToString() 
	{
		
		ImageEntry one = new ImageEntry("http://kreestman.unomaha.community/hw3testpage/page1.html",
				"http://kreestman.unomaha.community/hw3testpage/imgs/logo_uno.png");
		
		assertEquals("http://kreestman.unomaha.community/hw3testpage/imgs/logo_uno.png",
				one.toString());
		
	}
	
	
	
}
