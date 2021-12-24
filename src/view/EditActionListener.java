package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.StudentsController;

public class EditActionListener implements ActionListener {

	private static editStudentdialog eSd = null; 
	public void actionPerformed(ActionEvent arg0) { 
		if (TabbedPane.getInstance().getSelectedIndex() == 0) {
		if (StudentsController.getInstance().checkRow(StudentTable.getInstance().getSelectedRow())) return;
		eSd = new editStudentdialog(Main_Frame.getInstance(),"Edit Student",true);
		eSd.setVisible(true);
		}
	}
	
	public static editStudentdialog geteSd() {
		return eSd;
	}

}

