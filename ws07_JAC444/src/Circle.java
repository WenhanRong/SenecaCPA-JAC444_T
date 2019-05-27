import static java.lang.Math.PI;

public class Circle implements Shape {
    private double radius;
    Shape1 obj = () -> { return PI*radius*radius; };

    Circle(double radius) throws Exception {
            if(radius > 0.0) {
                this.radius = radius;
            } else{
                throw new Exception("Invalid radius!");
            }
    }

    public double getObjMethod() {
        return obj.getArea();
    }

    @Override
    public double getPerimeter(){
        return 2*PI*radius;
    }
}
