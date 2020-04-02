package kyu5;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * John keeps a backup of his old personal phone book as a text file. On each line of the file
 * he can find the phone number (formated as +X-abc-def-ghij where X stands for one or two digits),
 * the corresponding name between < and > and the address.
 * Unfortunately everything is mixed, things are not always in the same order; parts of lines are cluttered with
 * non-alpha-numeric characters (except inside phone number and name).
 *
 * Examples of John's phone book lines:
 * "/+1-541-754-3010 156 Alphand_St. <J Steeve>\n"
 * " 133, Green, Rd. <E Kustur> NY-56423 ;+1-541-914-3010!\n"
 * "<Anastasia> +48-421-674-8974 Via Quirinal Roma\n"
 * Could you help John with a program that, given the lines of his phone book and a phone number num
 * returns a string for this number : "Phone => num, Name => name, Address => adress"
 */
public class PhoneDir {
    public static String phone(String strng, String num) {
        String[] lines = strng.split("\n");
        String out = null;
        for (String line : lines) {
            String phone = line.substring(line.indexOf('+') + 1, line.indexOf('+') + 15);
            if (phone.substring(0, phone.indexOf('-')).length() != 1) {
                phone += line.substring(line.indexOf('+') + 15, line.indexOf('+') + 16);
            }
            if (!phone.equals(num))
                continue;
            if (out != null) {
                return "Error => Too many people: " + num;
            }
            String name = line.substring(line.indexOf('<') + 1, line.indexOf('>'));
            line = line.replace('+' + phone, "");
            line = line.replace('<' + name + '>', "");

            StringBuilder sb = new StringBuilder();
            Pattern pattern = Pattern.compile("[^a-zA-Z _0-9.-]");
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                matcher.appendReplacement(sb, "");
            }
            matcher.appendTail(sb);

            pattern = Pattern.compile("_");
            matcher = pattern.matcher(sb.toString());
            sb = new StringBuilder();
            while (matcher.find()) {
                matcher.appendReplacement(sb, " ");
            }
            matcher.appendTail(sb);
            out = "Phone => " + phone + ", " + "Name => " + name + ", " + "Address => " + sb.toString().trim().replaceAll(" {2}", " ");
        }
        return Objects.requireNonNullElseGet(out, () -> "Error => Not found: " + num);
    }
}
