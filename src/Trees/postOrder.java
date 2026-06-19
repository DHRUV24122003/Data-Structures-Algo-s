package Trees;

public class postOrder {
    public static void PrintpostOrder(Node root){
        if(root == null){
            return; //agar node nahi hai to wapas jao
        }

        PrintpostOrder(root.left);
        PrintpostOrder(root.right);
        System.out.print(root.data + " ");
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


        System.out.println("Preorder Traversal (Pura Tree):");
        PrintpostOrder(root);
    }
}

