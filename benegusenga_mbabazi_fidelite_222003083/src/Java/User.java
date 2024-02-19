package Java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class User {
	private String name;
	private String email;
	private String address;
	private String phone_number;
	private String gender;
	private String user_currency;
	private String password;
	public User () {}
	public User(int id, String name, String email, String address, String phone_number, String gender,
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
        String host = "jdbc:mysql://localhost/ benegusenga_mbabazi_fidelite_mps";
        String user = "222003083";
        String password = "";
    }
    public void insertData() {
        String host = "jdbc:mysql://localhost/ benegusenga_mbabazi_fidelite_mps";
        String user = "222003083";
        String password = "";

        String sql = "INSERT INTO user (name, email, address,phone_number, gender, user_currency, password) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (
        		
            Connection con = DriverManager.getConnection(host, user, password);

            // Create a prepared statement
        		
            PreparedStatement stm= con.prepareStatement(sql);
        ) {
            // Set the values for the prepared statement
        	
            stm.setString(1, this.name);
            stm.setString(2, this.email);
            stm.setString(3, this.address);
            stm.setString(4, this.phone_number);
            stm.setString(5, this.gender);
            stm.setString(6, this.user_currency);
            stm.setString(7, this.password);

            // Execute the query
            int rowsAffected = stm.executeUpdate();

            // Check the result
            if (rowsAffected > 0) {
            	System.out.println("Data inserted successfully!");
                JOptionPane.showMessageDialog(null, "SinUp successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Failed to insert data.");
                JOptionPane.showMessageDialog(null, "Failed to SinUp.!","After insert",JOptionPane.ERROR_MESSAGE);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }	
    }
    
    public void login() {
    	makeconnection();
    	String host = "jdbc:mysql://localhost/ benegusenga_mbabazi_fidelite_mps";
        String user = "222003083";
        String password = "";
        String sql = "SELECT * FROM Admin WHERE email = ? AND password = ?";
        
    	try(
    			Connection con = DriverManager.getConnection(host, user, password);
            		
                PreparedStatement stm= con.prepareStatement(sql);
    			
    			) {
    		
    		stm.setString(1, this.email);
    		stm.setString(2, this.password);
    		ResultSet rs = stm.executeQuery();
    		if(rs.next()) {
    			System.out.println("Data inserted successfully!");
                JOptionPane.showMessageDialog(null, "Login successfully!","After login",JOptionPane.INFORMATION_MESSAGE);
    		} else {
    			
			JOptionPane.showMessageDialog(null, "Incorect Email and password!","After login",JOptionPane.INFORMATION_MESSAGE);
    		}
    		con.close();
    		
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

	
}
