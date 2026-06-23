package Trees;
//approach would be
//find max height of left subtree and max height of right subtree  and
//add both of them
public class diameter_OF_tree {
    private int maxDiameter = 0;
    public int diameterOfBinaryTree(Node root) {
        //helper function to calculate height + update diameter
        calculateHeight(root);
        return maxDiameter;
    }

    private int calculateHeight(Node node) {

        if (node == null) {
            return 0;
        }

        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);
        int diameterThroughCurrentNode = leftHeight + rightHeight;
        maxDiameter = Math.max(maxDiameter, diameterThroughCurrentNode);
        return 1 + Math.max(leftHeight, rightHeight);

    }
    public static void main(String[] args) {

        // Tree:
        //         1
        //        / \
        //       2   3
        //      / \
        //     4   5

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.right = new Node(9);


        diameter_OF_tree obj = new diameter_OF_tree();
        int diameter = obj.diameterOfBinaryTree(root);

        System.out.println("Diameter of the tree is: " + diameter);
        // Output: 3
    }
}






