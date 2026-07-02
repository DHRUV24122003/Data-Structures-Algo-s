package Trees;

import java.util.ArrayList;
import java.util.List;

public class boundaryTraversal {
    //helper function : check if node is leaf
    boolean isLeaf(Node node){
        return (node.left == null && node.right ==null);
    }

    //traverse the left boundary
    void addLeftBoundary(Node node, ArrayList<Integer> res){
        if(node ==null)
            return;


    //if leaf node is not there than add it
        if(!isLeaf(node)){
            res.add(node.data);
        }

        //prefer left child
        if(node.left != null) {
            addLeftBoundary(node.left, res);
        }else if(node.right != null){
            addLeftBoundary(node.right, res);
        }

    }
    //part 2 - all leaf nodes
    void addLeaves (Node node, ArrayList<Integer> res){
        if(node ==null)
            return;

    if(isLeaf(node)){
        res.add(node.data);
        return;
    }

    addLeaves (node.left, res);
    addLeaves (node.right, res);

    }

    void addRightBoundary(Node node, ArrayList<Integer> res){
        if(node ==null)
            return;
        if(isLeaf(node)){
           if(node.right !=null){
               addRightBoundary(node.right, res);
           }
            else if(node.left != null){
                addRightBoundary(node.left, res);

           }
        }
        res.add(node.data);
    }
    public ArrayList<Integer> boundary(Node root) {
        ArrayList<Integer> res = new ArrayList<>();

        if (root == null) return res;

        // Root ko sirf ek baar add karo (agar leaf nahi hai)
        if (!isLeaf(root)) {
            res.add(root.data);
        }

        // Step 1: Left Boundary (root.left se shuru karo)
        addLeftBoundary(root.left, res);

        // Step 2: Saare Leaf Nodes
        addLeaves(root, res);

        // Step 3: Right Boundary (root.right se shuru karo)
        addRightBoundary(root.right, res);

        return res;
    }


public static void main(String[] args) {
    boundaryTraversal  sol = new boundaryTraversal ();

    // Creating the tree
        /*
                1
               / \
              2   3
             / \   \
            4   5   6
               / \
              7   8
        *///

    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);

    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.right = new Node(6);

    root.left.right.left = new Node(7);
    root.left.right.right = new Node(8);

    // Call boundary traversal
    List<Integer> result = sol.boundary(root);

    // Print result
    System.out.println("Boundary Traversal: " + result);
}
}

