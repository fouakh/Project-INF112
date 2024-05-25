package model;

import java.io.Serializable;
import java.util.Set;

import fr.tp.inf112.projects.canvas.model.*;
import pathfinder.Position;

public class Puck extends MovingComponent implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final int ROBOT_RADIUS = 2;
    @SuppressWarnings("unused")
	private boolean onRobot;

    private static final Color DEFAULT_COLOR = new DefaultColor();

    private static final Stroke DEFAULT_STROKE = new DefaultStroke();    

    public Puck(int xCoordinate, int yCoordinate, String name, int timeDelay) {
        super(xCoordinate, yCoordinate, name, getDefaultStyle(), getDefaultShape(), timeDelay);
        this.onRobot = false;
    }
    
    private static Style getDefaultStyle() {
        return new DefaultStyle();
    }

    private static OvalShape getDefaultShape() {
        return new DefaultOvalShape();
    }
    
    public void setPuckOn(boolean onRobot) {
        this.onRobot = onRobot;
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

    private static class DefaultColor implements Color, Serializable {
        
		private static final long serialVersionUID = 1L;
		@Override
        public int getRedComponent() {
            return 0;
        }

        @Override
        public int getGreenComponent() {
            return 0;
        }

        @Override
        public int getBlueComponent() {
            return 0;
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

	@Override
	public Set<Position> overlay() {
		return null;
	}
}
