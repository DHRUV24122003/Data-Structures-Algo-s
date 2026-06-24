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
