package controller;

import javax.swing.JOptionPane;

import Model.Student;
import view.AbstractTableStudents;
import view.ActionListener1;
import view.EditActionListener;
import view.Main_Frame;
import view.StudentBase;
import view.StudentTable;
import view.addStudentdialog;
import view.editStudentdialog;

public class StudentsController {
private static StudentsController instance = null;
	
	public static StudentsController getInstance() {
		if (instance == null) {
			instance = new StudentsController();
		}
		return instance;
	}
	
	public boolean contains(String ind) {
		return StudentBase.getInstance().contains(ind);
	}
	
	public void addStudent() {
		Student student = new Student(addStudentdialog.getInstance().getName(),addStudentdialog.getInstance().getSurname(),addStudentdialog.getInstance().getBirthDate(),
				addStudentdialog.getInstance().getAddress(),addStudentdialog.getInstance().getContactPhone(),addStudentdialog.getInstance().geteMail(),
				addStudentdialog.getInstance().getIndex(),addStudentdialog.getInstance().getYearOfEnrollment(),addStudentdialog.getInstance().getCurrentYear(),
				addStudentdialog.getInstance().getStatus());
		
		StudentBase.getInstance().dodajStudenta(student);
		ActionListener1.getaSd().setVisible(false);
		AbstractTableStudents model = (AbstractTableStudents) StudentTable.getInstance().getModel();
		model.fireTableDataChanged();
		Main_Frame.getInstance().validate();
	}
	
	public void deleteStudent(int rowSelectedIndex) {
		if (checkRow(rowSelectedIndex)) return;
		int result = JOptionPane.showConfirmDialog(Main_Frame.getInstance(),"Are you sure you want to delete this Student?", "Sure?",
		               JOptionPane.YES_NO_OPTION,
		               JOptionPane.QUESTION_MESSAGE);
		if (result == JOptionPane.YES_OPTION) {
    	// izmena modela
    	StudentBase.getInstance().izbrisiStudenta(rowSelectedIndex);
		// azuriranje prikaza
    	AbstractTableStudents model = (AbstractTableStudents) StudentTable.getInstance().getModel();
    	model.fireTableDataChanged();
		Main_Frame.getInstance().validate();
			}
	}
	
	public Student findSelcetedStudent(int rowSelectedIndex) {
		return StudentBase.getInstance().getRow(rowSelectedIndex);
	}
	
	public Student findStudentByInD(String ind) {
		for (Student S : StudentBase.getInstance().getStudenti().values()) {
			if(S.getIndex().equals(ind)) return S;
		}
		return null;
	}
	
	public boolean checkRow(int rowSelectedIndex) {
		if (rowSelectedIndex < 0 || rowSelectedIndex >= StudentBase.getInstance().getStudenti().size()) {
			JOptionPane.showMessageDialog(editStudentdialog.getInstance(), "No row selected!","Error!",2);
			return true;
		}
		return false;
	}
	
	public void editStudent() {
		StudentBase.getInstance().izmeniStudenta();
		EditActionListener.geteSd().setVisible(false);
		AbstractTableStudents model = (AbstractTableStudents) StudentTable.getInstance().getModel();
    	model.fireTableDataChanged();
		Main_Frame.getInstance().validate();
	}
	
}
