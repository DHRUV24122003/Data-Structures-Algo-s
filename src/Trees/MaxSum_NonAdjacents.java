package Trees;

import java.util.*;
public class MaxSum_NonAdjacents {
    public int rob(Node root){
        int[] result =  helper(root);
        //result [0] = we are taking max as this node
        //result [1] = not taking this as max
        return Math.max(result[0], result[1]);
    }
    public int [] helper(Node node){
        if(node == null){
            return new int[]{0,0};
        }
        int[] left = helper(node.left);
        int[] right = helper(node.right);

        // Case 1: Is node ko LO
        // Phir left aur right ke children ko nahi le sakte
        // isliye left[1] + right[1] + current
        int rob = node.data + left[1] + right[1];

        // Case 2: Is node ko MAT LO
        // Phir left aur right se maximum le sakte ho (rob ya notRob)
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{rob, notRob};

    }
    public static void main(String[] args) {

        // Example Tree (answer = 9)
        /*
                 3
                / \
               4   5
              / \   \
             1   3   1
        */

        Node root = new Node(3);
        root.left = new Node(4);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(7);
        root.right.right = new Node(1);

        MaxSum_NonAdjacents obj = new MaxSum_NonAdjacents();
        int answer = obj.rob(root);

        System.out.println("Maximum Sum = " + answer);
        // Output: Maximum Sum = 9
    }
}


