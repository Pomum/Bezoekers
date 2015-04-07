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

public class PopUp extends JDialog {
	private static final long serialVersionUID = 1L;
	
	private JPanel content;
	private JPanel north;

	private List<Tile> tiles;
	private Tile tile;

	private Table table = new Table(tiles);
	private JTable jtable = table.getJTable();
	
	public PopUp(JFrame owner, List<Tile> tiles,Tile tile) {
		super(owner, "PopUp =]");
		this.tiles = tiles;
		this.tile = tile;

		setModalityType(ModalityType.APPLICATION_MODAL);
		setLocationRelativeTo(null);
		
		initWindow();
		fillWindow();
		initButton();
		
		setSize(400, 400);
		setVisible(true);
	}

	private void fillWindow() {
		JLabel		 name 	  = new JLabel(" Name:");
		JTextField 	 invlName = new JTextField(tile.getName());
		JLabel 		 empty	  = new JLabel("");
		JCheckBox 	 check 	  = new JCheckBox("Building");
		JCheckBox 	 entrance = new JCheckBox("Entrance");
		JCheckBox 	 exit 	  = new JCheckBox("Exit");

		invlName.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				tile.setName(invlName.getText());
			}
		});
		north.add(name);
		north.add(invlName);
		north.add(empty);
		north.add(check);
		north.add(entrance);
		north.add(exit);
	}

	private void initWindow() {
		content = new JPanel(new BorderLayout());
		north = new JPanel(new GridLayout(3, 2));
		setContentPane(content);
		content.add(north, BorderLayout.NORTH);
	}

	private void initButton() {

		JButton add = new JButton("add");
		JScrollPane scrollPane = new JScrollPane(jtable);

		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		content.add(add, BorderLayout.SOUTH);
		content.add(scrollPane, BorderLayout.CENTER);
	}
}
