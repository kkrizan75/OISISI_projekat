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

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.Subject;
import Model.Student.Status_enum;
import Model.Subject.Semester_enum;
import controller.SubjectsController;

public class addSubjectDialog extends JDialog{
	private JButton ConfirmB = new JButton();
	private boolean[] conf = new boolean[4];
	private String Id;
	private String Name;
	private Semester_enum semester;
	private int yearOfStudy;
	private int ECTS;
	
	private static addSubjectDialog instance = null;
	
	private void restart() {
		for (boolean c : conf) {
			c = false;
		}
		this.setId("");
		this.setName("");
		this.setSemester("W");
		this.setYearOfStudy(-1);
		this.setECTS(-1);
		ConfirmB.setEnabled(false);
	}
	
	private void setconfF() {
		for (boolean c : conf) {
			c = false;
		}
		this.setId("");
		this.setName("");
		this.setSemester("W");
		this.setYearOfStudy(-1);
		this.setECTS(-1);
		ConfirmB.setBackground(Color.GRAY);
		ConfirmB.setPreferredSize(new Dimension(150,40));
		ConfirmB.setText("Confirm");
		ConfirmB.addActionListener(new ActionListener3());
		ConfirmB.setEnabled(false);
	}
	
	public boolean[] getConf() {
		return conf;
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
	
	public static addSubjectDialog getInstance() {
		if(instance == null) {
			instance = new addSubjectDialog();
			instance.setconfF();
			}
		return instance;
	}
	private addSubjectDialog() {
	}

	public void setConf(boolean[] conf) {
		this.conf = conf;
	}

	public String getId() {
		return Id;
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
			ActionListener1.getaSud().setVisible(false);
		}

	}
	
	private class FocusListener1 implements FocusListener{

		@Override
		public void focusGained(FocusEvent e) {
			
		}

		@Override
		public void focusLost(FocusEvent e) {
			JComboBox cB = (JComboBox) e.getComponent();
				if(cB.getSelectedItem().equals("S")) {
					getInstance().setSemester("S");
				}
				else {
					getInstance().setSemester("");
				}
		
		}
	}
	
	public class ActionListener3 implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (checkConfBTN()) {
						SubjectsController.getInstance().addSubject();
						getInstance().restart();
					}
			else {
				JOptionPane.showMessageDialog(addSubjectDialog.getInstance(), "Error!");
			}
		}
	}
	
	public boolean checkConfBTN() {
		return cmpEmp(getInstance().getName()) && cmpEmp(getInstance().getId()) &&
				!(getInstance().getYearOfStudy()==-1) && !(getInstance().getECTS()==-1)
				&& getInstance().checkB();
	}
	
	
	public addSubjectDialog(Frame parent, String s, boolean modal) {
		super(parent,s,modal);
		
		Dimension dim = new Dimension(200, 25);
		JPanel panName = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblName = new JLabel("Name*:");
		lblName.setPreferredSize(dim);
		JTextField txtName = new JTextField();
		txtName.setPreferredSize(dim);
		txtName.setName("txtName");
		txtName.setBackground(Color.LIGHT_GRAY);
		txtName.addFocusListener(new addSubjFListener());
		panName.add(lblName);
		panName.add(txtName);
		
		JPanel panId = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblId = new JLabel("Id*:");
		lblId.setPreferredSize(dim);
		JTextField txtId = new JTextField();
		txtId.setPreferredSize(dim);
		txtId.setName("txtId");
		txtId.setBackground(Color.LIGHT_GRAY);
		txtId.addFocusListener(new addSubjFListener());
		panId.add(lblId);
		panId.add(txtId);
		
		JPanel panyearOfStudy = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblyearOfStudy = new JLabel("Year Of Study*:");
		lblyearOfStudy.setPreferredSize(dim);
		JTextField txtyearOfStudy = new JTextField();
		txtyearOfStudy.setPreferredSize(dim);
		txtyearOfStudy.setName("txtyearOfStudy");
		txtyearOfStudy.setBackground(Color.LIGHT_GRAY);
		txtyearOfStudy.addFocusListener(new addSubjFListener());
		panyearOfStudy.add(lblyearOfStudy);
		panyearOfStudy.add(txtyearOfStudy);
		
		JPanel panECTS = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblECTS = new JLabel("ECTS*:");
		lblECTS.setPreferredSize(dim);
		JTextField txtECTS = new JTextField();
		txtECTS.setPreferredSize(dim);
		txtECTS.setName("txtECTS");
		txtECTS.setBackground(Color.LIGHT_GRAY);
		txtECTS.addFocusListener(new addSubjFListener());
		panECTS.add(lblECTS);
		panECTS.add(txtECTS);
		
		JPanel panSemester = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblSemester = new JLabel("Semester*:");
		lblSemester.setPreferredSize(dim);
		panSemester.add(lblSemester);
		JComboBox cS = new JComboBox();
		cS.setName("Semester");
		cS.addItem("W");
		cS.addItem("S");
		cS.addFocusListener(new FocusListener1());
		panSemester.add(cS);
		
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
		boxC.add(panId);
		boxC.add(panECTS);
		boxC.add(panyearOfStudy);
		boxC.add(panSemester);
		boxC.add(panConfCanc);
		
		
		add(boxC, BorderLayout.NORTH);
		
		this.setSize(new Dimension(500, 600));
		setLocationRelativeTo(Main_Frame.getInstance());
	}
	
	public void setId(String Id) {
		this.Id = Id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public Semester_enum getSemester() {
		return semester;
	}

	public void setSemester(String str) {
		if(str.equals("S")) this.semester = Semester_enum.S;
		else this.semester = Semester_enum.W;
	}

	public int getYearOfStudy() {
		return yearOfStudy;
	}

	public void setYearOfStudy(int yearOfStudy) {
		this.yearOfStudy = yearOfStudy;
	}

	public int getECTS() {
		return ECTS;
	}

	public void setECTS(int eCTS) {
		ECTS = eCTS;
	}

	public static void setInstance(addSubjectDialog instance) {
		addSubjectDialog.instance = instance;
	}

	
}
