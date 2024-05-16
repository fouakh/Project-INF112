package model;

import java.io.Serializable;
import java.util.List;
import fr.tp.inf112.projects.canvas.model.*;

public class Robot extends MovingComponents implements Serializable {
	
	private static final long serialVersionUID = 1L;
    private List<Components> componentsToVisit;
    private int currentComponentIndex;
    private static final int ROBOT_RADIUS = 10;
    @SuppressWarnings("unused")
	private boolean puckOn;

    private static final Color DEFAULT_COLOR = new DefaultColor();

    private static final Stroke DEFAULT_STROKE = new DefaultStroke();    

    public Robot(int xCoordinate, int yCoordinate, String name, int timeDelay, List<Components> componentsToVisit) {
        super(xCoordinate, yCoordinate, name, getDefaultStyle(), getDefaultShape(), timeDelay);
        this.puckOn = false;
        this.currentComponentIndex = 0;
        this.componentsToVisit = componentsToVisit;
    }
    
    private static Style getDefaultStyle() {
        return new DefaultStyle();
    }

    private static OvalShape getDefaultShape() {
        return new DefaultOvalShape();
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
        if (componentsToVisit.isEmpty()) {
            return;
        }
        Components currentComponent = componentsToVisit.get(currentComponentIndex);
        if (this.getxCoordinate() == currentComponent.getxCoordinate() && this.getyCoordinate() == currentComponent.getyCoordinate()) {
            currentComponentIndex = (currentComponentIndex + 1) % componentsToVisit.size();
            currentComponent = componentsToVisit.get(currentComponentIndex);
        }
        move(currentComponent.getxCoordinate(), currentComponent.getyCoordinate());
    }

    private void move(int targetX, int targetY) {
        float deltaX = (float) targetX - this.getxCoordinate();
        float deltaY = (float) targetY - this.getyCoordinate();
        
        float length = (float) Math.sqrt(deltaX * deltaX + deltaY * deltaY);
        float newDeltaX = deltaX / length * 5 * this.getTimeDelay();
        float newDeltaY = deltaY / length * 5 * this.getTimeDelay();
        
        float newX = this.getxCoordinate() + (Math.abs(newDeltaX) < Math.abs(deltaX) ? newDeltaX : deltaX);
        float newY = this.getyCoordinate() + (Math.abs(newDeltaY) < Math.abs(deltaY) ? newDeltaY : deltaY);
        
        this.setxCoordinate((int) newX);
        this.setyCoordinate((int) newY);
    }

    private static class DefaultColor implements Color, Serializable {
    	
    	private static final long serialVersionUID = 1L;
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
    }

    private static class DefaultStroke implements Stroke, Serializable {
    	
    	private static final long serialVersionUID = 1L;
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
    }

    private static class DefaultStyle implements Style, Serializable {
    	
    	private static final long serialVersionUID = 1L;
    	@Override
        public Color getBackgroundColor() {
            return DEFAULT_COLOR;
        }

        @Override
        public Stroke getStroke() {
            return DEFAULT_STROKE;
        }
    }

    private static class DefaultOvalShape implements OvalShape, Serializable {
    	
    	private static final long serialVersionUID = 1L;
    	@Override
        public int getWidth() {
            return ROBOT_RADIUS;
        }

        @Override
        public int getHeight() {
            return ROBOT_RADIUS;
        }
    }
}
