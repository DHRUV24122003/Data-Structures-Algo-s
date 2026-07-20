package BackTracking;

import java.util.ArrayList;

public class PrintPaths {
    static void main() {
        //System.out.println("Total no of paths are : " + (count(3,3)));
        System.out.println(pathRet(" ", 3, 3));
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
    static ArrayList<String> pathRet(String p, int r, int c) {
        if (r == 1 && c == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();

        //if we have tpo check the path diangonally as well

        if(r>1 && c>1){
            list.addAll(pathRet(p+"D", r-1, c-1));
        }
        if (r > 1) {
            list.addAll(pathRet(p + "V", r - 1, c));
        }

        if (c > 1) {
            list.addAll(pathRet(p + "H", r, c - 1));
        }
        return list;
    }



}






