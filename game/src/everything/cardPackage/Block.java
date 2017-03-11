package everything.cardPackage;

import everything.Card;
import everything.Player;
/**
 * Created by Steve on 3/10/2017.
 */
public class Block extends Card{
    public Block() { super("Hold your shield up, negating all damage for the turn", "Block", "Defense", 1); tempCD = 1;}

    public void setCooldown(){
        super.setCooldown();
    }

    public void cardFunction(Player p1, Player p2){
        if(checkCooldown()){
            p1.increaseDefence(100);
            this.setCooldown();
        }
    }

    public  void incrementCooldown(Player p1){
        if(tempCD != cooldown)
            tempCD = tempCD++;
        if(tempCD == cooldown)
            p1.decreaseDefence(100);
    }
}
