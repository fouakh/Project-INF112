package model;

import java.io.Serializable;
import fr.tp.inf112.projects.canvas.model.Shape;
import fr.tp.inf112.projects.canvas.model.Style;

/**
 * La classe StaticComponent représente un composant statique sur le canvas.
 * Elle hérite de la classe Component et implémente l'interface Serializable.
 * Un composant statique a une largeur et une hauteur.
 */
public abstract class StaticComponent extends Component implements Serializable {

	private static final long serialVersionUID = 1L;

	public StaticComponent() {
		super();
	}

	public StaticComponent(int xCoordinate, int yCoordinate, String name, Style style, Shape shape) {
		super(xCoordinate, yCoordinate, name, style, shape);
	}

	public abstract int getWidth();
    
    public abstract int getHeight();
	
}
