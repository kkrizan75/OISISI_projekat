package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.Address;
import Model.Student.Status_enum;
import controller.StudentsController;

public class addStudentdialog extends JDialog{

		private static final long serialVersionUID = 3591599721565020284L;
		
		private boolean[] conf = new boolean[8];
		
		private JButton ConfirmB = new JButton();
		
		private String Name;
		private String Surname;
		private LocalDate birthDate;
		private Address address ;
		private String contactPhone;
		private String eMail;
		private String Index;
		private int yearOfEnrollment;
		private int currentYear = 1;
		private Status_enum Status = Status_enum.S;
		
		private static addStudentdialog instance = null;
		
		private void restart() {
			for (boolean c : conf) {
				c = false;
			}
			this.setName("");
			this.setSurname("");
			this.setContactPhone("");
			this.seteMail("");
			this.setIndex("");
			this.setAddress(null);
			this.setBirthDate(null);
			this.setYearOfEnrollment(-1);
			ConfirmB.setEnabled(false);
		}
		
		private void setconfF() {
			for (boolean c : conf) {
				c = false;
			}
			this.setName("");
			this.setSurname("");
			this.setContactPhone("");
			this.seteMail("");
			this.setIndex("");
			this.setAddress(null);
			this.setBirthDate(null);
			this.setYearOfEnrollment(-1);
			ConfirmB.setBackground(Color.GRAY);
			ConfirmB.setPreferredSize(new Dimension(150,40));
			ConfirmB.setText("Confirm");
			ConfirmB.addActionListener(new ActionListener3());
			ConfirmB.setEnabled(false);
		}
		
		public void setConfF() {
			ConfirmB.setEnabled(false);
		}
		public void setConfT() {
			ConfirmB.setEnabled(true);
		}
		
		public void setTrue(int i) {
			conf[i] = true;
		}
		
		public void setFalse(int i) {
			conf[i] = false;
		}
		
		public static addStudentdialog getInstance() {
			if(instance == null) {
				instance = new addStudentdialog();
				instance.setconfF();
				}
			return instance;
		}
		
		private addStudentdialog() {
			
		}
		
		private boolean cmpEmp(String s) {
			return !s.equals("");
		}
		
		private boolean checkB() {
			for (boolean b : conf) {
				if (!b) {
					return b;
				}
			}
			return true;
		}

		public class ActionListener2 implements ActionListener {
			
			@Override
			public void actionPerformed(ActionEvent arg0) { 				
				ActionListener1.getaSd().setVisible(false);
			}

		}
		
