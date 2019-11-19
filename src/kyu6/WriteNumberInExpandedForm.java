package kyu6;

/**
 * You will be given a number and you will need to return it as a string in Expanded Form. For example:
 * Kata.expandedForm(12); # Should return "10 + 2"
 * Kata.expandedForm(42); # Should return "40 + 2"
 * Kata.expandedForm(70304); # Should return "70000 + 300 + 4"
 * <p>
 * NOTE: All numbers will be whole numbers greater than 0.
 */
public class WriteNumberInExpandedForm {
    public static String expandedForm(int num) {
        StringBuilder res = new StringBuilder();
        for (int i = 10; num != 0; i *= 10) {
            int a = num % 10 * (i / 10);
            num /= 10;
            if (a != 0)
                res.insert(0, " + ").insert(0, a);
        }
        res.delete(res.length() - 3, res.length());
        return res.toString();
    }
}
