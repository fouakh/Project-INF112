package pathfinder;

import java.util.List;
import java.util.logging.Logger;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultEdge;

public class FactoryPathFinder implements IFactoryPathFinder {

	@SuppressWarnings("unused")
	private static final Logger LOGGER = Logger.getLogger(FactoryPathFinder.class.getName());
	
	private DijkstraShortestPath<Position, DefaultEdge> shortestPath;
	
	
	@SuppressWarnings("unchecked")
	public FactoryPathFinder(FactoryToGraph factoryToGraph) {
		this.shortestPath = new DijkstraShortestPath<Position, DefaultEdge>((Graph<Position, DefaultEdge>) factoryToGraph.getGraph());
	}

	@Override
    public List<Position> findPath(Position sourcePosition, Position targetPosition) {

        GraphPath<Position, DefaultEdge> path =  this.shortestPath.getPath(sourcePosition, targetPosition);
        
        if (path == null) {
            return null;
        }
        return path.getVertexList();
	}

}
