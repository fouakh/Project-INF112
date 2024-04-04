import java.util.Arrays;
import java.util.List;

public class Rectangle implements IShape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
    
    @Override
    public List<Integer> determineBoundingBox(int center_x, int center_y) {
        int topLeftX = center_x - (int)(width / 2);
        int topLeftY = center_y - (int)(length / 2);
        int bottomRightX = center_x + (int)(width / 2);
        int bottomRightY = center_y + (int)(length / 2);

        return Arrays.asList(topLeftX, topLeftY, bottomRightX, bottomRightY);
    }
}