package Model;

import java.util.Vector;



public class Subject {
	
	public enum Semester_enum{S,W};

	private String Id;
	private String Name;
	private Semester_enum semester;
	private int yearOfStudy;
	private Professor professor;
	private int ECTS;
	private Vector<Student> studentsPassed = new Vector<Student>();
	private Vector<Student> studentsFailed = new Vector<Student>();
	
	
	public Subject(String Id, String Name, Semester_enum semester, int yearOfStudy,
			Professor professor, int eCTS, Vector<Student> studentsPassed, Vector<Student> studentsFailed) {
		super();
		this.Id = Id;
		this.Name = Name;
		this.semester = semester;
		this.yearOfStudy = yearOfStudy;
		this.professor = professor;
		ECTS = eCTS;
		this.studentsPassed = studentsPassed;
		this.studentsFailed = studentsFailed;
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


	public Vector<Student> getstudentsPassed() {
		return studentsPassed;
	}


	public void setstudentsPassed(Vector<Student> studentsPassed) {
		this.studentsPassed = studentsPassed;
	}


	public Vector<Student> getstudentsFailed() {
		return studentsFailed;
	}


	public void setstudentsFailed(Vector<Student> studentsFailed) {
		this.studentsFailed = studentsFailed;
	}

}
