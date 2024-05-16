package model;

import java.io.Serializable;
import fr.tp.inf112.projects.canvas.model.*;

public class Door extends StaticComponents implements Serializable {

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
