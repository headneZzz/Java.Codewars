/**Take 2 strings s1 and s2 including only letters from a to z.
 * Return a new sorted string, the longest possible, containing distinct letters,
 * each taken only once - coming from s1 or s2.*/
public class TwoToOne {
    public static String longest (String s1, String s2) {
        StringBuilder out = new StringBuilder();
        for (char chr='a';chr<='z';chr++) {
            if(s1.indexOf(chr)!=-1) {
                out.append(chr);
            } else {
                if (s2.indexOf(chr)!=-1) {
                    out.append(chr);
                }
            }
        }
        return  out.toString();
    }
}
