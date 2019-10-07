// Shortest Word
// Level: 7kyu
/**Simple, given a string of words, return the length of the shortest word(s).
 * String will never be empty and you do not need to account for different data types.
 */

public class ShortestWord {
    public static int findShort(String s) {
        int wordLength = s.length();
        String[] words = s.split(" ");
        for (String word : words) {
            wordLength = Math.min(wordLength, word.length());
        }
        return wordLength;
    }
}
