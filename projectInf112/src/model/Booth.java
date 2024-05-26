package model;

@SuppressWarnings("serial")

/**
 * La classe Booth représente un poste de travail sur le canvas.
*/
public class Booth extends Area {

	public Booth() {
		super();
	}

	public Booth(int xCoordinate, int yCoordinate, String name, int height, int width) {
		super(xCoordinate, yCoordinate, name, height, width);
	}

}
