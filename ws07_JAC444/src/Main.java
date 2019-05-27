import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String fileName = "src/shapes.txt";

        int shapesArrCounter = 0;
        Shape[] shapeArr;
        String s;

        System.out.println("-------> JAC 444 Assignment 7 <-------");
        System.out.println("------->        Task 4        <-------");

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            // Count number of lines in file to allocate array space
            while ((s = br.readLine()) != null) {
                try {
                    // ["Triangle", "1.0", "2.0", "3.0"]
                    String[] tokens = s.split(",");

                    // Check for...
                    // Valid shape name
                    // Sufficient dimensions
                    // Valid dimensions (NOT negative)

                    Class<?> c = Class.forName(tokens[0]);
                    boolean sufficientDimensions;

                    sufficientDimensions = isSufficientDimensions(tokens, c);

                    if (sufficientDimensions) {
                        for (int i = 1; i < tokens.length; i++) {
                            if (Double.valueOf(tokens[i]) <= 0.0) {
                                throw new Exception();
                            }
                        }

                        if (tokens[0].equals("Triangle")) {
                            if ((Double.valueOf(tokens[1]) + Double.valueOf(tokens[2])) < Double.valueOf(tokens[3])) {
                                throw new Exception();
                            } else if ((Double.valueOf(tokens[2]) + Double.valueOf(tokens[3])) < Double.valueOf(tokens[1])) {
                                throw new Exception();
                            } else if ((Double.valueOf(tokens[3]) + Double.valueOf(tokens[1])) < Double.valueOf(tokens[2])) {
                                throw new Exception();
                            }
                        }

                        shapesArrCounter++;

                    } else {
                        throw new Exception();
                    }
                } catch (Exception ignored) {
                }
            }
        } catch (IOException e) {
            System.out.println("Unable to read file!");
        }


        shapeArr = new Shape[shapesArrCounter];
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            shapesArrCounter = 0;

            // Count number of lines in file to allocate array space
            while ((s = br.readLine()) != null) {
                try {
                    // ["Triangle", "1.0", "2.0", "3.0"]
                    String[] tokens = s.split(",");
                    boolean sufficientDimensions;

                    // Check for...
                    // Valid shape name
                    // Sufficient dimensions
                    // Valid dimensions (NOT negative)


                    Class<?> c = Class.forName(tokens[0]);

                    sufficientDimensions = isSufficientDimensions(tokens, c);

                    // Minus one from tokens length to exclude class name
                    if (sufficientDimensions) {
                        if (tokens[0].equals("Triangle")) {
                            if ((Double.valueOf(tokens[1]) + Double.valueOf(tokens[2])) < Double.valueOf(tokens[3])) {
                                throw new Exception("Invalid side(s)!");
                            } else if ((Double.valueOf(tokens[2]) + Double.valueOf(tokens[3])) < Double.valueOf(tokens[1])) {
                                throw new Exception("Invalid side(s)!");
                            } else if ((Double.valueOf(tokens[3]) + Double.valueOf(tokens[1])) < Double.valueOf(tokens[2])) {
                                throw new Exception("Invalid side(s)!");
                            }
                        }

                        switch (tokens[0]) {
                            case "Circle":
                                shapeArr[shapesArrCounter] = new Circle(Double.valueOf(tokens[1]));
                                shapesArrCounter++;
                                break;
                            case "Parallelogram":
                                shapeArr[shapesArrCounter] = new Parallelogram(Double.valueOf(tokens[1]), Double.valueOf(tokens[2]));
                                shapesArrCounter++;
                                break;
                            case "Rectangle":
                                shapeArr[shapesArrCounter] = new Rectangle(Double.valueOf(tokens[1]), Double.valueOf(tokens[2]));
                                shapesArrCounter++;
                                break;
                            case "Square":
                                shapeArr[shapesArrCounter] = new Square(Double.valueOf(tokens[1]));
                                shapesArrCounter++;
                                break;
                            case "Triangle":
                                shapeArr[shapesArrCounter] = new Triangle(Double.valueOf(tokens[1]), Double.valueOf(tokens[2]), Double.valueOf(tokens[3]));
                                shapesArrCounter++;
                                break;
                            default:
                                throw new ClassNotFoundException("");
                        }

                    } else {
                        throw new Exception("Invalid side(s)!");
                    }
                } catch (ClassNotFoundException e) {
                    System.out.println("Invalid class name!");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Unable to read file!");
        } catch (Throwable ignored) {
        }

        System.out.println("\n" + shapeArr.length + " were created:");
        int counter = 0;

        for (Shape shape : shapeArr) {
            System.out.println(++counter + " -----");
            String className = shape.getClass().getSimpleName();
            System.out.println(className + " perimeter = " + shape.getPerimeter());

            if (shape instanceof Circle || shape instanceof Rectangle) {
                try {
                    Method objMethod = shape.getClass().getMethod("getObjMethod");
                    System.out.println("Area: " + objMethod.invoke(shape));
                } catch (Throwable e) {
                    System.out.println(e);
                }
            }
        }
    }

    private static boolean isSufficientDimensions(String[] tokens, Class<?> c) {
        String className = c.getSimpleName();
        boolean sufficientDimensions = false;

        if (className.equalsIgnoreCase("Circle") || className.equalsIgnoreCase("Rectangle")) {
            // These classes will have lambda objects
            if (c.getDeclaredFields().length == tokens.length) {
                sufficientDimensions = true;
            }
        } else if (c.getDeclaredFields().length == tokens.length - 1) {
            sufficientDimensions = true;
        }
        return sufficientDimensions;
    }

}
