package DynamicProgramming;
import java.util.*;
public class WordBreak {
    static boolean solve(String s, Set<String> dictionary, int index) {
        if (index == s.length()) {
            return true;
        }
        for (int end = index + 1; end <= s.length(); end++) {
            String word = s.substring(index, end);
            if (dictionary.contains(word)) {

                if (solve(s, dictionary, end)) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        String s = "ilikeicecream";
        String[] words = {
                "i", "like", "ice", "cream"
        };
        Set<String> dictionary = new HashSet<>(Arrays.asList(words));
        boolean answer = solve(s, dictionary, 0);
        System.out.println(answer);
    }
}