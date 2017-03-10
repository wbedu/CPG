package everything.cardPackage;

import everything.Card;
import everything.Player;

/**
 * Created by Steve on 3/10/2017.
 */
public class SavageStrike extends Card {
    public SavageStrike(){
        super("Wildly bring down your axe with great force, dealing 8 damage", "Savage Strike", "Attack", 3);
    }

    public void setCooldown(){
        super.setCooldown();
    }

    public void cardFunction(Player p1, Player p2){
        if(checkCooldown()){
            p2.decreaseHealth(8);
            this.setCooldown();
        }
    }

}