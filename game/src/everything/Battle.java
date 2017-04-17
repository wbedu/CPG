package everything;

import everything.AI.*;

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
    	user.runStatus();
    	user.hand.useCard(cardSelection,user,enemy);
        enemyTurn();
    }

    public void enemyTurn(){
    	enemy.runStatus();
        enemy.setNextCard();
        enemy.hand.useCard(enemy.getNextCard(), enemy, user);
        turnNo++;
    }

    public int getTurnNo(){
        return turnNo;
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

    public boolean attemptToRun(){
        int min = 1;
        int max = 4;
        int range = (int)(max - min) + 1;
        if (range == 4)
             return false;
        else
            return true;
    }
    
}
