package Model;

import java.util.ArrayList;
import java.util.Vector;

public class Department {
	
	private String code;
	private String name;
	private Professor boss;
	private ArrayList<Professor> profList = new ArrayList<Professor>();
	
	public Department(String code, String name, Professor boss) {
		super();
		this.code = code;
		this.name = name;
		this.boss = boss;
	}
	
	public void addProf(Professor p) {
		profList.add(p);
	}
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Professor getBoss() {
		return boss;
	}
	public void setBoss(Professor boss) {
		this.boss = boss;
	}
	public ArrayList<Professor> getProf_list() {
		return profList;
	}
	public void setProf_list(ArrayList<Professor> prof_list) {
		this.profList = prof_list;
	}
	
	
}
