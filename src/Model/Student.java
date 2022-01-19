package Model;

import java.time.LocalDate;
import java.util.ArrayList;
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
	private ArrayList<Grade> passedSubjects;
	private ArrayList<Subject> unpassedSubjects;
	
	public Student() {
		super();
	}
	
	public Student(String name, String surname, LocalDate birthDate, Address address, String contactPhone,
			String eMail, String index, int yearOfEnrollment, int currentYear,Status_enum status) {
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
		passedSubjects = new ArrayList<Grade>();
		unpassedSubjects = new ArrayList<Subject>();
	}
	
	
	
	@Override
	public String toString() {
		return "Student [Name=" + Name + ", Surname=" + Surname + ", birthDate=" + birthDate + ", address=" + address
				+ ", contactPhone=" + contactPhone + ", eMail=" + eMail + ", Index=" + Index + ", yearOfEnrollment="
				+ yearOfEnrollment + ", currentYear=" + currentYear + ", Status=" + Status + ", avgGrade=" + avgGrade
				+ ", passedSubjects=" + passedSubjects + ", unpassedSubjects=" + unpassedSubjects + "]";
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
		Name = name;
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
	
	public Subject getRowSub(int rowIndex) {
		return this.unpassedSubjects.get(rowIndex);
	}
	
	public ArrayList<Subject> getunpassedSubjects() {
		return unpassedSubjects;
	}
	
	public void removeUnpassed_subject(String xd) {
		for(Subject s : unpassedSubjects) {
			if(s.getId().equals(xd)) {
				unpassedSubjects.remove(s);
				return;
			}
		}
	}
	public void setUnpassed_subject(Subject unpassed_subject) {
		for(Subject s : unpassedSubjects) {
			if(s.getId().equals(unpassed_subject.getId())) return;
		}
		unpassedSubjects.add(unpassed_subject);
	}

	public ArrayList<Grade> getpassedSubjects() {
		return passedSubjects; 
	}
	public void addPassedSubject(Grade grade) {
		passedSubjects.add(grade);
	}
	
}
