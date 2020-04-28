package Arrays;
// highway-billboard-problem D.P
import java.util.HashMap;
import java.util.Map;

public class Problem8 {

    static Map<Integer,Integer> currToPrevIndexMap = new HashMap<Integer, Integer>();

    // Driver Code
    public static void main(String []args)
    {
        int m = 20;
        int[] x = new int[]{6, 7, 12, 13, 14};
        int[] revenue = new int[]{5, 6, 5, 3, 1};
        int n = x.length;
        int t = 5;
        preProcess(x,n,t);
        System.out.println(maxRevenue(x, revenue, n, t));
    }

    /**
     * This method saves a pointer to an index to x which can be piked if nth value is part of optimum.
     * If no such value exist then it won't add anything in currToPrevIndexMap.
     * If there are more than 1 such values it will pick value closest to it, so that it will solve larger sub problem.
     * @param x
     * @param n
     * @param t
     */
    private static void preProcess(int[] x , int n, int t)
    {
        int prev = n-1;
        for(int i= n-2; i>=0; i--)
        {
            int curr = i+1;
            // using the property of input(sorted in asc. order)
            if(x[curr] - x[prev] >= t)
            {
                currToPrevIndexMap.put(x[curr],prev);
            }
            else
            {
                while(prev > 0)
                {
                    prev--;
                    if(x[curr] - x[prev] >= t)
                    {
                        currToPrevIndexMap.put(x[curr],prev);
                        break;
                    }
                }
            }
        }
    }

    /**
     *
     * @param x
     * @param revenue
     * @param n
     * @param t
     * @return
     */
    private static int maxRevenue(int[] x, int[] revenue, int n, int t) {

        int [] result = new int[n+1];
        result[0] = 0;
        for(int i=1; i<=n; i++)
        {
            int val = 0;
            if(null != currToPrevIndexMap && currToPrevIndexMap.containsKey(x[i-1]))
            {
                val = currToPrevIndexMap.get(x[i-1]);
            }
            result[i] = Math.max(revenue[i-1] + result[val], result[i-1]);
        }

        return result[n];
    }
}
