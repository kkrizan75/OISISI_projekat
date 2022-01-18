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
import controller.StudentsController;
import controller.SubjectsController;
import view.addSubjectDialog.ActionListener2;

public class editSubjectDialog extends JDialog{

	
	private JButton ConfirmB = new JButton();
	private boolean[] conf = new boolean[4];
	private String Id;
	private String Name;
	private Semester_enum semester;
	private int yearOfStudy;
	private int ECTS;
	private String oldId;
	
	private static editSubjectDialog instance = null;
	
	private void setconfF(Subject s) {
		for (int i=0;i<4;i++) {
			setTrue(i);
		}
		this.setId(s.getId());
		this.setoldID(s.getId());
		this.setName(s.getName());
		this.setSemester(s.getSemester());
		this.setYearOfStudy(s.getyearOfStudy());
		this.setECTS(s.getECTS());
		ConfirmB.setBackground(Color.GRAY);
		ConfirmB.setPreferredSize(new Dimension(150,40));
		ConfirmB.setText("Confirm");
		ConfirmB.addActionListener(new ActionListenerCONF());
		ConfirmB.setEnabled(false);
	}
	
	public void setoldID(String s) {
		oldId = s;
	}
	
	public String getoldID() {
		return oldId;
	}

	public static editSubjectDialog getInstance() {
		if(instance == null) {
			instance = new editSubjectDialog();
			}
		return instance;
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
				SubjectsController.getInstance().editSubject();
			else {
				JOptionPane.showMessageDialog(editSubjectDialog.getInstance(), "Error!");
			}
		}
	}
		
	editSubjectDialog(){	
	}
	
	public editSubjectDialog(Frame f,String s,boolean b) {
		super(f,s,b);
		Subject su =	SubjectsController.getInstance().findSelcetedSubject(SubjectsTable.getInstance().getSelectedRow());
		getInstance().setconfF(su);
		getInstance().setconfT();
		getInstance().checkB();
		Dimension dim = new Dimension(200, 25);
		JPanel panName = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblName = new JLabel("Name*:");
		lblName.setPreferredSize(dim);
		JTextField txtName = new JTextField();
		txtName.setPreferredSize(dim);
		txtName.setName("txtName");
		txtName.setBackground(Color.LIGHT_GRAY);
		txtName.setText(getInstance().getName());
		txtName.addFocusListener(new editSubjFListener());
		panName.add(lblName);
		panName.add(txtName);
		
		JPanel panId = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblId = new JLabel("Id*:");
		lblId.setPreferredSize(dim);
		JTextField txtId = new JTextField();
		txtId.setPreferredSize(dim);
		txtId.setName("txtId");
		txtId.setBackground(Color.LIGHT_GRAY);
		txtId.setText(getInstance().getId());
		txtId.addFocusListener(new editSubjFListener());
		panId.add(lblId);
		panId.add(txtId);
		
		JPanel panyearOfStudy = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblyearOfStudy = new JLabel("Year Of Study*:");
		lblyearOfStudy.setPreferredSize(dim);
		JTextField txtyearOfStudy = new JTextField();
		txtyearOfStudy.setPreferredSize(dim);
		txtyearOfStudy.setName("txtyearOfStudy");
		txtyearOfStudy.setBackground(Color.LIGHT_GRAY);
		txtyearOfStudy.setText(getInstance().getYearOfStudy()+"");
		txtyearOfStudy.addFocusListener(new editSubjFListener());
		panyearOfStudy.add(lblyearOfStudy);
		panyearOfStudy.add(txtyearOfStudy);
		
		JPanel panECTS = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblECTS = new JLabel("ECTS*:");
		lblECTS.setPreferredSize(dim);
		JTextField txtECTS = new JTextField();
		txtECTS.setPreferredSize(dim);
		txtECTS.setName("txtECTS");
		txtECTS.setBackground(Color.LIGHT_GRAY);
		txtECTS.setText(getInstance().getECTS()+"");
		txtECTS.addFocusListener(new editSubjFListener());
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
		if (getInstance().getSemester() == Semester_enum.W) cS.setSelectedIndex(0);
		else cS.setSelectedIndex(1);
		cS.addFocusListener(new FocusListener(){
		
		 @Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void focusLost(FocusEvent arg0) {
			// TODO Auto-generated method stub
			
			JComboBox cB = (JComboBox) arg0.getComponent();
			
			if(cB.getName().equals("Semester")) {
				if(cB.getSelectedItem().equals("S")) {
					editSubjectDialog.getInstance().setSemester(Semester_enum.S);
				}
				else editSubjectDialog.getInstance().setSemester(Semester_enum.W);
				}
			}
		}
			);
		panSemester.add(cS);
		
		JButton CancelB = new JButton();
		CancelB.setBackground(Color.GRAY);
		CancelB.setPreferredSize(new Dimension(150,40));
		CancelB.setText("Cancel");
		CancelB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				 	EditActionListener.gateSud().setVisible(false);
				}
			});
		
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
		
		setBounds(750, 180, 500, 600);
	}

	public boolean[] getConf() {
		return conf;
	}

	public void setConf(boolean[] conf) {
		this.conf = conf;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Semester_enum getSemester() {
		return semester;
	}

	public void setSemester(Semester_enum semester) {
		this.semester = semester;
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
}
