package everything;

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
        user.hand.decrementCooldown();
    	user.hand.useCard(cardSelection,user,enemy);
        turnNo++;
        enemyTurn();
    }

    public void enemyTurn(){
        user.hand.decrementCooldown();
        enemy.hand.useCard(1, enemy, user);
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
}
