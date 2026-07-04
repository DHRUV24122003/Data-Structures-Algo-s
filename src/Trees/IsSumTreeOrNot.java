package Trees;



public class IsSumTreeOrNot {

    static int isSumTree(Node node) {
        if (node == null)
            return 0;

        if (node.left == null && node.right == null)
            return node.data;


        int leftSum = isSumTree(node.left);
        int rightSum = isSumTree(node.right);

        if (leftSum == -1 || rightSum == -1)
            return -1;


        if (node.data == leftSum + rightSum)
            return node.data + leftSum + rightSum;
        return -1;
    }
    static boolean isSumTreeOrNot(Node root) {
        return isSumTree(root) != -1;
    }
    public static void main(String[] args) {
        // Valid Sum Tree example
        Node root = new Node(26);
        root.left = new Node(10);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(6);
        root.right.right = new Node(3);

        System.out.println("Is Sum Tree : " + isSumTreeOrNot(root));  // true

        // Change root to make it invalid
        root.data = 10;
        System.out.println("Is Sum Tree : " + isSumTreeOrNot(root));  // false
    }
}









