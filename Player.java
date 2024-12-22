package week06JavaFinalProj;

import java.util.ArrayList;
import java.util.List;


public class Player {
 
	private List<Card> hand = new ArrayList<Card>(); // Keeps hand in a List
	private int score;
	private String name;
	
	//default constructor
	public Player() {
		
		score = 0;
	}
	
	
	public Player(String name) {
		
		this.name = name;
		score = 0;
	}
	
	public List<Card> getHand() {
		return hand;
	}


	public void setHand(List<Card> hand) {
		this.hand = hand;
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	
	
	public void describe() {
		
		System.out.println(" Player Name: " + name);
		System.out.println(name +"\'s Hand");
		for (Card eachCard: hand) {
			
			eachCard.describe();
		}
	}
		
	public Card flip() {
		
        Card aCard = this.hand.remove(0); //Using the remove method of the ArrayList.
		
		return aCard;
	}
		
    public Card draw(Deck aDeck) {
		
		Card aCard = aDeck.draw();
		
		return aCard;
	}
    
    public void incrementScore() {
    	
    	score ++;
    	
    }
}

