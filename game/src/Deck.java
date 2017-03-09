/**
 * Created by Steve on 3/5/2017.
 */
public class Deck {
    private Card[] hand;
    private int deckLength;

    Deck(int dl, Card c1, Card c2, Card c3, Card c4, Card c5, Card c6, Card c7, Card c8) {
        deckLength = dl;
        hand = new Card[deckLength];
        hand[0] = c1;
        hand[1] = c2;
        hand[2] = c3;
        hand[3] = c4;
        hand[4] = c5;
        hand[5] = c6;
        hand[6] = c7;
        hand[7] = c8;
    }

    Deck(int dl, Card c1, Card c2, Card c3)
    {
        deckLength = dl;
        hand = new Card[deckLength];
        hand[0] = c1;
        hand[1] = c2;
        hand[2] = c3;
    }

    private void changeCard(Card oldCard, Card newCard)
    {
        int i;
        for(i = 0; i < deckLength; i++) {
            if (hand[i] == oldCard) {
                if (hand[i].compareType(newCard))
                    hand[i] = newCard;
                else {
                    System.out.println("Card types do not match!");
                }
            }

        }
    }


    private void updateCooldowns(){
        for(int i = 0; i < deckLength; i++)
        {
            hand[i].incrementCooldown();
        }
    }
}
