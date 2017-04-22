package everything.statusPackage;

import everything.Player;

/**
 * Created by Steve on 4/22/2017.
 */
public class DelayedHit extends Status {
    int damage;
    Player enemy;

    public DelayedHit(Player newUser, int numTurns, int damageVal, Player newEnemy) {
        user = newUser;
        turns = numTurns;
        damage = damageVal;
        enemy = newEnemy;
    }

    @Override
    public void statusEffectBeginning() {
        turns--;
        if (turns==0)
            enemy.takeDamage(damage);
    }
}
