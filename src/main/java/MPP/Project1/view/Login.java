package MPP.Project1.view;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JTextField;

import MPP.Project1.controller.ProjectUserController;
import MPP.Project1.model.ProjectUser;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private static ProjectUserController userCont = new ProjectUserController();



	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 363, 220);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(250,250,210));
		frame.getContentPane().setLayout(null);
		//frame.setFocusable(true);
		frame.getContentPane().setFocusable(true);
		frame.setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("UserName:");
		lblNewLabel.setBounds(64, 63, 70, 14);
		frame.getContentPane().add(lblNewLabel);
		//UserName
		textField = new JTextField();
		textField.setBounds(144, 60, 121, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(64, 88, 70, 14);
		frame.getContentPane().add(lblNewLabel_1);
		//Password
		passwordField = new JPasswordField();
		passwordField.setBounds(144, 85, 121, 20);
		frame.getContentPane().add(passwordField);
		
		
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(new Color(240,230,140));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				String UserType = "";
				try {
					if(!textField.getText().equals(""))
							UserType = userCont.login(textField.getText(),passwordField.getText().toString());
					
					if(UserType == null) {
						JOptionPane.showMessageDialog(null,"Incorrect UserName or Password");
					}
					
					else if (UserType.equals("1")) {
						AdminView AdView = new AdminView(name);
						AdView.adminView(name);
						frame.setVisible(false);
						
					}
					else if(UserType.equals("2")) {
						//library Page
						LibrarianView lib = new LibrarianView(name);
						lib.setVisible(true);
						frame.setVisible(false);
					}
					else if(UserType.equals("3")) {
						//both
						BothView bv = new BothView(name);
						bv.setVisible(true);
						frame.setVisible(false);
					}
				}
				catch (Exception ex )
				{
					JOptionPane.showMessageDialog(null,"Incorrect UserName or Password");
				}
				textField.setText("");
				passwordField.setText("");
				
			}
			
		});
		btnNewButton.setBounds(144, 116, 121, 23);
		frame.getContentPane().add(btnNewButton);
		

	}
}
