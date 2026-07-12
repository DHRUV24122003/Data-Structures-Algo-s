package Binary_Search_Tree;
import java.util.*;

public class MergeTwoBTrees {

        // Main function: Do balanced BSTs ko merge karke ek balanced BST return karta hai
        public Node mergeTwoBSTs(Node root1, Node root2) {
            List<Integer> list1 = new ArrayList<>();
            List<Integer> list2 = new ArrayList<>();

            // Step 1: Dono trees ka inorder traversal karo (sorted values milengi)
            inorder(root1, list1);
            inorder(root2, list2);

            // Step 2: Do sorted lists ko merge karo
            List<Integer> mergedList = mergeSortedLists(list1, list2);

            // Step 3: Merged sorted list se balanced BST banao
            return buildBalancedBST(mergedList, 0, mergedList.size() - 1);
        }

        // Helper: Inorder traversal (BST ka inorder hamesha sorted hota hai)
        private void inorder(Node node, List<Integer> list) {
            if (node == null) return;
            inorder(node.left, list);
            list.add(node.data);
            inorder(node.right, list);
        }

        // Helper: Do sorted lists ko merge karta hai (Merge Sort jaisa)
        private List<Integer> mergeSortedLists(List<Integer> list1, List<Integer> list2) {
            List<Integer> merged = new ArrayList<>();
            int i = 0, j = 0;

            // Dono lists ko compare karke chhote element ko pehle daalo
            while (i < list1.size() && j < list2.size()) {
                if (list1.get(i) < list2.get(j)) {
                    merged.add(list1.get(i));
                    i++;
                } else {
                    merged.add(list2.get(j));
                    j++;
                }
            }

            // Agar list1 mein elements bache hain
            while (i < list1.size()) {
                merged.add(list1.get(i));
                i++;
            }

            // Agar list2 mein elements bache hain
            while (j < list2.size()) {
                merged.add(list2.get(j));
                j++;
            }

            return merged;
        }

        // Helper: Sorted list se balanced BST banata hai (Minimum height)
        private Node buildBalancedBST(List<Integer> list, int start, int end) {
            if (start > end) {
                return null;
            }

            // Middle element ko root banao → yeh balanced tree deta hai
            int mid = start + (end - start) / 2;
            Node root = new Node(list.get(mid));

            root.left = buildBalancedBST(list, start, mid - 1);
            root.right = buildBalancedBST(list, mid + 1, end);

            return root;
        }

        // Bonus: Inorder print karne ke liye
        public static void printInorder(Node node) {
            if (node == null) return;
            printInorder(node.left);
            System.out.print(node.data + " ");
            printInorder(node.right);
        }

        // Bonus: Height calculate karne ke liye
        public static int getHeight(Node node) {
            if (node == null) return 0;
            return 1 + Math.max(getHeight(node.left), getHeight(node.right));
        }

        // Driver Code
        public static void main(String[] args) {
            // Tree 1
            Node root1 = new Node(3);
            root1.left = new Node(1);
            root1.right = new Node(5);

            // Tree 2
            Node root2 = new Node(4);
            root2.left = new Node(2);
            root2.right = new Node(6);

            System.out.println("Tree 1 Inorder: ");
            printInorder(root1);
            System.out.println("\nTree 2 Inorder: ");
            printInorder(root2);

            MergeTwoBTrees sol = new MergeTwoBTrees();
            Node mergedRoot = sol.mergeTwoBSTs(root1, root2);

            System.out.println("\n\nMerged Balanced BST Inorder: ");
            printInorder(mergedRoot);
            System.out.println("\nHeight of Merged Tree: " + getHeight(mergedRoot));
        }
    }

