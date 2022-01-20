package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Model.Address;
import Model.Professor;
import Model.Student;
import Model.Subject;
import controller.ProfessorsController;
import controller.StudentsController;


public class EditProfessorsDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String surname;
	private LocalDate birthDate;
	private Address homeAddress;
	private String eMail;
	private int yExp;
	private String id;
	private Address offAddress;
	private String phoneNum;
	private String title;
	private String currentID;
	
	private JButton confirm;
	
	private boolean[] checkValid = new boolean[10]; 
	private String[] oldFields = new String[10];
	
	public ArrayList<JLabel> errorMsgLbl = new ArrayList<JLabel>(10);
	
	public String getName() {
		return name;
	}



	private static EditProfessorsDialog instance = null;
	private EditProfessorsListener proflistener = new EditProfessorsListener();
	
	public static EditProfessorsDialog getInstance() {
		if(instance == null) {
			instance = new EditProfessorsDialog();
			}
		return instance;
	}


	
	public EditProfessorsDialog() {
		
	
		super(Main_Frame.getInstance(), true);

		
		Professor prof = ProfessorsController.getInstance().findSelectedProfessor(ProfessorsTable.getInstance().getSelectedIndex());
		System.out.println(ProfessorsTable.getInstance().getSelectedIndex());
		
		initCheck(prof);
		
		setTitle("Edit Professor");
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension dim = new Dimension(200, 25);
	
		Box boxC = Box.createVerticalBox();
		boxC.add(Box.createVerticalStrut(20));
		
		
		String[] lblNames = new String [] {"Name*:", "Surname*:", "Birth date*:", "E-mail*:", "Address of Residence", "Phone number*:",
											"Office address*:","Title*:", "ID:*", "Years of experience*:"};
		
		String[] txtFields = new String[] {"txtName", "txtSurname", "txtDate", "txtEmail", "txtAddress", "txtPhone", "txtOffice",
											"txtTitle","txtID", "txtYexp"};
		
		
		
		for(int i = 0; i < 10; i++) {
			JLabel lblTemp = new JLabel("",SwingConstants.CENTER);
			lblTemp.setPreferredSize(new Dimension(300,10));
			lblTemp.setMaximumSize(new Dimension(300,5));
			lblTemp.setVisible(true);
			lblTemp.setFont(new Font("Calibri", Font.BOLD, 8));
			lblTemp.setForeground(Color.red);
			errorMsgLbl.add(i,lblTemp);
		}
		
		
		for(int i = 0; i < 10; i++) {
			
			JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT,0,0));
			JPanel panName = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
			JLabel lblName = new JLabel(lblNames[i]);
			lblName.setPreferredSize(dim);
			JTextField txtName = new JTextField();
			txtName.setPreferredSize(dim);
			txtName.setName(txtFields[i]);
			txtName.setBackground(Color.LIGHT_GRAY);
			txtName.setText(oldFields[i]);
			txtName.addFocusListener(proflistener);
			panName.add(lblName);
			panName.add(txtName);
			p.add(Box.createHorizontalStrut(20));
			p.add(errorMsgLbl.get(i));
			boxC.add(panName);
			boxC.add(p);
			
		}
		
		
		
		confirm = new JButton();
		confirm.setBackground(Color.cyan);
		confirm.setPreferredSize(new Dimension(100,30));
		confirm.setText("Confirm");
		confirm.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ProfessorsController.getInstance().editProfessor(ProfessorsTable.getInstance().getSelectedRow());
				instance.setVisible(false);
				instance = null;
			}
		});
		
		
		JButton Cancel = new JButton();
		Cancel.setBackground(Color.GRAY);
		Cancel.setPreferredSize(new Dimension(100,30));
		Cancel.setText("Cancel");
		Cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				getInstance().setVisible(false);
				instance = null;
			
		}
	});
		
		JPanel panbuttons = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panbuttons.add(confirm);
		panbuttons.add(Box.createHorizontalStrut(100));
		panbuttons.add(Cancel);
		boxC.add(panbuttons);
		
		JTabbedPane tp = new JTabbedPane();
		tp.add("Information", boxC);
		JPanel subjectsinfo = new JPanel();
		JPanel buttons = new JPanel();
		JButton AddS = new JButton();
		AddS.setBackground(Color.LIGHT_GRAY);
		AddS.setPreferredSize(new Dimension(140,30));
		AddS.setText("Add Subject");
		AddS.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new addSubjtoP(Main_Frame.getInstance(),"Add Subject",true);
				
			}
			
		});
		JButton	RemoveS = new JButton();
		RemoveS.setBackground(Color.LIGHT_GRAY);
		RemoveS.setPreferredSize(new Dimension(140,30));
		RemoveS.setText("Remove Subject");
		RemoveS.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(ProfTable.getInstance().getSelectedRow() == -1 ) {
					JOptionPane.showMessageDialog(getInstance(), "No row selected!","Error!",2);
					return;
				}
				int result = JOptionPane.showConfirmDialog(Main_Frame.getInstance(),"Are you sure you want to delete this Subject?", "Sure?",
			               JOptionPane.YES_NO_OPTION,
			               JOptionPane.QUESTION_MESSAGE);
				if (result == JOptionPane.NO_OPTION) return;
				Professor stu = ProfessorsBase.getInstance().findProfa(ProfessorsController.getInstance().findSelectedProfessor(ProfessorsTable.getInstance().getSelectedRow()).getID_number());
				Subject s = stu.getRowSub((ProfTable.getInstance().getSelectedRow()));
				stu.removeSubj(s);
				s.setProfessor(null);
				AbstractProfTable model = (AbstractProfTable) ProfTable.getInstance().getModel();
				model.fireTableDataChanged();
				EditProfessorsDialog.getInstance().validate();
			}
		});
		buttons.add(AddS);
		buttons.add(RemoveS);
		ProfTable pt = ProfTable.getInstance();
		subjectsinfo.add(buttons,BorderLayout.NORTH);
		subjectsinfo.add(new JScrollPane(pt),BorderLayout.SOUTH);
		tp.add("Subjects", subjectsinfo);
		JPanel dialogPanel = new JPanel();
		dialogPanel.setBackground(new Color(255,255,255));
		dialogPanel.setLayout(new BorderLayout());
		dialogPanel.add(tp,BorderLayout.CENTER);
		add(dialogPanel);
		Dimension d = kit.getScreenSize();
		setSize(3*d.width/12, 8* d.height/16);
		setLocationRelativeTo(null);
		
		
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				instance.setVisible(false);
				instance = null;
				}
		});	
			
		}
	
	public void initCheck(Professor p) {
		for(int i = 0; i < 10; i++) {
			checkValid[i] = true;
		}
			this.setName(p.getName());
			this.setSurname(p.getSurname());
			this.setBirthDate(p.getBirth_date());
			this.seteMail(p.getE_mail());
			this.setHomeAddress(p.getAddress_of_residence());
			this.setPhoneNum(p.getContact_phone());
			this.setOffAddress(p.getOffice_address());
			this.setId(p.getID_number());
			this.setTitleProf(p.getTitle());
			this.setyExp(p.getYears_of_work_exp());
			this.setCurrentID(p.getID_number());
			
			oldFields[0] = p.getName();
			oldFields[1] = p.getSurname();
			oldFields[2] = p.getBirth_date().toString();
			oldFields[3] = p.getE_mail();
			oldFields[4] = p.getAddress_of_residence().toString();
			oldFields[5] = p.getContact_phone();
			oldFields[6] = p.getOffice_address().toString();
			oldFields[7] = p.getTitle();
			oldFields[8] = p.getID_number();
			oldFields[9] = Integer.toString(p.getYears_of_work_exp());
	}
	
	
	public void setDisabled() {
		confirm.setEnabled(false);
	}
	
	public void setEnabled() {
		confirm.setEnabled(true);
	}
	
	
	public boolean getCheck() {
		
		for(int i = 0; i < 10; i++) {
			if(checkValid[i] == false) {
				return false;
			}
		}
		return true;
	}
	
	public void setCheck(int i, boolean b) {
		checkValid[i] = b;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}

	public String getCurrentID() {
		return currentID;
	}



	public void setCurrentID(String currentID) {
		this.currentID = currentID;
	}



	public String getSurname() {
		return surname;
	}



	public void setSurname(String surname) {
		this.surname = surname;
	}



	public LocalDate getBirthDate() {
		return birthDate;
	}



	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}



	public Address getHomeAddress() {
		return homeAddress;
	}



	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}



	public String geteMail() {
		return eMail;
	}



	public void seteMail(String eMail) {
		this.eMail = eMail;
	}



	public int getyExp() {
		return yExp;
	}



	public void setyExp(int yExp) {
		this.yExp = yExp;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public Address getOffAddress() {
		return offAddress;
	}



	public void setOffAddress(Address offAddress) {
		this.offAddress = offAddress;
	}



	public String getPhoneNum() {
		return phoneNum;
	}



	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}



	public String getTitleProf() {
		return title;
	}



	public void setTitleProf(String title) {
		this.title = title;
	}
}
