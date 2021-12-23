package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBar extends JPanel {
	
	private static JPanel leftLabel;
	private static JLabel opentab = new JLabel("Current Tab");
	
	private static StatusBar instance = null;
	
	public static StatusBar getInstance() {
		if(instance == null) 
			instance = new StatusBar();
		return instance;
	}
	
	public StatusBar() {
		
		setLayout(new BorderLayout());
		JLabel StudentskaS = new JLabel("Studentska Služba - ");
		leftLabel = new JPanel();
	
		leftLabel.add(StudentskaS);
		leftLabel.add(opentab);
		add(leftLabel,BorderLayout.WEST);
		JLabel timel = new JLabel();
		JLabel dateLabel = new JLabel();
		TimerThread timerThread = new TimerThread(dateLabel, timel);
        timerThread.start();
        
        add(Box.createHorizontalGlue());
		JPanel rightLabel = new JPanel();
		
		rightLabel.add(timel);
		rightLabel.add(dateLabel);
		add(rightLabel,BorderLayout.EAST);
		
		setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0, Color.black));
		setBackground(new Color(230,230,230));
		updateCT(0);
	}
	
	public static void updateCT(int i) {
		String str;
		if(i == 0) str = "Students";
		else if(i == 1) str = "Professors";
		else str = "Subjects";
		setCurrentTab(str);
	}
	
	public static void setCurrentTab(String s) {
		leftLabel.remove(opentab);
		opentab = new JLabel(s);
		leftLabel.add(opentab);	
	}

}
