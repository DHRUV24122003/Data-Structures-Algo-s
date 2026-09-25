package DynamicProgramming;

import java.util.Arrays;

public class LongestPalindromicSubsequence {

    static int solve(String s1 , String s2, int i , int j ,int [][]dp) {
        if(i == s1.length() || j == s2.length()){
            return 0;
        }

        if(dp[i][j]!=-1){

            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {

            return dp[i][j] =
                    1 + solve(
                            s1, s2,
                            i + 1, j + 1,
                            dp
                    );
        }

        // Not match
        int skipS1 =
                solve(s1, s2, i + 1, j, dp);

        int skipS2 =
                solve(s1, s2, i, j + 1, dp);

        return dp[i][j] =
                Math.max(skipS1, skipS2);
    }

    static int longestPalindromicSubsequence(String s) {

        String reversed =
                new StringBuilder(s)
                        .reverse()
                        .toString();

        int n = s.length();

        int[][] dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(s, reversed, 0, 0, dp);
    }

    static void main(String[] args) {

        String s = "agbdba";

        System.out.println(
                longestPalindromicSubsequence(s)
        );
    }
}
