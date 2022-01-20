package view;

import javax.swing.table.AbstractTableModel;

import Model.Department;
import controller.Read;

public class AbstractTableDepartments extends AbstractTableModel {

	/**
	 * 
	 */
	//Read.getInstance().getDep();
	
	private static final long serialVersionUID = 1L;

	@Override
	public int getRowCount() {
		return Read.getInstance().getDep().size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}
	
	@Override
	public String getColumnName(int column) {
		switch(column) {
		case 0:
			return "Code";
		case 1:
			return "Name";
		case 2:
			return "Professor";
		default:
			return "";
		}
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Department d = Read.getInstance().getDep().get(rowIndex+1);
		if(d == null) return null;
		switch (columnIndex) {
		case 0:
			return d.getCode();
		case 1:
			return d.getName();
		case 2:
			return d.getBoss().getID_number();
		default:
			return null;
		}
	}

}
