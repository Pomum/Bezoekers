package simulator;

import java.awt.BorderLayout;
import java.awt.GridLayout;

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
	
		
	
	public PopUp(JFrame owner)
	{
		super(owner, "PopUp");
//		setModalityType(ModalityType.APPLICATION_MODAL);
		setLocationRelativeTo(owner);
		
		content = new JPanel (new BorderLayout());
		north = new JPanel(new GridLayout(3, 2));
		setContentPane(content);
		
		content.add(north, BorderLayout.NORTH);
		
		inhoud();
		table();
		
		JButton add = new JButton("add");
		content.add(add, BorderLayout.SOUTH);
		
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
	
	public void table()
	{
		Object rowData[][] = {
	    	    {"Podium 1", "Kruispunt 1"},
	    	    {"Podium 2", "Kruispunt 2"},
	    	    {"Podium 3", "Kruispunt 1"}
	    	};
		
		JTable table = new JTable(new DefaultTableModel(rowData, new Object[]{"Destination:", "Target:"}));
		JScrollPane scrollPane = new JScrollPane(table);
		content.add(scrollPane, BorderLayout.CENTER);
	}
}
