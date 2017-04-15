package everything.cardPackage;
import everything.*;

/**
 * Created by Steve on 3/5/2017.
 */


public abstract class Card {
    protected String text;
    protected String name;
    protected String cardType;
    private static  String imagePath;
    protected int tempCD;
    protected int cooldown;
    private int advantage;

    public Card(String cardText, String cName, String cType, int cd,int advantage){
        text = cardText;
        name = cName;
        cardType = cType;
        cooldown = cd;
        tempCD = 0;
        this.advantage=advantage;
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
	public static String getImagePath() {
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
    
    public String getText(){
		return text;
    }
   
}
