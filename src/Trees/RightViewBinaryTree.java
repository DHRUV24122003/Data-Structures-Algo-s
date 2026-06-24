package Trees;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightViewBinaryTree {
    public List<Integer> rightView(Node root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {

            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {

                Node current = queue.poll();

                // Agar yeh level ka last node hai, toh right view mein add karo
                if (i == levelSize - 1) {
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

     static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        RightViewBinaryTree obj = new RightViewBinaryTree();
        List<Integer> rightViewList = obj.rightView(root);

        System.out.println("Right View: " + rightViewList);
        // Output: [1, 3, 6]
    }
}

