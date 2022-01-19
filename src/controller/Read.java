package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.HashMap;

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

public class Read {
	
	private HashMap<Integer,Address> hmA = new HashMap<Integer,Address>();
	private HashMap<Department,Integer> hmD = new HashMap<Department,Integer>();
	private HashMap<Integer,Student> hmS = new HashMap<Integer,Student>();
	private HashMap<Integer,Professor> hmP = new HashMap<Integer,Professor>();
	private HashMap<Integer,Subject> hmSu = new HashMap<Integer,Subject>();
	//private HashMap<Integer,Grade> hmG = new HashMap<Integer,Grade>();
	
	private static Read instance= null;
	
	public static Read getInstance() {
		if(instance == null) {
			instance = new Read();
			}
		return instance;
	}
	
	public void read() throws IOException {
		File f = null;
		
		f = new File("OSISI-BASE\\Adrese.txt");
		BufferedReader reader;
		reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
		try {
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] lineL = line.split("\t+",12);
				Address a = new Address(lineL[1],lineL[2],lineL[3],lineL[4]);
				hmA.put(Integer.parseInt(lineL[0]),a);
			}
		} finally {
		reader.close();
		}
		f = new File("OSISI-BASE\\Studenti.txt");
		reader = new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF8"));
		try {
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] lineL = line.split("\t+",12);
				String[] lD = lineL[5].split("\\.",4);
				LocalDate lc = LocalDate.of(Integer.parseInt(lD[2]), Integer.parseInt(lD[1]), Integer.parseInt(lD[0]));
				Address a = null;
				if(lineL[6].equals("null"));
				else a = hmA.get(Integer.parseInt(lineL[6]));
				Status_enum se = Status_enum.S;
				if(lineL[9].equals("B")) se = Status_enum.B;
				Student s = new Student(lineL[2],lineL[3],lc,a,lineL[7],lineL[8],lineL[1],Integer.parseInt(lineL[10]),Integer.parseInt(lineL[4]),se);
				StudentBase.getInstance().dodajStudenta(s);
				hmS.put(Integer.parseInt(lineL[0]), s);
			}
		} finally {
		reader.close();
		}
		f = new File("OSISI-BASE\\Katedre.txt");
		reader = new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF8"));
		try {
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] lineL = line.split("\t+",12);
				Department d = new Department(lineL[1],lineL[2],null);
				hmD.put(d, Integer.parseInt(lineL[0]));
			}
		} finally {
		reader.close();
		}
		
		f = new File("OSISI-BASE\\Profesori.txt");
		reader = new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF8"));
		try {
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] lineL = line.split("\t+",12);
				Address a = null;
				if(lineL[5].equals("null"));
				else a = hmA.get(Integer.parseInt(lineL[5]));
				Address a2 = null;
				if(lineL[8].equals("null"));
				else a2 = hmA.get(Integer.parseInt(lineL[8]));
				String[] lD = lineL[4].split("\\.",4);
				LocalDate lc = LocalDate.of(Integer.parseInt(lD[2]), Integer.parseInt(lD[1]), Integer.parseInt(lD[0]));
				Professor p = new Professor(lineL[2],lineL[3],lineL[10],lineL[7],lineL[6],a,a2,lineL[1],lc,Integer.parseInt(lineL[9]));
				ProfessorsBase.getInstance().addProfessor(p);
				hmP.put(Integer.parseInt(lineL[0]), p);
			}
		} finally {
		reader.close();
		}
		
		f = new File("OSISI-BASE\\Predmeti.txt");
		reader = new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF8"));
		try {
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] lineL = line.split("\t+",12);
				Semester_enum se = Semester_enum.S;
				if(lineL[6].equals("ZIMSKI")) se = Semester_enum.W;
				Professor p = null;
				if(lineL[5].equals("null"));
				else p = hmP.get(Integer.parseInt(lineL[5]));
				Subject s = new Subject(lineL[1],lineL[2],se,Integer.parseInt(lineL[3]),p,Integer.parseInt(lineL[4]),null,null);
				SubjectsBase.getInstance().addSubject(s);
				hmSu.put(Integer.parseInt(lineL[0]), s);
			}
		} finally {
		reader.close();
		}
		
		f = new File("OSISI-BASE\\NepolozeniP.txt");
		reader = new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF8"));
		try {
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] lineL = line.split("\t+",12);
				StudentBase.getInstance().findStudent(hmS.get(Integer.parseInt(lineL[0])).getIndex()).setUnpassed_subject(SubjectsBase.getInstance().findSubject(hmSu.get(Integer.parseInt(lineL[1])).getId()));
			}
		} finally {
		reader.close();
		}
		
		f = new File("OSISI-BASE\\Ocjene.txt");
		reader = new BufferedReader(new InputStreamReader(new FileInputStream(f),"UTF8"));
		try {
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] lineL = line.split("\t+",12);
				String[] lD = lineL[3].split("\\.",4);
				LocalDate lc = LocalDate.of(Integer.parseInt(lD[2]), Integer.parseInt(lD[1]), Integer.parseInt(lD[0]));
				Grade g = new Grade(StudentBase.getInstance().findStudent(hmS.get(Integer.parseInt(lineL[0])).getIndex()),SubjectsBase.getInstance().findSubject(hmSu.get(Integer.parseInt(lineL[1])).getId())
						,Integer.parseInt(lineL[2]),lc);
				StudentBase.getInstance().findStudent(hmS.get(Integer.parseInt(lineL[0])).getIndex()).addPassedSubject(g);
			}
		} finally {
		reader.close();
		}
	}
}
