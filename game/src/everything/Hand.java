//Hand class
//by Christophe Bedu (cbedu2@uic.edu)
//This class is responsible for maintaining the Card list that player can
//can use in Battle

package everything;

import java.util.ArrayList;


public class Hand{
	private static int maxCards=5;
	private int handSize;
	protected ArrayList<Card> hand = new ArrayList<Card>();
	
	
	protected Hand(){
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
}