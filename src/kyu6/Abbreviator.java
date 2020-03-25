package kyu6;

import java.util.regex.*;

/**
 * Write a function that takes a string and turns any and all "words" (see below)
 * within that string of length 4 or greater into an abbreviation, following these rules:
 *
 * A "word" is a sequence of alphabetical characters. By this definition, any other character like a space or hyphen
 * (eg. "elephant-ride") will split up a series of letters into two words (eg. "elephant" and "ride").
 * The abbreviated version of the word should have the first letter, then the number of removed characters,
 * then the last letter (eg. "elephant ride" => "e6t r2e").
 */
public class Abbreviator {
    public String abbreviate(String string) {
        Pattern pattern = Pattern.compile("[a-zA-Z]{4,}");
        Matcher matcher = pattern.matcher(string);
        StringBuffer out = new StringBuffer();
        while (matcher.find()) {
            String word = matcher.group();
            int length = word.length();
            matcher.appendReplacement(out, word.substring(0,1) + (length-2) + word.substring(length-1));
        }
        matcher.appendTail(out);
        return out.toString();
    }
}
