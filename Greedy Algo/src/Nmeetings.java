import java.util.*;

class Meeting {
    int start;
    int end;

    Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Nmeetings {

    // Function to find maximum number of non-overlapping meetings
    public static int maximumMeetings(int[] start, int[] end) {

        int n = start.length;

        if (n == 0) {
            return 0;
        }

        // Step 1: Create list of all meetings
        List<Meeting> meetings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(start[i], end[i]));
        }

        // Step 2: Sort meetings by their ending time (earliest finish first)
        Collections.sort(meetings, (a, b) -> a.end - b.end);

        // Step 3: Select the first meeting
        int count = 1;
        int lastEndTime = meetings.get(0).end;

        // Step 4: Try to select more meetings
        for (int i = 1; i < n; i++) {
            // Agar current meeting pichhli meeting ke end ke baad start ho rahi hai
            if (meetings.get(i).start > lastEndTime) {
                count++;
                lastEndTime = meetings.get(i).end;
            }
        }

        return count;
    }

    // Main method - IntelliJ yahin se program run karega
    public static void main(String[] args) {

        // Example 1
        int[] start1 = {1, 3, 0, 5, 8, 5};
        int[] end1   = {2, 4, 6, 7, 9, 9};
        System.out.println("Example 1 Output: " + maximumMeetings(start1, end1));  // 4

        // Example 2
        int[] start2 = {10, 12, 20};
        int[] end2   = {20, 25, 30};
        System.out.println("Example 2 Output: " + maximumMeetings(start2, end2));  // 1

        // Example 3
        int[] start3 = {1, 2};
        int[] end3   = {100, 99};
        System.out.println("Example 3 Output: " + maximumMeetings(start3, end3));  // 1
    }
}