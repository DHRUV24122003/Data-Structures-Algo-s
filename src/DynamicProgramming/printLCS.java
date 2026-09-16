package DynamicProgramming;

public class printLCS {


        static String solve(String s1, String s2, int i, int j) {

            // Base case:
            // kisi ek string ke end par pahunch gaye
            if (i == s1.length() || j == s2.length()) {
                return "";
            }

            // CASE 1: Characters match
            if (s1.charAt(i) == s2.charAt(j)) {

                return s1.charAt(i)
                        + solve(s1, s2, i + 1, j + 1);
            }

            // CASE 2: Characters don't match

            // s1 ka current character skip
            String skipS1 =
                    solve(s1, s2, i + 1, j);

            // s2 ka current character skip
            String skipS2 =
                    solve(s1, s2, i, j + 1);

            // Jo subsequence longer hai, use return karo
            if (skipS1.length() > skipS2.length()) {
                return skipS1;
            } else {
                return skipS2;
            }
        }


        public static void main(String[] args) {

            String s1 = "ABCDGH";
            String s2 = "AEDFHR";

            String lcs = solve(s1, s2, 0, 0);

            System.out.println("LCS = " + lcs);
            System.out.println("Length = " + lcs.length());
        }
    }

