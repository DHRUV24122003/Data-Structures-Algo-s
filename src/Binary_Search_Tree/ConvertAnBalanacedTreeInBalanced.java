package Binary_Search_Tree;
import java.util.*;


public class ConvertAnBalanacedTreeInBalanced {



        // Main function: Unbalanced BST ko Balanced BST mein convert karta hai
        public Node balanceBST(Node root) {
            if (root == null) {
                return null;                          // Agar tree empty hai to null return karo
            }

            List<Integer> inorder = new ArrayList<>();
            // Step 1: Inorder values store karne ke liye list banayi

            inorderTraversal(root, inorder);
            // Step 2: BST ka inorder traversal → sorted list ban jayegi

            // Step 3: Sorted list se balanced BST build karo (minimum height)
            return buildBalancedBST(inorder, 0, inorder.size() - 1);
        }

        // Helper: Inorder traversal karke values list mein daalta hai
        private void inorderTraversal(Node node, List<Integer> inorder) {
            if (node == null) {
                return;                               // Base case
            }

            inorderTraversal(node.left, inorder);     // Left subtree pehle
            inorder.add(node.data);                    // Current node add karo (sorted order mein aayega)
            inorderTraversal(node.right, inorder);    // Right subtree baad mein
        }

        // Helper: Sorted list se balanced BST banata hai (sabse important function)
        private Node buildBalancedBST(List<Integer> inorder, int start, int end) {
            if (start > end) {
                return null;                          // Base case: invalid range
            }

            // Middle element choose karo → yeh minimum height deta hai
            int mid = start + (end - start) / 2;

            Node root = new Node(inorder.get(mid));
            // Middle value ko root banao

            // Left half se left subtree banao
            root.left = buildBalancedBST(inorder, start, mid - 1);

            // Right half se right subtree banao
            root.right = buildBalancedBST(inorder, mid + 1, end);

            return root;                              // Balanced subtree return karo
        }

        // Bonus: Tree ki height calculate karne ke liye
        public static int getHeight(Node node) {
            if (node == null) {
                return 0;
            }
            return 1 + Math.max(getHeight(node.left), getHeight(node.right));
        }

        // Bonus: Inorder print karne ke liye (verify karne ke liye)
        public static void printInorder(Node node) {
            if (node == null) return;
            printInorder(node.left);
            System.out.print(node.data + " ");
            printInorder(node.right);
        }

        // Driver code - Example ke liye
        public static void main(String[] args) {
            // Unbalanced BST banao (Right skewed)
            Node root = new Node(1);
            root.right = new Node(2);
            root.right.right = new Node(3);
            root.right.right.right = new Node(4);
            root.right.right.right.right = new Node(5);

            System.out.println("=== Before Balancing ===");
            System.out.print("Inorder: ");
            printInorder(root);
            System.out.println();
            System.out.println("Height: " + getHeight(root));   // Height = 5 (bahut zyada)

            ConvertAnBalanacedTreeInBalanced sol = new ConvertAnBalanacedTreeInBalanced();
            Node balancedRoot = sol.balanceBST(root);

            System.out.println("\n=== After Balancing ===");
            System.out.print("Inorder: ");
            printInorder(balancedRoot);
            System.out.println();
            System.out.println("Height: " + getHeight(balancedRoot)); // Height = 3 (minimum possible)

            // Note: Inorder same rahega (sorted), lekin height kam ho jayegi
        }
    }
















//1. Do inorder traversal of given BST and store nodes in a list (sorted order)
//2. Use this sorted list to build a new balanced BST:
//a. Find middle element → make it root
//b. Recursively build left subtree from left half
//c. Recursively build right subtree from right half
//3. Return the new root