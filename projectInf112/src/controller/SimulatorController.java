package controller;

import model.Factory;
import persistence.FileCanvasPersistenceManager;
import fr.tp.inf112.projects.canvas.controller.CanvasViewerController;
import fr.tp.inf112.projects.canvas.controller.Observer;
import fr.tp.inf112.projects.canvas.model.Canvas;
import fr.tp.inf112.projects.canvas.model.CanvasPersistenceManager;
import fr.tp.inf112.projects.canvas.view.FileCanvasChooser;


public class SimulatorController implements CanvasViewerController {

    private Factory factoryModel;
    private boolean animationRunning;
    private CanvasPersistenceManager persistenceManager;

    public SimulatorController(Factory factoryModel) {
        this.factoryModel = factoryModel;
        this.animationRunning = false;
        this.persistenceManager = new FileCanvasPersistenceManager(new FileCanvasChooser("canvas", "Canvas"));
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
                Thread.sleep(200);
            } catch (InterruptedException ex) {
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
        if (canvasModel instanceof Factory) {
            this.factoryModel = (Factory) canvasModel;
        } else {
            throw new IllegalArgumentException("Invalid Canvas model");
        }
    }

    @Override
    public CanvasPersistenceManager getPersistenceManager() {
        return this.persistenceManager;
    }
}
