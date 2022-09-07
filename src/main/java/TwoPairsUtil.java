import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class TwoPairsUtil {
    public static boolean isTwoPairs(String[] hand) {
        List<Nominal> nominalsExist = Arrays.stream(hand).map(nominal -> nominal.split("")[0]).map(n -> Nominal.getByValue(n)).distinct().collect(Collectors.toList());

        if (nominalsExist.size() != 3) {
            return false;
        } else if (Collections.frequency(Arrays.stream(hand).map(nominal -> nominal.split("")[0]).map(n -> Nominal.getByValue(n)).collect(Collectors.toList()), nominalsExist.get(0)) == 2
                || Collections.frequency(Arrays.stream(hand).map(nominal -> nominal.split("")[0]).map(n -> Nominal.getByValue(n)).collect(Collectors.toList()), nominalsExist.get(1)) == 2
                || Collections.frequency(Arrays.stream(hand).map(nominal -> nominal.split("")[0]).map(n -> Nominal.getByValue(n)).collect(Collectors.toList()), nominalsExist.get(2)) == 2) {
            return true;
        } else return false;
    }

    public static int compareTwoTwoPairs(String[] hand1, String[] hand2) {
        List<Nominal> nominalsExistHand1 = Arrays.stream(hand1).map(nominal -> nominal.split("")[0]).map(n -> Nominal.getByValue(n)).distinct().collect(Collectors.toList());
        List<Nominal> nominalsExistHand2 = Arrays.stream(hand2).map(nominal -> nominal.split("")[0]).map(n -> Nominal.getByValue(n)).distinct().collect(Collectors.toList());

        Nominal nominalOfSingleHand1 = null;
        Nominal nominalOfSingleHand2 = null;

        for (int i = 0; i < nominalsExistHand1.size(); i++) {
            if (Collections.frequency(Arrays.stream(hand1).map(nominal -> nominal.split("")[0])
                    .map(n -> Nominal.getByValue(n)).collect(Collectors.toList()), nominalsExistHand1.get(i)) == 1) {
                nominalOfSingleHand1 = nominalsExistHand1.get(i);
            }
        }

        for (int j = 0; j < nominalsExistHand2.size(); j++) {
            if (Collections.frequency(Arrays.stream(hand2).map(nominal -> nominal.split("")[0])
                    .map(n -> Nominal.getByValue(n)).collect(Collectors.toList()), nominalsExistHand2.get(j)) == 1) {
                nominalOfSingleHand2 = nominalsExistHand2.get(j);
            }
        }

        List<Nominal> nominalsOfPairsHand1 = nominalsExistHand1.stream().sorted().collect(Collectors.toList());
        nominalsOfPairsHand1.remove(nominalOfSingleHand1);

        List<Nominal> nominalsOfPairsHand2 = nominalsExistHand2.stream().sorted().collect(Collectors.toList());
        nominalsOfPairsHand2.remove(nominalOfSingleHand2);

        int result = 0;

        for (int i = nominalsOfPairsHand1.size() - 1; i >= 0 && result == 0; i--) {
            if (nominalsOfPairsHand1.get(i).compareTo(nominalsOfPairsHand2.get(i)) != 0) {
                result = nominalsOfPairsHand1.get(i).compareTo(nominalsOfPairsHand2.get(i));
            }
        }

        if (result == 0) {
            result = nominalOfSingleHand1.compareTo(nominalOfSingleHand2);
        }

        return result;
    }
}
