package GreedyAlgorithms;

import java.util.*;
import java.util.Comparator;
class Activity {
    int start;
    int finish;
    String name;

    public Activity(String name, int start, int finish) {
        this.name = name;
        this.start = start;
        this.finish = finish;
    }
}

public class ActivitySelection {

    //so we have to return a list of activities follows the rule
    public static  List<Activity> selectMaxActivities(Activity[] activities){
        //if there is not a single activity in the array
        if(activities == null|| activities.length == 0  ){
            return new ArrayList<>();
        }
        //FIRST THINGS TO DO IS SORT ALL THE ACTIVITIES FINISH TIME IN ASCENDING ORDER
        Arrays.sort(activities, Comparator.comparingInt(a -> a.finish));

        // now make a list to store all the selected activities
        List <Activity> selected = new ArrayList<>();

        //add the first activity in the the selected list
        selected.add(activities[0]);

        //initialize last finish time to tract at each iteration
        int lastFinishTime = activities[0].finish;


        for(int i = 0; i < activities.length; i++){

            if(activities[i].start > lastFinishTime){ // if start of an act is bigger than last finish time
                selected.add(activities[i]); // add the activity to the selected list
            }
            //if not then loop will be moved further by rejecting that activity
        }

        return selected;


    }

    public static void main(String[] args) {
        // Example input data
        Activity[] activities = {
                new Activity("A1", 1, 2),
                new Activity("A2", 3, 4),
                new Activity("A3", 0, 6),
                new Activity("A4", 5, 7),
                new Activity("A5", 8, 9),
                new Activity("A6", 5, 9)
        };

        List<Activity> result = selectMaxActivities(activities); //put the function in a result list
        System.out.println("Maximum Compatible Activities Count: " + result.size() );
        System.out.println("Selected Activities:");
        for (Activity act : result) {
            System.out.println(act.name + " -> Start: " + act.start + ", Finish: " + act.finish);

        }
    }
}




