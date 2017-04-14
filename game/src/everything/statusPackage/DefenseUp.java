package everything.statusPackage;

import everything.Player;

/**
 * Created by Steve on 4/14/2017.
 */
public class DefenseUp extends Status {
    int defenseValue;
    public DefenseUp(Player newUser, int numTurns, int defenseFactor){
        user=newUser;
        turns=numTurns;
        defenseValue = defenseFactor;
    }

    @Override
    public void statusEffect(){
        turns--;
        if(turns==0){
            user.decreaseDefense(defenseValue);
        }
    }

}
