package everything.AI.AICards;
import everything.Player;
import everything.Card;

import java.util.Random;

/**
 * Created by Steve on 4/17/2017.
 */
public class GoblinStrike extends Card {
    public GoblinStrike(){
        super("Goblin swings wildly, dealing 1-8 damage", "Goblin Strike", "Attack", 0,0, false);
    }

    public void cardFunction(Player p1, Player p2) {
        Random number = new Random(0);
        int randomnum1 = number.nextInt((8-1) + 1) + 1;
        p2.takeDamage(randomnum1);
    }

}
