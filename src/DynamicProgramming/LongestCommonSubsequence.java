package DynamicProgramming;

public class LongestCommonSubsequence {
    static int solve(String s1, String s2, int i , int j){
    //base case
        if(i==s1.length() || j==s2.length()){
        return 0;
        }
        //character match
        if(s1.charAt(i)==s2.charAt(j)){
            return 1+solve(s1,s2,i+1,j+1);
        }
        //characters don't match
        int skipS1 = solve(s1,s2,i+1,j);
        int skipS2 = solve(s1,s2,i,j+1);
        return Math.max(skipS1,skipS2);
    }


    static void main() {
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";

        int answer = solve(s1, s2, 0, 0);

        System.out.println("LCS Length = " + answer);
    }
}
