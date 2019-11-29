package kyu4;

public class StripComments {
    public static String stripComments(String text, String[] commentSymbols) {
        StringBuilder out = new StringBuilder();
        char[] charsText = text.toCharArray();
        char[] comments = new char[commentSymbols.length];
        int j = 0;
        for (String s : commentSymbols) {
            comments[j] = s.toCharArray()[0];
            j++;
        }
        boolean isComment = false;
        for (int i = 0; i < charsText.length; i++) {
            if (!isComment) {
                for (char s : comments) {
                    if (charsText[i] == s) {
                        isComment = true;
                        break;
                    }
                }
                if (!isComment) out.append(charsText[i]);
            } else {
                if (charsText[i] == '\n') {
                    while (out.charAt(out.length()-1) == ' ') {
                        out.deleteCharAt(out.length()-1);
                    }
                    isComment = false;
                    out.append(charsText[i]);
                }
            }
        }
        return out.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(stripComments("apples, pears # and bananas\ngrapes\nbananas !apples", new String[]{"#", "!"}));
    }
}