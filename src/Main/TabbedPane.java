package Main;

import java.awt.Color;

import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class TabbedPane extends JTabbedPane {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7323271302275759031L;

	TabbedPane() {
		
		super();
		addTab("Studenti",null);
		addTab("Profesori", null);
		addTab("Predmeti", null);
		this.setBackground(new Color(255,255,255));
		
		
	}

}
