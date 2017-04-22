package everything.cardPackage;

import everything.Player;

/**
 * Created by Steve on 4/22/2017.
 */
public class BSBerserk extends Card {
    int damageVal;

    public BSBerserk() {
        super("The blacksmith breaks free of his armor, hitting you for as much damage as his defense was!", "BS Berserk", "Utility", 0, 0, false);
        tempCD = 0;
    }

    public void cardFunction(Player p1, Player p2) {
        damageVal = p1.getDefense();
        p1.decreaseDefense(damageVal);
        p2.takeDamage(damageVal);
    }
}
