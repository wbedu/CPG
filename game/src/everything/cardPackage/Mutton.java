package everything.cardPackage;

import everything.Card;
import everything.Player;
/**
 * Created by Steve on 3/10/2017.
 */
public class Mutton extends Card {
    public Mutton(){ super("Eat a stored leg of mutton, regain 4 health", "Mutton", "Utility", 3); tempCD = 3; }

    public void setCooldown(){
        super.setCooldown();
    }

    public void cardFunction(Player p1, Player p2){
        if(checkCooldown()){
            if(p1.getHealth() <= 6)
                p1.setHealth(10);
            else
                p1.increaseHealth(4);
        }
    }
}