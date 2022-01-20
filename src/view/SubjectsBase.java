package view;


import java.util.ArrayList;
import java.util.List;

import Model.Grade;
import Model.Professor;

import Model.Student;
import Model.Subject;
import Model.Subject.Semester_enum;
import controller.StudentsController;


public class SubjectsBase {

	
	
	private static SubjectsBase instance = null;

	public static SubjectsBase getInstance() {
		if (instance == null) {
			instance = new SubjectsBase();
		}
		return instance;
	}

	private long IDgenerator;

	private List<Subject> subjects;
	private List<Subject> failedSubjects;
	private List<String> columns;
	
	private SubjectsBase() {
		IDgenerator = 0;
	
		initSubjects();

		this.columns = new ArrayList<String>();
		this.columns.add("Subject ID");
		this.columns.add("Name");
		this.columns.add("ECTS");
		this.columns.add("Year of study");
		this.columns.add("Semester");
	
	}

	public ArrayList<Subject> unpassedSforStudent(Student s) {
		ArrayList<Subject> ret = new ArrayList<Subject>();
		boolean b = true;
		for (Subject su: subjects) {
			b = true;
			for(Subject su1 : s.getunpassedSubjects()) {
				if(su.getId().equals(su1.getId())) {
					b = false;
					break;
				}
			}
			for(Grade su2 : s.getpassedSubjects()) {
				if(su.getId().equals(su2.getSubject().getId())) {
					b = false;
					break;
				}
			}
			if(b) ret.add(su);
		}
		return ret;
	}
	
	public ArrayList<Subject> getSubjsNoProf() {
		ArrayList<Subject> als = new ArrayList<Subject>();
		for(Subject s : subjects) {
			if(s.getProfessor() != null) continue;
			als.add(s);
		}
		return als;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	private long generateId() {
		return ++IDgenerator;
	}

	public int getColumnCount() {
		return 5;
	}
	
	public Subject findSubject(String id) {
		for (Subject s: subjects) {
			if(s.getId().equals(id)) {
				return s;
			}
		}
		return null;
	}
	
	public boolean contains(String s) {
		for(Subject su:subjects) {
			if(s.equals(su.getId())) return true;
		}
		return false;
	}

	public String getColumnName(int index) {
		return this.columns.get(index);
	}

	public Subject getRow(int rowIndex) {
		return this.subjects.get(rowIndex);
	}

	public Subject getFrow(int rowIndex) {
		return this.failedSubjects.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		if (row >= subjects.size()) {
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
			Subject subject = this.subjects.get(row);
			switch (column) {
			case 0:
				return subject.getId();
			case 1:
				return subject.getName();
			case 2:
				return Integer.toString(subject.getECTS());
			case 3:
				return Integer.toString(subject.getyearOfStudy());
			case 4:
				if (subject.getSemester() == Subject.Semester_enum.W) return "WINTER";
				else return "SUMMER";
			default:
				return null;
			}
		}
		
	}
	
	
	public String getSubjectsValueAt(int row, int column) {
		Student s = StudentsController.getInstance().findSelcetedStudent(StudentTable.getInstance().getSelectedIndex());
		failedSubjects  = s.getunpassedSubjects();
		if(row >= failedSubjects.size()) {
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
			Subject subject = failedSubjects.get(row);
			switch (column) {
			case 0:
				return subject.getId();
			case 1:
				return subject.getName();
			case 2:
				return Integer.toString(subject.getECTS());
			case 3:
				return Integer.toString(subject.getyearOfStudy());
			case 4:
				if (subject.getSemester() == Semester_enum.W) return "WINTER";
				else return "SUMMER";
			default:
				return null;
			}
			
		}
	}

	public void addSubject(Subject subject) {
		this.subjects.add(subject);
	}

	
	private void initSubjects() {
		this.subjects = new ArrayList<Subject>();

		
	}

	public void editSubject() {
		for(Subject s: subjects) {
			if(s.getId().equals(editSubjectDialog.getInstance().getoldID())) {
				s.setId(editSubjectDialog.getInstance().getId());
				s.setName(editSubjectDialog.getInstance().getName());
				s.setECTS(editSubjectDialog.getInstance().getECTS());
				s.setSemester(editSubjectDialog.getInstance().getSemester());
				s.setyearOfStudy(editSubjectDialog.getInstance().getYearOfStudy());
			}
		}
	
	}
	
	public void deleteSubject(String ID) {
		for(Subject s : subjects) {
			if(s.getId().equals(ID)) {
				subjects.remove(s);
				break;
			}
		}
	}
	
}
