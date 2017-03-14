/**
 * Created by Steve on 3/5/2017.
 * Edited by Christophe Bedu(cbedu2@uic.edu)
 */

package everything;

import java.util.ArrayList;

import everything.Card;
import everything.cardPackage.SavageStrike;

public class Deck {
	protected static int maxCards =25;
    protected ArrayList<Card> deck;
    protected Hand hand;
    protected int deckLength;

    public Deck() {
        deckLength = 0;
        deck = new ArrayList<Card>();
    }
    
    public void addCard(Card newCard){
    	
    	if(maxCards==24){
    		
    		System.out.println("Error: maximum number of cards reached!");
    		System.out.println("Abort addCard");
    		return;
    	}
    	deckLength++;
    	
    	deck.add(newCard);
    }
    
    public void discard(Card removedCard){
    	if(hand.contains(removedCard)){
    		System.out.println("Error: cannot remove Card while it's in Hand!");
    		return;
    	}
    	
    	deck.remove(removedCard);
    	
    }
    
    public int getCardIndex(Card card){
    	
    	if(!deck.contains(card)){
    		return -1;
    	}
    	
    	return(deck.indexOf(card));
    }
    
    
   
    public void changeCard(Card oldCard, Card newCard)
    {
    	if(!deck.contains(oldCard)){
    		System.out.println("Error: This card is not Available in deck");
    		return;
    	}
    	
    	deck.remove(oldCard);
    	deck.add(newCard);
    }


  
	public void updateCooldowns(Player p1){
        for(int i = 0; i < deckLength; i++)
        {
        	deck.get(i).incrementCooldown(p1);
        }
    }
	
	public void chooseCards(){
		System.out.println("User has choosen default 5 cards");
	}
}
