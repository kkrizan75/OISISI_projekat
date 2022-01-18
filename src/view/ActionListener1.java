package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class ActionListener1 implements ActionListener {
	

	private static addStudentdialog aSd = null; 
	private static addSubjectDialog aSud = null; 
	public void actionPerformed(ActionEvent arg0) { 
		
		if (TabbedPane.getInstance().getSelectedIndex() == 0) {
		aSd = new addStudentdialog(Main_Frame.getInstance(),"Add Student", true);
		aSd.setVisible(true);
		}
		if (TabbedPane.getInstance().getSelectedIndex() == 1) {
			AddProfessorsDialog.getInstance().setVisible(true);
		}
		if (TabbedPane.getInstance().getSelectedIndex() == 2) {
			aSud = new addSubjectDialog(Main_Frame.getInstance(),"Add Subject", true);
			aSud.setVisible(true);
		}

	}
	
	public static addStudentdialog getaSd() {
		return aSd;
	}
	
	public static addSubjectDialog getaSud() {
		return aSud;
	}

}
