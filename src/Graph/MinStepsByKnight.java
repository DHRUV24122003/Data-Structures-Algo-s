package Graph;

  import java.util.*;

    public class MinStepsByKnight {

        //  8 possible moves of knight
        private static final int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        private static final int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};

        public int minSteps(int n, int[] start, int[] target) {
            // Agar start aur target same hain
            if (start[0] == target[0] && start[1] == target[1]) {
                return 0;
            }

            boolean[][] visited = new boolean[n + 1][n + 1]; // 1-based indexing
            Queue<int[]> queue = new LinkedList<>();

            // queue mein: {x, y, steps}
            queue.add(new int[]{start[0], start[1], 0});
            visited[start[0]][start[1]] = true;

            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                int steps = current[2];

                // 8 directions try karo
                for (int i = 0; i < 8; i++) {
                    int newX = x + dx[i];
                    int newY = y + dy[i];

                    // Valid position hai?
                    if (newX >= 1 && newX <= n && newY >= 1 && newY <= n && !visited[newX][newY]) {

                        // Target mil gaya
                        if (newX == target[0] && newY == target[1]) {
                            return steps + 1;
                        }

                        visited[newX][newY] = true;
                        queue.add(new int[]{newX, newY, steps + 1});
                    }
                }
            }

            return -1; // Impossible (usually n x n pe possible hota hai)
        }

        public static void main(String[] args) {
            MinStepsByKnight obj = new MinStepsByKnight();

            int n = 8;
            int[] start = {1, 1};      // (row, column) 1-based
            int[] target = {8, 8};

            int result = obj.minSteps(n, start, target);
            System.out.println("Minimum steps: " + result);
        }
    }

