package simulator;

import java.awt.Image;
import java.awt.geom.Point2D;
import java.util.List;

import javax.swing.ImageIcon;


public class NPC {
	private static final String PATH = "visitor.png";
	private Image image;
	private Point2D position;
	private double speed,direction;
	private Tile target,destination;
	private List<Tile> destinationList;
	
	public NPC(Point2D position){
		image = new ImageIcon(PATH).getImage();
		this.position = position;
		speed = 1;
		direction = 1;
		
		destination = getDestination();
		target = getTarget(destination);
	}

	private Tile getTarget(Tile destination) {
		return null;
	}

	private Tile getDestination() {
		
		return null;
	}
	
	
}
