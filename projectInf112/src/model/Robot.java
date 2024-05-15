package model;

import java.util.List;
import java.util.ArrayList;

import fr.tp.inf112.projects.canvas.model.*;

public class Robot extends MovingComponents {
    
	private List<Components> componentsToVisit; 
    private int currentComponentIndex;
    private static final int ROBOT_RADIUS = 10;
    private boolean puckOn;
    
    private static final Color DEFAULT_COLOR = new Color() {
        @Override
        public int getRedComponent() {
            return 0;
        }

        @Override
        public int getGreenComponent() {
            return 255;
        }

        @Override
        public int getBlueComponent() {
            return 20;
        }
    };

    private static final Stroke DEFAULT_STROKE = new Stroke() {
        @Override
        public Color getColor() {
            return DEFAULT_COLOR;
        }

        @Override
        public float getThickness() {
            return 2.0f; 
        }

        @Override
        public float[] getDashPattern() {
            return null; 
        }
    };    

    public Robot(int xCoordinate, int yCoordinate, String name, int timeDelay, List<Components> componentsToVisit) {  
    	super(xCoordinate, yCoordinate, name, getDefaultStyle(), getDefaultShape(), timeDelay);
        this.puckOn = false;
        this.currentComponentIndex = 0;
        this.componentsToVisit = componentsToVisit;
    }
    
    private static Style getDefaultStyle() {
        return new Style() {
            @Override
            public Color getBackgroundColor() {
                return DEFAULT_COLOR;
            }

            @Override
            public Stroke getStroke() {
                return DEFAULT_STROKE;
            }
        };
    }

    private static OvalShape getDefaultShape() {
        return new OvalShape() {
            @Override
            public int getWidth() {
                return ROBOT_RADIUS;
            }

            @Override
            public int getHeight() {
                return ROBOT_RADIUS;
            }
        };
    }
    
    public void setComponentsToVisit(List<Components> componentsToVisit) {
    	this.componentsToVisit = componentsToVisit;
    }
    
    public void setPuckOn(boolean puckOn) {
        this.puckOn = puckOn;
        setFactoryNotify();
    }
 
    @Override
    public Style getStyle() {
        return getDefaultStyle();
    }

    @Override
    public OvalShape getShape() {
        return getDefaultShape();
    }
    
    @Override
    public void behave() {
    	if (this.componentsToVisit.isEmpty()) {
            return;
        }
        Components currentComponent = this.componentsToVisit.get(this.currentComponentIndex);
        if (this.getxCoordinate() == currentComponent.getxCoordinate() && this.getyCoordinate() == currentComponent.getyCoordinate()) {
            this.currentComponentIndex = (this.currentComponentIndex + 1) % this.componentsToVisit.size();
            currentComponent = this.componentsToVisit.get(this.currentComponentIndex);
        }
        move(currentComponent.getxCoordinate(), currentComponent.getyCoordinate());
    }

    private void move(int targetX, int targetY) {
        float deltaX = (float) targetX - this.getxCoordinate();
        float deltaY = (float) targetY - this.getyCoordinate();
        
        float length = (float) Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        // Add charging ... %
        float newDeltaX = deltaX / length * 5 * this.getTimeDelay();
        float newDeltaY = deltaY / length * 5 * this.getTimeDelay();
        
        float newX = this.getxCoordinate() + (Math.abs(newDeltaX) < Math.abs(deltaX) ? newDeltaX : deltaX);
        float newY = this.getyCoordinate() + (Math.abs(newDeltaY) < Math.abs(deltaY) ? newDeltaY : deltaY);
        
        this.setxCoordinate((int) newX);
        this.setyCoordinate((int) newY);
    }

    /*private void move(int targetX, int targetY) {
        this.setxCoordinate(targetX);
        this.setyCoordinate(targetY);
    }*/

}
