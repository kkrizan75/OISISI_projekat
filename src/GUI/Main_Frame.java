package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

public class Main_Frame extends JFrame {
	
	
	public static Main_Frame instance = null;
	
	public static Main_Frame getInstance() {
		if(instance == null) 
			instance = new Main_Frame();
		return instance;
	}
	
	public Main_Frame() {
		super();
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension dim = kit.getScreenSize();
		setSize(3*dim.width/4, 3* dim.height/4);
		setLocationRelativeTo(null);
		//Image img = kit.getImage("images/iconaamong.png");
		//setIconImage(img);
		getContentPane().setBackground(Color.gray);
		setTitle("Studentska Služba");
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBackground(Color.gray);
		Menu_Bar menu = new Menu_Bar();
		this.setJMenuBar(menu);
		
		Toolbar tb = new Toolbar();
		StatusBar sb = new StatusBar();

		add(tb, BorderLayout.NORTH);
		add(sb, BorderLayout.SOUTH);
		
		
		JPanel defaultPanel = new JPanel();
		defaultPanel.setBackground(new Color(255,255,255));
		defaultPanel.setLayout(new BorderLayout());
		defaultPanel.add(TabbedPane.getInstance(),BorderLayout.CENTER);
		add(defaultPanel);
		
		
		
		}
}