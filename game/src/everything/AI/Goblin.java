package everything.AI;

import everything.Player;
import everything.AI.AICards.GoblinCower;
import everything.AI.AICards.GoblinFire;
import everything.AI.AICards.GoblinOpportunity;
import everything.AI.AICards.GoblinStrike;

/**
 * Created by Steve on 4/22/2017.
 */
public class Goblin extends AI {
    public Goblin(Player user){
        super("Goblin",20,0, user);
        this.addCard(new GoblinCower());
        this.addCard(new GoblinStrike());
        this.addCard(new GoblinFire());
        this.addCard(new GoblinOpportunity());
        depositMoney(50);
    }
        @Override
        public void setNextCard(){
            nextCard =randomWithRange(0,getHandSize()-1);
        }
}

