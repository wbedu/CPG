package everything;



public class AI extends Player{
	
	protected int healthThreshold;
	protected int nextCard;
	protected Card cardToDrop;
	
	protected AI(){
	
	}

	protected AI(String newName,int newHealth,int newAttackPoints,int newdefensePoints,int newHealthThreshold){
		super(newName,newHealth,newAttackPoints,newdefensePoints);
		healthThreshold=this.health;
		
	}
	
	
	int randomWithRange(int min, int max)
	{
	   int range = (max - min) + 1;     
	   return (int)(Math.random() * range) + min;
	}
	
	void setNextCard(Player user){
		
		boolean moveset=false;
		if(isHealthy()){
			//TODO
			//check if heal card available
			//set next card to heal
			//check if escape card available
			//set next to to escape
			nextCard =randomWithRange(1,3);
			
			moveset=true;
		}
		
		if((moveset==false)&&(user.defensePoints>this.attackPoints)){
			//TODO
			//check if buff card available;
			//if buff card available set next to attack
			
			nextCard=4;
			
			moveset=true;
		}
		
		if(moveset==false){
			
			//attempt to roll for special card
			//set next cart to special card
			//else
			//set next card to random attack
			
			nextCard=5;
			moveset=true;
		}
		
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
	protected Card setDropCard(){
		
		return cardToDrop;
	}
	
	private void useCard(){
		
	}
	
}