package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StatusBar extends JPanel {
	public StatusBar() {
		JLabel opentab = new JLabel("Current Tab");
		setLayout(new BorderLayout());
		JLabel StudentskaS = new JLabel("Studentska Služba - ");
		JPanel leftLabel = new JPanel();
	
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
		
		
		
	}
}
