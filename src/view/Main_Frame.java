package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;

import controller.Write;

import javax.swing.JOptionPane;

public class Main_Frame extends JFrame {
	
	
	private static Main_Frame instance = null;
	
	public static Main_Frame getInstance() {
		if(instance == null) 
			instance = new Main_Frame();
		return instance;
	}
	
	private Main_Frame() {
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
		
		addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				
				int code = JOptionPane.showConfirmDialog(Main_Frame.getInstance(), "Are you sure?");
				if(code!=JOptionPane.YES_OPTION) {
					setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
				}else {
					setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
					try {
						Write.getInstance().Save();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		}
}