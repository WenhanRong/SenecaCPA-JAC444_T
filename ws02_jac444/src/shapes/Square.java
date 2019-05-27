package shapes;
public class Square implements Shape{
    private double dimensions;

    Square(double dimensionsArr){
        this.dimensions = dimensionsArr;
    }

//    @Override
//    public void setDimensions(double[] dimensionsArr){
//        this.dimensions = dimensionsArr[0];
//    }

    @Override
    public double getPerimeter(){
        return 4*dimensions;
    }

    @Override
    public String getDimensions(){
        return "s=" + dimensions;
    }

}
