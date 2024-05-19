package model;

import java.io.Serializable;
import fr.tp.inf112.projects.canvas.model.*;

public class Room extends StaticComponent implements Serializable {

	private static final long serialVersionUID = 1L;
	private int height;
    private int width;
    private static final Stroke DEFAULT_STROKE = new DefaultStroke();

    public Room() {
        super();
    }

    public Room(int centerX, int centerY, String name, int height, int width) {
        super(centerX, centerY, name, getDefaultStyle(), getDefaultShape(height, width));
        this.height = height;
        this.width = width;
    }

    private static Style getDefaultStyle() {
        return new DefaultStyle();
    }

    private static RectangleShape getDefaultShape(int width, int height) {
        return new DefaultRectangleShape(width, height);
    }

    @Override
    public Style getStyle() {
        return getDefaultStyle();
    }

    @Override
    public RectangleShape getShape() {
        return getDefaultShape(this.height, this.width);
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }
    
    private static class DefaultStroke implements Stroke, Serializable {
        
		private static final long serialVersionUID = 1L;

		@Override
        public Color getColor() {
            return null;
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
            return null;
        }

        @Override
        public Stroke getStroke() {
            return DEFAULT_STROKE;
        }
    }

    private static class DefaultRectangleShape implements RectangleShape, Serializable {
 
		private static final long serialVersionUID = 1L;
		private final int width;
        private final int height;

        DefaultRectangleShape(int width, int height) {
            this.width = width;
            this.height = height;
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
}
