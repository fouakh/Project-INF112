import java.util.List;

/**
 * Interface IShape to define the behavior of shape components, including a method to calculate
 * a bounding box based on a provided center.
 */
public interface IShape {
    /**
     * Calculates the area of the shape.
     * 
     * @return The area of the shape.
     */
    double calculateArea();

    /**
     * Calculates the perimeter of the shape.
     * 
     * @return The perimeter of the shape.
     */
    double calculatePerimeter();

    /**
     * Determines the bounding box of the shape based on its center.
     * 
     * @param center_x The x coordinate of the shape's center.
     * @param center_y The y coordinate of the shape's center.
     * @return A list of four integers representing the top-left (x, y) and bottom-right (x, y) 
     * coordinates of the shape's bounding box.
     */
    List<Integer> determineBoundingBox(int center_x, int center_y);
}
