package kyu6;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array, find the integer that appears an odd number of times.
 * There will always be only one integer that appears an odd number of times.
 */
public class FindOdd {
    public static int findIt(int[] a) {
        HashMap<Integer, Integer> numbers = new HashMap<>();
        Arrays.stream(a).forEach(i -> numbers.merge(i, 1, Integer::sum));
        return numbers.entrySet().stream().filter(i -> i.getValue() % 2 != 0).findFirst().get().getKey();
    }
}
