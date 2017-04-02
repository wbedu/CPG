package everything.cardPackage;

import everything.Card;
import everything.Player;

/**
 * Created by Steve on 3/10/2017.
 */
public class Cleave extends Card{
    public Cleave(){super("\nSwing your axe in an arc dealing 3 damage","Cleave", "Attack", 0); tempCD = 0;}

    public void cardFunction(Player p1, Player p2){
        if(checkCooldown()){
            p2.takeDamage(3);
            super.setCooldown();
        }
    }
}
