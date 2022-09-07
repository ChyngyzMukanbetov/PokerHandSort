import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class FourOfUtil {
    public static boolean isFourOf(String[] hand) {
        List<Nominal> nominalsExist = Arrays.stream(hand).map(nominal -> nominal.split("")[0]).map(n -> Nominal.getByValue(n)).distinct().collect(Collectors.toList());

        if (nominalsExist.size() != 2) {
            return false;
        } else if (Collections.frequency(Arrays.stream(hand).map(nominal -> nominal.split("")[0]).map(n -> Nominal.getByValue(n)).collect(Collectors.toList()), nominalsExist.get(0)) == 1
                || Collections.frequency(Arrays.stream(hand).map(nominal -> nominal.split("")[0]).map(n -> Nominal.getByValue(n)).collect(Collectors.toList()), nominalsExist.get(0)) == 4) {
            return true;
        } else return false;
    }

    public static int compareTwoFourOf (String[] hand1, String[] hand2) {
        List<Nominal> nominalsExistHand1 = Arrays.stream(hand1).map(nominal -> nominal.split("")[0]).map(n -> Nominal.getByValue(n)).distinct().collect(Collectors.toList());
        List<Nominal> nominalsExistHand2 = Arrays.stream(hand2).map(nominal -> nominal.split("")[0]).map(n -> Nominal.getByValue(n)).distinct().collect(Collectors.toList());

        Nominal nominalOfFourHand1;
        Nominal nominalOfSingleHand1;
        Nominal nominalOfFourHand2;
        Nominal nominalOfSingleHand2;

        if (Collections.frequency(Arrays.stream(hand1).map(nominal -> nominal.split("")[0]).map(n -> Nominal.getByValue(n)).collect(Collectors.toList()), nominalsExistHand1.get(0)) == 4) {
            nominalOfFourHand1 = nominalsExistHand1.get(0);
            nominalOfSingleHand1 = nominalsExistHand1.get(1);
        } else {
            nominalOfFourHand1 = nominalsExistHand1.get(1);
            nominalOfSingleHand1 = nominalsExistHand1.get(0);
        }

        if (Collections.frequency(Arrays.stream(hand2).map(nominal -> nominal.split("")[0]).map(n -> Nominal.getByValue(n)).collect(Collectors.toList()), nominalsExistHand2.get(0)) == 4) {
            nominalOfFourHand2 = nominalsExistHand2.get(0);
            nominalOfSingleHand2 = nominalsExistHand2.get(1);
        } else {
            nominalOfFourHand2 = nominalsExistHand2.get(1);
            nominalOfSingleHand2 = nominalsExistHand2.get(0);
        }

        if (nominalOfFourHand1.compareTo(nominalOfFourHand2) != 0) {
            return nominalOfFourHand1.compareTo(nominalOfFourHand2);
        } else return nominalOfSingleHand1.compareTo(nominalOfSingleHand2);
    }
}
