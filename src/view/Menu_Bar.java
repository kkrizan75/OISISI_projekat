package view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;

public class Menu_Bar extends JMenuBar {
	
	private static final long serialVersionUID = -7863806568418316202L;

	public Menu_Bar() {
		

			JMenu file = new JMenu("File");
	
			file.setMnemonic(KeyEvent.VK_F);
		JMenuItem miStudents = new JMenuItem("Students");
		Icon icon = new ImageIcon("images\\student.png");
		miStudents.setIcon(icon);
		miStudents.setMnemonic(KeyEvent.VK_S);
		miStudents.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
		miStudents.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TabbedPane.getInstance().setSelectedIndex(0);
			}
			
		});
		JMenuItem miSubjects = new JMenuItem("Subjects");
		icon = new ImageIcon("images\\subject.png");
		miSubjects.setIcon(icon);
		miSubjects.setMnemonic(KeyEvent.VK_U);
		miSubjects.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, ActionEvent.CTRL_MASK));
		miSubjects.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TabbedPane.getInstance().setSelectedIndex(2);
			}
			
		});
		JMenuItem miProfessors = new JMenuItem("Professors");
		icon = new ImageIcon("images\\professor.png");
		miProfessors.setIcon(icon);
		miProfessors.setMnemonic(KeyEvent.VK_P);
		miProfessors.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
		miProfessors.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TabbedPane.getInstance().setSelectedIndex(1);
			}
			
		});
		JMenuItem miDepartments = new JMenuItem("Departments");
		icon = new ImageIcon("images\\department.png");
		miDepartments.setIcon(icon);
		miDepartments.setMnemonic(KeyEvent.VK_D);
		miDepartments.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		miDepartments.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new DepartmentDialog(Main_Frame.getInstance(),"Dpartments",true);
				
			}
			
		});
		
		JMenuItem miNew = new JMenuItem("New");
		icon = new ImageIcon("images\\plus2.png");
		miNew.setIcon(icon);
		miNew.setMnemonic(KeyEvent.VK_N);
		miNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		
		
		miNew.addActionListener(new ActionListener1());
		
		
		JMenuItem miOpen = new JMenu("Open");
		icon = new ImageIcon("images\\open.png");
		miOpen.setIcon(icon);
		miOpen.setMnemonic(KeyEvent.VK_O);
		miOpen.add(miStudents);
		miOpen.add(miSubjects);
		miOpen.add(miProfessors);
		miOpen.add(miDepartments);
		JMenuItem miSave = new JMenuItem("Save");
		icon = new ImageIcon("images\\save.png");
		miSave.setIcon(icon);
		miSave.setMnemonic(KeyEvent.VK_S);
		miSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
		JMenuItem miClose = new JMenuItem("Close");
		icon = new ImageIcon("images\\close.png");
		miClose.setIcon(icon);
		miClose.setMnemonic(KeyEvent.VK_C);
		miClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		miClose.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(Main_Frame.getInstance(),"Are you want to exit?", "Exit?",
			               JOptionPane.YES_NO_OPTION,
			               JOptionPane.QUESTION_MESSAGE);
				if (result == JOptionPane.YES_OPTION)
				System.exit(0);				
			}
			
		});

		file.add(miNew);
		file.addSeparator();
		file.add(miSave);
		file.addSeparator();
		file.add(miOpen);
		file.addSeparator();
		file.add(miClose);

			JMenu edit = new JMenu("Edit");
			icon = new ImageIcon("images\\edit.png");
			edit.setMnemonic(KeyEvent.VK_E);
		JMenuItem miEdit = new JMenuItem("Edit");
		miEdit.setIcon(icon);
		miEdit.setMnemonic(KeyEvent.VK_E);
		miEdit.addActionListener(new EditActionListener());
		miEdit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		JMenuItem miDelete = new JMenuItem("Delete");
		icon = new ImageIcon("images\\delete.png");
		miDelete.setIcon(icon);
		miDelete.setMnemonic(KeyEvent.VK_D);
		miDelete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		miDelete.addActionListener(new DeleteActionListener());
		edit.add(miEdit);
		edit.addSeparator();
		edit.add(miDelete);
			JMenu help = new JMenu("Help");
			help.setMnemonic(KeyEvent.VK_H);
		JMenuItem miHelp = new JMenuItem("Help");
		icon = new ImageIcon("images\\help.png");
		miHelp.setIcon(icon);
		miHelp.setMnemonic(KeyEvent.VK_H);
		miHelp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		JDialog Help = new JDialog();
		Help.setBounds(750, 180, 500, 600);
		JTextPane HelpKristian = new JTextPane();
		HelpKristian.setText("Menu Bar contains File, Edit, Help \n"
				+ "File: you can ADD(Ctrl + N) new Student, Professor or Subject according "
				+ "to current chosen tab, SAVE(Ctrl +S) changes, OPEN Students (Ctrl +T) ,"
				+ "Professors (Ctrl+P) or Subjects(Ctrl +U) desired tab or edit Departments"
				+ "(Ctrl+R) or Exit application (Ctrl + X) "
				+ "\n\nEdit: In current tab, you can EDIT(Ctrl+E) selected Student, Professor or Subject"
				+ "or DELETE(Ctrl +D) it"
				+ "\n\nHelp: you can get information ABOUT(Ctrl+A) application and its autors"
				+ "or get HELP(Ctrl+H) about using app"
				+ "\n\nStatus Bar: Name of Application, current open tab and current time"
				+ "\n\nTab Students: All added students in app"
				+ "\n\nAdd Student dialog: you have to input information in specific format in order"
				+ "to Add New Student,address format 'street,number,ciry,country',date format 'yyyy.mm.dd' "
				+ "\n\nEdit Student: you can only edit data with same format as add"
				+ "\n\nRemove Student: Remove selected student form base"
				+ "\n\nAdd Subject dialog: you have to input information in specific format in order"
				+ "to add new Subject"
				+ "\n\nEdit Student: you can only edit data with same format as add"
				+ "\n\nPassed Subjects: in edit student dialog it shows all subject that student "
				+ "has passed and its grade"
				+ "\n\nAdd Subject to Student: it allows Student to take an exam for specific Subject"
				+ "\n\nRemove Subject from Student: Student cannot take an exam for specific Subject"
				+ "\n\nSearch Student: at tab Student it allows to search specific Student"
				+ "\n\nSort Students: you can sort student in ascending or descending order by clicking"
				+ "on name of column of Student"
				+ "\n\nProfessors Subjects: it shows Subjects that Professor is on"
				+ "\n\nAdd Subject to Professor: adding Subjects that doesnt have Professor to "
				+ "chosen Professor \n\nRemove Subject from Professor: Professor is not longer"
				+ "Professor on chosen Subject"
				+ "\n\nDepartments: you can add or change Boss Professor to specific department"
				+ "you can only add it if professor is working on that department, have more than 5"
				+ "years of experience and have title of professor or associate professor");
		JScrollPane jsp = new JScrollPane(HelpKristian);
		Help.add(jsp);
		Help.setTitle("Help");
		miHelp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Help.setVisible(true);
			}
			
		});
		
		JMenuItem miAbout = new JMenuItem("About");
		icon = new ImageIcon("images\\about.png");
		miAbout.setIcon(icon);
		miAbout.setMnemonic(KeyEvent.VK_A);
		miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		JDialog About = new JDialog();
		JTextPane LVersion = new JTextPane();
		LVersion.setText("Version: Alfa");
		JTextPane LKristian = new JTextPane();
		LKristian.setText("About Kristian: \n Kristian is student, third year of FTS in Novi Sad and this is his first bigger project "
				+ " it took few days of work to get this app to this current state he hopes he would gat a good grade"
				+ " for this. ");
		About.setTitle("About");
		LVersion.add(LKristian);
		About.add(LVersion,BorderLayout.NORTH);
		About.add(Box.createVerticalStrut(20));
		About.add(LKristian,BorderLayout.CENTER);
		About.setBounds(750, 180, 500, 600);
		miAbout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				About.setVisible(true);
			}
			
		});
		
		help.add(miHelp);
		help.addSeparator();
		help.add(miAbout);
		add(file);
		add(edit);
		add(help);
	}

}
