package simulator;

import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

public class Tile {
	private Point2D position;
	private Shape rect;
	private boolean isBuilding;
	private double width = 200 ,height = 200;
	private List<Path> Paths = new ArrayList<Path>();

	public Tile(Point2D position){
		this.position = position;
		isBuilding = false;
		rect = new Rectangle2D.Double(position.getX(), position.getY(), width, height);
	}

	public Shape getRect(){
		return rect;
	}

	public Point2D getCenter(){
		Point2D center = new Point2D.Double(position.getX()+width/2,position.getY()+height/2);
		return center;
	}

	public List<Path> getPaths() {
		return Paths;
	}
	
	public boolean isBuilding(){
		return isBuilding;
	}
}
