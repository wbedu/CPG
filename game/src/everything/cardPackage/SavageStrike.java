package everything.cardPackage;

import everything.Player;
import everything.statusPackage.Bleed;

/**
 * Created by Steve on 3/10/2017.
 */
public class SavageStrike extends Card {
    public SavageStrike(){
        super("Wildly bring down your axe with great force, dealing 8 damage", "SavageStrike", "Attack", 3,8,true );
        	tempCD = 0;
        }

    public void cardFunction(Player p1, Player p2){
        if(checkCooldown()){
            p2.takeDamage(8);
            p1.addStatus(new Bleed(p2, 3));
            super.setCooldown();
        }
    }

}