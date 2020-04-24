package Arrays;
// program to find max path in bottom triangle
public class Problem2 {

    public static void main(String arg[]) {
        int input[][] = {{5, 0, 0, 0, 0, 0},
                {7, 3, 0, 0, 0, 0},
                {10, 2, 5, 0, 0, 0},
                {1, 9, 20, 17, 0, 0},
                {3, 2, 5, 19, 4, 0},
                {5, 2, 3, 1, 3, 5}
        };
        System.out.println(maximumPath(input,6,6));
    }

    private static int maximumPath(int[][] input,int m,int n) {
    int[][] result = new int[m][n];

    result[0][0] = input[0][0];

    // first column of table will have no other option but it's top
    // so simply add element just above it to get it's maximum sum.
    for(int i = 1; i < m; i++)
    {
        result[i][0] = result[i-1][0]+ input[i][0];
    }

    for(int i =1; i < m; i++)
    {
        for(int j=1; j < i+1 ;j++)
        {
            // for the rest of cells we can get max either from top or it's left
            result[i][j] = Math.max(result[i][j-1],result[i-1][j]) + input[i][j];
        }
    }

    return result[m-1][n-1];
    }
}
