package LinkedList.SinglyLinkedList;
// Given two numbers represented by two lists, write a function that returns the sum list.
// The sum list is list representation of the addition of two input numbers.
/*
        Input:  List1: 5->6->3  // represents number 365
                List2: 8->4->2 //  represents number 248
        Output: Resultant list: 3->1->6  // represents number 613
 */
public class Problem7 {
    static Node head1, head2;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }


    void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println("");
    }

    Node addTwoLists(Node first, Node second) {
        Node newHead = null;
        Node tail = null;
        Node prev = null;
        int carry = 0,sum;

        while (first != null || second != null) {

            sum = (first != null ? first.data : 0) + (second != null ? second.data : 0) + carry;
            carry = sum >= 10 ? 1 : 0;
            sum = sum % 10;
            tail = new Node(sum);

            if(null == newHead) {
                newHead = tail;
            }
            else {
                prev.next = tail;
            }

            prev = tail;

            if (first != null) {
                first = first.next;
            }
            if (second != null) {
                second = second.next;
            }
        }
        if(carry >0) {
            tail.next = new Node(carry);
        }
        return newHead;
    }


        public static void main(String[] args) {
        Problem7 list = new Problem7();

        // creating first list
        list.head1 = new Node(7);
        list.head1.next = new Node(5);
        list.head1.next.next = new Node(9);
        list.head1.next.next.next = new Node(4);
        list.head1.next.next.next.next = new Node(6);
        System.out.print("First List is ");
        list.printList(head1);

        // creating seconnd list
        list.head2 = new Node(8);
        list.head2.next = new Node(4);
        System.out.print("Second List is ");
        list.printList(head2);

        // add the two lists and see the result
        Node rs = list.addTwoLists(head1, head2);
        System.out.print("Resultant List is ");
        list.printList(rs);
    }
}



