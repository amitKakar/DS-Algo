package LinkedList.SinglyLinkedList;
/*
Add two numbers represented by linked lists
  Input:
            First List: 5->6->3  // represents number 563
            Second List: 8->4->2 //  represents number 842
  Output:
            Resultant list: 1->4->0->5  // represents number 1405
 */
public class Problem10 {
    class node
    {
        int val;
        node next;

        public node(int val)
        {
            this.val = val;
        }
    }

    // Function to print linked list
    void printlist(node head)
    {
        while (head != null)
        {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    node head1, head2, result, curr;
    int carry;

    /* A utility function to push a value to linked list */
    void push(int val, int list)
    {
        node newnode = new node(val);
        if (list == 1)
        {
            newnode.next = head1;
            head1 = newnode;
        }
        else if (list == 2)
        {
            newnode.next = head2;
            head2 = newnode;
        }
        else
        {
            newnode.next = result;
            result = newnode;
        }

    }
    int getsize(node head)
    {
        int count = 0;
        while (head != null)
        {
            count++;
            head = head.next;
        }
        return count;
    }
    private void propogateCarry(node head1) {
        if(head1 == curr)
        {
            return;
        }
        propogateCarry(head1.next);
        int sum = head1.val + carry;
        carry = sum/10;
        sum = sum%10;
        push(sum,3);
    }

    private void addSameSize(node head1, node head2) {
        if(head1 == null)
        {
            return;
        }
        addSameSize(head1.next,head2.next);

        int sum = head1.val + head2.val + carry;
        carry = sum/10;
        sum = sum%10;
        push(sum,3);
    }

    // Driver program to test above functions
    public static void main(String args[])
    {
        Problem10 list = new Problem10();
        list.head1 = null;
        list.head2 = null;
        list.result = null;
        list.carry = 0;
        int arr1[] = { 9, 9, 9 };
        int arr2[] = { 1, 8 };

        // Create first list as 9->9->9
        for (int i = arr1.length - 1; i >= 0; --i)
            list.push(arr1[i], 1);

        // Create second list as 1->8
        for (int i = arr2.length - 1; i >= 0; --i)
            list.push(arr2[i], 2);

        list.addlists();

        list.printlist(list.result);
    }

    private void addlists() {

        if(null == head1)
        {
            result = head2;
            return;
        }

        if(null == head2)
        {
            result = head1;
            return;
        }

        int size1 = getsize(head1);
        int size2 = getsize(head2);
        if(size1 == size2)
        {
            addSameSize(head1,head2);
        }
        else
        {
            if(size1 < size2)
            {
                node temp = head1;
                head1 = head2;
                head2 = temp;
            }

            int diff = Math.abs(size1-size2);
            curr = head1;
            while(diff > 0)
            {
                curr = curr.next;
                diff--;
            }
            addSameSize(curr,head2);

            propogateCarry(head1);
        }

        if(carry > 0)
        {
            push(carry,3);
        }

    }
}
