package Listeners;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JComboBox;
import dialogs.addStudentdialog;

public class FocusListener2 implements FocusListener{
	
	 @Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
		JComboBox cB = (JComboBox) arg0.getComponent();
		if (cB.getName().equals("currentYear")) {
		if(cB.getSelectedItem().equals("2.(second)")) {
			addStudentdialog.getInstance().setCurrentYear(2);
		}
		else if (cB.getSelectedItem().equals("3.(third)")) {
			addStudentdialog.getInstance().setCurrentYear(3);
		} 
		else if (cB.getSelectedItem().equals("4.(fourth)")) {
			addStudentdialog.getInstance().setCurrentYear(4);
		}
		else if (cB.getSelectedItem().equals("1.(first)")) {
			addStudentdialog.getInstance().setCurrentYear(1);
		}
		
		}
		
		if(cB.getName().equals("Status")) {
			if(cB.getSelectedItem().equals("S")) {
				addStudentdialog.getInstance().setStatus("S");
			}
			else addStudentdialog.getInstance().setStatus("B");
			}
		}
}
