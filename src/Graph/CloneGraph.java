package Graph;

import java.util.*;

public class CloneGraph {

    static class Node {
        public int val;
        public List<Node> neighbours;

        public Node() {
            val = 0;
            neighbours = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbours = new ArrayList<>();
        }

        public Node(int _val, List<Node> _neighbours) {
            val = _val;
            neighbours = _neighbours;
        }
    }

    // Sahi Map: Original Node → Cloned Node
    private Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        return dfs(node);
    }

    private Node dfs(Node node) {
        // Agar yeh node pehle se clone ho chuka hai
        if (map.containsKey(node)) {
            return map.get(node);
        }

        // Naya clone banao
        Node clone = new Node(node.val);

        // Map mein daal do (original → clone)
        map.put(node, clone);

        // Saare neighbours clone karke add karo
        for (Node neighbour : node.neighbours) {
            clone.neighbours.add(dfs(neighbour));
        }

        return clone;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbours.add(node2);
        node1.neighbours.add(node4);

        node2.neighbours.add(node1);
        node2.neighbours.add(node3);

        node3.neighbours.add(node2);
        node3.neighbours.add(node4);

        node4.neighbours.add(node1);
        node4.neighbours.add(node3);

        CloneGraph obj = new CloneGraph();
        Node cloned = obj.cloneGraph(node1);

        System.out.println("Graph cloned successfully!");
        System.out.println("Original node val: " + node1.val);
        System.out.println("Cloned node val: " + cloned.val);
    }
}