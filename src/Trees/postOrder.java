package Trees;
import java.util.*;

public class postOrder {
    //recursive method
//    public static void PrintpostOrder(Node root){
//        if(root == null){
//            return; //agar node nahi hai to wapas jao
//        }
//
//        PrintpostOrder(root.left);
//        PrintpostOrder(root.right);
//        System.out.print(root.data + " ");
//    }

    //iterative method


        public void postOrderIterative(Node root){
            if(root == null)
                return;


        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(root);
        while(!stack1.isEmpty()) {
            Node current = stack1.pop();//stack 1 me delete ho gaya
            stack2.push(current);//stack 2 me push kar diya
            if (current.left != null) {
                stack1.push(current.left);
            }
            if (current.right != null) {
                stack1.push(current.right);
            }
        }
        while(!stack2.isEmpty()){
            System.out.print( stack2.pop().data + " ");
        }

    }






    static void main() {
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

        postOrder obj = new postOrder();
        System.out.println("Preorder Traversal (Pura Tree):");
        obj.postOrderIterative(root);
    }
}

