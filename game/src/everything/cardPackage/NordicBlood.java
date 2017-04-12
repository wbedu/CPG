package everything.cardPackage;

import everything.Player;
import everything.statusPackage.*;
import everything.Card;
/**
 * Created by Steve on 3/10/2017.
 */
public class NordicBlood extends Card {
    public NordicBlood(){
        super("Reduce damage taken by 1 for the rest of the encounter","Nordic Blood", "Defense", 6);
        tempCD = 0;
    }

    public void cardFunction(Player p1, Player p2){
        if(checkCooldown()){
            p1.increaseDefense(7);
            p1.addStatus(new NordicBloodStatus(p1));
            super.setCooldown();
        }
    }
}
