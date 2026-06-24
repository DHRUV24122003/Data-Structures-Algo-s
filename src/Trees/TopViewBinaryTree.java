package Trees;

import java.util.*;

public class TopViewBinaryTree {
    public List<Integer> topView(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // Map to store first node at each horizontal distance
        Map<Integer, Integer> topNodes = new TreeMap<>();

        // Queue for Level Order Traversal
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));   // (node, horizontal distance)

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            Node node = current.node;
            int hd = current.hd;

            // Agar yeh horizontal distance pehli baar aa raha hai
            if (!topNodes.containsKey(hd)) {
                topNodes.put(hd, node.data);
            }

            // Left child
            if (node.left != null) {
                queue.offer(new Pair(node.left, hd - 1));
            }

            // Right child
            if (node.right != null) {
                queue.offer(new Pair(node.right, hd + 1));
            }
        }

        // TreeMap already sorted hai keys ke hisaab se
        for (int val : topNodes.values()) {
            result.add(val);
        }

        return result;
    }

    // Helper class to store node + horizontal distance
    static class Pair {
        Node node;
        int hd;
        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void main(String[] args) {

        // Example Tree
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        TopViewBinaryTree obj = new TopViewBinaryTree();
        List<Integer> topViewList = obj.topView(root);

        System.out.println("Top View: " + topViewList);
        // Output: [4, 2, 1, 3, 7]
    }
}


