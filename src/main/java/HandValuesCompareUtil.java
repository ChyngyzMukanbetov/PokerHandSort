public abstract class HandValuesCompareUtil {
    public static int chooseCompareToByHandValue(String[] hand1, String[] hand2, HandValue handValue) {
        if (handValue.equals(HandValue.ROYAL_FLUSH)) {
            return 0;
        } else if (handValue.equals(HandValue.STRAIGHT_FLUSH)) {
            return StraightUtil.compareTwoStraight(hand1, hand2);
        } else if (handValue.equals(HandValue.FOUR_OF)) {
            return FourOfUtil.compareTwoFourOf(hand1, hand2);
        } else if (handValue.equals(HandValue.FULL_HOUSE)) {
            return FullHouseUtil.compareTwoFullHouse(hand1, hand2);
        } else if (handValue.equals(HandValue.FLUSH)) {
            return FlushUtil.compareTwoFlush(hand1, hand2);
        } else if (handValue.equals(HandValue.STRAIGHT)) {
            return StraightUtil.compareTwoStraight(hand1, hand2);
        } else if (handValue.equals(HandValue.THREE_OF)) {
            return ThreeOfUtil.compareTwoThreeOf(hand1, hand2);
        } else if (handValue.equals(HandValue.TWO_PAIRS)) {
            return TwoPairsUtil.compareTwoTwoPairs(hand1, hand2);
        } else if (handValue.equals(HandValue.PAIR)) {
            return PairUtil.compareTwoPair(hand1, hand2);
        } else return HighCardUtil.compareHighCards(hand1, hand2);
    }
}