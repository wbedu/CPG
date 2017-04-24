package everything.cardPackage;

import everything.Player;
import everything.statusPackage.Burning;
/**
 * Created by Steve on 4/22/2017.
 */
public class BSMoltenWeapon extends Card {
    public BSMoltenWeapon() {
        super("Inawa the Blacksmith dunks his weapon into the forge, his next attack will burn for 3 damage for 3 turns", "BS Molten Weapon", "Utility", 0, 0, false);
        tempCD = 0;
    }

    public void cardFunction(Player p1, Player p2) {
        p2.addStatus(new Burning(p2, 3, 3 ));
    }
}
