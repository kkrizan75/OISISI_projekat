package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.ProfessorsController;
import controller.Read;
import controller.StudentsController;
import controller.SubjectsController;

public class EditActionListener implements ActionListener {

	private static editStudentdialog eSd = null; 
	private static editSubjectDialog eSud = null;
	public void actionPerformed(ActionEvent arg0) { 
		if (TabbedPane.getInstance().getSelectedIndex() == 0) {
		if (StudentsController.getInstance().checkRow(StudentTable.getInstance().getSelectedIndex())) return;
		eSd = new editStudentdialog(Main_Frame.getInstance(),"Edit Student",true);
		eSd.setVisible(true);
		}
		if (TabbedPane.getInstance().getSelectedIndex() == 1) {
			if (!ProfessorsController.getInstance().checkRow(ProfessorsTable.getInstance().getSelectedIndex()))
				EditProfessorsDialog.getInstance().setVisible(true);
		}
		if (TabbedPane.getInstance().getSelectedIndex() == 2) {
			if (SubjectsController.getInstance().checkRow(SubjectsTable.getInstance().getSelectedRow())) return;
			eSud = new editSubjectDialog(Main_Frame.getInstance(),"Edit Subject",true);
			eSud.setVisible(true);
		}
	}
	
	public static editStudentdialog geteSd() {
		return eSd;
	}
	
	public static editSubjectDialog gateSud() {
		return eSud;
	}

}

