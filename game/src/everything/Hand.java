//Hand class
//by Christophe Bedu (cbedu2@uic.edu)
//This class is responsible for maintaining the Card list that player can
//can use in Battle

package everything;

import java.util.ArrayList;
import everything.cardPackage.*;

public class Hand{
	private static int maxCards=6;
	protected ArrayList<Card> hand;
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
  
    		hand.add(newCard);  		
    		System.out.println("card: "+ newCard.getCardName()+ " added");
    }
    
    protected void removeCard(Card removedCard){
    	if(!hand.contains(removedCard)){
    		System.out.println("Error: this Card does not exist in this Hand");
    	}
    	
    	hand.remove(removedCard);
    }
    
    protected int getSize(){
    	return hand.size();
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
    
    public int getUtilityCards(){
    	for(int i=0;i<hand.size();i++){
    		if(hand.get(i).getCardType().equals("utility")){
    			return i;
    		}
    	}
    	return -1;
    }
    
    public int getMostAdvantage(){
    	int mostAdv =-1;
    	int ret = 0;
    	for(int i=0;i<hand.size();i++){
    		if(hand.get(i).getAdvantage()>ret){
    			mostAdv =hand.get(i).getAdvantage();
    			ret=i;
    		}
    	}
    	
    	return ret;
    }
    
    public void decrementCooldown(Player p1){
    	for(int i=0;i<hand.size();i++){
    		hand.get(i).decrementCooldown(p1);
    	}
    }

	public void resetCooldowns(Player p1){
		for(int i=0;i<hand.size();i++){
			hand.get(i).setTempCDZero();
		}
	}


    
    public boolean checkCooldown(int cardIndex){
    	return hand.get(cardIndex).checkCooldown();
    }
    
    public int getCoolDownTime(int cardIndex){
    	return hand.get(cardIndex).getCooldownTime();
    }
    
    public String getLastCardText(){
    	return lastCardText;
    }
    
    public String[] getImagePaths(){
    	String[] ret = new String[maxCards];
    	int i=0;
    	while(i<hand.size()){
    		ret[i]=hand.get(i).getImagePath();
    		i++;
    	}
    	while(i<maxCards){
    		ret[i]="images/Card_Placeholder.jpeg";
    		i++;
    	}
    	return ret;
    }
    
    public String[] getCardList(){
    	String [] ret = new String[maxCards];
    	int i=0;
    	while(i<hand.size()){
    		ret[i]=hand.get(i).getCardName();
    		i++;
    	}
    	while(i<maxCards){
    		ret[i]="null";
    		i++;
    	}
		return ret;
    }
    public String[] getCardClass(){
    	String[] classes=new String[hand.size()];
    	for(int i=0;i<hand.size();i++){
    		classes[i] =hand.get(i).cardClass();
    	}
    	return classes;
    }
}