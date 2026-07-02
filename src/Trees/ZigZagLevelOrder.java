package Trees;

import java.util.*;

public class ZigZagLevelOrder {

    // ==================== Main ZigZag Function ====================
    public List<List<Integer>> zigzagLevelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int level = 1;                    // Level 1 is odd → Left to Right

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                currentLevel.add(node.data);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            // Reverse only for even levels (Right to Left)
            if (level % 2 == 0) {
                Collections.reverse(currentLevel);
            }

            result.add(currentLevel);
            level++;
        }

        return result;
    }

    // ==================== Helper: Build Tree from Level Order ====================
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

    // ==================== Main Method for Testing ====================
    public static void main(String[] args) {
        ZigZagLevelOrder solution = new ZigZagLevelOrder();

        // Test Case 1
        Integer[] input1 = {1, 2, 3, 4, 5, 6, 7};
        Node root1 = buildTreeFromLevelOrder(input1);
        List<List<Integer>> output1 = solution.zigzagLevelOrder(root1);

        System.out.println("=== Test Case 1 ===");
        System.out.println("Input Tree (Level Order): " + Arrays.toString(input1));
        System.out.println("Zigzag Output: " + output1);
        System.out.println("Expected:        [[1], [3, 2], [4, 5, 6, 7]]");
        System.out.println();

        // Test Case 2 (Classic Example)
        Integer[] input2 = {3, 9, 20, null, null, 15, 7};
        Node root2 = buildTreeFromLevelOrder(input2);
        List<List<Integer>> output2 = solution.zigzagLevelOrder(root2);

        System.out.println("=== Test Case 2 ===");
        System.out.println("Input Tree (Level Order): " + Arrays.toString(input2));
        System.out.println("Zigzag Output: " + output2);
        System.out.println("Expected:        [[3], [20, 9], [15, 7]]");
    }
}
    // Expected: [1, 3, 2, 4, 5, 6, 7]



//summary of the question
//make a list type function
//make a list which store the result - result
//Make a queue and add the root to it
//if queue is not empty the initialize level size with the queue.size() and make a new list -> currentlevel
//if node.left is not equal to null add node.left in queue , and
//if node.right is not equal to null add node.right to the queue
//and if level is even(if (level % 2 == 0) then reverse the currentlevel list - Collections.reverse(currentLevel);
//add the result in list currentlevel and increase the level count by 1
//make a binary tree assign it's values




//Approach

//Do normal level order traversal using a Queue (always visits left to right).
//Collect nodes of current level in a list.
//If the level is even → reverse the list before adding to result.
//Children are always enqueued left → right.
