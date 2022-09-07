import junit.framework.TestCase;
import org.junit.Assert;

public class PokerHandTest extends TestCase {

    public void testCompareTo() {
        //HIGH_CARD test
        Assert.assertTrue(new PokerHand("JD 5S 9C AS TD").compareTo(new PokerHand("JD 5S 5C AS TD")) < 0);
        Assert.assertTrue(new PokerHand("JD 5S 9C AS TD").compareTo(new PokerHand("JD KS 5C AS TD")) < 0);
        Assert.assertTrue(new PokerHand("JD 5S 9C AS TD").compareTo(new PokerHand("JH 5C 9D AS TH")) == 0);
        Assert.assertTrue(new PokerHand("JD 5S 9C AS TD").compareTo(new PokerHand("JD QS 5C 4S TD")) > 0);
        Assert.assertTrue(new PokerHand("JD 5S 9C AS TD").compareTo(new PokerHand("3D TS 6C 4S 7D")) > 0);

        //PAIR test
        Assert.assertTrue(new PokerHand("JD 5S 5C AS TD").compareTo(new PokerHand("JD 8S 8C AS TD")) < 0);
        Assert.assertTrue(new PokerHand("JD 5S 5C AS TD").compareTo(new PokerHand("JD KS 5C AS 5D")) < 0);
        Assert.assertTrue(new PokerHand("JD 5S 5C AS TD").compareTo(new PokerHand("JS 5C 5D AD TH")) == 0);
        Assert.assertTrue(new PokerHand("JD 5S 5C AS TD").compareTo(new PokerHand("JD QS 5C 4S TD")) > 0);
        Assert.assertTrue(new PokerHand("JD 5S 5C AS TD").compareTo(new PokerHand("4D TS KC 4S QD")) > 0);

        //TWO_PAIRS test
        Assert.assertTrue(new PokerHand("JD 5S 5C AS TD").compareTo(new PokerHand("JD 8S 8C AS TD")) < 0);
        Assert.assertTrue(new PokerHand("JD 5S 5C AS TD").compareTo(new PokerHand("JD KS 5C AS 5D")) < 0);
        Assert.assertTrue(new PokerHand("JD 5S 5C AS TD").compareTo(new PokerHand("JS 5C 5D AD TH")) == 0);
        Assert.assertTrue(new PokerHand("JD 5S 5C AS TD").compareTo(new PokerHand("JD QS 5C 4S TD")) > 0);
        Assert.assertTrue(new PokerHand("JD 5S 5C AS TD").compareTo(new PokerHand("4D TS KC 4S QD")) > 0);

        //THREE_OF test
        Assert.assertTrue(new PokerHand("JD 5S 5C AS TD").compareTo(new PokerHand("JD 8S 8C AS TD")) < 0);
        Assert.assertTrue(new PokerHand("JD 5S 5C AS TD").compareTo(new PokerHand("JD KS 5C AS 5D")) < 0);
        Assert.assertTrue(new PokerHand("JD 5S 5C AS TD").compareTo(new PokerHand("JS 5C 5D AD TH")) == 0);
        Assert.assertTrue(new PokerHand("JD 5S 5C AS TD").compareTo(new PokerHand("JD QS 5C 4S TD")) > 0);
        Assert.assertTrue(new PokerHand("JD 5S 5C AS TD").compareTo(new PokerHand("4D TS KC 4S QD")) > 0);

        //STRAIGHT test
        Assert.assertTrue(new PokerHand("8D JS 9C QS TD").compareTo(new PokerHand("JD 8D 2D AD TD")) < 0);
        Assert.assertTrue(new PokerHand("8D JS 9C QS TD").compareTo(new PokerHand("KH JC 9D QS TH")) < 0);
        Assert.assertTrue(new PokerHand("8D JS 9C QS TD").compareTo(new PokerHand("8H JC 9D QS TH")) == 0);
        Assert.assertTrue(new PokerHand("8D JS 9C QS TD").compareTo(new PokerHand("JD JS JC 4S TD")) > 0);
        Assert.assertTrue(new PokerHand("8D JS 9C QS TD").compareTo(new PokerHand("8D 6S 9C 7S TD")) > 0);

        //FLUSH test
        Assert.assertTrue(new PokerHand("JD 8D 2D AD TD").compareTo(new PokerHand("JD JS JC 4S 4D")) < 0);
        Assert.assertTrue(new PokerHand("JD 8D 2D AD TD").compareTo(new PokerHand("JD QD 2D AD TD")) < 0);
        Assert.assertTrue(new PokerHand("JD 8D 2D AD TD").compareTo(new PokerHand("JH 8H 2H AH TH")) == 0);
        Assert.assertTrue(new PokerHand("JD 8D 2D AD TD").compareTo(new PokerHand("JD 8D 2D 9D TD")) > 0);
        Assert.assertTrue(new PokerHand("JD 8D 2D AD TD").compareTo(new PokerHand("KH JC 9D QS TH")) > 0);

        //FULL_HOUSE test
        Assert.assertTrue(new PokerHand("JD JS JC 4S 4D").compareTo(new PokerHand("JD JS JC 8S 8D")) < 0);
        Assert.assertTrue(new PokerHand("JD JS JC 4S 4D").compareTo(new PokerHand("JD JS JC JH 4D")) < 0);
        Assert.assertTrue(new PokerHand("JD JS JC 4S 4D").compareTo(new PokerHand("JD JH JC 4H 4C")) == 0);
        Assert.assertTrue(new PokerHand("JD JS JC 4S 4D").compareTo(new PokerHand("JD JS 4C 4S 4D")) > 0);
        Assert.assertTrue(new PokerHand("JD JS JC 4S 4D").compareTo(new PokerHand("KH JC 9D QS TH")) > 0);

        //FOUR_OF test
        Assert.assertTrue(new PokerHand("JD JS JC JH 4D").compareTo(new PokerHand("8H JH 9H 7H TH")) < 0);
        Assert.assertTrue(new PokerHand("JD JS JC JH 4D").compareTo(new PokerHand("JD JS JC JH KD")) < 0);
        Assert.assertTrue(new PokerHand("JD JS JC JH 4D").compareTo(new PokerHand("JD JS JC JH 4H")) == 0);
        Assert.assertTrue(new PokerHand("JD JS JC JH 4D").compareTo(new PokerHand("JD JS JC JH 2H")) > 0);
        Assert.assertTrue(new PokerHand("JD JS JC JH 4D").compareTo(new PokerHand("JD JS JC 8S 8D")) > 0);

        //STRAIGHT_FLUSH test
        Assert.assertTrue(new PokerHand("8H JH 9H 7H TH").compareTo(new PokerHand("KH JH AH QH TH")) < 0);
        Assert.assertTrue(new PokerHand("8H JH 9H 7H TH").compareTo(new PokerHand("8H JH 9H QH TH")) < 0);
        Assert.assertTrue(new PokerHand("8H JH 9H 7H TH").compareTo(new PokerHand("8D JD 9D 7D TD")) == 0);
        Assert.assertTrue(new PokerHand("8H JH 9H 7H TH").compareTo(new PokerHand("8H 6H 4H 7H 5H")) > 0);
        Assert.assertTrue(new PokerHand("8H JH 9H 7H TH").compareTo(new PokerHand("JD JS JC JH 8D")) > 0);

        //ROYAL_FLUSH test
        Assert.assertTrue(new PokerHand("KH JH AH QH TH").compareTo(new PokerHand("KS JS AS QS TS")) == 0);
        Assert.assertTrue(new PokerHand("KH JH AH QH TH").compareTo(new PokerHand("8H 6H 4H 7H 5H")) > 0);
        Assert.assertTrue(new PokerHand("KH JH AH QH TH").compareTo(new PokerHand("JD JS JC JH 8D")) > 0);
    }

