import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentProcess {
public static List<Student> gradeRange(List<Student> stdList, double lowerGrade, double higherGrade){
    return stdList.stream().filter(std -> std.getGrade() >= lowerGrade && std.getGrade() <= higherGrade).collect(Collectors.toList());
}

public static List<String> uniqueLastName(List<Student> stdList){
    return stdList.stream().map(std -> std.getName().split(" ")).map(stdName -> stdName[1]).distinct().collect(Collectors.toList());
}

public static Comparator<Student> StudentGradeComparator = (std1, std2) -> (int)(std1.getGrade() - std2.getGrade());

    public static Comparator<Student> StudentFullNameComparator = (std1, std2) -> {
        String[] std1Name = std1.getName().split(" ");
        String[] std2Name = std2.getName().split(" ");

        int compareName = std1Name[1].compareTo(std2Name[1]);
        if(std1Name[1].compareTo(std2Name[1]) == 0){
            compareName = std1Name[0].compareTo(std2Name[0]);
        }

        return compareName;
    };

    public static Comparator<Student> StudentUniqueLastNameComparator = (std1, std2) -> {
        std1.getName();
        return 0;
    };



    public static Comparator<Student> StudentFirstNameComparator = (std1, std2) -> {
        String[] std1Name = std1.getName().split(" ");
        String[] std2Name = std2.getName().split(" ");

        return std1Name[0].compareTo(std2Name[0]);
    };

    public static Comparator<Student> StudentLastNameComparator = (std1, std2) -> {
        String[] std1Name = std1.getName().split(" ");
        String[] std2Name = std2.getName().split(" ");

        return std1Name[1].compareTo(std2Name[1]);
    };


}
