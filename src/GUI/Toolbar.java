package GUI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import Listeners.ActionListener1;

public class Toolbar extends JToolBar {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6245645558350941598L;

	public Toolbar() {

		super(SwingConstants.HORIZONTAL);
		JButton btnNew = new JButton();
		btnNew.setToolTipText("New");
		btnNew.setIcon(new ImageIcon("images\\addentity.png"));
		btnNew.setBackground(Color.WHITE);
		btnNew.setBorderPainted(false);
		add(btnNew);
		btnNew.addActionListener(new ActionListener1());
		addSeparator();

		JButton btnEdit = new JButton();
		btnEdit.setToolTipText("Edit");
		btnEdit.setIcon(new ImageIcon("images\\edit2.png"));
		btnEdit.setBackground(Color.WHITE);
		btnEdit.setBorderPainted(false);
		add(btnEdit);

		addSeparator();
		
		JButton btnDelete = new JButton();
		btnDelete.setToolTipText("Delete");
		btnDelete.setIcon(new ImageIcon("images\\erase.png"));
		btnDelete.setBackground(Color.WHITE);
		btnDelete.setBorderPainted(false);
		add(btnDelete);
		
		add(Box.createHorizontalGlue());

		
		
		JTextField searchbar = new JTextField();
		searchbar.setPreferredSize( new Dimension(250, 30));
		searchbar.setMaximumSize(new Dimension(250,30));
		add(searchbar);
		
		JButton btnSearch = new JButton();
		btnSearch.setToolTipText("Search");
		btnSearch.setIcon(new ImageIcon("images\\search.png"));
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBorderPainted(false);
		add(btnSearch);
		
		
		setFloatable(false); //static toolbar
		setBackground(new Color(255, 255, 255));

	}

}
