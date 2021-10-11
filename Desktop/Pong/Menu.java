/*
   Author: Leor Porat
   Date: 5/17/2021
   Rev: 03
   Notes: Menu class is where the window is created as well as where the Pong game happens. 
   Methods include keeping track of the score and always checking for keyboard inputs. 
   Objects are created here, will create paddle object and ball object.
*/

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.Scanner;

public class Menu extends JPanel implements KeyListener{
	
	// Fields
	private String choice;
	private Paddle p1;
	private Paddle p2;
	public int y1, y;
	private Ball pongBall;
	public int scoreOne, scoreTwo;
	private Scoreboard panel;
	public String scoreOneText, scoreTwoText;
	private boolean sPressed, wPressed, upPressed, downPressed;
	public static final int MENU_WIDTH = 640;
	public static final int MENU_HEIGHT = 480;
	private boolean endCheck;
	
	// Constructor
	public Menu() {
		super();
		
		p1 = new Paddle(0, 0);
		p2 = new Paddle(MENU_WIDTH - 25, 0);
		pongBall = new Ball(scoreOne, scoreTwo);
		panel = new Scoreboard();
		
		setBackground(Color.BLACK); // Changes the color of the background
	}
	
	// Methods
	// Draws the various objects inside the game
	public void paintComponent(Graphics g)
	  {
	      super.paintComponent(g); 
	  
	      g.setColor(Color.WHITE);
	      
	      Font font = new Font("IMPACT", Font.BOLD, 40);
	      g.setFont(font);
	      
	      //Makes text for score
	      scoreOneText = String.valueOf(scoreOne);
	      scoreTwoText = String.valueOf(scoreTwo);
	      
	      //Draws score
	      g.drawString(scoreOneText,150, 40);
	      g.drawString(scoreTwoText,450, 40);
	      
	      //Draws ball
	      g.fillOval(pongBall.getX(), pongBall.getY(), 20, 20);
			pongBall.update();
			
			//Draws both paddles
	      g.fillRect(0, y, 10, 50);
	      g.fillRect(MENU_WIDTH - 25, y1, 10, 50);
	  
	  }
	
	// Gets the scoreboard of player 1
	public int getScoreBoard()
	{
		return scoreOne;
	}
	
	// Gets the scoreboard of player 2
	public int getScoreBoard2()
	{
		return scoreTwo;
	}
	
	// Refreshes the pong game so it can update
	public void refresh() {
	
		while (endCheck != true)
		{
		// Press "w", left paddle goes up
		if (wPressed == true)
		{
			this.p1.moveUp(5);
		}
		// Press "s", left paddle goes down
		if (sPressed == true)
		{
			this.p1.moveDown(5);
		}	
		// Press "upArrow", right paddle goes up
		if (upPressed == true)
		{
			this.p2.moveUp(5);
		}
		// Press "downArrow", right paddle goes down
		if (downPressed == true)
		{
			this.p2.moveDown(5);
		}
			
		//Get y-values of paddles
		 y = p1.getY();
		 y1 = p2.getY();
		 
		 //Get scores from ball
		scoreOne = pongBall.getScoreOne();
		scoreTwo = pongBall.getScoreTwo();
		
		//Check for collisions
		pongBall.checkRightPaddleCollision(p2);
		pongBall.checkLeftPaddleCollision(p1);
		pongBall.checkWindowCollision();
		 
		// Repaints the frame
		repaint();
		
		if (scoreOne == 10 || scoreTwo == 10)
		{
		
	    	//Print winner
			panel.endGame(scoreOne, scoreTwo);
			
			//Reset location to default
			pongBall.setYLocation(240);
    		pongBall.setXLocation(320);
    		
    		//Pause ball
    		pongBall.setXSpeed(0);
			pongBall.setYSpeed(0);
			
			//Reset score
			pongBall.setScoreOne(0);
			pongBall.setScoreTwo(0);

			//Checks if game has ended
			endCheck = panel.endGameCheck(scoreOne, scoreTwo);
			
			System.out.println("\n Play again? Y/N");
			
			Scanner kboard = new Scanner(System.in);
	    	choice = kboard.next();
	    
	    	if (choice.equals("Y"))
	    	{
	    		// Reset speed to default
	    		pongBall.setYSpeed(5);
	    		pongBall.setXSpeed(2);
	    		
	    		// Change game back to running
	    		endCheck = false;
	    		System.out.println("Go to Window!");
	    		
	    	} else if (choice.equals("N")) 
	    	{
	    		System.out.println("Thanks for playing!");
	    		System.exit(0); // Quits game
	    	}
	    	
	    	//Wait a little bit
	    	try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//Wait some more
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
			}
		}
	}
	
	// Variables turn true when the keybinds are pressed
	public void keyPressed(KeyEvent e) 
	{
		if (e.getKeyCode() == KeyEvent.VK_W)
		{
			wPressed = true;
		}
		else if (e.getKeyCode() == KeyEvent.VK_S)
		{
			sPressed = true;
			
		}
		else if (e.getKeyCode() == KeyEvent.VK_UP)
		{
			upPressed = true;
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN)
		{
			downPressed = true;
		}
	}
	
	// When the keybinds are released the variables turn false
	public void keyReleased(KeyEvent e) {
		 if (e.getKeyCode() == KeyEvent.VK_W) {
				wPressed = false;
		  	} else if (e.getKeyCode() == KeyEvent.VK_S) {
		  		sPressed = false;
		  	}
		  	else if (e.getKeyCode() == KeyEvent.VK_UP)
			{
				upPressed = false;
			}
			else if (e.getKeyCode() == KeyEvent.VK_DOWN)
			{
				downPressed = false;
			}
	}
	
	// Part of the Keylistener, checks for a key typed
	public void keyTyped(KeyEvent e) {
	  	
		}
	
	// Main method
	public static void main(String[] args) {
		
		Menu panelGame = new Menu ();
	    JFrame w = new JFrame("Pong");
	 
	    w.setBounds(100, 100, 640, 480);
	    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    w.addKeyListener(panelGame);
	    w.add(panelGame);
	    w.setResizable(false);
	    w.setVisible(true);
	    
	    panelGame.refresh();
	}

}