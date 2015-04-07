package simulator;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ViewPanel extends JPanel
{

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private List<Tile> t;
	
	public ViewPanel(JFrame frame)
	{
		setBackground(Color.white);
		setVisible(true);
		addPopUp();
		this.frame = frame;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		
	}
	
	public void addPopUp()
	{
		JButton b = new JButton("POPUP =]");
		
		b.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		new PopUp(frame, t);
	    	}
	    });
		
	this.add(b);
	
	}

}
