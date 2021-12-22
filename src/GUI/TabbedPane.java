package GUI;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import tables.StudentTable;

public class TabbedPane extends JTabbedPane {
	
	
	/**
	 * 
	 */
	public static TabbedPane instance = null;
	
	public static TabbedPane getInstance() {
		if(instance == null) 
			instance = new TabbedPane();
		return instance;
	}
	
	private static final long serialVersionUID = 7323271302275759031L;

	private TabbedPane() {
		
		super();
		
		TPchangeListener cL = new TPchangeListener();
		addChangeListener(cL);
		addTab("Students",new JScrollPane(StudentTable.getInstance()));
		addTab("Professors", null);
		addTab("Subjects", null);
		this.setBackground(new Color(255,255,255));
		
	
	}
	
	public static int getSelectedIdx() {
		return instance.getSelectedIndex();
	}
	
}
