package kyu6;

public class ValidBraces {
    public static boolean isValid(String braces) {
        char[] chars = braces.toCharArray();
        boolean isValid;
        for (int i=0;i<chars.length-1;i++) {
            if (chars[i] == '(' || chars[i] == '[' || chars[i] == '{') {
                isValid = false;
                for (int j=i+1;j<=chars.length-1;j+=2) {
                    if (chars[j]-2 == chars[i] || chars[j]-1 == chars[i]) {
                        isValid = true;
                        break;
                    }
                }
                if (!isValid) return false;
            }
        }
        return true;
    }
}
