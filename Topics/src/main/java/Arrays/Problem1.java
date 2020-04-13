package Arrays;
// find subset with sum equal to given number in an array.
public class Problem1 {

    public static void main(String[] args)
    {
        Problem1 arraysum = new Problem1();
        int arr[] = {15, 2, 4, 8, 9, 5, 10, 23};
        int n = arr.length;
        int sum = 23;
        arraysum.subArraySum(arr, n, sum);
    }

    private void subArraySum(int[] arr, int n, int sum) {

        if(n < 1)
        {
            return;
        }
        int currSum = arr[0];
        int p = 0;
        for(int i=1; i<=n; i++)
        {
            if(currSum > sum)
            {
                while(currSum > sum && p < i-1) {
                    currSum -= arr[p];
                    p++;
                }
            }

            if(currSum == sum)
            {
                System.out.println("subset found between start:"+ p + " end:"+ (i-1));
                return;
            }

            if(i < n)
            {
                currSum += arr[i];
            }
        }
    }
}
