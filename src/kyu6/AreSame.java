package kyu6;

import java.util.Arrays;

/**
 * Given two arrays a and b write a function comp(a, b) that checks whether the two arrays have the "same" elements, with the same multiplicities.
 * "Same" means, here, that the elements in b are the elements in a squared, regardless of the order.
 * Examples:
 * Valid arrays:
 * a = [121, 144, 19, 161, 19, 144, 19, 11]
 * b = [121, 14641, 20736, 361, 25921, 361, 20736, 361]
 * a = [121, 144, 19, 161, 19, 144, 19, 11]
 * b = [11*11, 121*121, 144*144, 19*19, 161*161, 19*19, 144*144, 19*19]
 * Invalid arrays
 * If we change the first number to something else, comp may not return true anymore:
 * a = [121, 144, 19, 161, 19, 144, 19, 11]
 * b = [132, 14641, 20736, 361, 25921, 361, 20736, 361]
 */
public class AreSame {
    public static boolean comp(int[] a, int[] b) {
        if (a == null || b == null || a.length != b.length)
            return false;

        int[] sortedA = Arrays.stream(a).map(x -> x * x).sorted().toArray();
        int[] sortedB = Arrays.stream(b).sorted().toArray();
        return Arrays.equals(sortedA, sortedB);
    }
}
