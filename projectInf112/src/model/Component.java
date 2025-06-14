/**
 * 
 */
package model;

import pathfinder.Position;

import java.io.Serializable;
import java.util.Set;
import java.util.logging.Logger;
import fr.tp.inf112.projects.canvas.model.*;

/**
 * La classe Component représente un élément graphique abstrait sur le canvas.
 * Un élément graphique a une position, un nom, un style et une forme spécifiques,
 * ainsi qu'une référence à une factory pour les notifications.
 */
public abstract class Component implements Figure, Serializable  {
	
	/**
     * Logger pour les messages de debug et d'erreur.
     */
	public static final Logger LOGGER = Logger.getLogger(Component.class.getName());
	
	private static final long serialVersionUID = 1L;
	private Position position;
	private String name;
	private Style style;
	private Shape shape;
	private transient Factory factoryModel;
	
	public Component() {
		this.position = new Position(0,0);
		this.name = "none";
	}
	
	public Component(int xCoordinate, int yCoordinate, String name, Style style, Shape shape) {
		this.position = new Position(xCoordinate, yCoordinate);
		this.name = name;
		this.style = style;
		this.shape = shape;
	}
	
	public void setxCoordinate(int xCoordinate) {
		this.position.setxCoordinate(xCoordinate);
	}
	
	public void setyCoordinate(int yCoordinate) {
		this.position.setyCoordinate(yCoordinate);
	}
	
	public Position getPosition() {
		return this.position;
	}
	
	@Override
	public int getxCoordinate() {
		return this.position.getxCoordinate();
    }

	@Override
    public int getyCoordinate() {
		return this.position.getyCoordinate();
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
    
    /**
     * Méthode abstraite qui définit le comportement de l'élément graphique.
     */
    public void behave() {
    	//
    }
    
    public abstract Set<Position> overlay();
    
}
