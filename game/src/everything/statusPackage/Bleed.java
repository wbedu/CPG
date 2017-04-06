package everything.statusPackage;
import everything.*;
import everything.Player;
/**
 * Created by Steve on 4/1/2017.
 */
public class Bleed extends Status{

    public Bleed(Player newUser,int numTurns){
        user = newUser;
        turns = numTurns;
    }

    @Override
    public void statusEffect() {
        user.decreaseHealth(1);
    }
}
