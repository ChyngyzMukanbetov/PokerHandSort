import org.junit.Assert;
import org.junit.Test;

public class FlushUtilTest {

    @Test
    public void testIsFlush() {
        Assert.assertTrue(FlushUtil.isFlush(new PokerHand("2D 3D 4D 5D 6D").getHand()));
        Assert.assertFalse(FlushUtil.isFlush(new PokerHand("2D 3S 4C 5D 6C").getHand()));
        Assert.assertFalse(FlushUtil.isFlush(new PokerHand("7D 3S JC AD 3C").getHand()));
        Assert.assertTrue(FlushUtil.isFlush(new PokerHand("2S 7S JS AS 6S").getHand()));
    }
}