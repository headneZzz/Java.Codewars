package kyu5;

import java.util.Arrays;

/**
 * Your task is to check wheter a given integer is a perfect power.
 * If it is a perfect power, return a pair m and k with mk = n as a proof.
 * Otherwise return Nothing, Nil, null, NULL, None or your language's equivalent.
 *
 * Examples
 * isPerfectPower(4) => new int[]{2,2}
 * isPerfectPower(5) => null
 * isPerfectPower(8) => new int[]{2,3}
 * isPerfectPower(9) => new int[]{3,2}
 */
public class PerfectPower {
    public static int[] isPerfectPower(int n) {
        for (int m = 2; m * m <= n; m++) {
            for (int k = 2; Math.pow(m, k) <= n; k++)
                if (Math.pow(m, k) == n) return new int[]{m, k};
        }
        return null;
    }
}
