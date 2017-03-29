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
    	user.hand.useCard(cardSelection,user,enemy);
        turnNo++;
        enemyTurn();
    }

    public void enemyTurn(){
       enemy.hand.useCard(1, enemy, user);
    }


    
    //checks if a battl is on going/
    public boolean isOver(){
    	return(user.isDead() ||enemy.isDead());
    }
}
