package shapes;
import java.lang.Math;

public class Circle implements Shape {
    private double radius;

    Circle(double radius){
        this.radius = radius;
    }

//    @Override
//    public void setDimensions(double[] dimensionsArr){
//        this.radius = dimensionsArr[0];
//    }

    @Override
    public double getPerimeter(){
        return 2*Math.PI*radius;
    }

    @Override
    public String getDimensions() {
        return "r=" + radius;
    }


}
