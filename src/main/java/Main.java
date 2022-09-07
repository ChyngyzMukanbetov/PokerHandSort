import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ArrayList<PokerHand> hands = new ArrayList<>();

        hands.add(new PokerHand("7C 3C 6C 4D 5C"));
        hands.add(new PokerHand("2C 3C 6C 4C 5C"));
        hands.add(new PokerHand("9C 7C 6C 8C 5C"));
        hands.add(new PokerHand("QH 5H JH 2H 7H"));
        hands.add(new PokerHand("KS KC KH 9S 6H"));
        hands.add(new PokerHand("4S 4C 4D 4H AD"));
        hands.add(new PokerHand("JD JH JC JS 7S"));
        hands.add(new PokerHand("KS 2H 5C JD TD"));
        hands.add(new PokerHand("8H 9S TS JD QC"));
        hands.add(new PokerHand("KC 7C 6H 8H 9S"));
        hands.add(new PokerHand("4H 6C 8S TD QH"));
        hands.add(new PokerHand("4H JC JH QS QD"));
        hands.add(new PokerHand("AS KS JS QS TS"));
        hands.add(new PokerHand("AH QH TH JH KH"));
        hands.add(new PokerHand("AH AS TH TC 6H"));
        hands.add(new PokerHand("QH QS KD KC KH"));
        hands.add(new PokerHand("2C 3C AC 4C 5C"));
        hands.add(new PokerHand("QH QS 9S 6H 7C"));
        hands.add(new PokerHand("8D 7D TD JD 9D"));
        hands.add(new PokerHand("AS 5S 7S 9S JS"));
        hands.add(new PokerHand("2D AH 7H TC TS"));
        hands.add(new PokerHand("AH 2C 3D 4C 5H"));
        hands.add(new PokerHand("QD QH QS 5D 5H"));
        hands.add(new PokerHand("7H TS KH KD KC"));

        Collections.sort(hands);

        for (PokerHand ph : hands) {
            for (String p : ph.getHand()) {
                System.out.print(p + " ");
            }
            System.out.println("= " + ph.getHandValue());
        }
    }
}