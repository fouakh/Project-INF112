package model;

import fr.tp.inf112.projects.canvas.model.*;

public class Room extends StaticComponents {

	private int height;
	private int width;
	private static final Stroke DEFAULT_STROKE = new Stroke() {
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
    };
    
	
	public Room() {
		super();
	}

	public Room(int centerX, int centerY, String name, int height, int width) {
		super(centerX, centerY, name, getDefaultStyle(), getDefaultShape(height, width));
		this.height = height;
		this.width = width;
		// TODO Auto-generated constructor stub
	}
    
    private static Style getDefaultStyle() {
        return new Style() {
            @Override
            public Color getBackgroundColor() {
                return null;
            }

            @Override
            public Stroke getStroke() {
                return DEFAULT_STROKE;
            }
        };
    }
    
    private static RectangleShape getDefaultShape(int width, int height) {
        return new RectangleShape() {
            @Override
            public int getWidth() {
                return width;
            }

            @Override
            public int getHeight() {
                return height;
            }
        };
    }
    
    @Override
    public Style getStyle() {
        return getDefaultStyle();
    }
    
    @Override
    public RectangleShape getShape() {
        return getDefaultShape(this.height, this.width);
    }
}
