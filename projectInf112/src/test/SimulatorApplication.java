package test;

import fr.tp.inf112.projects.canvas.view.CanvasViewer;

import implement.*;
import controller.*;

public class SimulatorApplication {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
        
		Application app = new Application();
		SimulatorController controller = new SimulatorController(app.getFactory());
        CanvasViewer canvasViewer = new CanvasViewer(controller);
        controller.addObserver(canvasViewer);
        
        canvasViewer.show();
    }
	
}
