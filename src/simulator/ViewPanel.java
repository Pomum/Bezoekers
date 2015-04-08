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
		new InputHandler(frame, this, tiles);
		initTest();
		
		new Timer(1000/60,this).start();
	}
	private void initTest(){
		Tile tile1 = new Tile(new Point2D.Double(0, 0));
		Tile tile2 = new Tile(new Point2D.Double(200 + 100, 0));
		Tile tile3 = new Tile(new Point2D.Double(0, 200 + 100));
		Tile tile4 = new Tile(new Point2D.Double(200 + 100, 200 + 100));
		
		tile1.setBuilding(true);
		tile2.setBuilding(true);
		tile3.setBuilding(true);
		tile4.setEntrance(true);
		
		tiles.add(tile1);
		tiles.add(tile2);
		tiles.add(tile3);
		tiles.add(tile4);
	
		tile1.addPath(tile4, tile3);
		for(int i = 0 ; i < 25 ; i++){
			Point2D point = new Point2D.Double(Math.random()*1024,Math.random()*768);
			NPC npc = new NPC(point,tiles);
			while(npc.hasCollision(NPCs)){
				npc = new NPC(new Point2D.Double(Math.random()*1024,Math.random()*768), tiles);
			}
			NPCs.add(npc);
		}
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for (int i = 0; i < tiles.size(); i++) {
			tiles.get(i).paint(g2);
		}
		for (int x = 0; x < NPCs.size(); x++) {
			NPCs.get(x).paint(g2);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		for(NPC npc : NPCs){
			npc.update(NPCs);
		}
		repaint();
	}
}
