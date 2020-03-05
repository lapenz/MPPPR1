package MPP.Project1.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.sun.net.httpserver.Filter;

import MPP.Project1.controller.LendController;
import MPP.Project1.model.Lend;

public class LibrarianGetMemberCheckOut {

	private JFrame frame;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_1;
	private JLabel  lblNewLabel;
	private LendController lendCtr = new LendController();

	/**
	 * Launch the application.
	 */
	public void MemberRecords() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibrarianGetMemberCheckOut window = new LibrarianGetMemberCheckOut();
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
	public LibrarianGetMemberCheckOut() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 232, 160);
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
		
		
		for(int i =0 ;i<3;++i) {
			textFields.add(new JTextField());
			//textFields.get(i).setForeground(Color.white);
		}
		
		lblNewLabel = new JLabel("MemberID:");
		lblNewLabel.setBounds(34, 41, 68, 14);
		//lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel);
		
		
		textFields.get(0).setBounds(115, 38, 86, 20);
		frame.getContentPane().add(textFields.get(0));
		textFields.get(0).setColumns(10);
		
		
		lblNewLabel_6 = new JLabel("Check Out Record");
		lblNewLabel_6.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel_6.setOpaque(true);
		//lblNewLabel_6.setForeground(Color.white);
		lblNewLabel_6.setBackground(new Color(240,230,140));
		lblNewLabel_6.setFont(new Font("Courier New",Font.BOLD,20));
		lblNewLabel_6.setBounds(0, 0, 216, 25);
		frame.getContentPane().add(lblNewLabel_6);
		
		
		
		JButton btnNewButton_1 = new JButton("Print");
		btnNewButton_1.setBackground(new Color(240,230,140));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					List<Lend> lendlst = new ArrayList<>();
					lendlst.addAll(lendCtr.findAll());
					List<Lend> filterlst = new ArrayList<>();
					for(Lend l : lendlst) {
						if(l.getMember().getId()== Integer.parseInt(textFields.get(0).getText()))
							filterlst.add(l);
					}
					if(filterlst.size()==0)
						JOptionPane.showMessageDialog(null,"This Member does not have any check out record");
					else {
						CheckOutTable chtable = new CheckOutTable(null);
						chtable.checkOutRecord(filterlst);
					}
					
				}
				catch ( Exception e1)
				{
					System.out.println(e1);
					JOptionPane.showMessageDialog(null,e1.getMessage());
				}
			}
		});
		btnNewButton_1.setBounds(34, 88, 168, 23);
		frame.getContentPane().add(btnNewButton_1);
	}

}
