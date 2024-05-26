package persistence;

import fr.tp.inf112.projects.canvas.model.impl.AbstractCanvasPersistenceManager;
import fr.tp.inf112.projects.canvas.model.CanvasChooser;
import fr.tp.inf112.projects.canvas.model.Canvas;

import java.io.*;

/**
 * La classe FileCanvasPersistenceManager est une implémentation de la classe AbstractCanvasPersistenceManager qui gère la persistance des canvas dans des fichiers.
 * Elle utilise les flux d'entrée et de sortie d'objets pour lire et écrire les canvas dans des fichiers.
 */
public class FileCanvasPersistenceManager extends AbstractCanvasPersistenceManager {

    public FileCanvasPersistenceManager(CanvasChooser chooser) {
        super(chooser);
    }

    /**
     * Lit un canvas à partir d'un fichier identifié par son ID.
     *
     * @param canvasId ID du canvas à lire.
     * @return Le canvas lu.
     * @throws IOException Si une erreur d'entrée/sortie se produit lors de la lecture du fichier.
     */
    @Override
    public Canvas read(String canvasId) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(canvasId))) {
            return (Canvas) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException("Class not found while reading canvas", e);
        }
    }
    /**
     * Persiste un canvas dans un fichier identifié par son ID.
     *
     * @param canvasModel Le canvas à persister.
     * @throws IOException Si une erreur d'entrée/sortie se produit lors de l'écriture du fichier.
     */

    @Override
    public void persist(Canvas canvasModel) throws IOException {
        String canvasId = canvasModel.getId();
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(canvasId))) {
        	oos.writeObject(canvasModel);
        }
    }

    /**
     * Supprime un canvas identifié par son ID.
     *
     * @param canvasModel Le canvas à supprimer.
     * @return True si le fichier a été supprimé avec succès, false sinon.
     * @throws IOException Si une erreur d'entrée/sortie se produit lors de la suppression du fichier.
     */
    @Override
    public boolean delete(Canvas canvasModel) throws IOException {
        File file = new File(canvasModel.getId());
        return file.delete();
    }
}
