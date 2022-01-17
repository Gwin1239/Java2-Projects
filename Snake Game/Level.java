// COURSE: CSCI1620
// TERM: Fall 2020
// 
// NAME: Godwin Djossou
// RESOURCES: CSLC, Edward


package snake;

//import java.util.Random;

/**
 * This class defines the Level for use in the Snake game.
 * It will control major portions of the game like updating the 
 * Snake and Item positions and determining when the game has been lost.
 * @author gdjossou
 */
public class Level
{
	/**
	 * Integer that indicates the width of the level.
	 */
	private int levelWidth;
	/**
	 * Integer that indicates the height of the level.
	 */
	private int levelHeight;
	/**
	 * Integer that indicates the Y value of the Snake.
	 */
	private java.util.Random levelRand;
	/**
	 * GameState that indicates if the game is playing or is lost.
	 */
	private GameState firstGameState;
	/**
	 * Integer array that contains the position of the level.
	 */
	private int[][] levelArr;
	/**
	 * Item object that creates a new Item.
	 */
	private Item firstItem;
	/**
	 * Item object that creates a new Snake.
	 */
	private Snake firstSnake;
	
	/**
	 * Creates a default level with a given dimension.
	 * The map should use the given height and width values as its dimensions.
	 * The Snake and Item should be be the default version of themselves.
	 * The Random object passed in should be used in creation of new positions for the Item.
	 * The GameState should initially be PLAYING.
	 * @param widthIn The logical width of the new level.
	 * @param heightIn The logical height of the new level.
	 * @param randIn The Random object that will be used to generate new Item locations.
	 */
	public Level(int widthIn, int heightIn, java.util.Random randIn)
	{
		this.levelWidth = widthIn;
		this.levelHeight = heightIn;
		levelArr = new int[levelHeight][levelWidth];
		this.firstSnake = new Snake();
		this.firstItem = new Item();
		this.levelRand = randIn;
		this.firstGameState = GameState.PLAYING;
	}

	/**
	 * Updates a single step. 
	 * The algorithm you use should go as follows:
	 * 1) Move the Snake in its current direction
	 * 2) Determine if a losing condition has been met (the Snake hitting itself or a wall)
	 * 3) Determine if the Item has been grabbed by the Snake. 
	 * If it has, generate the new position for the Item. 
	 * If the position generated is currently being occupied by the Snake,
	 * regenerate another position and check again. 
	 * Do this until a valid position has been found.
	 * If the Item was grabbed, be sure to increase the length of the Snake as well.
	 */
	public void updateOneStep()
	{
		
		firstSnake.move();
		if (firstSnake.hitSelf())
		{
			this.firstGameState = GameState.LOST;
		}
		
		if (firstSnake.getHeadX() < 0 || firstSnake.getHeadX() > levelWidth - 1 
				|| firstSnake.getHeadY() < 0 || firstSnake.getHeadY() > levelHeight - 1) 
		{
			this.firstGameState = GameState.LOST;
		}
		
		if (firstSnake.getSnake()[0][0] == firstItem.getX() && firstSnake.getSnake()[0][1] == firstItem.getY())
		{
			firstSnake.increaseLength();
			firstItem.setNewLocation(levelRand.nextInt(levelWidth), levelRand.nextInt(levelHeight));
			//add while loop here, flag, boolean
			boolean itemOnSnake = false;
			
			for (int i = 0; i < this.firstSnake.getLength(); i++)
			{
				if (firstItem.getX() == firstSnake.getSnake()[i][0] 
						&& firstItem.getY() == firstSnake.getSnake()[i][1])
				{
					itemOnSnake = true;
				}
				
			}
			
			while (itemOnSnake)
			{
				firstItem.setNewLocation(levelRand.nextInt(levelWidth), levelRand.nextInt(levelHeight));
				for (int i = 0; i < this.firstSnake.getLength(); i++)
				{
					if (firstItem.getX() == firstSnake.getSnake()[i][0] 
							&& firstItem.getY() == firstSnake.getSnake()[i][1])
					{
						itemOnSnake = true;
					}
					else
					{
						itemOnSnake = false;
						
					}
				}
				
			}
			
			
		}
		
		
	}	
		
	/**
	 * Generates the 2-dimensional map of the game area.
	 * Please read the supplemental document on the differences 
	 * between how the game map should look vs the Snake.
	 * The following pattern should be used for the map:
	 * If the space is open, place a 0 in that place in the map
	 * If the space is occupied by the Snake, place a 1 in that place in the map
	 * If the space is occupied by the Item, place a -1 in that place in the map
	 */
	public void generateMap()
	{
		for (int i = 0; i < levelHeight; i++)
		{
			for (int j = 0; j < levelWidth; j++)
			{
				levelArr[i][j] = 0;
			}
		}
		
		
		for (int i = 0; i < firstSnake.getLength(); i++)
		{
			int x = firstSnake.getSnake()[i][0];
			int y = firstSnake.getSnake()[i][1];
			levelArr[y][x] = 1;
			
		}
		
		levelArr[firstItem.getY()][firstItem.getX()] = -1;
		
	
	}
		
	
	/**
	 * Returns the current Item.
	 * @return the current Item.
	 */
	public Item getItem()
	{
		return this.firstItem;
	}
	
	/**
	 * Returns the current Snake.
	 * @return the current Snake.
	 */
	public Snake getSnake()
	{
		return this.firstSnake;
	}
	
	/**
	 * Returns the current 2d array map.
	 * @return the current 2d array map.
	 */
	public int[][] getMap() 
	{
		return this.levelArr;
	}
	
	/**
	 * Returns the current GameState.
	 * @return the current GameState.
	 */
	public GameState getGameState()
	{
		return this.firstGameState;
	}
	
}
