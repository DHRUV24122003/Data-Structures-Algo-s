package Binary_Search_Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DeletAKey {
    public static Node deleteKey(Node root, int key) {
        if (root == null) {
            return null;
        }
        if(key < root.data){//agar ki root ki value key se kam hai
            root.left = deleteKey(root.left, key);//find it in left
        }
        else if(key > root.data){
            root.right = deleteKey(root.right, key);//or find it in right
        }
        else{
            if(root.left == null) {//if root.left is null just return root.right
                return root.right;
            }
            if(root.right == null){
                return root.left;//else root.left

            }
            // Case 3: 2 children → Inorder Successor use karo
            Node successor = findMin(root.right);
            root.data = successor.data; //swap the root.data with successor data
            //and call the function here
            root.right = deleteKey(root.right, successor.data);

            }
           return root;

        }
    //so now we have to find the successor of deleted node(right subtree ka leftmost)
    private static Node findMin(Node node){
        while(node.left!=null){
            node = node.left;
        }
        return node;

    }
    public static void printLevelOrder(Node root){
        if(root == null){
            System.out.println("Empty Tree");
            return;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node current = queue.poll();
            System.out.print(current.data + " ");
            if(current.left != null) queue.add(current.left);
            if(current.right != null) queue.add(current.right);
            }
       // System.out.println();
        }
    // ==================== MAIN FUNCTION ====================
    public static void main(String[] args) {

        // Example 1: root = [5,3,6,2,4,null,7], key = 3
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.right.right = new Node(7);
        //int key = 3;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the key you want to delete :  ");
        int key = sc.nextInt();

        System.out.print("Before Deletion: ");
                printLevelOrder(root) ;
                  // Output: 5 3 6 2 4 7


        root = deleteKey(root, key);

        System.out.print("\nAfter Deleting " + key + " ------> ");
        printLevelOrder(root);           // Output: 5 4 6 2 7
    }
}



