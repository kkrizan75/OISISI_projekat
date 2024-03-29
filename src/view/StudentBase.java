package view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Model.Address;
import Model.Grade;
import Model.Student;
import Model.Student.Status_enum;
import Model.Subject;
import Model.Subject.Semester_enum;

public class StudentBase {
	private static StudentBase instance = null;

	public static StudentBase getInstance() {
		if (instance == null) {
			instance = new StudentBase();
		}
		return instance;
	}

	private int generator;

	private List<Student> Studenti;
	private List<String> kolone;

	private StudentBase() {
		generator = -1;
		Studenti = new ArrayList<Student>();
		initStudente();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Index");
		this.kolone.add("Name");
		this.kolone.add("Surname");
		this.kolone.add("currentyear");
		this.kolone.add("Status");
		this.kolone.add("avgGrade");
	
	}

	private void initStudente() {

		
	}
	
	public boolean contains(String ind) {
		for(Student s : Studenti) {
			if(s.getIndex().equals(ind)) {
				return true;
			}
		}
		return false;
	}

	public List<Student> getStudenti() {
		return Studenti;
	}
	
	public Student findStudent(String xd) {
		for(Student s : Studenti) {
			if(s.getIndex().equals(xd)) return s;
		}
		return null;
	}

	public void setStudenti(List<Student> Studenti) {
		this.Studenti = Studenti;
	}

	private int generateId() {
		return ++generator;
	}

	public int getColumnCount() {
		return 6;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Student getRow(int rowIndex) {
		return this.Studenti.get(rowIndex);
	}
	

	public String getValueAt(int row, int column) {
		if (row >= Studenti.size()) {
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
			case 5:
				return "";
			default:
				return null;
			}
		
		} else {
			Student Student = this.Studenti.get(row);
			switch (column) {
			case 0:
				return Student.getIndex();
			case 1:
				return Student.getname();
			case 2:
				return Student.getSurname();
			case 3:
				return Long.toString(Student.getcurrentYear());
			case 4:
				if (Student.getStatus() == Status_enum.B) return "B";
				else return "S";
			case 5:
				return Float.toString(Student.getavgGrade());
			default:
				return null;
			}
		}
		
	}
	

	public void dodajStudenta(Student student) {
		Studenti.add(student);
	}

	public void izbrisiStudenta(int id) {
		Studenti.remove(id);
	}
	
	public void findAvgGrade(String index) {
		float avg = 0;
		for(Student s : Studenti) {
			if(s.getIndex().equals(index)) {
				for(Grade g : s.getpassedSubjects()) {
					avg += g.getGrade();
				}
			avg /= s.getpassedSubjects().size();
			s.setavgGrade(avg);
			break;
			}
		}
		
			
	}
	
	public void deleteGrade(String index, Grade g) {
		for(Student s : Studenti) {
			if(s.getIndex().equals(index)) {
				s.getpassedSubjects().remove(g);
				s.setUnpassed_subject(g.getSubject());
				break;
			}
		}
		
	}
	
	public void addGrade(String index, Grade g) {
		for(Student s : Studenti) {
			if(s.getIndex().equals(index)) {
				s.addPassedSubject(g);
				s.getunpassedSubjects().remove(g.getSubject());
				break;
			}
		}
	}

	public void izmeniStudenta() {
			
		for (Student Student : Studenti) {
			if (Student.getIndex().equals(editStudentdialog.getInstance().getoldIND())) {
				Student.setIndex(editStudentdialog.getInstance().getIndex());
				Student.setname(editStudentdialog.getInstance().getName());
				Student.setSurname(editStudentdialog.getInstance().getSurname());
				Student.setStatus(editStudentdialog.getInstance().getStatus());
				Student.setcurrentYear(editStudentdialog.getInstance().getCurrentYear());
				Student.setAdress(editStudentdialog.getInstance().getAddress());
				Student.setbirthDate(editStudentdialog.getInstance().getBirthDate());
				Student.setcontactPhone(editStudentdialog.getInstance().getContactPhone());
				Student.setyearOfEnrollment(editStudentdialog.getInstance().getYearOfEnrollment());
			}
		}
		//return true;
	}
}
