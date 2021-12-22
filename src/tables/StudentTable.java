package tables;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class StudentTable extends JTable {
	private static StudentTable instance = null;
	
	public static StudentTable getInstance() {
		if (instance == null) {
			instance = new StudentTable();
		}
		return instance;
	}
	
	public StudentTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// Sama JTable komponenta je implementirana postujuci MVC arhitekturu.
		this.setModel(new AbstractTableStudents());
	}

}
