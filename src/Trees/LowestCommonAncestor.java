package Trees;

public class LowestCommonAncestor {
    Node lca(Node root, int n1, int n2) {
        // Base Case
        if (root == null) {
            return null;
        }

        // If current node is n1 or n2
        if (root.data == n1 || root.data == n2) {
            return root;
        }

        // Recurse on left and right
        Node leftLCA = lca(root.left, n1, n2);
        Node rightLCA = lca(root.right, n1, n2);

        // If both left and right return non-null → current node is LCA
        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        // Otherwise return the non-null one
        return (leftLCA != null) ? leftLCA : rightLCA;
    }


// Main class to test

    public static void main(String[] args) {

        /*
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7
                   \
                    8
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);

        LowestCommonAncestor sol = new LowestCommonAncestor();

        // Test Cases
        System.out.println("LCA of 4 and 5  : " + sol.lca(root, 4, 5).data);   // 2
        System.out.println("LCA of 4 and 6  : " + sol.lca(root, 4, 6).data);   // 1
        System.out.println("LCA of 3 and 4  : " + sol.lca(root, 3, 4).data);   // 1
        System.out.println("LCA of 2 and 4  : " + sol.lca(root, 2, 4).data);   // 2
        System.out.println("LCA of 6 and 8  : " + sol.lca(root, 6, 8).data);   // 6
        System.out.println("LCA of 7 and 8  : " + sol.lca(root, 7, 8).data);   // 3
        System.out.println("LCA of 5 and 8  : " + sol.lca(root, 5, 8).data);   // 1
    }
}

