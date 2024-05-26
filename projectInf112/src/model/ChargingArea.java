package model;

@SuppressWarnings("serial")
/**
 * La classe ChargingArea représente une aire de recharge sur le canvas.
 * Elle hérite de la classe Area et implémente l'interface RectangleShape.
 */
public class ChargingArea extends Area {

	public ChargingArea() {
		super();
	}

	public ChargingArea(int xCoordinate, int yCoordinate, String name, int height, int width) {
		super(xCoordinate, yCoordinate, name, height, width);
	}

}
