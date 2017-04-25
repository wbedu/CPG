package everything.AI.AICards;

import everything.Player;
import everything.Card;
import everything.statusPackage.IncreaseDefenseStatus;

/**
 * Created by Steve on 4/22/2017.
 */
public class BSArmorUp extends Card {
    public BSArmorUp() {
        super("Inawa the Blacksmith dons a suit of armor, gaining 10 armor for 2 turns", "Armor Up", "Defense", 0, 0, false);
    }

    public void cardFunction(Player p1, Player p2) {
        {
            p1.increaseDefense(10);
            p1.addStatus(new IncreaseDefenseStatus(p1, 2, 10));
        }
    }

}
