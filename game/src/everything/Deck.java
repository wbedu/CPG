/**
 * Created by Steve on 3/5/2017.
 * Edited by Christophe Bedu(cbedu2@uic.edu)
 */

package everything;

import java.util.ArrayList;

import everything.Card;
import everything.cardPackage.SavageStrike;

public class Deck {
	private static int maxCards =25;
    private ArrayList<Card> deck;
    protected Hand hand;
    private int deckLength;

    protected Deck() {
        deckLength = 0;
        deck = new ArrayList<Card>();
    }
    
    protected void addCard(Card newCard){
    	
    	if(maxCards==24){
    		
    		System.out.println("Error: maximum number of cards reached!");
    		System.out.println("Abort addCard");
    		return;
    	}
    	deckLength++;
    	
    	deck.add(newCard);
    }
    
    protected void discard(Card removedCard){
    	if(hand.contains(removedCard)){
    		System.out.println("Error: cannot remove Card while it's in Hand!");
    		return;
    	}
    	
    	deck.remove(removedCard);
    	
    }
    
    protected int getCardIndex(Card card){
    	
    	if(!deck.contains(card)){
    		return -1;
    	}
    	
    	return(deck.indexOf(card));
    }
    
    
   
    protected void changeCard(Card oldCard, Card newCard)
    {
    	if(!deck.contains(oldCard)){
    		System.out.println("Error: This card is not Available in deck");
    		return;
    	}
    	
    	deck.remove(oldCard);
    	deck.add(newCard);
    }


  
	private void updateCooldowns(Player p1){
        for(int i = 0; i < deckLength; i++)
        {
        	deck.get(i).incrementCooldown(p1);
        }
    }
}
