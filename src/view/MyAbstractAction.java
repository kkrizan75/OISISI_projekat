package view;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import controller.ProfessorsController;



import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;

public class MyAbstractAction extends AbstractAction {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private static addStudentdialog aSd = null;
	//private static editStudentdialog eSd = null;
	private String name;
	
	
	@SuppressWarnings("deprecation")
	public MyAbstractAction(String s) {
		String rez = s.trim();
		rez = s.toLowerCase();
		name = rez;
		switch(rez){
			case "new":
				putValue(MNEMONIC_KEY, KeyEvent.VK_N);
				putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
				break;
			case "edit":
				putValue(MNEMONIC_KEY, KeyEvent.VK_E);
				putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
				break;
			case "delete":
				putValue(MNEMONIC_KEY, KeyEvent.VK_D);
				putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
				break;
		}
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/*// TODO Auto-generated method stub
		if(name.equals("close"))
			Main_Frame.exit();
		else if(name.equals("new"))
			switch(TabbedPane.getInstance().getSelectedIndex()) {
				case 0:
					/*if (TabbedPane.getInstance().getSelectedIndex() == 0) {
						aSd = new addStudentdialog(Main_Frame.getInstance(),"Add Student", true);
						aSd.setVisible(true); }
						break; 
				case 1:
						AddProfessorsDialog.getInstance().setVisible(true);;
						break;
				case 2:
						break;
			}
		else if(name.equals("edit"))
			switch(TabbedPane.getInstance().getSelectedIndex()) {
				case 0:
					if (StudentsController.getInstance().checkRow(StudentTable.getInstance().getSelectedRow())) return;
					eSd = new editStudentdialog(Main_Frame.getInstance(),"Edit Student",true);
					eSd.setVisible(true);
					break;
				case 1:
						if (!ProfessorsController.getInstance().checkRow(ProfessorsTable.getInstance().getSelectedRow()))
							EditProfessorsDialog.getInstance().setVisible(true);;
						break;
				case 2:
					break;
				}
		else if(name.equals("delete"))
			switch(TabbedPane.getInstance().getSelectedIndex()) {
				case 0:
					//StudentsController.getInstance().deleteStudent(StudentTable.getInstance().getSelectedRow());
					break;
				case 1:
					ProfessorsController.getInstance().deleteProfessor(ProfessorsTable.getInstance().getSelectedRow());
		
					break;
				case 2:
					break;
				}
					
			*/}
	}

	
	
	
