package everything.cardPackage;
import everything.*;

public class Detox extends Card{
    public Detox(){super("Clears all status effects from player","Detox", "Utility", 5); tempCD = 0;}

    public void cardFunction(Player p1, Player p2){
    	p1.statusManager.clearAllStatus();
    }
}
