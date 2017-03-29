package everything;
import everything.cardPackage.*;

/**
 * Created by Aaron on 3/4/17.
 */
public class client {
    public static void main(String args[]){
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

        //First Battle
        while(gameLoop){
            if(needBattle==1){
                testBattle = new Battle(userPlayer, enemyAI);
                needBattle = 0;
            }
            while(panelUIInst.getCardWaiting()){
                //System.out.println(panelUIInst.getCardWaiting());
            }
            System.out.println("Farters");
            cardSelected = panelUIInst.getCardSelect(); //This gets the current selected card
                                                        //Pass into Battle
            //DO BATTLE
            testBattle.startTurn(cardSelected);

            if(testBattle.isOver()){
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
