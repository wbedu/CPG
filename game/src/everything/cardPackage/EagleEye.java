package everything.cardPackage;

import everything.Card;
import everything.Player;
import everything.statusPackage.TrueDamage;

/**
 * Created by Steve on 4/22/2017.
 */
public class EagleEye  extends Card {
    public EagleEye(){
        super("Focus your ability, making all of your strikes hit for true damage for 3 turns (ignores armor).", "Eagle Eye", "Utility", 5,0, false);
    }

    public void cardFunction(Player p1, Player p2) {
        p2.addStatus(new TrueDamage(p1, 3, p2));
        super.setCooldown();
    }
}

