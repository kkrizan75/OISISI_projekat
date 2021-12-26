package view;

import javax.swing.table.AbstractTableModel;

public class AbstractTableSubjects extends AbstractTableModel {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AbstractTableSubjects() {
	}

	// broj redova
	@Override
	public int getRowCount() {
		return 10;
	}
	
	// broj kolona
	@Override
	public int getColumnCount() {
		return SubjectsBase.getInstance().getColumnCount();
	}

	// nazivi kolona u zaglavlju
	@Override
	public String getColumnName(int column) {
		return SubjectsBase.getInstance().getColumnName(column);
	}
	
	// sadrzaj celije
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return SubjectsBase.getInstance().getValueAt(rowIndex, columnIndex);
	}
}

