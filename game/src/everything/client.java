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
        SaveState save = new SaveState();

        //SaveState save = new SaveState();
        //Hand Setup
        userPlayer =save.loadGame();

        panelUIInst.setCardBackFromPlayer(userPlayer.getImagePaths());

        while (true) {
            if(panelUIInst.canStartGame()==1){
                System.out.println("start battle -client");
                userPlayer.setHealth(userPlayer.getMaxHealth());
                userPlayer.hand.resetCooldowns(userPlayer);
                enemyAI = AIManager.getRandomMonster(userPlayer);//new AI("Shrak", 30, 1,userPlayer);
                panelUIInst.setEnemyImagePath(enemyAI.getImagePath());
                testBattle = new Battle(userPlayer, enemyAI);
                panelUIInst.setCardWaitingTrue();

                //Battle
                while (gameLoop) {
                    //if (needBattle == 1) {
                    //  needBattle = 0;
                    //   panelUIInst.setMessage("\nBattle with 'Shrak' the Ogre has begun!");    //this function takes a String and puts it in the message display
                    //}

                    panelUIInst.setMessage("\n---------------------------------");
                    panelUIInst.setMessage("\nTurn number " + testBattle.getTurnNo());
                    panelUIInst.setMessage("\nPlayer Health: " + userPlayer.getHealth());
                    panelUIInst.setPlayerHealth(userPlayer.getHealth());
                    panelUIInst.setPlayerArmor(userPlayer.getDefense());
                    panelUIInst.setMessage("\nEnemy Health: " + enemyAI.getHealth());
                    panelUIInst.setEnemyHealth(enemyAI.getHealth());
                    panelUIInst.setEnemyArmor(enemyAI.getDefense());
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
                        panelUIInst.displayPlayerTurn(userPlayer.hand.getLastCardText());
                        testBattle.startTurn(cardSelected);
                        panelUIInst.setCardBackFromPlayer(userPlayer.getImagePaths());
                        panelUIInst.cardCoolDownUpdate();
                        panelUIInst.setMessage("\nArmor: "+userPlayer.getDefense());
                        panelUIInst.displayEnemyTurn(enemyAI.hand.getLastCardText());
                    } else {
                        //print cooldown of card selected
                        panelUIInst.setMessage("\nCard still on COOL DOWN: " + userPlayer.hand.getCoolDownTime(cardSelected) + " turns left");
                    }

                    if (testBattle.isOver()) {
                    	save.saveGame(userPlayer);
                        System.out.println("\n\nBattle is over!");
                        if(testBattle.whoIsDead()==1){
                            System.out.println("\n\nYOU HAVE WON!");
                            panelUIInst.setWinner(1);
                        } else {
                            System.out.println("\n\nYou’ve Met with a Terrible Fate, Haven’t You?");
                            panelUIInst.setWinner(0);
                        }
                        gameLoop = false;
                        panelUIInst.setStartGame0();
                        //needBattle = 1;
                    }
                    panelUIInst.setCardWaitingTrue();
                }//End of GameLoop
                gameLoop = true;
                panelUIInst.battleTearDown();
                panelUIInst.createContinue();
                while(panelUIInst.getWinner() != -1){
                    if(panelUIInst.getContinue() == 1){
                        panelUIInst.setWinner(-1);
                    } else {
                        Thread.sleep(100);
                    }
                }

                panelUIInst.createStartUI();

            } else if(panelUIInst.canShop()==1){
                while (panelUIInst.canShop() == 1) {
                    if (panelUIInst.getExitFlag()==1) {
                        panelUIInst.setExitFlag0();
                        break;
                    } else {
                        if(panelUIInst.needShopLib()==1) panelUIInst.setShopLibrary();
                        Thread.sleep(100);
                    }
                    //panelUIInst.updateFrame();
                }
                //RETURN HAND CHANGES
            } else {
                Thread.sleep(100);
            }
        }
    }

    public void deckSetup(User p1, AI e1){

    }

}
