package Binary_Search_Tree;

public class CheckBST {

        // ==================== RANGE METHOD (BEST) ====================
        public static boolean isBST(Node root) {
            return isBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private static boolean isBSTUtil(Node node, long min, long max) {
            // Base case: agar node null hai toh BST hai
            if (node == null) {
                return true;
            }

            // Agar current node apni range ke bahar hai toh BST nahi
            if (node.data <= min || node.data >= max) {
                return false;
            }

            // Left subtree check karo (max update karo)
            // Right subtree check karo (min update karo)
            return isBSTUtil(node.left, min, node.data) &&
                    isBSTUtil(node.right, node.data, max);
        }

        // ==================== MAIN METHOD ====================
        public static void main(String[] args) {

            // Example 1: Valid BST
            Node root1 = new Node(10);
            root1.left = new Node(5);
            root1.right = new Node(15);
            root1.left.left = new Node(2);
            root1.left.right = new Node(7);
            root1.right.right = new Node(20);

            System.out.println("Tree 1 is BST? " + isBST(root1));   // true

            // Example 2: Not a BST
            Node root2 = new Node(10);
            root2.left = new Node(5);
            root2.right = new Node(15);
            root2.right.left = new Node(12);   // galat hai (12 < 15)

            System.out.println("Tree 2 is BST? " + isBST(root2));   // false
        }
    }





    //--------2nd way using inorder traversal

//public class CheckBST_Inorder {
//
//    static Integer prev = null;   // previous node ki value store karne ke liye
//
//    public static boolean isBST(Node root) {
//        prev = null;
//        return inorderCheck(root);
//    }
//
//    private static boolean inorderCheck(Node node) {
//        if (node == null) {
//            return true;
//        }
//
//        // Left subtree check karo
//        if (!inorderCheck(node.left)) {
//            return false;
//        }
//
//        // Current node previous se chhota ya barabar hai toh BST nahi
//        if (prev != null && node.data <= prev) {
//            return false;
//        }
//
//        prev = node.data;   // current value ko previous mein store karo
//
//        // Right subtree check karo
//        return inorderCheck(node.right);
//    }
//
//    public static void main(String[] args) {
//
//        Node root = new Node(10);
//        root.left = new Node(5);
//        root.right = new Node(15);
//        root.left.left = new Node(2);
//        root.left.right = new Node(7);
//
//        System.out.println("Is BST? " + isBST(root));   // true
//    }
//}
