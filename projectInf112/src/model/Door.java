package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import fr.tp.inf112.projects.canvas.model.*;
import pathfinder.Position;


/**
 * La classe Door représente une porte sur le canvas.
 * Elle hérite de la classe StaticComponent et implémente l'interface Serializable.
 * Une porte a une position, un nom, une orientation (verticale ou horizontale),
 * une couleur de fond, un style de bordure et une forme spécifiques.
 * Elle peut être ouverte ou fermée.
 */
public class Door extends StaticComponent implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final int HEIGHT = 30;
    private static final int WIDTH = 2;
    private boolean vertical;
    private boolean doorOpen;
    
    /**
     * Couleur de fond par défaut de la porte.
     */
    private static final Color DEFAULT_COLOR_OFF = new DefaultColorOff();
    private static final Color DEFAULT_COLOR_ON = new DefaultColorOn();

    public Door(int xCoordinate, int yCoordinate, String name, boolean vertical, boolean doorOpen) {
        super(xCoordinate, yCoordinate, name, getDefaultStyle(doorOpen), getDefaultShape(vertical));
        this.vertical = vertical;
        this.doorOpen = doorOpen;
    }
    /**
     * Renvoie le style par défaut de la porte en fonction de son état.
     *
     * @param doorOpen Indique si la porte est ouverte ou fermée.
     * @return Le style par défaut de la porte.
     */
    private static Style getDefaultStyle(boolean doorOpen) {
        return new DefaultStyle(doorOpen);
    }

    /**
     * Renvoie la forme par défaut de la porte en fonction de son orientation.
     *
     * @param vertical Indique si la porte est verticale ou horizontale.
     * @return La forme par défaut de la porte.
     */
    private static RectangleShape getDefaultShape(boolean vertical) {
        return new DefaultRectangleShape(vertical);
    }

    /**
     * Renvoie la forme de la porte.
     *
     * @return La forme de la porte.
     */
    @Override
    public RectangleShape getShape() {
        return getDefaultShape(this.vertical);
    }

    /**
     * Définit l'état de la porte.
     *
     * @param doorOpen Indique si la porte est ouverte ou fermée.
     */
    public void setDoorOn(boolean doorOpen) {
        this.doorOpen = doorOpen;
    }

    /**
     * Renvoie l'état de la porte.
     *
     * @return L'état de la porte.
     */
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
    	int xTopLeftCorner;
    	int yTopLeftCorner;
    	int xBottomRightCorner;
    	int yBottomRightCorner;
    	
    	if(vertical) {
    		xTopLeftCorner = this.getxCoordinate() - modelRobot.getRadius();
            yTopLeftCorner = this.getyCoordinate();
            xBottomRightCorner = this.getxCoordinate() + this.getWidth();
            yBottomRightCorner = this.getyCoordinate() + this.getHeight() - modelRobot.getRadius();
    	}
    	else {
    		xTopLeftCorner = this.getxCoordinate();
            yTopLeftCorner = this.getyCoordinate() - modelRobot.getRadius();
            xBottomRightCorner = this.getxCoordinate() + this.getHeight() - modelRobot.getRadius();
            yBottomRightCorner = this.getyCoordinate() + this.getWidth();
    	}
    	
    	Set<Position> allowedVertices = new HashSet<>();
    	
    	for(int x = xTopLeftCorner; x <= xBottomRightCorner; x++) {
    		for(int y = yTopLeftCorner; y <= yBottomRightCorner; y++) {
    			allowedVertices.add(new Position(x,y));
    		}
    	}	
    	return allowedVertices;
    }
    // sous classe privée pour déinir la couleur par défaut de la porte sous code RGB à  (100,100,100)
    //porte fermee
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
    //porte ouverte
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
    //la forme de la porte par défaut est un rectangle 
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
