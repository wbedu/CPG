package everything.cardPackage;

import everything.Player;
import everything.statusPackage.IncreaseDefenseStatus;

/**
 * Created by Steve on 4/17/2017.
 */
public class WolfDefense extends Card{
    public WolfDefense() {
        super("The wolf assumes a defense posture and howls, gaining 5 amor for the turn and healing for 3 damage.", "Wolf Defense", "Attack", 0, 0, false);
        tempCD = 0;
    }

    public void cardFunction(Player p1, Player p2) {
        p1.addStatus(new IncreaseDefenseStatus(p1, 1, 5));
        p1.increaseHealth(3);
    }
}
