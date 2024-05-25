package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import fr.tp.inf112.projects.canvas.model.*;
import pathfinder.Position;

public class Door extends StaticComponent implements Serializable {
	
	private static final Logger LOGGER = Logger.getLogger(Door.class.getName());

	private static final long serialVersionUID = 1L;
	private static final int HEIGHT = 30;
    private static final int WIDTH = 2;
    private boolean vertical;
    private boolean doorOpen;

    private static final Color DEFAULT_COLOR_OFF = new DefaultColorOff();
    private static final Color DEFAULT_COLOR_ON = new DefaultColorOn();

    public Door(int xCoordinate, int yCoordinate, String name, boolean vertical, boolean doorOpen) {
        super(xCoordinate, yCoordinate, name, getDefaultStyle(doorOpen), getDefaultShape(vertical));
        this.vertical = vertical;
        this.doorOpen = doorOpen;
    }

    private static Style getDefaultStyle(boolean doorOpen) {
        return new DefaultStyle(doorOpen);
    }

    private static RectangleShape getDefaultShape(boolean vertical) {
        return new DefaultRectangleShape(vertical);
    }

    @Override
    public RectangleShape getShape() {
        return getDefaultShape(this.vertical);
    }

    public void setDoorOn(boolean doorOpen) {
        this.doorOpen = doorOpen;
    }

    public boolean getDoorOn() {
        return this.doorOpen;
    }
    
    @Override
    public int getWidth() {
    	return Door.WIDTH;
    }
    
    @Override
    public int getHeight() {
    	return Door.HEIGHT;
    }
    
    @Override
    public Set<Position> overlay() {
    	Robot modelRobot = new Robot();
    	int xTopLeftCorner = this.getxCoordinate() - (modelRobot.getRadius()/2);
    	int yTopLeftCorner = this.getyCoordinate() - (modelRobot.getRadius()/2);
    	int xBottomRightCorner = this.getxCoordinate() + this.getWidth() + (modelRobot.getRadius()/2);
    	int yBottomRightCorner = this.getyCoordinate() + this.getHeight() + (modelRobot.getRadius()/2);
    	
    	Set<Position> allowedVertices = new HashSet<>();
    	
    	for(int x = xTopLeftCorner; x <= xBottomRightCorner; x++) {
    		for(int y = yTopLeftCorner; y <= yBottomRightCorner; y++) {
    			allowedVertices.add(new Position(x,y));
    		}
    	}	
    	//LOGGER.info(getName() + "{ size = " + allowedVertices.size() + " }");
    	//LOGGER.info(getName() + "{ size calculated = " + (xBottomRightCorner - xTopLeftCorner)*(yBottomRightCorner - yTopLeftCorner) + " }");
    	return allowedVertices;
    }

    private static class DefaultColorOff implements Color, Serializable {

    	private static final long serialVersionUID = 1L;
    	@Override
        public int getRedComponent() {
            return 100;
        }

        @Override
        public int getGreenComponent() {
            return 100;
        }

        @Override
        public int getBlueComponent() {
            return 200;
        }
    }

    private static class DefaultColorOn implements Color, Serializable {

    	private static final long serialVersionUID = 1L;
    	@Override
        public int getRedComponent() {
            return 180;
        }

        @Override
        public int getGreenComponent() {
            return 180;
        }

        @Override
        public int getBlueComponent() {
            return 255;
        }
    }

    private static class DefaultStyle implements Style, Serializable {

    	private static final long serialVersionUID = 1L;
    	private final boolean doorOpen;

        DefaultStyle(boolean doorOpen) {
            this.doorOpen = doorOpen;
        }

        @Override
        public Color getBackgroundColor() {
            return this.doorOpen ? DEFAULT_COLOR_ON : DEFAULT_COLOR_OFF;
        }

        @Override
        public Stroke getStroke() {
            return new DefaultStroke(this.doorOpen);
        }
    }

    private static class DefaultStroke implements Stroke, Serializable {
        
    	private static final long serialVersionUID = 1L;
    	private final boolean doorOpen;

        DefaultStroke(boolean doorOpen) {
            this.doorOpen = doorOpen;
        }

        @Override
        public Color getColor() {
            return this.doorOpen ? DEFAULT_COLOR_ON : DEFAULT_COLOR_OFF;
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

    private static class DefaultRectangleShape implements RectangleShape, Serializable {
      
    	private static final long serialVersionUID = 1L;
    	private final boolean vertical;

        DefaultRectangleShape(boolean vertical) {
            this.vertical = vertical;
        }

        @Override
        public int getWidth() {
            return this.vertical ? WIDTH : HEIGHT;
        }

        @Override
        public int getHeight() {
            return this.vertical ? HEIGHT : WIDTH;
        }
    }
}
