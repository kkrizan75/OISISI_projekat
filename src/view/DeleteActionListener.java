package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.ProfessorsController;
import controller.StudentsController;

public class DeleteActionListener implements ActionListener {
	

		@Override
		public void actionPerformed(ActionEvent e) {
			if (TabbedPane.getInstance().getSelectedIndex() == 0) {
			StudentsController.getInstance().deleteStudent(StudentTable.getInstance().getSelectedRow());
			}
			
			if (TabbedPane.getInstance().getSelectedIndex() == 1) {
				ProfessorsController.getInstance().deleteProfessor(ProfessorsTable.getInstance().getSelectedRow());
				}
		}
	

}
