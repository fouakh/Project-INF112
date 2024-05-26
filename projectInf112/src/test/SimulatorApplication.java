package test;

import fr.tp.inf112.projects.canvas.view.CanvasViewer;

import java.util.logging.Logger;
import java.util.Arrays;

import implement.*;
import controller.*;


/**
 * La classe SimulatorApplication crée une instance de l'application, un contrôleur de simulation et une vue de canvas, puis les relie ensemble.
 */
public class SimulatorApplication {

	/**
     * Logger pour enregistrer les messages de l'application.
     */
	private static final Logger LOGGER = Logger.getLogger(SimulatorApplication.class.getName());
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		// Configuration du logging
		//System.setProperty("java.util.logging.config.file", "config/logging.properties");
		LOGGER.info("Starting the robot simulator...");
        LOGGER.config("With parameters " + Arrays.toString(args) + ".");
        
        // Début de l'application
		Application app = new Application();
		SimulatorController controller = new SimulatorController(app.getFactory());
        CanvasViewer canvasViewer = new CanvasViewer(controller);
        controller.addObserver(canvasViewer);
        
        canvasViewer.show();
    }
	
}
