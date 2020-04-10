package LinkedList.SinglyLinkedList;

import java.util.ArrayList;
import java.util.List;

// Move all occurrences of an element to end in a linked list
public class Problem9 {
    Node head; // head of linked list
    Node headDup;
    Node tailDup;

    /* Linked list node */
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    /* Given a reference to the head of a list and an int,
        inserts a new Node on the front of the list. */
    public void push(int new_data) {
        /* 1. alloc the Node and put the data */
        Node new_Node = new Node(new_data);

        /* 2. Make next of new Node as head */
        new_Node.next = head;

        /* 3. Move the head to point to new Node */
        head = new_Node;
    }

    // Moves all occurrences of given key to
    // end of linked list.
    Node moveToEnd(Node head, int key) {
        //list with size 0 or 1
        if (head == null || head.next == null) {
            return head;
        }

        Node curr = head;
        Node prev = null;
        Node next;
        boolean modified = false;
        Node headDup = null;
        Node tailDup = null;
        while (curr != null)
        {
            if (curr.data == key)
            {
                Node tail = curr;
                // collecting all the duplicate keys together
                // so that we don't need to update links again and again.
                while (tail.next != null && tail.next.data == key)
                {
                    tail = tail.next;
                }

                // first element is not key
                if (null != prev)
                {
                    if (null == headDup)
                    {
                        headDup = curr;
                    }
                    else {
                        tailDup.next = curr;
                    }
                    prev.next = tail.next;
                }
                // first element is key
                else {
                    headDup = curr;
                    head = curr;
                }
                tailDup = tail;
                curr = tail.next;
                tail.next = null;
                modified = true;
            }

            prev = curr;
            if (!modified)
            {
                curr = curr.next;
            }
            modified = false;
        }
        if(null != headDup)
        {
            prev.next = headDup;
        }
        return head;
    }

    /* This function prints contents of linked list
        starting from the given Node */
    public void printList() {
        Node tNode = head;
        while (tNode != null) {
            System.out.print(tNode.data + " ");
            tNode = tNode.next;
        }
    }

    public static void main(String[] args) {
        Problem9 llist = new Problem9();

        /* Use push() to construct below list
        1->12->1->4->1  */
        llist.push(1);
        llist.push(2);
        llist.push(2);
        llist.push(4);
        llist.push(7);

        System.out.println("Before reverse");
        llist.printList();
        //System.out.println("\ntarget: "+ llist.head.next.next.data);

        llist.head = llist.moveToEnd(llist.head, 2);

        System.out.println("\nAfter reverse");
        llist.printList();
    }
}
