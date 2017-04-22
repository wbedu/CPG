package everything.statusPackage;

import everything.Player;

/**
 * Created by Steve on 4/17/2017.
 */
public class IncreaseDefenseStatus extends Status {
        //public static final String text = "Hold your shield up, negating all damage for the turn";
    public int defenseFactor;


    public IncreaseDefenseStatus(Player newUser, int numTurns, int defFactor) {
        user = newUser;
        turns = numTurns;
        defenseFactor = defFactor;
    }

    @Override
    public void statusEffectBeginning() {
        turns--;
        if (turns == 0) {
            user.decreaseDefense(this.defenseFactor);
        }
    }
}