		public boolean checkConfBTN() {
			return cmpEmp(getInstance().getName()) && cmpEmp(getInstance().getSurname()) && cmpEmp(getInstance().getContactPhone()) && 
					cmpEmp(getInstance().geteMail()) && cmpEmp(getInstance().getIndex()) && 
					!(getInstance().getAddress() == null) && !(getInstance().getBirthDate()==null) 
					&& !(getInstance().getYearOfEnrollment() == -1) && getInstance().checkB();
		}
		
		
		public class ActionListener3 implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkConfBTN()) {
							StudentsController.getInstance().addStudent();
							getInstance().restart();
						}
				else {
					JOptionPane.showMessageDialog(addStudentdialog.getInstance(), "Error!");
				}
			}
		}
		
		public addStudentdialog(Frame parent, String s, boolean modal) {
			super(parent,s,modal);
			Dimension dim = new Dimension(200, 25);

			JPanel panName = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JLabel lblName = new JLabel("Name*:");
			lblName.setPreferredSize(dim);
			JTextField txtName = new JTextField();
			txtName.setPreferredSize(dim);
			txtName.setName("txtName");
			txtName.setBackground(Color.LIGHT_GRAY);
			txtName.addFocusListener(new FocusListener1());
			panName.add(lblName);
			panName.add(txtName);
			
			JPanel panSurname = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JLabel lblSurname = new JLabel("Surname*:");
			lblSurname.setPreferredSize(dim);
			JTextField txtSurname = new JTextField();
			txtSurname.setPreferredSize(dim);
			txtSurname.setName("txtSurname");
			txtSurname.setBackground(Color.LIGHT_GRAY);
			txtSurname.addFocusListener(new FocusListener1());
			panSurname.add(lblSurname);
			panSurname.add(txtSurname);
			
			JPanel panbirthDate = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JLabel lblbirthDate = new JLabel("Birth date*:");
			lblbirthDate.setPreferredSize(dim);
			JTextField txtbirthDate = new JTextField();
			txtbirthDate.setPreferredSize(dim);
			txtbirthDate.setName("txtbirthDate");
			txtbirthDate.setBackground(Color.LIGHT_GRAY);
			txtbirthDate.addFocusListener(new FocusListener1());
			panbirthDate.add(lblbirthDate);
			panbirthDate.add(txtbirthDate);
			
			JPanel panAddress = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JLabel lblAddress = new JLabel("Address*:");
			lblAddress.setPreferredSize(dim);
			JTextField txtAddress = new JTextField();
			txtAddress.setPreferredSize(dim);
			txtAddress.setName("txtAddress");
			txtAddress.setBackground(Color.LIGHT_GRAY);
			txtAddress.addFocusListener(new FocusListener1());
			panAddress.add(lblAddress);
			panAddress.add(txtAddress);
			
			JPanel pancontactPhone = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JLabel lblcontactPhone = new JLabel("Contact Phone*:");
			lblcontactPhone.setPreferredSize(dim);
			JTextField txtcontactPhone = new JTextField();
			txtcontactPhone.setPreferredSize(dim);
			txtcontactPhone.setName("txtcontactPhone");
			txtcontactPhone.setBackground(Color.LIGHT_GRAY);
			txtcontactPhone.addFocusListener(new FocusListener1());
			pancontactPhone.add(lblcontactPhone);
			pancontactPhone.add(txtcontactPhone);
			
			JPanel paneMail = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JLabel lbleMail = new JLabel("E-mail*:");
			lbleMail.setPreferredSize(dim);
			JTextField txteMail = new JTextField();
			txteMail.setPreferredSize(dim);
			txteMail.setName("txteMail");
			txteMail.setBackground(Color.LIGHT_GRAY);
			txteMail.addFocusListener(new FocusListener1());
			paneMail.add(lbleMail);
			paneMail.add(txteMail);
			
			JPanel panIndex = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JLabel lblIndex = new JLabel("Index*:");
			lblIndex.setPreferredSize(dim);
			JTextField txtIndex = new JTextField();
			txtIndex.setPreferredSize(dim);
			txtIndex.setName("txtIndex");
			txtIndex.setBackground(Color.LIGHT_GRAY);
			txtIndex.addFocusListener(new FocusListener1());
			panIndex.add(lblIndex);
			panIndex.add(txtIndex);
			
			JPanel panyearOfEnrollment = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JLabel lblyearOfEnrollment = new JLabel("Year of enrollment*:");
			lblyearOfEnrollment.setPreferredSize(dim);
			JTextField txtyearOfEnrollment = new JTextField();
			txtyearOfEnrollment.setPreferredSize(dim);
			txtyearOfEnrollment.setName("txtyearOfEnrollment");
			txtyearOfEnrollment.setBackground(Color.LIGHT_GRAY);
			txtyearOfEnrollment.addFocusListener(new FocusListener1());
			panyearOfEnrollment.add(lblyearOfEnrollment);
			panyearOfEnrollment.add(txtyearOfEnrollment);
			
			JPanel pancurrentYear = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JLabel lblcurrentYear = new JLabel("Current Year*:");
			lblcurrentYear.setPreferredSize(dim);
			pancurrentYear.add(lblcurrentYear);
			JComboBox cY = new JComboBox();
			cY.setName("currentYear");
			cY.addItem("1.(first)");
			cY.addItem("2.(second)");
			cY.addItem("3.(third)");
			cY.addItem("4.(fourth)");
			cY.addFocusListener(new  FocusListener2());
			pancurrentYear.add(cY);
			
			JPanel panStatus = new JPanel(new FlowLayout(FlowLayout.CENTER));
			JLabel lblStatus = new JLabel("Status*:");
			lblStatus.setPreferredSize(dim);
			panStatus.add(lblStatus);
			JComboBox cS = new JComboBox();
			cS.setName("Status");
			cS.addItem("S");
			cS.addItem("B");
			cS.addFocusListener(new  FocusListener2());
			panStatus.add(cS);	
			
			JButton CancelB = new JButton();
			CancelB.setBackground(Color.GRAY);
			CancelB.setPreferredSize(new Dimension(150,40));
			CancelB.setText("Cancel");
			CancelB.addActionListener(new ActionListener2());
			
			JPanel panConfCanc = new JPanel(new FlowLayout(FlowLayout.CENTER));
			panConfCanc.add(getInstance().ConfirmB);
			panConfCanc.add(CancelB);
			
			
			Box boxC = Box.createVerticalBox();
			boxC.add(Box.createVerticalStrut(20));
			boxC.add(panName);
			boxC.add(panSurname);
			boxC.add(panbirthDate);
			boxC.add(panAddress);
			boxC.add(pancontactPhone);
			boxC.add(paneMail);
			boxC.add(panIndex);
			boxC.add(panyearOfEnrollment);
			boxC.add(pancurrentYear);
			boxC.add(panStatus);
			boxC.add(panConfCanc);
			add(boxC, BorderLayout.NORTH);
			
			this.setSize(new Dimension(500, 600));
			setLocationRelativeTo(Main_Frame.getInstance());
			

		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public String getSurname() {
			return Surname;
		}
		public void setSurname(String surname) {
			Surname = surname;
		}
		public LocalDate getBirthDate() {
			return birthDate;
		}
		public void setBirthDate(LocalDate birthDate) {
			this.birthDate = birthDate;
		}
		public Address getAddress() {
			return address;
		}
		public void setAddress(Address address) {
			this.address = address;
		}
		public String getContactPhone() {
			return contactPhone;
		}
		public void setContactPhone(String contactPhone) {
			this.contactPhone = contactPhone;
		}
		public String geteMail() {
			return eMail;
		}
		public void seteMail(String eMail) {
			this.eMail = eMail;
		}
		public String getIndex() {
			return Index;
		}
		public void setIndex(String index) {
			Index = index;
		}
		public int getYearOfEnrollment() {
			return yearOfEnrollment;
		}
		public void setYearOfEnrollment(int yearOfEnrollment) {
			this.yearOfEnrollment = yearOfEnrollment;
		}
		public int getCurrentYear() {
			return currentYear;
		}
		public void setCurrentYear(int currentYear) {
			this.currentYear = currentYear;
		}
		public Status_enum getStatus() {
			return Status;
		}
		public void setStatus(String status) {
			if(status.equals("B")) Status = Status_enum.B ;
			else Status = Status_enum.S;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		
		
}
