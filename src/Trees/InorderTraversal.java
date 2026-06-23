package Trees;

public class InorderTraversal {
        //the basic difference between preorder and inorder is
      //preorder prints root first then left and then right values
    //inorder prints left then root and then right

        // Inorder Traversal Method
        public static void printInorder(Node node) {

            if (node == null) {
                return;                    // Base Case
            }

            // Step 1: Left subtree
            printInorder(node.left);

            // Step 2: Root (Current Node)
            System.out.print(node.data + " ");

            // Step 3: Right subtree
            printInorder(node.right);
        }

        public static void main(String[] args) {

            // Tree banana
            Node root = new Node(10);
            root.left = new Node(5);
            root.left.left = new Node(3);
            root.left.right = new Node(7);
            root.right = new Node(15);
            root.right.right = new Node(20);

            System.out.println("Inorder Traversal:" );
            printInorder(root);
        }
    }

