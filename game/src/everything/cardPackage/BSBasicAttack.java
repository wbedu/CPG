package everything.cardPackage;

import everything.Player;

/**
 * Created by Steve on 4/22/2017.
 */
public class BSBasicAttack extends Card {
    public BSBasicAttack() {
        super("Inawa the Blacksmith bashes you with his shield dealing 3 damage, then returns to a defensive posture gaining 1 armor", "Basic Attack", "Attack", 0, 0, false);
        tempCD = 0;
    }

    public void cardFunction(Player p1, Player p2) {
        {
            p2.takeDamage(3);
            p1.increaseDefense(1);
        }
    }
}
