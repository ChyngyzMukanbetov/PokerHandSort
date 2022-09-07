import java.util.Arrays;
import java.util.stream.Collectors;

public class PokerHand implements Comparable<PokerHand>{
    private String[] hand;
    private HandValue handValue;

    public PokerHand(String pokerHand) {
        hand = pokerHand.split(" ");
        handValue = handValueDetermineting(hand);
    }

    public String[] getHand() {
        return hand;
    }

    public HandValue getHandValue() {
        return handValue;
    }

    @Override
    public int compareTo(PokerHand o) {
        if (this.getHandValue().compareTo(o.getHandValue()) != 0) {
            return this.getHandValue().compareTo(o.getHandValue());
        } else {
            return HandValuesCompareUtil.chooseCompareToByHandValue(this.getHand(), o.getHand(), this.getHandValue());
        }
    }

    public HandValue handValueDetermineting(String[] hand) {
        HandValue handValue;
        if (FlushUtil.isFlush(hand) && StraightUtil.isStraight(hand)) {
            if (Arrays.stream(hand).map(nominal -> nominal.split("")[0]).map(n -> Nominal.getByValue(n))
                    .collect(Collectors.toList()).contains(Nominal.ACE)) {
                handValue = HandValue.ROYAL_FLUSH;
            } else {
                handValue = HandValue.STRAIGHT_FLUSH;
            }
        } else if (FourOfUtil.isFourOf(hand)) {
            handValue = HandValue.FOUR_OF;
        } else if (FullHouseUtil.isFullHouse(hand)) {
            handValue = HandValue.FULL_HOUSE;
        } else if (FlushUtil.isFlush(hand)) {
            handValue = HandValue.FLUSH;
        } else if (StraightUtil.isStraight(hand)) {
            handValue = HandValue.STRAIGHT;
        } else if (ThreeOfUtil.isThreeOf(hand)) {
            handValue = HandValue.THREE_OF;
        } else if (TwoPairsUtil.isTwoPairs(hand)) {
            handValue = HandValue.TWO_PAIRS;
        } else if (PairUtil.isPair(hand)) {
            handValue = HandValue.PAIR;
        } else {
            handValue = HandValue.HIGH_CARD;
        }
        return handValue;
    }
}