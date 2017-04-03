package everything;
import everything.cardPackage.*;

/**
 * Created by Aaron on 3/4/17.
 */
public class client {
    public static void main(String args[]) throws InterruptedException {
        boolean gameLoop = true;
        panelUI panelUIInst = new panelUI();
        Battle testBattle;
        User userPlayer;
        AI enemyAI;
        int cardSelected, needBattle = 0;

        userPlayer = new User("Aaron", 30, 3, 3);
        enemyAI = new AI("Shrak", 30, 1, 2, 3);

        //Hand Setup
        userPlayer.hand.addCard(new Block());
        userPlayer.hand.addCard(new Cleave());
        userPlayer.hand.addCard(new Mutton());
        userPlayer.hand.addCard(new NordicBlood());
        userPlayer.hand.addCard(new SavageStrike());

        enemyAI.hand.addCard(new Block());
        enemyAI.hand.addCard(new Cleave());
        enemyAI.hand.addCard(new Mutton());
        enemyAI.hand.addCard(new NordicBlood());
        enemyAI.hand.addCard(new SavageStrike());


        while (true) {
            if(panelUIInst.canStartGame()==1){
                break;
            } else {
                //System.out.println("wait for start game");
                Thread.sleep(100);
            }
        }

        testBattle = new Battle(userPlayer, enemyAI);

            //First Battle
            while (gameLoop) {
                //if (needBattle == 1) {
                  //  needBattle = 0;
                 //   panelUIInst.setMessage("\nBattle with 'Shrak' the Ogre has begun!");    //this function takes a String and puts it in the message display
                //}

                panelUIInst.setMessage("\n\nTurn number " + testBattle.getTurnNo());
                panelUIInst.setMessage("\nPlayer Health: " + userPlayer.getHealth());
                panelUIInst.setMessage("\nEnemy Health: " + enemyAI.getHealth());

                while (true) {
                    if (!panelUIInst.getCardWaiting()) {
                        break;
                    } else {
                        Thread.sleep(100);
                    }
                    //System.out.println();
                }
                cardSelected = panelUIInst.getCardSelect();

                //DO BATTLE
                if (userPlayer.hand.hand.get(cardSelected).checkCooldown()) {
                    panelUIInst.displayPlayerTurn();
                    testBattle.startTurn(cardSelected);
                    panelUIInst.displayEnemyTurn(enemyAI.hand.getLastCardText());
                } else {
                    //print cooldown of card selected
                    panelUIInst.setMessage("\nCard still on COOL DOWN: " + userPlayer.hand.hand.get(cardSelected).getCooldownTime() + " turns left");
                }

                if (testBattle.isOver()) {
                    panelUIInst.setMessage("\n\nBattle is over!");
                    gameLoop = false;
                    //needBattle = 1;
                }
                panelUIInst.setCardWaitingTrue();
            }

            //End battle if statement here
        }


    public void deckSetup(User p1, AI e1){

    }

}
