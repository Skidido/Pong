/* 
Author: Leor Porat, Kevin Valencia, Justin Navarro
Date: 5/20/2021
Rev: 02
Notes: The Scoreboard class IS-A Score, and implements methods from the Score class. Credits to Jay Paek for helping us out so much
*/

public class Scoreboard extends Score {
	
	// Fields
	private Score score;
	
	// Constructor
	public Scoreboard () {
		score = new Score();
	}
	
	// Methods
	// Calls the printWinner method on the jayScore object
	public void endGame(int firstScore, int secondScore)
	{
		score.printWinner(firstScore, secondScore);
		
	}
	
	// Calls the endGameCheck method on jayScore, seeing if the game should be over
	public void endCheck(int firstScore, int secondScore)
	{
		score.endGameCheck(firstScore, secondScore);
	}
}