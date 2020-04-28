package Trees.BinaryTree.BST;
// transform-bst-sum-tree
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
// Transform a BST to greater sum tree
public class Problem1 {
    /* testing for example nodes */
    static int sum = 0;
    public static void main(String args[])
    {
        /* creating a binary tree and entering the nodes */
        Node root = new Node(11);
        root.left = new Node(2);
        root.right = new Node(29);
        root.left.left = new Node(1);
        root.left.right = new Node(7);
        root.right.left = new Node(15);
        root.right.right = new Node(40);
        root.right.right.left = new Node(35);
        /* print inorder traversal of the input tree */
        System.out.println("Inorder traversal of input tree is :");
        inOrder(root);
        System.out.println("");

        /* convert tree to its mirror */
        transform(root);

        /* print inorder traversal of the minor tree */
        System.out.println("Inorder traversal of binary tree is : ");
        inOrder(root);

    }

    private static void transform(Node root) {
        if(null == root)
        {
            return;
        }
        transform(root.right);
        sum += root.data;
        root.data = sum - root.data;
        transform(root.left);
    }

    private static void inOrder(Node root) {
        if(null == root)
        {
            return;
        }
        inOrder(root.left);
        System.out.println(root.data);
        inOrder(root.right);
    }

}
