/**
 * Created with InteliJ IDEA
 * User: vmotoroiu
 * Date: 1/18/2017
 * Time: 09:49 AM
 */
public enum Suit {
    HEART("\u2665"),
    DIAMOND("\u2666"),
    CLUB("\u2663"),
    SPADE("\u2660");

    String suitChar;
    private Suit(String suitChar){
        this.suitChar = suitChar;
    }
}
