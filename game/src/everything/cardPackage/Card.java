package everything.cardPackage;
import everything.*;

/**
 * Created by Steve on 3/5/2017.
 */


public abstract class Card {
    protected String text;
    protected String name;
    protected String cardType;
    private   String imagePath;
    protected int tempCD;
    protected int cooldown;
    private int advantage;
    protected boolean ownedByPlayer;

    public Card(String cardText, String cName, String cType, int cd,int advantage, boolean isOwned){
        text = cardText;
        name = cName;
        cardType = cType;
        cooldown = cd;
        tempCD = 0;
        this.advantage=advantage;
        ownedByPlayer = isOwned;
        setImagePath("images/".concat(this.getClass().getSimpleName()).concat(".jpg"));
    }
    public int getAdvantage(){
    	return this.advantage;
    }
    public void setCooldown(){
        tempCD = cooldown;
    }
    
    /**
	 * @return the imagePath
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * @param imagePath the imagePath to set
	 */
	protected void setImagePath(String setImagePath) {
		imagePath = setImagePath;
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

    public  void decrementCooldown(Player p1){
        if(tempCD>0)
          tempCD-=1;
    }


    public void cardFunction(Player p1, Player p2) {
    }

    public void printCardInfo(){
        System.out.println("Card: "+  this.name + " cooldown: " + this.cooldown + "Card Type: " +this.cardType );
        System.out.println(this.text);
    }

    public boolean isOwned() {return ownedByPlayer; }
    public int getCooldownTime(){
        return (tempCD);
    }
    public String getCardType(){
    	return cardType;
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

    public void setOwnedByPlayer(){
        if (ownedByPlayer = false)
            ownedByPlayer = true;
    }
    public String getText(){
		return text;
    }
   
}
