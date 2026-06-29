package Trees;

import java.util.*;

class TreeNode {
int val;
TreeNode left;
TreeNode right;
TreeNode(int val) { this.val = val; }
}

 class BoundaryTraversal {

    public List<Integer> boundaryTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) return result;

        // Add root
        result.add(root.val);

        // If root is leaf, return
        if (root.left == null && root.right == null) return result;

        // Add Left Boundary
        addLeftBoundary(root.left, result);

        // Add all Leaf Nodes
        addLeaves(root, result);

        // Add Right Boundary in reverse
        addRightBoundary(root.right, result);

        return result;
    }

    private void addLeftBoundary(TreeNode node, List<Integer> result) {
        while (node != null) {
            if (node.left != null || node.right != null) { // non-leaf
                result.add(node.val);
            }
            if (node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
    }

    private void addLeaves(TreeNode node, List<Integer> result) {
        if (node == null) return;

        if (node.left == null && node.right == null) {
            result.add(node.val);
            return;
        }

        addLeaves(node.left, result);
        addLeaves(node.right, result);
    }

    private void addRightBoundary(TreeNode node, List<Integer> result) {
        Stack<Integer> stack = new Stack<>();

        while (node != null) {
            if (node.left != null || node.right != null) { // non-leaf
                stack.push(node.val);
            }
            if (node.right != null) {
                node = node.right;
            } else {
                node = node.left;
            }
        }

        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
    }

    // ==================== MAIN FUNCTION ====================
    public static void main(String[] args) {
        BoundaryTraversal  sol = new BoundaryTraversal ();

        // Creating the tree
        /*
                1
               / \
              2   3
             / \   \
            4   5   6
               / \
              7   8
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);

        // Call boundary traversal
        List<Integer> boundary = sol.boundaryTraversal(root);

        // Print result
        System.out.println("Boundary Traversal: " + boundary);
    }
}
