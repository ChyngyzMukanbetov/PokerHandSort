import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public abstract class PairUtil {
    public static boolean isPair(String[] hand) {
        if (Arrays.stream(hand).map(nominal -> nominal.split("")[0]).map(n -> Nominal.getByValue(n)).distinct().collect(Collectors.toList()).size() == 4) {
            return true;
        } else return false;
    }

    public static int compareTwoPair(String[] hand1, String[] hand2) {
        List<Nominal> nominalsExistHand1 = Arrays.stream(hand1).map(nominal -> nominal.split("")[0]).map(n -> Nominal.getByValue(n)).distinct().collect(Collectors.toList());
        List<Nominal> nominalsExistHand2 = Arrays.stream(hand2).map(nominal -> nominal.split("")[0]).map(n -> Nominal.getByValue(n)).distinct().collect(Collectors.toList());

        Nominal nominalOfPairHand1 = null;
        Nominal nominalOfPairHand2 = null;

        for (int i = 0; i < nominalsExistHand1.size(); i++) {
            if (Collections.frequency(Arrays.stream(hand1).map(nominal -> nominal.split("")[0])
                    .map(n -> Nominal.getByValue(n)).collect(Collectors.toList()), nominalsExistHand1.get(i)) == 2) {
                nominalOfPairHand1 = nominalsExistHand1.get(i);
            }
        }

        for (int j = 0; j < nominalsExistHand2.size(); j++) {
            if (Collections.frequency(Arrays.stream(hand2).map(nominal -> nominal.split("")[0])
                    .map(n -> Nominal.getByValue(n)).collect(Collectors.toList()), nominalsExistHand2.get(j)) == 2) {
                nominalOfPairHand2 = nominalsExistHand2.get(j);
            }
        }

        List<Nominal> nominalsOfSinglesHand1 = nominalsExistHand1.stream().sorted().collect(Collectors.toList());
        nominalsOfSinglesHand1.remove(nominalOfPairHand1);

        List<Nominal> nominalsOfSinglesHand2 = nominalsExistHand2.stream().sorted().collect(Collectors.toList());
        nominalsOfSinglesHand2.remove(nominalOfPairHand2);

        if (nominalOfPairHand1.compareTo(nominalOfPairHand2) != 0) {
            return nominalOfPairHand1.compareTo(nominalOfPairHand2);
        } else {
            int result = 0;
            for (int i = nominalsOfSinglesHand1.size() - 1; i >= 0 && result == 0; i--) {
                if (nominalsOfSinglesHand1.get(i).compareTo(nominalsOfSinglesHand2.get(i)) != 0) {
                    result = nominalsOfSinglesHand1.get(i).compareTo(nominalsOfSinglesHand2.get(i));
                }
            }
           return result;
        }
    }
}
