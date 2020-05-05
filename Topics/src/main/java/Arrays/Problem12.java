package Arrays;
// temple-offerings (DP)
public class Problem12 {

    // Driver code
    public static void main (String[] args)
    {
        int arr1[] = {1, 2, 2};
        System.out.println(offeringNumber(3, arr1));
        int arr2[] = {1, 4, 3, 6, 2, 1};
        System.out.println(offeringNumber(6, arr2));
    }

    private static int offeringNumber(int i, int[] temple) {
        int[] runLeft = new int[i];
        int[] runRight = new int[i];
        for(int k=0; k<i; k++)
        {
            runLeft[k] = -1;
            runRight[k] = -1;
        }

        runLeft[0] = 1;
        runRight[i-1] = 1;

        // length of decreasing substring on left of current index + 1
        for(int k = 1; k < i; k++)
        {
            if(temple[k] > temple[k-1])
            {
                runLeft[k] = runLeft[k-1]+1;
            }
            // if no dec. substring on left found
            else
            {
                runLeft[k] = 1;
            }
        }

        // length of decreasing substring on right of current index + 1
        for(int k = i-2; k >= 0; k--)
        {
            if(temple[k] > temple[k+1])
            {
                runRight[k] = runRight[k+1]+1;
            }
            // if no dec. substring on right found
            else
            {
                runRight[k] = 1;
            }
        }

        int sum = 0;
        for(int k=0; k< i; k++)
        {
            sum += Math.max(runLeft[k],runRight[k]);
        }

        return sum;
    }

    private static int offeringNumberNaive(int i, int[] arr1) {
        int sum = 0;
        //int n = arr1.length;
        for(int k=0; k<i; k++)
        {
            int temp1 = 0;
            for(int l=k-1; l>=0; l--)
            {
                if(arr1[l+1] > arr1[l])
                {
                    temp1++;
                }
                else
                {
                    break;
                }
            }
            int temp2 = 0;
            for(int l=k+1; l<i; l++)
            {
                if(arr1[l] < arr1[l-1])
                {
                    temp2++;
                }
                else
                {
                    break;
                }
            }

            sum+= Math.max(temp1,temp2)+1;
        }


        return sum;
    }
}
