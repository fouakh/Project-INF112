package model;

import fr.tp.inf112.projects.canvas.model.*;

public class Puck extends MovingComponents {
    // Additional variables specific to Robot can be declared here
    private static final int ROBOT_RADIUS = 2;
    private boolean onRobot;
    
    private static final Color DEFAULT_COLOR = new Color() {
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

    public Puck(int xCoordinate, int yCoordinate, String name, int timeDelay) {
        super(xCoordinate, yCoordinate, name, getDefaultStyle(), getDefaultShape(), timeDelay); // Pass null for Style and Shape
        this.onRobot = false;
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

}
