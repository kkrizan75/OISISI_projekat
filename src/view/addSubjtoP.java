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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

import Model.Professor;
import Model.Subject;
import Model.Subject.Semester_enum;
import controller.ProfessorsController;

public class addSubjtoP extends JDialog{
	
	
	public class AbstractTableallSubjects extends AbstractTableModel {

		/**
		 * 
		 */
		
		private ArrayList<Subject> als = SubjectsBase.getInstance().getSubjsNoProf();
		
		public ArrayList<Subject> getAls(){
			return als;
		}
		
		private static final long serialVersionUID = 1L;

		@Override
		public int getRowCount() {
			return SubjectsBase.getInstance().getSubjsNoProf().size();
		}

		@Override
		public int getColumnCount() {
			return SubjectsBase.getInstance().getColumnCount();
		}

		@Override
		public String getColumnName(int column) {
			return SubjectsBase.getInstance().getColumnName(column);
		}
		
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Subject s = als.get(rowIndex);
			switch (columnIndex) {
			case 0:
				return s.getId();
			case 1:
				return s.getName();
			case 2:
				return Integer.toString(s.getECTS());
			case 3:
				return Integer.toString(s.getyearOfStudy());
			case 4:
				if (s.getSemester() == Semester_enum.W) return "WINTER";
				else return "SUMMER";
			default:
				return null;
			}
		}

	}
	
	
	public class allSubjects extends JTable {
		
		private AbstractTableallSubjects abt = new AbstractTableallSubjects();
		
		public allSubjects() {
			this.setRowSelectionAllowed(true);
			this.setColumnSelectionAllowed(true);
			this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			this.setModel(abt);
		}
		
		public ArrayList<Subject> getAls(){
			return abt.getAls();
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
	
	
	public addSubjtoP(Frame f,String s,boolean b) {
		super(f,s,b);
		
		allSubjects ss = new allSubjects();
		JScrollPane st = new JScrollPane(ss);
		
		setBounds(750, 180, 500, 600);
		JButton conf = new JButton();
		conf.setText("Confirm");
		conf.setBackground(Color.LIGHT_GRAY);
		conf.setPreferredSize(new Dimension(100,30));
		
		conf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(ss.getSelectedRow() == -1) return;
				Subject s = SubjectsBase.getInstance().findSubject(ss.getAls().get(ss.getSelectedRow()).getId());
				Professor stu = ProfessorsController.getInstance().findSelectedProfessor(ProfessorsTable.getInstance().getSelectedRow());
				stu.addSubj(s);
				s.setProfessor(stu);
				AbstractProfTable model = (AbstractProfTable) ProfTable.getInstance().getModel();
				model.fireTableDataChanged();
				EditProfessorsDialog.getInstance().validate();
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
				// TODO Auto-generated method stub
				setVisible(false);
			}
		});
		JPanel pan1 = new JPanel();
		pan1.add(st);
		JPanel pan = new JPanel();
		pan.add(conf);
		pan.add(canc);
		add(pan);
		add(pan1,BorderLayout.NORTH);
		setVisible(true);
	}
}
