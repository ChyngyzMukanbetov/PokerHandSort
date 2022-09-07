import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class HighCardUtil {

    public static int compareHighCards(String[] hand1, String[] hand2) {

        List<Nominal> nominalsExistHand1 = Arrays.stream(hand1).map(nominal -> nominal.split("")[0]).map(n -> Nominal.getByValue(n)).sorted().collect(Collectors.toList());
        List<Nominal> nominalsExistHand2 = Arrays.stream(hand2).map(nominal -> nominal.split("")[0]).map(n -> Nominal.getByValue(n)).sorted().collect(Collectors.toList());

        int result = 0;

        for (int i = nominalsExistHand1.size() - 1; i >= 0 && result == 0; i--) {
            result = nominalsExistHand1.get(i).compareTo(nominalsExistHand2.get(i));
        }

        return result;
    }
}
