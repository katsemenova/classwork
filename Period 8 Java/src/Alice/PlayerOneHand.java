package Alice;

import java.util.ArrayList;

public class Player {

	private ArrayList<Card> inHand; //will work once card class is made, "Card" change depends on what the card class is actually called
	
	private String name;
	
	public Player(String name) {
		this.name = name;
		inHand = new ArrayList<Card>();
		for(int i=0; i<5; i++){
			int deckLength = deck.size();
			//this selects a random card from deck pile in begining
			//then when selected it also *removes it* very helpful 
			inHand.add(deck.remove((Math.random()*deckLength)));
			//NOTE deck has to be replaced by the getter for deck or the variable name!
		}
	}
	
	public void addCardtoHand(Card c){
		if(inHand.size() < 5)
			inHand.add(c);
	}
	
	public void removeCardfromHand(Card c){
		if(inHand.size()>0 && inHand.contains(c)) //makes sure you dont remove if hand is empty and if the card is even in the hand
			inHand.remove(c);
	}
	
	public ArrayList<Card> getInHand(){
		return inHand;
	}
	
	public String getName(){
		return name;
	}
}
