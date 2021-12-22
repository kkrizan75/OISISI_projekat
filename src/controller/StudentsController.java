package controller;

public class StudentsController {
private static StudentsController instance = null;
	
	public static StudentsController getInstance() {
		if (instance == null) {
			instance = new StudentsController();
		}
		return instance;
	}
}
