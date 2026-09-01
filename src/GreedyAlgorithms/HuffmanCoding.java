package GreedyAlgorithms;
import java.util.*;
public class HuffmanCoding {

    // Node class for Huffman Tree
    static class Node {
        char ch;           // character ( for leaf nodes )
        int freq;          // frequency
        Node left, right;
        String earliestChar; //the first one char to come in the subtree

        Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
            this.earliestChar = String.valueOf(ch);
        }

        Node(int freq, Node left, Node right, String earliestChar) {
            this.ch = '-'; // internal node
            this.freq = freq;
            this.left = left;
            this.right = right;
            this.earliestChar = earliestChar;
        }
    }

    public ArrayList<String> huffmanCodes(String s, int[] f, int N) {

        // Priority Queue (Min Heap) with custom comparator
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if (a.freq != b.freq) {
                return a.freq - b.freq;               // smaller frequency first
            }
            // frequency same → jis node ka earliestChar pehle aata hai string mein
            return a.earliestChar.compareTo(b.earliestChar);
        });

        // Step 1: Saare characters ko leaf nodes bana ke pq mein daalo
        for (int i = 0; i < N; i++) {
            pq.add(new Node(s.charAt(i), f[i]));
        }

        // Step 2: Huffman Tree banao
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();

            // Special rule already comparator se handle ho gaya
            // Ab naya parent node banao
            String earliest = left.earliestChar.compareTo(right.earliestChar) < 0
                    ? left.earliestChar
                    : right.earliestChar;

            Node parent = new Node(left.freq + right.freq, left, right, earliest);
            pq.add(parent);
        }

        // Step 3: Root found
        Node root = pq.poll();

        // Step 4: Preorder traversal  -> codes
        ArrayList<String> result = new ArrayList<>();
        preorder(root, "", result);

        return result;
    }

    // Preorder traversal to generate codes
    private void preorder(Node node, String code, ArrayList<String> result) {
        if (node == null) return;

        // Leaf node → character mil gaya
        if (node.left == null && node.right == null) {
            result.add(code);
            return;
        }

        // Left → 0, Right → 1
        preorder(node.left, code + "0", result);
        preorder(node.right, code + "1", result);
    }


    public static void main(String[] args) {

        HuffmanCoding sol = new HuffmanCoding();

        String s = "abcdef";
        int[] f = {5, 9, 12, 13, 16, 45};
        int N = 6;

        ArrayList<String> codes = sol.huffmanCodes(s, f, N);

        System.out.println("Huffman Codes in Preorder:");
        for (String code : codes) {
            System.out.println(code);
        }
    }
}






