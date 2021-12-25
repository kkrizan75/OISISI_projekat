package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Model.Student;

public class ActionListener1 implements ActionListener {
	

	private static addStudentdialog aSd = null; 
	public void actionPerformed(ActionEvent arg0) { 
		
		if (TabbedPane.getInstance().getSelectedIndex() == 0) {
		aSd = new addStudentdialog(Main_Frame.getInstance(),"Add Student", true);
		aSd.setVisible(true);
		}
	}
	
	public static addStudentdialog getaSd() {
		return aSd;
	}

}
