package everything.cardPackage;

import everything.Player;
import everything.Card;
/**
 * Created by Steve on 3/10/2017.
 */
public class NordicBlood extends Card {
    public NordicBlood(){
        super("Reduce damage taken by 1 for the rest of the encounter","Nordic Blood", "Defense", 2);
    }

    public void setCooldown(){
        super.setCooldown();
    }

    public void cardFunction(Player p1, Player p2){
        if(checkCooldown()){
            p1.increaseDefense(1);
            setCooldown();
        }
    }
}
