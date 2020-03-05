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

public class LibrarianView extends JFrame {

	private JPanel contentPane;
	private String name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibrarianView frame = new LibrarianView("");
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
	public LibrarianView(String name) {
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		getContentPane().setBackground(new Color(250,250,210));
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
		lblDte.setBounds(345, 0, 79, 14);
		getContentPane().add(lblDte);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(240,230,140));
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("librarian Functions");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Checkout a book ");
		mnNewMenu.add(mntmNewMenuItem);
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Check Member Records");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		mntmNewMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//AdminaddMember memberview = new AdminaddMember();
				//memberview.addMember();
				CheckOutBook checkOutBook = new CheckOutBook();
				checkOutBook.checkOut();
			}
		});
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				LibrarianGetMemberCheckOut librec = new LibrarianGetMemberCheckOut();
				librec.MemberRecords();
			}
		});
	}

	public void setName(String name) {
		this.name = name;
	}

}
