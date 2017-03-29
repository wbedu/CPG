package everything;
import everything.cardPackage.*;

/**
 * Created by Aaron on 3/4/17.
 */
public class client {
    public static void main(String args[]){
        boolean gameLoop = true;
        panelUI panelUIInst = new panelUI();
        Battle testBattle;
        User userPlayer;
        AI enemyAI;
        int cardSelected, needBattle = 1;

        //Hand setup
        Block blockCard = new Block();
        Cleave cleaveCard = new Cleave();
        Mutton muttonCard = new Mutton();
        NordicBlood nordCard = new NordicBlood();
        SavageStrike savageCard = new SavageStrike();

        Hand playerHand = new Hand();
        playerHand.addCard(blockCard);
        playerHand.addCard(cleaveCard);
        playerHand.addCard(muttonCard);
        playerHand.addCard(nordCard);
        playerHand.addCard(savageCard);

        Hand enemyHand = new Hand();
        enemyHand.addCard(nordCard);   //???USING SAME CARD OBJECTS???
        enemyHand.addCard(savageCard);

        panelUIInst.setMessage("\nBattle with 'Shrak' the Ogre has begun!\n");    //this function takes a String and puts it in the message display

        userPlayer = new User("Aaron",10,3,3,playerHand);
        enemyAI = new AI("Shrak",10,1,2,enemyHand,3);

        //First Battle
        while(gameLoop){
            if(needBattle==1){
                testBattle = new Battle(userPlayer, enemyAI);
                needBattle = 0;
            }
            while(panelUIInst.getCardWaiting()){

            }
            cardSelected = panelUIInst.getCardSelect(); //This gets the current selected card
                                                        //Pass into Battle
            //DO BATTLE
            panelUIInst.setCardWaitingTrue();
        }

        //End battle if statement here
    }

}
