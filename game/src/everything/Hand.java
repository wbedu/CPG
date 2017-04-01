//Hand class
//by Christophe Bedu (cbedu2@uic.edu)
//This class is responsible for maintaining the Card list that player can
//can use in Battle

package everything;

import java.util.ArrayList;


public class Hand{
	private static int maxCards=5;
	protected ArrayList<Card> hand;
	protected ArrayList<Card> deck;	
	protected String lastCardText;
			
	protected Hand(){
		hand = new ArrayList<Card>();
		//TODO handSize=0;
	}
	
	
	
    protected void addCard(Card newCard){
    	
    	if(hand.size()>=maxCards){
    		
    		System.out.println("Error: maximum number of cards reached");
    		System.out.println("Abort addCard");
    		return;
    	}
  
    	//if(deck.contains(newCard)){
    	//	hand.add(newCard);
    	//}else{
    	//	deck.add(newCard);
    		hand.add(newCard);
    		
    		System.out.println("card add");
    	//}
    		
    
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
    
    
    public void useCard(int cardIndex, Player p1, Player p2){
    	
    	System.out.println("in useCard");
    	hand.get(cardIndex).cardFunction(p1, p2);	
    	decrementCooldown(p1);
    	
    	lastCardText=hand.get(cardIndex).getText();
    	
    }
    
    public void decrementCooldown(Player p1){
    	for(int i=0;i<hand.size();i++){
    		hand.get(i).decrementCooldown(p1);
    	}
    }
    
    public String getLastCardText(){
    	return lastCardText;
    }
}