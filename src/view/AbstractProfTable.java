package view;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Model.Subject;
import Model.Subject.Semester_enum;
import controller.ProfessorsController;

public class AbstractProfTable extends AbstractTableModel {

	/**
	 * 
	 */
	
	private static AbstractProfTable instance = null;

	public static AbstractProfTable getInstance() {
		if (instance == null) {
			instance = new AbstractProfTable();
		}
		return instance;
	}
	
	private ArrayList<Subject> als = ProfessorsBase.getInstance().SubjectsofProfessor(ProfessorsController.getInstance().findSelectedProfessor(ProfessorsTable.getInstance().getSelectedRow()));
	
	public ArrayList<Subject> getAls(){
		return als;
	}
	
	private static final long serialVersionUID = 1L;

	@Override
	public int getRowCount() {
		return ProfessorsBase.getInstance().SubjectsofProfessor(ProfessorsController.getInstance().findSelectedProfessor(ProfessorsTable.getInstance().getSelectedRow())).size();
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
		Subject s = als.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return s.getId();
		case 1:
			return s.getName();
		case 2:
			return Integer.toString(s.getECTS());
		case 3:
			return Integer.toString(s.getyearOfStudy());
		case 4:
			if (s.getSemester() == Semester_enum.W) return "WINTER";
			else return "SUMMER";
		default:
			return null;
		}
	}
}
