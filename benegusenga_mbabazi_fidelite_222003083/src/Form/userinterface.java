package Form;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class userinterface {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userinterface window = new userinterface();
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
	public userinterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setBounds(100, 100, 711, 402);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ALL FORMS OF SYSTEM");
		lblNewLabel.setFont(new Font("Tahoma", Font.ITALIC, 25));
		lblNewLabel.setBounds(185, 38, 339, 31);
		frame.getContentPane().add(lblNewLabel);
		
		JButton empbtn = new JButton("account");
		empbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empbtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						AccountForm sup=new AccountForm();
						sup.frame.setVisible(true);
						frame.dispose();
					}
				});
			}
			
			
		});
		empbtn.setFont(new Font("Tahoma", Font.BOLD, 25));
		empbtn.setBounds(131, 94, 194, 39);
		frame.getContentPane().add(empbtn);
		
		JButton btnAttendance = new JButton("payment");
		empbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empbtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						InvoiceForm s=new InvoiceForm();
						s.frame.setVisible(true);
						frame.dispose();
					}
				});
			}
			
			
		});
		btnAttendance.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnAttendance.setBounds(382, 94, 214, 39);
		frame.getContentPane().add(btnAttendance);
		
		JButton btnHoliday = new JButton("Invoice");
		empbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empbtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						InvoiceForm hol=new InvoiceForm();
						hol.frame.setVisible(true);
						frame.dispose();
					}
				});
			}
			
			
		});
		btnHoliday.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnHoliday.setBounds(131, 161, 194, 39);
		frame.getContentPane().add(btnHoliday);
		
		JButton btnLeave = new JButton("transaction_currency");
		empbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				empbtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Transaction_CurrencyForm supe=new Transaction_CurrencyForm();
						supe.frame.setVisible(true);
						frame.dispose();
					}
				});
			}
			
			
		});
		btnLeave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLeave.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnLeave.setBounds(402, 161, 194, 39);
		frame.getContentPane().add(btnLeave);
		
		
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnBack.setBounds(586, 315, 101, 39);
		frame.getContentPane().add(btnBack);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	public void setEmail(String text) {
		// TODO Auto-generated method stub
		
	}

	public void setPassword(String passwordString) {
		// TODO Auto-generated method stub
		
	}

	public void login() {
		// TODO Auto-generated method stub
		
	}

}
