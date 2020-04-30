package Arrays;
// Gold Mine Problem [DP]
public class Problem10 {

    //driver code
    public static void main(String arg[]) {
        int gold[][] = {{1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2}};
        int m = 4, n = 4;
        System.out.print(getMaxGold(gold, m, n));
    }

    private static int getMaxGold(int[][] gold, int rowx, int colx) {

        int[][] res = new int[rowx][colx];
        // no option to reach
        for (int i = 0; i < rowx; i++) {
            res[i][0] = gold[i][0];
        }
        for (int col = 1; col < colx; col++) {
            for (int row = 0; row < rowx; row++) {
                int a = 0, b = 0, c = 0;
                // corner case for elements of first rows
                if (col - 1 >= 0 && row - 1 >= 0) {
                    a = res[row - 1][col - 1];
                }
                b = res[row][col - 1];
                // corner case for elements of last rows
                if (col - 1 >= 0 && row + 1 < colx) {
                    c = res[row + 1][col - 1];
                }
                res[row][col] = gold[row][col] + Math.max(Math.max(a, b), c);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < rowx; i++) {
            if (max < res[i][colx - 1]) {
                max = res[i][colx - 1];
            }
        }

        return max;
    }

}
