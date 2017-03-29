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
        System.out.println("HERE");
        if(checkCooldown()){
            System.out.println("\nBlock: Blocking incoming DMG - 1 turn CD");
            p1.increaseDefense(100);
            this.setCooldown();
        }
    }

    public  void incrementCooldown(Player p1){
        if(tempCD != cooldown)
            tempCD = tempCD++;
        if(tempCD == cooldown)
            p1.decreaseDefense(100);
    }
}
