package everything;
import everything.cardPackage.*;

/**
 * Created by Aaron on 3/4/17.
 */
public class client {
    public static void main(String args[]) throws InterruptedException{
        boolean gameLoop = true;
        panelUI panelUIInst = new panelUI();
        Battle testBattle = new Battle();
        User userPlayer;
        AI enemyAI;
        int cardSelected, needBattle = 1;

        panelUIInst.setMessage("\nBattle with 'Shrak' the Ogre has begun!\n");    //this function takes a String and puts it in the message display

        userPlayer = new User("Aaron",10,3,3);
        enemyAI = new AI("Shrak",10,1,2,3);


        //Hand Setup
        userPlayer.hand.addCard(new Block());
        userPlayer.hand.addCard(new Cleave());
        userPlayer.hand.addCard(new Mutton());
        userPlayer.hand.addCard(new NordicBlood());
        userPlayer.hand.addCard(new SavageStrike());

        enemyAI.hand.addCard(new Cleave());
        enemyAI.hand.addCard(new SavageStrike());
        enemyAI.hand.addCard(new Mutton());

        //First Battle
        while(gameLoop){
            if(needBattle==1){
                testBattle = new Battle(userPlayer, enemyAI);
                needBattle = 0;
            }
            while(true){
            	if(!panelUIInst.getCardWaiting()){	
            		break;
            	}else{
            		Thread.sleep(100);
            	}
                //System.out.println();
            }
            cardSelected = panelUIInst.getCardSelect();

            //DO BATTLE
            if(userPlayer.hand.hand.get(cardSelected).checkCooldown()) {
                panelUIInst.displayPlayerTurn();
                testBattle.startTurn(cardSelected);
                panelUIInst.displayEnemyTurn();
            } else {
                //print cooldown of card selected
            }

            if(testBattle.isOver()){
                panelUIInst.setMessage("\nBattle is over!");
                gameLoop = false;
                needBattle = 1;
            }
            panelUIInst.setCardWaitingTrue();
        }

        //End battle if statement here
    }

    public void deckSetup(User p1, AI e1){

    }

}
