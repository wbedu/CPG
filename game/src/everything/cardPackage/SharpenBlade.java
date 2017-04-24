package everything.cardPackage;

import everything.Player;
import everything.statusPackage.CriticalStrike;

/**
 * Created by Steve on 4/22/2017.
 */
public class  SharpenBlade extends Card {
    public SharpenBlade(){
        super("Sharpen your blade putting on a keen edge, granting critical strike (double damage) on your next attack within 3 turns", "Keen Edge", "Utility", 5,0, false);
    }

    public void cardFunction(Player p1, Player p2) {
        p1.addStatus(new CriticalStrike(p1, 3, p2));
        super.setCooldown();
    }
}


