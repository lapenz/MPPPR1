package MPP.Project1.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import MPP.Project1.controller.BookController;
import MPP.Project1.controller.CopyBookController;
import MPP.Project1.model.Book;
import MPP.Project1.model.CopyBook;

import javax.print.attribute.TextSyntax;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminAddCopyBook extends JFrame{

	private JFrame frame;
//	private JTextField textField;
//	private JTextField textField_1;
//	private JTextField textField_2;
//	private JTextField textField_3;
	private JLabel lblNewLabel_4;
	//private JTextField textField_4;
	private JLabel lblNewLabel_5;
	//private JTextField textField_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private static BookController Bookctr = new BookController();
	private static CopyBookController copyBook = new CopyBookController();
	private Book myBook;

	/**
	 * Launch the application.
	 */
	public void adminAddBook() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminAddCopyBook window = new AdminAddCopyBook();
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
	public AdminAddCopyBook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 232, 227);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(250,250,210));
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);
		final List<JTextField> textFields = new ArrayList<JTextField>();
		Bookctr = new BookController();
		
		/*JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(0, 0, 356, 26);
		frame.getContentPane().add(lblNewLabel_6);*/
		
		
		for(int i =0 ;i<6;++i) {
			textFields.add(new JTextField());
			//textFields.get(i).setForeground(Color.white);
		}
		
		JLabel lblNewLabel = new JLabel("Isbn:");
		lblNewLabel.setBounds(34, 41, 68, 14);
		//lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel);
		
		
		textFields.get(0).setBounds(115, 38, 86, 20);
		frame.getContentPane().add(textFields.get(0));
		textFields.get(0).setColumns(10);
		
		lblNewLabel_1 = new JLabel("Title:");
		lblNewLabel_1.setBounds(34, 75, 68, 14);
		//lblNewLabel_1.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_1);
		
		textFields.get(1).setBounds(115, 72, 86, 20);
		textFields.get(1).setEditable(false);
		frame.getContentPane().add(textFields.get(1));
		textFields.get(1).setColumns(10);
		
		lblNewLabel_2 = new JLabel("NumberOfCopyes:");
		lblNewLabel_2.setBounds(10, 111, 114, 14);
		//lblNewLabel_2.setHorizontalAlignment(JLabel.);
		frame.getContentPane().add(lblNewLabel_2);
		
		textFields.get(2).setBounds(115, 108, 86, 20);
		textFields.get(2).setEditable(false);
		frame.getContentPane().add(textFields.get(2));
		textFields.get(2).setColumns(10);
	
		
		
		lblNewLabel_6 = new JLabel("Add Copy Book");
		lblNewLabel_6.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel_6.setOpaque(true);
		//lblNewLabel_6.setForeground(Color.white);
		lblNewLabel_6.setBackground(new Color(240,230,140));
		lblNewLabel_6.setFont(new Font("Courier New",Font.BOLD,20));
		lblNewLabel_6.setBounds(0, 0, 216, 25);
		frame.getContentPane().add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.setBackground(new Color(240,230,140));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(myBook.getIsbn());
				if (myBook != null) {
					/*List<CopyBook> copyBooks = new ArrayList<>();
					copyBooks.addAll(myBook.getCopyBooks());
					copyBooks.add(new CopyBook());
					myBook.setCopyBooks(copyBooks);
					Bookctr.update(myBook);*/
					myBook.setOneCopy();
					Bookctr.update(myBook);
					textFields.get(2).setText(Integer.toString(myBook.getCopyBooks().size()));
				}
			}
		});
		btnNewButton.setBounds(10, 156, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Search");
		btnNewButton_1.setBackground(new Color(240,230,140));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					myBook= Bookctr.findFirst("isbn", textFields.get(0).getText());
					textFields.get(1).setText(myBook.getTitle());
					textFields.get(2).setText(Integer.toString(myBook.getCopyBooks().size()));
				}
				catch ( Exception e1)
				{
					
					JOptionPane.showMessageDialog (null,"isbn Not Found");
				}
			}
		});
		btnNewButton_1.setBounds(109, 156, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}

}
