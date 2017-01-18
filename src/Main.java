import java.nio.charset.Charset;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to Blackjack!");

        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();
        playingDeck.shuffle();

        Deck playerCards = new Deck();
        Deck dealerCards = new Deck();

        Scanner userInput = new Scanner(System.in);

        boolean endRound = false;

        System.out.println("Dealing...");
        //Player cards
        playerCards.draw(playingDeck);
        playerCards.draw(playingDeck);

        //Dealer cards
        dealerCards.draw(playingDeck);
        dealerCards.draw(playingDeck);

        //While loop for drawing new cards
        while (true) {
            //Display player cards
            System.out.println("Player:" + playerCards.toString() + "(value:" + playerCards.cardsValue() + ")");

            //Display dealer cards
            System.out.println("Dealer Hand: " + dealerCards.getCard(0).toString() + " and [hidden]");

            //What do they want to do
            System.out.println("Do you want to draw another card? (Y/N)");
            String response = userInput.next();

            //HIT STAND OR OTHER
            if (response.toLowerCase().equals("y")) {
                playerCards.draw(playingDeck);
                System.out.println("Player draw a: " + playerCards.getCard(playerCards.deckSize() - 1).toString());
                //Bust if they go over 21
                if (playerCards.cardsValue() > 21) {
                    System.out.println("Bust. Currently valued at: " + playerCards.cardsValue());
                    endRound = true;
                    break;
                }
            } else if (response.toLowerCase().equals("n")) {
                break;
            }

        }

        //Reveal Dealer Cards
        System.out.println("Dealer Cards:" + dealerCards.toString());
        //See if dealer has more points than player
        if ((dealerCards.cardsValue() > playerCards.cardsValue()) && endRound == false) {
            System.out.println("Dealer beats you " + dealerCards.cardsValue() + " to " + playerCards.cardsValue());
            endRound = true;
        }
        //Dealer hits at 16 stands at 17
        while ((dealerCards.cardsValue() < 17) && endRound == false) {
            dealerCards.draw(playingDeck);
            System.out.println("Dealer draws: " + dealerCards.getCard(dealerCards.deckSize() - 1).toString());
        }
        //Display value of dealer
        System.out.println("Dealers hand value: " + dealerCards.cardsValue());
        //Determine if dealer busted
        if ((dealerCards.cardsValue() > 21) && endRound == false) {
            System.out.println("Dealer Busts. You win!");
            endRound = true;
        }
        //Determine if push
        if ((dealerCards.cardsValue() == playerCards.cardsValue()) && endRound == false) {
            System.out.println("Push.");
            endRound = true;
        }
        //Determine if player wins
        if ((playerCards.cardsValue() > dealerCards.cardsValue()) && endRound == false) {
            System.out.println("You win the hand.");
            endRound = true;
        } else if (endRound == false) //dealer wins
        {
            System.out.println("Dealer wins.");
        }

        System.out.println("End of Hand.");

        //Close Scanner
        userInput.close();

    }


}
