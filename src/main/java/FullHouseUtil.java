import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class FullHouseUtil {
    public static boolean isFullHouse(String[] hand) {
        List<Nominal> nominalsExist = Arrays.stream(hand).map(nominal -> nominal.split("")[0]).map(n -> Nominal.getByValue(n)).distinct().collect(Collectors.toList());

        if (nominalsExist.size() != 2) {
            return false;
        } else if (Collections.frequency(Arrays.stream(hand).map(nominal -> nominal.split("")[0]).map(n -> Nominal.getByValue(n)).collect(Collectors.toList()), nominalsExist.get(0)) == 2
                || Collections.frequency(Arrays.stream(hand).map(nominal -> nominal.split("")[0]).map(n -> Nominal.getByValue(n)).collect(Collectors.toList()), nominalsExist.get(0)) == 3) {
            return true;
        } else return false;
    }

    public static int compareTwoFullHouse (String[] hand1, String[] hand2) {

        List<Nominal> nominalsExistHand1 = Arrays.stream(hand1).map(nominal -> nominal.split("")[0]).map(n -> Nominal.getByValue(n)).distinct().collect(Collectors.toList());
        List<Nominal> nominalsExistHand2 = Arrays.stream(hand2).map(nominal -> nominal.split("")[0]).map(n -> Nominal.getByValue(n)).distinct().collect(Collectors.toList());

        Nominal nominalOfThreeHand1;
        Nominal nominalOfPairHand1;
        Nominal nominalOfThreeHand2;
        Nominal nominalOfPairHand2;

        if (Collections.frequency(Arrays.stream(hand1).map(nominal -> nominal.split("")[0]).map(n -> Nominal.getByValue(n)).collect(Collectors.toList()), nominalsExistHand1.get(0)) == 3) {
            nominalOfThreeHand1 = nominalsExistHand1.get(0);
            nominalOfPairHand1 = nominalsExistHand1.get(1);
        } else {
            nominalOfThreeHand1 = nominalsExistHand1.get(1);
            nominalOfPairHand1 = nominalsExistHand1.get(0);
        }

        if (Collections.frequency(Arrays.stream(hand2).map(nominal -> nominal.split("")[0]).map(n -> Nominal.getByValue(n)).collect(Collectors.toList()), nominalsExistHand2.get(0)) == 3) {
            nominalOfThreeHand2 = nominalsExistHand2.get(0);
            nominalOfPairHand2 = nominalsExistHand2.get(1);
        } else {
            nominalOfThreeHand2 = nominalsExistHand2.get(1);
            nominalOfPairHand2 = nominalsExistHand2.get(0);
        }

        if (nominalOfThreeHand1.compareTo(nominalOfThreeHand2) != 0) {
            return nominalOfThreeHand1.compareTo(nominalOfThreeHand2);
        } else return nominalOfPairHand1.compareTo(nominalOfPairHand2);
    }

}
