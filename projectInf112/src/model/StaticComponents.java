package model;

import fr.tp.inf112.projects.canvas.model.Shape;
import fr.tp.inf112.projects.canvas.model.Style;

public abstract class StaticComponents extends Components {

	public StaticComponents() {
		super();
	}

	public StaticComponents(int xCoordinate, int yCoordinate, String name, Style style, Shape shape) {
		super(xCoordinate, yCoordinate, name, style, shape);
	}

}
