package shapes;

import java.text.DecimalFormat;

public class Square extends Rectangle {
    private double side;

    Square(double side) throws Exception{
        super(side, side);
        this.side = super.width;
    }

    @Override
    public double getPerimeter() {
        return side;
    }

    public String getDimensions() {
        return "s=" + side;
    }
}
