package MPP.Project1.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import MPP.Project1.controller.BookController;
import MPP.Project1.model.Author;
import MPP.Project1.model.Book;
import MPP.Project1.model.Member;
import javax.swing.JTable;

public class AdminAddBook {

	private JFrame frame;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JTable table;
	private BookController bookCtr = new BookController();
	

	/**
	 * Launch the application.
	 */
	public void adminAddBook() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminAddBook window = new AdminAddBook();
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
	public AdminAddBook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 267, 489);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//frame.setBackground(Color.black);
		frame.getContentPane().setBackground(new Color(250,250,210));
		frame.setLocationRelativeTo(null);
		
		final List<JTextField> textFields = new ArrayList<JTextField>();
		for(int i =0 ;i<10;++i) {
			textFields.add(new JTextField());
			//textFields.get(i).setForeground(Color.white);
		}
		
		textFields.get(0);
		JLabel lblNewLabel = new JLabel("First Name:");
		lblNewLabel.setBounds(34, 51, 68, 14);
		//lblNewLabel.setForeground(Color.WHITE);
		//lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel);
		
		
		textFields.get(0).setBounds(102, 48, 86, 20);
		frame.getContentPane().add(textFields.get(0));
		textFields.get(0).setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name:");
		lblNewLabel_1.setBounds(34, 80, 68, 14);
		//lblNewLabel_1.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_1);
		
		textFields.get(1).setBounds(102, 77, 86, 20);
		frame.getContentPane().add(textFields.get(1));
		textFields.get(1).setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Street:");
		lblNewLabel_2.setBounds(34, 110, 68, 14);
		//lblNewLabel_2.setHorizontalAlignment(JLabel.);
		frame.getContentPane().add(lblNewLabel_2);
		
		
		textFields.get(2).setBounds(102, 113-7, 86, 20);
		frame.getContentPane().add(textFields.get(2));
		textFields.get(2).setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("City:");
		lblNewLabel_3.setBounds(34, 147-7, 68, 14);
		//lblNewLabel_3.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_3);
		
		textFields.get(3).setBounds(102, 144-7, 86, 20);
		frame.getContentPane().add(textFields.get(3));
		textFields.get(3).setColumns(10);
		
		lblNewLabel_4 = new JLabel("State:");
		lblNewLabel_4.setBounds(34, 177-7, 68, 14);
		//lblNewLabel_4.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_4);
		
		
		textFields.get(4).setBounds(102, 174-7, 86, 20);
		frame.getContentPane().add(textFields.get(4));
		textFields.get(4).setColumns(10);
		

		lblNewLabel_5 = new JLabel("zip:");
		lblNewLabel_5.setBounds(34, 213-7, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		textFields.get(5).setBounds(102, 210-7, 86, 20);
		frame.getContentPane().add(textFields.get(5));
		textFields.get(5).setColumns(10);
		
		JLabel lblPhone = new JLabel("phone:");
		lblPhone.setBounds(34, 252-7, 46, 14);
		frame.getContentPane().add(lblPhone);
		
		textFields.get(6).setBounds(102, 250-7, 86, 20);
		frame.getContentPane().add(textFields.get(6));
		textFields.get(6).setColumns(10);
		

		
		lblNewLabel_6 = new JLabel("Add Book");
		lblNewLabel_6.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel_6.setOpaque(true);
		//lblNewLabel_6.setForeground(Color.white);
		lblNewLabel_6.setBackground(new Color(240,230,140));
		lblNewLabel_6.setFont(new Font("Courier New",Font.BOLD,20));
		lblNewLabel_6.setBounds(0, 0, 251, 25);
		frame.getContentPane().add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBackground(new Color(240,230,140));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(JTextField txtf : textFields) {
					if(txtf.getText().equals("")) {
						JOptionPane.showMessageDialog(null,"you need to fill the mandatory");
						return;
					}
				}
				Book book = new Book();
				book.setTitle(textFields.get(7).getText());
				book.setIsbn(textFields.get(8).getText());
				int numberOfCopys = Integer.parseInt(textFields.get(9).getText());
				for(int i = 0;i<numberOfCopys;++i)
					book.setOneCopy();
				Author author = new Author(textFields.get(0).getText(),
						textFields.get(1).getText(),
						textFields.get(2).getText(),
						textFields.get(3).getText(),
						textFields.get(4).getText(),
						textFields.get(5).getText(),
						textFields.get(6).getText());
				book.setOneAuthor(author);
				bookCtr.save(book);
				//JOptionPane.showMessageDialog(null,"Member "+textFields.get(0).getText()+" Added");
				for(JTextField txtf : textFields) {
					txtf.setText("");
				}
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(138, 417, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_7 = new JLabel("Author Information:");
		lblNewLabel_7.setFont(new Font("Aileron",Font.PLAIN,17));
		lblNewLabel_7.setBounds(10, 22, 231, 25);
		frame.getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_7_1 = new JLabel("Book Information:");
		lblNewLabel_7_1.setFont(new Font("Dialog", Font.PLAIN, 17));
		lblNewLabel_7_1.setBounds(10, 282, 231, 25);
		frame.getContentPane().add(lblNewLabel_7_1);
		
		
		JLabel lblNewLabel_8 = new JLabel("Title:");
		lblNewLabel_8.setBounds(34, 318, 46, 14);
		frame.getContentPane().add(lblNewLabel_8);
		
		textFields.get(7).setBounds(102, 318, 86, 20);
		frame.getContentPane().add(textFields.get(7));
		textFields.get(7).setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Isbn:");
		lblNewLabel_9.setBounds(34, 347, 46, 14);
		frame.getContentPane().add(lblNewLabel_9);
		textFields.get(8).setBounds(102, 347, 86, 20);
		frame.getContentPane().add(textFields.get(8));
		textFields.get(8).setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Copy#");
		lblNewLabel_10.setBounds(34, 380, 46, 14);
		frame.getContentPane().add(lblNewLabel_10);
		
		textFields.get(9).setBounds(102, 380, 86, 20);
		frame.getContentPane().add(textFields.get(9));
		textFields.get(9).setColumns(10);
	}
}
