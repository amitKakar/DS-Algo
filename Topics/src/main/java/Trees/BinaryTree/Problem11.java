package Trees.BinaryTree;
// Convert an arbitrary Binary Tree to a tree that holds Children Sum Property.
public class Problem11 {

    // Utility function to do inorder traversal
    static void printInorder(Node node)
    {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    // Driver program to test above functions
    public static void main(String args[])
    {
        Node root = new Node(50);
        root.left = new Node(7);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(1);
        root.right.right = new Node(30);

        System.out.println("Inorder traversal before conversion is :");
        printInorder(root);
        convertTree(root);
        System.out.println("");
        System.out.println("Inorder traversal after conversion is :");
        printInorder(root);
    }

    private static void convertTree(Node root) {
        int leftData = 0, rightData = 0;
        int diff;

        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        convertTree(root.left);
        convertTree(root.right);

        if (null != root.left) {
            leftData = root.left.data;
        }
        if (null != root.right) {
            rightData = root.right.data;
        }

        diff = leftData + rightData - root.data;

        if (diff < 0) {
            increment(root, -diff);
        } else if (diff > 0) {
            root.data += diff;
        }
    }

    private static void increment(Node root, int diff) {

        if(root.left != null)
        {
            root.left.data +=  diff;
            increment(root.left, diff);
        }

        else if(root.right != null)
        {
            root.right.data +=  diff;
            increment(root.right, diff);
        }
    }
}
