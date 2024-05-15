package model;

import fr.tp.inf112.projects.canvas.model.*;

public class Door extends StaticComponents {

    private static final int HEIGHT = 30;
    private static final int WIDTH = 2;
    private boolean vertical;
    private boolean doorOpen;

    private static final Color DEFAULT_COLOR_OFF = new Color() {
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
    };

    private static final Color DEFAULT_COLOR_ON = new Color() {
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
    };

    public Door(int xCoordinate, int yCoordinate, String name, boolean vertical, boolean doorOpen) {
        super(xCoordinate, yCoordinate, name, getDefaultStyle(doorOpen), getDefaultShape(vertical));
        this.vertical = vertical;
        this.doorOpen = doorOpen;
    }

    private static Style getDefaultStyle(boolean doorOpen) {
        return new Style() {
            @Override
            public Color getBackgroundColor() {
                return doorOpen ? DEFAULT_COLOR_ON : DEFAULT_COLOR_OFF;
            }

            @Override
            public Stroke getStroke() {
                return new Stroke() {
                    @Override
                    public Color getColor() {
                        return doorOpen ? DEFAULT_COLOR_ON : DEFAULT_COLOR_OFF;
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
            }
        };
    }

    private static RectangleShape getDefaultShape(boolean vertical) {
        return new RectangleShape() {
            @Override
            public int getWidth() {
                return vertical ? WIDTH : HEIGHT;
            }

            @Override
            public int getHeight() {
                return vertical ? HEIGHT : WIDTH;
            }
        };
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

}
