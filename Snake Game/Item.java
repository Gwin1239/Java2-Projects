// COURSE: CSCI1620
// TERM: FALL 2020
// 
// NAME: Godwin Djossou
// RESOURCES: CSLC, Edward

package snake;


/**
 * This class creates the Item object that will be used in the Snake game.
 * @author gdjossou
 */
public class Item
{
	/**
	 * Integer that indicates the X value of the Item.
	 */
	private int xCoord;
	/**
	 * Integer that indicates the Y value of the Item.
	 */
	private int yCoord;
	/**
	 * Integer that indicates the default X and Y values.
	 */
	private final int position = 25;
	
	/**
	 * The default constructor for an Item.
	 * It sets the default location of the Item at position 25,25.
	 */
	public Item()
	{
		this.xCoord = position;
		this.yCoord = position;
	}
	
	/**
	 * The specific constructor for an Item.
	 * It sets the location of the Item using the passed in parameters.
	 * @param itemXIn the supposed starting X value for the Item..
	 * @param itemYIn the supposed starting Y value for the Item..
	 */
	public Item(int itemXIn, int itemYIn)
	{
		this.xCoord = itemXIn;
		this.yCoord = itemYIn;
	}
	
	/**
	 * Returns the current X value for the Item.
	 * @return The current X value for the Item.
	 */
	public int getX()
	{
		return this.xCoord;
	}
	
	/**
	 * Returns the current Y value for the Item.
	 * @return The current Y value for the Item.
	 */
	public int getY() 
	{
		return this.yCoord;
	}
	
	/**
	 * Sets a new location for the item as long as both values are valid (>=0).
	 * @param itemXIn the supposed new X value for the Item.
	 * @param itemYIn the supposed new Y value for the Item.
	 */
	public void setNewLocation(int itemXIn, int itemYIn)
	{
		if (itemXIn >= 0 && itemYIn >= 0)
		{
			this.xCoord = itemXIn;
			this.yCoord = itemYIn;
		}
	}
	
	/**
	 * Returns a String representing the item.
	 * @Override toString in class java.lang.Object.
	 * @return The String representation of the Item where X and Y are the item's X and Y values respectively.
	 * e.g. The item is located at position (X, Y).
	 */
	@Override
	public java.lang.String toString()
	{
		return String.format("The item is located at position (%d, %d)", this.xCoord, this.yCoord);
	}
	
}
