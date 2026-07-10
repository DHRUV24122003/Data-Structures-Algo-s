package Trees;

import java.util.*;

public class Maximum_Sum_Subtree {
    //so we have to store the maximum sum with the smallest integer
    int maxSum = Integer.MIN_VALUE;

    public int findLargestSubtreeSum(Node root) {
        calculateSum(root);//calling the function here
        return maxSum;
    }

    private int calculateSum(Node node) {
        //base case
        if (node == null) {
            return 0;
        }

        int leftSum = calculateSum(node.left);//for the left
        int rightSum = calculateSum(node.right);//for right
        int currentSum = leftSum + rightSum + node.data;// for node
        maxSum = Math.max(currentSum, maxSum);
        return currentSum;
    }


    static void main() {
        // Example Tree banate hain:
        /*
                  1
                 / \
                2   3
               / \   \
              4   5   6
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        Maximum_Sum_Subtree obj = new Maximum_Sum_Subtree();
        int result = obj.findLargestSubtreeSum(root);

        System.out.println("Largest Subtree Sum = " + result);
        // Output: Largest Subtree Sum = 21
    }
}






