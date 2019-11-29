package kyu5;

/**
 * Take the following IPv4 address: 128.32.10.1
 * This address has 4 octets where each octet is a single byte (or 8 bits).
 * 1st octet 128 has the binary representation: 10000000
 * 2nd octet 32 has the binary representation: 00100000
 * 3rd octet 10 has the binary representation: 00001010
 * 4th octet 1 has the binary representation: 00000001
 * So 128.32.10.1 == 10000000.00100000.00001010.00000001
 * Because the above IP address has 32 bits, we can represent it as the unsigned 32 bit number: 2149583361
 * Complete the function that takes an unsigned 32 bit number and returns a string representation of its IPv4 address.
 *
 * Examples
 * 2149583361 ==> "128.32.10.1"
 */
public class Int32toIPv4 {
    public static String longToIP(long ip) {
        StringBuilder longToBin = new StringBuilder(Long.toBinaryString(ip));
        while (longToBin.length() < 32) {
            longToBin.insert(0, "0");
        }
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < 32; i += 8) {
            out.insert(out.length(), Integer.parseInt(longToBin.substring(i , i + 8), 2)).insert(out.length(), '.');
        }
        return out.deleteCharAt(out.length() - 1).toString();
    }
}
