package MPP.Project1.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class BothView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BothView frame = new BothView("");
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
	public BothView(String name) {
		
		setBounds(100, 100, 450, 300);
		getContentPane().setBackground(new Color(250,250,210));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		
		//bookview = new AdminAddBook();
		//memberview = new AdminaddMember();
		
		JLabel lblNewLabel = new JLabel("Welcome "+ name);
		lblNewLabel.setBounds(57, 72, 367, 89);
		lblNewLabel.setFont(new Font("Baskerville",Font.PLAIN,40));
		getContentPane().add(lblNewLabel);
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate now = LocalDate.now();
		JLabel lblDte = new JLabel(dtf.format(now));
		lblDte.setFont(new Font("Baskerville",Font.PLAIN,15));
		lblDte.setBounds(350, 11, 79, 14);
		getContentPane().add(lblDte);
		
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Admin Function");
		menuBar.setBackground(new Color(240,230,140));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Add new Library member");
		mnNewMenu.add(mntmNewMenuItem);
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Add Copy Book");
		mnNewMenu.add(mntmNewMenuItem_1);
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Add Book");
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu2 = new JMenu("librarian Functions");
		menuBar.add(mnNewMenu2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Checkout a book ");
		mnNewMenu2.add(mntmNewMenuItem_3);
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Check Member Records");
		mnNewMenu2.add(mntmNewMenuItem_4);
		
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
		
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//AdminaddMember memberview = new AdminaddMember();
				//memberview.addMember();
				CheckOutBook checkOutBook = new CheckOutBook();
				checkOutBook.checkOut();
			}
		});
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LibrarianGetMemberCheckOut librec = new LibrarianGetMemberCheckOut();
				librec.MemberRecords();
			}
		});
		
		
	}
}

