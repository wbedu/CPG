package everything.cardPackage;

import everything.Card;
import everything.Player;
/**
 * Created by Steve on 4/14/2017.
 */
public class ImmolateArmor extends Card {
    public ImmolateArmor() {
        super("Melt the opponents armor, dealing damage equal to it", "Melt Armor", "Utility", 3, 0, false); tempCD = 0;
    }

    public void cardFunction(Player p1, Player p2){
        int dmgVal = p2.getDefense();
        p2.decreaseDefense(dmgVal);
        p2.takeDamage(dmgVal);
        super.setCooldown();
    }
}
