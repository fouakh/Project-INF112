package model;

import pathfinder.*;

import java.io.Serializable;
import java.util.List;
import fr.tp.inf112.projects.canvas.model.*;

public class Robot extends MovingComponent implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
    private List<Component> componentsToVisit;
    private int currentComponentIndex;
    
    private IFactoryPathFinder factoryPathFinder;
    private List<Position> currentPath;
    private int currentPathIndex;
    
    private static final int ROBOT_RADIUS = 10;
 
    @SuppressWarnings("unused")
	private boolean puckOn;

    private static final Color DEFAULT_COLOR = new DefaultColor();

    private static final Stroke DEFAULT_STROKE = new DefaultStroke();    

    public Robot(int xCoordinate, 
    		int yCoordinate, 
    		String name, 
    		int timeDelay, 
    		List<Component> componentsToVisit,
    		FactoryToGraph factoryGraph) {
    	
        super(xCoordinate, yCoordinate, name, getDefaultStyle(), getDefaultShape(), timeDelay);
        this.puckOn = false;
        this.currentComponentIndex = 0;
        this.currentPathIndex = 0;
        this.componentsToVisit = componentsToVisit;
        this.factoryPathFinder = new FactoryPathFinder(factoryGraph);
    }
    
    private static Style getDefaultStyle() {
        return new DefaultStyle();
    }

    private static OvalShape getDefaultShape() {
        return new DefaultOvalShape();
    }
    
    public void setComponentsToVisit(List<Component> componentsToVisit) {
        this.componentsToVisit = componentsToVisit;
    }
    
    public void setPuckOn(boolean puckOn) {
        this.puckOn = puckOn;
        setFactoryNotify();
    }
    
    public int getRadius() {
    	return ROBOT_RADIUS;
    }
 
    @Override
    public Style getStyle() {
        return getDefaultStyle();
    }

    @Override
    public OvalShape getShape() {
        return getDefaultShape();
    }

    private void calculatePath() {
    	Component nextComponent = componentsToVisit.get(currentComponentIndex);
        currentPath = factoryPathFinder.findPath(this.getPosition(), nextComponent.getPosition());
        currentComponentIndex = (currentComponentIndex + 1) % componentsToVisit.size();
        currentPathIndex = 0;
    }

    @Override
    public void behave() {
        if (componentsToVisit.isEmpty()) {
            return;
        }
        if (currentPath == null || currentPathIndex >= currentPath.size()) {
            calculatePath();
        }
        if (currentPath != null && currentPathIndex < currentPath.size()) {
            Position nextPosition = currentPath.get(currentPathIndex);
            this.setxCoordinate(nextPosition.getxCoordinate());
            this.setyCoordinate(nextPosition.getyCoordinate());
            currentPathIndex++;
        }
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
