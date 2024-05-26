package controller;

import model.Factory;
import persistence.FileCanvasPersistenceManager;
import fr.tp.inf112.projects.canvas.controller.CanvasViewerController;
import fr.tp.inf112.projects.canvas.controller.Observer;
import fr.tp.inf112.projects.canvas.model.Canvas;
import fr.tp.inf112.projects.canvas.model.CanvasPersistenceManager;
import fr.tp.inf112.projects.canvas.view.FileCanvasChooser;

/**
 * La classe SimulatorController est responsable de la simulation d'un canvas.
 * Elle implémente l'interface CanvasViewerController et utilise un objet Factory pour créer et gérer le canvas.
 */

public class SimulatorController implements CanvasViewerController {

    private Factory factoryModel;
    private boolean animationRunning;
    /**
     * L'objet CanvasPersistenceManager utilisé pour enregistrer et charger le canvas.
     */
    private CanvasPersistenceManager persistenceManager;

    /**
     * Construit un nouvel objet SimulatorController avec l'objet Factory spécifié.
     *
     * @param factoryModel L'objet Factory utilisé pour créer et gérer le canvas.
     */
    public SimulatorController(Factory factoryModel) {
        this.factoryModel = factoryModel;
        this.animationRunning = false;
        this.persistenceManager = new FileCanvasPersistenceManager(new FileCanvasChooser("canvas", "Canvas"));
    }

    @Override
    public Canvas getCanvas() {
        return factoryModel;
    }

    /**
     * Démarre l'animation du canvas.
     */
    @Override
    public void startAnimation() {
        factoryModel.startSimulation();
        animationRunning = true;

        while (factoryModel.isSimulationStarted()) {
            factoryModel.behave();
            try {
                Thread.sleep(80);
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

    /**
     * Retourne un booléen indiquant si l'animation est actuellement en cours.
     *
     * @return Vrai si l'animation est en cours, faux sinon.
     */
    @Override
    public boolean isAnimationRunning() {
        return this.animationRunning;
    }

    /**
     * Ajoute un observateur au canvas.
     *
     * @param observer L'observateur à ajouter.
     * @return Vrai si l'observateur a été ajouté avec succès, faux sinon.
     */
    @Override
    public boolean addObserver(Observer observer) {
        return this.factoryModel.addObserver(observer);
    }

    @Override
    public boolean removeObserver(Observer observer) {
        return this.factoryModel.removeObserver(observer);
    }

    /**
     * Définit le canvas géré par l'objet Factory.
     *
     * @param canvasModel Le nouveau canvas à définir.
     */
    @Override
    public void setCanvas(Canvas canvasModel) {
        if (canvasModel instanceof Factory) {
            this.factoryModel = (Factory) canvasModel;
        } else {
            throw new IllegalArgumentException("Invalid Canvas model");
        }
    }

    /**
     * Retourne l'objet CanvasPersistenceManager utilisé pour enregistrer et charger le canvas.
     *
     * @return L'objet CanvasPersistenceManager.
     */
    @Override
    public CanvasPersistenceManager getPersistenceManager() {
        return this.persistenceManager;
    }
}
