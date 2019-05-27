package shapes;

public class Parallelogram implements Shape{
    private double[] dimensionsArr;

    Parallelogram(double[] dimensionsArr){
        this.dimensionsArr = new double[2];
        this.dimensionsArr = dimensionsArr;
    }

//    @Override
//    public void setDimensions(double[] dimensionsArr){
//        this.dimensionsArr = new double[2];
//        this.dimensionsArr = dimensionsArr;
//    }

    @Override
    public double getPerimeter(){
        return 2*dimensionsArr[0] + 2*dimensionsArr[1];
    }

    @Override
    public String getDimensions(){
        return "w=" + dimensionsArr[0] + ", h=" + dimensionsArr[1];
    }
}
