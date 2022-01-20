package view;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Model.Address;
import Model.Department;
import Model.Professor;
import Model.Subject;
import controller.Read;




public class ProfessorsBase {

	
		private static ProfessorsBase instance = null;

		public static ProfessorsBase getInstance() {
			if (instance == null) {
				instance = new ProfessorsBase();
			}
			return instance;
		}

		private long IDgenerator;

		private List<Professor> professors;
		private List<String> kolone;

		private ProfessorsBase() {
			IDgenerator = 0;
		
			initProfessors();

			this.kolone = new ArrayList<String>();
			this.kolone.add("Name");
			this.kolone.add("Surname");
			this.kolone.add("Title");
			this.kolone.add("E-mail");
		
		}
		
		public ArrayList<Professor> getProfDEP(String s) {
			ArrayList<Professor> ret = new ArrayList<Professor>();
			ArrayList<Professor> profs = null;
			boolean b = false; 
			for(Department d : Read.getInstance().getDep().values()) {
				if(d == null) continue;
				if(d.getCode().equals(s)) {
					profs = d.getProf_list();
				if(profs == null) return null;
					for(Professor p1 : profs) {
							if(d.getBoss().getID_number().equals(p1.getID_number())) continue;
							if((p1.getTitle().equals("VANREDNI_PROFESOR")||p1.getTitle().equals("REDOVNI_PROFESOR")
									&& p1.getYears_of_work_exp() > 5))
							ret.add(p1);
						}
				break;	
					}
			}
			return ret;
			
		}
		
		public ArrayList<Subject> SubjectsofProfessor(Professor p) {
			for (Professor p1 : professors) {
				if(p1.getID_number().equals(p.getID_number())) return p1.getList_of_subjects();
			}
			return null;
		}

		public List<Professor> getProfessors() {
			return professors;
		}

		public void setProfessors(List<Professor> professors) {
			this.professors = professors;
		}

		private long generateId() {
			return ++IDgenerator;
		}

		public int getColumnCount() {
			return 4;
		}

		public String getColumnName(int index) {
			return this.kolone.get(index);
		}

		public Professor getRow(int rowIndex) {
			return this.professors.get(rowIndex);
		}
		
		public Professor findProfa(String id) {
			for (Professor p : professors) {
				if(p.getID_number().equals(id)) return p;
			}
			return null;
		}

		public String getValueAt(int row, int column) {
			if (row >= professors.size()) {
				switch (column) {
				case 0:
					return "";
				case 1:
					return "";
				case 2:
					return "";
				case 3:
					return "";
				default:
					return null;
				}
			
			} else {
				Professor professor = this.professors.get(row);
				switch (column) {
				case 0:
					return professor.getName();
				case 1:
					return professor.getSurname();
				case 2:
					return professor.getTitle();
				case 3:
					return professor.getE_mail();
				default:
					return null;
				}
			}
			
		}

		public void addProfessor(Professor professor) {
			this.professors.add(professor);
		}

		
		private void initProfessors() {
			this.professors = new ArrayList<Professor>();
			this.professors.add(new Professor("Rale","Nebojsic","Phd","prof1@gmail.com", "0601233120", new Address("Topolska", "18", "Smederevo", "Srbija"),
														new Address("Ulica", "11", "Nis", "Srbija"),
					"012345678", LocalDate.of(1955, 11, 11), 
					12));
			
		}
		
		

		public void editProfessor() {
			
			for (Professor prof : professors) {
				if (prof.getID_number().equals(EditProfessorsDialog.getInstance().getCurrentID())) {
					prof.setName(EditProfessorsDialog.getInstance().getName());
					prof.setSurname(EditProfessorsDialog.getInstance().getSurname());
					prof.setTitle(EditProfessorsDialog.getInstance().getTitleProf());
					prof.setBirth_date(EditProfessorsDialog.getInstance().getBirthDate());
					prof.setAddress_of_residence(EditProfessorsDialog.getInstance().getHomeAddress());
					prof.setOffice_address(EditProfessorsDialog.getInstance().getOffAddress());
					prof.setContact_phone(EditProfessorsDialog.getInstance().getPhoneNum());
					prof.setE_mail(EditProfessorsDialog.getInstance().geteMail());
					prof.setID_number(EditProfessorsDialog.getInstance().getId());
					prof.setYears_of_work_exp(EditProfessorsDialog.getInstance().getyExp());
				}
			}
		}
		
		public void deleteProfessor(String ID) {
			for(Professor p : professors) {
				if(p.getID_number().equals(ID)) {
					professors.remove(p);
					break;
				}
			}
		}
	}
