import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public abstract class StraightUtil {
    public static boolean isStraight(String[] hand) {
        List<Nominal> list = Arrays.stream(hand).map(nominal -> nominal.split("")[0]).map(n -> Nominal.getByValue(n))
                .sorted().collect(Collectors.toList());


        boolean isStreaght = true;
        for (int i=0; i < list.size()-1 && isStreaght; i++) {
            if (list.get(i).compareTo(list.get(i+1)) != -1) {
                isStreaght = false;
            }
        }
        return isStreaght;
    }

    public static int compareTwoStraight(String[] hand1, String[] hand2) {
        return Arrays.stream(hand1).map(nominal -> nominal.split("")[0]).map(n -> Nominal.getByValue(n)).sorted().collect(Collectors.toList()).get(0)
                .compareTo(Arrays.stream(hand2).map(nominal -> nominal.split("")[0]).map(n -> Nominal.getByValue(n)).sorted().collect(Collectors.toList()).get(0));
    }
}
