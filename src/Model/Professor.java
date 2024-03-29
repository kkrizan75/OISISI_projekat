package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;


public class Professor {

	private String surname;
	private String name;
	private LocalDate birth_date;
	private Address address_of_residence;
	private String contact_phone;
	private String e_mail;
	private Address office_address;
	private String ID_number;
	private String title;
	private int years_of_work_exp;
	private ArrayList<Subject> list_of_subjects;
	
	public Professor(String name, String surname, String title,String eMail ,
			String contactPhone,Address addressOfResidence , Address officeAddress, String idNumber, LocalDate birthDate,
			int yearsOfWorkingExp) {
		super();
		this.surname = surname;
		this.name = name;
		this.birth_date = birthDate;
		this.address_of_residence = addressOfResidence;
		this.contact_phone = contactPhone;
		this.e_mail = eMail;
		this.office_address = officeAddress;
		ID_number = idNumber;
		this.title = title;
		this.list_of_subjects = new ArrayList<Subject>();
		this.years_of_work_exp = yearsOfWorkingExp;
	}
	
	public Subject getRowSub(int rowIndex) {
		return this.list_of_subjects.get(rowIndex);
	}
	
	public void removeSubj(Subject s) {
		list_of_subjects.remove(s);
	}
	
	public void addSubj(Subject s) {
		list_of_subjects.add(s);
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(LocalDate birth_date) {
		this.birth_date = birth_date;
	}

	public Address getAddress_of_residence() {
		return address_of_residence;
	}

	public void setAddress_of_residence(Address address_of_residence) {
		this.address_of_residence = address_of_residence;
	}

	public String getContact_phone() {
		return contact_phone;
	}

	public void setContact_phone(String contact_phone) {
		this.contact_phone = contact_phone;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public Address getOffice_address() {
		return office_address;
	}

	public void setOffice_address(Address office_address) {
		this.office_address = office_address;
	}

	public String getID_number() {
		return ID_number;
	}

	public void setID_number(String iD_number) {
		ID_number = iD_number;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYears_of_work_exp() {
		return years_of_work_exp;
	}

	public void setYears_of_work_exp(int years_of_work_exp) {
		this.years_of_work_exp = years_of_work_exp;
	}

	public ArrayList<Subject> getList_of_subjects() {
		return list_of_subjects;
	}

	public void setList_of_subjects(ArrayList<Subject> list_of_subjects) {
		this.list_of_subjects = list_of_subjects;
	}
	
	@Override
	public String toString() {
		return name + " " + surname;
	}
	
}
