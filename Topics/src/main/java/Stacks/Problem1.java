package Stacks;
// Given an array, print the Next Greater Element (NGE) for every element.
import java.util.Stack;

public class Problem1 {

    private static void printNGE(int[] arr, int n) {

        if(n == 0)
        {
            return;
        }

        Stack<Integer> s = new Stack<Integer>();
        s.push(arr[0]);
        for(int i=1; i<n; i++)
        {
            int next = arr[i];
            if(!s.isEmpty())
            {
                int top = s.pop();
                while(next > top)
                {
                    System.out.println("NGE of :"+ top + " is :"+ next);
                    if(s.isEmpty())
                    {
                        break;
                    }
                    s.pop();
                }
                if(next < top)
                {
                    s.push(top);
                }
            }
            s.push(next);
        }
        while (!s.isEmpty())
        {
            int element = s.pop();
            int next = -1;
            System.out.println("NGE of :"+element + " is :" + next);
        }
    }



    public static void main(String[] args)
    {
        int arr[] = { 11, 13, 21, 3 };
        int n = arr.length;
        printNGE(arr, n);
    }
}
