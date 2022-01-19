package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class Toolbar extends JToolBar {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6245645558350941598L;

	public Toolbar() {

		super(SwingConstants.HORIZONTAL);
		MyAbstractAction aNew = new MyAbstractAction("new");
		JButton btnNew = new JButton(aNew);
		btnNew.setToolTipText("New");
		btnNew.setIcon(new ImageIcon("images\\addentity.png"));
		btnNew.setBackground(Color.WHITE);
		btnNew.setBorderPainted(false);
		add(btnNew);
		btnNew.addActionListener(new ActionListener1());
		addSeparator();

		MyAbstractAction aEdit = new MyAbstractAction("edit");
		JButton btnEdit = new JButton(aEdit);
		btnEdit.setToolTipText("Edit");
		btnEdit.setIcon(new ImageIcon("images\\edit2.png"));
		btnEdit.setBackground(Color.WHITE);
		btnEdit.setBorderPainted(false);
		btnEdit.addActionListener(new EditActionListener());
		add(btnEdit);

		addSeparator();
		
		MyAbstractAction aDelete = new MyAbstractAction("delete");
		JButton btnDelete = new JButton(aDelete);
		btnDelete.setToolTipText("Delete");
		btnDelete.setIcon(new ImageIcon("images\\erase.png"));
		btnDelete.setBackground(Color.WHITE);
		btnDelete.setBorderPainted(false);
		btnDelete.addActionListener(new DeleteActionListener());
		add(btnDelete);
		
		add(Box.createHorizontalGlue());

		
		
		JTextField searchbar = new JTextField();
		searchbar.setPreferredSize( new Dimension(250, 30));
		searchbar.setMaximumSize(new Dimension(250,30));
		searchbar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ProfessorsTable.getInstance().searchProfessors(searchbar.getText());
			}
		});
		add(searchbar);
		
		JButton btnSearch = new JButton();
		btnSearch.setToolTipText("Search");
		btnSearch.setIcon(new ImageIcon("images\\search.png"));
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBorderPainted(false);
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (TabbedPane.getInstance().getSelectedIndex() == 1) {
					ProfessorsTable.getInstance().searchProfessors(searchbar.getText());
					}
				}
		});
		add(btnSearch);
		
		
		setFloatable(false); //static toolbar
		setBackground(new Color(255, 255, 255));

	}

}
