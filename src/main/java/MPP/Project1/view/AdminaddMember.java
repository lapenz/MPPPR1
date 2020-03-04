package MPP.Project1.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.plaf.ColorChooserUI;

import org.postgresql.translation.messages_zh_TW;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class AdminaddMember {

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		frame.setBounds(100, 100, 267, 315);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		List<JTextField> textFields = new ArrayList<JTextField>();
		for(int i =0 ;i<6;++i)
			textFields.add(new JTextField());
		
		JLabel lblNewLabel = new JLabel("First Name:");
		lblNewLabel.setBounds(34, 41, 68, 14);
		//lblNewLabel.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(102, 38, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name:");
		lblNewLabel_1.setBounds(34, 75, 68, 14);
		//lblNewLabel_1.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(102, 72, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Street:");
		lblNewLabel_2.setBounds(34, 111, 68, 14);
		//lblNewLabel_2.setHorizontalAlignment(JLabel.);
		frame.getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(102, 108, 86, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("City:");
		lblNewLabel_3.setBounds(34, 142, 68, 14);
		//lblNewLabel_3.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(102, 139, 86, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		lblNewLabel_4 = new JLabel("zip:");
		lblNewLabel_4.setBounds(34, 172, 68, 14);
		//lblNewLabel_4.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(102, 169, 86, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		

		lblNewLabel_5 = new JLabel("Phone:");
		lblNewLabel_5.setBounds(34, 208, 46, 14);
		frame.getContentPane().add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(102, 205, 86, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		lblNewLabel_6 = new JLabel("AddMember");
		lblNewLabel_6.setHorizontalAlignment(JLabel.CENTER);
		lblNewLabel_6.setOpaque(true);
		lblNewLabel_6.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_6.setFont(new Font("Courier New",Font.BOLD,20));
		lblNewLabel_6.setBounds(0, 0, 251, 25);
		frame.getContentPane().add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnNewButton.setBounds(102, 246, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		
	}
}
