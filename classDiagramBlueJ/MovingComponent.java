public abstract class MovingComponent extends Component {
    // Instance variables corrected to float for speed
    protected float speedX;
    protected float speedY;
    protected int timeDelay;

    /**
     * Default constructor for objects of class MovingComponent
     */
    public MovingComponent() {
        // Initialization of instance variables
        this.centerX = 0; // Assuming centerX is inherited from Component
        this.centerY = 0; // Assuming centerY is inherited from Component
        this.speedX = 0.0f;
        this.speedY = 0.0f;
        this.timeDelay = 0;
    }
    
    public MovingComponent(int centerX, int centerY, float speedX, float speedY, int timeDelay, String name) {
        super(centerX, centerY, name);
        this.speedX = speedX;
        this.speedY = speedY;
        this.timeDelay = timeDelay;
    }

    // Getters
    public float getSpeedX() {
        return speedX;
    }

    public float getSpeedY() {
        return speedY;
    }

    public int getTimeDelay() {
        return timeDelay;
    }

    // Setters
    public void setSpeedX(float speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
    }

    public void setTimeDelay(int timeDelay) {
        this.timeDelay = timeDelay;
    }

    /**
     * Calculates the magnitude of the velocity vector.
     * 
     * @return The magnitude of the velocity.
     */
    public double calculateVelocityMagnitude() {
        return Math.sqrt(speedX * speedX + speedY * speedY);
    }

    /**
     * Calculates the angle of direction of movement in degrees.
     * 
     * @return The angle of direction in degrees.
     */
    public double calculateDirectionAngle() {
        // Convert radians to degrees
        return Math.toDegrees(Math.atan2(speedY, speedX));
    }
}
