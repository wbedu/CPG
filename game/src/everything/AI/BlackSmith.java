package everything.AI;

import everything.AI.AICards.*;
import everything.Player;
/**
 * Created by Steve on 4/24/2017.
 */
public class BlackSmith extends AI{
        public BlackSmith(Player user){
            super("Inawa",50,0, user);
            this.addCard(new BSArmorUp());//card0
            this.addCard(new BSBasicAttack());//card1
            this.addCard(new BSBerserk());//card2
            this.addCard(new BSHammerToss());//card3
            this.addCard(new BSKeenEdge());//card4
            this.addCard(new BSMoltenWeapon());//card5
            depositMoney(50);
        }
        @Override
        public void setNextCard(){
        	int rand = (int)(Math.random()*100);
        	if(getDefense()==0||(rand<20)){
        		nextCard=0;
        		return;
        	}
        	if(getDefense()>=10||(rand<20)){
        	    nextCard=3;
            }
        	
        	if(enemy.getHealth()>this.health){
        		
        		if(this.getDefense()>(enemy.getHealth()/2)){
        			nextCard=2;
        		}
        		nextCard=5;
        		return;
        	}
        	
        	
        	if(rand+getDefense()>70){
        		nextCard=2;
        		return;
       		}
        		
        	if(rand>60){
        		nextCard=3;
       			return;
       		}
       		
       		if(rand>50){
       			nextCard=4;
       			return;
       		}
       		
        	if(rand>40){
        		nextCard=5;
        		return;
        	}
        		
            nextCard =1;
        }
}
