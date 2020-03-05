package MPP.Project1.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private AdminAddBook bookview;

	/**
	 * Launch the application.
	 */
	public void adminView() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminView window = new AdminView();
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
	public AdminView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		//bookview = new AdminAddBook();
		//memberview = new AdminaddMember();
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setBounds(118, 72, 219, 89);
		lblNewLabel.setFont(new Font("Courier New",Font.BOLD,50));
		frame.getContentPane().add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Admin Function");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Add new Library member");
		mnNewMenu.add(mntmNewMenuItem);
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Add Book");
		mnNewMenu.add(mntmNewMenuItem_1);
		
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
				AdminAddBook addbookview = new AdminAddBook();
				addbookview.adminAddBook();
			}
		});
		
		
	}
}
