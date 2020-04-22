package Stacks;
// Merge Overlapping Intervals
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Problem6 {
    public static void main(String args[]) {
        Interval arr[] = new Interval[4];
        arr[0] = new Interval(6, 8);
        arr[1] = new Interval(1, 9);
        arr[2] = new Interval(2, 4);
        arr[3] = new Interval(4, 7);
        mergeIntervals(arr);
    }

    private static void mergeIntervals(Interval[] arr) {
        Arrays.sort(arr, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        Stack<Interval> s = new Stack<Interval>();
        s.push(arr[0]);
        for(int i=1 ; i<arr.length; i++)
        {
            Interval top = s.peek();
            Interval curr = arr[i];
            // case non overlapping intervals.
            if(curr.start > top.end)
            {
                s.push(curr);
            }
            // case overlapping intervals with end time of current array element greater than top.
            else if (top.end < curr.end)
            {
                s.pop();
                top.end = curr.end;
                s.push(top);
            }
        }
        // Print contents of stack
        System.out.print("The Merged Intervals are: ");
        while (!s.isEmpty())
        {
            Interval t = s.pop();
            System.out.print("["+t.start+","+t.end+"] ");
        }

    }
}

class Interval {
    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}