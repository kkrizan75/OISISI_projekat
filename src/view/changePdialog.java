package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

import Model.Department;
import Model.Professor;
import controller.Read;

public class changePdialog extends JDialog{
	
	
	public class AbstractTableProfs extends AbstractTableModel {

		/**
		 * 
		 */
		private ArrayList<Professor> als;
		
		public ArrayList<Professor> getAls(){
			return als;
		}
		
		public AbstractTableProfs() {
			als = ProfessorsBase.getInstance().getProfDEP(Read.getInstance().getDep().get(DepartmentTable.getInstance().getSelectedRow()+1).getCode());	
//			for (Professor p : als) {
//				System.out.println(p.getName());
//				
//			}
//			System.out.println("\n\n");
		}
		
		private static final long serialVersionUID = 1L;

		@Override
		public int getRowCount() {
			return als.size();
		}

		@Override
		public int getColumnCount() {
			return 3;
		}

		@Override
		public String getColumnName(int column) {
			switch (column) {
			case 0:
				return "ID number";
			case 1:
				return "Name";
			case 2:
				return "Surname";
			default:
				return null;
			}
		}
		
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			if(rowIndex == -1) return null;
			Professor s = als.get(rowIndex);
			if(s == null) return null;
			switch (columnIndex) {
			case 0:
				return s.getID_number();
			case 1:
				return s.getName();
			case 2:
				return s.getSurname();
			default:
				return null;
			}
		}

	}
	
	
	public class Profs extends JTable {
		
		
		public Profs() {
			this.setRowSelectionAllowed(true);
			this.setColumnSelectionAllowed(true);
			this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			this.setModel(new AbstractTableProfs());
		}
		
		public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
			Component c = super.prepareRenderer(renderer, row, column);
			if (isRowSelected(row)) {
				c.setBackground(Color.LIGHT_GRAY);
			} else {
				c.setBackground(Color.WHITE);
			}
			return c;
		}

	}
	
	
	
	
	public changePdialog(Frame f,String s,boolean t) {
		super(f,s,t);
		Profs ss = new Profs();
		JScrollPane st = new JScrollPane(ss);
		JPanel jp = new JPanel();
		JButton conf = new JButton();
		conf.setBackground(Color.LIGHT_GRAY);
		conf.setPreferredSize(new Dimension(100,30));
		conf.setText("Confirm");
		conf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(ss.getSelectedRow() == -1) return;
				Professor p1 = ProfessorsBase.getInstance().getProfDEP(Read.getInstance().getDep().get(DepartmentTable.getInstance().getSelectedRow()+1).getCode()).
						get(ss.getSelectedRow());
				Department d = Read.getInstance().getDep().get(DepartmentTable.getInstance().getSelectedRow()+1);
				Read.getInstance().getDep().get(DepartmentTable.getInstance().getSelectedRow()+1);
				d.setBoss(p1);
				AbstractTableDepartments model = (AbstractTableDepartments) DepartmentTable.getInstance().getModel();
				model.fireTableDataChanged();
				DepartmentTable.getInstance().validate();
				setVisible(false);
			}
			
		});
		JButton canc = new JButton();
		canc.setBackground(Color.LIGHT_GRAY);
		canc.setPreferredSize(new Dimension(100,30));
		canc.setText("Cancel");
		canc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				
			}
			
		});
		jp.add(conf);
		jp.add(canc);
		add(st);
		add(jp,BorderLayout.SOUTH);
		setBounds(750, 180, 500, 600);
		setVisible(true);
	}
}
