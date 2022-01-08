package view;

import javax.swing.table.AbstractTableModel;


public class AbstractTableProfessors extends AbstractTableModel {



	/**
	 * 
	 */
	private static final long serialVersionUID = 7123158991188437639L;

	public AbstractTableProfessors() {
	}

	@Override
	public int getRowCount() {
		return ProfessorsBase.getInstance().getProfessors().size();
	}
	
	@Override
	public int getColumnCount() {
		return ProfessorsBase.getInstance().getColumnCount();
	}


	@Override
	public String getColumnName(int column) {
		return ProfessorsBase.getInstance().getColumnName(column);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return ProfessorsBase.getInstance().getValueAt(rowIndex, columnIndex);
	}
}