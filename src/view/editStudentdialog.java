package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import Model.Address;
import Model.Grade;
import Model.Student;
import Model.Student.Status_enum;
import controller.StudentsController;


public class editStudentdialog extends JDialog{
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
	
	private String oldIND;
	
	private static editStudentdialog instance = null;
	
	private void setconfF(Student S) {
		for (int i=0;i<8;i++) {
			setTrue(i);
		}
		this.setName(S.getname());
		this.setSurname(S.getSurname());
		this.setContactPhone(S.getcontactPhone());
		this.seteMail(S.geteMail());
		this.setIndex(S.getIndex());
		this.setAddress(S.getAdress());
		this.setBirthDate(S.getbirthDate());
		this.setYearOfEnrollment(S.getyearOfEnrollment());
		this.setCurrentYear(S.getcurrentYear());
		this.setStatus(S.getStatus());
		this.setoldIND((S.getIndex()));
		ConfirmB.setBackground(Color.GRAY);
		ConfirmB.setPreferredSize(new Dimension(150,40));
		ConfirmB.setText("Confirm");
		ConfirmB.addActionListener(new ActionListenerCONF());
	}
	
	public static editStudentdialog getInstance() {
		if(instance == null) {
			instance = new editStudentdialog();
			}
		return instance;
	}
	
	editStudentdialog(){
		
	}
	
	public class FocusListenerCB implements FocusListener{
		
		 @Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void focusLost(FocusEvent arg0) {
			// TODO Auto-generated method stub
			
			JComboBox cB = (JComboBox) arg0.getComponent();
			if (cB.getName().equals("currentYear")) {
			if(cB.getSelectedItem().equals("2.(second)")) {
				editStudentdialog.getInstance().setCurrentYear(2);
			}
			else if (cB.getSelectedItem().equals("3.(third)")) {
				editStudentdialog.getInstance().setCurrentYear(3);
			} 
			else if (cB.getSelectedItem().equals("4.(fourth)")) {
				editStudentdialog.getInstance().setCurrentYear(4);
			}
			else if (cB.getSelectedItem().equals("1.(first)")) {
				editStudentdialog.getInstance().setCurrentYear(1);
			}
			
			}
			
			if(cB.getName().equals("Status")) {
				if(cB.getSelectedItem().equals("S")) {
					editStudentdialog.getInstance().setStatus(Status_enum.S);
				}
				else editStudentdialog.getInstance().setStatus(Status_enum.B);
				}
			}
	}
	
	public boolean checkB() {
		for (boolean b : conf) {
			if (!b) {
				return b;
			}
		}
		return true;
	}
	
	public void setconfT() {
		ConfirmB.setEnabled(true);
	}
	
	public void setconfF() {
		ConfirmB.setEnabled(false);
	}
	
	public void setTrue(int i) {
		conf[i] = true;
	}
	
	public void setFalse(int i) {
		conf[i] = false;
	}
	
