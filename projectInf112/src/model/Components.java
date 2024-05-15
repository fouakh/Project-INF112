/**
 * 
 */
package model;

import fr.tp.inf112.projects.canvas.model.*;

/**
 * 
 */
public abstract class Components implements Figure{

	private int xCoordinate;
	private int yCoordinate;
	private String name;
	private int id;
	private Style style;
	private Shape shape;
	private Factory factoryModel;
	
	private static int lastId = 0;
	
	public Components() {
		this.xCoordinate = 0;
		this.yCoordinate = 0;
		this.name = "none";
		this.id = ++lastId;
	}
	
	public Components(int xCoordinate, int yCoordinate, String name, Style style, Shape shape) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.name = name;
		this.style = style;
		this.shape = shape;
		this.id = ++lastId;
	}
	
	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	
	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	
	@Override
	public int getxCoordinate() {
        return this.xCoordinate;
    }

	@Override
    public int getyCoordinate() {
        return this.yCoordinate;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }
    
    @Override
    public Style getStyle() {
    	return this.style;
    }
    
    @Override
    public Shape getShape() {
    	return this.shape;
    }
    
    public void setFactoryNotify() {
    	factoryModel.notifyObservers();
    }
    
    public void behave() {
    	//
    }
}
