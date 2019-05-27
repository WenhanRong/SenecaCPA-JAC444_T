public class Triangle implements Shape {
    private double s1;
    private double s2;
    private double s3;

    Triangle(double s1, double s2, double s3) throws Exception {
        if (s1 > 0.0 || s2 > 0.0 || s3 > 0.0) {
            this.s1 = s1;
            this.s2 = s2;
            this.s3 = s3;
        } else {
            throw new Exception("Invalid side(s)!");
        }
    }

    @Override
    public double getPerimeter(){
        return s1 + s2 + s3;
    }


}

