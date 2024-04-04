public class Robot extends MovingComponent {
    // Additional variables specific to Robot can be declared here
    private static final double ROBOT_RADIUS = 10.0;
    private Circle circle;
    private boolean puckOn;
    /**
     * Constructor for objects of class Robot. Initializes all variables from both Component and MovingComponent.
     *
     * @param center_x Initial x-coordinate of the robot's center.
     * @param center_y Initial y-coordinate of the robot's center.
     * @param speedX Initial x-speed of the robot.
     * @param speedY Initial y-speed of the robot.
     * @param timeDelay Initial time delay for the robot's movement.
     * @param name Initial name of the robot.
     */
    public Robot(int center_x, int center_y, float speedX, float speedY, int timeDelay, String name) {
        // Initialize Component and MovingComponent variables via the superclass constructor
        super(center_x, center_y, speedX, speedY, timeDelay, name);
        this.circle = new Circle(ROBOT_RADIUS);
        this.puckOn = false;
    }

    public Circle getCircle() {
        return circle;
    }

    public double getRobotRadius() {
        return ROBOT_RADIUS;
    }
}
