package everything.statusPackage;

import everything.Player;

/**
 * Created by Steve on 4/22/2017.
 */
public class TrueDamage extends Status {
    int health;
    int damage;

    public TrueDamage(Player newUser, int numTurns, Player newEnemy) {
        user = newUser;
        turns = numTurns;
        enemy = newEnemy;
        health = enemy.getHealth();
    }

    @Override
    public void statusEffectEnding() {
        turns--;
        if (enemy.getHealth() < health){
             damage = enemy.getDefense();
             enemy.takeDamage(damage);
             health = enemy.getHealth();
        }
    }

}
