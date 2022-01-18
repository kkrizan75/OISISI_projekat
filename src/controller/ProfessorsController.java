package controller;

import java.time.LocalDate;
import java.util.Vector;

import javax.swing.JOptionPane;

import view.Main_Frame;

import Model.Address;
import Model.Professor;
import Model.Subject;
import view.AddProfessorsDialog;

import view.AbstractTableProfessors;
import view.ProfessorsBase;
import view.ProfessorsTable;

public class ProfessorsController {

private static ProfessorsController instance = null;
	
	public static ProfessorsController getInstance() {
		if (instance == null) {
			instance = new ProfessorsController();
		}
		return instance;
	}
	
	public void addProfessor(String name, String surname, String title,String eMail ,
			String contactPhone,Address addressOfResidence , Address officeAddress, String idNumber, LocalDate birthDate,
			int yearsOfWorkingExp) {
		
		
		Professor prof = new Professor(name, surname, title, eMail ,
				 contactPhone, addressOfResidence ,  officeAddress,  idNumber,  birthDate,
				 yearsOfWorkingExp);
		
		ProfessorsBase.getInstance().addProfessor(prof);
		//ActionListener1.getaSd().setVisible(false);
		AbstractTableProfessors model = (AbstractTableProfessors) ProfessorsTable.getInstance().getModel();
		model.fireTableDataChanged();
		Main_Frame.getInstance().validate();
	}
	
	public void deleteProfessor(int rowSelectedIndex) {
		if (checkRow(rowSelectedIndex)) return;
		int result = JOptionPane.showConfirmDialog(Main_Frame.getInstance(),"Are you sure you want to delete this Professor?", "Sure?",
		               JOptionPane.YES_NO_OPTION,
		               JOptionPane.QUESTION_MESSAGE);
		if (result == JOptionPane.YES_OPTION) {

    	Professor prof = ProfessorsBase.getInstance().getRow(rowSelectedIndex);
    	ProfessorsBase.getInstance().deleteProfessor(prof.getID_number());

    	AbstractTableProfessors model = (AbstractTableProfessors) ProfessorsTable.getInstance().getModel();
    	model.fireTableDataChanged();
		Main_Frame.getInstance().validate();
			}
	}
	
	public Professor findSelectedProfessor(int rowSelectedIndex) {
		return ProfessorsBase.getInstance().getRow(rowSelectedIndex);
	}
	
	public Professor findProfessorByID(String id) {
		for (Professor prof : ProfessorsBase.getInstance().getProfessors()) {
			if(prof.getID_number().equals(id)) 
				return prof;
		}
		return null;
	}
	
	public boolean checkRow(int rowSelectedIndex) {
		if (rowSelectedIndex < 0 || rowSelectedIndex >= ProfessorsBase.getInstance().getProfessors().size()) {
			JOptionPane.showMessageDialog(AddProfessorsDialog.getInstance(), "No row selected!","Error",2);
			return true;
		}
		return false;
	}
	
	public void editProfessor(int rowSelectedIndex) {
		if (checkRow(rowSelectedIndex)) return;
		
		ProfessorsBase.getInstance().editProfessor();
		AbstractTableProfessors model = (AbstractTableProfessors) ProfessorsTable.getInstance().getModel();
    	model.fireTableDataChanged();
		Main_Frame.getInstance().validate();
	}
}
