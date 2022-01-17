// COURSE: CSCI1620
// TERM: FALL 2020
// 
// NAME: Godwin Djossou
// RESOURCES: CSLC, Edward

package snake;

/**
 * This class defines the Snake object for use in the Snake game.
 * @author gdjossou
 */
public class Snake
{
	/**
	 * Integer that indicates the X value of the Snake.
	 */
	private int placeX;
	/**
	 * Integer that indicates the Y value of the Snake.
	 */
	private int placeY;
	/**
	 * Integer that indicates the value of the Snake.
	 */
	private int snakeLength;
	/**
	 * Integer array that contains the snake's position.
	 */
	private int[][] snakeArr;
	/**
	 * Direction that indicates the direction of the Snake.
	 */
	private Direction firstDirection;
	/**
	 * Integer that indicates the default value of the X and Y positions of the Snake.
	 */
	private final int startVal = 20;
	/**
	 * Integer that indicates the maximum value of the Snake array.
	 */
	private final int maxVal = 5000;
	
	/**
	 * The default constructor for the Snake. 
	 * It should do the same as the specific constructor except that 
	 * it will use the value of 20 as the Default value for both the 
	 * X and Y values for the head as the parameters.
	 */
	public Snake()
	{
		this.placeX = startVal;
		this.placeY = startVal;
		this.snakeArr = new int[maxVal][2];
		this.snakeLength = 4;
		this.firstDirection = Direction.DOWN;
		
		snakeArr[0][0] = placeX;
		snakeArr[0][1] = placeY;
		
		for (int i = 1; i <= 3; i++)
		{
			
			snakeArr[i][0] = placeX;
			snakeArr[i][1] = snakeArr[i - 1][1] - 1;
			
			/*if (placeY > 0)
			{
				this.placeY++;
			}
			else if (placeX > 0)
			{
				this.placeX--;
			}
			else 
			{
				this.placeY--;
			}*/
			
		}
	}
	
	/**
	 * The specific constructor for the Snake.
	 * The snake 2d array should be initialized with a size of [5000][2].
	 * The snake should have its head's X and Y values set.
	 * The snake should then form out of the head to an initial length of 4.
	 * When forming out, this is the order that it should expand:
	 * 1) Above the head; if no space to continue doing so
	 * 2) Left of the head; if no space to continue doing so
	 * 3) Below the headWe will not place the initial Snake too close to the 
	 * top left corner so that it cannot grow to its initial size.
	 * The initial direction of the snake should be DOWN.
	 * @param headXIn  the initial X value for the head of the Snake.
	 * @param headYIn  the initial Y value for the head of the Snake.
	 */
	public Snake(int headXIn, int headYIn)
	{
		this.snakeArr = new int[maxVal][2];
		this.placeX = headXIn;
		this.placeY = headYIn;
		this.snakeLength = 4;
		this.firstDirection = Direction.DOWN;
		
		snakeArr[0][0] = headXIn;
		snakeArr[0][1] = headYIn;
		
		for (int i = 1; i <= snakeLength - 1; i++)
		{
			
			snakeArr[i][0] = placeX;
			snakeArr[i][1] = snakeArr[i - 1][1] - 1;
			
			
				
		}
	}
	
	/**
	 * Returns the current X value for the head of the Snake.
	 * @return the current X value for the head of the Snake.
	 */
	public int getHeadX() 
	{
		return this.snakeArr[0][0];
	}
	
	/**
	 * Returns the current Y value for the head of the Snake.
	 * @return the current Y value for the head of the Snake.
	 */
	public int getHeadY()
	{
		return this.snakeArr[0][1];
	}
	
	/**
	 * The move method should move the Snake forward one space in the current Direction.
	 * HINT: Only the head will be in a "new" position, 
	 * the rest will continue to follow the further up portions of the snake body.
	 */
	public void move()
	{
		for (int i = snakeLength - 1; i >= 1; i--)
		{
			snakeArr[i][0] = snakeArr[i - 1][0];
			snakeArr[i][1] = snakeArr[i - 1][1];
		}
		
		if (firstDirection == Direction.DOWN)
		{
			this.snakeArr[0][1]++;
		}
		
		if (firstDirection == Direction.UP)
		{
			this.snakeArr[0][1]--;
		}
		
		if (firstDirection == Direction.LEFT)
		{
			this.snakeArr[0][0]--;
		}
		
		if (firstDirection == Direction.RIGHT)
		{
			this.snakeArr[0][0]++;
		}
	}
	
	/**
	 * Determines if the head of the Snake has hit another part of the Snake.
	 * @return true if the Snake hit itself.
	 */
	public boolean hitSelf()
	{
		
		boolean a = false;
		for (int i = 1; i < this.snakeLength; i++) 
		{
			if (snakeArr[0][0] == snakeArr[i][0] && snakeArr[0][1] == snakeArr[i][1]) 
			{
				a = true;
				break;
			}
				
			
		}
			
		return a;	
	}
	
	/**
	 * Changes the Direction of the Snake, 
	 * except if the new Direction is directly opposite of the current one.
	 * @param dirIn the Direction that the Snake is trying to change to be facing
	 */
	public void changeDir(Direction dirIn)
	{
		if (firstDirection == Direction.UP)
		{
			if (dirIn != Direction.DOWN)
			{
				this.firstDirection = dirIn;
			}
		}
		
		if (firstDirection == Direction.DOWN)
		{
			if (dirIn != Direction.UP)
			{
				this.firstDirection = dirIn;
			}
		}
		
		if (firstDirection == Direction.LEFT)
		{
			if (dirIn != Direction.RIGHT)
			{
				this.firstDirection = dirIn;
			}
		}
		
		if (firstDirection == Direction.RIGHT)
		{
			if (dirIn != Direction.LEFT)
			{
				this.firstDirection = dirIn;
			}
		}
	}
	
	/**
	 * The current Direction of the Snake.
	 * @return the current Direction of the Snake
	 */
	public Direction getDirection()
	{
		return this.firstDirection;
	}
	
	/**
	 * The current length value of the Snake.
	 * @return the current length value of the Snake
	 */
	public int getLength()
	{
		return this.snakeLength;
	}
	
	/**
	 * Returns the current Snake 2d array.
	 * @return the current Snake 2d array.
	 */
	public int[][] getSnake()
	{
		return this.snakeArr;
	}
	
	/**
	 * Increases the current length of the Snake by 1 and grows the snake.
	 * This means that it also sets the newly added part of the 
	 * tail (n) to the value of the previous tail (n-1) values in the Snake.
	 */
	public void increaseLength()
	{
		snakeArr[snakeLength][0] = snakeArr[snakeLength - 1][0];
		snakeArr[snakeLength][1] = snakeArr[snakeLength - 1][1];
		snakeLength++;
	}
	
}
