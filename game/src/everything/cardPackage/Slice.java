package everything.cardPackage;
import everything.Player;
import everything.statusPackage.Bleed;

/**
 * Created by Steve on 4/14/2017.
 */
public class Slice extends Card {
    public Slice(){
        super("Slice your target for 2 damage, and bleed them for 1 for 3 turns", "Slice", "Attack", 0, 0,false); tempCD = 0;
    }

    public void cardFunction(Player p1, Player p2){
        if(checkCooldown()){
            p2.takeDamage(2);
            p1.addStatus(new Bleed(p2,3));
            super.setCooldown();
        }
    }
}
