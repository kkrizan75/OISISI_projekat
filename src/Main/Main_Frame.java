package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main_Frame extends JFrame {
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
		}
}