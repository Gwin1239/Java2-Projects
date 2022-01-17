// COURSE: CSCI1620
// TERM: Fall 2020
// 
// NAME: Godwin Djossou
// RESOURCES: CSLC
package scraper.base;

/**
 * This class stores information about each image found while crawling pages. 
 * Image URLs are saved along with the URL for the page on which the image appears.
 * 
 * @author gdjossou
 */
public class ImageEntry 
{
	/**
	 * String for the page URL.
	 */
	private String pageUrl;
	
	/**
	 * String for image URL.
	 */
	private String imageUrl;
	
	/**
	 * Creates a new ImageEntry storing an image URL alongside the source page URL.
	 * @param pageAddress the URL for the page where the image was found
	 * @param imgAddress the full URL of the image itself
	 */
	public ImageEntry(java.lang.String pageAddress,
					java.lang.String imgAddress)
	{
		this.pageUrl = pageAddress;
		this.imageUrl = imgAddress;
	}
	
	/**
	 * Retrieves the source page URL.
	 * @return The web page where the image of this ImageEntry can be found.
	 */
	public java.lang.String getPageLocation()
	{
		return this.pageUrl;
	}
	
	/**
	 * Retrieves the direct image URL.
	 * @return The full URL of image file itself.
	 */
	public java.lang.String getImgLocation()
	{
		return this.imageUrl;
	}
	
	/**
	 * Compares this ImageEntry to another object for equality based on the URL of the image file.
	 * Two ImageEntries with the same image URL but different page URLs will be considered equivalent.
	 * @param other Object to compare to the ImageEntry.
	 * @return true if this ImageEntry and other refer to the same image as file on the Web; false otherwise.
	 */
	public boolean equals(java.lang.Object other)
	{
		boolean urls = false;
		if (other instanceof ImageEntry)
		{
			ImageEntry one = (ImageEntry) other;
			if (one.getImgLocation().equals(this.getImgLocation()))
			{
				urls = true;
			}
		}
		return urls;
	}
	
	/**
	 * Retrieves a String version of this ImageEntry. 
	 * The returned string should only contain the URL for the image file.
	 * @return the image file URL from this ImageEntry
	 */
	@Override
	public java.lang.String toString()
	{
		return this.imageUrl;
	}
	
}
