package view;

import javax.swing.table.AbstractTableModel;

public class AbstractTableStudents extends AbstractTableModel{
	private static final long serialVersionUID = 2710362894062472488L;

	public AbstractTableStudents() {
	}

	// broj redova
	@Override
	public int getRowCount() {
		return StudentBase.getInstance().getStudenti().size();
	}
	
	// broj kolona
	@Override
	public int getColumnCount() {
		return StudentBase.getInstance().getColumnCount();
	}

	// nazivi kolona u zaglavlju
	@Override
	public String getColumnName(int column) {
		return StudentBase.getInstance().getColumnName(column);
	}
	
	// sadrzaj celije
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return StudentBase.getInstance().getValueAt(rowIndex, columnIndex);
	}
	
	public Class getColumnClass(int c) {
		   return getValueAt(0, c).getClass();
	}
}
