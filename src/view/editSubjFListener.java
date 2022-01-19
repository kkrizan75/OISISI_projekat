package view;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.SubjectsController;

public class editSubjFListener implements FocusListener{

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		JTextField txt = (JTextField) e.getComponent();
		txt.setBackground(Color.WHITE);
	}

	@Override
	public void focusLost(FocusEvent e) {
		JTextField txt = (JTextField) e.getComponent();
		txt.setBackground(Color.LIGHT_GRAY);
	
	if (txt.getName().equals("txtName")) {
		

		if (txt.getText().trim().equals("") || txt.getText().trim().equals("Enter Name...")) {
			txt.setText("Enter Name...");
			txt.setForeground(Color.RED);
			editSubjectDialog.getInstance().setFalse(0);
		} else {
			txt.setForeground(Color.BLACK);
			editSubjectDialog.getInstance().setName(txt.getText().trim());
			editSubjectDialog.getInstance().setTrue(0);
			}
		
		}
	
	if (txt.getName().equals("txtId")) {
		

		if (txt.getText().trim().equals("") || txt.getText().trim().equals("Enter Id...")) {
			txt.setText("Enter Id...");
			txt.setForeground(Color.RED);
			editSubjectDialog.getInstance().setFalse(1);
		} else {
			if (SubjectsController.getInstance().contains(txt.getText().trim())) {
				editSubjectDialog.getInstance().setFalse(1);
				JOptionPane.showMessageDialog(editSubjectDialog.getInstance(), "Subject with that Id already exists!","Existing subject with that ID",1);
			}
			else {
			txt.setForeground(Color.BLACK);
			editSubjectDialog.getInstance().setId(txt.getText().trim());
			editSubjectDialog.getInstance().setTrue(1);
				}
			}
		}
	
	if (txt.getName().equals("txtyearOfStudy")) {
		

		if (txt.getText().trim().equals("") || txt.getText().trim().equals("Enter Year Of Study...")) {
			txt.setText("Enter Year Of Study...");
			txt.setForeground(Color.RED);
			editSubjectDialog.getInstance().setFalse(2);
		} else {
			txt.setForeground(Color.BLACK);
			editSubjectDialog.getInstance().setYearOfStudy(Integer.parseInt(txt.getText().trim()));
			editSubjectDialog.getInstance().setTrue(2);
			}
		
		}

	if (txt.getName().equals("txtECTS")) {
	

	if (txt.getText().trim().equals("") || txt.getText().trim().equals("Enter ECTS...")) {
		txt.setText("Enter ECTS...");
		txt.setForeground(Color.RED);
		editSubjectDialog.getInstance().setFalse(3);
	} else {
		txt.setForeground(Color.BLACK);
		editSubjectDialog.getInstance().setECTS(Integer.parseInt(txt.getText().trim()));
		editSubjectDialog.getInstance().setTrue(3);
		}
	
	}
	if(editSubjectDialog.getInstance().checkB()) editSubjectDialog.getInstance().setconfT(); 
	else editSubjectDialog.getInstance().setconfF();
	}
}
