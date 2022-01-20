package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

public class DepartmentDialog extends JDialog{	
	
	private static DepartmentDialog instance = null;
	
	public static DepartmentDialog getInstance() {
		if(instance == null) {
			instance = new DepartmentDialog(Main_Frame.getInstance(),"Change Professor",true);
			}
		return instance;
	}
	
	public DepartmentDialog(Frame f,String s,boolean b) {
		super(f,s,b);
		DepartmentTable fs = DepartmentTable.getInstance();
		JScrollPane st = new JScrollPane(fs);
		JPanel pan = new JPanel();
		JPanel pa2 = new JPanel();
		JButton ok = new JButton();
		ok.setBackground(Color.LIGHT_GRAY);
		ok.setPreferredSize(new Dimension(100,30));
		ok.setText("Apply");
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
			
		});
		JButton Change = new JButton();
		Change.setBackground(Color.LIGHT_GRAY);
		Change.setPreferredSize(new Dimension(100,30));
		Change.setText("Change");
		Change.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(DepartmentTable.getInstance().getSelectedRow() == -1)  {
					JOptionPane.showMessageDialog(Main_Frame.getInstance(), "No row selected!","Error",2);
					return;
				}
				new changePdialog(Main_Frame.getInstance(),"Change Professor",true); 
			}
			
		});
		pan.add(st);
		pa2.add(ok);
		pa2.add(Change);
		add(pan);
		add(pa2,BorderLayout.SOUTH);
		setBounds(750, 180, 500, 600);
		setVisible(true);
	}
}
