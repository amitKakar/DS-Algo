package Trees.BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Diagonal Traversal of Binary Tree
public class Problem6 {

    private static void diagonalPrint(Node root) {
        Map<Integer,List<Integer>>diagMap = new HashMap<Integer,List<Integer>>();
        diagonalPrint(root,0,diagMap);
        if(null != diagMap)
        {
            System.out.println("Diagonal Traversal of Binnary Tree");
            for (Map.Entry<Integer, List<Integer>> entry : diagMap.entrySet())
            {
                System.out.println(entry.getValue());
            }
        }
    }

    private static void diagonalPrint(Node root, int d, Map<Integer, List<Integer>> diagMap) {
        if(null == root)
        {
            return;
        }
        List<Integer> currList = diagMap.get(d);
        if(null == currList)
        {
            currList = new ArrayList<Integer>();
        }
        currList.add(root.data);
        diagMap.put(d,currList);
        diagonalPrint(root.left, d+1, diagMap);
        diagonalPrint(root.right, d, diagMap);
    }


    // Driver program
    public static void main(String[] args) {

        Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);

        diagonalPrint(root);
    }
}

