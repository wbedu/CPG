package everything.statusPackage;

import everything.Player;

/**
 * Created by Steve on 4/22/2017.
 */
public class Burning extends Status {
    int burnVal;

    public Burning(Player newUser, int fireDamage, int numTurns){
        user = newUser;
        turns = numTurns;
        burnVal = fireDamage;
    }

    @Override
    public void statusEffectBeginning() {
        turns--;
        user.decreaseHealth(burnVal);
    }
}
