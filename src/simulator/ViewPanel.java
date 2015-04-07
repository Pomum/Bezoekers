package simulator;

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
import javax.swing.Timer;

public class ViewPanel extends JPanel implements ActionListener
{

	private static final long serialVersionUID = 1L;
	private List<Tile> tiles = new ArrayList<Tile>();
	private List<NPC> NPCs = new ArrayList<NPC>();
	private JFrame frame;
	
	public ViewPanel(JFrame frame)
	{
		this.frame = frame;
		
		initTest();
		
		new Timer(1000/60,this).start();
	}
	private void initTest(){
		addPopUp();
		
		Tile tile1 = new Tile(new Point2D.Double(0, 0));
		tile1.setBuilding(true);
		Tile tile2 = new Tile(new Point2D.Double(200 + 10, 0));
		tile2.setBuilding(true);
		Tile tile3 = new Tile(new Point2D.Double(0, 200 + 10));
		tile3.setBuilding(true);
		Tile tile4 = new Tile(new Point2D.Double(200 + 10, 200 + 10));
		tile4.setEntrance(true);
		tiles.add(tile1);
		tiles.add(tile2);
		tiles.add(tile3);
		tiles.add(tile4);
		NPC npc1 = new NPC(new Point2D.Double(300, 300),tiles);
		NPCs.add(npc1);
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
	
	public void addPopUp() {
		JButton b = new JButton("POPUP =]");

		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PopUp(frame, tiles);
			}
		});
		this.add(b);
	}

	public void actionPerformed(ActionEvent e) {
		for(NPC npc : NPCs){
			npc.update(NPCs);
		}
		repaint();
	}
}
