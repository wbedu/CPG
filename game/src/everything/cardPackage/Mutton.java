package everything.cardPackage;

import everything.Card;
import everything.Player;
/**
 * Created by Steve on 3/10/2017.
 */
public class Mutton extends Card {
    public Mutton(){ super("Eat a stored leg of mutton, regain 4 health", "Mutton", "Utility", 3); tempCD = 0; }

    public void cardFunction(Player p1, Player p2){
        if(checkCooldown()){
            System.out.println("\nMutton: Restore 4 HP - 3 turn CD");
            p1.increaseHealth(4);
            super.setCooldown();
        }
    }
}
