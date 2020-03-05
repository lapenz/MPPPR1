package MPP.Project1.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.text.View;
import javax.swing.text.html.HTMLDocument.HTMLReader.BlockAction;

import junit.framework.Test;

import javax.swing.JLabel;

public class AdminView extends JFrame {

	private JFrame frame;
	private AdminaddMember memberview;
	private AdminAddCopyBook bookview;
	private String name;

	/**
	 * Launch the application.
	 */
	public void adminView(final String name) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminView window = new AdminView(name);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AdminView(String name ) {
		this.name = name;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.getContentPane().setBackground(new Color(250,250,210));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		
		//bookview = new AdminAddBook();
		//memberview = new AdminaddMember();
		
		JLabel lblNewLabel = new JLabel("Welcome "+ name);
		lblNewLabel.setBounds(57, 72, 367, 89);
		lblNewLabel.setFont(new Font("Baskerville",Font.PLAIN,40));
		frame.getContentPane().add(lblNewLabel);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate now = LocalDate.now();
		JLabel lblDte = new JLabel(dtf.format(now));
		lblDte.setFont(new Font("Baskerville",Font.PLAIN,15));
		lblDte.setBounds(345, 0, 79, 14);
		frame.getContentPane().add(lblDte);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Admin Function");
		menuBar.setBackground(new Color(240,230,140));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Add new Library member");
		mnNewMenu.add(mntmNewMenuItem);
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Add Copy Book");
		mnNewMenu.add(mntmNewMenuItem_1);
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Add Book");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		mntmNewMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AdminaddMember memberview = new AdminaddMember();
				memberview.adminAddMember();
			}
		});
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AdminAddCopyBook addbookview = new AdminAddCopyBook();
				addbookview.adminAddBook();
			}
		});
		
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AdminAddBook addbookview = new AdminAddBook();
				addbookview.adminAddBook();
			}
		});
		
		
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
