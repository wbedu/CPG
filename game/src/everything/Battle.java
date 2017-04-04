package everything;

import java.util.ArrayList;


/**
 * Created by Steve on 3/5/2017.
 */

public class Battle {
    private Player user;
    private AI enemy;
    private int turnNo;
    
    public Battle(){
    }

    public Battle(Player p1, AI e) {
        user = p1;
        enemy = (AI) e;
        turnNo = 1;
    }
    public void startTurn(int cardSelection) {
    	runUserEffects();
        user.hand.decrementCooldown(user);
    	user.hand.useCard(cardSelection,user,enemy);
        enemyTurn();
    }

    public void enemyTurn(){
    	runEnemyStatus();
        user.hand.decrementCooldown(enemy);
        enemy.setNextCard(user);
        enemy.hand.useCard(enemy.getNextCard(), enemy, user);
        turnNo++;
    }

    public int getTurnNo(){
        return turnNo;
    }
    
    public void runUserEffects(){
    	for(int i=0;i<user.status.size();i++){
    			user.status.get(i).turns--;
    			
    			user.status.get(i).statusEffect();
    	}
    	
    }
    
    public void runEnemyStatus(){
    	for(int i=0;i<enemy.status.size();i++){
			enemy.status.get(i).turns--;
			
			enemy.status.get(i).statusEffect();
    	}
    }

    //checks if a battle is on going/
    public boolean isOver(){
    	
    	System.out.println("Player: "+user.getHealth());
        System.out.println("AI: "+enemy.getHealth());
    	return(!user.lifeCheck() ||!enemy.lifeCheck());
    }
    
    public int whoIsDead(){
    	if(!isOver()){
    		return -1;
    	}
    	if(user.getHealth()<=0){
    		return 0;
    	}else{
    		return 1;
    	}
    }
}
