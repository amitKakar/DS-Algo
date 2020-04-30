package Arrays;
// longest-increasing-sub sequence [dp]
public class Problem9 {

    public static void main(String args[])
    {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        int n = arr.length;
        System.out.println("Length of lis is " + lis( arr, n ) + "\n" );
    }

    private static int lis(int[] arr, int n) {

        int []res = new int[n];
        int max = 0;
        for(int j=0; j<n; j++)
        {
            res[j] = 1;
        }

        for(int i=1; i<n; i++)
        {
            for(int j=0; j<i; j++)
            {
                // if current value "arr[j]" is greater than "arr[i]"
                // and it's length+1 is greater than already value present in res[i]
                // ex: 10,22,9,33   possible inc. sub seq.: {10,22,33},{9,33} so pick longest one.
                if(arr[i] > arr[j] && res[i] < res[j]+1)
                {
                    res[i] = res[j]+1;
                }
            }
        }
        // maximum of all the possible length is answer.
        for(int i=0; i < n; i++)
        {
            if(res[i] > max)
            {
                max = res[i];
            }
        }
        return max;
    }
}
