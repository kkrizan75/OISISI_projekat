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
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

import javax.swing.RowFilter;

public class ProfessorsTable extends JTable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ProfessorsTable instance = null;
	public static int rowSelectedIndex = -1;
	public static TableRowSorter<AbstractTableProfessors> profSort;
	public static JTable profTable;
	public static AbstractTableProfessors profAbstractTable;
	
	public static ProfessorsTable getInstance() {
		if (instance == null) {
			instance = new ProfessorsTable();
		}
		return instance;
	}
	
	public ProfessorsTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	
		this.setModel(new AbstractTableProfessors());
		profAbstractTable = new AbstractTableProfessors();
		profAbstractTable = (AbstractTableProfessors)this.getModel();
		
		this.addMouseListener(new MouseAdapter () {
		@Override
		public void mouseReleased(MouseEvent e) {
			profTable = (JTable) e.getComponent();
			if(profTable.getSelectedRow() != -1) {
				rowSelectedIndex = profTable.convertRowIndexToModel(profTable.getSelectedRow());
			}
		}
		
		});
		
		profSort =new TableRowSorter<AbstractTableProfessors>(profAbstractTable);
		this.setRowSorter(profSort);
		
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
	
	
	public void searchProfessors(String search) {
		RowFilter<AbstractTableProfessors, Object> rf = null;
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
		
		profSort.setRowFilter(rf);
	}

}
