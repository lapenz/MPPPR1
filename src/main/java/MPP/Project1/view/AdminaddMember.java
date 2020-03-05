package MPP.Project1.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.plaf.ColorChooserUI;

import org.postgresql.translation.messages_zh_TW;

import MPP.Project1.controller.MemberController;
import MPP.Project1.model.Member;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class AdminaddMember extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblNewLabel_4;
	private JTextField textField_4;
	private JLabel lblNewLabel_5;
	private JTextField textField_5;
	private JLabel lblNewLabel_6;
	private static MemberController membCtr = new MemberController(); 

	/**
	 * Launch the application.
	 */
	public void adminAddMember() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminaddMember window = new AdminaddMember();
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
	public AdminaddMember() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 267, 370);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//frame.setBackground(Color.black);
		frame.getContentPane().setBackground(new Color(250,250,210));
		frame.setLocationRelativeTo(null);
		
		final List<JTextField> textFields = new ArrayList<JTextField>();
		for(int i =0 ;i<7;++i) {
			textFields.add(new JTextField());
			//textFields.get(i).setForeground(Color.white);
		}
		
		textFields.get(0);
		JLabel lblNewLabel = new JLabel("First Name:");
		lblNewLabel.setBounds(34, 41, 68, 14);
		//lblNewLabel.setForeground(Color.WHITE);
		//lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel);
		
		
		textFields.get(0).setBounds(102, 38, 86, 20);
		frame.getContentPane().add(textFields.get(0));
		textFields.get(0).setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name:");
		lblNewLabel_1.setBounds(34, 75, 68, 14);
		//lblNewLabel_1.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_1);
		
		textFields.get(1).setBounds(102, 72, 86, 20);
		frame.getContentPane().add(textFields.get(1));
		textFields.get(1).setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Street:");
		lblNewLabel_2.setBounds(34, 111, 68, 14);
		//lblNewLabel_2.setHorizontalAlignment(JLabel.);
		frame.getContentPane().add(lblNewLabel_2);
		
		
		textFields.get(2).setBounds(102, 108, 86, 20);
		frame.getContentPane().add(textFields.get(2));
		textFields.get(2).setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("City:");
		lblNewLabel_3.setBounds(34, 142, 68, 14);
		//lblNewLabel_3.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textFields.get(3).setBounds(102, 139, 86, 20);
		frame.getContentPane().add(textFields.get(3));
		textFields.get(3).setColumns(10);
		
		lblNewLabel_4 = new JLabel("State:");
		lblNewLabel_4.setBounds(34, 172, 68, 14);
		//lblNewLabel_4.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_4);
		
		
		textFields.get(4).setBounds(102, 169, 86, 20);
		frame.getContentPane().add(textFields.get(4));
		textFields.get(4).setColumns(10);
		

		lblNewLabel_5 = new JLabel("zip:");
		lblNewLabel_5.setBounds(34, 208, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textFields.get(5).setBounds(102, 205, 86, 20);
		frame.getContentPane().add(textFields.get(5));
		textFields.get(5).setColumns(10);
		
		JLabel lblPhone = new JLabel("phone:");
		lblPhone.setBounds(34, 247, 46, 14);
		frame.getContentPane().add(lblPhone);
		
		textFields.get(6).setBounds(102, 245, 86, 20);
		frame.getContentPane().add(textFields.get(6));
		textFields.get(6).setColumns(10);
		

		
		lblNewLabel_6 = new JLabel("Add Member");
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
				Member m = new Member(textFields.get(0).getText(),
						textFields.get(1).getText(),
						textFields.get(2).getText(),
						textFields.get(3).getText(),
						textFields.get(4).getText(),
						textFields.get(5).getText(),
						textFields.get(6).getText());
				membCtr.save(m);
				JOptionPane.showMessageDialog(null,"Member "+textFields.get(0).getText()+" Added");
				for(JTextField txtf : textFields) {
					txtf.setText("");
				}
			}
		});
		btnNewButton.setBounds(100, 285, 89, 23);
		frame.getContentPane().add(btnNewButton);

		
		
	}
}
