package implement;

import model.*;
import pathfinder.FactoryToGraph;

import java.util.List;
import java.util.ArrayList;

public class Application {

	private Factory factory;
	
    private Room room1, room2, room3, room4;
    private PackagingArea packagingArea1;
    private ChargingArea chargingArea1;
    private Area sortingArea1, stockDeliveryArea1, stock1;
    private Booth booth1, booth2;
    private ChargingArea chargingArea2;
    private Door door1, door2, door3, door4;
    private Robot robot1;
    
    private List<Component> componentsToVisitByRobot1;
    
    private FactoryToGraph factoryGraph;

    public Application() {
    	
        factory = new Factory();
        factoryGraph = new FactoryToGraph(factory);
        
        componentsToVisitByRobot1 = new ArrayList<>();
        
        room1 = new Room(10, 10, "Packaging Room", 90, 170);
        room2 = new Room(180, 10, "Sorting Room", 90, 210);
        room3 = new Room(10, 100, "Stock Room", 90, 220);
        room4 = new Room(230, 100, "Delivery Room", 90, 160);
        
        packagingArea1 = new PackagingArea(30, 40, "Packaging Area", 40, 40);
        chargingArea1 = new ChargingArea(155, 25, "Charging Point", 30, 20);
        sortingArea1 = new Area(220, 25, "Sorting Area", 40, 40);
        booth1 = new Booth(365, 10, "Booth I", 45, 20);
        booth2 = new Booth(365, 55, "Booth II", 45, 20);
        stockDeliveryArea1 = new Area(340, 100, "Stock Delivery Area", 50, 50);
        stock1 = new Area(15, 135, "Stock Delivery Area", 50, 80);
        chargingArea2 = new ChargingArea(195, 105, "Charging Point", 20, 30);
        
        door1 = new Door(179, 65, "Door 1", true, true);
        door2 = new Door(20, 99, "Door 2", false, true);
        door3 = new Door(229, 150, "Door 3", true, true);
        door4 = new Door(240, 99, "Door 4", false, true);
      
        
        factory.addComponent(room1);
    	factory.addComponent(room2); 
    	factory.addComponent(room3); 
    	factory.addComponent(room4);
    	
    	factory.addComponent(packagingArea1);
    	factory.addComponent(chargingArea1);
    	factory.addComponent(sortingArea1);
    	factory.addComponent(booth1);
    	factory.addComponent(booth2);
    	factory.addComponent(stockDeliveryArea1);
    	factory.addComponent(stock1);
    	factory.addComponent(chargingArea2);
    	
    	factory.addComponent(door1);
    	factory.addComponent(door2);
    	factory.addComponent(door3);
    	factory.addComponent(door4);
    	
    	componentsToVisitByRobot1.add(this.stock1);
    	componentsToVisitByRobot1.add(this.chargingArea2);
    	componentsToVisitByRobot1.add(this.sortingArea1);
    	componentsToVisitByRobot1.add(this.chargingArea1);
    	componentsToVisitByRobot1.add(this.stockDeliveryArea1);
    	//robot1 = new Robot(20, 20, "Robot 1", 1, componentsToVisitByRobot1, factoryGraph);
    	robot1 = new Robot(20, 120, "Robot 1", 1, componentsToVisitByRobot1, factoryGraph);
    	
    	factory.addComponent(robot1);
    	
    }
	
	public Factory getFactory() {
		return this.factory;
	}
	
}