	public class ActionListenerCONF implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (getInstance().checkB()) 
				StudentsController.getInstance().editStudent();
			else {
				JOptionPane.showMessageDialog(addStudentdialog.getInstance(), "Blanks cannot be empty.");
			}
		}
	}

	public editStudentdialog(Frame f,String s,boolean b) {
		
		super(f,s,b);
		Student S = StudentsController.getInstance().findSelcetedStudent(StudentTable.getInstance().getSelectedRow());
		getInstance().setconfF(S);
		getInstance().setconfT();
		Dimension dim = new Dimension(200, 25);
		JPanel panName = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblName = new JLabel("Name*:");
		lblName.setPreferredSize(dim);
		JTextField txtName = new JTextField();
		txtName.setPreferredSize(dim);
		txtName.setName("txtName");
		txtName.setBackground(Color.LIGHT_GRAY);
		txtName.setText(getInstance().getName());
		txtName.addFocusListener(new EditFocusListener());
		panName.add(lblName);
		panName.add(txtName);
		
		JPanel panSurname = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblSurname = new JLabel("Surname*:");
		lblSurname.setPreferredSize(dim);
		JTextField txtSurname = new JTextField();
		txtSurname.setPreferredSize(dim);
		txtSurname.setName("txtSurname");
		txtSurname.setBackground(Color.LIGHT_GRAY);
		txtSurname.setText(getInstance().getSurname());
		txtSurname.addFocusListener(new EditFocusListener());
		panSurname.add(lblSurname);
		panSurname.add(txtSurname);
		
		JPanel panbirthDate = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblbirthDate = new JLabel("Birth date*:");
		lblbirthDate.setPreferredSize(dim);
		JTextField txtbirthDate = new JTextField();
		txtbirthDate.setPreferredSize(dim);
		txtbirthDate.setName("txtbirthDate");
		txtbirthDate.setBackground(Color.LIGHT_GRAY);
		txtbirthDate.setText(getInstance().getBirthDate().toString());
		txtbirthDate.addFocusListener(new EditFocusListener());
		panbirthDate.add(lblbirthDate);
		panbirthDate.add(txtbirthDate);
		
		JPanel panAddress = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblAddress = new JLabel("Address*:");
		lblAddress.setPreferredSize(dim);
		JTextField txtAddress = new JTextField();
		txtAddress.setPreferredSize(dim);
		txtAddress.setName("txtAddress");
		txtAddress.setBackground(Color.LIGHT_GRAY);
		txtAddress.setText(getInstance().getAddress().toString());
		txtAddress.addFocusListener(new EditFocusListener());
		panAddress.add(lblAddress);
		panAddress.add(txtAddress);
		
		JPanel pancontactPhone = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblcontactPhone = new JLabel("Contact Phone*:");
		lblcontactPhone.setPreferredSize(dim);
		JTextField txtcontactPhone = new JTextField();
		txtcontactPhone.setPreferredSize(dim);
		txtcontactPhone.setName("txtcontactPhone");
		txtcontactPhone.setBackground(Color.LIGHT_GRAY);
		txtcontactPhone.setText(getInstance().getContactPhone());
		txtcontactPhone.addFocusListener(new EditFocusListener());
		pancontactPhone.add(lblcontactPhone);
		pancontactPhone.add(txtcontactPhone);
		
		JPanel paneMail = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lbleMail = new JLabel("E-mail*:");
		lbleMail.setPreferredSize(dim);
		JTextField txteMail = new JTextField();
		txteMail.setPreferredSize(dim);
		txteMail.setName("txteMail");
		txteMail.setBackground(Color.LIGHT_GRAY);
		txteMail.setText(getInstance().geteMail());
		txteMail.addFocusListener(new EditFocusListener());
		paneMail.add(lbleMail);
		paneMail.add(txteMail);
		
		JPanel panIndex = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblIndex = new JLabel("Index*:");
		lblIndex.setPreferredSize(dim);
		JTextField txtIndex = new JTextField();
		txtIndex.setPreferredSize(dim);
		txtIndex.setName("txtIndex");
		txtIndex.setBackground(Color.LIGHT_GRAY);
		txtIndex.setText(getInstance().getIndex());
		txtIndex.addFocusListener(new EditFocusListener());
		panIndex.add(lblIndex);
		panIndex.add(txtIndex);
		
		JPanel panyearOfEnrollment = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblyearOfEnrollment = new JLabel("Year of enrollment*:");
		lblyearOfEnrollment.setPreferredSize(dim);
		JTextField txtyearOfEnrollment = new JTextField();
		txtyearOfEnrollment.setPreferredSize(dim);
		txtyearOfEnrollment.setName("txtyearOfEnrollment");
		txtyearOfEnrollment.setBackground(Color.LIGHT_GRAY);
		txtyearOfEnrollment.setText(getInstance().getYearOfEnrollment() + "");
		txtyearOfEnrollment.addFocusListener(new EditFocusListener());
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
		cY.setSelectedIndex(getInstance().getCurrentYear()-1);
		cY.addFocusListener(new  FocusListenerCB());
		pancurrentYear.add(cY);
		
		JPanel panStatus = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblStatus = new JLabel("Status*:");
		lblStatus.setPreferredSize(dim);
		panStatus.add(lblStatus);
		JComboBox cS = new JComboBox();
		cS.setName("Status");
		cS.addItem("S");
		cS.addItem("B");
		if (getInstance().getStatus() == Status_enum.S) cS.setSelectedIndex(0);
		else cS.setSelectedIndex(1);
		cS.addFocusListener(new  FocusListenerCB());
		panStatus.add(cS);
		
		JButton CancelB = new JButton();
		CancelB.setBackground(Color.GRAY);
		CancelB.setPreferredSize(new Dimension(150,40));
		CancelB.setText("Cancel");
		CancelB.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			 	EditActionListener.geteSd().setVisible(false);
			}
		});
		
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
		JTabbedPane dT = new JTabbedPane();
		dT.add("Information", boxC);
		
		//JList list = new JList();
		JPanel panTest = new JPanel(new FlowLayout(FlowLayout.CENTER));
		ArrayList<Grade> Passed = StudentsController.getInstance().findStudentByInD(getInstance().getIndex()).getpassedSubjects();
		
		JPanel failedSubjects = new JPanel();
		JButton pass = new JButton();
		pass.setBackground(Color.LIGHT_GRAY);
		pass.setPreferredSize(new Dimension(100,30));
		pass.setText("Pass");
		
		JButton remove = new JButton();
		remove.setBackground(Color.LIGHT_GRAY);
		remove.setPreferredSize(new Dimension(100,30));
		remove.setText("Remove");
		
		JButton add = new JButton();
		add.setBackground(Color.LIGHT_GRAY);
		add.setPreferredSize(new Dimension(100,30));
		add.setText("Add");
		
		failedSubjects.add(add);
		failedSubjects.add(remove);
		failedSubjects.add(pass);
		failedSubjects.add(new JScrollPane(FailedSubjectsTable.getInstance()));
		dT.add("Passed Subjects", panTest);
		dT.add("Failed Subjects", failedSubjects);
		JPanel defaultPanel = new JPanel();
		defaultPanel.setBackground(new Color(255,255,255));
		defaultPanel.setLayout(new BorderLayout());
		defaultPanel.add(dT,BorderLayout.CENTER);
		add(defaultPanel);
		
		setBounds(750, 180, 500, 600);
		
	}
	
	
	public String getoldIND() {
		return oldIND;
	}

	public void setoldIND(String ind) {
		oldIND = ind;
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

	public void setStatus(Status_enum status) {
		Status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
