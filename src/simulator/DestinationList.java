package simulator;

import java.awt.geom.Point2D;
import java.util.List;

public class DestinationList {

	private List<Tile> destinations;
	public DestinationList(){
	}
	
	public void createTile(Point2D position, boolean isBuilding){
		Tile tile = new Tile(position, isBuilding);
		destinations.add(tile);
	}
	
	public List<Tile> getList(){
		return destinations;
	}
}
