package everything.AI;

import everything.*;

public abstract class AI extends Player{
	
	protected int healthThreshold;
	protected int nextCard;
	protected Card cardToDrop;
	private   String imagePath;
	Player enemy;
	protected AI(){
	
	}

	public AI(String name,int health,int defense, Player enemy){
		super(name,health,defense);
		maxHealth = health;
		this.enemy= enemy;
		setImagePath("images/".concat(this.getClass().getSimpleName()).concat("Sprite.png"));
	}

	public String getImagePath() {
		return imagePath;
	}

	/**
	 * @param imagePath the imagePath to set
	 */
	protected void setImagePath(String setImagePath) {
		imagePath = setImagePath;
	}
	
	
	int randomWithRange(int min, int max)
	{
	   int range = (max - min) + 1;     
	   return (int)(Math.random() * range) + min;
	}
	
	public void setNextCard(){
		
		boolean moveset=false;			
			if(enemy.getHealth()>this.getHealth()){
				nextCard=this.hand.getUtilityCards();
				if(nextCard>0){
					moveset=true;
				}else{
					nextCard=this.hand.getMostAdvantage();
					moveset=true;
				}
			}else{
				nextCard =randomWithRange(0,getHandSize());
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
	protected Card getDropCard(){
		
		return cardToDrop;
	}	
}