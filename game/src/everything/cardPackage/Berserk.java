package everything.cardPackage;

import everything.Player;

import javax.smartcardio.*;

/**
 * Created by Steve on 4/21/2017.
 */
public class Berserk extends Card{
    int damageVal;
    boolean hasBeenUsed;

    public Berserk(){
        super("Break free of your armor, ","Berserk", "Utility", 5,2, false);
        hasBeenUsed = false;
        tempCD = 0;
    }

    public void cardFunction(Player p1, Player p2){
        if(checkCooldown()){
            damageVal = p1.getDefense();
            p1.decreaseDefense(damageVal);
            super.setCooldown();
        }
        if(!checkCooldown() && !beenUsed())
        {
            p2.takeDamage(damageVal);
            setHasBeenUsed();
        }
    }

    public void decrementCooldown(Player p1){
        if(tempCD > 0){
            tempCD--;
            if(tempCD == 0){
                setHasBeenUsedFalse();
            }
        }
    }

    public void setHasBeenUsed(){
        hasBeenUsed = true;
    }

    public void setHasBeenUsedFalse(){
        hasBeenUsed = false;
    }

    public boolean beenUsed(){
        return hasBeenUsed;
    }
}
