package model;

import java.io.Serializable;

import fr.tp.inf112.projects.canvas.model.*;

public abstract class MovingComponent extends Component implements Serializable {

	private static final long serialVersionUID = 1L;
	private float speedX;
    private float speedY;
    private final int timeDelay;

    
    public MovingComponent() {
        super(); 
        this.speedX = 0.0f;
        this.speedY = 0.0f;
        this.timeDelay = 0;
    }
    
    public MovingComponent(int xCoordinate, int yCoordinate, String name, Style style, Shape shape, int timeDelay) {
        super(xCoordinate, yCoordinate, name, style, shape);
        this.timeDelay = timeDelay;
    }

    public float getSpeedX() {
        return speedX;
    }

    public float getSpeedY() {
        return speedY;
    }

    public int getTimeDelay() {
        return timeDelay;
    }

    public void setSpeedX(float speedX) {
        this.speedX = speedX;
        setFactoryNotify();
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
        setFactoryNotify();
    }

}
