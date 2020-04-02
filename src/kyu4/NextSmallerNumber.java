package kyu4;

import java.util.*;

/**
 * Write a function that takes a positive integer and returns the next smaller positive integer containing the same digits.
 * For example:
 * nextSmaller(21) == 12
 * nextSmaller(531) == 513
 * nextSmaller(2071) == 2017
 * nextSmaller(9) == -1
 * nextSmaller(111) == -1
 * nextSmaller(135) == -1
 * nextSmaller(1027) == -1 // 0721 is out since we don't write numbers with leading zeros
 */
public class NextSmallerNumber {
    public static long nextSmallerInt(long n) {
        char[] chars = Long.toString(n).toCharArray();
        int[] numbers = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            numbers[i] = Character.digit(chars[i], 10);
        }

        int startingIndex = numbers.length - 1;
        for (int i = numbers.length - 2; i >= 0; i--) {
            int max = i == 0 ? 0 : Integer.MIN_VALUE;
            int maxIndex = -1;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] > max && numbers[j] < numbers[i]) {
                    max = numbers[j];
                    maxIndex = j;
                }
            }
            if (maxIndex >= 0) {
                int temp = numbers[maxIndex];
                numbers[maxIndex] = numbers[i];
                numbers[i] = temp;
                startingIndex = i;
                break;
            }
        }

        for (int i = startingIndex + 1; i < numbers.length - 1; i++) {
            int max = numbers[i];
            int sortIndex = i;
            for (int j = i; j < numbers.length; j++) {
                if (numbers[j] > max) {
                    max = numbers[j];
                    sortIndex = j;
                }
            }
            int temp = numbers[i];
            numbers[i] = max;
            numbers[sortIndex] = temp;
        }
        StringBuilder newNumbers = new StringBuilder();
        for (int number : numbers) {
            newNumbers.append(number);
        }
        long newValue = Long.parseLong(newNumbers.toString());
        return newValue == n ? -1 : newValue;
    }

    //=======================================================

    private static List<String> vals = new ArrayList<>();

    public static long nextSmaller(long n) {
        vals.clear();
        String value = String.valueOf(n);
        permute(value, 0, value.length() - 1);
        Collections.sort(vals);
        int index = vals.indexOf(value);
        if (index == 0) return -1;
        if (vals.get(index - 1).charAt(0) == '0') return -1;
        return Long.parseLong(vals.get(index - 1));
    }

    private static void permute(String str, int l, int r) {
        if (l == r) vals.add(str);
        else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    private static String swap(String a, int i, int j) {
        char[] charArray = a.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
}
