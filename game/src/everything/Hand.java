//Hand class
//by Christophe Bedu (cbedu2@uic.edu)
//This class is responsible for maintaining the Card list that player can
//can use in Battle

package everything;

import java.util.ArrayList;


public class Hand{
	private static int maxCards=5;
	private int handSize;
	protected ArrayList<Card> hand;
			
	protected Hand(){
		hand = new ArrayList<Card>();
		handSize=0;
	}
	
	
	
    protected void addCard(Card newCard){
    	
    	if(handSize>=maxCards){
    		
    		System.out.println("Error: maximum number of cards reached");
    		System.out.println("Abort addCard");
    		return;
    	}
    	
    	hand.add(newCard);
    }
    
    protected void removeCard(Card removedCard){
    	if(!hand.contains(removedCard)){
    		System.out.println("Error: this Card does not exist in this Hand");
    	}
    	
    	hand.remove(removedCard);
    }
    
    
    protected boolean contains(Card card){
    		return hand.contains(card);
    }
}