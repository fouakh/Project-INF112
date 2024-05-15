package controller;

import model.Factory;

import java.io.IOException;

import fr.tp.inf112.projects.canvas.controller.CanvasViewerController;
import fr.tp.inf112.projects.canvas.controller.Observer;
import fr.tp.inf112.projects.canvas.model.Canvas;
import fr.tp.inf112.projects.canvas.model.CanvasPersistenceManager;

public class SimulatorController implements CanvasViewerController {

    private Factory factoryModel;
    private boolean animationRunning;

    public SimulatorController(Factory factoryModel) {
        this.factoryModel = factoryModel;
        this.animationRunning = false;
    }

	@Override
	public Canvas getCanvas() {
		return factoryModel;
	}

	@Override
	public void startAnimation() {
		factoryModel.startSimulation();
		animationRunning = true;
		
		while (factoryModel.isSimulationStarted()) {
			factoryModel.behave();
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		
	}

	@Override
	public void stopAnimation() {
		animationRunning = false;
        factoryModel.stopSimulation();
		
	}

	@Override
	public boolean isAnimationRunning() {
		return this.animationRunning;
	}

	@Override
    public boolean addObserver(Observer observer) {
        return this.factoryModel.addObserver(observer);
    }

    @Override
    public boolean removeObserver(Observer observer) {
    	return this.factoryModel.removeObserver(observer);
    }

	@Override
	public void setCanvas(Canvas canvasModel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CanvasPersistenceManager getPersistenceManager() {
		// TODO Auto-generated method stub
		return null;
	}

  
}

