package everything.statusPackage;

import everything.Player;

/**
 * Created by Steve on 4/22/2017.
 */
public class CriticalStrike extends Status {
    int health;

    public CriticalStrike(Player newUser, int numTurns, Player newEnemy) {
        user = newUser;
        turns = numTurns;
        enemy = newEnemy;
        health = enemy.getHealth();
    }

    @Override
    public void statusEffectEnding() {
        turns--;
        if (enemy.getHealth() < health) {
            int damageVal = health - user.getHealth();
            enemy.takeDamage(damageVal);
            health = enemy.getHealth();
            turns = 0;
        }
    }
}
