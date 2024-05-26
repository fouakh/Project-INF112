package model;

import java.io.Serializable;
import java.util.Set;
import fr.tp.inf112.projects.canvas.model.*;
import pathfinder.Position;

/**
 * La classe Area représente une zone statique sur le canvas.
 * Une zone a une largeur et une hauteur spécifiques, ainsi qu'un style et une forme par défaut.
 */
public class Area extends StaticComponent implements Serializable {

	private static final long serialVersionUID = 1L;
	private int height;
    private int width;
    /**
     * Le style par défaut de la zone.
     */
    private static final Stroke DEFAULT_STROKE = new DefaultStroke();

    public Area() {
        super();
    }
    /**
     * Constructeur de la classe Area qui définit la position, le nom, la hauteur et la largeur de la zone.
     *
     * @param xCoordinate La coordonnée x de la position de la zone.
     * @param yCoordinate La coordonnée y de la position de la zone.
     * @param name Le nom de la zone.
     * @param height La hauteur de la zone.
     * @param width La largeur de la zone.
     */
    public Area(int xCoordinate, int yCoordinate, String name, int height, int width) {
        super(xCoordinate, yCoordinate, name, getDefaultStyle(), getDefaultShape(height, width));
        this.height = height;
        this.width = width;
    }

    private static Style getDefaultStyle() {
        return new DefaultStyle();
    }

    private static RectangleShape getDefaultShape(int height, int width) {
        return new DefaultRectangleShape(height, width);
    }

    @Override
    public Style getStyle() {
        return getDefaultStyle();
    }

    @Override
    public RectangleShape getShape() {
        return getDefaultShape(this.height, this.width);
    }
    
    private static class DefaultStroke implements Stroke, Serializable {

    	private static final long serialVersionUID = 1L;
		@Override
        public Color getColor() {
            return null;
        }
		//épaisseur
        @Override
        public float getThickness() {
            return 1.0f;
        }
       
        /**
         * Retourne le motif de trait par défaut.
         *
         * @return Le motif de trait par défaut.
         */
        @Override
        public float[] getDashPattern() {
            return new float[]{3.0f, 3.0f};
        }
    }
    
    /**
     * Classe interne qui représente le style par défaut de la zone.
     */
    private static class DefaultStyle implements Style, Serializable {

    	private static final long serialVersionUID = 1L;
		@Override
        public Color getBackgroundColor() {
            return null;
        }

        @Override
        public Stroke getStroke() {
            return DEFAULT_STROKE;
        }
    }
    
    /**
     * Classe interne qui représente la forme réctangle par défaut de la zone.
     */
    private static class DefaultRectangleShape implements RectangleShape, Serializable {
        
    	private static final long serialVersionUID = 1L;
    	private final int width;
        private final int height;

        DefaultRectangleShape(int height, int width) {
        	this.height = height;
            this.width = width;
        }

        @Override
        public int getWidth() {
            return this.width;
        }

        @Override
        public int getHeight() {
            return this.height;
        }
    }

	@Override
	public int getWidth() {
		return this.width;
	}

	@Override
	public int getHeight() {
		return this.height;
	}

	@Override
	public Set<Position> overlay() {
		return null;
	}
}
