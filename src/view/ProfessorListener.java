package view;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.LocalDate;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import Model.Address;
import controller.ProfessorsController;



public class ProfessorListener implements FocusListener {
	
	
	private CheckData checkData = new CheckData();
	
	private String[] errorMessages = new String [] {
			
			"INVALID NAME!",
			"INVALID SURNAME!",
			"INVALID BIRTH DATE! - DATE SHOULD BE IN YYYY-MM-DD FORMAT",
			"INVALID EMAIL!",
			"INVALID ADDRESS! FORMAT OF ADDRESS: STREET, NUMBER, CITY, COUNTRY",
			"INVALID PHONE NUMBER!",
			"INVALID OFFICE ADDRESS!", 
			"INVALID TITLE!",
			"INVALID ID! - MUST HAVE 9 NUMBERS",
			"INVALID YEARS OF EXPERIENCE"
			
	};
	

	
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

			if (!checkData.checkName(txt.getText())) {
				txt.setBorder(new LineBorder(Color.red,1));
				AddProfessorsDialog.getInstance().setCheck(0, false);
				AddProfessorsDialog.getInstance().errorMsgLbl.get(0).setText(errorMessages[0]);
				AddProfessorsDialog.getInstance().setDisabled();
			}else {
				txt.setBorder(new LineBorder(Color.green,1));
				AddProfessorsDialog.getInstance().setCheck(0, true);
				AddProfessorsDialog.getInstance().setName(txt.getText());
				AddProfessorsDialog.getInstance().errorMsgLbl.get(0).setText("");
				if(AddProfessorsDialog.getInstance().getCheck()) 
					AddProfessorsDialog.getInstance().setEnabled();
			}	
		}
		if (txt.getName().equals("txtSurname")) {
			if (!checkData.checkSurname(txt.getText())) {
				txt.setBorder(new LineBorder(Color.red,1));
				AddProfessorsDialog.getInstance().setCheck(1, false);
				AddProfessorsDialog.getInstance().errorMsgLbl.get(1).setText(errorMessages[1]);
				AddProfessorsDialog.getInstance().setDisabled();
			}else {
				txt.setBorder(new LineBorder(Color.green,1));
				AddProfessorsDialog.getInstance().setCheck(1, true);
				AddProfessorsDialog.getInstance().setSurname(txt.getText());
				AddProfessorsDialog.getInstance().errorMsgLbl.get(1).setText("");
				if(AddProfessorsDialog.getInstance().getCheck()) 
					AddProfessorsDialog.getInstance().setEnabled();
			}	
		}
		
		if (txt.getName().equals("txtDate")) {
			
			if (!checkData.checkDate(txt.getText())) {
				txt.setBorder(new LineBorder(Color.red,1));
				AddProfessorsDialog.getInstance().setCheck(2, false);
				AddProfessorsDialog.getInstance().errorMsgLbl.get(2).setText(errorMessages[2]);
				AddProfessorsDialog.getInstance().setDisabled();
			}else {
				
				txt.setBorder(new LineBorder(Color.green,1));
				String[] dateNums = txt.getText().split("-", 3);
				AddProfessorsDialog.getInstance().setBirthDate(LocalDate.of(Integer.parseInt(dateNums[0]),Integer.parseInt(dateNums[1]) , Integer.parseInt(dateNums[2])));
				AddProfessorsDialog.getInstance().setCheck(2, true);
				AddProfessorsDialog.getInstance().errorMsgLbl.get(2).setText("");
				if(AddProfessorsDialog.getInstance().getCheck()) 
					AddProfessorsDialog.getInstance().setEnabled();
			}	
	
		}
		
		if (txt.getName().equals("txtEmail")) {
			if (!checkData.checkeMail(txt.getText())) {
				txt.setBorder(new LineBorder(Color.red,1));
				AddProfessorsDialog.getInstance().setCheck(3, false);
				AddProfessorsDialog.getInstance().errorMsgLbl.get(3).setText(errorMessages[3]);
				AddProfessorsDialog.getInstance().setDisabled();
			} else {
				txt.setBorder(new LineBorder(Color.green,1));
				AddProfessorsDialog.getInstance().seteMail(txt.getText().trim());
				AddProfessorsDialog.getInstance().setCheck(3, true);
				AddProfessorsDialog.getInstance().errorMsgLbl.get(3).setText("");
				if(AddProfessorsDialog.getInstance().getCheck()) 
					AddProfessorsDialog.getInstance().setEnabled();
			}
		}
		
		if (txt.getName().equals("txtAddress")) {
			if (!checkData.checkAddress(txt.getText())) {
				txt.setBorder(new LineBorder(Color.red,1));
				AddProfessorsDialog.getInstance().setCheck(4, false);
				AddProfessorsDialog.getInstance().errorMsgLbl.get(4).setText(errorMessages[4]);
				AddProfessorsDialog.getInstance().setDisabled();
			} else {
				String[] addrs = txt.getText().split(" ",4);
				Address address = new Address(addrs[0],addrs[1],addrs[2],addrs[3]);
				AddProfessorsDialog.getInstance().setHomeAddress(address);
				txt.setBorder(new LineBorder(Color.green,1));
				AddProfessorsDialog.getInstance().setCheck(4, true);
				AddProfessorsDialog.getInstance().errorMsgLbl.get(4).setText("");
				if(AddProfessorsDialog.getInstance().getCheck()) 
					AddProfessorsDialog.getInstance().setEnabled();
				}
			}
		
		
		if (txt.getName().equals("txtPhone")) {
			if (!checkData.checkPhone(txt.getText())) {
				txt.setBorder(new LineBorder(Color.red,1));
				AddProfessorsDialog.getInstance().setCheck(5, false);
				AddProfessorsDialog.getInstance().errorMsgLbl.get(5).setText(errorMessages[5]);
				AddProfessorsDialog.getInstance().setDisabled();
			} else {
				txt.setBorder(new LineBorder(Color.green,1));
				AddProfessorsDialog.getInstance().setPhoneNum(txt.getText().trim());
				AddProfessorsDialog.getInstance().setCheck(5, true);
				AddProfessorsDialog.getInstance().errorMsgLbl.get(5).setText("");
				if(AddProfessorsDialog.getInstance().getCheck()) 
					AddProfessorsDialog.getInstance().setEnabled();
			}
		}
		
		if (txt.getName().equals("txtOffice")) {
			if (!checkData.checkAddress(txt.getText())) {
				txt.setBorder(new LineBorder(Color.red,1));
				AddProfessorsDialog.getInstance().setCheck(6, false);
				AddProfessorsDialog.getInstance().errorMsgLbl.get(6).setText(errorMessages[6]);
				AddProfessorsDialog.getInstance().setDisabled();
			} else {
				String[] addrs = txt.getText().split(" ",6);
				Address address = new Address(addrs[0],addrs[1],addrs[2],addrs[3]);
				AddProfessorsDialog.getInstance().setOffAddress(address);
				txt.setBorder(new LineBorder(Color.green,1));
				AddProfessorsDialog.getInstance().setCheck(6, true);
				AddProfessorsDialog.getInstance().errorMsgLbl.get(6).setText("");
				if(AddProfessorsDialog.getInstance().getCheck()) 
					AddProfessorsDialog.getInstance().setEnabled();
				}
			}
		
		if (txt.getName().equals("txtTitle")) {
			if (!checkData.checkTitle(txt.getText())) {
				txt.setBorder(new LineBorder(Color.red,1));
				AddProfessorsDialog.getInstance().setCheck(7, false);
				AddProfessorsDialog.getInstance().errorMsgLbl.get(7).setText(errorMessages[7]);
				AddProfessorsDialog.getInstance().setDisabled();
			} else {
				txt.setBorder(new LineBorder(Color.green,1));
				AddProfessorsDialog.getInstance().setTitleProf(txt.getText().trim());
				AddProfessorsDialog.getInstance().setCheck(7, true);
				AddProfessorsDialog.getInstance().errorMsgLbl.get(7).setText("");
				if(AddProfessorsDialog.getInstance().getCheck()) 
					AddProfessorsDialog.getInstance().setEnabled();
				}
			}
		
		if (txt.getName().equals("txtID")) {
			if (!checkData.checkID(txt.getText())) {
				txt.setBorder(new LineBorder(Color.red,1));
				AddProfessorsDialog.getInstance().setCheck(8, false);
				AddProfessorsDialog.getInstance().errorMsgLbl.get(8).setText(errorMessages[8]);
				AddProfessorsDialog.getInstance().setDisabled();
			} else {
				txt.setBorder(new LineBorder(Color.green,1));
				if(ProfessorsController.getInstance().findProfessorByID(txt.getText()) != null) {
					JOptionPane.showMessageDialog(AddProfessorsDialog.getInstance(), "Professor with this ID already exists!", "",0);;
				}
				AddProfessorsDialog.getInstance().setId(txt.getText().trim());
				AddProfessorsDialog.getInstance().setCheck(8, true);
				AddProfessorsDialog.getInstance().errorMsgLbl.get(8).setText("");
				if(AddProfessorsDialog.getInstance().getCheck()) 
					AddProfessorsDialog.getInstance().setEnabled();
				}
			}
		
		if (txt.getName().equals("txtYexp")) {
			if (txt.getText().equals("") || !checkData.checkYExp(txt.getText())) {
				txt.setBorder(new LineBorder(Color.red,1));
				AddProfessorsDialog.getInstance().setCheck(9, false);
				AddProfessorsDialog.getInstance().errorMsgLbl.get(9).setText(errorMessages[9]);
				AddProfessorsDialog.getInstance().setDisabled();
			} else {
				txt.setBorder(new LineBorder(Color.green,1));
				AddProfessorsDialog.getInstance().setyExp(Integer.parseInt(txt.getText().trim()));
				AddProfessorsDialog.getInstance().setCheck(9, true);
				AddProfessorsDialog.getInstance().errorMsgLbl.get(9).setText("");
				if(AddProfessorsDialog.getInstance().getCheck()) 
					AddProfessorsDialog.getInstance().setEnabled();
				}
			}
		

		
		

	}
}
