import java.util.Comparator;

public class Student implements Comparable<Student> {
    private String firstName;
    private String lastName;
    private double grade;
    private String department;
    StudentProcess studentProcess = new StudentProcess();

    Student(String firstName, String lastName, double grade, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
        this.department = department;
    }

    public String getName() {
        return (firstName + ' ' + lastName);
    }

    public double getGrade() {
        return grade;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return String.format("%-12s", firstName) +
        String.format("%-12s", lastName) +
        String.format("%-7s", grade)+
        String.format("%-12s", department);
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int compareTo(Student std) {
        double compareGrade = std.getGrade();
        return (int)(Math.round(this.grade - compareGrade));
    }
}
