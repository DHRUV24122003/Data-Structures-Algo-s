package BackTracking;

import java.util.*;

public class WordBreak {
    static void main() {
        String s = "welcometothekapilsharmashow";
        List<String> dict = Arrays.asList("welcome", "to",
                "the",
                "kapil",
                "sharma",
                "show"

        );

        List<String> result = wordBreak(s, dict);
        System.out.println(result);
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        List<String> result = new ArrayList<>();
        //call the function
        solve(s,0," ",dict, result);
        return result;
    }

    public static void solve(String s,int start, String path, Set<String> dict, List<String> result) {
        //base case
        if(start == s.length()){
            result.add(path.trim());//add the path to the result
            return ;
        }
        for(int end = start+1; end <= s.length(); end++){
            String word = s.substring(start, end);
            if(dict.contains(word)){
                solve(s,end,path+word+" ",dict,result);
            }
        }
    }
}
