/**
 * 
 */
package model;

import java.io.Serializable;
import fr.tp.inf112.projects.canvas.model.*;

/**
 * 
 */
public abstract class Components implements Figure, Serializable  {

	private static final long serialVersionUID = 1L;
	private int xCoordinate;
	private int yCoordinate;
	private String name;
	private Style style;
	private Shape shape;
	private transient Factory factoryModel;
	
	public Components() {
		this.xCoordinate = 0;
		this.yCoordinate = 0;
		this.name = "none";
	}
	
	public Components(int xCoordinate, int yCoordinate, String name, Style style, Shape shape) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
		this.name = name;
		this.style = style;
		this.shape = shape;
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
