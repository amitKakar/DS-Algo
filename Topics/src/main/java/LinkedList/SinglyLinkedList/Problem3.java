// Reverse a linked list Iterative
package LinkedList.SinglyLinkedList;

public class Problem3 {
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
    Node reverse(Node head)
    {
        if(null == head)
        {
            return head;
        }

        else
        {
            Node prev = null;
            Node curr = head;
            Node next = null;
            while(null!= curr)
            {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            head = prev;
        }
        return head;
    }

    public static void main(String[] args)
    {
        Problem3 llist = new Problem3();

        /* Use push() to construct below list
        1->12->1->4->1  */
        llist.push(1);
        llist.push(2);
        llist.push(3);
        llist.push(4);
        llist.push(5);

        System.out.println("Before reverse");
        llist.printList();

        llist.head = llist.reverse(llist.head);

        System.out.println("\nAfter reverse");
        llist.printList();
    }
}
