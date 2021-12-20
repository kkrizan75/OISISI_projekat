package Model;

import java.util.Vector;

public class Department {
	
	private int code;
	private String name;
	private Professor boss;
	private Vector<Professor> prof_list = new Vector<Professor>();
	
	public Department(int code, String name, Professor boss, Vector<Professor> prof_list) {
		super();
		this.code = code;
		this.name = name;
		this.boss = boss;
		this.prof_list = prof_list;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
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
	public Vector<Professor> getProf_list() {
		return prof_list;
	}
	public void setProf_list(Vector<Professor> prof_list) {
		this.prof_list = prof_list;
	}
	
	
}
