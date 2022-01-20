package view;

import javax.swing.table.AbstractTableModel;

import controller.StudentsController;

public class AbstractTableFailedSubjects extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public int getRowCount() {
		return StudentsController.getInstance().findSelcetedStudent(StudentTable.getInstance().getSelectedIndex()).getunpassedSubjects().size();
	}

	@Override
	public int getColumnCount() {
		return SubjectsBase.getInstance().getColumnCount();
	}

	@Override
	public String getColumnName(int column) {
		return SubjectsBase.getInstance().getColumnName(column);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return SubjectsBase.getInstance().getSubjectsValueAt(rowIndex, columnIndex);
	}

}
