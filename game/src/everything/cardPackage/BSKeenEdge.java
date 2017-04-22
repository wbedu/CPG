package everything.cardPackage;

import everything.Player;
import everything.statusPackage.CriticalStrike;

/**
 * Created by Steve on 4/22/2017.
 */
public class BSKeenEdge extends Card {
    public BSKeenEdge(){
        super("Blacksmith sharpens his weapon, granting critical strike for 3 turns.", "Keen Edge", "Utility", 0,0, false);
    }

    public void cardFunction(Player p1, Player p2) {
        p2.addStatus(new CriticalStrike(p1, 3, p2));
    }
}
