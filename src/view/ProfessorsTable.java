package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Comparator;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

public class ProfessorsTable extends JTable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ProfessorsTable instance = null;
	public static int rowSelectedIndex = -1;
	public static TableRowSorter<AbstractTableProfessors> profSort;
	public static JTable profTable;
	public static AbstractTableProfessors profAbstractTable;
	
	public static ProfessorsTable getInstance() {
		if (instance == null) {
			instance = new ProfessorsTable();
		}
		return instance;
	}
	
	public ProfessorsTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableProfessors());
		this.profAbstractTable = new AbstractTableProfessors();
		this.addMouseListener(new MouseAdapter () {
		@Override
		public void mouseReleased(MouseEvent e) {
			profTable = (JTable) e.getComponent();
			if(profTable.getSelectedRow() != -1) {
				rowSelectedIndex = profTable.convertRowIndexToModel(profTable.getSelectedRow());
			}
		}
		
		});
		
		profSort =new TableRowSorter<AbstractTableProfessors>(profAbstractTable);
		profSort.setComparator(3, new Comparator<String>() {
			
			@Override
			public int compare(String name1, String name2) {
				return extractInt(name1) - extractInt(name2);
			}
			
			int extractInt(String s) {
				String num = s.replaceAll("\\D", "");
				return num.isEmpty() ? 0 : Integer.parseInt(num);
			}
			
		});
		this.setRowSorter(profSort);
		
	}
	
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}

}
