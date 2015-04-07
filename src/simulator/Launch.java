package simulator;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Launch{

	public static void main(String[] args){
		JFrame frame = new JFrame(":D");
		JPanel panel = new ViewPanel();
		frame.getContentPane().add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setMinimumSize(new Dimension(1024,768));
		frame.pack();
		frame.setVisible(true);
	}
}
