package tables;

import java.util.ArrayList;
import java.util.List;

import Model.Student;
import Model.Student.Status_enum;

public class StudentBase {
	private static StudentBase instance = null;

	public static StudentBase getInstance() {
		if (instance == null) {
			instance = new StudentBase();
		}
		return instance;
	}

	private long generator;

	private List<Student> Studenti;
	private List<String> kolone;

	private StudentBase() {
		generator = 0;
	
		initStudente();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Index");
		this.kolone.add("Name");
		this.kolone.add("Surname");
		this.kolone.add("currentyear");
		this.kolone.add("Status");
		this.kolone.add("avgGrade");
	
	}

	private void initStudente() {
		this.Studenti = new ArrayList<Student>();

		
	}

	public List<Student> getStudenti() {
		return Studenti;
	}

	public void setStudenti(List<Student> Studenti) {
		this.Studenti = Studenti;
	}

	private long generateId() {
		return ++generator;
	}

	public int getColumnCount() {
		return 6;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Student getRow(int rowIndex) {
		return this.Studenti.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		if (row >= Studenti.size()) {
			switch (column) {
			case 0:
				return "";
			case 1:
				return "";
			case 2:
				return "";
			case 3:
				return "";
			case 4:
				return "";
			case 5:
				return "";
			default:
				return null;
			}
		
		} else {
			Student Student = this.Studenti.get(row);
			switch (column) {
			case 0:
				return Student.getIndex();
			case 1:
				return Student.getname();
			case 2:
				return Student.getSurname();
			case 3:
				return Long.toString(Student.getcurrentYear());
			case 4:
				if (Student.getStatus() == Status_enum.B) return "B";
				else return "S";
			case 5:
				return Float.toString(Student.getavgGrade());
			default:
				return null;
			}
		}
		
	}

	public void dodajStudenta(String ime, String prezime, String klub) {
		this.Studenti.add(new Student());
	}

	public void izbrisiStudenta(String id) {
		for (Student Student : Studenti) {
			if (Student.getIndex().equals(id)) {
				Studenti.remove(Student);
				break;
			}
		}
	}

	public void izmeniStudenta(String id, String ime, String prezime, String klub,Status_enum se, int cy,float ag) {
		for (Student Student : Studenti) {
			if (Student.getIndex().equals(id)) {
				Student.setname(ime);
				Student.setSurname(prezime);
				Student.setStatus(se);
				Student.setcurrentYear(cy);
				Student.setavgGrade(ag);
			}
		}
	}
}
