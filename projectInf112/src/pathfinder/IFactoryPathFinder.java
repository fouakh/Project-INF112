package pathfinder;

import java.util.List;

public interface IFactoryPathFinder {
	
	public List<Position> findPath(Position sourcePosition, Position targetPosition);

}

