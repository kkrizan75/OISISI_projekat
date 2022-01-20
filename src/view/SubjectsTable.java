package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Comparator;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;
import java.util.List;
import java.util.ArrayList;

public class SubjectsTable extends JTable{


	/**
	 * 
	 */
	private static final long serialVersionUID = -6769874681843326035L;
	private static SubjectsTable instance = null;
	public static JTable subjectsTable;
	public static int rowSelectedIndex = -1;
	public static TableRowSorter<AbstractTableSubjects> subjSort;
	public static JTable subjTable;
	public static AbstractTableSubjects subjAbstractTable;
	
	public static SubjectsTable getInstance() {
		if (instance == null) {
			instance = new SubjectsTable();
		}
		return instance;
	}
	
	public SubjectsTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableSubjects());
		this.getTableHeader().setReorderingAllowed(false);;
		subjAbstractTable = new AbstractTableSubjects();
		subjAbstractTable = (AbstractTableSubjects)this.getModel();
		
		this.addMouseListener(new MouseAdapter () {
			@Override
			public void mouseReleased(MouseEvent e) {
				subjTable = (JTable) e.getComponent();
				if(subjTable.getSelectedRow() != -1) {
					rowSelectedIndex = subjTable.convertRowIndexToModel(subjTable.getSelectedRow());
				}
			}
			
		});
		
		subjSort = new TableRowSorter<AbstractTableSubjects>(subjAbstractTable);
		subjSort.setComparator(0, new Comparator<String>() {

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
		
		subjSort.setComparator(2, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				Integer int1 = Integer.parseInt(o1);
				Integer int2 = Integer.parseInt(o2);
				return  int1.compareTo(int2);
			}
			
		});
		this.setRowSorter(subjSort);
		
	}
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
	
	
	public int getSelectedIndex() {
		return rowSelectedIndex;
	}
	
	public void searchSubjects(String search) {
		RowFilter<AbstractTableSubjects, Object> rf = null;
		List<RowFilter<Object,Object>> rfs = 
	            new ArrayList<RowFilter<Object,Object>>();
		
		try {
		    String text = search;
		    String[] textArray = text.split("[, ]+");
		    
		    

		    for (int i = 0; i < textArray.length; i++) {
		        rfs.add(RowFilter.regexFilter("(?i)" + textArray[i], 0, 1, 2, 3, 4));
		    }

		    rf = RowFilter.andFilter(rfs);

		} catch (java.util.regex.PatternSyntaxException e) {
		        return;
		}
		
		subjSort.setRowFilter(rf);
	}
}