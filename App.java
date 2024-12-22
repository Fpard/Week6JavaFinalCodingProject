package week06JavaFinalProj;

import java.util.Scanner;

public class App {

	/* An automated version of the classic card game WAR, using classes and objects.
	 * 
	 * This app uses three other classes to help conduct the game: Card, DECK, and Player.
	 * 
	 * Deck keeps track of all the cards, shuffles, draws and describes them. 
	 * 
	 * Card knows its name, suit, value. It is part of the deck and dealt hand.  
	 * 
	 * Player requests draws from the deck, flips its hand and keeps score.
	 * 
	 * 
	 * 
	 * 
	 */
	
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		
			boolean play = true;
			String keepGoing = null;
			
			while (play) {
			 Deck aDeck = new Deck();
			 Player player1 = new Player("Player_1");
			 Player player2 = new Player("Player_2");
			 aDeck.shuffle();
			 
			 int numCards = aDeck.getCards().size();
			 
			 //******************************************GAME BEGINS*****************************
			 
			 // The following for...loop deals the players' hands.
			 for (int i = 0; i < numCards; i++) {
				if (i % 2 == 0 ) {
				  player1.getHand().add(player1.draw(aDeck));
				 
			   } else {
				   
				   player2.getHand().add(player2.draw(aDeck));
			   }

		    }//END FOR
			 
			//Each player flips their hands in turn and keeps scores.		
			for (int i = 0; i < 26; i++) {
				
				System.out.println("\nTurn : " + (i+1) + " Scores: \n");
			   int player1CardValue = player1.flip().getValue();
			   int player2CardValue = player2.flip().getValue();
			   
			   System.out.println(player1.getName() + ": " + player1CardValue + " / " + player2.getName()  +  ": " + player2CardValue);
			
				if (player1CardValue > player2CardValue ) {	
					player1.incrementScore();
					
				}
				else /*if (player1.flip().getValue() < player2.flip().getValue()){*/
					
					if (player1CardValue < player2CardValue ) {
						
					player2.incrementScore();
				} else {
					System.out.println("\nIt's a tie. No point was awarded");
				}
				
				
			} //END FOR
			
			//****************************************PRINTING THE SCORES**AT THE END OF THE GAME***************************************************
			System.out.println();
			if (player1.getScore() > player2.getScore()) {
				
				System.out.println("Final Scores: "+ player1.getName()+ " " + player1.getScore() + " / " + player2.getName()  + " " +player2.getScore() +": " +   player1.getName() + " is the winner");
				
			} else if (player1.getScore() < player2.getScore()) {
				
				System.out.println("Final Scores: "+ player1.getName()+ " " + player1.getScore() + " / " +  player2.getName()  + " " +player2.getScore() +": " +   player2.getName() + " is the winner");
			} else {
				
				System.out.println("Final Scores: " + player1.getName() + " " +  player1.getScore() + " / " + player2.getName( ) + " "+ player2.getScore() +": it's a draw.");
			}
			
			System.out.println();
			System.out.println("How about another one? Enter yes (y) or no (n)");
			
			  	      
		      keepGoing = in.nextLine();
		      if (keepGoing.charAt(0) == ('y') ) {
		    	  play = true;
		    	  	    	  
		      } else {
		    	   play = false;
		    	   in.close();
		      }
		}//END WHILE

	}//END MAIN

}
