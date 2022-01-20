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

import Model.Student;
import Model.Subject;
import Model.Subject.Semester_enum;
import controller.StudentsController;

public class addSubjecttoS extends JDialog{
	
	public class AbstractTableFailedSubjectsS extends AbstractTableModel {

		/**
		 * 
		 */
		
		private ArrayList<Subject> als = SubjectsBase.getInstance().unpassedSforStudent(StudentsController.getInstance().findSelcetedStudent(StudentTable.getInstance().getSelectedRow()));
		
		public ArrayList<Subject> getAls(){
			return als;
		}
		
		private static final long serialVersionUID = 1L;

		@Override
		public int getRowCount() {
			return SubjectsBase.getInstance().unpassedSforStudent(StudentsController.getInstance().findSelcetedStudent(StudentTable.getInstance().getSelectedRow())).size();
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
	
	public class FailedSubjectsTableS extends JTable {
		
		private AbstractTableFailedSubjectsS abt = new AbstractTableFailedSubjectsS();
		
		public FailedSubjectsTableS() {
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
	
	
	public addSubjecttoS(Frame f,String s,boolean b) {
		super(f,s,b);
		FailedSubjectsTableS fs = new FailedSubjectsTableS();
		JScrollPane st = new JScrollPane(fs);
		JPanel pan = new JPanel();
		pan.add(st);
		setBounds(750, 180, 500, 600);
		fs.getSelectedRow();
		JButton conf = new JButton();
		conf.setText("Confirm");
		conf.setBackground(Color.LIGHT_GRAY);
		conf.setPreferredSize(new Dimension(100,30));
		conf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(fs.getSelectedRow() == -1) return;
				Subject s = SubjectsBase.getInstance().findSubject(fs.getAls().get(fs.getSelectedRow()).getId());
				Student stu = StudentsController.getInstance().findSelcetedStudent(StudentTable.getInstance().getSelectedRow());
				stu.setUnpassed_subject(s);
				AbstractTableFailedSubjects model = (AbstractTableFailedSubjects) FailedSubjectsTable.getInstance().getModel();
				model.fireTableDataChanged();
				editStudentdialog.getInstance().validate();
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
		add(pan,BorderLayout.NORTH);
		JPanel pan2 = new JPanel();
		pan2.add(conf);
		pan2.add(canc);
		add(pan2);
		setVisible(true);
	}
	
	
	
}
