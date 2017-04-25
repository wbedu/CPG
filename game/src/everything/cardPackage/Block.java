package everything.cardPackage;

import everything.*;
import everything.statusPackage.IncreaseDefenseStatus;
import everything.Card;
/**
 * Created by Steve on 3/10/2017.
 */
public class Block extends Card{
    public Block() {
    	super("Hold your shield up, negating all damage for the turn", "Block", "Defense", 3,11, true);
    	tempCD =0;
    }

    public void cardFunction(Player p1, Player p2){
        System.out.println("HERE");
        if(checkCooldown()){
            p1.increaseDefense(100);
            p1.addStatus(new IncreaseDefenseStatus(p1, 1, 100));
            super.setCooldown();
        }
    }
}
