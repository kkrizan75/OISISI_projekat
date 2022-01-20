package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class SubjectsTable extends JTable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -6769874681843326035L;
	private static SubjectsTable instance = null;
	public static JTable subjectsTable;
	
	
	public static SubjectsTable getInstance() {
		if (instance == null) {
			instance = new SubjectsTable();
		}
		return instance;
	}
	
	public SubjectsTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableSubjects());
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