package Trees;

import java.util.*;



public class DuplicateSubtree {

    static Map<String, Integer> map = new HashMap<>();

    // Function jo subtree ko string mein convert karega
    static String serialize(Node root) {
        if (root == null) return "#";

        // Left + Current + Right subtree ko combine karo
        String left = serialize(root.left);
        String right = serialize(root.right);

        String current = left + " " + root.data + " " + right;

        // Map mein count badhao
        map.put(current, map.getOrDefault(current, 0) + 1);

        // Agar kisi subtree ka count 2 ya zyada ho gaya toh true return kar do
        if (map.get(current) == 2) {
            // Hum yahan bas flag set kar rahe hain (better way niche hai)
        }

        return current;
    }

    static boolean hasDuplicateSubtree(Node root) {
        map.clear();
        serialize(root);

        // Check karo ki kisi bhi string ka count >=2 hai ya nahi
        for (int count : map.values()) {
            if (count >= 2) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        // Example 1 (Duplicate hai)
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(2);
        root.right.left.left = new Node(4);
        root.right.right = new Node(4);

        System.out.println("Has Duplicate Subtree: " + hasDuplicateSubtree(root));  // true
    }
}