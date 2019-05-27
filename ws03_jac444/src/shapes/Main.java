package shapes;

import shapes.Shape;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {
        String fileName = "shapes/shapes.txt";

        int shapesArrCounter = 0;
        Shape[] shapeArr;
        String s;

        System.out.println("------->JAC 444 Assignment 1<-------");
        System.out.println("------->Task 1 ... <-------");

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

                    Class<?> c = Class.forName("shapes." + tokens[0]);
                    if (c.getDeclaredFields().length + 1 == tokens.length) {
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
                } catch (ClassNotFoundException e) {
                } catch (Exception e) {
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

                    // Check for...
                    // Valid shape name
                    // Sufficient dimensions
                    // Valid dimensions (NOT negative)


                    Class<?> c = Class.forName("shapes." + tokens[0]);
                    if (c.getDeclaredFields().length + 1 == tokens.length) {
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
                        throw new Exception("Invalid # of side(s)!");
                    }
                } catch (ClassNotFoundException e) {
                    System.out.println("Invalid class name!");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

        } catch (IOException e) {
            System.out.println("Unable to read file!");
        }

        System.out.println("\n" + shapeArr.length + " were created:");
        for (int i = 0; i < shapeArr.length; i++) {
            System.out.println(shapeArr[i].getClass().getSimpleName() + " {" + shapeArr[i].getDimensions() + "} perimeter = " + shapeArr[i].getPerimeter());
        }

        System.out.println("\n------->Task 2 ... <-------");
        double triangleMin = 0;
        double circleMax = 0;
        boolean triangleFound = false;

        for (int i = 0; !triangleFound && (i < shapeArr.length); i++) {
            if (shapeArr[i].getClass().getSimpleName().equals("Triangle")) {
                triangleMin = shapeArr[i].getPerimeter();
                triangleFound = true;
            }
        }

        // Determine lowest triangle perimeter and highest circle perimeter
        for (int i = 0; i < shapeArr.length; i++) {
            if (shapeArr[i].getClass().getSimpleName().equals("Triangle")) {
                if (shapeArr[i].getPerimeter() < triangleMin) {
                    triangleMin = shapeArr[i].getPerimeter();
                }
            }

            if (shapeArr[i].getClass().getSimpleName().equals("Circle")) {
                if (shapeArr[i].getPerimeter() > circleMax) {
                    circleMax = shapeArr[i].getPerimeter();
                }
            }
        }

        shapesArrCounter = shapeArr.length;
        for (int i = 0; i < shapesArrCounter; i++) {
            if (shapeArr[i].getClass().getSimpleName().equals("Triangle")) {
               // if (shapeArr[i].getPerimeter() == triangleMin) {
                if(Math.abs(shapeArr[i].getPerimeter() - triangleMin) <= 0.000000001){
                    for(int j = i; j < shapesArrCounter - 1; j++) {
                        shapeArr[j] = shapeArr[j + 1];
                    }
                    shapesArrCounter--;
                }
            }

            if (shapeArr[i].getClass().getSimpleName().equals("Circle")) {
                //if (shapeArr[i].getPerimeter() == circleMax) {
                if(Math.abs(shapeArr[i].getPerimeter() - circleMax) <= 0.00000001){
                    for(int j = i; j < shapesArrCounter - 1; j++) {
                        shapeArr[j] = shapeArr[j + 1];
                    }
                    shapesArrCounter--;
                }
            }
        }

        for (int i = 0; i < shapesArrCounter; i++) {
            System.out.println(shapeArr[i].getClass().getSimpleName() + " {" + shapeArr[i].getDimensions() + "} perimeter = " + shapeArr[i].getPerimeter());
        }

        System.out.println(shapesArrCounter);

        System.out.println("\n------->Task 3 ... <-------");
        double parallelogramPTotal = 0;
        double trianglePTotal = 0;
        for (int i = 0; i < shapesArrCounter; i++) {
            if (shapeArr[i].getClass().getSimpleName().equals("Parallelogram")) {
                parallelogramPTotal += shapeArr[i].getPerimeter();
            } else if (shapeArr[i].getClass().getSimpleName().equals("Triangle")) {
                trianglePTotal += shapeArr[i].getPerimeter();
            }

        }

        System.out.println("Total perimeter of Parallelogram is: " + parallelogramPTotal);
        System.out.println("Total perimeter of Triangle is: " + trianglePTotal);
    }

}

