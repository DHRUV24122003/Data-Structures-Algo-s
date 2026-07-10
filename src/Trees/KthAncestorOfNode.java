package Trees;

public class KthAncestorOfNode {
    // Node class




        // Main function
        public int kthAncestor(Node root, int k, int node) {
            int[] ans = {-1};           // result store karne ke liye
            int[] kArr = {k};           // k ko mutable banane ke liye

            findKthAncestor(root, node, kArr, ans);
            return ans[0];
        }

        // Helper recursive function
        private boolean findKthAncestor(Node root, int node, int[] k, int[] ans) {
            // Base case
            if (root == null) {
                return false;
            }

            // Target node mil gaya
            if (root.data == node) {
                return true;
            }

            // Left ya Right mein target dhoondo
            boolean left = findKthAncestor(root.left, node, k, ans);
            boolean right = findKthAncestor(root.right, node, k, ans);

            // Agar target left ya right mein mila
            if (left || right) {
                k[0]--;                 // ek level upar aaye

                // Agar abhi k == 0 ho gaya → yehi Kth ancestor hai
                if (k[0] == 0) {
                    ans[0] = root.data;
                }

                return true;            // upar wale ko batado ki target mil gaya
            }

            return false;
        }


    // Main class for testing

        public static void main(String[] args) {

        /*
                  1
                /   \
               2     3
              / \
             4   5
        */

            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);

            KthAncestorOfNode sol = new KthAncestorOfNode();

            System.out.println("2nd ancestor of 5 : " + sol.kthAncestor(root, 2, 5)); // 1
            System.out.println("1st ancestor of 5 : " + sol.kthAncestor(root, 1, 5)); // 2
            System.out.println("3rd ancestor of 5 : " + sol.kthAncestor(root, 3, 5)); // -1
            System.out.println("2nd ancestor of 4 : " + sol.kthAncestor(root, 2, 4)); // 1
            System.out.println("1st ancestor of 2 : " + sol.kthAncestor(root, 1, 2)); // 1
            System.out.println("1st ancestor of 1 : " + sol.kthAncestor(root, 1, 1)); // -1
        }
    }


