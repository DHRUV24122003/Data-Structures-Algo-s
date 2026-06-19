package Trees;

public class PreorderTraversal {
    public static void printPreorder(Node root){
        if(root == null){
            return; //agar node nahi hai to wapas jao
        }
        System.out.println(root.data + " ");//pahle root print karo
        printPreorder(root.left);//fir left subtree
        printPreorder(root.right);//fir right subtree
    }
    static void main() {
        Node root = new Node(10);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right = new Node(15);
        root.right.right = new Node(20);

        System.out.println("Preorder Traversal (Pura Tree):");
        printPreorder(root);
    }
}



