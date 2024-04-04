import java.util.List;
import java.util.ArrayList;
/**
 * The Factory class represents a manufacturing facility with the ability to store
 * and manage a collection of components. It allows adding and removing components
 * to the facility, and provides a way to access the current list of components.
 * This class is designed as part of a larger system to simulate a factory's operations.
 */
public class Factory {
    
    private List<Component> factoryComponents;

    /**
     * Constructor for objects of class Factory
     */
    public Factory() {
        // Initialize the instance variable
        this.factoryComponents = new ArrayList<>();
    }

    /**
     * Adds a Component to the factoryComponents list.
     *
     * @param component The Component to be added.
     */
    public void addComponent(Component component) {
        factoryComponents.add(component);
    }

    /**
     * Removes a Component from the factoryComponents list.
     *
     * @param component The Component to be removed.
     * @return true if this list contained the specified element.
     */
    public boolean removeComponent(Component component) {
        return factoryComponents.remove(component);
    }

    /**
     * Gets the list of Components in the Factory.
     *
     * @return An unmodifiable list of factoryComponents.
     */
    public List<Component> getComponents() {
        // Returning an unmodifiable list to ensure encapsulation and data integrity.
        return java.util.Collections.unmodifiableList(factoryComponents);
    }
}
