import java.util.ArrayList;
import java.util.List;

// Model class to hold student details and marks
class Student {
    private String name;
    private int rollNo;
    private List<Integer> marks;
    private int totalMarks;

    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = new ArrayList<>();
        this.totalMarks = 0;
    }

    public void addMarks(int mark) {
        marks.add(mark);
    }

    public void calculateTotal() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        this.totalMarks = sum;
    }

    public String getName() {
        return name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public int getTotalMarks() {
        return totalMarks;
    }
}

// Shared repository managing student records safely
class ResultSystem {
    private List<Student> students;

    public ResultSystem() {
        this.students = new ArrayList<>();
    }

    public synchronized void addStudent(Student student) {
        students.add(student);
    }

    // Thread task 1: calculates total marks for each student
    public synchronized void processResults() {
        for (Student s : students) {
            s.calculateTotal();
        }
    }

    // Thread task 2: displays the processed student results
    public synchronized void displayResults() {
        System.out.println("----- Student Results -----");
        for (Student s : students) {
            System.out.println("Roll No: " + s.getRollNo() + " | Name: " + s.getName() + " | Total Marks: " + s.getTotalMarks());
        }
    }
}

// Runnable task matching the constructor in the main method
class ResultThread implements Runnable {
    private ResultSystem system;

    public ResultThread(ResultSystem system) {
        this.system = system;
    }

    @Override
    public void run() {
        system.processResults();
        system.displayResults();
    }
}

// Named studentResult so running studentResult.java in VS Code works directly
public class studentResult {
    public static void main(String[] args) throws InterruptedException {
        ResultSystem system = new ResultSystem();

        Student s1 = new Student("Rahul", 101);
        s1.addMarks(80);
        s1.addMarks(90);

        Student s2 = new Student("Priya", 102);
        s2.addMarks(85);
        s2.addMarks(95);

        system.addStudent(s1);
        system.addStudent(s2);

        Thread t1 = new Thread(new ResultThread(system));

        t1.start();
        t1.join();
    }
}