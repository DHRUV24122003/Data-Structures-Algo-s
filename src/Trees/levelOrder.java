package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class levelOrder {
    static void main() {
        Node root = new Node(10);
        root.left = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right = new Node(15);
        root.right.right = new Node(20);
        System.out.println(LevelOrder(root));

    }

    public static List<List<Integer>> LevelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }


        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                currentLevel.add(currentNode.data);

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            result.add(currentLevel);
        }
        return result;
    }
}








//    class Solution {
//        public static ArrayList<Integer> levelOrder(Node root) {
//            ArrayList<Integer> result = new ArrayList<>();
//
//            if (root == null) {
//                return result;
//            }
//
//            Queue<Node> queue = new LinkedList<>();
//            queue.offer(root);
//
//            while (!queue.isEmpty()) {
//                Node currentNode = queue.poll();
//                result.add(currentNode.data);
//
//                if (currentNode.left != null) {
//                    queue.offer(currentNode.left);
//                }
//                if (currentNode.right != null) {
//                    queue.offer(currentNode.right);
//                }
//            }
//
//            return result;
//        }
//    }
