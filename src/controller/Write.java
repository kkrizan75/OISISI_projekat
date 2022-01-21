package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import Model.Address;
import Model.Department;
import Model.Grade;
import Model.Professor;
import Model.Student;
import Model.Student.Status_enum;
import Model.Subject;
import Model.Subject.Semester_enum;
import view.ProfessorsBase;
import view.StudentBase;
import view.SubjectsBase;

import java.io.FileOutputStream;
import java.io.IOException;

public class Write {

	private static Write instance = null;
	private HashMap<Integer, Professor> profMap = new HashMap<Integer, Professor>();
	private HashMap<Integer, Address> addressMap = new HashMap<Integer, Address>();
	private HashMap<Integer, Subject> subMap = new HashMap<Integer, Subject>();
	private HashMap<Integer, ArrayList<Integer>> subjf = new HashMap<Integer, ArrayList<Integer>>();
	private ArrayList<GradeID> listg = new ArrayList<GradeID>();
	private int addressID;
	
	public static Write getInstance() {
		if(instance == null) {
			instance = new Write();
		}
		return instance;
	}
	
	public class GradeID {
		
		private int studID;
		private int subjID;
		private int grade;
		private String date;
		
		
		public GradeID(int studID, int subjID, int grade, String date) {
			super();
			this.studID = studID;
			this.subjID = subjID;
			this.grade = grade;
			this.date = date;
		}
		
		public int getStudID() {
			return studID;
		
		}
		public void setStudID(int studID) {
			this.studID = studID;
		}
		public int getSubjID() {
			return subjID;
		}
		public void setSubjID(int subjID) {
			this.subjID = subjID;
		}
		public int getGrade() {
			return grade;
		}
		public void setGrade(int grade) {
			this.grade = grade;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		
	}
	
	public int findAddressID(Address a) {
		for(Integer key : addressMap.keySet()) {
			if(Objects.equals(addressMap.get(key), a)) 
				return key;
		}
		return -1;
	}
	
	public int findProfessorID(Professor p) {
		for(Integer key : profMap.keySet()) {
			if(Objects.equals(profMap.get(key), p)) {
				return key;
			}
		}
		return -1;
	}
	
	public int findSubjectID(Subject s) {
		for(Integer key : subMap.keySet()) {
			if(Objects.equals(subMap.get(key), s)) {
				return key;
			}
		}
		return -1;
	}
	
	private Write() {
		
	}
	
