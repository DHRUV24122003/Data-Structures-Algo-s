package Trees;
import java.util.*;



class BracketToDL {

    int index = 0;   // For parsing bracket string

    // ==================== 1. Build Tree from Bracket String ====================
    public Node buildTree(String str) {
        if (str == null || str.length() == 0) return null;
        index = 0;
        return construct(str);
    }

    private Node construct(String s) {
        // Parse number
        int num = 0;
        boolean negative = false;

        if (s.charAt(index) == '-') {
            negative = true;
            index++;
        }

        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            num = num * 10 + (s.charAt(index) - '0');
            index++;
        }

        if (negative) num = -num;

        Node node = new Node(num);

        // Left Child
        if (index < s.length() && s.charAt(index) == '(') {
            index++; // skip '('
            node.left = construct(s);
            index++; // skip ')'
        }

        // Right Child
        if (index < s.length() && s.charAt(index) == '(') {
            index++; // skip '('
            node.right = construct(s);
            index++; // skip ')'
        }

        return node;
    }

    // ==================== 2. Convert Binary Tree to Doubly Linked List ====================
    Node prev = null;
    Node head = null;

    public Node bToDLL(Node root) {
        if (root == null) return null;

        // Inorder: Left → Root → Right
        bToDLL(root.left);

        if (prev == null) {
            head = root;           // First node (head of DLL)
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;

        bToDLL(root.right);

        return head;
    }

    // ==================== MAIN FUNCTION (Testing) ====================
    public static void main(String[] args) {

        BracketToDL obj = new BracketToDL();

        // Example Bracket String
        String str = "4(2(3)(1))(6(5))";

        System.out.println("Bracket String: " + str);

        // Step 1: Build Binary Tree from Bracket String
        Node root = obj.buildTree(str);

        System.out.print("Inorder of Tree: ");
        printInorder(root);
        System.out.println();

        // Step 2: Convert to Doubly Linked List
        Node dllHead = obj.bToDLL(root);

        // Step 3: Print DLL
        System.out.print("Doubly Linked List: ");
        printDLL(dllHead);
    }

    // Helper: Print Inorder of Tree
    public static void printInorder(Node node) {
        if (node == null) return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }
    public static void printDLL(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data);
            if (curr.right != null) System.out.print(" <-> ");
            curr = curr.right;
        }
        System.out.println();
    }
}

// Helper: