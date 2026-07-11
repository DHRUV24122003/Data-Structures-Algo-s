package Binary_Search_Tree;

class TreeNode {
    int data;
    TreeNode left, right, next;

    TreeNode(int data) {
        this.data = data;
        this.left = this.right = this.next = null;
    }
}
public class PopulateInorderSuccessor {

    TreeNode prev = null;

    public void PopulateNext(TreeNode root) {
        populateNextUtil(root);
    }

    private void populateNextUtil(TreeNode node) {
        if (node == null) {
            return;
        }

        // Left subtree
        populateNextUtil(node.left);

        // Set next pointer
        if (prev != null) {
            prev.next = node;
        }
        prev = node;

        // Right subtree
        populateNextUtil(node.right);
    }

    public static void main(String[] args) {

        // Tree banao (TreeNode use karo)
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(20);

        // Object banao aur call karo
        PopulateInorderSuccessor sol = new PopulateInorderSuccessor();
        sol.PopulateNext(root);                    // Note: Capital P

        // Print next pointers
        System.out.println("Node -> Next");
        printNextPointers(root);
    }

    // Helper function (TreeNode use karo)
    public static void printNextPointers(TreeNode root) {
        if (root == null) return;

        if (root.left != null) printNextPointers(root.left);

        String nextVal = (root.next != null) ? String.valueOf(root.next.data) : "NULL";
        System.out.println(root.data + " -> " + nextVal);

        if (root.right != null) printNextPointers(root.right);
    }
}