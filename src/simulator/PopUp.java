package simulator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PopUp extends JDialog
{
	private static final long serialVersionUID = 1L;
	private JPanel content;
	private JPanel north;
	private List<Tile> t;
	private Table table = new Table(t);
	private JTable jtable = table.getJTable();
		
	
	public PopUp(JFrame owner, List<Tile> t)
	{
		super(owner, "PopUp =]");
		setModalityType(ModalityType.APPLICATION_MODAL);
		setLocationRelativeTo(null);
		
		content = new JPanel (new BorderLayout());
		north = new JPanel(new GridLayout(3, 2));
		setContentPane(content);
		
		content.add(north, BorderLayout.NORTH);
		
		inhoud();
		this.t = t;
		
		JButton add = new JButton("add");
		
		add.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e)
	    	{
	    		
	    	}
	    });
		
		content.add(add, BorderLayout.SOUTH);
		
		JScrollPane scrollPane = new JScrollPane(jtable);
		content.add(scrollPane, BorderLayout.CENTER);
		
		setSize(400,400);
	    setVisible(true);
	}
	
	public void inhoud()
	{
		JLabel name = new JLabel(" Name:");
		JTextField invlName = new JTextField();
		JLabel isBuilding = new JLabel(" Is Building:");
		JCheckBox check = new JCheckBox("Building");
		JLabel waypoints = new JLabel(" Waypoints:");
		JLabel label = new JLabel(" ");
		
		
		north.add(name);
		north.add(invlName);
		north.add(isBuilding);
		north.add(check);
		north.add(waypoints);
		north.add(label);
	}
}
