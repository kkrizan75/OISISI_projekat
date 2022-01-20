package Model;

import java.util.ArrayList;
import java.util.Vector;



public class Subject {
	
	public enum Semester_enum{S,W};

	private String Id;
	private String Name;
	private Semester_enum semester;
	private int yearOfStudy;
	private Professor professor;
	private int ECTS;
	private ArrayList<Student> studentsPassed;
	private ArrayList<Student> studentsFailed;
	
	
	public Subject(String Id, String Name, Semester_enum semester, int yearOfStudy,
			Professor professor, int eCTS) {
		super();
		this.Id = Id;
		this.Name = Name;
		this.semester = semester;
		this.yearOfStudy = yearOfStudy;
		this.professor = professor;
		ECTS = eCTS;
		studentsFailed = new ArrayList<Student>();
		studentsPassed = new ArrayList<Student>();
		
	}


	public String getId() {
		return Id;
	}


	public void setId(String Id) {
		this.Id = Id;
	}


	public String getName() {
		return Name;
	}


	public void setName(String Name) {
		this.Name = Name;
	}


	public Semester_enum getSemester() {
		return semester;
	}


	public void setSemester(Semester_enum semester) {
		this.semester = semester;
	}


	public int getyearOfStudy() {
		return yearOfStudy;
	}


	public void setyearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}


	public Professor getProfessor() {
		return professor;
	}


	public void setProfessor(Professor professor) {
		this.professor = professor;
	}


	public int getECTS() {
		return ECTS;
	}


	public void setECTS(int eCTS) {
		ECTS = eCTS;
	}
	
	public void addStudentsFailed(Student s) {
		studentsFailed.add(s);
	}

	public void addStudentsPassed(Student s) {
		studentsPassed.add(s);
	}

	public ArrayList<Student> getstudentsPassed() {
		return studentsPassed;
	}


	public void setstudentsPassed(ArrayList<Student> studentsPassed) {
		this.studentsPassed = studentsPassed;
	}


	public ArrayList<Student> getstudentsFailed() {
		return studentsFailed;
	}


	public void setstudentsFailed(ArrayList<Student> studentsFailed) {
		this.studentsFailed = studentsFailed;
	}

}
