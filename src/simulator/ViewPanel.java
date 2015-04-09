package simulator;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class ViewPanel extends JPanel implements ActionListener
{

	private static final long serialVersionUID = 1L;
	private List<Tile> tiles = new ArrayList<Tile>();
	private List<NPC> NPCs = new ArrayList<NPC>();
	private boolean delay = false;
	private int amountOfVisitors = 50;
	
	public ViewPanel(JFrame frame)
	{
		new InputHandler(frame, this, tiles);
		initTest();
		
		new Timer(1000,new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delay = !delay;
			}
		}).start();
		
		new Timer(1000/60,this).start();
	}
	
	private void initTest(){
		Tile tile1 = new Tile(new Point2D.Double(0, 0));
		Tile tile2 = new Tile(new Point2D.Double(200 + 100, 0));
		Tile tile3 = new Tile(new Point2D.Double(0, 200 + 100));
		Tile tile4 = new Tile(new Point2D.Double(200 + 100, 200 + 100));
		
		tile1.setBuilding(true);
		tile3.setExit(true);
		tile4.setEntrance(true);

		tile1.setName("Building");
		tile2.setName("Crossing");
		tile3.setName("Exit");
		tile4.setName("Entrance");
		
		tiles.add(tile1);
		tiles.add(tile2);
		tiles.add(tile3);
		tiles.add(tile4);
	
		tile1.addPath(tile3, tile3);
		tile2.addPath(tile1, tile1);
		tile2.addPath(tile3, tile3);
		tile4.addPath(tile1, tile2);
		tile4.addPath(tile3, tile2);
		
		
		for(int i = 0 ; i < 50 ; i++){
			NPC npc;
			Tile entrance;
			Point2D point;
			List<Tile> entrances = new ArrayList<Tile>();
			
			for(Tile tile : tiles){
				if(tile.isEntrance()){
					entrances.add(tile);
				}
			}
			
			entrance = entrances.get(new Random().nextInt(entrances.size()));
			
			do {
				point = new Point2D.Double(
						entrance.getPosition().getX() + Math.random()*entrance.getWidth(),
						entrance.getPosition().getY() + Math.random()*entrance.getHeight());
				npc = new NPC(point,tiles);
			} while (npc.hasCollision(NPCs));
			NPCs.add(npc);
		}
	}
	
	private void checkVisitors() {
		for (int i = NPCs.size(); i < amountOfVisitors; i++) {
			NPC npc;
			Tile entrance;
			Point2D point;
			List<Tile> entrances = new ArrayList<Tile>();
			List<Tile> exits = new ArrayList<Tile>();
			for (Tile tile : tiles) {
				if (tile.isEntrance()) {
					entrances.add(tile);
				}
				if(tile.isExit()){
					exits.add(tile);
				}
			}
			
			if(entrances.isEmpty() || exits.isEmpty()){
				JOptionPane.showMessageDialog(this, "you need to have atleast 1 entrance and exit");
				break;
			}
			entrance = entrances.get(new Random().nextInt(entrances.size()));
			int n = 0;
			do {
				n++;
				point = new Point2D.Double(
						entrance.getPosition().getX() + Math.random() * entrance.getWidth(), 
						entrance.getPosition().getY() + Math.random() * entrance.getHeight());

				npc = new NPC(point, tiles);
			} while (npc.hasCollision(NPCs) && n < 20);
			
			if (delay && n < 20) {
				NPCs.add(npc);
				break;
			}
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
		
		Iterator<NPC> it = NPCs.iterator();
		while(it.hasNext()){
			for(Tile tile : tiles){
				if(tile.isExit() && tile.getRect().contains(it.next().getPosition())){
					it.remove();
				}
			}
		}
		checkVisitors();	
		repaint();
	}
}
