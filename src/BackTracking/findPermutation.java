package BackTracking;
import java.util.*;

public class findPermutation {

        public static void main(String[] args) {
            findPermutation sol = new findPermutation();

            String s = "ABC";
            List<String> result = sol.findpermutation(s);

            System.out.println(result);
        }

    public List<String> findpermutation(String s) {
            List<String> ans = new ArrayList<>();
            char[] arr = s.toCharArray();
            Arrays.sort(arr);                     // sort karna important hai
            boolean[] visited = new boolean[arr.length];

            solve(arr, visited, new StringBuilder(), ans);
            return ans;
        }

        private void solve(char[] arr, boolean[] visited, StringBuilder path, List<String> ans) {

            // Base Case: jab path complete ho gaya
            if (path.length() == arr.length) {
                ans.add(path.toString());
                return;
            }

            for (int i = 0; i < arr.length; i++) {

                // Already used hai toh skip
                if (visited[i]) continue;

                // Duplicate avoid karne ka condition
                if (i > 0 && arr[i] == arr[i-1] && !visited[i-1]) {
                    continue;
                }

                // Current character lo
                visited[i] = true;
                path.append(arr[i]);

                solve(arr, visited, path, ans);

                // Backtrack
                path.deleteCharAt(path.length() - 1);
                visited[i] = false;
            }
        }
    }

