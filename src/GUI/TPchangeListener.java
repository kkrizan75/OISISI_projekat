package GUI;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TPchangeListener  implements ChangeListener {

	@Override
	public void stateChanged(ChangeEvent e) {
		if (e.getSource() instanceof TabbedPane) {
			TabbedPane p = (TabbedPane) e.getSource();
			if(p.getTitleAt(p.getSelectedIndex()).equals("Students")) {
				//StatusBar.updateCT();
			} else if(p.getTitleAt(p.getSelectedIndex()).equals("Professors")) {
				//StatusBar.updateCT();
			} else {
				//StatusBar.updateCT();
			}
		}
		
	}
	
}
