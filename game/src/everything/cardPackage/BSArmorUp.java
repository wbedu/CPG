package everything.cardPackage;

import everything.Player;
import everything.statusPackage.IncreaseDefenseStatus;

/**
 * Created by Steve on 4/22/2017.
 */
public class BSArmorUp extends Card {
    public BSArmorUp() {
        super("Blacksmith dons a suit of armor, gaining 10 armor for 2 turns", "Armor Up", "Defense", 0, 0, false);
    }

    public void cardFunction(Player p1, Player p2) {
        {
            p2.increaseDefense(10);
            p2.addStatus(new IncreaseDefenseStatus(p1, 2, 10));
        }
    }

}