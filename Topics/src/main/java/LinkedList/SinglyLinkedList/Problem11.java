package LinkedList.SinglyLinkedList;
import java.util.Iterator;
import java.util.*;
// Count pairs from two linked lists whose sum is equal to a given value
public class Problem11 {

    // method to count all pairs from both the linked lists
    // whose sum is equal to a given value
    static int countPairs(LinkedList<Integer> head1, LinkedList<Integer> head2, int x)
    {
        int count = 0;
        if(null == head1 || null == head2)
        {
            return count;
        }
        Set<Integer> diffSet = new HashSet<Integer>();
        Iterator itr = head1.iterator();
        while(itr.hasNext())
        {
            int curr = (Integer)itr.next();
            if(curr < x)
            {
                int diff = x - curr;
                diffSet.add(diff);
            }
        }

        itr = head2.iterator();
        while(itr.hasNext())
        {
            int curr = (Integer)itr.next();
            if(curr < x && !diffSet.add(x-curr))
            {
                count++;
            }
        }
        return count;
    }
        // Driver method
    public static void main(String[] args)
    {
        Integer arr1[] = {3, 1, 5, 7};
        Integer arr2[] = {8, 2, 5, 3};

        // create linked list1 3->1->5->7
        LinkedList<Integer> head1 = new LinkedList<Integer>(Arrays.asList(arr1));

        // create linked list2 8->2->5->3
        LinkedList<Integer> head2 = new LinkedList<Integer>(Arrays.asList(arr2));

        int x = 10;

        System.out.println("Count = " + countPairs(head1, head2, x));
    }
}
