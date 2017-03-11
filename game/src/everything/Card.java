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
        if(tempCD == cooldown)
        {
            return true;
        }
        else
        {
            int timeleft = cooldown - tempCD;
            System.out.println("card is on cooldown for "+timeleft+"turns");
            return false;
        }
    }

    public  void incrementCooldown(Player p){
        if(tempCD != cooldown)
          tempCD = tempCD++;
        }


    public void cardFunction(Player p, Player e) {
        if (checkCooldown()) {
        }
        else {
            System.out.println("everything.Card is on cooldown!");
        }
    }

    public boolean compareType(Card c1)
    {
        if(this.cardType.equals(c1.cardType))
            return true;
        else {
            return false;
        }
    }

    public Card() {
        text = "everything.Card Doesn't Exit";
        name = "nonexistant everything.Card";
        cardType = "NONE";
        cooldown = -999;
    }

}
