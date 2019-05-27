package shapes;

public class Triangle implements Shape {
    private double[] dimensionsArr;

    Triangle(double[] dimensionsArr) {
        this.dimensionsArr = new double[3];
        this.dimensionsArr = dimensionsArr;
    }

//    @Override
//    public void setDimensions(double[] dimensionsArr){
//        this.dimensionsArr = new double[3];
//        this.dimensionsArr = dimensionsArr;
//    }

    @Override
    public double getPerimeter() {
        return dimensionsArr[0] + dimensionsArr[1] + dimensionsArr[2];
    }

    @Override
    public String getDimensions() {
        return "s1=" + dimensionsArr[0] + ", s2=" + dimensionsArr[1] + ", s3=" + dimensionsArr[2];
    }
}
