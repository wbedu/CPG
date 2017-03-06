/**
 * Created by Steve on 3/5/2017.
 */
public class Battle {
    private Player user;
    private Player enemy;
    private Deck uDeck;
    private Deck eDeck;
    private int turnNo;

    public void turn() {
        turnNo++;
    }

    public void doBattle() {
        while(!user.isDead() || !enemy.isDead()) {
            turn();
        }
    }

    Battle(Player p1, Player e, Deck p1Deck, Deck enemyDeck) {
        user = p1;
        enemy = e;
        uDeck = p1Deck;
        eDeck = enemyDeck;
        turnNo = 1;

    }
}
