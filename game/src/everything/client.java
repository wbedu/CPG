package everything;
import everything.cardPackage.*;
import everything.AI.*;
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
        int cardSelected;

        //Hand Setup
        userPlayer = new User("Aaron", 30, 0);
        userPlayer.hand.addCard(new Block());
        userPlayer.hand.addCard(new Cleave());
        userPlayer.hand.addCard(new Mutton());
        userPlayer.hand.addCard(new NordicBlood());
        userPlayer.hand.addCard(new SavageStrike());

        panelUIInst.setCardBackFromPlayer(userPlayer.getImagePaths());

        while (true) {
            if(panelUIInst.canStartGame()==1){
                enemyAI = new AI("Shrak", 30, 1,userPlayer);
                enemyAI.hand.addCard(new Block());
                enemyAI.hand.addCard(new Cleave());
                enemyAI.hand.addCard(new Mutton());
                enemyAI.hand.addCard(new NordicBlood());
                enemyAI.hand.addCard(new SavageStrike());
                testBattle = new Battle(userPlayer, enemyAI);
                panelUIInst.setCardWaitingTrue();

                //Battle
                while (gameLoop) {
                    //if (needBattle == 1) {
                    //  needBattle = 0;
                    //   panelUIInst.setMessage("\nBattle with 'Shrak' the Ogre has begun!");    //this function takes a String and puts it in the message display
                    //}

                    panelUIInst.setMessage("\n\n----------------------------------------------------------------------");
                    panelUIInst.setMessage("\nTurn number " + testBattle.getTurnNo());
                    panelUIInst.setMessage("\nPlayer Health: " + userPlayer.getHealth());
                    panelUIInst.setMessage("\nEnemy Health: " + enemyAI.getHealth());
                    panelUIInst.setMessage("\nYour Turn. Choose a card to play.");

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
                    if (userPlayer.hand.checkCooldown(cardSelected)) {
                        panelUIInst.displayPlayerTurn();
                        testBattle.startTurn(cardSelected);
                        panelUIInst.setMessage("\nArmor: "+userPlayer.getDefense());
                        panelUIInst.displayEnemyTurn(enemyAI.hand.getLastCardText());
                    } else {
                        //print cooldown of card selected
                        panelUIInst.setMessage("\nCard still on COOL DOWN: " + userPlayer.hand.getCoolDownTime(cardSelected) + " turns left");
                    }

                    if (testBattle.isOver()) {
                        panelUIInst.setMessage("\n\nBattle is over!");
                        if(testBattle.whoIsDead()==0){
                            panelUIInst.setMessage("\n\nYou’ve Met with a Terrible Fate, Haven’t You?");
                        } else {
                            panelUIInst.setMessage("\n\nYOU HAVE WON!");
                        }
                        gameLoop = false;
                        //needBattle = 1;
                    }
                    panelUIInst.setCardWaitingTrue();
                }//End of GameLoop
                gameLoop = true;
                panelUIInst.battleTearDown();
                panelUIInst.createStartUI();

            } else if(panelUIInst.canShop()==1){
                while (true) {
                    if (panelUIInst.getExitFlag()==1) {
                        break;
                    } else {
                        Thread.sleep(100);
                    }
                    //RETURN HAND CHANGES
                }
            } else {
                //System.out.println("wait for start game");
                Thread.sleep(100);
            }
        }
    }

    public void deckSetup(User p1, AI e1){

    }

}
