package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static Trees.InorderTraversal.printInorder;

public class ReverseLevelOrder {
    public List<Integer> reverseLevelOrder(Node root) {

        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // Normal level order traversal karke levels collect kar rahe hain

        List<List<Integer>> levels = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                currentLevel.add(node.data);

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            levels.add(currentLevel);
        }

        // Ab levels ko reverse order mein final result mein add kar rahe hain
        for (int i = levels.size() - 1; i >= 0; i--) {
            result.addAll(levels.get(i));
        }

        return result;
    }



    public static void main(String[] args) {

        // Sample Tree 1 (GFG Example)
        /*
                1
               / \
              3   2
        */
        Node root1 = new Node(1);
        root1.left = new Node(3);
        root1.right = new Node(2);

        ReverseLevelOrder sol = new ReverseLevelOrder();
        List<Integer> result1 = sol.reverseLevelOrder(root1);

        System.out.println("Reverse Level Order (Example 1): " + result1);
        // Expected Output: [3, 2, 1]


        // Sample Tree 2 (GFG Example)
        /*
                10
               /  \
             20    30
            /  \
          40    60
        */
        Node root2 = new Node(10);
        root2.left = new Node(20);
        root2.right = new Node(30);
        root2.left.left = new Node(40);
        root2.left.right = new Node(60);

        List<Integer> result2 = sol.reverseLevelOrder(root2);
        System.out.println("Reverse Level Order (Example 2): " + result2);
        // Expected Output: [40, 60, 20, 30, 10]
    }
}