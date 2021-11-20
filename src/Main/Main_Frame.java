package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Main_Frame extends JFrame {
	public Main_Frame() {
		super();
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension dim = kit.getScreenSize();
		setSize(dim.width/2, dim.height/2);
		setLocationRelativeTo(null);
		//Image img = kit.getImage("images/iconaamong.png");
		//setIconImage(img);
		getContentPane().setBackground(Color.gray);
		setTitle("My first GUI App");
		setVisible(true);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBackground(Color.gray);
		}
}