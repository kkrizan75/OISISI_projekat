package Model;

import java.time.LocalDate;
import java.util.Vector;

public class Student {
	
	public enum Status_enum{B,S};

	private String Name;
	private String Surname;
	private LocalDate birthDate;
	private Address address;
	private String contactPhone;
	private String eMail;
	private String Index;
	private int yearOfEnrollment;
	private int currentYear;
	private Status_enum Status;
	private float avgGrade;
	private Vector<Grade> passedSubjects;
	private Vector<Subject> unpassedSubjects;
	
	public Student() {
		super();
	}
	
	public Student(String name, String surname, LocalDate birthDate, Address address, String contactPhone,
			String eMail, String index, int yearOfEnrollment, int currentYear,Status_enum status, float ag) {
		super();
		Name = name;
		Surname = surname;
		this.birthDate = birthDate;
		this.address = address;
		this.contactPhone = contactPhone;
		this.eMail = eMail;
		Index = index;
		this.yearOfEnrollment = yearOfEnrollment;
		this.currentYear = currentYear;
		Status = status;
		avgGrade = ag;
		passedSubjects = new Vector<Grade>();
		unpassedSubjects = new Vector<Subject>();
	}
	
	public Status_enum getStatus() {
		return Status;
	}
	public void setStatus(Status_enum status) {
		Status = status;
	}
	
	public String getname() {
		return Name;
	}
	public void setname(String name) {
		name = Name;
	}
	public String getSurname() {
		return Surname;
	}
	public void setSurname(String surname) {
		Surname = surname;
	}
	public LocalDate getbirthDate() {
		return birthDate;
	}
	public void setbirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	public Address getAdress() {
		return address;
	}
	public void setAdress(Address address) {
		this.address = address;
	}
	public String getcontactPhone() {
		return contactPhone;
	}
	public void setcontactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getIndex() {
		return Index;
	}
	public void setIndex(String index) {
		Index = index;
	}
	public int getyearOfEnrollment() {
		return yearOfEnrollment;
	}
	public void setyearOfEnrollment(int yearOfEnrollment) {
		this.yearOfEnrollment = yearOfEnrollment;
	}
	public int getcurrentYear() {
		return currentYear;
	}
	public void setcurrentYear(int currentYear) {
		this.currentYear = currentYear;
	}
	public float getavgGrade() {
		return avgGrade;
	}
	public void setavgGrade(float avgGrade) {
		this.avgGrade = avgGrade;
	}
	public Vector<Subject> getunpassedSubjects() {
		return unpassedSubjects;
	}
	public void setUnpassed_subject(Subject unpassed_subject) {
		unpassedSubjects.add(unpassed_subject);
	}

	public Vector<Grade> getpassedSubjects() {
		return passedSubjects; 
	}

	public void setpassedSubjects(Grade passed) {
		passedSubjects.add(passed); 
	}
	
}
