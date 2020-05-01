package Arrays;
// longest-repeating-subsequence
public class Problem11 {

    // driver program to check above function
    public static void main (String[] args)
    {
        String str = "aabb";
        System.out.println("The length of the largest subsequence that"
                +" repeats itself is : "+findLongestRepeatingSubSeq(str));
    }

    private static int findLongestRepeatingSubSeq(String str) {
        int n = str.length();
        int[][] res = new int[n+1][n+1];
        for(int i=1; i<=n; i++)
        {
            for(int j=1; j<=n; j++)
            {
                // similar to lcs with additional condition (i!=j)
                if(str.charAt(i-1) == str.charAt(j-1) && i!=j)
                {
                    res[i][j] = 1+res[i-1][j-1];
                }
                else
                {
                    res[i][j] = Math.max(res[i-1][j],res[i][j-1]);
                }
            }

        }

        return res[n][n];
    }
}
