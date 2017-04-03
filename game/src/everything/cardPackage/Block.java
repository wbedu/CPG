package everything.cardPackage;

import everything.Card;
import everything.Player;
/**
 * Created by Steve on 3/10/2017.
 */
public class Block extends Card{
    public Block() { super("Hold your shield up, negating all damage for the turn", "Block", "Defense", 1); tempCD =0;}

    public void cardFunction(Player p1, Player p2){
        System.out.println("HERE");
        if(checkCooldown()){
            p1.increaseDefense(100);
            super.setCooldown();
        }
    }

    public  void decrementCooldown(Player p1){
        if(tempCD < 0)
            tempCD -= 1;
        if(tempCD == cooldown-1)
            p1.decreaseDefense(100);
    }
}
