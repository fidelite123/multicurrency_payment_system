package Java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Payment {
	private String name;
	private int date;
	private int amount;
	private String receipt;
	private int user_id;
	private int transaction_id;
	public Payment() {}
	public Payment(String name, int date, int amount, String receipt, int user_id, int transaction_id) {
		super();
		this.name = name;
		this.date = date;
		this.amount = amount;
		this.receipt = receipt;
		this.user_id = user_id;
		this.transaction_id = transaction_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getReceipt() {
		return receipt;
	}
	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setuser_id(int user_id) {
		this.user_id = user_id; 
	}
	public int gettransaction_id() {
		return transaction_id;
	}
	public void settransaction_id(int transaction_id) {
		this.transaction_id = transaction_id; 
	}
		public void insertData() {
	        String host = "jdbc:mysql://localhost/benegusenga_mbabazi_fidelite_mps";
	        String user = "222003083";
	        String password = "";

	        String sql = "INSERT INTO payment ( payment_name, date, payment_amount, receipt, user_id, transaction_id ) VALUES (?, ?, ?, ?, ?, ?)";

	        try (Connection con = DriverManager.getConnection(host, user, password);
	                PreparedStatement preparedStatement = con.prepareStatement(sql);) {

	            preparedStatement.setString(1, this.name);
	            preparedStatement.setInt(2, this.date);
	            preparedStatement.setInt(3, this.amount);
	            preparedStatement.setString(4, this.receipt);
	            preparedStatement.setInt(5, this.user_id);
	            preparedStatement.setInt(6, this.transaction_id);

	            int rowsAffected = preparedStatement.executeUpdate();

	            if (rowsAffected > 0) {
	                System.out.println("Data inserted successfully!");
	                JOptionPane.showMessageDialog(null, "Data inserted successfully!", "After insert",
	                        JOptionPane.INFORMATION_MESSAGE);
	            } else {
	                System.out.println("Failed to insert data.");
	                JOptionPane.showMessageDialog(null, "Failed to insert data!", "After insert",
	                        JOptionPane.ERROR_MESSAGE);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    // Implement updateData(), deleteData(), and viewData() methods similarly to UserProfile class if needed

	public void updateData() {
	    String host = "jdbc:mysql://localhost/benegusenga_mbabazi_fidelite_mps";
	    String user = "222003083";
	    String password = "";

	    String sql = "UPDATE payment SET name=?, type=?, currency=?, balance=?, date=?, user_id=? WHERE ID=?";

	    try (Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);) {

	        preparedStatement.setString(1, this.name);
	        preparedStatement.setInt(2, this.date);
	        preparedStatement.setInt(3, this.amount);
	        preparedStatement.setString(4, this.receipt);
	        preparedStatement.setInt(5, this.user_id);
	        preparedStatement.setInt(6, this.transaction_id);
	        int rowsAffected = preparedStatement.executeUpdate();

	        if (rowsAffected > 0) {
	            System.out.println("Data updated successfully!");
	            JOptionPane.showMessageDialog(null, "Data updated successfully!", "After update",
	                    JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to update data.");
	            JOptionPane.showMessageDialog(null, "Failed to update data!", "After update",
	                    JOptionPane.ERROR_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public void deleteData() {
	    String host = "jdbc:mysql://localhost/benegusenga_mbabazi_fidelite_mps";
	    String user = "222003083";
	    String password = "";

	    String sql = "DELETE FROM payment WHERE ID=?";

	    try (Connection con = DriverManager.getConnection(host, user, password);
	            PreparedStatement preparedStatement = con.prepareStatement(sql);) {

	        preparedStatement.setString(1, this.name);
	        preparedStatement.setInt(2, this.date);
	        preparedStatement.setInt(3, this.amount);
	        preparedStatement.setString(4, this.receipt);
	        preparedStatement.setInt(5, this.user_id);
	        preparedStatement.setInt(6, this.transaction_id);
	        
	        int rowsAffected = preparedStatement.executeUpdate();

	        if (rowsAffected > 0) {
	            System.out.println("Data deleted successfully!");
	            JOptionPane.showMessageDialog(null, "Data deleted successfully!", "After delete",
	                    JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            System.out.println("Failed to delete data.");
	            JOptionPane.showMessageDialog(null, "Failed to delete data!", "After delete",
	                    JOptionPane.ERROR_MESSAGE);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public static ResultSet viewData() {
	    String host = "jdbc:mysql://localhost/benegusenga_mbabazi_fidelite_mps";
	    String user = "222003083";
	    String password = "";

	    String sql = "SELECT * FROM payment";

	    try {
	        Connection con = DriverManager.getConnection(host, user, password);
	        PreparedStatement preparedStatement = con.prepareStatement(sql);
	        return preparedStatement.executeQuery();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	

	}
	
	
	}
	