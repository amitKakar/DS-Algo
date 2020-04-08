package LinkedList.SinglyLinkedList;
// rotate a Linked List counter clock wise w.r.t a specific given node.
public class Problem5 {
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
    Node reverse(Node curr, Node target)
    {
        if(curr == null)
        {
            return curr;
        }
        Node tail = curr;
        Node temp = null;
        while(tail.next != null)
        {
            if(tail.next.data == target.data)
            {
                temp = tail;
            }
            tail = tail.next;
        }
        if(null == temp)
        {
            System.out.println("target not found");
            return curr;
        }
        head = temp.next;
        tail.next = curr;
        temp.next = null;
        return head;
    }

    public static void main(String[] args)
    {
        Problem5 llist = new Problem5();

        /* Use push() to construct below list
        1->12->1->4->1  */
        llist.push(1);
        llist.push(2);
        llist.push(3);
        llist.push(4);
        llist.push(5);

        System.out.println("Before reverse");
        llist.printList();
        System.out.println("\ntarget: "+ llist.head.next.next.data);

        llist.head = llist.reverse(llist.head,llist.head.next.next);

        System.out.println("\nAfter reverse");
        llist.printList();
    }
}
