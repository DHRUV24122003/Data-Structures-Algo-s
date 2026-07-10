package Trees;

public class DistBtw_two_GivenNodes {
    // Node class


        // Function to find minimum distance between two nodes
        int findDist(Node root, int a, int b) {

            // Step 1: Find LCA of a and b
            Node lca = findLCA(root, a, b);

            // Step 2: Find distance from LCA to a and LCA to b
            int distA = findDistance(lca, a);
            int distB = findDistance(lca, b);

            // Total distance
            return distA + distB;
        }

        // Helper function to find LCA
        Node findLCA(Node root, int a, int b) {
            if (root == null) {
                return null;
            }

            if (root.data == a || root.data == b) {
                return root;
            }

            Node left = findLCA(root.left, a, b);
            Node right = findLCA(root.right, a, b);

            if (left != null && right != null) {
                return root;
            }

            return (left != null) ? left : right;
        }

        // Helper function to find distance from a node to target
        int findDistance(Node root, int target) {
            if (root == null) {
                return -1;
            }

            if (root.data == target) {
                return 0;
            }

            int leftDist = findDistance(root.left, target);
            if (leftDist >= 0) {
                return leftDist + 1;
            }

            int rightDist = findDistance(root.right, target);
            if (rightDist >= 0) {
                return rightDist + 1;
            }

            return -1;
        }


    // Main class for testing

        public static void main(String[] args) {

        /*
                  1
                /   \
               2     3
              / \   / \
             4   5 6   7
        */

            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);
            root.right.left = new Node(6);
            root.right.right = new Node(7);

            DistBtw_two_GivenNodes sol = new DistBtw_two_GivenNodes();

            System.out.println("Distance between 4 and 5 : " + sol.findDist(root, 4, 5)); // 2
            System.out.println("Distance between 4 and 6 : " + sol.findDist(root, 4, 6)); // 4
            System.out.println("Distance between 3 and 4 : " + sol.findDist(root, 3, 4)); // 3
            System.out.println("Distance between 2 and 4 : " + sol.findDist(root, 2, 4)); // 1
            System.out.println("Distance between 5 and 7 : " + sol.findDist(root, 5, 7)); // 4
            System.out.println("Distance between 6 and 7 : " + sol.findDist(root, 6, 7)); // 2
        }
    }

