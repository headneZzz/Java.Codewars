package kyu6;

/**
 * You are given an array strarr of strings and an integer k.
 * Your task is to return the first longest string consisting of k consecutive strings taken in the array.
 * <p>
 * Example:
 * longest_consec(["zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"], 2) --> "abigailtheta"
 * <p>
 * n being the length of the string array, if n = 0 or k > n or k <= 0 return "".
 * <p>
 * Note
 * consecutive strings : follow one after another without an interruption
 */
public class LongestConsec {
    public static String longestConsec(String[] strarr, int k) {
        if (strarr.length == 0 || k > strarr.length || k <= 0)
            return "";
        int max = 0, index = 0;

        for (int i = 0; i < strarr.length - k + 1; i++) {
            int lengthSum = 0;
            for (int j = i; j < i + k; j++) {
                lengthSum += strarr[j].length();
            }
            if (lengthSum > max) {
                max = lengthSum;
                index = i;
            }
        }
        StringBuilder out = new StringBuilder();
        for (int i = index; i < index + k; i++) {
            out.append(strarr[i]);
        }
        return out.toString();
    }
}
