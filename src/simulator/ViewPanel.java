package simulator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ViewPanel extends JPanel
{

	private static final long serialVersionUID = 1L;
	private List<Tile> tiles = new ArrayList<Tile>();
	private List<NPC> NPCs = new ArrayList<NPC>();
	private JFrame frame;
	
	public ViewPanel(JFrame frame)
	{
		setBackground(Color.white);
		setVisible(true);
		addPopUp();
		this.frame = frame;
		tiles.add(new Tile(new Point2D.Double(0, 0)));
		tiles.add(new Tile(new Point2D.Double(200 + 10, 0)));
		tiles.add(new Tile(new Point2D.Double(0, 200 + 10)));
		tiles.add(new Tile(new Point2D.Double(200 + 10, 200 + 10)));
		NPCs.add(new NPC(new Point2D.Double(300, 300),tiles));
		//new PopUp(frame, tiles);
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for (int i = 0; i < tiles.size(); i++) {
			g2.fill(tiles.get(i).getRect());
		}
		for (int x = 0; x < NPCs.size(); x++) {
			NPCs.get(x).paint(g2);
		}
	}
	
	public void addPopUp()
	{
		JButton b = new JButton("POPUP =]");
		
		b.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		new PopUp(frame, tiles);
	    	}
	    });
		
	this.add(b);
	
	}

}
