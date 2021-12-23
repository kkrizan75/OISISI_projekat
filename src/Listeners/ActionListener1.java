package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import GUI.Main_Frame;
import GUI.TabbedPane;
import dialogs.addStudentdialog;

public class ActionListener1 implements ActionListener {
	

	private static addStudentdialog aSd = null; 
	public void actionPerformed(ActionEvent arg0) { 
		
		if (TabbedPane.getInstance().getSelectedIndex() == 0) {
		aSd = new addStudentdialog(Main_Frame.getInstance(),"addStudent", true);
		aSd.setVisible(true);
		}
	}
	
	public static addStudentdialog getaSd() {
		return aSd;
	}

}
