package Trees;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public ArrayList<Integer> diagonal(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            // Process entire right spine of current diagonal
            while (curr != null) {
                result.add(curr.data);
                if (curr.left != null) {
                    q.offer(curr.left);   // left goes to next diagonal
                }
                curr = curr.right;        // right stays on same diagonal
            }
        }
        return result;
    }
}

public class DiagonalTraversalClean {
    public static void main(String[] args) {
        /*
         * Example Tree (from GeeksforGeeks):
         *
         *         8
         *       /   \
         *      3     10
         *     / \      \
         *    1   6      14
         *       / \     /
         *      4   7   13
         *
         * Expected Diagonal Traversal: 8 10 14 3 6 7 13 1 4
         */

        // Build the tree
        Node root = new Node(8);

        root.left = new Node(3);
        root.right = new Node(10);

        root.left.left = new Node(1);
        root.left.right = new Node(6);

        root.left.right.left = new Node(4);   // 6 -> left
        root.left.right.right = new Node(7);  // 6 -> right

        root.right.right = new Node(14);
        root.right.right.left = new Node(13); // 14 -> left

        // Call the solution
        Solution sol = new Solution();
        ArrayList<Integer> result = sol.diagonal(root);

        // Print the result
        System.out.println("Diagonal Traversal of the Binary Tree:");
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i));
            if (i < result.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();

        // Also print as list for clarity
        System.out.println("\nAs ArrayList: " + result);
    }
}

