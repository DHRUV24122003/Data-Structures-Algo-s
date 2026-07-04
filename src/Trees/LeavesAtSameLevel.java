package Trees;

public class LeavesAtSameLevel {

    //static variable to store level of first leaf
    static int leafLevel = -1;

    static boolean checkLeaves(Node root, int level){
        if(root == null) return true;
        if(root.left == null && root.right == null){
            if(leafLevel ==-1){
                leafLevel = level;
                return true;
            }

            return (level ==leafLevel);


        }
        return checkLeaves(root.left, level+1)&&
                checkLeaves(root.right, level+1);
    }
    static boolean areLeavesAtSameLevel(Node root){
        leafLevel = -1;
        return checkLeaves(root, 0);
    }
    public static void main(String[] args) {
        // Example 1 (True)
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);
        root1.left.left = new Node(4);
        root1.left.right = new Node(5);

        System.out.println("Example 1: " + areLeavesAtSameLevel(root1));  // true

        // Example 2 (False)
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.right.right = new Node(5);
        //root2.left.left.left = new Node(6);

        System.out.println("Example 2: " + areLeavesAtSameLevel(root2));  // false
    }


}
