package model;


@SuppressWarnings("serial")
/**
 * La classe PackagingArea représente une zone de conditionnement sur le canvas.
 * Elle hérite de la classe Area.
 */
public class PackagingArea extends Area {

	public PackagingArea() {
		super();
	}

	public PackagingArea(int xCoordinate, int yCoordinate, String name, int height, int width) {
		super(xCoordinate, yCoordinate, name, height, width);
	}

}
