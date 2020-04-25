package Arrays;
// length of longest common subseq.
public class Problem7 {

    public static void main(String[] args)
    {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X=s1.toCharArray();
        char[] Y=s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println("Length of LCS is" + " " + lcs( X, Y, m, n ) );
    }

    private static int lcs(char[] x, char[] y, int m, int n)
    {
        int result = 0;
        if(m ==0 || n==0)
        {
            return result;
        }

        if(x[m-1] == y[n-1])
        {
            return lcs(x,y,m-1,n-1)+1;
        }
        else
        {
            return Math.max(lcs(x,y,m-1,n),lcs(x,y,m,n-1));
        }
    }


        private static int lcsOpt(char[] x, char[] y, int m, int n) {
        int[][]result = new int[m+1][n+1];

        for(int i =0; i<=m; i++)
        {
            for(int j=0; j<=n; j++)
            {
                if(i==0 || j==0)
                {
                    result[i][j]=0;
                }
                // last char of both strings are same
                else if(x[i-1] == y[j-1])
                {
                    result[i][j] = 1+result[i-1][j-1];
                }
                // last char are not same
                else
                {
                    result[i][j] = Math.max(result[i-1][j],result[i][j-1]);
                }
            }
        }



        return result[m][n];
    }
}
