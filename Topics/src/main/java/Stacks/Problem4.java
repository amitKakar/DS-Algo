package Stacks;
// The Stock Span Problem
import java.util.Arrays;
import java.util.Stack;

public class Problem4 {
    // A utility function to print elements of array
    static void printArray(int arr[])
    {
        System.out.print(Arrays.toString(arr));
    }

    // Driver method
    public static void main(String[] args)
    {
        int price[] = { 10, 4, 5, 90, 120, 80 };
        int n = price.length;
        int S[] = new int[n];

        // Fill the span values in array S[]
        calculateSpan(price, n, S);

        // print the calculated span values
        printArray(S);
    }

    private static void calculateSpan(int[] price, int n, int[] s) {
        if(0 == n)
        {
            return;
        }

        Stack<Integer> stack = new Stack<Integer>();

        stack.push(0);
        s[0] = 1;

        for(int i=1; i<n; i++)
        {
            int next = price[i];
            while(!stack.isEmpty() && price[stack.peek()] < next)
            {
                stack.pop();
            }

            s[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }


    }
}
