package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftViewOfTree {
    public List<Integer> leftView(Node root) {
        List<Integer> result = new ArrayList<>();//ek list banao jisme result store ho
        //agar tree empty hai to empty list return karo
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();

                if (i == 0) {
                    result.add(current.data);

                }
                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }

        return result;
    }
        public static void main (String[] args) {

            // Example Tree
            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.left = new Node(4);
            root.left.right = new Node(5);
            root.right.right = new Node(6);

            LeftViewOfTree obj = new LeftViewOfTree();
            List<Integer> leftViewList = obj.leftView(root);

            System.out.println("Left View: " + leftViewList);
            // Output: [1, 2, 4]

    }


}




//import java.util.*;
//
//class TreeNode {
//    int val;
//    TreeNode left, right;
//
//    TreeNode(int val) {
//        this.val = val;
//    }
//}
//
//public class LeftViewBinaryTree {
//
//    public List<Integer> leftView(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//
//        // Edge case: Agar tree khali hai toh empty list return kar do
//        if (root == null) {
//            return result;
//        }
//
//        // Queue banate hain level order traversal ke liye
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);                    // Root node ko queue mein daal do
//
//        // Jab tak queue khali nahi ho jati
//        while (!queue.isEmpty()) {
//
//            int levelSize = queue.size();     // Current level mein kitne nodes hain
//
//            // Har level ka pehla node hi left view ka node hoga
//            // Isliye sirf pehle node ko result mein add karenge
//            TreeNode firstNode = queue.peek();   // Queue ka front element (leftmost node)
//            result.add(firstNode.val);
//
//            // Ab is level ke saare nodes ko process karte hain
//            for (int i = 0; i < levelSize; i++) {
//
//                TreeNode current = queue.poll();   // Queue se node nikaalte hain
//
//                // Left child agar hai toh queue mein daal do
//                if (current.left != null) {
//                    queue.offer(current.left);
//                }
//
//                // Right child agar hai toh queue mein daal do
//                if (current.right != null) {
//                    queue.offer(current.right);
//                }
//            }
//        }
//
//        return result;
//    }
//}

