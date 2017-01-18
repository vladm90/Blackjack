/**
 * Created with InteliJ IDEA
 * User: vmotoroiu
 * Date: 1/18/2017
 * Time: 09:46 AM
 */
public enum Value {
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JACK("J"),
    QUEEN("Q"),
    KING("K"),
    ACE("A");

    String valueChar;
    private Value(String valueChar){
        this.valueChar = valueChar;
    }
}
