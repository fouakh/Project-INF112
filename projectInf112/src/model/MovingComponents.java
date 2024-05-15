package model;

import fr.tp.inf112.projects.canvas.model.*;

public abstract class MovingComponents extends Components {

	private float speedX;
    private float speedY;
    private final int timeDelay;

    
    public MovingComponents() {
        super(); 
        this.speedX = 0.0f;
        this.speedY = 0.0f;
        this.timeDelay = 0;
    }
    
    public MovingComponents(int xCoordinate, int yCoordinate, String name, Style style, Shape shape, int timeDelay) {
        super(xCoordinate, yCoordinate, name, style, shape);
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
        setFactoryNotify();
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
        setFactoryNotify();
    }

}
