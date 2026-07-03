package Trees;

public class TransformtoSumTree {

    public static int ConvertoSumTree(Node node) {
        if (node == null) {
            return 0;
        }
        int lefTree = ConvertoSumTree(node.left);
        int rightTree = ConvertoSumTree(node.right);

        int oldValue = node.data;
        node.data = lefTree + rightTree;
        return oldValue + lefTree + rightTree;

    }

    static void main() {
        TransformtoSumTree sol = new TransformtoSumTree();
        Node root = new Node(10);
        root.left = new Node(-2);
        root.right = new Node(6);
        root.left.left = new Node(8);
        root.left.right = new Node(-4);
        root.right.left = new Node(7);
        root.right.right = new Node(5);

        System.out.println("Original Tree (Inorder):");
        printInorder(root);

        // Convert to Sum Tree
        sol.ConvertoSumTree(root);

        System.out.println("\n\nAfter converting to Sum Tree (Inorder):");
        printInorder(root);
    }

    public static void printInorder(Node node) {
        if (node == null) return;

        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }
}




