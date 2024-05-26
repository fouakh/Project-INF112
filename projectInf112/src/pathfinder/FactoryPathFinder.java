package pathfinder;

import java.util.List;
import java.util.logging.Logger;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;

/**
 * Classe implémentant l'interface IFactoryPathFinder pour trouver un chemin entre deux positions dans une usine.
 * 
 * Cette classe utilise la bibliothèque JGraphT pour trouver le chemin le plus court entre deux positions dans une usine.
 */
public class FactoryPathFinder implements IFactoryPathFinder {

	
	@SuppressWarnings("unused")
	private static final Logger LOGGER = Logger.getLogger(FactoryPathFinder.class.getName());
	
	
	private FactoryToGraph factoryToGraph;
	/**
     * Instance de DijkstraShortestPath utilisée pour trouver le chemin le plus court.
     */
	private DijkstraShortestPath<Position, DefaultWeightedEdge> shortestPath;
	
	
	public FactoryPathFinder(FactoryToGraph factoryToGraph) {
		this.factoryToGraph = factoryToGraph;
	}

	/**
     * Trouve un chemin entre la position source et la position cible.
     * 
     * @param sourcePosition la position de départ
     * @param targetPosition la position d'arrivée
     * @return la liste des positions représentant le chemin le plus court entre la position source et la position cible, ou null si aucun chemin n'est trouvé.
     */
	@Override
    public List<Position> findPath(Position sourcePosition, Position targetPosition) {

		Graph<Position, DefaultWeightedEdge> subGraph = factoryToGraph.createSubGraph();
		this.shortestPath = new DijkstraShortestPath<Position, DefaultWeightedEdge>((Graph<Position, DefaultWeightedEdge>) subGraph);
        GraphPath<Position, DefaultWeightedEdge> path =  this.shortestPath.getPath(sourcePosition, targetPosition);
        
        if (path == null) {
            return null;
        }
        return path.getVertexList();
	}

}
