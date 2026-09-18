import java.util.*;

public class set2 {

    public static Set<String> removeDuplicates(List<String> names) {
        return new LinkedHashSet<>(names);
    }

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();

        names.add("Aman");
        names.add("Riya");
        names.add("Karan");
        names.add("Aman");
        names.add("Riya");
        names.add("Simran");
        names.add("Karan");

        Set<String> uniqueNames = removeDuplicates(names);

        System.out.println("Original List: " + names);
        System.out.println("Unique Names: " + uniqueNames);
    }
}