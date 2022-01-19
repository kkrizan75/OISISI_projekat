package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class StudentTable extends JTable {
	private static StudentTable instance = null;
	
	public static StudentTable getInstance() {
		if (instance == null) {
			instance = new StudentTable();
		}
		return instance;
	}
	
	public StudentTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableStudents());
		this.setAutoCreateRowSorter(true);
// 		StudentBase.getInstance().getStudenti().sort;
//		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(this.getModel());
//		this.setRowSorter(sorter);
//
//		List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
//		sortKeys.add(new RowSorter.SortKey(4, SortOrder.ASCENDING));
//		sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
//		sorter.setSortKeys(sortKeys);
	}
	
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		// selektovani red ce imati drugaciju boju od ostalih
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}

}
