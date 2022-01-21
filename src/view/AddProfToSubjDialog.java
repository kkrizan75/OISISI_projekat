package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Model.Professor;
import Model.Subject;
import controller.ProfessorsController;
import controller.SubjectsController;

import javax.swing.JList;


public class AddProfToSubjDialog extends JDialog {
	
	JList<Professor> list = new JList<>();
	DefaultListModel<Professor> model = new DefaultListModel<>();
	JButton conf;
	
	public AddProfToSubjDialog() {
		super(Main_Frame.getInstance(), true);
		Toolkit kit = Toolkit.getDefaultToolkit();
		setTitle("Choose Professor");
		list.setModel(model);
		list.setPreferredSize(new Dimension(400,400));
		List<Professor> profs = ProfessorsController.getInstance().getProfessors();
		model.addAll(profs);
		JPanel panList = new JPanel();
		
		list.getSelectionModel().addListSelectionListener(e -> {
			if(list.getSelectedIndex() != -1)
				conf.setEnabled(true);
		});
		
		conf = new JButton();
		conf.setBackground(Color.CYAN);
		conf.setPreferredSize(new Dimension(150,40));
		conf.setText("Confirm");
		conf.setEnabled(false);
		conf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				editSubjectDialog.getInstance().setProfessor(list.getSelectedValue());
				editSubjectDialog.getInstance().setProfTxt();
				Subject s = editSubjectDialog.getInstance().getCurrSubject();
				ProfessorsController.getInstance().findProfessorByID(list.getSelectedValue().getID_number()).addSubj(editSubjectDialog.getInstance().getCurrSubject());
				SubjectsController.getInstance().findSubjectByID(s.getId()).setProfessor(list.getSelectedValue());
				setVisible(false);
				editSubjectDialog.getInstance().setRem(true);
				editSubjectDialog.getInstance().setAdd(false);
				
			}
			
		});
		JButton canc = new JButton();
		canc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				editSubjectDialog.getInstance().setAdd(true);
				
			}
			
		});
		canc.setPreferredSize(new Dimension(150,40));
		canc.setText("Cancel");
		JPanel panbuttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panbuttons.add(conf);
		panbuttons.add(canc);
		
		Box box = Box.createVerticalBox();
		box.add(panList);
		box.add(panbuttons);
		
		
		panList.add(new JScrollPane(list), BorderLayout.NORTH);
		add(box);
		
		Dimension d = kit.getScreenSize();
		setSize(3*d.width/12, 16* d.height/48);
		setLocationRelativeTo(null);
		
		
	}
	
}
