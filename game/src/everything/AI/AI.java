package everything;

import everything.cardPackage.*;


public class AI extends Player{
	
	protected int healthThreshold;
	protected int nextCard;
	protected Card cardToDrop;
	
	protected AI(){
	
	}

	protected AI(String name,int health,int defense){
		super(name,health,defense);
	}
	
	
	int randomWithRange(int min, int max)
	{
	   int range = (max - min) + 1;     
	   return (int)(Math.random() * range) + min;
	}
	
	void setNextCard(Player user){
		
		boolean moveset=false;
			nextCard =randomWithRange(0,4);
			
			moveset=true;

	}
	
	public int getNextCard(){
		return nextCard;
	}
	
	//checks if AI health is bellow a threshold
	//returns true AI is above threshold
	//returns false if AI is bellow;
	protected boolean isHealthy(){
	
		if(this.health>healthThreshold){
			return true;
		}else{
			return false;
		}
	}
	
	//must edit to have card drop
	protected Card getDropCard(){
		
		return cardToDrop;
	}	
}