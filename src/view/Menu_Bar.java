package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import controller.Write;

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
		miSave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Write.getInstance().Save();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
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
		JMenuItem miAbout = new JMenuItem("About");
		icon = new ImageIcon("images\\about.png");
		miAbout.setIcon(icon);
		miAbout.setMnemonic(KeyEvent.VK_A);
		miAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		help.add(miHelp);
		help.addSeparator();
		help.add(miAbout);
		add(file);
		add(edit);
		add(help);
	}

}
