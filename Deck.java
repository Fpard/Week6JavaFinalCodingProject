package week06JavaFinalProj;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Deck {
	
		
		private List <Card> cards = new ArrayList<Card>();
		
		public Deck() {
		
			String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
			
			String[] numbers = {"Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
			
			//This for...loop builds each card in the deck.	
			for (String suit: suits) {
				   int value = 2;
				      for (String number: numbers) {
					
					Card card = new Card(number, suit, value);
					cards.add(card);
					value++;
				}
				
			}
		}

		public List<Card> getCards() {
			return cards;
		}

		public void setCards(List<Card> cards) {
			this.cards = cards;
		}
		
		public void describe(){
			
			Iterator<Card> itr = cards.iterator(); 
			
			 while (itr.hasNext()){
				((Card) itr.next()).describe();
			 }
		}
		
		public void shuffle() {
			
			
			Random randomCard = new Random();
			int n = cards.size();
			System.out.println("Number of cards: "+ n);
			
			   for(int i = n-1; i >= 1; i--) {
			     
			     int randomIndex =  randomCard.nextInt(i+1);
				
			     // Swap with deck[i]
			     Card temp = new Card(cards.get(randomIndex));
			     cards.set(randomIndex, cards.get(i));
			     cards.set(i, temp); 
			     
			   }
			}
		
			
		public Card draw() {
			
			Card aCard = this.cards.remove(0); //Using the remove method of the ArrayList.
			
			return aCard;
		}
		
	
}
