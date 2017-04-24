package everything.AI;

import everything.cardPackage.*;
import everything.Player;
/**
 * Created by Steve on 4/24/2017.
 */
public class BlackSmith extends AI{
        public BlackSmith(Player user){
            super("Inawa",50,0, user);
            this.addCard(new BSArmorUp());
            this.addCard(new BSBasicAttack());
            this.addCard(new BSBerserk());
            this.addCard(new BSHammerToss());
            this.addCard(new BSKeenEdge());
            this.addCard(new BSMoltenWeapon());
            depositMoney(50);
        }
        @Override
        public void setNextCard(){
            nextCard =randomWithRange(0,getHandSize()-1);
        }
}
