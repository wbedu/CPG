package everything.cardPackage;
import everything.Card;
import everything.Player;

import java.util.Random;

/**
 * Created by Steve on 3/28/2017.
 */
public class Assassinate extends Card {
    public Assassinate(){
    	super("Rapidly strike your target twice with a hidden dagger dealing 3-5 damage with each strike.","Assassinate", "Attack", 4,10, true);
    	tempCD = 0;
    	ownedByPlayer = true;
    }

    public void setCooldown(){

    }

    public void cardFunction(Player p1, Player p2){
        if(checkCooldown()){
            Random number1 = new Random(0);
            Random number2 = new Random();
            int randomnum1 = number1.nextInt((5-3) + 1) + 3;
            int randomnum2 = number2.nextInt((5-3) + 1) + 3;
            int damagenum = randomnum1 + randomnum2;
            p2.takeDamage(damagenum);
            super.setCooldown();
        }
    }

}