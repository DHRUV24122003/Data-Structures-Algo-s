package GreedyAlgorithms;

import java.util.*;

public class jobSequencing {

    public static ArrayList<Integer> jobsequencing(int[] deadline, int[] profit) {
        int n = deadline.length; //number of deadlines

        //create a list of jobs(index, deadline, profit)
        //we store index just for understanding

        ArrayList<int[]> jobs = new ArrayList<>(); //make a list jobs
        for (int i = 0; i < n; i++) {
            jobs.add(new int[]{deadline[i], profit[i], i}); //deadline , profit and index of eacj job are being stores in an array
            //and being added to a list name jobs

        }

        //now sort the jobs in descending order of profits
        //highest profit first

        Collections.sort(jobs, (a, b) -> b[1] - a[1]);
        //find maximum deadline


        int maxDeadline = 0;// assume it maximum then by running a loop update to maximum
        for (int d : deadline) {
            maxDeadline = Math.max(maxDeadline, d);
        }
        //create slot array
        //slot[i] = -1 means empty

        int[] slot = new int[maxDeadline + 1];
        Arrays.fill(slot, -1); //make all the slots as empty

        int countJobs = 0; //right now both of these are 0
        int maxProfit = 0;

        //now try to place each job in the latest possible free slot
        for (int[] job : jobs) {
            int d = job[0]; //deadline of current job
            int p = job[1]; //profit of current job

            //start from deadline and go backwards to find free slot
            for (int j = d; j > 0; j--) {
                if (slot[j] == -1) {
                    //free slot found

                    slot[j] = 1; // mark as occupied;
                    countJobs++;

                    maxProfit += p;
                    break;
                }
            }

        }

        //step : return result as arraylist
        //first value -> number of jobs done
        //second value -> maximum profit

        ArrayList<Integer> result = new ArrayList<>();
        result.add(countJobs);
        result.add(maxProfit);

        return result;


    }


    static void main() {
        int[] deadline = {4, 1, 1, 1};
        int[] profit = {20, 10, 40, 30};

        ArrayList<Integer> ans = jobSequencing.jobsequencing(deadline, profit);
        System.out.println(ans);   // Output: [2, 60]
    }
}




//to reduce time complexity

//class Solution {
//    public ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
//        // code here
//        int n = deadline.length;
//
//        // Step 1: Jobs ko store karo {deadline, profit}
//        ArrayList<int[]> jobs = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            jobs.add(new int[]{deadline[i], profit[i]});
//        }
//
//        // Step 2: Deadline ke according ascending order mein sort karo
//        Collections.sort(jobs, (a, b) -> a[0] - b[0]);
//
//        // Step 3: Min Heap (PriorityQueue) - smallest profit pehle
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//
//        for (int[] job : jobs) {
//            int d = job[0];
//            int p = job[1];
//
//            if (pq.size() < d) {
//                // Agar slot available hai toh add kar do
//                pq.add(p);
//            }
//            else if (!pq.isEmpty() && pq.peek() < p) {
//                // Agar current job better hai toh lowest profit wale ko replace kar do
//                pq.poll();
//                pq.add(p);
//            }
//        }
//
//        // Step 4: Result calculate karo
//        int countJobs = pq.size();
//        int maxProfit = 0;
//
//        while (!pq.isEmpty()) {
//            maxProfit += pq.poll();
//        }
//
//        ArrayList<Integer> result = new ArrayList<>();
//        result.add(countJobs);
//        result.add(maxProfit);
//        return result;
//    }
//}