package LinkedList.SinglyLinkedList;
// reverse linked list in group.
public class Problem6 {
    Node head; // head of linked list
    /* Linked list node */
    class Node
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
    Node reverse(Node curr, int size)
    {
        int count = 0;
        Node tempHead = curr;
        Node prev = null;
        Node next = null;
        while(tempHead!= null && count < size)
        {
            next = tempHead.next;
            tempHead.next = prev;
            prev = tempHead;
            tempHead = next;
            count++;
        }
        if(next != null)
        {
            curr.next = reverse(next,size);
        }

        return prev;
    }

    public static void main(String[] args)
    {
        Problem6 llist = new Problem6();

        /* Use push() to construct below list
        1->12->1->4->1  */
        llist.push(1);
        llist.push(2);
        llist.push(3);
        llist.push(4);
        llist.push(5);

        System.out.println("Before reverse");
        llist.printList();
        //System.out.println("\ntarget: "+ llist.head.next.next.data);

        llist.head = llist.reverse(llist.head,3);

        System.out.println("\nAfter reverse");
        llist.printList();
    }
}
