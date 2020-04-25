package Arrays;
// subset sum problem
public class Problem6 {

    // Driver program to test above function
    public static void main(String args[])
    {
        int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        int n = set.length;
        if (isSubsetSumOpt(set, n, sum) == true)
            System.out.println("Found a subset"
                    + " with given sum");
        else
            System.out.println("No subset with"
                    + " given sum");
    }


    private static boolean isSubsetSumOpt(int[] set, int n, int target) {

        boolean[][]result = new boolean[n+1][target+1];

        for(int i=0; i<=n; i++)
        {
            result[i][0] = true;
        }


        for(int i=1; i<=n ; i++)
        {
            for(int j=1; j<=target; j++)
            {
                // case last value is smaller or equal to target
                if(j >= set[i-1] )
                {
                    // result will be one if either is true:
                    // last element is part of solution or not part of solution
                    result [i][j] = result[i-1][j-1] || result[i-1][j-set[i-1]];
                }
                // last value greater than target
                else
                {
                    result[i][j] = result[i-1][j];
                }
            }
        }

        return result[n][target];
    }


        private static boolean isSubsetSum(int[] set, int n, int target) {

        if(target == 0)
        {
            return true;
        }

        if(n <= 0 && target > 0)
        {
            return false;
        }

        if(set[n-1] > target)
        {
            return isSubsetSum(set,n-1,target);
        }

        return isSubsetSum(set, n - 1, target) || isSubsetSum(set, n - 1, target - set[n - 1]);

    }

}
