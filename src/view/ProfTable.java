package view;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

import Model.Subject;

public class ProfTable extends JTable {
	
	private static ProfTable instance = null;

	public static ProfTable getInstance() {
		if (instance == null) {
			instance = new ProfTable();
		}
		return instance;
	}
	
	public ProfTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractProfTable());
	}
	
	public ArrayList<Subject> getAls(){
		return AbstractProfTable.getInstance().getAls();
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