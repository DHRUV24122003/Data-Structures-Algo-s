package Trees;

public class TreeIsomorphism {
    // Node class




        // Main function
        boolean isIsomorphic(Node root1, Node root2) {

            // Case 1: Dono null hain
            if (root1 == null && root2 == null) {
                return true;
            }

            // Case 2: Ek null hai, doosra nahi
            if (root1 == null || root2 == null) {
                return false;
            }

            // Case 3: Data different hai
            if (root1.data != root2.data) {
                return false;
            }

            // Case 4: Do possibilities check karo

            // Possibility 1: Bina flip ke
            boolean noFlip = isIsomorphic(root1.left, root2.left) &&
                    isIsomorphic(root1.right, root2.right);

            // Possibility 2: Flip karke
            boolean withFlip = isIsomorphic(root1.left, root2.right) &&
                    isIsomorphic(root1.right, root2.left);

            return noFlip || withFlip;
        }


    // Main class for testing

        public static void main(String[] args) {

            // Tree 1
            Node root1 = new Node(1);
            root1.left = new Node(2);
            root1.right = new Node(3);
            root1.left.left = new Node(4);
            root1.left.right = new Node(5);
            root1.right.left = new Node(6);
            root1.left.right.left = new Node(7);
            root1.left.right.right = new Node(8);

            // Tree 2 (Isomorphic version)
            Node root2 = new Node(1);
            root2.left = new Node(3);
            root2.right = new Node(2);
            root2.right.left = new Node(4);
            root2.right.right = new Node(5);
            root2.left.right = new Node(6);
            root2.right.right.left = new Node(8);
            root2.right.right.right = new Node(7);

            TreeIsomorphism sol = new TreeIsomorphism();

            System.out.println("Are trees isomorphic? " + sol.isIsomorphic(root1, root2)); // true

            // Extra test
            Node root3 = new Node(1);
            root3.left = new Node(2);
            root3.right = new Node(3);

            Node root4 = new Node(1);
            root4.left = new Node(3);
            root4.right = new Node(2);

            System.out.println("Are trees isomorphic? " + sol.isIsomorphic(root3, root4)); // true

            Node root5 = new Node(1);
            root5.left = new Node(2);

            Node root6 = new Node(1);
            root6.right = new Node(3);

            System.out.println("Are trees isomorphic? " + sol.isIsomorphic(root5, root6)); // false
        }
    }


