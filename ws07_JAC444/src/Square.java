public class Square extends Rectangle {
    private double side;

    Square(double side) throws Exception{
        super(side, side);
        this.side = super.width;
    }

}
