package simulator;

import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Tile {
	private Point2D position;
	private Shape rect;
	private boolean isBuilding;
	private double width = 200 ,height = 200;
	
	public Tile(Point2D position, boolean isBuilding){
		this.position = position;
		this.isBuilding = isBuilding;
		rect = new Rectangle2D.Double(position.getX(), position.getY(), width, height);
	}
}
