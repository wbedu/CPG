package everything.statusPackage;

import everything.Player;
import jdk.net.SocketFlow;

/**
 * Created by Steve on 4/19/2017.
 */
public class Thorns extends Status {
    int thornsVal;
    int health;
    public Thorns(Player newUser, int numTurns, int thornDamage, Player enemy) {
        user = newUser;
        turns = numTurns;
        thornsVal = thornDamage;
        health = newUser.getHealth();
    }

    @Override
    public void statusEffectEnding() {
        turns--;
        if (user.getHealth() < health) {
            enemy.takeDamage(thornsVal);
            health = user.getHealth();
        }
        else{
            health = user.getHealth();
        }
    }
}
