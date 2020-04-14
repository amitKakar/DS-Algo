package Trees.BinaryTree;

import java.util.Stack;

// Level order traversal in spiral form
public class Problem5 {

    Node root;
    /* Driver program to test the above functions */
    public static void main(String[] args)
    {
        Problem5 tree = new Problem5();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(6);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(4);
        System.out.println("Spiral order traversal of Binary Tree is ");
        tree.printSpiral(tree.root);
    }

    private void printSpiral(Node root) {
        if(null == root)
        {
            return;
        }
        Stack<Node> s1 = new Stack<Node>();
        Stack<Node> s2 = new Stack<Node>();

        s1.push(root);
        while(!s1.empty() || !s2.empty())
        {
            while(!s1.empty())
            {
                Node temp = s1.pop();
                System.out.println(temp.data + "");
                if(null != temp.right)
                {
                    s2.push(temp.right);
                }
                if(null != temp.left)
                {
                    s2.push(temp.left);
                }

            }

            while(!s2.empty())
            {
                Node temp = s2.pop();
                System.out.println(temp.data + "");
                if(null != temp.left)
                {
                    s1.push(temp.left);
                }
                if(null != temp.right)
                {
                    s1.push(temp.right);
                }
            }

        }
    }
}
