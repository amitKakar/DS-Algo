package Trees.BinaryTree;
// print level order traversal of binary tree without recursion.
import java.util.LinkedList;
import java.util.Queue;

public class Problem2 {
    Node root;

    /* Given a binary tree. Print its nodes in level order
     using array for implementing queue  */
    void printLevelOrder()
    {
        if(root == null)
        {
            return;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            Node curr = queue.poll();
            System.out.println(curr.data+ "");
            if(null != curr.left)
            {
                queue.add(curr.left);
            }
            if(null != curr.right)
            {
                queue.add(curr.right);
            }
        }
    }
    public static void main(String args[])
    {
        /* creating a binary tree and entering
         the nodes */
        Problem2 tree_level = new Problem2();
        tree_level.root = new Node(1);
        tree_level.root.left = new Node(2);
        tree_level.root.right = new Node(3);
        tree_level.root.left.left = new Node(4);
        tree_level.root.left.right = new Node(5);

        System.out.println("Level order traversal of binary tree is - ");
        tree_level.printLevelOrder();
    }
}
