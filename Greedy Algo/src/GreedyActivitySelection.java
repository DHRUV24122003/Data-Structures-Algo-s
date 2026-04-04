import java.util.*;

class Activity {
    int start;
    int finish;
    int index;

    Activity(int start, int finish, int index) {
        this.start = start;
        this.finish = finish;
        this.index = index;
    }
}

public class GreedyActivitySelection {

    public static List<Integer> activitySelection(int[] start, int[] finish) {
        int n = start.length;

        // Step 1: Create list of activities
        List<Activity> activities = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            activities.add(new Activity(start[i], finish[i], i));
        }

        // Step 2: Sort activities by finish time (ascending)
        activities.sort((a, b) -> a.finish - b.finish);

        // Step 3: Greedy selection
        List<Integer> selected = new ArrayList<>();
        int lastFinishTime = -1;

        for (Activity act : activities) {
            if (act.start >= lastFinishTime) {
                selected.add(act.index);
                lastFinishTime = act.finish;
            }
        }

        return selected;
    }

    public static void main(String[] args) {
        int[] start  = {1, 3, 0, 5, 8, 5, 6};
        int[] finish = {4, 5, 6, 7, 9, 9, 10};

        List<Integer> result = activitySelection(start, finish);

        System.out.println("Selected Activity Indices: " + result);
        System.out.println("Maximum number of activities: " + result.size());
    }
}