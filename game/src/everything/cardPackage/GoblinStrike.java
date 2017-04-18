package everything.cardPackage;
import everything.Player;
/**
 * Created by Steve on 4/17/2017.
 */
public class GoblinStrike extends Card {
    public GoblinStrike(){
        super("Goblin swings wildly, dealing 1-10 damage", "Goblin Strike", "Attack", 0,0, false);
    }

    public void cardFunction(Player p1, Player p2) {
        int range = (10 - 1) + 1;
        int randomnum1 = (int) (Math.random() * range) + 1;
        p2.takeDamage(randomnum1);
    }

}
