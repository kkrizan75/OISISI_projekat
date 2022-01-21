package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.event.RowSorterEvent;
import javax.swing.event.RowSorterListener;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

public class StudentTable extends JTable {
	private static StudentTable instance = null;
	public static JTable studTable;
	public static TableRowSorter<AbstractTableStudents> studentSort;
	public static AbstractTableStudents studAbstractTable;
	public static int rowSelectedIndex = -1;
	
	
	public static StudentTable getInstance() {
		if (instance == null) {
			instance = new StudentTable();
		}
		return instance;
	}
	
	public int getSelectedIndex() {
        return rowSelectedIndex;
    }
	
	public StudentTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableStudents());
		//this.setAutoCreateRowSorter(true);
		
		studAbstractTable = new AbstractTableStudents();
		studAbstractTable = (AbstractTableStudents)this.getModel();
		
		this.addMouseListener(new MouseAdapter () {
			@Override
			public void mouseReleased(MouseEvent e) {
				studTable = (JTable) e.getComponent();
				if(studTable.getSelectedRow() != -1) {
					rowSelectedIndex = studTable.convertRowIndexToModel(studTable.getSelectedRow());
				}
			}
			
			});
			
			studentSort =new TableRowSorter<AbstractTableStudents>(studAbstractTable);
			studentSort.setComparator(0, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {

	                String o1StringPart = o1.replaceAll("\\d", "");
	                String o2StringPart = o2.replaceAll("\\d", "");


	                if(o1StringPart.equalsIgnoreCase(o2StringPart))
	                {
	                    return extractInt(o1) - extractInt(o2);
	                }
	                return o1.compareTo(o2);
	            }

	            int extractInt(String s) {
	                String num = s.replaceAll("\\D", "");
	                return num.isEmpty() ? 0 : Integer.parseInt(num);
	            }
					
				
			});
			this.setRowSorter(studentSort);
			
			studentSort.setComparator(5, new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					Float int1 = Float.parseFloat(o1);
					Float int2 = Float.parseFloat(o2);
					return  int1.compareTo(int2);
				}
				
			});
			
		
	}
	
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		// selektovani red ce imati drugaciju boju od ostalih
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
	
	public void searchStudents(String search) {
		RowFilter<AbstractTableStudents, Object> rf = null;
		List<RowFilter<Object,Object>> rfs = 
	            new ArrayList<RowFilter<Object,Object>>();
		
		try {
		    String text = search;
		    String[] textArray = text.split("[, ]+");
		    
		    

		    for (int i = 0; i < textArray.length; i++) {
		        rfs.add(RowFilter.regexFilter("(?i)" + textArray[i], 0, 1, 2, 3));
		    }

		    rf = RowFilter.andFilter(rfs);

		} catch (java.util.regex.PatternSyntaxException e) {
		        return;
		}
		
		studentSort.setRowFilter(rf);
	}

}
