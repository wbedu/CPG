package everything.cardPackage;


import java.util.ArrayList;

/**
 * Created by Steve on 4/17/2017.
 */
public class CardList {
     private ArrayList<Card> cardList;

     public CardList(){
        cardList = new ArrayList<Card>();
    }

     void createList(){
         addCard(new Assassinate());
         addCard(new Block());
         addCard(new Cleave());
         addCard(new Detox());
         addCard(new ImmolateArmor());
         addCard(new Mutton());
         addCard(new NordicBlood());
         addCard(new SavageStrike());
         addCard(new Slice());
    }

    void displayShopCards(){
        for(int i=0;i<cardList.size();i++){
            if(!cardList.get(i).isOwned()){
                cardList.get(i).printCardInfo();
            }
        }
    }

    void displayerAvailableCards(){
        for(int i=0;i<cardList.size();i++){
            if(cardList.get(i).isOwned()){
                cardList.get(i).printCardInfo();
            }
        }
    }

     void addCard(Card newCard){
        cardList.add(newCard);
    }
}