    public void testHandValueDetermineting() {
        Assert.assertEquals(HandValue.HIGH_CARD, new PokerHand("JD 5S 9C AS TD").getHandValue());
        Assert.assertEquals(HandValue.PAIR, new PokerHand("JD 5S 9C 9S TD").getHandValue());
        Assert.assertEquals(HandValue.TWO_PAIRS, new PokerHand("JD 5S 9C 9S JD").getHandValue());
        Assert.assertEquals(HandValue.THREE_OF, new PokerHand("9D 5S 9C 9S JD").getHandValue());
        Assert.assertEquals(HandValue.STRAIGHT, new PokerHand("3D 5S 6C 4S 7D").getHandValue());
        Assert.assertEquals(HandValue.FLUSH, new PokerHand("3S AS 6S 9S 7S").getHandValue());
        Assert.assertEquals(HandValue.FULL_HOUSE, new PokerHand("3S 3D 6H 3C 6S").getHandValue());
        Assert.assertEquals(HandValue.FOUR_OF, new PokerHand("3S 3D QH 3C 3H").getHandValue());
        Assert.assertEquals(HandValue.STRAIGHT_FLUSH, new PokerHand("JD 9D QD 8D TD").getHandValue());
        Assert.assertEquals(HandValue.ROYAL_FLUSH, new PokerHand("JD KD QD AD TD").getHandValue());

        Assert.assertNotEquals(HandValue.HIGH_CARD, new PokerHand("JD 5S 5C AS TD").getHandValue());
        Assert.assertNotEquals(HandValue.PAIR, new PokerHand("JD 5S 5C JS TD").getHandValue());
        Assert.assertNotEquals(HandValue.TWO_PAIRS, new PokerHand("JD 5S 5C 5D TD").getHandValue());
        Assert.assertNotEquals(HandValue.THREE_OF, new PokerHand("JD 9S QC 8D TD").getHandValue());
        Assert.assertNotEquals(HandValue.STRAIGHT, new PokerHand("JD 9D QD 8D TD").getHandValue());
        Assert.assertNotEquals(HandValue.FLUSH, new PokerHand("JD 9D QD 8D TD").getHandValue());
        Assert.assertNotEquals(HandValue.FULL_HOUSE, new PokerHand("3S 3D QH 3C 3H").getHandValue());
        Assert.assertNotEquals(HandValue.FOUR_OF, new PokerHand("JD 9D QD 8D TD").getHandValue());
        Assert.assertNotEquals(HandValue.STRAIGHT_FLUSH, new PokerHand("JD KD QD AD TD").getHandValue());
        Assert.assertNotEquals(HandValue.ROYAL_FLUSH, new PokerHand("JD KC 3D 9D TH").getHandValue());
    }
}