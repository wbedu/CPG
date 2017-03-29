package everything;

/**
 * Created by Steve on 3/5/2017.
 */


public abstract class Card {
    protected String text;
    protected String name;
    protected String cardType;
    protected int tempCD;
    protected int cooldown;


    public Card(String cardText, String cName, String cType, int cd){
        text = cardText;
        name = cName;
        cardType = cType;
        cooldown = cd;
        tempCD = cd;
    }

    public void setCooldown(){
        tempCD = -1;
    }

    public boolean checkCooldown(){
        if(tempCD >=0)
        {
            return true;
        }else{
        	return false;
        }
    }

    public  void decrementCooldown(){
        if(tempCD>0)
          --tempCD;
    }


    public void cardFunction(Player p1, Player p2) {
        if (checkCooldown()) {
        }
        else {
        	decrementCooldown();
            System.out.println("everif(ything.Card is on cooldown!");
        }
    }

    public boolean compareType(Card c1)
    {
        return this.cardType.equals(c1.cardType);
    }

    public Card() {
        text = "everything.Card Doesn't Exit";
        name = "nonexistant everything.Card";
        cardType = "NONE";
        cooldown = -999;
    }
   
}
