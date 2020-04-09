package LinkedList.SinglyLinkedList;
// Sort a linked list of 0s, 1s and 2s
public class Problem8 {
    /* Linked list node */
    private static Node head;
    static class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            data = d;
            next = null;
        }
    }

    /* Given a reference to the head of a list and an int,
        inserts a new Node on the front of the list. */
    public void push(int new_data)
    {
        /* 1. alloc the Node and put the data */
        Node new_Node = new Node(new_data);

        /* 2. Make next of new Node as head */
        new_Node.next = head;

        /* 3. Move the head to point to new Node */
        head = new_Node;
    }

    /* This function prints contents of linked list
        starting from the given Node */
    public void printList()
    {
        Node tNode = head;
        while (tNode != null) {
            System.out.print(tNode.data + " ");
            tNode = tNode.next;
        }
    }
    static Node sortList(Node headPt)
    {
        if(null == headPt)
        {
            return head;
        }

        Node zeroD = new Node(0);
        Node oneD = new Node(0);
        Node twoD = new Node(0);
        Node zero = zeroD, one = oneD, two = twoD;
        Node curr = headPt;
        while(null!= curr)
        {
            if(curr.data == 0)
            {
                zero.next = curr;
                zero = zero.next;
            }
            else if(curr.data == 1)
            {
                one.next = curr;
                one = one.next;
            }
            else
            {
                two.next = curr;
                two = two.next;
            }
            curr = curr.next;
        }
        zero.next = oneD.next!=null?oneD.next:twoD.next;
        one.next = twoD.next;
        two.next = null;
        return zeroD.next;
    }

    public static void main(String[] args)
    {
        Problem8 llist = new Problem8();

        /* Use push() to construct below list
        1->12->1->4->1  */
        llist.push(1);
        llist.push(2);
        llist.push(0);
        llist.push(1);
        llist.push(2);

        System.out.println("Before sort");
        llist.printList();
        //System.out.println("\ntarget: "+ llist.head.next.next.data);

        llist.head = sortList(llist.head);

        System.out.println("\nAfter sort");
        llist.printList();
    }
}
