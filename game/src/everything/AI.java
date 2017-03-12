package everything;
import java.util.*;


public abstract class AI extends Player{
	
	protected int healthTreshold;
	
	
	protected AI(){
		super();
	}

	protected AI(String newName,int newHealth,int newAttackPoints,int newdefensePoints, Deck newHand,int newHealthTreshold){
		super(newName,newHealth,newAttackPoints,newdefensePoints,newHand);
		healthTreshold=this.health;
		
	}
	
	
	void setNextCard(Player user){
		
		boolean moveset=false;
		if(isHealthy()){
			//TODO
			//check if heal card available
			//set next card to heal
			//check if escape card available
			//set next to to escape
			moveset=true;
		}
		
		if((moveset==false)&&(user.defensePoints>this.attackPoints)){
			//TODO
			//check if buff card available;
			//if buff card available set next to attack
			moveset=true;
		}
		
		if(moveset==false){
			
			//attempt to roll for special card
			//set next cart to special card
			//else
			//set next card to random attack
		}
		
		
		
		
	}
	
	//call function or cards available that can repleanish health;
	protected boolean isHealthy(){
	
		if(this.health>healthTreshold){
			return true;
		}else{
			return false;
		}
	}
	
}