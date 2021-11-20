package Main;

import java.time.LocalDate;

public class Grade {
	
	private Student student;
	private Subject subject;
	private int grade;
	private LocalDate exam_date;
	
	
	public Grade(Student student, Subject subject, int grade, LocalDate exam) {
		super();
		this.student = student;
		this.subject = subject;
		if(grade <= 10 || grade >=6) {
			this.grade = grade;
			//("grade cannot be less than 6 or more than 10");
		}
		this.exam_date = exam;
	}
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		if(grade <= 10 || grade >=6) {
			this.grade = grade;
			//("grade cannot be less than 6 or more than 10");
		}
	}
	public LocalDate getExam() {
		return exam_date;
	}
	public void setExam(LocalDate exam) {
		this.exam_date = exam;
	}
	
	
}
