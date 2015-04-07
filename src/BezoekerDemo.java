import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;


public class BezoekerDemo extends JPanel implements ActionListener 
{
	private static final long serialVersionUID = 1L;
	private Shape s = new Rectangle(350, 650, 100, 100);
	private Shape s1 = new Rectangle(350, 0, 100, 100);
	
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Bezoeker");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,800);
		frame.setLocationRelativeTo(null);
		frame.setContentPane(new BezoekerDemo());		
		frame.setVisible(true);		
	}
	
	ArrayList<Bezoeker> bezoekers = new ArrayList<>();
	
	public BezoekerDemo() 
	{
		while(bezoekers.size() < 30)
		{
			Bezoeker b = new Bezoeker(new Point2D.Double(Math.random()*800, Math.random()*600), s, s1);
			if(!b.hasCollision(bezoekers))
				bezoekers.add(b);
		}
		new Timer(1000/60, this).start();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		g2.draw(s);
		g2.draw(s1);
		for(Bezoeker b : bezoekers)
			b.paint(g2);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		for(Bezoeker b : bezoekers)
			b.update(bezoekers);
		
		repaint();
	}
}
