package Binary_Search_Tree;


import java.util.*;
public class ConvertBTreeInBST {
    public Node convertToBst(Node root) {
        if (root == null) {
            return null;
        }
        List<Integer> values = new ArrayList<>();
        // Step 1: Saare node values store karne ke liye ArrayList banayi

        collectValues(root,values);
        //traverse all the values and put it into the list

        Collections.sort(values);
        //sort thi list and it is perfect for bst

        int [] index = new int[1];
        //make an index array

        assignInorder(root,values,index);
        //sorted values ko inorder positions me assign kardo

        return root;

    }
    private void collectValues(Node node, List<Integer> values) {

        if (node == null) {
            return;
        }
        collectValues(node.left,values);
        values.add(node.data);
        collectValues(node.right,values);
    }
    // Helper method: Sorted values ko tree mein inorder positions pe assign karna
    private void assignInorder(Node node, List<Integer> values, int[] index) {
        if (node == null) {
            return;               // Base case
        }

        assignInorder(node.left, values, index);
        // Pehle left child ko process karo

        node.data = values.get(index[0]);
        // Current node ko sorted list ka next value assign karo

        index[0]++;
        // Index ko aage badhao taaki next node ko next sorted value mile

        assignInorder(node.right, values, index);
        // Ab right child ko process karo
    }

    //Bonus: Inorder print karne ke liye (testing ke liye)
    public static void printInorder(Node node) {
        if (node == null) return;
        printInorder(node.left);
        System.out.print(node.data + " ");
        printInorder(node.right);
    }

    // Driver code (example ke liye)
    public static void main(String[] args) {
        // Example Tree (jo BST nahi hai)
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);

        System.out.print("Original Inorder (before): ");
        printInorder(root);
        System.out.println();           // Output: 3 1 2

        ConvertBTreeInBST sol = new ConvertBTreeInBST();
        Node bstRoot = sol.convertToBst(root);

        System.out.print("After Conversion Inorder (should be sorted): ");
        printInorder(bstRoot);
        System.out.println();           // Output: 1 2 3

        // Note: Structure same hai (root ka left aur right child same objects hain)
        // Sirf values change hui hain taaki BST ban jaye
    }
}


//approach - > traverse the bt in inorder
//sort the list
//assign the nodes to the tree in inorder

