package everything.cardPackage;

import everything.Player;
/**
 * Created by Steve on 3/28/2017.
 */
public class Assassinate extends Card {
    public Assassinate(){super("Rapidly strike your target twice with a hidden dagger dealing 3-5 damage with each strike.","Assassinate", "Attack", 3); tempCD = 3;}

    public void setCooldown(){

    }

    public void cardFunction(Player p1, Player p2){
        if(checkCooldown()){
            int range = (5 - 3) + 1;
            int randomnum1 = (int)(Math.random() * range) + 3;
            int randomnum2 = (int)(Math.random() * range) + 3;
            int damagenum = randomnum1 + randomnum2;
            p2.takeDamage(damagenum);
        }
    }

}