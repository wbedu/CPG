/**
 * Created by Steve on 3/5/2017.
 */
public class Battle {
    private Player user;
    private Player enemy;
    private Deck uDeck;
    private Deck eDeck;

    public void turn()
    {
    }

    Battle(Player p1, Player e, Deck p1Deck, Deck enemyDeck)
    {
        user = p1;
        enemy = e;
        uDeck = p1Deck;
        eDeck = enemyDeck;
    }
}
