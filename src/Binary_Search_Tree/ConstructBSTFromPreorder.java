package Binary_Search_Tree;





public class ConstructBSTFromPreorder {

    int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return construct(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode construct(int[] preorder, int min, int max) {
        if (index >= preorder.length || preorder[index] < min || preorder[index] > max) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[index]);
        index++;

        root.left = construct(preorder, min, root.data);
        root.right = construct(preorder, root.data, max);

        return root;
    }

    // ==================== TREE PRINT KARNE KE LIYE ====================

    // Inorder Print (BST mein sorted hona chahiye)
    public void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    // Level Order Print (Tree structure dekhne ke liye)
    public void printLevelOrder(TreeNode root) {
        if (root == null) return;

        java.util.Queue<TreeNode> queue = new java.util.LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.data + " ");
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }

    // ==================== MAIN METHOD ====================
    public static void main(String[] args) {
        ConstructBSTFromPreorder obj = new ConstructBSTFromPreorder();

        int[] preorder = {8, 5, 1, 7, 10, 12};

        TreeNode root = obj.bstFromPreorder(preorder);

        System.out.println("Inorder Traversal (Sorted hona chahiye):");
        obj.printInorder(root);
        System.out.println();

        System.out.println("\nLevel Order Traversal (Tree Structure):");
        obj.printLevelOrder(root);
    }
}