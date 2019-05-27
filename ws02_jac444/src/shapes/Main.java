package shapes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String fileName = "shapes/shapes.txt";


        System.out.println("------->JAC 444 Assignment 1<-------");
        System.out.println("------->Task 1 ... <-------");

        int shapesArrCounter = 0;
        String shapeList[] = {"Circle", "Parallelogram", "Rectangle", "Square", "Triangle"};
        Shape[] shapeArr = {};
        String s;
        int a = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((s = br.readLine()) != null) {
                // ["Triangle", "1.0", "2.0", "3.0"]
                String[] tokens = s.split(",");

                for (int i = 0; i < shapeList.length; i++) {
                    if (tokens[0].equalsIgnoreCase(shapeList[i])) {
                        shapesArrCounter++;
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("error!");
        } catch (Exception e) {
            System.out.println(e);
        }

            shapeArr = new Shape[shapesArrCounter];
            try(BufferedReader br1 = new BufferedReader(new FileReader(fileName))) {


                while ((s = br1.readLine()) != null) {
                    try {
                        // ["Triangle", "1.0", "2.0", "3.0"]
                        String[] tokens = s.split(",");

                        double[] parsed = new double[tokens.length - 1];
                        for (int i = 1; i <= tokens.length - 1; i++) {
                            parsed[i - 1] = Double.valueOf(tokens[i]);
                        }

                        System.out.println("Parsed: " + Arrays.toString(parsed));

                        double[] arr = Arrays.copyOfRange(parsed, 0, parsed.length - 1);

                        System.out.println("hi");

                        for (int i = 0; i < arr.length; i++) {
                            if (!(arr[i] > 0)) {
                                throw new Exception("Invalid side(s)!");
                            }
                        }


                        System.out.println(Class.forName(tokens[0]).getDeclaredFields().length);
                        if (Class.forName(tokens[0]).getDeclaredFields().length + 1 == tokens.length) {
                            switch (tokens[0]) {
                                case "Circle":
                                    shapeArr[a] = new Circle(arr[1]);
                                    a++;
                                    break;
                                case "Parallelogram":
                                    shapeArr[a] = new Parallelogram(arr);
                                    a++;
                                    break;
                                case "Rectangle":
                                    shapeArr[a] = new Rectangle(arr);
                                    a++;
                                    break;
                                case "Square":
                                    shapeArr[a] = new Square(arr[1]);
                                    a++;
                                    break;
                                case "Triangle":
                                    shapeArr[a] = new Triangle(arr);
                                    a++;
                                    break;
                                default:
                                    throw new Exception("Invalid shape name!");
                            }


                        } else {
                            throw new Exception("Invalid side(s)!");
                        }
                    } catch (IOException e) {
                        System.out.println("error!");
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }catch (IOException e) {
                System.out.println("error!");
            } catch (Exception e) {
                System.out.println(e);
            }


        double[] arr1 = {1.2, 3.4};
        shapeArr[0] = new Rectangle(arr1);
        System.out.println(shapeArr[0].getClass().getSimpleName());

        System.out.println(shapeArr.length + " shapes were created:");
        System.out.println(shapeArr[1].getPerimeter());
        for (int i = 0; i < shapeArr.length; i++) {
            String strClassName = shapeArr[i].getClass().getSimpleName();
            System.out.println(strClassName + " {" + shapeArr[i].getDimensions() + "} perimeter = " + shapeArr[i].getPerimeter());
        }

    }

}
