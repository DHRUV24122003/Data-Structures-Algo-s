package BackTracking;
import java.util.*;



public class PalindromicPartitionString {
    public static void main(String[] args) {
        PalindromicPartitionString obj = new PalindromicPartitionString();

        String s = "abcbadad";
        List<List<String>> ans = obj.palinParts(s);

        for (List<String> partition : ans) {
            System.out.println(partition);
        }
    }


        public List<List<String>> palinParts(String s) {
            List<List<String>> result = new ArrayList<>();
            List<String> current = new ArrayList<>();

            solve(0, s, current, result);
            return result;
        }

        private void solve(int index, String s, List<String> current, List<List<String>> result) {
            // Base case: poori string partition ho gayi
            if (index == s.length()) {
                result.add(new ArrayList<>(current));
                return;
            }

            // index se lekar end tak har possible cut try karo
            for (int i = index; i < s.length(); i++) {
                // Current substring s[index...i] palindrome hai ya nahi
                if (isPalindrome(s, index, i)) {
                    // Palindrome hai toh current list mein daalo
                    current.add(s.substring(index, i + 1));

                    // Aage ki string ke liye recursive call
                    solve(i + 1, s, current, result);

                    // Backtrack
                    current.remove(current.size() - 1);
                }
            }
        }

        // Helper function to check palindrome
        private boolean isPalindrome(String s, int left, int right) {
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }

