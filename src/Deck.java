/**
 * Created with InteliJ IDEA
 * User: vmotoroiu
 * Date: 1/18/2017
 * Time: 11:49 AM
 */
import java.util.ArrayList;
import java.util.Random;

/**
 * Created with InteliJ IDEA
 * User: vmotoroiu
 * Date: 1/18/2017
 * Time: 09:53 AM
 */
public class Deck {

    private ArrayList<Card> cards;

    public Deck(){
        this.cards = new ArrayList<Card>();
    }

    //Add 52 playing cards to a deck
    public void createFullDeck(){
        for(Suit cardSuit : Suit.values()){
            for(Value cardValue : Value.values()){
                this.cards.add(new Card(cardSuit,cardValue));
            }
        }
    }


    //Shuffle deck of cards
    public void shuffle(){
        ArrayList<Card> tmpDeck = new ArrayList<Card>();
        Random random = new Random();
        int randomCardIndex = 0;
        int originalSize = this.cards.size();
        for(int i = 0; i<originalSize;i++){
            randomCardIndex = random.nextInt((this.cards.size()-1 - 0) + 1) + 0;
            tmpDeck.add(this.cards.get(randomCardIndex));
            this.cards.remove(randomCardIndex);
        }
        this.cards = tmpDeck;
    }


    //Remove a card from the deck
    public void removeCard(int i){
        this.cards.remove(i);
    }
    //Get card from deck
    public Card getCard(int i){
        return this.cards.get(i);
    }

    //Add card to deck
    public void addCard(Card addCard){
        this.cards.add(addCard);
    }

    //Draw a top card from deck
    public void draw(Deck comingFrom){
        this.cards.add(comingFrom.getCard(0));
        comingFrom.removeCard(0);
    }

    //Use to print out deck
    public String toString(){
        String cardListOutput = " ";
        int i = 0;
        for(Card aCard : this.cards){
            cardListOutput += aCard.toString()+", ";
            i++;
        }
        return cardListOutput;
    }


    public int deckSize(){
        return this.cards.size();
    }

    //Calculate the value of deck
    public int cardsValue(){
        int totalValue = 0;
        int aces = 0;
        for(Card aCard : this.cards){
            switch(aCard.getValue()){
                case TWO: totalValue += 2; break;
                case THREE: totalValue += 3; break;
                case FOUR: totalValue += 4; break;
                case FIVE: totalValue += 5; break;
                case SIX: totalValue += 6; break;
                case SEVEN: totalValue += 7; break;
                case EIGHT: totalValue += 8; break;
                case NINE: totalValue += 9; break;
                case TEN: totalValue += 10; break;
                case JACK: totalValue += 10; break;
                case QUEEN: totalValue += 10; break;
                case KING: totalValue += 10; break;
                case ACE: aces += 1; break;
            }
        }

        //Aces 11 or 1
        for(int i = 0; i < aces; i++){
            if (totalValue > 10){
                totalValue += 1;
            }else{
                totalValue += 11;
            }
        }
        return totalValue;

    }


}
