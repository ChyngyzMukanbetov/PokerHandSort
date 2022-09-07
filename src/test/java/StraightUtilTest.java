import org.junit.Assert;
import org.junit.Test;

public class StraightUtilTest {

    @Test
    public void isStraight() {
        Assert.assertTrue(StraightUtil.isStraight(new PokerHand("2D 3S 4C 5D 6C").getHand()));
        Assert.assertTrue(StraightUtil.isStraight(new PokerHand("AD TS KC JD QC").getHand()));
        Assert.assertFalse(StraightUtil.isStraight(new PokerHand("2D 3S 4C 5D 7C").getHand()));
        Assert.assertFalse(StraightUtil.isStraight(new PokerHand("2D JS 4C TD 6C").getHand()));
    }
}