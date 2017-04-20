package everything.statusPackage;

import everything.Player;

/**
 * Created by Steve on 4/19/2017.
 */
public class Reflect extends Status {
    int health;

    public Reflect(Player newUser, int numTurns, Player Enemy) {
        user = newUser;
        turns = numTurns;
        health = newUser.getHealth();
    }

    @Override
    public void statusEffect() {
        turns--;
        if (user.getHealth() < health) {
            int damageVal = health - user.getHealth();
            user.increaseHealth(damageVal);
            enemy.takeDamage(damageVal);
        }
    }
}
