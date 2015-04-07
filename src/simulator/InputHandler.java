package simulator;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class InputHandler {

	public InputHandler(JFrame frame, JPanel panel, List<Tile> tiles){
		panel.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				Point mousePosition = e.getPoint();
				for(Tile tile : tiles){
					if(contact(mousePosition,tile)){
						System.out.println(e.getX() +" "+ e.getY());
						if(SwingUtilities.isMiddleMouseButton(e)){
							new PopUp(frame, tiles, tile);
						}
					}
				}
			}
		});
	}
	
	private boolean contact(Point mousePosition, Tile tile) {
		return tile.getRect().contains(mousePosition);
	}
}
