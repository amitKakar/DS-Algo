package Stacks;

import java.util.Stack;

// The Celebrity Problem
public class Problem5 {
    // Person with 2 is celebrity
    static int MATRIX[][] = { { 0, 0, 1, 0 },
            { 0, 0, 1, 0 },
            { 0, 0, 0, 0 },
            { 0, 0, 1, 0 } };

    // Returns true if a knows
    // b, false otherwise
    static boolean knows(int a, int b)
    {
        boolean res = (MATRIX[a][b] == 1) ?
                true :
                false;
        return res;
    }
    // Driver Code
    public static void main(String[] args)
    {
        int n = 4;
        int result = findCelebrity(n);
        if (result == -1)
        {
            System.out.println("No Celebrity");
        }
        else
            System.out.println("Celebrity ID " +
                    result);
    }

    private static int findCelebrity(int n) {
        int id;
        if(0 == n || 1 == n)
        {
            return -1;
        }

        Stack<Integer> s = new Stack<Integer>();
        for(int i=0; i<n; i++)
        {
            s.push(i);
        }

        while(s.size() != 1)
        {
            int first = s.pop();
            int second = s.pop();

            if(knows(first,second))
            {
                s.push(second);
            }
            else
            {
                s.push(first);
            }
        }
        id = s.pop();
        for(int i=0 ;i <n; i++)
        {
            if(i != id && (knows(id,i) || !knows(i,id)))
            {
                return -1;
            }
        }
        return id;
    }
}
