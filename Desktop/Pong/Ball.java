import java.util.Random;

/*
Author: Justin Navarro
Date: 5/17/2021
Rev: 03
Notes: This class represents a ball. It is the ball that will be flying around in the finished game.
*/

public class Ball {
	
	// Fields
	private int xSpeed = 2, ySpeed = 5;
	private int width = 20;
	private int radius = 10;
	private int locationX = 320;
	private int locationY = 240;
	public int scoreOne = 0;
	public int scoreTwo = 0;
	
	// Constructors
	public Ball (int scoreOne, int scoreTwo) {
		 this.scoreOne = scoreOne;
		 this.scoreTwo = scoreTwo;
	}
	
	// Methods
	// Checks the right paddle's collision when the balls hits the paddle
	public void checkRightPaddleCollision(Paddle player2)
	{
		int halfPaddleWidth2 = player2.getX() - player2.getWidth()/2;
		
		if (locationX + radius >= halfPaddleWidth2 && locationY - radius < player2.getY() + player2.getHeight()/2 && locationY - radius > player2.getY() - player2.getHeight()/2)
		{
			xSpeed *= -1.5;
		}
	}
	
	// Checks the left paddle's collision when the balls hits the paddle
	public void checkLeftPaddleCollision(Paddle player1)
	{
		int halfPaddleWidth1 = player1.getX()+ player1.getWidth()/2;
		
		if (locationX - radius < halfPaddleWidth1 && locationY - radius < player1.getY() + player1.getHeight()/2 && locationY + radius > player1.getY() - player1.getHeight()/2)
		{
			xSpeed *= -1.5;
		}
	}
	
	// Defines where the ball can and can't go based on size of the window
	public void checkWindowCollision() {
		
		// Reverse speed if hit top or bottom
		if (locationY < 0 || locationY > 415)
		{
			ySpeed *= -1;
		}
		
		//Check if hits left or right side of screen
		if (locationX < 0 || locationX > 640 - width)
		{
			Random random = new Random();
			int ran;
			int ranY;
			locationX = 320;
			locationY= 240;
			
			ran = random.nextInt(5) + 2;
			ySpeed = random.nextInt(5) + 5;
			ranY = random.nextInt(3) - 1;
			
			if (ran != 0)
			{
				xSpeed = ran;
			}
			if (ranY != 0)
			{
				ySpeed *= ranY;
			}
		}
	}
	
	// Gets the score of player 1
	public int getScoreTwo()
	{
		if (locationX < 0)
		{
		 scoreTwo++;
		 
		}
		return scoreTwo;
	}
	
	// Gets the score of player 
	public int getScoreOne()
	{
		if(locationX > 640 - width)
		{
		scoreOne++;
		
		}
		return scoreOne;
	}
	
	// Updates the ball location and movement whenever it collides
	public void update() {
		locationX += xSpeed;
		locationY += ySpeed;
	}
	
	// Returns X location of the ball
	public int getX() {
		return locationX;
	}
	
	// Returns Y location of the ball
	public int getY() {
		return locationY;
	}
	
	// Returns x-direction speed of the ball
	public int getXSpeed() {
		return xSpeed;
	}
	// Returns y-direction speed of the ball
	public int getYSpeed() {
		return ySpeed;
	}
	
	// Sets the y Speed
	public void setYSpeed (int speedY)
	{
		ySpeed = speedY;
	}
	
	// Sets the x Speed
	public void setXSpeed (int speedX)
	{
		xSpeed = speedX;
	}
	
	// Sets the x location of the Ball
	public void setXLocation (int x)
	{
		locationX = x;
	}
	
	// Sets the y location of the Ball
	public void setYLocation (int y)
	{
		locationY = y;
	}
	
	// Sets the score of Player 1
	public void setScoreOne(int x)
	{
		scoreOne = x;
	}
	
	// Sets the score of Player 2
	public void setScoreTwo(int y)
	{
		scoreTwo = y;
	}
}