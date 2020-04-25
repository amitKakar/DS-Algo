package Arrays;
// rod cutting DP
public class Problem4 {

    public static void main(String args[])
    {
        int arr[] = new int[] {1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        System.out.println("Maximum Obtainable Value is "+
                cutRodOpt(arr, size));

    }

    private static int cutRod(int[] arr, int size) {
        int max = Integer.MIN_VALUE;
        // base case no cut possible/ smallest unit.
        if(size <= 0)
        {
            return 0;
        }
        //result[0] = 0;
        for(int i=0; i<size; i++)
        {
            // when we made a cut we will have two half.
            // so total profit after cut = wt of first half + cutRod(remaining rod).
            // we keep track of maximum profit found so far and return maxProfit.
            max = Math.max(max,arr[i] + cutRod(arr, size-i-1));
        }
        return max;
    }

    //optimized DP sol
    private static int cutRodOpt(int[] arr, int size) {
        int [] val = new int [size+1];
        val [0] = 0;

        // case 1: starting with size of target rod is 1
        // case 2: case size of target is two
        // case 3: size is 3
        for(int i=1; i<=size; i++)
        {
            int max = Integer.MIN_VALUE;
            // case 1: best we can get entire rod no cuts.
            // case 2: no cut{already part of solution from step one} or one cut.
            // case 3: no cut, one cut, two cut.
            for(int j=0; j<i; j++)
            {
                max = Math.max(max,arr[j] + val[i-j-1]);
            }
            val[i] = max;
        }
        return val[size];
    }
}
