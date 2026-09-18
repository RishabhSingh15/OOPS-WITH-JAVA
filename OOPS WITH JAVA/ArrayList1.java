import java.util.*;

public class ArrayList1 {

    public static void addMarks(List<Integer> marks, int mark) {
        marks.add(mark);
    }

    public static double calculateAverage(List<Integer> marks) {
        if (marks == null || marks.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.size();
    }

    public static int findHighest(List<Integer> marks) {
        if (marks == null || marks.isEmpty()) {
            return 0;
        }
        return Collections.max(marks);
    }

    public static void displayMarks(List<Integer> marks) {
        if (marks == null || marks.isEmpty()) {
            return;
        }
        for (int i = 0; i < marks.size(); i++) {
            System.out.print(marks.get(i));
            if (i < marks.size() - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> marks = new ArrayList<>();

        addMarks(marks, 78);
        addMarks(marks, 85);
        addMarks(marks, 92);
        addMarks(marks, 67);
        addMarks(marks, 88);

        displayMarks(marks);

        System.out.println("Average: " + calculateAverage(marks));
        System.out.println("Highest: " + findHighest(marks));
    }
}