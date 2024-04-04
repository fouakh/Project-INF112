import java.util.Arrays;
import java.util.List;

public class Circle implements IShape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
    
    @Override
    public List<Integer> determineBoundingBox(int center_x, int center_y) {
        int topLeftX = center_x - (int)radius;
        int topLeftY = center_y - (int)radius;
        int bottomRightX = center_x + (int)radius;
        int bottomRightY = center_y + (int)radius;

        return Arrays.asList(topLeftX, topLeftY, bottomRightX, bottomRightY);
    }
}