package Trees;

import java.util.Stack;


//recursive method
public class PreorderTraversal {


//    public static void printPreorder(Node root){
//        if(root == null){
//            return; //agar node nahi hai to wapas jao
//        }
//        System.out.println(root.data + " ");//pahle root print karo
//        printPreorder(root.left);//fir left subtree
//        printPreorder(root.right);//fir right subtree
//    }
    //(iterative approach)
    //public class IterativePreorder {

        public void preorderIterative(Node root) {

            if (root == null) return;

            // Stack banaya
            Stack<Node> stack = new Stack<>();
            stack.push(root);                    // Pehle root ko stack mein daalo

            while (!stack.isEmpty()) {

                // Stack se node nikaalo aur visit (print) karo
                Node current = stack.pop();
                System.out.print(current.data + " ");

                // === IMPORTANT ===
                // Right child pehle push karo, phir Left child
                // Kyunki Stack LIFO hota hai, Left pehle nikalna chahiye
                if (current.right != null) {
                    stack.push(current.right);
                }
                if (current.left != null) {
                    stack.push(current.left);
                }
            }
        }



    //so we understand the\at first it will traverse the entire tree with left subtrees
        public static void main() {
        Node root = new Node(2);
        root.left = new Node(3);
        root.left.left = new Node(5);
        root.left.left.left = new Node(7);
        root.left.left.left.left = new Node(8);
        root.left.left.left.left.left = new Node(10);
        root.left.left.left.left.left.left= new Node(11);
        root.left.left.left.right = new Node(9);
        root.left.right = new Node(6);
        root.left.right.right = new Node(3);
        root.right = new Node(4);
        root.left.left.left.left.right = new Node(12);
        root.right.left = new Node(5);
        root.right.left.left = new Node(13);

        PreorderTraversal obj = new PreorderTraversal();

        System.out.println("Preorder Traversal (Pura Tree):");
        obj.preorderIterative(root);
    }
}



