package test;

import fr.tp.inf112.projects.canvas.view.CanvasViewer;

import java.util.logging.Logger;
import java.util.Arrays;

import implement.*;
import controller.*;

public class SimulatorApplication {

	private static final Logger LOGGER = Logger.getLogger(SimulatorApplication.class.getName());
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		//System.setProperty("java.util.logging.config.file", "config/logging.properties");
		LOGGER.info("Starting the robot simulator...");
        LOGGER.config("With parameters " + Arrays.toString(args) + ".");
        
		Application app = new Application();
		SimulatorController controller = new SimulatorController(app.getFactory());
        CanvasViewer canvasViewer = new CanvasViewer(controller);
        controller.addObserver(canvasViewer);
        
        canvasViewer.show();
    }
	
}
