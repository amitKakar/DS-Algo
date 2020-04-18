package Trees.BinaryTree;
// Check sum of Covered and Uncovered nodes of Binary Tree
public class Problem13 {
    // Driver program to test above functions
    public static void main(String[] args) {


        // Making above given diagram's binary tree
        Node root = new Node(8);
        root.left = new Node(3);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);
        root.right = new Node(10);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);

        if (isSumSame(root))
            System.out.println("Sum of covered and uncovered is same");
        else
            System.out.println("Sum of covered and uncovered is not same");
    }

    private static boolean isSumSame(Node root) {
        if (null == root) {
            return true;
        }

        int left = uncoveredSumLeft(root.left);
        int right = uncoveredSumRight(root.right);
        int total = totalSum(root);
        return (total == left + right);
    }

    private static int totalSum(Node root) {

        if (root == null) {
            return 0;
        }

        return root.data + totalSum(root.left) + totalSum(root.right);
    }

    private static int uncoveredSumRight(Node root) {
        if (root.left == null && root.right == null) {
            return root.data;
        }

        if (null != root.right) {
            return root.data + uncoveredSumLeft(root.right);
        } else {
            return root.data + uncoveredSumLeft(root.left);
        }
    }

    private static int uncoveredSumLeft(Node root) {
        if (root.left == null && root.right == null) {
            return root.data;
        }
        if (null != root.left) {
            return root.data + uncoveredSumLeft(root.left);
        } else {
            return root.data + uncoveredSumLeft(root.right);
        }
    }
}
