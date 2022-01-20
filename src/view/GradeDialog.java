package view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.time.LocalDate;
import java.awt.Toolkit;

import Model.Grade;
import Model.Student;
import Model.Subject;
import controller.StudentsController;
import controller.SubjectsController;

public class GradeDialog extends JDialog {
	
	private LocalDate date;
	private int grade;	
	private JButton Confirm;
	private CheckData checkData = new CheckData();
	
	
	public GradeDialog() {
		
		super(Main_Frame.getInstance(), true);
		Subject su = SubjectsController.getInstance().findSelectedUnpassedSubject(FailedSubjectsTable.getInstance().getSelectedRow());
		Dimension dim = new Dimension(200, 25);

		Toolkit kit = Toolkit.getDefaultToolkit();
		setTitle("Pass a Subject");
		
		JPanel pID = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblID = new JLabel("Subject ID*:");
		lblID.setPreferredSize(dim);
		JTextField txtID = new JTextField();
		txtID.setText(su.getId());
		txtID.setPreferredSize(dim);
		txtID.setBackground(Color.LIGHT_GRAY);
		txtID.setEditable(false);
		pID.add(lblID);
		pID.add(txtID);
		
		
		JPanel pName = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblName = new JLabel("Name*:");
		lblName.setPreferredSize(dim);
		JTextField txtName = new JTextField();
		txtName.setText(su.getName());
		txtName.setPreferredSize(dim);
		txtName.setName("txtName");
		txtName.setBackground(Color.LIGHT_GRAY);
		txtName.setEditable(false);
		pName.add(lblName);
		pName.add(txtName);
		
		
		JPanel panGrade = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblGrade = new JLabel("Grade*:");
		lblGrade.setPreferredSize(dim);
		JComboBox comboGrade = new JComboBox();
		comboGrade.setPreferredSize(dim);
		comboGrade.setName("Grade");
		comboGrade.addItem("6");
		comboGrade.addItem("7");
		comboGrade.addItem("8");
		comboGrade.addItem("9");
		comboGrade.addItem("10");
		comboGrade.setSelectedIndex(0);
		setGrade(6);
		comboGrade.addFocusListener(new  FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				JComboBox cB = (JComboBox) arg0.getComponent();
				if(cB.getSelectedItem().equals("6")) {
					setGrade(6);
				}
				else if (cB.getSelectedItem().equals("7")) {
					setGrade(7);
				} 
				else if (cB.getSelectedItem().equals("8")) {
					setGrade(8);
				}
				else if (cB.getSelectedItem().equals("9")) {
					setGrade(9);
				}
				else if (cB.getSelectedItem().equals("10")) {
					setGrade(10);
				}
				
			}
			
		});
		panGrade.add(lblGrade);
		panGrade.add(comboGrade);
		
		JPanel pDate = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblDate = new JLabel("Date*:");
		lblDate.setPreferredSize(dim);
		JTextField txtDate = new JTextField();
		txtDate.setPreferredSize(dim);
		txtDate.addFocusListener(new FocusListener() {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (!checkData.checkDate(txtDate.getText())) {
					txtDate.setBorder(new LineBorder(Color.red,1));
				}else {
					
					txtDate.setBorder(new LineBorder(Color.green,1));
					String[] dateNums = txtDate.getText().split("-", 3);
					setDate(LocalDate.of(Integer.parseInt(dateNums[0]),Integer.parseInt(dateNums[1]) , Integer.parseInt(dateNums[2])));

				}	
				
			}
			
		});
		txtDate.setBackground(Color.LIGHT_GRAY);
		pDate.add(lblDate);
		pDate.add(txtDate);
		
		JButton cancel = new JButton();
		cancel.setBackground(Color.GRAY);
		cancel.setPreferredSize(new Dimension(150,40));
		cancel.setText("Cancel");
		
		JButton confirm = new JButton();
		confirm.setBackground(Color.GRAY);
		confirm.setPreferredSize(new Dimension(150,40));
		confirm.setText("Confirm");
		confirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Student st = StudentsController.getInstance().findSelcetedStudent(StudentTable.getInstance().getSelectedIndex());
				StudentsController.getInstance().addPassedSubjectToStudent(st, su, grade, date);
				setVisible(false);
			}
			
		});
		
		JPanel buttons = new JPanel();
		buttons.add(cancel);
		buttons.add(confirm);
		
		Box boxC = Box.createVerticalBox();
		boxC.add(Box.createVerticalStrut(20));
		boxC.add(pID);
		boxC.add(pName);
		boxC.add(panGrade);
		boxC.add(pDate);
		boxC.add(buttons);
		
		add(boxC, BorderLayout.NORTH);
		
		Dimension d = kit.getScreenSize();
		setSize(3*d.width/12, 16* d.height/48);
		setLocationRelativeTo(null);

		
		
	}



	public LocalDate getDate() {
		return date;
	}



	public void setDate(LocalDate date) {
		this.date = date;
	}



	public int getGrade() {
		return grade;
	}



	public void setGrade(int grade) {
		this.grade = grade;
	}



	public JButton getConfirm() {
		return Confirm;
	}



	public void setConfirm(JButton confirm) {
		Confirm = confirm;
	}
	
	
	
	
}
