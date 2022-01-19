package view;

import javax.swing.table.AbstractTableModel;

import controller.StudentsController;

public class AbstractTablePassedSubjects extends AbstractTableModel{
	private static final long serialVersionUID = 1L;

	@Override
	public int getRowCount() {
		return StudentsController.getInstance().findSelcetedStudent(StudentTable.getInstance().getSelectedRow()).getpassedSubjects().size();
	}

	@Override
	public int getColumnCount() {
		return GradeBase.getInstance().getColumnCount();
	}

	@Override
	public String getColumnName(int column) {
		return GradeBase.getInstance().getColumnName(column);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return GradeBase.getInstance().getSubjectsValueAt(rowIndex, columnIndex);
	}
}