	public void Save() throws IOException {
		BufferedWriter out = null;
		File f = new File("OSISI-BASE\\\\Profesori.txt");
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), "UTF8"));
		}catch (IOException e) {
			e.printStackTrace();
		}
		try {
			int profID = 0;
			int depID = -1;
			addressID = 0;
			int addressRes = 0;
			int addressOff = 0;
			for(Professor prof : ProfessorsBase.getInstance().getProfessors()) {
				profID++;
				if(addressMap.containsValue(prof.getAddress_of_residence())) {
					addressRes = findAddressID(prof.getAddress_of_residence());
				}else {
					if(addressMap.isEmpty()) {
						addressMap.put( 1, prof.getAddress_of_residence());
						addressID = 1;
						addressRes = 1;
					}else {
						addressMap.put(++addressID, prof.getAddress_of_residence());
						addressRes = addressID;
					}
				}
				
				if(addressMap.containsValue(prof.getOffice_address())) {
					addressOff = findAddressID(prof.getOffice_address());
				}else {
					addressMap.put(++addressID, prof.getOffice_address());
					addressOff = addressID;
				}
				
				HashMap<Integer,Department> hmd = Read.getInstance().getDep();
				for(int i = 1; i <= 6; i ++) {
					ArrayList<Professor> profList = hmd.get(i).getProf_list();
					for(Professor p : profList) {
						if(p == prof) {
							depID = i;
							break;
						}
					}
				}
				String[] date = prof.getBirth_date().toString().split("\\-",4);
				String dateProf = date[2] + "." + date[1] + "."+ date[0] + ".";
				profMap.put(profID, prof);
				StringBuilder s = new StringBuilder("");
				s.append(profID + "\t" + 
								prof.getID_number() + "\t" + 
								prof.getName() + "\t" +
								prof.getSurname() + "\t" + 
								dateProf  + "\t" +
								addressRes + "\t" +
								prof.getContact_phone() + "\t" + 
								prof.getE_mail() + "\t" +
								addressOff + "\t" + 
								prof.getYears_of_work_exp() + "\t" +
								prof.getTitle() + "\t" +
								depID);
				out.write(s.toString());
				out.write("\n");
				
			}
		} finally {
				if(out != null)
					try {
						out.close();
					}catch(IOException e) {
						e.printStackTrace();
					}
		}
	
		File fs = new File("OSISI-BASE\\\\Predmeti.txt");
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fs), "UTF8"));
		}catch (IOException e) {
			e.printStackTrace();
		}
		try {
			int subjID = 0;
			for(Subject s : SubjectsBase.getInstance().getSubjects()) {
				subjID++;
				String profID = "";
				Professor p = s.getProfessor();
				if(p != null) {
					if(profMap.containsValue(p)) {
						profID = Integer.toString(findProfessorID(p));
					}
				}else {
					profID = "null";
				}
				String semester;
				if(s.getSemester() == Semester_enum.W) 
					semester = "ZIMSKI";
				else
					semester = "LETNJI";
				subMap.put(subjID, s);
				StringBuilder sb = new StringBuilder("");
				sb.append(subjID + "\t" + 
							s.getId() + "\t" + 
							s.getName() + "\t" +
							s.getyearOfStudy() + "\t" +
							s.getECTS() + "\t" + 
							profID + "\t" +
							semester);
				out.write(sb.toString());
				out.write("\n");
			}
			
			
		} finally {
				if(out != null)
					try {
						out.close();
					}catch(IOException e) {
						e.printStackTrace();
					}
		}
		
		File fst = new File("OSISI-BASE\\\\Studenti.txt");
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fst), "UTF8"));
		}catch (IOException e) {
			e.printStackTrace();
		}
		try {
			int studID = 0;
			for(Student s : StudentBase.getInstance().getStudenti()) {
				studID++;
				String addressRes = "";
				String[] date =  s.getbirthDate().toString().split("\\-",4);
				String dateStud = date[2] + "." + date[1] + "."+ date[0] + ".";
				if(s.getAdressx() != null) {
					if(addressMap.containsValue(s.getAdressx())) {
						addressRes = Integer.toString(findAddressID(s.getAdressx()));
					}else {
						if(addressMap.isEmpty()) {
							addressMap.put( 1, s.getAdressx());
							addressID = 1;
							addressRes = "1";
						}else {
							addressMap.put(++addressID, s.getAdressx());
							addressRes = Integer.toString(addressID);
						}
					}
				}else {
					addressRes = "null";
				}
				String status = "";
				if(s.getStatus() == Status_enum.B) {
					status = "B";
				}else
					status = "S";
				if(!s.getunpassedSubjects().isEmpty()) {
					ArrayList<Integer> list = new ArrayList<Integer>();
					for(Subject sj : s.getunpassedSubjects()) {
						list.add(findSubjectID(sj));
						
					}
					subjf.put(studID, list);
				}
				if(!s.getpassedSubjects().isEmpty()) {
					for(Grade g : s.getpassedSubjects()) {
						String[] dateg =  g.getExam().toString().split("\\-",4);
						String dateExam = dateg[2] + "." + dateg[1] + "."+ dateg[0] + ".";
						GradeID gr = new GradeID(studID, findSubjectID(g.getSubject()), g.getGrade(), dateExam);
						listg.add(gr);
					}
				}
				
				StringBuilder sb = new StringBuilder("");
				sb.append(studID +  "\t" + 
							s.getIndex() + "\t" + 
							s.getname() + "\t" +
							s.getSurname() + "\t" +
							s.getcurrentYear() + "\t" +
							dateStud + "\t" +
							addressRes + "\t" +
							s.getcontactPhone() + "\t" +
							s.geteMail() + "\t" + 
							status + "\t" +
							s.getyearOfEnrollment());
			
				out.write(sb.toString());
				out.write("\n");
				
			}
			
			
		} finally {
				if(out != null)
					try {
						out.close();
					}catch(IOException e) {
						e.printStackTrace();
					}
		}
		File ffs = new File("OSISI-BASE\\\\NepolozeniP.txt");
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ffs), "UTF8"));
		}catch (IOException e) {
			e.printStackTrace();
		}
		try {
			String write;
			for(Integer key : subjf.keySet()) {
				for(int i : subjf.get(key)) {
					write = Integer.toString(key) + "\t" + Integer.toString(i);
					out.write(write);
					out.write("\n");
				}
			}
			
			
		} finally {
				if(out != null)
					try {
						out.close();
					}catch(IOException e) {
						e.printStackTrace();
					}
		}
		
		File fg = new File("OSISI-BASE\\\\Ocjene.txt");
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fg), "UTF8"));
		}catch (IOException e) {
			e.printStackTrace();
		}
		try {
			String write;
			for(GradeID grade : listg) {
					write = Integer.toString(grade.getStudID()) + "\t" + Integer.toString(grade.getSubjID()) + "\t" + Integer.toString(grade.getGrade()) + "\t" + grade.getDate();
					out.write(write);
					out.write("\n");
				
			}
			
			
		} finally {
				if(out != null)
					try {
						out.close();
					}catch(IOException e) {
						e.printStackTrace();
					}
		}
		
		File fd = new File("OSISI-BASE\\\\Katedre.txt");
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fd), "UTF8"));
		}catch (IOException e) {
			e.printStackTrace();
		}
		try {
			String write;
			HashMap<Integer, Department> hmd = Read.getInstance().getDep();
			for(Integer key : hmd.keySet()) {
				Department d = hmd.get(key);
				write = Integer.toString(key) + "\t" + d.getCode() + "\t" + d.getName() + "\t" + Integer.toString(findProfessorID(d.getBoss()));
				out.write(write);
				out.write("\n");
				
			}
			
			
		} finally {
				if(out != null)
					try {
						out.close();
					}catch(IOException e) {
						e.printStackTrace();
					}
		}
		File fa = new File("OSISI-BASE\\\\Adrese.txt");
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fa), "UTF8"));
		}catch (IOException e) {
			e.printStackTrace();
		}
		try {
			String write;
			for(Integer key : addressMap.keySet()) {
				Address a = addressMap.get(key);
				write = Integer.toString(key) + "\t" + a.getStreet() + "\t" + a.getStreetnum() + "\t" + a.getCity() + "\t" + a.getCountry();
				out.write(write);
				out.write("\n");
				
			}
			
			
		} finally {
				if(out != null)
					try {
						out.close();
					}catch(IOException e) {
						e.printStackTrace();
					}
		}
		
	}
		
}
	
	
