package everything.cardPackage;

import everything.Player;

import javax.smartcardio.*;

/**
 * Created by Steve on 4/21/2017.
 */
public class Berserk extends Card {
    int damageVal;

    public Berserk() {
        super("Break free of your armor, then deal damage equal to that value", "Berserk", "Utility", 5, 2, false);
        tempCD = 0;
    }

    public void cardFunction(Player p1, Player p2) {
        if (checkCooldown()) {
            damageVal = p1.getDefense();
            p1.decreaseDefense(damageVal);
            p2.takeDamage(damageVal);
            super.setCooldown();
        }
    }
}
