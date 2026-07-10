package Trees;

import java.util.*;
import java.util.ArrayList;

public class All_K_Sum_Paths {
    public void printKSumPaths(Node root, int k) {
        List<Integer> path = new ArrayList<>();
        printPathsUtil(root,k,path);
    }

    private void printPathsUtil(Node node, int k, List<Integer> path){
        if(node == null){
            return;
        }
        // Current node ko path mein daal do
        path.add(node.data);
        //left aur right me jao
        printPathsUtil(node.left,k,path);
        printPathsUtil(node.right,k,path);

        //ab current path ke end se pichhe ki taraf sum check karo
        int sum = 0;
        for(int i =  path.size() -1;i >=0; i--){
            sum += path.get(i);

            //agar sum == k ho gaya
            if(sum == k){
                //path print kar do
                printPath(path,i);
            }
        }

        path.remove(path.size() - 1);

    }

    //path print karne wala helper
    private void printPath(List<Integer> path,int start){
        for(int i = start; i<path.size();i++){
            System.out.print(path.get(i)+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {

        /* Example Tree:
                  1
                /   \
               3     -1
              / \    /  \
             2   1  4    5
            /   /  / \    \
           1   1  1   2    2
        */

        // Tree 1 - k = 7
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        root.left.left = new Node(2);
        root.left.right = new Node(1);
        root.right.left = new Node(4);
        root.right.right = new Node(5);
        root.left.left.left = new Node(1);

        int k = 7;

        All_K_Sum_Paths obj = new All_K_Sum_Paths();
        System.out.println("K-Sum Paths (k = " + k + "):");
        obj.printKSumPaths(root, k);
    }
}


