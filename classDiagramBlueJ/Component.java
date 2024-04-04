/**
 * Abstract class Component - describes common properties and methods for components in your application.
 * Each component has a center (x and y coordinates), a name, and a unique identifier that automatically increments with each new instance.
 */
public abstract class Component {
    // Instance variables
    protected int centerX;
    protected int centerY;
    protected String name;    
    protected int id;

    // Class variable to track the last assigned ID
    private static int lastId = 0;

    /**
     * Default constructor for objects of class Component.
     * Initializes components with default values and assigns a unique ID.
     */
    public Component() {
        this.centerX = 0;
        this.centerY = 0;
        this.name = "none";
        // Increment lastId and assign the new value to the instance's ID
        this.id = ++lastId;
    }

    /**
     * Constructor for objects of class Component with specific parameters.
     * Initializes components with provided values and assigns a unique ID.
     */
    public Component(int centerX, int centerY, String name) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.name = name;
        // Increment lastId and assign the new value to the instance's ID
        this.id = ++lastId;
    }

    // Setters and Getters
    
    // Setters
    public void setCenterX(int center_x) {
        this.centerX = centerX;
    }

    public void setCenterY(int center_y) {
        this.centerY = centerY;
    }

    public void setName(String name) {
        this.name = name;
    }

    // No setter for id as it is automatically managed

    // Getters
    public int getCenterX() {
        return this.centerX;
    }

    public int getCenterY() {
        return this.centerY;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    /**
     * Abstract method intended to be implemented by subclasses.
     * For example, could be used to draw the component or to update its state.
     */
    //public abstract void update();
}
