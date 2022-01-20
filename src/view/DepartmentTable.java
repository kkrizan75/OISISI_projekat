package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class DepartmentTable extends JTable {
	
	private static DepartmentTable instance = null;
	
	public static DepartmentTable getInstance() {
		if(instance == null) {
			instance = new DepartmentTable();
			}
		return instance;
	}
	
	private AbstractTableDepartments abt = new AbstractTableDepartments();
	
	public DepartmentTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(abt);
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
