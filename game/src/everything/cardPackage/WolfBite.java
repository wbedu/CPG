package everything.cardPackage;

import everything.Player;

/**
 * Created by Steve on 4/17/2017.
 */
public class WolfBite extends Card {
    public WolfBite() {
        super("You get bitten by a wolf, you take 3 damage and your armor is decreased by 1", "Wolf's Bite", "Attack", 0, 0, false);
        tempCD = 0;
    }

    public void cardFunction(Player p1, Player p2) {
        p2.decreaseDefense(1);
        p2.decreaseHealth(3);
    }
}