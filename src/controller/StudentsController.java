package controller;

import GUI.Main_Frame;
import Listeners.ActionListener1;
import Model.Student;
import dialogs.addStudentdialog;
import tables.AbstractTableStudents;
import tables.StudentBase;
import tables.StudentTable;

public class StudentsController {
private static StudentsController instance = null;
	
	public static StudentsController getInstance() {
		if (instance == null) {
			instance = new StudentsController();
		}
		return instance;
	}
	
	public void addStudent() {
		Student student = new Student(addStudentdialog.getInstance().getName(),addStudentdialog.getInstance().getSurname(),addStudentdialog.getInstance().getBirthDate(),
				addStudentdialog.getInstance().getAddress(),addStudentdialog.getInstance().getContactPhone(),addStudentdialog.getInstance().geteMail(),
				addStudentdialog.getInstance().getIndex(),addStudentdialog.getInstance().getYearOfEnrollment(),addStudentdialog.getInstance().getCurrentYear(),
				addStudentdialog.getInstance().getStatus());
		
		StudentBase.getInstance().dodajStudenta(student);
		ActionListener1.getaSd().setVisible(false);
		AbstractTableStudents model = (AbstractTableStudents) StudentTable.getInstance().getModel();
        model.fireTableRowsInserted(1,1);
		Main_Frame.getInstance().validate();
	}
}
