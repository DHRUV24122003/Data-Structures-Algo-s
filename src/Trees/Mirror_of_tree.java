package Trees;



//approach would be , that first we have to make the inorder traversal of the tree and then print it's reverse
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode(int val) {
//        this.val = val;
//    }
//}

public class Mirror_of_tree {

    public Node createMirror(Node root) {

        // Base Case: Agar node null hai toh null return karo
        if (root == null) {
            return null;
        }

        // Naya node banao with same value
        Node newNode = new Node(root.data);

        // Original tree ke LEFT subtree ka mirror banao
        // aur usko NEW node ke RIGHT child mein daal do
        newNode.right = createMirror(root.left);

        // Original tree ke RIGHT subtree ka mirror banao
        // aur usko NEW node ke LEFT child mein daal do
        newNode.left = createMirror(root.right);

        // Naya mirrored node return karo
        return newNode;
    }

    // ================== Helper: Print Tree (Inorder) ==================
    public void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    // ================== Testing ==================
    public static void main(String[] args) {

        // Original Tree bana rahe hain
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        Mirror_of_tree obj = new Mirror_of_tree();

        System.out.print("Original Inorder: ");
        obj.inorder(root);                    // Output: 4 2 5 1 3

        // Mirror tree create karo
        Node mirrorRoot = obj.createMirror(root);

        System.out.print("\nMirror Inorder:   ");
        obj.inorder(mirrorRoot);              // Output: 3 1 5 2 4
    }
}
