package Trees.BinaryTree;
//Perfect Binary Tree Specific Level Order Traversal (Bottom to Top traversal)
// https://www.geeksforgeeks.org/perfect-binary-tree-specific-level-order-traversal-set-2/

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problem4 {
    Node root;

    // Driver program to test the above functions
    public static void main(String[] args)
    {
        Problem4 tree = new Problem4();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left  = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left  = new Node(6);
        tree.root.right.right = new Node(7);

        tree.root.left.left.left  = new Node(8);
        tree.root.left.left.right  = new Node(9);
        tree.root.left.right.left  = new Node(10);
        tree.root.left.right.right  = new Node(11);
        tree.root.right.left.left  = new Node(12);
        tree.root.right.left.right  = new Node(13);
        tree.root.right.right.left  = new Node(14);
        tree.root.right.right.right  = new Node(15);

        tree.root.left.left.left.left  = new Node(16);
        tree.root.left.left.left.right  = new Node(17);
        tree.root.left.left.right.left  = new Node(18);
        tree.root.left.left.right.right  = new Node(19);
        tree.root.left.right.left.left  = new Node(20);
        tree.root.left.right.left.right  = new Node(21);
        tree.root.left.right.right.left  = new Node(22);
        tree.root.left.right.right.right  = new Node(23);
        tree.root.right.left.left.left  = new Node(24);
        tree.root.right.left.left.right  = new Node(25);
        tree.root.right.left.right.left  = new Node(26);
        tree.root.right.left.right.right  = new Node(27);
        tree.root.right.right.left.left  = new Node(28);
        tree.root.right.right.left.right  = new Node(29);
        tree.root.right.right.right.left  = new Node(30);
        tree.root.right.right.right.right  = new Node(31);

        System.out.println("Specific Level Order Traversal "
                + "of Binary Tree is ");
        tree.printSpecificLevelOrder(tree.root);
    }

    private void printSpecificLevelOrder(Node root) {
        if(null == root)
        {
            return;
        }
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);

        if(root.left != null)
        {
            stack.push(root.right);
            stack.push(root.left);
        }

        // given tree is perfect binary tree no need to check for right.
        if(root.left.left != null)
        {
            printSpecificLevelOrder(root,stack);
        }

        while(!stack.empty())
        {
            Node temp = stack.pop();
            if(null!= temp)
            {
                System.out.println(temp.data + "");
            }
        }
    }

    private void printSpecificLevelOrder(Node root, Stack<Node> stack) {
        if(null == root)
        {
            return;
        }

        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root.left);
        queue.add(root.right);
        while(!queue.isEmpty())
        {
            Node first = queue.poll();
            Node second = queue.poll();
            if (null != first && null != second
                    && null != first.left && null != first.right
                    && null != second.left && null != second.right)
            {
                stack.push(second.left);
                stack.push(first.right);
                stack.push(second.right);
                stack.push(first.left);

                // given tree is perfect binary tree no need to check for right.
                if(root.left.left != null)
                {
                    queue.add(first.right);
                    queue.add(second.left);
                    queue.add(first.left);
                    queue.add(second.right);
                }
            }

        }
    }
}
