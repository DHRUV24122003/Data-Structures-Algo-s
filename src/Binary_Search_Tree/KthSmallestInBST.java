package Binary_Search_Tree;

public class KthSmallestInBST {

        static class TreeNode {
            int val;
            TreeNode left, right;

            TreeNode(int val) {
                this.val = val;
            }
        }

        static class Solution {
            private int count = 0;
            private int result = -1;

            public int kthSmallest(TreeNode root, int k) {
                if (k <= 0 || root == null) return -1;

                count = 0;
                result = -1;

                inorder(root, k);
                return result;
            }

            private void inorder(TreeNode node, int k) {
                if (node == null || count >= k) {
                    return;
                }

                // Left
                inorder(node.left, k);

                // Root
                count++;
                if (count == k) {
                    result = node.val;
                    return;
                }

                // Right
                inorder(node.right, k);
            }
        }

        // ==================== TEST CASES ====================
        public static void main(String[] args) {
            /*
             * Tree:
             *         5
             *        / \
             *       3   7
             *      / \   \
             *     2   4   8
             */
            TreeNode root = new TreeNode(5);
            root.left = new TreeNode(3);
            root.right = new TreeNode(7);
            root.left.left = new TreeNode(2);
            root.left.right = new TreeNode(4);
            root.right.right = new TreeNode(8);

            Solution sol = new Solution();

            System.out.println("k = 1: " + sol.kthSmallest(root, 1));   // 2
            System.out.println("k = 3: " + sol.kthSmallest(root, 3));   // 4
            System.out.println("k = 6: " + sol.kthSmallest(root, 6));   // 8
            System.out.println("k = 7: " + sol.kthSmallest(root, 7));   // -1 (invalid)
            System.out.println("k = 0: " + sol.kthSmallest(root, 0));   // -1
        }
    }



//Approach (Short & Clear)
//Since it's a BST:
//
//Normal Inorder traversal (Left → Root → Right) visits nodes in ascending sorted order.
//

//Steps:

//Perform Inorder traversal.
//Maintain a count of visited nodes.
//When count == k, store that node's value as the answer.
//If after complete traversal count < k, return -1.
//
//This is the standard and most efficient way without modifying the tree.
//
//Time Complexity: O(N)
//Space Complexity: O(H) (recursion stack)
