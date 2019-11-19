package kyu5;

import java.util.Arrays;

/**
 * Your task is to check wheter a given integer is a perfect power.
 * If it is a perfect power, return a pair m and k with mk = n as a proof.
 * Otherwise return Nothing, Nil, null, NULL, None or your language's equivalent.
 * <p>
 * Examples
 * isPerfectPower(4) => new int[]{2,2}
 * isPerfectPower(5) => null
 * isPerfectPower(8) => new int[]{2,3}
 * isPerfectPower(9) => new int[]{3,2}
 */
public class PerfectPower {
    public static int[] isPerfectPower(int n) {
        for (int i = 2; i <= n / 2; i++) {
            int temp = n;
            int k = 0;
            while (temp > 1) {
                temp /= i;
                k++;
            }
            if (temp == 1) {
                int[] out = new int[2];
                out[0] = i;
                out[1] = k;
                return out;
            }
        }
        return null;
    }
    //TODO
    public static void main(String[] args) {
        System.out.println(Arrays.toString(isPerfectPower(5)));
    }
}
