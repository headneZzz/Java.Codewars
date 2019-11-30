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
        for (char c : charsText) {
            if (!isComment) {
                for (char s : comments) {
                    if (c == s) {
                        isComment = true;
                        break;
                    }
                }
                if (!isComment && c != '\n')
                    out.append(c);
            }
            if (c == '\n') {
                while (out.length() != 0 && out.charAt(out.length() - 1) == ' ') {
                    out.deleteCharAt(out.length() - 1);
                }
                isComment = false;
                out.append(c);
            }
        }
        while (out.length() != 0 && out.charAt(out.length() - 1) == ' ') {
            out.deleteCharAt(out.length() - 1);
        }
        return out.toString();
    }
}