package DynamicProgramming;

public class editDistance {

    static int solve (String s1, String s2, int i , int j){
        //if s1 is finished
        //s2's remaining characters need to be inserted

        if(i == s1.length()){
            return s2.length() -j;
        }

        //if s2 is finished then remaining characters of s1 need to be inserted

        if(j == s2.length()){
            return s1.length() -i;
        }

        //if chars are same

        if(s1.charAt(i) == s2.charAt(j)){
            return solve(s1, s2, i+1, j+1); //move ahead in both of the strings
        }

        // else perform all the operations

        //insert
        int insert = 1+solve(s1, s2, i, j+1);

        //delete
        int delete = 1+solve(s1, s2, i+1, j);

        //replace
        int replace = 1+solve(s1, s2, i+1, j+1);
        return Math.min(insert,Math.min(delete, replace));



    }
    public static void main(String[] args) {

        String s1 = "horse";
        String s2 = "ros";

        int answer = solve(s1, s2, 0, 0);

        System.out.println("Minimum operations = " + answer);
    }


}
