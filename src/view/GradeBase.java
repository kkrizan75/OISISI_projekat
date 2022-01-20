package view;

import java.util.ArrayList;
import java.util.List;

import Model.Grade;
import Model.Student;
import Model.Subject;
import Model.Subject.Semester_enum;
import controller.StudentsController;

public class GradeBase {
	private static GradeBase instance = null;

	public static GradeBase getInstance() {
		if (instance == null) {
			instance = new GradeBase();
		}
		return instance;
	}

	private long IDgenerator;
	
	private List<Grade> grades;
	private List<String> columns;
	
	private GradeBase() {
		IDgenerator = 0;
	
		initGrade();

		this.columns = new ArrayList<String>();
		this.columns.add("Subject ID");
		this.columns.add("Name");
		this.columns.add("ECTS");
		this.columns.add("Grade");
		this.columns.add("Date");
	
	}
	
	public List<Grade> getgrades() {
		return grades;
	}

	public void setgrades(List<Grade> grades) {
		this.grades = grades;
	}

	private long generateId() {
		return ++IDgenerator;
	}

	public int getColumnCount() {
		return 5;
	}

	public String getColumnName(int index) {
		return this.columns.get(index);
	}

	public Grade getRow(int rowIndex) {
		return this.grades.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		if (row >= grades.size()) {
			switch (column) {
			case 0:
				return "";
			case 1:
				return "";
			case 2:
				return "";
			case 3:
				return "";
			case 4:
				return "";
			default:
				return null;
			}
		
		} else {
			Grade grade = this.grades.get(row);
			switch (column) {
			case 0:
				return grade.getSubject().getId();
			case 1:
				return grade.getSubject().getName();
			case 2:
				return Integer.toString(grade.getSubject().getECTS());
			case 3:
				return Integer.toString(grade.getGrade());
			case 4:
				return grade.getExam().toString();
			default:
				return null;
			}
		}
		
	}
	
	public String getSubjectsValueAt(int row, int column) {
		Student s = StudentsController.getInstance().findSelcetedStudent(StudentTable.getInstance().getSelectedIndex());
		grades = s.getpassedSubjects();
		if(row >= grades.size()) {
			switch (column) {
			case 0:
				return "";
			case 1:
				return "";
			case 2:
				return "";
			case 3:
				return "";
			case 4:
				return "";
			default:
				return null;
			}
			
		}else {
			Grade grade = grades.get(row);
			switch (column) {
			case 0:
				return grade.getSubject().getId();
			case 1:
				return grade.getSubject().getName();
			case 2:
				return Integer.toString(grade.getSubject().getECTS());
			case 3:
				return Integer.toString(grade.getGrade());
			case 4:
				return grade.getExam().toString();
			default:
				return null;
			}
			
		}
	}

	
	private void initGrade() {
		this.grades = new ArrayList<Grade>();
		
	}
}
