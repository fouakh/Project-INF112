package pathfinder;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;

import model.Door;
import model.Room;

public class FactoryToGraph {
	
	private Graph<Position, DefaultEdge> graph;
	
	public FactoryToGraph(Room room) {
		//robot = new Robot(0, 0, null, 0, null, null);
		graph = new DefaultDirectedGraph<>(DefaultEdge.class);
		createRoomGraph(room);
	}


	public void mergeGraph(DefaultDirectedGraph<Position, DefaultEdge> graphToMerge) {
        for (Position vertex : graphToMerge.vertexSet()) {
            if (!graph.containsVertex(vertex)) {
            	this.graph.addVertex(vertex);
            }
        }

        for (DefaultEdge edge : graphToMerge.edgeSet()) {
            Position source = graphToMerge.getEdgeSource(edge);
            Position target = graphToMerge.getEdgeTarget(edge);
            if (!graph.containsEdge(source, target)) {
            	this.graph.addEdge(source, target);
            }
        }
    }
	
	public void createRoomGraph(Room room) {
		/*int xTopLeft = room.getxCoordinate() + (this.robot.getRadius() / 2);
		int yTopLeft = room.getyCoordinate() + (this.robot.getRadius() / 2);
		int xBottomRight = xTopLeft + room.getWidth() - (this.robot.getRadius() / 2);
		int yBottomRight = yTopLeft + room.getHeight() - (this.robot.getRadius() / 2);*/
		
		int xTopLeft = room.getxCoordinate();
		int yTopLeft = room.getyCoordinate();
		int xBottomRight = xTopLeft + room.getHeight();
		int yBottomRight = yTopLeft + room.getWidth();
		
		for (int x = xTopLeft; x <= xBottomRight; x++) {
            for (int y = yTopLeft; y <= yBottomRight; y++) {
                Position pos = new Position(x, y);
                this.graph.addVertex(pos);

                if (x > xTopLeft) {
                    Position leftNeighbor = new Position(x - 1, y);
                    this.graph.addEdge(pos, leftNeighbor);
                    this.graph.addEdge(leftNeighbor, pos);
                }

                if (y > yTopLeft) {
                    Position topNeighbor = new Position(x, y - 1);
                    this.graph.addEdge(pos, topNeighbor);
                    this.graph.addEdge(topNeighbor, pos);
                }
            }
        }		
	}
	
	public void openDoor(DefaultDirectedGraph<Position, DefaultEdge> graph, Door door) {
		// TODO Auto-generated method stub
	}
	
	public void closeDoor(DefaultDirectedGraph<Position, DefaultEdge> graph, Door door) {
		// TODO Auto-generated method stub
	}

	public Object getGraph() {
		return this.graph;
	}

}
