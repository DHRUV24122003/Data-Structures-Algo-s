package Trees;
import java.util.*;

public class FindAllSubtrees {

    // Node class




        // Main function
        public List<Node> printAllDups(Node root) {
            Map<String, Integer> map = new HashMap<>();
            List<Node> result = new ArrayList<>();

            serialize(root, map, result);
            return result;
        }

        // Helper function - serialize karta hai + frequency track karta hai
        private String serialize(Node root, Map<String, Integer> map, List<Node> result) {
            // Base case
            if (root == null) {
                return "N";
            }

            // Left aur Right ko serialize karo
            String left = serialize(root.left, map, result);
            String right = serialize(root.right, map, result);

            // Current subtree ka unique string banao
            String curr = "(" + left + ")" + root.data + "(" + right + ")";

            // Frequency update karo
            map.put(curr, map.getOrDefault(curr, 0) + 1);

            // Agar yeh subtree pehli baar 2 baar aaya hai → answer mein daal do
            if (map.get(curr) == 2) {
                result.add(root);
            }

            return curr;
        }


    // Main class for testing

        public static void main(String[] args) {

        /*
                  1
                /   \
               2     3
              /     / \
             4     2   4
                  /
                 4
        */

            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.right.left = new Node(2);
            root.right.right = new Node(4);
            root.right.left.left = new Node(4);

            FindAllSubtrees sol = new FindAllSubtrees();
            List<Node> duplicates = sol.printAllDups(root);

            System.out.println("Duplicate Subtrees (Pre-order):");
            for (Node node : duplicates) {
                printPreOrder(node);
                System.out.println();
            }
        }

        // Helper to print pre-order
        static void printPreOrder(Node root) {
            if (root == null) return;
            System.out.print(root.data + " ");
            printPreOrder(root.left);
            printPreOrder(root.right);
        }
    }

