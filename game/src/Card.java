/**
 * Created by Steve on 3/5/2017.
 */
public abstract class Card {
    private String text;
    private int cooldown;
    private int tempCD;

    Card(String cardText, int cd){
        text = cardText;
        cooldown = cd;
        tempCD = 0;
    }

    private boolean checkCooldown(){
        if(tempCD == 0)
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

    public void incrementCooldown(){
        if(tempCD != 0)
          tempCD = tempCD++;
        else if (tempCD < cooldown){
            tempCD = tempCD++;
        }
        else {
            tempCD = 0;
        }
    }

    public void cardFunction(Player p, Player e) {
        if (checkCooldown()) {
        }
        else {
            System.out.println("Card is on cooldown!");
        }
    }
}
