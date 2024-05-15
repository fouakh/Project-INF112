package model;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

import fr.tp.inf112.projects.canvas.model.*;
import fr.tp.inf112.projects.canvas.controller.*;
/**
 * 
 */
public class Factory implements Canvas, Observable {

	private static final int HEIGHT = 200;
	private static final int WIDTH = 400;
	private static final String NAME = "Factory";
	private static final Color DEFAULT_COLOR = null;
	private static final Stroke DEFAULT_STROKE = null;
	
	
	private List<Components> factoryComponents;
	private List<Observer> factoryObservers;
	private boolean simulationStarted;

    public Factory() {
        this.factoryComponents = new ArrayList<>();
        this.factoryObservers = new ArrayList<>();
        this.simulationStarted = false;
    }

    
    public void addComponent(Components component) {
        factoryComponents.add(component);
    }

    public boolean removeComponent(Components component) {
        return factoryComponents.remove(component);
    }
    
    public List<Components> getComponents() {
        return java.util.Collections.unmodifiableList(factoryComponents);
    }
    
    @Override
    public Collection<Figure> getFigures() {
        List<Figure> figures = new ArrayList<>();
        for (Components component : factoryComponents) {
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
        for (Components component : factoryComponents) {
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
    	//System.out.println(this.factoryObservers.size());
        for (Observer observer : this.factoryObservers) {
            observer.modelChanged();
        }
    }


	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
	}

}
