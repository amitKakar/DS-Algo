package Trees.BinaryTree;
// print level order traversal of binary tree with recursion.


public class Problem3
{
    Node root;

    /* Given a binary tree. Print its nodes in level order
     using array for implementing queue  */
    void printLevelOrder()
    {
        if(null == root)
        {
            return;
        }
        int height = getHeight(root);
        for(int i=1; i<= height; i++)
        {
            printLevelOrder(root,i);
        }
    }

    private void printLevelOrder(Node root, int height) {
        if (root == null)
            return;
        if(height == 1)
        {
            System.out.println(root.data + "");
        }
        else if (height > 1)
        {
            printLevelOrder(root.left, height-1);
            printLevelOrder(root.right, height-1);
        }
    }

    private int getHeight(Node root) {
        if(null == root)
        {
            return 0;
        }
        int lh = getHeight(root.left);
        int rh = getHeight(root.right);
        return Math.max(lh+1,rh+1);
    }

    public static void main(String args[])
    {
        /* creating a binary tree and entering
         the nodes */
        Problem3 tree_level = new Problem3();
        tree_level.root = new Node(1);
        tree_level.root.left = new Node(2);
        tree_level.root.right = new Node(3);
        tree_level.root.left.left = new Node(4);
        tree_level.root.left.right = new Node(5);

        System.out.println("Level order traversal of binary tree is - ");
        tree_level.printLevelOrder();
    }
}
