import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class GetStdInfo {
    public static void getStdInfo() {
        try {
            FileOutputStream fs = new FileOutputStream("output.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fs);
            Scanner reader = new Scanner(System.in);

            boolean addStd = true;

            do {
                Student std = new Student();

                System.out.println("Enter student number: ");
                std.setStdID(reader.nextInt());
                reader.nextLine();

                System.out.println("Enter student's first name: ");
                std.setFirstName(reader.nextLine());
                System.out.println("Enter student's last name: ");
                std.setLastName(reader.nextLine());

                boolean addCourse = true;

                do {
                    System.out.println("Enter student's course <Enter 0 to finish>: ");
                    String course = reader.nextLine();

                    if (course.equals("0")) {
                        addCourse = false;
                    } else {
                        std.setCourses(course);
                    }

                } while (addCourse);

                oos.writeObject(std);
                oos.flush();

                System.out.println("Would you like to enter another student? (y or n): ");
                String answer = reader.nextLine();

                while(!(answer.equalsIgnoreCase("y")) && !(answer.equalsIgnoreCase("n"))){
                    System.out.println(answer + " is an invalid answer. Please enter y or n: ");
                    answer = reader.nextLine();
                }

                if(answer.equalsIgnoreCase("n")){
                    addStd = false;
                }

            }while(addStd);

            oos.flush();
            fs.close();

        } catch (Throwable e) {
            System.err.println(e);
        }
    }
}
