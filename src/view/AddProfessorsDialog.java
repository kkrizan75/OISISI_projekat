package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


import Model.Address;
import controller.ProfessorsController;

public class AddProfessorsDialog extends JDialog{

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
	
	private JButton Confirm;
	
	private boolean[] checkValid = new boolean[10]; 
	
	
	public ArrayList<JLabel> errorMsgLbl = new ArrayList<JLabel>(10);
	
	public String getName() {
		return name;
	}



	private static AddProfessorsDialog instance = null;
	private ProfessorListener proflistener = new ProfessorListener();
	
	public static AddProfessorsDialog getInstance() {
		if(instance == null) {
			instance = new AddProfessorsDialog();
			instance.initCheck();
			}
		return instance;
	}
	
	
	public AddProfessorsDialog() {
		
		super(Main_Frame.getInstance(), true);
	
		setTitle("AddProfessor");
		
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
			txtName.addFocusListener(proflistener);
			panName.add(lblName);
			panName.add(txtName);
			p.add(Box.createHorizontalStrut(20));
			p.add(errorMsgLbl.get(i));
			boxC.add(panName);
			boxC.add(p);
			
		}
		
		
	    Confirm = new JButton();
		Confirm.setBackground(Color.cyan);
		Confirm.setPreferredSize(new Dimension(100,30));
		Confirm.setText("Confirm");
		Confirm.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
				
				ProfessorsController.getInstance().addProfessor(name, surname, title, eMail, phoneNum, offAddress, homeAddress, id, birthDate, yExp, null);
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
		panbuttons.add(Confirm);
		panbuttons.add(Box.createHorizontalStrut(100));
		panbuttons.add(Cancel);
		boxC.add(panbuttons);
		
		add(boxC, BorderLayout.NORTH);
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
	
	
	public void setDisabled() {
		Confirm.setEnabled(false);
	}
	
	public void setEnabled() {
		Confirm.setEnabled(true);
	}
	
	
	public void initCheck() {
		for(int i = 0; i < 10; i++) {
			setDisabled();
			checkValid[i] = false;
		}
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
