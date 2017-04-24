package everything.cardPackage;

import everything.Player;
import everything.statusPackage.Burning;

/**
 * Created by Steve on 4/22/2017.
 */
public class GoblinFire extends Card {
    public GoblinFire() {
        super("A goblin sneaks up with a torch and burns you for 3 damage for 3 turns", "Goblin Fire", "Attack", 0, 0, false);
        tempCD = 0;
    }

    public void cardFunction(Player p1, Player p2) {
        p2.addStatus(new Burning(p2, 3, 3 ));
    }
}

