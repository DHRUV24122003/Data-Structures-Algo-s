package Binary_Search_Tree;

import java.util.LinkedList;
import java.util.Queue;



public class Min_MaxInBST {
    public static int findMin( Node root){
        if(root==null){
            return -1;
        }
        Node current = root;
        while(current.left!=null){
            current = current.left;

        }
         return current.data;
    }
    public static int findMax(Node root){
        if(root==null){
            return -1;
        }
        Node current = root;
        while(current.right!=null){
            current = current.right;
        }
        return current.data;
    }
    // function to print level order traversal
    static void LevelOrderPrint(Node root) {
        if(root == null)
            return;

    Queue<Node> queue = new LinkedList<Node>();
    queue.add(root);
    while(!queue.isEmpty()){
    Node node = queue.poll();
    System.out.print(" " + node.data);
    if(node.left!=null) queue.add(node.left);
    if(node.right!=null) queue.add(node.right);

    }
        System.out.println();
    }
    public static void main(String[] args) {

        // Tree banao: [8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13]
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.right = new Node(7);

        System.out.print("Tree: ");
        LevelOrderPrint(root);

        int min = findMin(root);
        int max = findMax(root);

        System.out.println("Minimum value in BST: " + min);
        System.out.println("Maximum value in BST: " + max);
    }
}

