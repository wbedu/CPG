package everything.cardPackage;

import everything.Card;
import everything.Player;

/**
 * Created by Steve on 3/10/2017.
 */
public class Cleave extends Card{
    public Cleave(){super("Swing your axe in an arc dealing 3 damage","Cleave", "Attack", 0); tempCD = 0;}

    public void setCooldown(){
        super.setCooldown();
    }

    public void cardFunction(Player p1, Player p2){
        if(checkCooldown()){
            p2.takeDamage(3);
        }
    }
}
