import java.io.*;

public class ReadStdInfo {
    public static void readStdInfo(){
        try {
            FileInputStream fis = new FileInputStream("output.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            boolean read = true;
            int stdCounter = 1;

            while(read) {
                Student std = (Student) ois.readObject();

                if(std != null) {
                    System.out.println("Student " + stdCounter++);
                    System.out.println("Student Number: " + std.getStdID());
                    System.out.println("Student Name: " + std.getFullName());
                    System.out.println("Student Course(s): " + std.getCourses());
                    System.out.println();

                } else{
                    read = false;
                }
            }

            fis.close();

        }catch(EOFException e){
            System.out.print("End of file reached!");
        } catch(Throwable e){
            System.err.println(e);
        }
    }
}
