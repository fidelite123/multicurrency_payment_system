
package Form;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Java.User;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;



public class UserForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nametext;
	private JTextField emailtext;
	private JTextField addresstext;
	private JTextField phone_numbertext;
	private JTextField gendertext;
	private JTextField user_currency;
	private JPasswordField passwordtext;
	private JComboBox gendertxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserForm frame = new UserForm();
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
	public UserForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 505);
		setTitle("REGISTRATION_FORM");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblname = new JLabel(" NAME :");
		lblname.setBounds(10, 25, 77, 23);
		contentPane.add(lblname);
		
		JLabel lblemail = new JLabel("EMAIL :" );
		lblemail.setBounds(10, 69, 77, 23);
		contentPane.add(lblemail );
		
		nametext = new JTextField();
		nametext.setBounds(97, 20, 180, 33);
		contentPane.add(nametext);
		nametext.setColumns(10);
		
		emailtext = new JTextField();
		emailtext.setBounds(97, 64, 180, 33);
		emailtext.setColumns(10);
		contentPane.add(emailtext);
		
		JLabel lbladdress = new JLabel("ADDRESS :");
		lbladdress.setBounds(10, 119, 77, 23);
		contentPane.add(lbladdress);
		
		addresstext = new JTextField();
		addresstext.setBounds(97, 112, 180, 33);
		addresstext.setColumns(10);
		contentPane.add(addresstext);
		
		JLabel lblPhone_number = new JLabel("PHONE_NUMBER :");
		lblPhone_number.setBounds(10, 170, 77, 23);
		contentPane.add(lblPhone_number);
		
		phone_numbertext = new JTextField();
		phone_numbertext.setBounds(97, 160, 180, 33);
		phone_numbertext.setColumns(10);
		contentPane.add(phone_numbertext);
		
		JLabel lblGender = new JLabel(" GENDER :");
		lblGender.setBounds(10, 210, 77, 23);
		contentPane.add(lblGender);
		
		JLabel lbluser_currency = new JLabel("USER_CURRENCY:" );
		lbluser_currency.setBounds(348, 30, 77, 23);
		contentPane.add(lbluser_currency);
		
		user_currency = new JTextField();
		user_currency.setBounds(425, 27, 180, 33);
		user_currency.setColumns(10);
		contentPane.add(user_currency);
		
		JLabel lblPhone_1_1 = new JLabel("Password :");
		lblPhone_1_1.setBounds(348, 183, 77, 23);
		contentPane.add(lblPhone_1_1);
		
		passwordtext = new JPasswordField();
		passwordtext.setBounds(423, 179, 182, 33);
		contentPane.add(passwordtext);
		
		JButton cancelButton= new JButton("CANCEL");
		cancelButton.setBounds(209, 285, 126, 33);
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nametext.setText(null);
				addresstext.setText(null);
				emailtext.setText(null);
				phone_numbertext.setText(null);
				user_currency.setText(null);
				gendertext.setText(null);
				passwordtext.setText(null);
				
			}});
		contentPane.add(cancelButton);
			
		JButton signUp = new JButton("SIGN UP");
		signUp.setBounds(380, 285, 132, 33);
		signUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User us = new User(); 
				if(e.getSource()==signUp) {
					us.setName(nametext.getText());
					us.setEmail(emailtext.getText());
					us.setAddress(addresstext.getText());
					us.setPhone_number(phone_numbertext.getText());
					us.setUser_currency(user_currency.getText());
					String selectedOption = gendertxt.getSelectedItem().toString();
					us.setGender(selectedOption);
					char[] passwordChars = passwordtext.getPassword();
					String passwordString = new String(passwordChars);
					us.setpassword(passwordString);
					us.insertData();
					System.out.print(us.getName() + " " + us.getEmail() + " " +us.getAddress()  + " " + us.getPhone_number() + " " + us.getGender()  + " " + us.getUser_currency()  + " " + us.getpassword() );
				}
			}
		});
		contentPane.add(signUp);
		String[] gender = {"Male", "Female"};
		gendertxt = new JComboBox(gender);
		gendertxt.setBounds(97, 210, 180, 23);
		contentPane.add(gendertxt);
	}

	public void setPassword(String text) {
		// TODO Auto-generated method stub
		
	}

	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	public void login() {
		// TODO Auto-generated method stub
		
	}
}
