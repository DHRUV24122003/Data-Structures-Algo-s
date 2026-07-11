package Binary_Search_Tree;

import java.util.Scanner;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class KEY_In_Tree {
    static boolean searchKey(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key)
            return true;

        if (key > root.data)
            return searchKey(root.right, key);

        return searchKey(root.left, key);

    }


    static void main() {

        Node root = new Node(6);
        root.left = new Node(2);
        root.right = new Node(8);
        root.right.left = new Node(7);
        root.right.right = new Node(9);

        //int key = 2;

        Scanner sc = new Scanner(System.in);
        System.out.print("enter the key of the tree: " );
        int key = sc.nextInt();
        //System.out.println("entered key is " + key);
        // Searching for key in the BST

        if (searchKey(root, key)) {
            System.out.println(searchKey(root, key) + " --> " + key + " is present in the Tree");
        }
        else {
            System.out.println("key is not present in the Tree");
        }
    }
}

