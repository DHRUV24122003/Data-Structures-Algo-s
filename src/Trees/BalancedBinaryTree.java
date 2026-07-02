package Trees;





public class BalancedBinaryTree {
         // a balanced binary tree is a tree which is having a height difference 1 or 0 between it's left and right subtree

        // TreeNode definition
        static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int val) {
                this.val = val;
                this.left = null;
                this.right = null;
            }
        }

        // Main function to check if tree is height-balanced
        public static boolean isBalanced(TreeNode root) {

            return checkHeight(root) != -1;
        }

        // Helper function: returns height if balanced, else returns -1
        private static int checkHeight(TreeNode node) {
            if (node == null) {
                return 0;
            }

            // Check left subtree
            int leftHeight = checkHeight(node.left);
            if (leftHeight == -1) {
                return -1;  // Left subtree unbalanced
            }

            // Check right subtree
            int rightHeight = checkHeight(node.right);
            if (rightHeight == -1) {
                return -1;  // Right subtree unbalanced
            }

            // Check balance condition at current node
            if (Math.abs(leftHeight - rightHeight) > 1) {
                return -1;
            }

            // Return height of current subtree
            return Math.max(leftHeight, rightHeight) + 1;
        }

        // ==================== TEST CASES ====================
        public static void main(String[] args) {
            System.out.println("=== Height Balanced Binary Tree Checker ===\n");

            // Example 1: Balanced Tree
            //       1
            //      / \
            //     2   3
            //    / \   \
            //   4   5   6
            TreeNode root1 = new TreeNode(1);
            root1.left = new TreeNode(2);
            root1.right = new TreeNode(3);
            root1.left.left = new TreeNode(4);
            root1.left.right = new TreeNode(5);
            root1.right.right = new TreeNode(6);

            System.out.println("Example 1 (Balanced Tree): " + isBalanced(root1));  // Expected: true

            // Example 2: Unbalanced Tree (left skewed)
            //     1
            //    /
            //   2
            //  /
            // 3
            TreeNode root2 = new TreeNode(1);
            root2.left = new TreeNode(2);
            root2.left.left = new TreeNode(3);

            System.out.println("Example 2 (Unbalanced Tree): " + isBalanced(root2));  // Expected: false

            // Example 3: Empty tree
            TreeNode root3 = null;
            System.out.println("Example 3 (Empty Tree): " + isBalanced(root3));  // Expected: true

            // Example 4: Single node (always balanced)
            TreeNode root4 = new TreeNode(10);
            System.out.println("Example 4 (Single Node): " + isBalanced(root4));  // Expected: true

            // Example 5: Another balanced tree
            //       1
            //      / \
            //     2   3
            //    /
            //   4
            TreeNode root5 = new TreeNode(1);
            root5.left = new TreeNode(2);
            root5.right = new TreeNode(3);
            root5.left.left = new TreeNode(4);

            System.out.println("Example 5 (Balanced): " + isBalanced(root5));  // Expected: true
        }
    }


    //summary of the solution
//check the height difference at each node and if it comes out to be more than 1 return unbalanced
//make a function which checks the height of of tree at each node
//initialize leftheight with left node inside the function int leftHeight = checkHeight(root.left), and if it is -1 then return -1;
//same for the rightNode
//Now check the height differences if (Math.abs(leftHeight - rightHeight) > 1) {
//            return -1;
//        }
//return the maximum from leftheight and rightheight (return Math.max(leftHeight, rightHeight) + 1;)

