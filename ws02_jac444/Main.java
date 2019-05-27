package shapes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    static void main(String[] args) {
        String fileName = "shapes/shapes.txt";

        int shapesArrCounter = 0;
        Shape[] shapeArr;
        String s;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            // Count number of lines in file to allocate array space
            while ((s = br.readLine()) != null) {
                // ["Triangle", "1.0", "2.0", "3.0"]
                String[] tokens = s.split(",");

                Class<?> c = Class.forName(tokens[0]);
                if (c.getDeclaredFields().length + 1 == tokens.length) {
                    shapesArrCounter++;
                }
            }
            shapeArr = new Shape[shapesArrCounter];


        } catch (IOException e) {
            System.out.println("error!");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            //String s;
            while ((s = br.readLine()) != null) {
                // ["Triangle", "1.0", "2.0", "3.0"]
                String[] tokens = s.split(",");


                Class<?> c = Class.forName(tokens[0]);
                // Check for...
                // Valid shape name
                // Sufficient dimensions
                // Valid dimensions (Is a double and NOT negative)
                if (c.getDeclaredFields().length + 1 == tokens.length) {
                    double[] parsed = new double[tokens.length - 1];

                    for (int i = 0; i < tokens.length - 1; i++) {
                        parsed[i] = Double.valueOf(tokens[i]);
                    }

                    double[] arr = Arrays.copyOfRange(parsed, 2, parsed.length - 1);
                    Class con = c.getDeclaredConstructor(double[].class).newInstance(arr);
                } else {
                    System.out.println("Invalid side(s)!");
                }

            }

        } catch (NoSuchMethodException e1) {
            e1.printStackTrace();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException c) {
            System.out.println(c.getMessage());

        } catch (InstantiationException i) {
            System.out.println(i.getMessage());

        } catch (IllegalAccessException i) {
            System.out.println(i.getMessage());

        } catch (NumberFormatException n) {
            System.out.println(n.getMessage());

        } catch (InvocationTargetException i) {

        }
    }
}

