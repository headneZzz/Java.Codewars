package kyu4;

public class StripComments {
    public static String stripComments(String text, String[] commentSymbols) {
        StringBuilder newtext = new StringBuilder(text);
        for (int i = 0; i < newtext.length() - 1; i++) {
            if (newtext.charAt(i) == '\\' && newtext.charAt(i + 1) == 'n') {
                newtext.replace(i,i+2,"\n");
            }
        }
        text = newtext.toString();
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
                if (!isComment && charsText[i] != '\n')
                    out.append(charsText[i]);
            }
            if (charsText[i] == '\n') {
                while (out.charAt(out.length() - 1) == ' ') {
                    out.deleteCharAt(out.length() - 1);
                }
                isComment = false;
                out.append(charsText[i]);
            }
        }
        while (out.length() != 0 && out.charAt(out.length() - 1) == ' ') {
            out.deleteCharAt(out.length() - 1);
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.print(stripComments("e\\n\\nf\\n\\neb\\n\\nc\\n\\nc\\n\\nf\\n\\nedab\\n\\nfc\\n\\nd\\n\\n!\\n\\n!\\n\\ne\\n\\n!!e\\n\\nf\\n\\nf\\n\\na\\n\\n!d\\n\\nb\\n\\nd\\n\\ncef\\n\\ne\\n\\n\\n\\n\\nb\\n\\n\\n\\n\\nbf\\n\\nfa\\n\\n!bbb\\n\\nc\\n\\nc\\n\\nfd\\n\\n!c\\n\\ne\\n\\na\\n\\n\\n\\n\\nd\\n\\nd\\n\\nf\\n\\n\\n\\n\\nd\\n\\n!\\n\\nc\\n\\ndaaf\\n\\nc\\n\\nc\\n\\n\\na\\n\\nbb\\n\\nff!\\n\\n!d\\n!ae!c\\n\\nc\\n\\nf\\n\\nee\\n\\nc\\n\\n\\n\\ndca\\n\\nc\\n\\nde\\n\\ne\\n\\nb\\n\\nd\\n\\nad\\n\\n\\neda\\n\\nb\\n\\na\\n\\n\\n\\n\\n\\n\\n\\na\\n\\nd\\n\\ne!f\\n\\na\\n\\nfcfa\\n\\nf", new String[]{"#", "$", "!", "-"}));
    }
}