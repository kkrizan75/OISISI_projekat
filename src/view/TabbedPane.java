package view;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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
	
	public static class TPchangeListener  implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			if (e.getSource() instanceof TabbedPane) {
				TabbedPane p = (TabbedPane) e.getSource();
				if(p.getTitleAt(p.getSelectedIndex()).equals("Students")) {
					StatusBar.updateCT(0);
				} else if(p.getTitleAt(p.getSelectedIndex()).equals("Professors")) {
					StatusBar.updateCT(1);
				} else {
					StatusBar.updateCT(2);
				}
			}
			
		}
		
	}

	
	private static final long serialVersionUID = 7323271302275759031L;

	private TabbedPane() {
		
		super();
		
		TPchangeListener cL = new TPchangeListener();
		addChangeListener(cL);
		addTab("Students",new JScrollPane(StudentTable.getInstance()));
		addTab("Professors", new JScrollPane(ProfessorsTable.getInstance()));
		addTab("Subjects", null);
		this.setBackground(new Color(255,255,255));
		
	
	}
	
	public static int getSelectedIdx() {
		return instance.getSelectedIndex();
	}
	
}
