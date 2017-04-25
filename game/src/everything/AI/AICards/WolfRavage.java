package everything.AI.AICards;
import everything.Player;
import everything.statusPackage.Bleed;
import everything.Card;

/**
 * Created by Steve on 4/17/2017.
 */
public class WolfRavage extends Card {
    public WolfRavage() {
        super("Wolf swings with both claws, attacking twice for 3 damage each time and has a chance of inflicting bleed.", "WolfRavage", "Attack", 0, 0, false);
        tempCD = 0;
    }

    public void cardFunction(Player p1, Player p2) {
        for (int i = 0; i < 1; i++) {
            p2.decreaseHealth(3);
            int range = (10 - 1) + 1;
            int randomnum = (int) (Math.random() * range) + 1;
            if (randomnum > 6) {
                p1.addStatus(new Bleed(p2, 3));
                System.out.println("You are now bleeding");
            }
        }
    }
}