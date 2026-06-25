package Trees;
import java.util.*;
import java.util.ArrayList;



class Pair {
    Node node;
    int hd;

    Pair(Node node, int hd) {
        this.node = node;
        this.hd = hd;
    }
}
public class BottomView {
    public static ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            Node node = curr.node;
            int hd = curr.hd;

            // Last wala update hi bottom-most node hoga
            map.put(hd, node.data);

            if (node.left != null) {
                q.add(new Pair(node.left, hd - 1));
            }
            if (node.right != null) {
                q.add(new Pair(node.right, hd + 1));
            }
        }

        for (int val : map.values()) {
            result.add(val);
        }

        return result;
    }

    public static void main(String[] args) {
        // Tree banate hain
        /*
                  1
               /     \
              2       3
             / \     / \
            4   5   6   7
               / \
              8   9
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.left.right.left = new Node(8);
        root.left.right.right = new Node(9);

        // Bottom View nikaalte hain
        ArrayList<Integer> bottom = bottomView(root);

        System.out.println("Bottom View of Binary Tree:");
        for (int val : bottom) {
            System.out.print(val + " ");
        }
    }
}

