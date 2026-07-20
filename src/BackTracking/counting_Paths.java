package BackTracking;



//total no of paths to reach at the goal in 2d matrix
public class counting_Paths {
    static void main() {
        System.out.println("Total no of paths are : " + (count(3,3)));

    }
    static int count(int r, int c){
        if(r==1||c==1){
            return 1;
        }
        int left = count(r-1,c);
        int right = count(r,c-1);
        return left+right;
    }

}
