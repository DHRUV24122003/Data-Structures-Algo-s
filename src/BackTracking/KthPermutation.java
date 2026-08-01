package BackTracking;
import java.util.*;

public class KthPermutation {

        public static void main(String[] args) {
            KthPermutation sol = new KthPermutation();

            System.out.println(sol.getPermutation(3, 4));  // Output: 231
            System.out.println(sol.getPermutation(4, 17)); // Output: 3412
            System.out.println(sol.getPermutation(3, 1));  // Output: 123
        }




        public String getPermutation(int n, int k) {

            // 1 se n tak numbers store karo
            List<Integer> numbers = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                numbers.add(i);
            }

            // Factorials precompute karo
            int[] fact = new int[n + 1];
            fact[0] = 1;
            for (int i = 1; i <= n; i++) {
                fact[i] = fact[i - 1] * i;
            }

            // k ko 0-based bana do
            k = k - 1;

            StringBuilder ans = new StringBuilder();

            // Har position ke liye number decide karo
            for (int i = n; i >= 1; i--) {

                int index = k / fact[i - 1];   // kaunsa number aayega
                ans.append(numbers.get(index));

                // us number ko list se hata do
                numbers.remove(index);

                // k update karo
                k = k % fact[i - 1];
            }

            return ans.toString();
        }
    }

