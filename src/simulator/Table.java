package simulator;

import java.util.List;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class Table 
{
	private JTable table;
	private DefaultTableModel model;
	private List<Tile> t;
	
	public Table(List<Tile> t)
	{
		setModel();
		this.t = t;
	}
	
	
	private void setModel()
	{				
		table = new JTable(new AbstractTableModel()
		{
			private static final long serialVersionUID = 1L;

			@Override
			public int getColumnCount() {
				
				return 2;
			}

			@Override
			public int getRowCount() {
				
				//return t.size();
				return 5;
			}

			@Override
			public Object getValueAt(int row, int col) {
				if (col == 0)
				{
					//return t.get(row).getDestination().getName();
					return "a";
				} 
				else if (col == 1)
				{
					//return t.get(row).getTarget().getName();
					return "b";
				}
				else
				{
					return "-";
				}
			}

			@Override
			public String getColumnName(int col) {
						if (col == 0)
						{
							return "Destination:";
						} 
						else if (col == 1)
						{
							return "Target:";
						}						
						else
						{
							return "-";
						}
			}			
		});
		table.setCellSelectionEnabled(true);
	}
	
	public void addRow(Tile destination, Tile target)
	{
		model.addRow(new Object[]{destination, target});
	}
	
	public void removeRow(int row)
	{
			model.removeRow(row);
	}
	
	public JTable getJTable()
	{
		return table;
	}
}
