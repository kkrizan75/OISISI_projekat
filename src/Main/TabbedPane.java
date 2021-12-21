package Main;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTabbedPane;
import javax.swing.JTable;

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
		addTab("Studenti",null);
		addTab("Profesori", null);
		addTab("Predmeti", null);
		this.setBackground(new Color(255,255,255));
		
	
	}
	
	public int getSelectedIdx() {
		return instance.getSelectedIndex();
	}

}
