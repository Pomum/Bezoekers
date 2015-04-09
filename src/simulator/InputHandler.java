package simulator;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Point2D;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class InputHandler {
	private Tile tile;
	private Point clickPoint;
	private Point2D lastPoint;
	public InputHandler(JFrame frame, JPanel panel, List<Tile> tiles){
		panel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				clickPoint = e.getPoint();
				lastPoint = clickPoint;
				for(Tile selectTile : tiles){
					if(contact(clickPoint,selectTile)){
						if(e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e)){
							new PopUp(frame, selectTile, tiles);
							break;
						}
						else{
							tile = selectTile;
						}
					}
				}
				if(SwingUtilities.isMiddleMouseButton(e)){
					Tile tile = new Tile(clickPoint);
					tiles.add(tile);
					new PopUp(frame, tile, tiles);
				}
			}
			public void mouseReleased(MouseEvent e) {
				tile = null;
			}
		});
		
		panel.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				clickPoint = e.getPoint();
				if (tile != null) {
					if (SwingUtilities.isLeftMouseButton(e)) {
						tile.setPosition(new Point2D.Double(
								tile.getPosition().getX() - (lastPoint.getX() - clickPoint.getX()),
								tile.getPosition().getY() - (lastPoint.getY() - clickPoint.getY())));
					}else if (SwingUtilities.isRightMouseButton(e)){
						if(tile.getWidth() > 20)
							tile.setWidth(tile.getWidth() - (lastPoint.getX() - clickPoint.getX()));
						else
							tile.setWidth(21);
						if(tile.getHeight() > 20)
							tile.setHeight(tile.getHeight()- (lastPoint.getY() - clickPoint.getY()));
						else
							tile.setHeight(21);
					}
				}
				lastPoint = clickPoint;
				panel.repaint();
			}
		});
	}
	
	private boolean contact(Point clickPosition, Tile tile) {
		return tile.getRect().contains(clickPosition);
	}
}