package model;

import java.io.Serializable;

import fr.tp.inf112.projects.canvas.model.*;

/**
 * La classe MovingComponent représente un composant mobile sur le canvas.
 * Elle hérite de la classe Component et implémente l'interface Serializable.
 * Un composant mobile a une vitesse et un délai de temps.

 */
public abstract class MovingComponent extends Component implements Serializable {

	private static final long serialVersionUID = 1L;
	//vitesse horizontale et verticale
	private float speedX;
    private float speedY;
    private final int timeDelay;

    /**
     * Constructeur de la classe MovingComponent qui initialise la vitesse horizontale, la vitesse verticale et le délai
     * de temps à 0.
     */
    public MovingComponent() {
        super(); 
        this.speedX = 0.0f;
        this.speedY = 0.0f;
        this.timeDelay = 0;
    }
    
    /**
     * Constructeur de la classe MovingComponent qui initialise le composant mobile.
     *
     * @param xCoordinate Coordonnée x du composant mobile.
     * @param yCoordinate Coordonnée y du composant mobile.
     * @param name Nom du composant mobile.
     * @param style Style du composant mobile.
     * @param shape Forme du composant mobile.
     * @param timeDelay Délai de temps du composant mobile.
     */
    public MovingComponent(int xCoordinate, int yCoordinate, String name, Style style, Shape shape, int timeDelay) {
        super(xCoordinate, yCoordinate, name, style, shape);
        this.timeDelay = timeDelay;
    }
    //getter et setter
    public float getSpeedX() {
        return speedX;
    }

    public float getSpeedY() {
        return speedY;
    }

    public int getTimeDelay() {
        return timeDelay;
    }

    public void setSpeedX(float speedX) {
        this.speedX = speedX;
        setFactoryNotify();
    }

    public void setSpeedY(float speedY) {
        this.speedY = speedY;
        setFactoryNotify();
    }

}
