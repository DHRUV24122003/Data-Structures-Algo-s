package Binary_Search_Tree;

public class PredecessorSuccessorBST {



        // Ye do variables globally declare kiye hain taaki hum inme result store kar sake
        static Node predecessor = null;
        static Node successor = null;

        // Ye method sirf starting point hai, asli kaam ye function karega
        public static void findPreSuc(Node root, int key) {
            predecessor = null;           // pehle dono ko null kar dete hain
            successor = null;
            findPreSucUtil(root, key);    // asli logic yahan se shuru hota hai
        }

        // ==================== YE FUNCTION LINE BY LINE EXPLAINED HAI ====================
        private static void findPreSucUtil(Node root, int key) {

            // Agar current node null hai toh kuch nahi karna, function se bahar aa jao
            if (root == null) return;

            // ===================== CASE 1: Jab hume key wala node mil jaaye =====================
            if (root.data == key) {

                // === Predecessor nikalne ka logic ===
                // Agar key wale node ka left child exist karta hai
                if (root.left != null) {
                    // left subtree ke rightmost node ko dhundho
                    Node temp = root.left;                    // left child se shuru karo
                    while (temp.right != null) {              // jab tak right child hai, right jaate raho
                        temp = temp.right;                    // rightmost node tak pahunchne ke liye
                    }
                    predecessor = temp;                       // rightmost node hi predecessor hai
                }

                // === Successor nikalne ka logic ===
                // Agar key wale node ka right child exist karta hai
                if (root.right != null) {
                    // right subtree ke leftmost node ko dhundho
                    Node temp = root.right;                   // right child se shuru karo
                    while (temp.left != null) {               // jab tak left child hai, left jaate raho
                        temp = temp.left;                     // leftmost node tak pahunchne ke liye
                    }
                    successor = temp;                         // leftmost node hi successor hai
                }
                return;  // key mil gayi, ab aur search karne ki zarurat nahi
            }

            // ===================== CASE 2: Jab key, current root se CHHOTI hai =====================
            if (key < root.data) {
                // Jab hum left side ja rahe hain, toh current root potential successor ban sakta hai
                // kyunki ye key se bada hai aur abhi tak ka sabse chhota bada number ho sakta hai
                successor = root;
                findPreSucUtil(root.left, key);     // ab left subtree mein search karo
            }

            // ===================== CASE 3: Jab key, current root se BADI hai =====================
            else {
                // Jab hum right side ja rahe hain, toh current root potential predecessor ban sakta hai
                // kyunki ye key se chhota hai aur abhi tak ka sabse bada chhota number ho sakta hai
                predecessor = root;
                findPreSucUtil(root.right, key);    // ab right subtree mein search karo
            }
        }

        // ==================== MAIN METHOD ====================
        public static void main(String[] args) {

            Node root = new Node(8);
            root.left = new Node(3);
            root.right = new Node(10);
            root.left.left = new Node(1);
            root.left.right = new Node(6);
            root.right.right = new Node(14);
            root.left.right.left = new Node(4);
            root.left.right.right = new Node(7);
            root.right.right.left = new Node(13);

            int key = 6;

            findPreSuc(root, key);

            System.out.println("Key = " + key);
            System.out.println("Predecessor: " + (predecessor != null ? predecessor.data : "NULL"));
            System.out.println("Successor:   " + (successor != null ? successor.data : "NULL"));
        }
    }

