package Trees.BinaryTree;
// Convert a given tree to its Sum Tree
public class Problem10 {

    // Utility function to do inorder traversal
    static void inorder(Node node)
    {
        if (node == null)
            return;
        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    // Driver program
    public static void main(String[] args)
    {
    /* Let us construct below tree
                1
            / \
            2 3
            / \ \
            4 5 6 */
        Node root = new Node(10);
        root.left = new Node(-2);
        root.right = new Node(6);
        root.left.left = new Node(8);
        root.left.right = new Node(-4);
        root.right.left = new Node(7);
        root.right.right = new Node(5);
        updatetree(root);
        System.out.println("Inorder traversal of the modified tree is");
        inorder(root);
    }

    private static int updatetree(Node root) {

        if (root == null)
            return 0;
        int leftSubTreeSum = updatetree(root.left);
        int rightSubTreeSum = updatetree(root.right);
        int temp = root.data;
        root.data = leftSubTreeSum + rightSubTreeSum;
        return root.data+temp;
    }
}
