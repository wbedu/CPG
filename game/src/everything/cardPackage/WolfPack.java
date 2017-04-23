package everything.cardPackage;

import everything.Player;
import everything.statusPackage.Bleed;

/**
 * Created by Steve on 4/17/2017.
 */
public class WolfPack extends Card {
    public WolfPack() {
        super("The wolf calls for allies, 5 wolves attack you each has a chance of inflicting bleed", "WolfPack", "Attack", 0, 0, false);
        tempCD = 0;
    }

    public void cardFunction(Player p1, Player p2) {
        for(int i = 0; i < 4; i++) {
            int range = (10 - 1) + 1;
            int randomnum = (int) (Math.random() * range) + 1;
            if (randomnum > 6) {
                p1.addStatus(new Bleed(p2, 3));
                System.out.println("You are now bleeding");
            }
        }
    }
}
