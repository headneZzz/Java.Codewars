package kyu6;

/**
 * Longest Palindrome
 * Find the length of the longest substring in the given string s that is the same in reverse.
 * As an example, if the input was “I like racecars that go fast”, the substring (racecar) length would be 7.
 * If the length of the input string is 0, the return value must be 0.
 * Example:
 * "a" -> 1
 * "aab" -> 2
 * "abcde" -> 1
 * "zzbaabcd" -> 4
 * "" -> 0
 */
public class Palindromes {
    public static int longestPalindrome(final String s) {
        if (s.length() == 0) return 0;
        int length = 0;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= s.length() - i; j++) {
                StringBuilder word = new StringBuilder(s.substring(j, j + i));
                if (word.toString().equals(word.reverse().toString()))
                    length = word.length();
            }
        }
        return length;
    }
}
