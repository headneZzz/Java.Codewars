/**
 * Write a function that takes a positive integer and returns the next smaller positive integer containing the same digits.
 *
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
    public static long nextSmaller(long n) {
        StringBuilder out = new StringBuilder().append(n);
        if (out.length()<=1)
            return -1;
        for(int i=out.length()-1;i>=0;i--) {
            for(int j=i-1;j>=0;j--){
                if (out.charAt(j)<out.charAt(i)){
                    if (i==0 && out.charAt(i)=='0'){
                        continue;
                    }
                    char temp = out.charAt(i);
                    out.setCharAt(i,out.charAt(j));
                    out.setCharAt(j,temp);
                    return Long.valueOf(out.toString().trim());
                }
            }
        }
        return -1;

    }
}
