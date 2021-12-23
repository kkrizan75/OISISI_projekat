package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GUI.TabbedPane;
import controller.StudentsController;
import tables.StudentTable;

public class DeleteActionListener implements ActionListener {
	

		@Override
		public void actionPerformed(ActionEvent e) {
			if (TabbedPane.getInstance().getSelectedIndex() == 0) {
			StudentsController.getInstance().deleteStudent(StudentTable.getInstance().getSelectedRow());
			}
		}
	

}
