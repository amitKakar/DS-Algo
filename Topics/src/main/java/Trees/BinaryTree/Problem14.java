package Trees.BinaryTree;
// Check for Children Sum Property in a Binary Tree
public class Problem14 {

    /* driver program to test the above functions */
    public static void main(String[] args)
    {
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.right = new Node(2);
        if (isSumProperty(root))
            System.out.println("The given tree satisfies children"
                    + " sum property");
        else
            System.out.println("The given tree does not satisfy children"
                    + " sum property");
    }

    private static boolean isSumProperty(Node root) {

        if(null == root || (root.left == null && root.right == null))
        {
            return true;
        }

        int left = root.left!=null?root.left.data:0;
        int right = root.right!=null?root.right.data:0;
        return ((root.data == left + right) && isSumProperty(root.left) && isSumProperty(root.right));
    }
}
