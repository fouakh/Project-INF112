package pathfinder;

import java.util.List;
import java.util.logging.Logger;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultEdge;

import model.Room;

public class FactoryPathFinder implements IFactoryPathFinder {

	@SuppressWarnings("unused")
	private static final Logger LOGGER = Logger.getLogger(FactoryPathFinder.class.getName());
	
	private FactoryToGraph factoryToGraph;
	private DijkstraShortestPath<Position, DefaultEdge> shortestPath;
	
	
	@SuppressWarnings("unchecked")
	public FactoryPathFinder(Room operatingRoom) {
		this.factoryToGraph = new FactoryToGraph(operatingRoom);
		this.shortestPath = new DijkstraShortestPath<Position, DefaultEdge>((Graph<Position, DefaultEdge>) this.factoryToGraph.getGraph());
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
