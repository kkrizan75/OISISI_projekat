package view;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.SubjectsController;

public class addSubjFListener implements FocusListener{

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		JTextField txt = (JTextField) e.getComponent();
		txt.setBackground(Color.WHITE);
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		JTextField txt = (JTextField) e.getComponent();
		txt.setBackground(Color.LIGHT_GRAY);
	
	if (txt.getName().equals("txtName")) {
		

		if (txt.getText().trim().equals("") || txt.getText().trim().equals("Enter Name...")) {
			txt.setText("Enter Name...");
			txt.setForeground(Color.RED);
			addSubjectDialog.getInstance().setFalse(0);
		} else {
			txt.setForeground(Color.BLACK);
			addSubjectDialog.getInstance().setName(txt.getText().trim());
			addSubjectDialog.getInstance().setTrue(0);
			}
		
		}
	
	if (txt.getName().equals("txtId")) {
		

		if (txt.getText().trim().equals("") || txt.getText().trim().equals("Enter Id...")) {
			txt.setText("Enter Id...");
			txt.setForeground(Color.RED);
			addSubjectDialog.getInstance().setFalse(1);
		} else {
			if (SubjectsController.getInstance().contains(txt.getText().trim())) {
				addSubjectDialog.getInstance().setFalse(1);
				JOptionPane.showMessageDialog(addSubjectDialog.getInstance(), "Subject with that Id already exists!","Existing subject with that ID",1);
			}
			else {
			txt.setForeground(Color.BLACK);
			addSubjectDialog.getInstance().setId(txt.getText().trim());
			addSubjectDialog.getInstance().setTrue(1);
			}
		}
		
		}
	
	if (txt.getName().equals("txtyearOfStudy")) {
		

		if (txt.getText().trim().equals("") || txt.getText().trim().equals("Enter Year Of Study...")) {
			txt.setText("Enter Year Of Study...");
			txt.setForeground(Color.RED);
			addSubjectDialog.getInstance().setFalse(2);
		} else {
			txt.setForeground(Color.BLACK);
			addSubjectDialog.getInstance().setYearOfStudy(Integer.parseInt(txt.getText().trim()));
			addSubjectDialog.getInstance().setTrue(2);
			}
		
		}

	if (txt.getName().equals("txtECTS")) {
	

	if (txt.getText().trim().equals("") || txt.getText().trim().equals("Enter ECTS...")) {
		txt.setText("Enter ECTS...");
		txt.setForeground(Color.RED);
		addSubjectDialog.getInstance().setFalse(3);
	} else {
		txt.setForeground(Color.BLACK);
		addSubjectDialog.getInstance().setECTS(Integer.parseInt(txt.getText().trim()));
		addSubjectDialog.getInstance().setTrue(3);
		}
	
	}
	if(addSubjectDialog.getInstance().checkConfBTN()) addSubjectDialog.getInstance().setConfT(); 
	else addSubjectDialog.getInstance().setConfF();
	}

}
