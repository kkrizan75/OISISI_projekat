package controller;

import javax.swing.JOptionPane;

import Model.Subject;
import view.AbstractTableSubjects;
import view.ActionListener1;
import view.EditActionListener;
import view.Main_Frame;
import view.SubjectsBase;
import view.SubjectsTable;
import view.addSubjectDialog;
import view.editSubjectDialog;

public class SubjectsController {
	
private static SubjectsController instance = null;
	
	public static SubjectsController getInstance() {
		if (instance == null) {
			instance = new SubjectsController();
		}
		return instance;
	}
	
	public boolean contains(String s) {
		return SubjectsBase.getInstance().contains(s);
	}
	
	
	public void addSubject() {
		Subject subject = new Subject(addSubjectDialog.getInstance().getId(),addSubjectDialog.getInstance().getName(),
				addSubjectDialog.getInstance().getSemester(),addSubjectDialog.getInstance().getYearOfStudy(),null,addSubjectDialog.getInstance().getECTS());
		
		SubjectsBase.getInstance().addSubject(subject);
		ActionListener1.getaSud().setVisible(false);
		AbstractTableSubjects model = (AbstractTableSubjects) SubjectsTable.getInstance().getModel();
		model.fireTableDataChanged();
		Main_Frame.getInstance().validate();
	}
	
	public Subject findSelcetedSubject(int rowSelectedIndex){
		return SubjectsBase.getInstance().getRow(rowSelectedIndex);
	
	}
	
	public Subject findSubjectByID(String id) {
		for(Subject s : SubjectsBase.getInstance().getSubjects()) {
			if(s.getId().equals(id))
				return s;
		}
		return null;
	}
	
	
	public void deleteSubject(int rowSelectedIndex) {
		if (checkRow(rowSelectedIndex)) return;
		int result = JOptionPane.showConfirmDialog(Main_Frame.getInstance(),"Are you sure you want to delete this Subject?", "Sure?",
		               JOptionPane.YES_NO_OPTION,
		               JOptionPane.QUESTION_MESSAGE);
		if (result == JOptionPane.YES_OPTION) {

    	Subject sub = SubjectsBase.getInstance().getRow(rowSelectedIndex);
    	SubjectsBase.getInstance().deleteSubject(sub.getId());

    	AbstractTableSubjects model = (AbstractTableSubjects) SubjectsTable.getInstance().getModel();
    	model.fireTableDataChanged();
		Main_Frame.getInstance().validate();
			}
	}
	
	public Subject findSelectedUnpassedSubject(int rowSelectedIndex) {
		return SubjectsBase.getInstance().getFrow(rowSelectedIndex);
	}
	
	public boolean checkRow(int rowSelectedIndex) {
		if (rowSelectedIndex < 0 || rowSelectedIndex >= SubjectsBase.getInstance().getSubjects().size()) {
			JOptionPane.showMessageDialog(editSubjectDialog.getInstance(), "No row selected!","Error!",2);
			return true;
		}
		return false;
	}
	
	public void editSubject() {
		SubjectsBase.getInstance().editSubject();
		EditActionListener.gateSud().setVisible(false);
		AbstractTableSubjects model = (AbstractTableSubjects) SubjectsTable.getInstance().getModel();
    	model.fireTableDataChanged();
		Main_Frame.getInstance().validate();
	}
}
