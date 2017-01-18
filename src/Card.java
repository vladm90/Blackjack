import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * Created with InteliJ IDEA
 * User: vmotoroiu
 * Date: 1/18/2017
 * Time: 09:55 AM
 */
public class Card {

    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value){
        this.suit = suit;
        this.value = value;
    }

    public String toString(){
        return this.value.valueChar + this.suit.suitChar.toLowerCase() ;
    }

    public Value getValue(){
        return this.value;
    }



}
