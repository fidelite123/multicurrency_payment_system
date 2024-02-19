package Java;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Form.InvoiceForm;

public class Login {
	private String name;
	private String email;
	private String address;
	private String phone_number;
	private String gender;
	private String user_currency;
	private String password;
	public Login () {}
	public Login(int id, String name, String email, String address, String phone_number, String gender,
			String user_currency, String password) {
		super();
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone_number = phone_number;
		this.gender = gender;
		this.user_currency = user_currency;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getUser_currency() {
		return user_currency;
	}
	public void setUser_currency(String user_currency) {
		this.user_currency = user_currency;
	}
	public String getpassword() {
		return password;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	  public void makeconnection() {
	    	// JDBC URL, username, and password of MySQL server
	        String host = "jdbc:mysql://localhost/benegusenga_mbabazi_fidelite_mps";
	        String user = "222003083";
	        String password = "";
	    }   public void login() {
	    	makeconnection();
	    	String host = "jdbc:mysql://localhost/benegusenga_mbabazi_fidelite_mps";
	        String user = "222003083";
	        String password = "";
	        String sql = "SELECT * FROM user WHERE name = ? AND password = ?";
	        
	    	try(
	    			Connection con = DriverManager.getConnection(host, user, password);
            		
	                PreparedStatement stm= con.prepareStatement(sql);
	    			
	    			) {
	    		
	    		stm.setString(1, this.name);
	    		stm.setString(2, this.password);
	    		ResultSet rs = stm.executeQuery();
	    		if(rs.next()) {
	    			System.out.println("Loged in successfully!");
	                JOptionPane.showMessageDialog(null, "Loged in successfully!","After login",JOptionPane.INFORMATION_MESSAGE);
	    		} else {
	    			JOptionPane.showMessageDialog(null, "Incorect User name and password!","After login",JOptionPane.INFORMATION_MESSAGE);
	    		}
	    		con.close();
	    	} catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    	
	    }

	    		
	   
	