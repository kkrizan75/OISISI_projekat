package Model;

import java.util.Vector;

import Model.Subject.Semester_enum;

public class Subject {
	
public enum Semester_enum{LETNJI,ZIMSKI};
	
	private String subject_iD;
	private String subject_name;
	private Semester_enum semester;
	private int year_of_study;
	private Professor professor;
	private int ECTS;
	private Vector<Student> students_passed = new Vector<Student>();
	private Vector<Student> students_failed = new Vector<Student>();
	
	
	public Subject(String subject_iD, String subject_name, Semester_enum semester, int year_of_study,
			Professor professor, int eCTS, Vector<Student> students_passed, Vector<Student> students_failed) {
		super();
		this.subject_iD = subject_iD;
		this.subject_name = subject_name;
		this.semester = semester;
		this.year_of_study = year_of_study;
		this.professor = professor;
		ECTS = eCTS;
		this.students_passed = students_passed;
		this.students_failed = students_failed;
	}


	public String getSubject_iD() {
		return subject_iD;
	}


	public void setSubject_iD(String subject_iD) {
		this.subject_iD = subject_iD;
	}


	public String getSubject_name() {
		return subject_name;
	}


	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}


	public Semester_enum getSemester() {
		return semester;
	}


	public void setSemester(Semester_enum semester) {
		this.semester = semester;
	}


	public int getYear_of_study() {
		return year_of_study;
	}


	public void setYear_of_study(int year_of_study) {
		this.year_of_study = year_of_study;
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


	public Vector<Student> getStudents_passed() {
		return students_passed;
	}


	public void setStudents_passed(Vector<Student> students_passed) {
		this.students_passed = students_passed;
	}


	public Vector<Student> getStudents_failed() {
		return students_failed;
	}


	public void setStudents_failed(Vector<Student> students_failed) {
		this.students_failed = students_failed;
	}

}
