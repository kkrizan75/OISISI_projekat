package dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;

import javax.swing.Box;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class addStudentdialog extends JDialog{

		private static final long serialVersionUID = 3591599721565020284L;

		public addStudentdialog(Frame parent, String s, boolean modal) {
			Dimension dim = new Dimension(120, 25);

			JPanel panName = new JPanel(new FlowLayout(FlowLayout.LEFT));
			panName.setBackground(new Color(254, 254, 208));
			JLabel lblName = new JLabel("Name*:");
			lblName.setPreferredSize(dim);
			JTextField txtName = new JTextField();
			txtName.setPreferredSize(dim);
			txtName.setName("txtName");
			panName.add(lblName);
			panName.add(txtName);
			
			JPanel panSurname = new JPanel(new FlowLayout(FlowLayout.LEFT));
			panName.setBackground(new Color(254, 254, 208));
			JLabel lblSurname = new JLabel("Surname*:");
			lblSurname.setPreferredSize(dim);
			JTextField txtSurname = new JTextField();
			txtSurname.setPreferredSize(dim);
			txtSurname.setName("txtSurname");
			panSurname.add(lblSurname);
			panSurname.add(txtSurname);
			
			JPanel panbirthDate = new JPanel(new FlowLayout(FlowLayout.LEFT));
			panName.setBackground(new Color(254, 254, 208));
			JLabel lblbirthDate = new JLabel("Birth date*:");
			lblbirthDate.setPreferredSize(dim);
			JTextField txtbirthDate = new JTextField();
			txtbirthDate.setPreferredSize(dim);
			txtbirthDate.setName("txtbirthDate");
			panbirthDate.add(lblbirthDate);
			panbirthDate.add(txtbirthDate);
			
			JPanel panAddress = new JPanel(new FlowLayout(FlowLayout.LEFT));
			panName.setBackground(new Color(254, 254, 208));
			JLabel lblAddress = new JLabel("Address*:");
			lblAddress.setPreferredSize(dim);
			JTextField txtAddress = new JTextField();
			txtAddress.setPreferredSize(dim);
			txtAddress.setName("txtAddress");
			panAddress.add(lblAddress);
			panAddress.add(txtAddress);
			
			JPanel pancontactPhone = new JPanel(new FlowLayout(FlowLayout.LEFT));
			panName.setBackground(new Color(254, 254, 208));
			JLabel lblcontactPhone = new JLabel("Contact Phone*:");
			lblcontactPhone.setPreferredSize(dim);
			JTextField txtcontactPhone = new JTextField();
			txtcontactPhone.setPreferredSize(dim);
			txtcontactPhone.setName("txtcontactPhone");
			pancontactPhone.add(lblcontactPhone);
			pancontactPhone.add(txtcontactPhone);
			
			JPanel paneMail = new JPanel(new FlowLayout(FlowLayout.LEFT));
			panName.setBackground(new Color(254, 254, 208));
			JLabel lbleMail = new JLabel("E-mail*:");
			lbleMail.setPreferredSize(dim);
			JTextField txteMail = new JTextField();
			txteMail.setPreferredSize(dim);
			txteMail.setName("txteMail");
			paneMail.add(lbleMail);
			paneMail.add(txteMail);
			
			JPanel panIndex = new JPanel(new FlowLayout(FlowLayout.LEFT));
			panName.setBackground(new Color(254, 254, 208));
			JLabel lblIndex = new JLabel("Index*:");
			lblIndex.setPreferredSize(dim);
			JTextField txtIndex = new JTextField();
			txtIndex.setPreferredSize(dim);
			txtIndex.setName("txtIndex");
			panIndex.add(lblIndex);
			panIndex.add(txtIndex);
			
			JPanel panyearOfEnrollment = new JPanel(new FlowLayout(FlowLayout.LEFT));
			panName.setBackground(new Color(254, 254, 208));
			JLabel lblyearOfEnrollment = new JLabel("Year of enrollment*:");
			lblyearOfEnrollment.setPreferredSize(dim);
			JTextField txtyearOfEnrollment = new JTextField();
			txtyearOfEnrollment.setPreferredSize(dim);
			txtyearOfEnrollment.setName("txtyearOfEnrollment");
			panyearOfEnrollment.add(lblyearOfEnrollment);
			panyearOfEnrollment.add(txtyearOfEnrollment);
			
			JPanel pancurrentYear = new JPanel(new FlowLayout(FlowLayout.LEFT));
			panName.setBackground(new Color(254, 254, 208));
			JLabel lblcurrentYear = new JLabel("Current Year*:");
			lblcurrentYear.setPreferredSize(dim);
			pancurrentYear.add(lblcurrentYear);
			
			JPanel panStatus = new JPanel(new FlowLayout(FlowLayout.LEFT));
			panName.setBackground(new Color(254, 254, 208));
			JLabel lblStatus = new JLabel("Status*:");
			lblStatus.setPreferredSize(dim);
			panStatus.add(lblStatus);
			
			
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
			add(boxC, BorderLayout.NORTH);
			
			setBounds(750, 180, 400, 500);
			

		}
}
