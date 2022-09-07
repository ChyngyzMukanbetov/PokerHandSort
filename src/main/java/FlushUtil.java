import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class FlushUtil {
    public static boolean isFlush(String[] hand) {
        return Arrays.stream(hand).map(mast -> mast.split("")[1]).map(m -> Mast.getByValue(m)).collect(Collectors.toSet()).size() == 1;
    }

    public static int compareTwoFlush(String[] hand1, String[] hand2) {
        List<Nominal> hand1Nominals = Arrays.stream(hand1).map(nominal -> nominal.split("")[0]).map(n -> Nominal.getByValue(n))
                .sorted().collect(Collectors.toList());
        List<Nominal> hand2Nominals = Arrays.stream(hand2).map(nominal -> nominal.split("")[0]).map(n -> Nominal.getByValue(n))
                .sorted().collect(Collectors.toList());

        int result = 0;

        for (int i = hand1Nominals.size() - 1; i >= 0 && result == 0; i--) {
            result = hand1Nominals.get(i).compareTo(hand2Nominals.get(i));
        }
        return result;
    }
}
