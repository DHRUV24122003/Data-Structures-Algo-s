package Trees;

import java.util.Stack;

public class InorderTraversal {
    //the basic difference between preorder and inorder is
    //preorder prints root first then left and then right values
    //inorder prints left then root and then right

    // Inorder Traversal Method(Recursive way)
//        public static void printInorder(Node node) {
//
//            if (node == null) {
//                return;                    // Base Case
//            }
//
//            // Step 1: Left subtree
//            printInorder(node.left);
//
//            // Step 2: Root (Current Node)
//            System.out.print(node.data + " ");
//
//            // Step 3: Right subtree
//            printInorder(node.right);
//        }


    //Iterative way (by using stack)
    public void inorderIterative(Node root) {

        // Stack banaya
        Stack<Node> stack = new Stack<>();
        Node current = root;           // Current node ko root se start karo

        // Jab tak current node hai ya stack mein kuch hai
        while (current != null || !stack.isEmpty()) {

            // Step 1: Leftmost node tak jaate raho aur stack mein push karte raho
            while (current != null) {
                stack.push(current);       // Current node ko stack mein daalo
                current = current.left;    // Left child pe jaao
            }

            // Step 2: Stack se node nikaalo aur print karo (Visit)
            current = stack.pop();
            System.out.print(current.data + " ");

            // Step 3: Ab right subtree process karo
            current = current.right;
        }
    }

    public static void main(String[] args) {

        // Tree banana
        Node root = new Node(10);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right = new Node(15);
        root.right.right = new Node(20);
        InorderTraversal obj = new InorderTraversal();

        System.out.println("Inorder Traversal:");
        //printInorder(root);
        obj.inorderIterative(root);
    }
}

