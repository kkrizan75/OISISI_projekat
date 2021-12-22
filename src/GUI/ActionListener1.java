package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import dialogs.addStudentdialog;

public class ActionListener1 implements ActionListener {
	
	@Override
	public void actionPerformed(ActionEvent arg0) { 
		JFrame x = new JFrame();
		addStudentdialog aSd = new addStudentdialog(x,"add Student", true);
		
		aSd.setVisible(true);
	}

}
