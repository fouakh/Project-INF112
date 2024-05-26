package model;

import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import pathfinder.Position;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.io.Serializable;
import java.io.IOException;
import java.io.ObjectInputStream;

import fr.tp.inf112.projects.canvas.model.*;
import fr.tp.inf112.projects.canvas.controller.*;

@SuppressWarnings("serial")
public class Factory implements Canvas, Observable, Serializable {
	
	@SuppressWarnings("unused")
	private static final Logger LOGGER = Logger.getLogger(Factory.class.getName());

	private static final int HEIGHT = 200;
	private static final int WIDTH = 400;
	private static final String NAME = "Factory";
	private static final Color DEFAULT_COLOR = null;
	private static final Stroke DEFAULT_STROKE = null;
	private String id;
	
	private List<Component> factoryComponents;
	//private transient List<Components> factoryComponents;
	private transient List<Observer> factoryObservers;
	private boolean simulationStarted;

    public Factory() {
        this.factoryComponents = new ArrayList<>();
        this.factoryObservers = new ArrayList<>();
        this.simulationStarted = false;
    }

    
    public void addComponent(Component component) {
        factoryComponents.add(component);
    }

    public boolean removeComponent(Component component) {
        return factoryComponents.remove(component);
    }
    
    public List<Component> getComponents() {
        return java.util.Collections.unmodifiableList(factoryComponents);
    }
    
    @Override
    public Collection<Figure> getFigures() {
        List<Figure> figures = new ArrayList<>();
        for (Component component : factoryComponents) {
            figures.add(component);
        }
        return figures;
    }
    
    @Override
    public int getWidth() {
    	return WIDTH;
    }
    
    @Override 
    public int getHeight() {
    	return HEIGHT;
    }
    
    @Override
    public Style getStyle (){
        return new Style() {
            @Override
            public Color getBackgroundColor() {
                return DEFAULT_COLOR;
            }

            @Override
            public Stroke getStroke() {
                return DEFAULT_STROKE;
            }
        };
    }
    
    @Override
    public String getName() {
    	return NAME;
    }
    
    public void behave() {
        for (Component component : factoryComponents) {
            component.behave();
        }
        notifyObservers();
    }

    public void startSimulation() {
        this.simulationStarted = true;
        notifyObservers();
    }

    public void stopSimulation() {
        this.simulationStarted = false;
        notifyObservers();
    }

    public boolean isSimulationStarted() {
        return simulationStarted;
    }

    @Override
    public boolean addObserver(Observer observer) {
        return this.factoryObservers.add(observer);
    }

    @Override
    public boolean removeObserver(Observer observer) {
    	return this.factoryObservers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : this.factoryObservers) {
            observer.modelChanged();
        }
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }
    
    public Set<Position> allOverlay() {   	
    	Set<Position> union = new HashSet<>();
		for(Component component : factoryComponents) {
			Set<Position> overlaySet = component.overlay();
	        if (overlaySet != null) {
	        	union.addAll(overlaySet);
	        }
		}
    	return union;
    }

    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
        ois.defaultReadObject();
        this.factoryObservers = new ArrayList<>(); 
    }
}
