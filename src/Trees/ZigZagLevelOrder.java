package Trees;

import java.util.*;
import java.util.Arrays;
import java.util.List;

public class ZigZagLevelOrder {
    public List<Integer> zigzagLevelOrder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
 
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;   // Level 1 is odd → Left to Right

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                currentLevel.add(node.data);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            // Reverse for even levels (Right to Left)
            if (!leftToRight) {
                Collections.reverse(currentLevel);
            }

            result.addAll(currentLevel);
            leftToRight = !leftToRight;
        }

        return result;
    }

    public static Node buildTreeFromLevelOrder(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) return null;

        Node root = new Node(arr[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int index = 1;

        while (!queue.isEmpty() && index < arr.length) {
            Node current = queue.poll();

            if (index < arr.length && arr[index] != null) {
                current.left = new Node(arr[index]);
                queue.offer(current.left);
            }
            index++;

            if (index < arr.length && arr[index] != null) {
                current.right = new Node(arr[index]);
                queue.offer(current.right);
            }
            index++;
        }
        return root;
    }


// ==================== Main method for testing ====================
public static void main(String[] args) {
    Integer[] input = {1, 2, 3, 4, 5, 6, 7};
    Node root = buildTreeFromLevelOrder(input);

    ZigZagLevelOrder solution = new ZigZagLevelOrder();
    List<Integer> output = solution.zigzagLevelOrder(root);

    System.out.println("Input:  " + Arrays.toString(input));
    System.out.println("Output: " + output);

}
    // Expected: [1, 3, 2, 4, 5, 6, 7]



}
