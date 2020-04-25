package Arrays;

public class Problem3 {

    // Driver program to test above function
    public static void main(String args[]) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }

    private static int knapSack(int target, int[] wt, int[] val, int n) {

        int[][]result =new int[n+1][target+1];

        // wt in bag {10,20,30}
        for(int i=0; i<=n; i++)
        {
            // target wt{1,2,3,4...50}
            for(int j=0; j<=target; j++)
            {
                // case target =0 or available wt = 0
                if(i==0 || j==0)
                {
                    result[i][j]=0;
                }
                // case current wt in bag is less than current target wt
                else if(wt[i-1] <= j)
                {
                    // max of value from top of current cell{case when curr wt is not taken}
                    // and val of current wt + best of result just previous row with diff of wt{current wt is added}
                    result[i][j] = Math.max(result[i-1][j],val[i-1]+result[i-1][j-wt[i-1]]);
                }
                // case current wt in bag is greater than current target wt
                else
                {
                    result[i][j] = result[i-1][j];
                }
            }
        }
        return result[n][target];
    }
}
