package Trees;


import java.util.*;



public class SumOfLongestPath {

    // Global variables to store final answer
    static int maxLen = 0;           // Sabse lambi path ki length
    static int maxSum = Integer.MIN_VALUE;  // Us length ki sabse badi sum

    // DFS function
    static void solve(Node root, int currLen, int currSum) {

        // Base case: agar node null hai toh return
        if (root == null) return;

        // Current node ko path mein add kar rahe hain
        currSum += root.data;
        currLen += 1;

        // Agar leaf node hai (koi child nahi)
        if (root.left == null && root.right == null) {

            // Case 1: Agar yeh path pehle se lambi hai
            if (currLen > maxLen) {
                maxLen = currLen;
                maxSum = currSum;
            }
            // Case 2: Agar length same hai, lekin sum bada hai
            else if (currLen == maxLen) {
                maxSum = Math.max(maxSum, currSum);
            }
        }

        // Left subtree explore karo
        solve(root.left, currLen, currSum);

        // Right subtree explore karo
        solve(root.right, currLen, currSum);
    }

    // Main function jo answer return karega
    static int sumOfLongRootToLeafPath(Node root) {
        maxLen = 0;
        maxSum = Integer.MIN_VALUE;

        // DFS shuru karo (length = 0, sum = 0 se)
        solve(root, 0, 0);

        return maxSum;
    }

    public static void main(String[] args) {

        // Example Tree
        /*
                4
               / \
              2   5
             / \   \
            7   2   6
        */
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(7);
        root.left.right = new Node(2);
        root.right.right = new Node(6);

        int result = sumOfLongRootToLeafPath(root);
        System.out.println("Sum of longest path = " + result);
        // Expected Output: 15  (path: 4 → 5 → 6)
    }
}