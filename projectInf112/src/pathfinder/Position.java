package pathfinder;

import java.io.Serializable;
import java.util.Objects;

/**
 * La classe Position représente un point dans un plan à deux dimensions avec des coordonnées x et y.
 */
public class Position implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int xCoordinate;
	private int yCoordinate;
	
	
	public Position(int xCoordinate, int yCoordinate) {
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}
	
	public int getxCoordinate() {
		return xCoordinate;
	}
	
	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}
	
	public int getyCoordinate() {
		return yCoordinate;
	}
	
	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	
	@Override
    public String toString() {
        return "Position{" +
                "xCoordinate=" + xCoordinate +
                ", yCoordinate=" + yCoordinate +
                '}';
    }

	//égalité profonde
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (xCoordinate != position.xCoordinate) return false;
        return yCoordinate == position.yCoordinate;
    }
	//retourne un hash du point 
    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate);
    }
	
}
