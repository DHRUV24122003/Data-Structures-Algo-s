package Binary_Search_Tree;

public class KthLargestInBST {



        // Definition for a binary tree node
        static class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int val) {
                this.val = val;
            }
        }

        static class Solution {
            private int count = 0;
            private int result = -1;

            public int kthLargest(TreeNode root, int k) {
                count = 0;
                result = -1;
                reverseInorder(root, k);
                return result;
            }

            // Reverse In-Order: Right → Root → Left (gives descending order)
            private void reverseInorder(TreeNode node, int k) {
                // Base case + early stopping
                if (node == null || count >= k) {
                    return;
                }

                // 1. Visit RIGHT subtree first (larger values)
                reverseInorder(node.right, k);

                // 2. Visit current node
                count++;
                if (count == k) {
                    result = node.val;
                    return; // Found the k-th largest
                }

                // 3. Visit LEFT subtree (smaller values)
                reverseInorder(node.left, k);
            }
        }

        // ==================== TEST / DRIVER ====================
        public static void main(String[] args) {
            /*
             * Build the example BST:
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

            Solution solution = new Solution();

            // Test cases
            System.out.println("3rd largest: " + solution.kthLargest(root, 3)); // Expected: 5
            System.out.println("1st largest: " + solution.kthLargest(root, 1)); // Expected: 8
            System.out.println("6th largest: " + solution.kthLargest(root, 6)); // Expected: 2
        }
    }




//Short Approach:
//BST mein normal inorder (Left → Root → Right) sorted ascending order deta hai.
//Lekin hume k-th largest chahiye, yani descending order mein k-th element.
//Solution:
//
//Reverse Inorder traversal karo → Right → Root → Left
//Ek count variable maintain karo
//Jaise hi count == k ho jaye, wahi node return kar do
