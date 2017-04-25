package everything.AI.AICards;

import everything.Player;
import everything.statusPackage.DelayedHit;
import everything.Card;
/**
 * Created by Steve on 4/22/2017.
 */
public class BSHammerToss extends Card {
    int damageVal;

    public BSHammerToss() {
        super("Inawa the Blacksmith tosses his hammer in the air, it will strike you in 3 turns for 20 damage", "Hammer Toss", "Attack", 3, 0, false);
        tempCD = 0;
        damageVal = 20;
    }

    public void cardFunction(Player p1, Player p2) {
        if (checkCooldown()) {
            p1.addStatus(new DelayedHit(p1, 3, damageVal, p2));
        }
    }
}
