package Trees;

import java.util.*;



class solution {

    // Function to find minimum swaps to convert Binary Tree to BST
    public static int minSwaps(int[] levelOrder) {
        if (levelOrder == null || levelOrder.length == 0) return 0;

        // Step 1: Build Binary Tree from level order array
        Node root = buildTree(levelOrder);

        // Step 2: Get Inorder Traversal
        List<Integer> inorderList = new ArrayList<>();
        inorderTraversal(root, inorderList);

        // Step 3: Convert list to array
        int n = inorderList.size();
        int[] inorder = new int[n];
        for (int i = 0; i < n; i++) {
            inorder[i] = inorderList.get(i);
        }

        // Step 4: Find minimum swaps to sort this inorder array
        return minSwapsToSort(inorder);
    }

    // Build tree from level order array
    private static Node buildTree(int[] arr) {
        if (arr.length == 0) return null;

        Node root = new Node(arr[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (!queue.isEmpty() && i < arr.length) {
            Node current = queue.poll();

            if (i < arr.length) {
                current.left = new Node(arr[i++]);
                queue.offer(current.left);
            }
            if (i < arr.length) {
                current.right = new Node(arr[i++]);
                queue.offer(current.right);
            }
        }
        return root;
    }

    // Inorder Traversal
    private static void inorderTraversal(Node root, List<Integer> list) {
        if (root == null) return;
        inorderTraversal(root.left, list);
        list.add(root.data);
        inorderTraversal(root.right, list);
    }

    // Minimum swaps to sort an array using Cycle Sort logic
    private static int minSwapsToSort(int[] arr) {
        int n = arr.length;

        // Create a sorted version of array
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        // Map value -> correct index in sorted array
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            valueToIndex.put(sortedArr[i], i);
        }

        // Visited array
        boolean[] visited = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] || valueToIndex.get(arr[i]) == i) {
                continue;
            }

            // Find cycle size
            int cycleSize = 0;
            int j = i;

            while (!visited[j]) {
                visited[j] = true;
                j = valueToIndex.get(arr[j]);
                cycleSize++;
            }

            if (cycleSize > 1) {
                swaps += (cycleSize - 1);
            }
        }
        return swaps;
    }
}

// ==================== MAIN FUNCTION ====================
public class MinSwapsToBST {
    public static void main(String[] args) {
        // Example from our explanation
        int[] levelOrder = {5, 6, 7, 8, 9, 10, 11};

        int result = solution.minSwaps(levelOrder);

        System.out.println("Level Order of Binary Tree: " + Arrays.toString(levelOrder));
        System.out.println("Minimum Swaps Required to Convert to BST: " + result);
    }
}