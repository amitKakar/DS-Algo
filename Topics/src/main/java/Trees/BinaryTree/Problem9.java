package Trees.BinaryTree;
// Change a Binary Tree so that every node stores sum of all nodes in right subtree
public class Problem9 {
    static int updatetree(Node root)
    {

        if(null == root)
        {
            return 0;
        }
        if(root.left == null && root.right == null)
        {
            return root.data;
        }
        int leftSubTreeSum = updatetree(root.left);
        int rightSubTreeSum = updatetree(root.right);
        // add left sub tree to current
        root.data += rightSubTreeSum;
        // return root.data+leftsubtree+rightsubtree  (since for parent node rightSubTreeSum is also part of left subtree.)
        return root.data+leftSubTreeSum;
    }

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
        Node root = new Node(1);
        root.left         = new Node(2);
        root.right     = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        updatetree(root);


        System.out.println("Inorder traversal of the modified tree is");
        inorder(root);
    }
}
