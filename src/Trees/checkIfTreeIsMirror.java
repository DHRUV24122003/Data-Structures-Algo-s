package Trees;

import java.util.*;

class checkIfTreeIsMirror {

    public int checkMirrorTree(int n, int e, int[] A, int[] B) {

        // Step 1: Build adjacency lists for both trees
        List<List<Integer>> adj1 = new ArrayList<>(n + 1);
        List<List<Integer>> adj2 = new ArrayList<>(n + 1);

        for (int i = 0; i <= n; i++) {
            adj1.add(new ArrayList<>());
            adj2.add(new ArrayList<>());
        }

        // Fill Tree 1 from A[]
        for (int i = 0; i < 2 * e; i += 2) {
            int u = A[i];
            int v = A[i + 1];
            adj1.get(u).add(v);
        }

        // Fill Tree 2 from B[]
        for (int i = 0; i < 2 * e; i += 2) {
            int u = B[i];
            int v = B[i + 1];
            adj2.get(u).add(v);
        }

        // Step 2: Find root of Tree 1
        boolean[] hasParent = new boolean[n + 1];
        for (int i = 0; i < 2 * e; i += 2) {
            hasParent[A[i + 1]] = true;
        }

        int root = -1;
        for (int i = 1; i <= n; i++) {
            if (!hasParent[i]) {
                root = i;
                break;
            }
        }

        // Step 3: Check if both trees are mirror images
        if (isMirror(root, root, adj1, adj2)) {
            return 1;
        }
        return 0;
    }

    // Recursive function to check mirror
    private boolean isMirror(int node1, int node2,
                             List<List<Integer>> adj1,
                             List<List<Integer>> adj2) {

        List<Integer> child1 = adj1.get(node1);
        List<Integer> child2 = adj2.get(node2);

        if (child1.size() != child2.size()) {
            return false;
        }

        int m = child1.size();

        for (int i = 0; i < m; i++) {
            if (!isMirror(child1.get(i), child2.get(m - 1 - i), adj1, adj2)) {
                return false;
            }
        }

        return true;
    }

    // Main method for testing
    public static void main(String[] args) {
        checkIfTreeIsMirror obj = new checkIfTreeIsMirror();

        // Example from question
        int n = 3;
        int e = 2;
        int[] A = {1, 2, 1, 3};
        int[] B = {1, 3, 1, 2};

        int result = obj.checkMirrorTree(n, e, A, B);
        System.out.println("Output: " + result);   // Expected: 1
    }
}