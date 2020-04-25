package Arrays;

public class Problem5 {


    static int count( int S[], int m, int n )
    {
        // If n is 0 then there is 1 solution
        // (do not include any coin)
        if (n == 0)
            return 1;

        // If n is less than 0 then no
        // solution exists
        if (n < 0)
            return 0;

        // If there are no coins and n
        // is greater than 0, then no
        // solution exist
        if (m <=0 && n >= 1)
            return 0;

        // count is sum of solutions (i)
        // including S[m-1] (ii) excluding S[m-1]
        return count( S, m - 1, n ) +
                count( S, m, n-S[m-1] );
    }

    //DP solution
    static int countOpt( int S[], int m, int n )
    {
        int [][] result = new int[m+1][n+1];

        for(int i=0; i<=m; i++)
        {
            result[i][0]=1;
        }
        for(int i=1; i<=m; i++)
        {
            for(int j=1; j<=n; j++)
            {
                if(S[i-1] > j)
                {
                    result[i][j] = result[i-1][j];
                }
                else
                {
                    result[i][j] = result[i-1][j]+result[i][j-S[i-1]];
                }
            }
        }

        return result[m][n];
    }

    // Driver program to test above function
    public static void main(String[] args)
    {
        int arr[] = {1, 2, 3};
        int m = arr.length;
        System.out.println( countOpt(arr, m, 4));


    }
}
