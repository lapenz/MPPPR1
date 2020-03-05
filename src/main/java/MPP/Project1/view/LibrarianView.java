package MPP.Project1.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class LibrarianView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibrarianView frame = new LibrarianView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LibrarianView() {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		//bookview = new AdminAddBook();
		//memberview = new AdminaddMember();
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setBounds(118, 72, 219, 89);
		lblNewLabel.setFont(new Font("Courier New",Font.BOLD,50));
		getContentPane().add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("librarian Functions");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Checkout a book ");
		mnNewMenu.add(mntmNewMenuItem);
//		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Add Book");
//		mnNewMenu.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//AdminaddMember memberview = new AdminaddMember();
				//memberview.addMember();
			}
		});
//		mntmNewMenuItem_1.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
	}

}
