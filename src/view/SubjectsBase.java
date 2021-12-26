package view;


import java.util.ArrayList;
import java.util.List;



import Model.Subject;
import Model.Subject.Semester_enum;


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
	private List<String> columns;
	
	private SubjectsBase() {
		IDgenerator = 0;
	
		initProfessors();

		this.columns = new ArrayList<String>();
		this.columns.add("Subject ID");
		this.columns.add("Name");
		this.columns.add("ECTS");
		this.columns.add("Year of study");
		this.columns.add("Semester");
	
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

	public String getColumnName(int index) {
		return this.columns.get(index);
	}

	public Subject getRow(int rowIndex) {
		return this.subjects.get(rowIndex);
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
				return subject.getSubject_iD();
			case 1:
				return subject.getSubject_name();
			case 2:
				return Integer.toString(subject.getECTS());
			case 3:
				return Integer.toString(subject.getYear_of_study());
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

	
	private void initProfessors() {
		this.subjects = new ArrayList<Subject>();
		this.subjects.add(new Subject("123", "Kompjuteri i ostalo", Semester_enum.W, 4, null, 8, null, null ));

		
	}

	public void editSubject() {
		
	
	}
	
	public void deleteSubject(String ID) {
		for(Subject s : subjects) {
			if(s.getSubject_iD().equals(ID)) {
				subjects.remove(s);
				break;
			}
		}
	}
	
}
