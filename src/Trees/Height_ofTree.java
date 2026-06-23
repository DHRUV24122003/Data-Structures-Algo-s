package Trees;


public class Height_ofTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    public static int maxDepth(TreeNode root) {//make a function and pass the node
        if (root == null) {//base case agar root hi nahi hai to -1 return kardo
            return -1; // Empty tree has height -1
        }

        int leftHeight = maxDepth(root.left);//initialize height of left tree as maxdepth(root.left), means maximum death of left subtree
        int rightHeight = maxDepth(root.right);//initialize height of right tree by it's max depth

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        // Creating a sample binary tree
        /*
                1
               / \
              2   3
             / \
            4   5
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);

        // Calling the function
        int height = maxDepth(root);

        System.out.println("Maximum Depth (Number of Edges): " + height);
    }
}

