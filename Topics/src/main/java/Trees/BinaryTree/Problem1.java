package Trees.BinaryTree;
// Boundary Traversal of binary tree

// A binary tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
public class Problem1 {
    Node root;

    // Driver program to test above functions
    public static void main(String args[])
    {
        Problem1 tree = new Problem1();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        tree.root.right = new Node(22);
        tree.root.right.right = new Node(25);
        tree.printBoundary(tree.root);
    }

    private void printBoundary(Node root) {
        if(root == null)
        {
            return;
        }
        System.out.println(root.data+ "");
        printLeft(root.left);
        printLeaf(root.left);
        printLeaf(root.right);
        printRight(root.right);
    }

    private void printLeaf(Node root) {

        if(null == root)
        {
            return;
        }
        printLeaf(root.left);
        if(root.left == null && root.right == null)
        {
            System.out.println(root.data+ "");
        }
        printLeaf(root.right);
    }

    private void printRight(Node root) {
        if(null == root)
        {
            return;
        }
        if(root.right != null)
        {
            printRight(root.right);
            System.out.println(root.data+ "");
        }
        else if(root.left != null)
        {
            printRight(root.left);
            System.out.println(root.data+ "");
        }
    }

    private void printLeft(Node root) {

        if(null == root)
        {
            return;
        }
        if(root.left != null)
        {
            System.out.println(root.data+ "");
            printLeft(root.left);
        }
        else if(root.right != null)
        {
            System.out.println(root.data+ "");
            printLeft(root.right);
        }
    }

}


