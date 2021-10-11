/*
   Author: Kevin Valencia
   Date: 5/17/2021
   Rev: 03
   Notes: Paddle class has the methods that calculate what happens when the Paddle moves up or down
   Stores the y value of the paddle and draws the paddle itself.
*/

import java.awt.Rectangle;

public class Paddle 
{
	
	// Fields
	private Rectangle paddle;
	private int x, y;
	private final int WIDTH = 10;
	private final int HEIGHT = 50;
	
	// Constructor
	public Paddle(int x, int y)
	{
		
			this.x=x;
			this.y=y;
		 paddle = new Rectangle(x,y,10,50);
	
	}
	
	// Methods
	// Returns the y value of the paddle
	public int getY()
	{
		return y;
	}
	
	// Returns the x value of the Paddle
	public int getX()
	{
		return x;
	}
	
	// Returns the Width of the Paddle
	public int getWidth()
	{
		return WIDTH;
	}
	
	// Returns the Height of the Paddle
	public int getHeight()
	{
		return HEIGHT;
	}
	
	// Moves the paddle up
	public void moveUp(int direction) 
	{
	if (y > 0 && y < 430)
	{
		y -= direction;	
	}
	}
	
	// Moves the paddle down
	public void moveDown(int direction) {
		if (y >= -5 && y < 395)
		{
			y += direction;
		}
	}
	
	// Gets the bounds of the Paddle
	public Rectangle getBounds() {
	    return new Rectangle(0, y, WIDTH, HEIGHT);
	    }

}