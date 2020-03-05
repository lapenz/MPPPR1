package MPP.Project1.view;
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

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	private static ProjectUserController userCont = new ProjectUserController();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String UserType = "";
				try {
					if(!textField.getText().equals(""))
							UserType = userCont.login(textField.getText(),passwordField.getText().toString());
					
					if(UserType == null) {
						JOptionPane.showMessageDialog(null,"Incorrect UserName or Password");
					}
					
					else if (UserType.equals("1")) {
						AdminView AdView = new AdminView();
						AdView.adminView();
						frame.setVisible(false);
						
					}
					else if(UserType.equals("2")) {
						//library Page
						JOptionPane.showMessageDialog(null,"FuckLibraryn");
					}
					else if(UserType.equals("3")) {
						//both
					}
				}
				catch (Exception ex )
				{
					throw ex;
				}
				textField.setText("");
				passwordField.setText("");
				
			}
			
		});
		btnNewButton.setBounds(144, 116, 121, 23);
		frame.getContentPane().add(btnNewButton);
		

	}
}
