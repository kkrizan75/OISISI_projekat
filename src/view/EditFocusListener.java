package view;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.LocalDate;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Model.Address;

public class EditFocusListener implements FocusListener {

	@Override
	public void focusGained(FocusEvent arg0) {

		JTextField txt = (JTextField) arg0.getComponent();
		txt.setBackground(Color.WHITE);

	}

	@Override
	public void focusLost(FocusEvent arg0) {
		JTextField txt = (JTextField) arg0.getComponent();
		txt.setBackground(Color.LIGHT_GRAY);

		if (txt.getName().equals("txtName")) {

			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Enter Name...")) {
				txt.setText("Enter Name...");
				txt.setForeground(Color.RED);
				editStudentdialog.getInstance().setFalse(0);
			} else {
				txt.setForeground(Color.BLACK);
				editStudentdialog.getInstance().setName(txt.getText().trim());
				editStudentdialog.getInstance().setTrue(0);
			}
			
		}
		if (txt.getName().equals("txtSurname")) {
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Enter Surname...")) {
				txt.setText("Enter Surname...");
				txt.setForeground(Color.RED);
				editStudentdialog.getInstance().setFalse(1);
			} else {
				txt.setForeground(Color.BLACK);
				editStudentdialog.getInstance().setSurname(txt.getText().trim());
				editStudentdialog.getInstance().setTrue(1);
			}
		}
		
		if (txt.getName().equals("txtbirthDate")) {
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Enter Birth Date...")) {
				txt.setText("Enter Birth Date...");
				txt.setForeground(Color.RED);
				editStudentdialog.getInstance().setFalse(2);
			} else {
				txt.setForeground(Color.BLACK);
				String[] txt1 = txt.getText().split("\\W+",3);
				if (txt1.length != 3) {
					editStudentdialog.getInstance().setFalse(2);
					JOptionPane.showMessageDialog(editStudentdialog.getInstance(), "Format of date: YYYY.MM.DD","Wrong Format of Birth Date",0);
					txt.setText("Enter Birth Date...");
					txt.setForeground(Color.RED);
					return;
				}
				editStudentdialog.getInstance().setBirthDate(LocalDate.of(Integer.parseInt(txt1[0]), Integer.parseInt(txt1[1]), Integer.parseInt(txt1[2])));
				editStudentdialog.getInstance().setTrue(2);
			}
		}
		
		if (txt.getName().equals("txtAddress")) {
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Enter Address...")) {
				txt.setText("Enter Address...");
				txt.setForeground(Color.RED);
				editStudentdialog.getInstance().setFalse(3);
			} else {
				txt.setForeground(Color.BLACK);
				String[] txt1 = txt.getText().split(",",4);
				if (txt1.length != 4) {
					editStudentdialog.getInstance().setFalse(3);
					JOptionPane.showMessageDialog(editStudentdialog.getInstance(), "Format of Address: Street, Number, City, Country","Wrong Format of Address",0);
					txt.setText("Enter Address...");
					txt.setForeground(Color.RED);
					return;
				}
				Address a = new Address(txt1[0],txt1[1],txt1[2],txt1[3]);
				editStudentdialog.getInstance().setAddress(a);
				editStudentdialog.getInstance().setTrue(3);
			}
		}
		
		if (txt.getName().equals("txtcontactPhone")) {
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Enter Contact Phone...")) {
				txt.setText("Enter Contact Phone...");
				txt.setForeground(Color.RED);
				editStudentdialog.getInstance().setFalse(4);
			} else {
				txt.setForeground(Color.BLACK);
				editStudentdialog.getInstance().setContactPhone(txt.getText().trim());
				editStudentdialog.getInstance().setTrue(4);
			}
		}
		
		if (txt.getName().equals("txteMail")) {
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Enter E-mail...")) {
				txt.setText("Enter E-mail...");
				txt.setForeground(Color.RED);
				editStudentdialog.getInstance().setFalse(5);
			} else {
				txt.setForeground(Color.BLACK);
				editStudentdialog.getInstance().seteMail(txt.getText().trim());
				editStudentdialog.getInstance().setTrue(5);
			}
		}
		
		if (txt.getName().equals("txtIndex")) {
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Enter Index...")) {
				txt.setText("Enter Index...");
				txt.setForeground(Color.RED);
				editStudentdialog.getInstance().setFalse(6);
			} else {
				txt.setForeground(Color.BLACK);
				editStudentdialog.getInstance().setIndex(txt.getText().trim());
				editStudentdialog.getInstance().setTrue(6);
			}
		}
		
		if (txt.getName().equals("txtyearOfEnrollment")) {
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Enter Year of enrollment...")) {
				txt.setText("Enter  Year of enrollment...");
				txt.setForeground(Color.RED);
				editStudentdialog.getInstance().setFalse(7);
			} else {
				txt.setForeground(Color.BLACK);
				editStudentdialog.getInstance().setYearOfEnrollment(Integer.parseInt(txt.getText().trim()));
				editStudentdialog.getInstance().setTrue(7);
			}
		}
		
		if(editStudentdialog.getInstance().checkB())  editStudentdialog.getInstance().setconfT();
		else editStudentdialog.getInstance().setconfF();
		
		

	}

}