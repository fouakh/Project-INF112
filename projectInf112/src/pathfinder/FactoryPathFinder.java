package pathfinder;

import java.util.List;
import java.util.logging.Logger;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;

public class FactoryPathFinder implements IFactoryPathFinder {

	
	@SuppressWarnings("unused")
	private static final Logger LOGGER = Logger.getLogger(FactoryPathFinder.class.getName());
	
	
	private FactoryToGraph factoryToGraph;
	private DijkstraShortestPath<Position, DefaultWeightedEdge> shortestPath;
	
	
	public FactoryPathFinder(FactoryToGraph factoryToGraph) {
		this.factoryToGraph = factoryToGraph;
	}

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
