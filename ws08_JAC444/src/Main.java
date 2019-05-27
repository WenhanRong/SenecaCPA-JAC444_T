import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Student[] students = {
                new Student("Jack", "Smith", 50.0, "IT"),
                new Student("Aaron", "Johnson", 76.0, "IT"),
                new Student("Maaria", "White", 35.8, "Business"),
                new Student("John", "White", 47.0, "Media"),
                new Student("Laney", "White", 62.0, "IT"),
                new Student("Jack", "Jones", 32.9, "Business"),
                new Student("Wesley", "Jones", 42.89, "Media"),
        };

        List<Student> studentsList = new ArrayList(Arrays.asList(students));

        System.out.println("\n---------->     Task 1     <----------");
        System.out.println("--- Complete Student list: ");
        studentsList.forEach(System.out::println);

        System.out.println("\n---------->     Task 2     <----------");
        System.out.println("--- Students who got 50% - 100% sorted by grade: ");
        studentsList.sort(StudentProcess.StudentGradeComparator);
        StudentProcess.gradeRange(studentsList, 50, 100).forEach(std -> System.out.println(std.toString()));

        System.out.println("\n---------->     Task 3     <----------");
        System.out.println("--- First student who got 50% - 100%: ");
        System.out.println(StudentProcess.gradeRange(studentsList, 50, 100).get(0));

        System.out.println("\n---------->     Task 4     <----------");
        System.out.println("--- Student in ascending order by last name then first: ");
        studentsList.sort(StudentProcess.StudentFullNameComparator);
        studentsList.forEach(std -> System.out.println(std.toString()));

        System.out.println("\n--- Student in descending order by last name then first: ");
        studentsList.sort((StudentProcess.StudentFullNameComparator.reversed()));
        studentsList.forEach(std -> System.out.println(std.toString()));

        System.out.println("\n---------->     Task 5     <----------");
        System.out.println("--- Unique student last names: ");
        studentsList.stream().map(Student::getName).distinct().sorted().forEach(System.out::println).sort(StudentProcess.StudentLastNameComparator);
        StudentProcess.uniqueLastName(studentsList).forEach(stdLName -> System.out.println(stdLName));



    }
}
