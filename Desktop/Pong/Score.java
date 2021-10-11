/*
Authors: Leor Porat, Kevin Valencia, Justin Navarro
Date: 5/17/2021
Rev: 01
Notes: This class contains the score and ending conditions for the game. It also contains the printWinner method which prints who won to the console.
*/

public class Score {

	// Fields
	public final static int ENDING_SCORE = 10;
	public String endingString = "";
	public boolean endCheck = false;
	public String scoreOneText;
	public String scoreTwoText;
	
	// Constructor
	public Score() {
		
	}
	
	// Methods
	// Checks to see if the game should end, if so, runs printWinner
	public void endGame(int firstScore, int secondScore) 
	{
		
		printWinner(firstScore, secondScore);
	
	}
	
	// Prints out the winner of the game based on the player that reaches 10 points first
	public void printWinner(int firstScore, int secondScore)
	{
		if (firstScore == 10)
		{
			System.out.println("Player 1 has won, with " + firstScore + " points!");	
		}
		else if (secondScore == 10)
		{
			System.out.println("Player 2 has won, with " + secondScore + " points!");
		}
	}

	// Checks if the score is the ending score, returns true if true
	public boolean endGameCheck(int firstScore, int secondScore) {
		if (firstScore == 2 || secondScore == 2) {	
			endCheck = true;
		}
		return endCheck;
	} 
}