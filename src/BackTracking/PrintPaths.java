package BackTracking;

public class PrintPaths {
    static void main() {
        //System.out.println("Total no of paths are : " + (count(3,3)));
        path(" ",3,3);
    }
    // here this code is only to find out number of paths
//    static int count(int r, int c){
//        if(r==1||c==1){
//            return 1;
//        }
//        int left = count(r-1,c);
//        int right = count(r,c-1);
//        return left+right;
//    }
   //it is for printing the total number of paths
    static void path (String p, int r , int c ){
        if(r==1 && c==1){
            System.out.println(p);
            return;
        }


        if(r>1){
            path(p + 'D',r-1,c);
        }

        if(c>1){
            path(p+ 'R',r,c-1);
        }

}
}






