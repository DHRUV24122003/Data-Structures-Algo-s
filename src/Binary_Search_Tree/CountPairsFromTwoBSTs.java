package Binary_Search_Tree;


import java.util.*;
public class CountPairsFromTwoBSTs {


        static class TreeNode {
            int val;
            TreeNode left, right;
            TreeNode(int val) { this.val = val; }
        }

        static class Solution {
            private void inorder(TreeNode root, List<Integer> list) {
                if (root == null) return;
                inorder(root.left, list);
                list.add(root.val);
                inorder(root.right, list);
            }

            public int countPairs(TreeNode root1, TreeNode root2, int x) {
                List<Integer> list1 = new ArrayList<>();
                List<Integer> list2 = new ArrayList<>();

                inorder(root1, list1);
                inorder(root2, list2);

                int i = 0;
                int j = list2.size() - 1;
                int count = 0;

                while (i < list1.size() && j >= 0) {
                    int sum = list1.get(i) + list2.get(j);

                    if (sum == x) {
                        int val1 = list1.get(i);
                        int val2 = list2.get(j);

                        int freq1 = 0;
                        while (i < list1.size() && list1.get(i) == val1) {
                            freq1++;
                            i++;
                        }

                        int freq2 = 0;
                        while (j >= 0 && list2.get(j) == val2) {
                            freq2++;
                            j--;
                        }

                        count += freq1 * freq2;
                    }
                    else if (sum < x) {
                        i++;
                    }
                    else {
                        j--;
                    }
                }
                return count;
            }
        }

        public static void main(String[] args) {
            // BST 1
            TreeNode root1 = new TreeNode(5);
            root1.left = new TreeNode(3);
            root1.right = new TreeNode(7);
            root1.left.left = new TreeNode(2);
            root1.left.right = new TreeNode(4);

            // BST 2 (CORRECT structure)
            TreeNode root2 = new TreeNode(10);
            root2.left = new TreeNode(6);
            root2.left.right = new TreeNode(8);
            root2.right = new TreeNode(15);
            root2.right.left = new TreeNode(12);

            Solution sol = new Solution();
            int x = 15;

            System.out.println("Number of pairs: " + sol.countPairs(root1, root2, x));
            // Expected: 3
        }
    }