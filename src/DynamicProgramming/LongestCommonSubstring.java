package DynamicProgramming;

public class LongestCommonSubstring {

        static int longestCommonSubstring(String s1, String s2) {

            int n = s1.length(); //the length of the string
            int m = s2.length();

            int[][] dp = new int[n + 1][m + 1]; //initializing a 2d dp with the size of both of the string

            int maxLength = 0; //initialize maxLength as 0

            for (int i = 1; i <= n; i++) { //for all the characters of String 1

                for (int j = 1; j <= m; j++) { //and for all the chars os string 2

                    // Characters match
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) { //if the prev character is matching of each of the string

                        dp[i][j] = 1 + dp[i - 1][j - 1]; //add one to the length of common substring

                        maxLength = Math.max(maxLength, dp[i][j]); //and then return the common substring of  max length and dp

                    } else {

                        // Continuity broken ...
                        dp[i][j] = 0;
                    }
                }
            }

            return maxLength;
        }


        public static void main(String[] args) {

            String s1 = "ABCDGH";
            String s2 = "ACDGHR";

            int answer =
                    longestCommonSubstring(s1, s2);

            System.out.println(
                    "Longest Common Substring Length = " + answer
            );
        }
    }

