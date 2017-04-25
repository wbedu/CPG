package everything.AI.AICards;

import everything.Player;
import everything.Card;
import everything.statusPackage.CriticalStrike;
/**
 * Created by Steve on 4/22/2017.
 */
public class GoblinOpportunity extends Card {
    public GoblinOpportunity(){
        super("Goblin gets into a better position, granting critical strike on his next attack.", "GoblinOpportunity", "Utility", 0,0, false);
    }

    public void cardFunction(Player p1, Player p2) {

        p2.addStatus(new CriticalStrike(p1, 3, p2));
    }
}

