package Trees;

public class SimpleTree {
    public static void main(String[] args) {

        // Root node banao
        Node root = new Node(10);

        // Left subtree
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(7);

        // Right subtree
        root.right = new Node(15);
        root.right.right = new Node(20);

        // Print kar ke check karo
        //so here we are able to print the values of the node
        System.out.println("Tree ban gaya successfully!");
        System.out.println("Root ki value: " + root.data);
        System.out.println("Root ke left child ki value: " + root.left.data);
        System.out.println("Root ke left child ki value: " + root.left.left.data);
    }
}