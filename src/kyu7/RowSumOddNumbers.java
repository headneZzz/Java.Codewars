package kyu7;

/**
 * Given the triangle of consecutive odd numbers:
 * 1
 * 3     5
 * 7     9    11
 * 13    15    17    19
 * 21    23    25    27    29
 * ...
 * Calculate the row sums of this triangle from the row index (starting at index 1) e.g.:
 * rowSumOddNumbers(1); // 1
 * rowSumOddNumbers(2); // 3 + 5 = 8
 */
public class RowSumOddNumbers {
    //ver.1
    public static int versionWithFirst(int n) {
        int first = 1, odd = 2, sum = 0;

        for (int i = 1; i < n; i++) {
            first += odd;
            odd += 2;
        }
        for (int i = 0; i < n; i++) {
            sum += first;
            first += 2;
        }
        return sum;
    }

    //ver.2: two-dimensional array
    public static int versionWithArray(int n) {
        int[][] oddNumbs = new int[n][n];
        int oddInt = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                oddNumbs[i][j] = oddInt;
                oddInt += 2;
            }
        }
        for (int j = 0; j < n; j++) {
            sum += oddNumbs[n - 1][j];
        }
        return sum;
    }
}
