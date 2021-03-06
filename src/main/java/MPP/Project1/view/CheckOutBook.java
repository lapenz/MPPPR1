package MPP.Project1.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import MPP.Project1.controller.CopyBookController;
import MPP.Project1.controller.LendController;
import MPP.Project1.controller.MemberController;
import MPP.Project1.model.CopyBook;
import MPP.Project1.model.Member;

public class CheckOutBook {

	private JFrame frame;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_1;
	private JLabel  lblNewLabel;
	private static CopyBookController copyBookctr = new CopyBookController();
	private static MemberController memberCtr = new MemberController();
	private static LendController lendCtr = new LendController();
	private String isbn;
	private String Title;
	private CopyBook copybook;
	private Member myMember;

	/**
	 * Launch the application.
	 */
	public void checkOut() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckOutBook window = new CheckOutBook();
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
	public CheckOutBook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 232, 180);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setBackground(new Color(250,250,210));
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setFocusable(true);
		frame.toFront();
		frame.requestFocus();
		final List<JTextField> textFields = new ArrayList<JTextField>();
		//Bookctr = new BookController();
		
		/*JLabel lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setBounds(0, 0, 356, 26);
		frame.getContentPane().add(lblNewLabel_6);*/
		
		
		for(int i =0 ;i<6;++i) {
			textFields.add(new JTextField());
			//textFields.get(i).setForeground(Color.white);
		}
		
		lblNewLabel = new JLabel("Copy ID:");
		lblNewLabel.setBounds(34, 41, 68, 14);
		//lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel);
		
		
		textFields.get(0).setBounds(115, 38, 86, 20);
		frame.getContentPane().add(textFields.get(0));
		textFields.get(0).setColumns(10);
		
		lblNewLabel_1 = new JLabel("MemberID:");
		lblNewLabel_1.setBounds(34, 75, 68, 14);
		//lblNewLabel_1.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_1);
		
		textFields.get(1).setBounds(115, 72, 86, 20);
		frame.getContentPane().add(textFields.get(1));
		textFields.get(1).setColumns(10);
		
	
		
		textFields.get(0).addFocusListener( new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				//textFields.get(0).setText("Fucks");
				lblNewLabel.setText("Title:");
				if((copybook == null) || (copybook.getId() != Integer.parseInt(textFields.get(0).getText()))) {
					copybook = copyBookctr.find(Integer.parseInt(textFields.get(0).getText()));
					if(copybook==null)
						copybook=null;
				}
				if(copybook != null ) {
					textFields.get(0).setText(copybook.getBook().getTitle());
				}
				else {
					lblNewLabel.setText("CopyBook ID:");
					textFields.get(0).setText("");
					}
			}
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				//isbn = lblNewLabel.getText();
				lblNewLabel.setText("CopyBook ID:");
				if(copybook !=null)
					textFields.get(0).setText(String.valueOf(copybook.getId()));
				else textFields.get(0).setText("");
				
			}
		});
		
		textFields.get(1).addFocusListener( new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				//textFields.get(0).setText("Fucks");
				lblNewLabel_1.setText("Name:");
				if((myMember == null))
					myMember = memberCtr.find(Integer.parseInt(textFields.get(1).getText()));
				if(myMember != null ) {
					textFields.get(1).setText(myMember.getLast_name() +", " +myMember.getFirst_name());
				}
				else textFields.get(1).setText("");
				
			}
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				//isbn = lblNewLabel.getText();
				lblNewLabel_1.setText("MemberID:");
				if(myMember !=null)
					textFields.get(1).setText(Integer.toString(myMember.getId()));
				else {
					textFields.get(1).setText("");
					}
				
			}
		});
		
		
		lblNewLabel_6 = new JLabel("Check Out");
		lblNewLabel_6.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel_6.setOpaque(true);
		//lblNewLabel_6.setForeground(Color.white);
		lblNewLabel_6.setBackground(new Color(240,230,140));
		lblNewLabel_6.setFont(new Font("Courier New",Font.BOLD,20));
		lblNewLabel_6.setBounds(0, 0, 216, 25);
		frame.getContentPane().add(lblNewLabel_6);
		
		
		
		JButton btnNewButton_1 = new JButton("CheckOut");
		btnNewButton_1.setBackground(new Color(240,230,140));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						if(copybook==null)
							JOptionPane.showMessageDialog(null,"this book does not exist");
						else if(myMember==null)
							JOptionPane.showMessageDialog(null,"this member does not exist");
						else
						{
							lendCtr.checkout(myMember.getId(), copybook.getId());
							JOptionPane.showMessageDialog(null,"Check out saved ");
							frame.setVisible(false);
						}
						
				}
				catch ( Exception e1)
				{
					System.out.println(e1);
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
			}
		});
		btnNewButton_1.setBounds(107, 108, 94, 23);
		frame.getContentPane().add(btnNewButton_1);
	}

}
