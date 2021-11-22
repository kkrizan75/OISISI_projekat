package Main;

import java.time.LocalDate;
import java.util.Vector;

public class Student {
	
	public enum Status_enum{B,S};

	private String Name;
	private String Surname;
	private LocalDate Birth_date;
	private Address address;
	private String Conntact_phone;
	private String E_mail;
	private String Index;
	private int Year_of_enrollment;
	private int Current_year;
	private Status_enum Status;
	private float Avg_grade;
	private Vector<Grade> Passed_subjects = new Vector<Grade>();
	private Vector<Subject> Unpassed_subjects = new Vector<Subject>();
	
	
	
	public Student(String name, String surname, LocalDate birth_date, Address address, String conntact_phone,
			String e_mail, String index, int year_of_enrollment, int current_year,Status_enum status) {
		super();
		Name = name;
		Surname = surname;
		Birth_date = birth_date;
		this.address = address;
		Conntact_phone = conntact_phone;
		E_mail = e_mail;
		Index = index;
		Year_of_enrollment = year_of_enrollment;
		Current_year = current_year;
		Status = status;
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
	public LocalDate getBirth_date() {
		return Birth_date;
	}
	public void setBirth_date(LocalDate birth_date) {
		Birth_date = birth_date;
	}
	public Address getAdress() {
		return address;
	}
	public void setAdress(Address address) {
		this.address = address;
	}
	public String getConntact_phone() {
		return Conntact_phone;
	}
	public void setConntact_phone(String conntact_phone) {
		Conntact_phone = conntact_phone;
	}
	public String getE_mail() {
		return E_mail;
	}
	public void setE_mail(String e_mail) {
		E_mail = e_mail;
	}
	public String getIndex() {
		return Index;
	}
	public void setIndex(String index) {
		Index = index;
	}
	public int getYear_of_enrollment() {
		return Year_of_enrollment;
	}
	public void setYear_of_enrollment(int year_of_enrollment) {
		Year_of_enrollment = year_of_enrollment;
	}
	public int getCurrent_year() {
		return Current_year;
	}
	public void setCurrent_year(int current_year) {
		Current_year = current_year;
	}
	public float getAvg_grade() {
		return Avg_grade;
	}
	public void setAvg_grade(float avg_grade) {
		Avg_grade = avg_grade;
	}
	public Vector<Subject> getUnpassed_subjects() {
		return Unpassed_subjects;
	}
	public void setUnpassed_subject(Subject unpassed_subject) {
		Unpassed_subjects.add(unpassed_subject);
	}

	public Vector<Grade> getPassed_subjects() {
		return Passed_subjects; 
	}

	public void setPassed_subjects(Grade passed) {
		Passed_subjects.add(passed); 
	}
	
}
