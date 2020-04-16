package Trees.BinaryTree;

public class Problem7 {

    static Node temp;

    // Driver program to test above functions
    public static void main(String args[])
    {
        // Let's con the binary tree
        // as shown in above diagram

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);


        /*
        Right child of node is not NULL.
        If the right child of the node is not NULL then the inorder successor of this node will be the leftmost node
        in it’s right subtree.
        */
        // Case 1
        inorderSuccesor(root, root.right);

        /*
        Right Child of the node is NULL.
        If the right child of node is NULL.
        Then we keep finding the parent of the given node x, say p such that p->left = x.
        For example in the above given tree, inorder successor of node 5 will be 1.
        First parent of 5 is 2 but 2->left != 5.
        So next parent of 2 is 1, now 1->left = 2.
        Therefore, inorder successor of 5 is 1.
        Below is the algorithm for this case:
        Suppose the given node is x. Start traversing the tree from root node to find x recursively.
        If root == x, stop recursion otherwise find x recursively for left and right subtrees.
        Now after finding the node x, recur­sion will back­track to the root.
        Every recursive call will return the node itself to the calling function,
        we will store this in a temporary node say temp.
        Now, when it back­tracked to its par­ent which will be root now, check whether root.left = temp, if not , keep going up
         */
        // case 2
        inorderSuccesor(root, root.left.left);

        /*
        If node is the rightmost node.
        If the node is the rightmost node in the given tree.
        For example, in the above tree node 6 is the right most node.
        In this case, there will be no inorder successor of this node.
        i.e. Inorder Successor of the rightmost node in a tree is NULL.
         */
        // case 3
        inorderSuccesor(root, root.right.right);

    }

    private static void inorderSuccesor(Node root, Node x) {
        if(root == null)
        {
            return;
        }

        if(x.right != null)
        {
            Node temp = traverseLeftMost(x.right);
            if(null != temp)
            {
                System.out.println("inorder successor is: "+temp.data);
            }
        }
        if(x.right == null)
        {

            Node rightMost = traverseRightMost(root);

            if(rightMost == x)
            {
                System.out.println("no successor present");
            }
            else
            {
              inorderFinalSuccesor(root,x);
            }

        }
    }

    private static Node inorderFinalSuccesor(Node root, Node x) {
        if(null == root)
        {
            return null;
        }

        if (root == x || (temp = inorderFinalSuccesor(root.left, x)) != null
                || (temp = inorderFinalSuccesor(root.right, x)) != null)
        {
            if(null != temp)
            {
                if (root.left == temp)
                {
                    System.out.print( "Inorder Successor is "+ root.data + "\n");
                    return null;
                }
            }
        }
        return root;
    }

    private static Node traverseLeftMost(Node left) {
        while(left != null && left.left != null)
        {
            left = left.left;
        }
        return left;
    }

    private static Node traverseRightMost(Node right) {
        while(right != null && right.right != null)
        {
            right = right.right;
        }
        return right;
    }
}
