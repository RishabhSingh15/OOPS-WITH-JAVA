import java.util.*;

public class set3 {

    public static Set<Integer> commonStudents(
            Set<Integer> javaStudents,
            Set<Integer> pythonStudents) {
        Set<Integer> intersection = new HashSet<>(javaStudents);
        intersection.retainAll(pythonStudents);
        return intersection;
    }

    public static Set<Integer> allStudents(
            Set<Integer> javaStudents,
            Set<Integer> pythonStudents) {
        Set<Integer> union = new HashSet<>(javaStudents);
        union.addAll(pythonStudents);
        return union;
    }

    public static Set<Integer> onlyJava(
            Set<Integer> javaStudents,
            Set<Integer> pythonStudents) {
        Set<Integer> difference = new HashSet<>(javaStudents);
        difference.removeAll(pythonStudents);
        return difference;
    }

    public static void main(String[] args) {

        Set<Integer> javaStudents =
                new HashSet<>(
                        Arrays.asList(101, 102, 103, 104));

        Set<Integer> pythonStudents =
                new HashSet<>(
                        Arrays.asList(103, 104, 105, 106));

        System.out.println("Both: "
                + commonStudents(javaStudents, pythonStudents));

        System.out.println("Either: "
                + allStudents(javaStudents, pythonStudents));

        System.out.println("Only Java: "
                + onlyJava(javaStudents, pythonStudents));
    }
}