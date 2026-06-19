package Trees;

public class start_tree {

        Node root;

        // YE METHOD TREE KO SEEDHA AUR SUNDAR PRINT KAREGA
        void printTree(Node node, int space) {
            if (node == null){
                return;
            }

            // Har level pe 5 spaces badhao (jitna chahe badha sakta hai)
            space += 5;

            // Pehle RIGHT subtree print karo
            printTree(node.right, space);

            // Spaces print karo
            for (int i = 5; i < space; i++)
                System.out.print(" ");

            // Node ka data print karo
            System.out.println(node.data);

            // Ab LEFT subtree print karo
            printTree(node.left, space);
        }

        public static void main(String[] args) {
            start_tree tree = new start_tree();

            // Tree banana
            tree.root = new Node(1);
            tree.root.left = new Node(2);
            tree.root.right = new Node(3);
            tree.root.left.left = new Node(4);
            tree.root.left.right = new Node(5);
            tree.root.right.left = new Node(6);
            tree.root.right.right = new Node(7);

            System.out.println("=== Binary Tree (Seedha Structure) ===\n");
            tree.printTree(tree.root, 0);
        }
    }

