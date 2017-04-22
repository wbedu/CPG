package everything.statusPackage;

import everything.Player;

/**
 * Created by Steve on 4/19/2017.
 */
public class Evasion extends Status {
    int EvasionPercent;
    int health;

    public Evasion(Player newUser, int numTurns, int EvadeChance) {
        user = newUser;
        turns = numTurns;
        EvasionPercent = EvadeChance;
        health = newUser.getHealth();
    }

    @Override
    public void statusEffectEnding() {
        turns--;
        if (user.getHealth() < health) {
            int randVal = (int)(Math.random() * 100);
            if(randVal <= EvasionPercent){
                user.increaseHealth(health - user.getHealth());
            }
        }
        else{
            health = user.getHealth();
        }
    }
}
