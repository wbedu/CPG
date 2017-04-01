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
        tempCD = 0;
    }

    public void setCooldown(){
        tempCD = cooldown;
    }

    public boolean checkCooldown(){
        if(tempCD == 0)
        {
            return true;
        }else{
            System.out.println("On cooldown " + this.getCooldownTime() + " turns left!");
        	return false;
        }
    }

    public  void decrementCooldown(){
        if(tempCD>0)
          tempCD-=1;
    }


    public void cardFunction(Player p1, Player p2) {
    }

    public int getCooldownTime(){
        return (tempCD);
    }

    public boolean compareType(Card c1)
    {
        return this.cardType.equals(c1.cardType);
    }

    public Card() {
        text = "everything.Card Doesn't Exit";
        name = "nonexistant everything.Card";
        cardType = "NONE";
        cooldown = 0;
    }
   
}
