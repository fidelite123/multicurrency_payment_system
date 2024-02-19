package Java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Invoice {
	private String name;
	private int amount;
	private int due_date;
	private int account_id;
	private int transaction_id;
	public Invoice() {}
	public Invoice(String name, int amount, int due_date, int account_id, int transaction_id) {
		super();
		this.name = name;
		this.amount = amount;
		this.due_date = due_date;
		this.account_id = account_id;
		this.transaction_id = transaction_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getDue_date() {
		return due_date;
	}
	public void setDue_date(int due_date) {
		this.due_date = due_date;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	public void insertData() {
        String host = "jdbc:mysql://localhost/benegusenga_mbabazi_fidelite_mps";
        String user = "222003083";
        String password = "";

        String sql = "INSERT INTO invoice ( invoice_name, invoice_amount, due_date, account_id, transaction_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(host, user, password);
                PreparedStatement preparedStatement = con.prepareStatement(sql);) {

            preparedStatement.setString(1, this.name);
            preparedStatement.setInt(2, this.amount);
            preparedStatement.setInt(3, this.due_date);
            preparedStatement.setInt(4, this.account_id);
            preparedStatement.setInt(5, this.transaction_id);
          

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

    String sql = "UPDATE invoice SET name=?, amount=?, due_date=?, account_id=?, transaction_id=? WHERE ID=?";

    try (Connection con = DriverManager.getConnection(host, user, password);
            PreparedStatement preparedStatement = con.prepareStatement(sql);) {

        preparedStatement.setString(1, this.name);
        preparedStatement.setInt(2, this.amount);
        preparedStatement.setInt(3, this.due_date);
        preparedStatement.setInt(4, this.account_id);
        preparedStatement.setInt(5, this.transaction_id);
      
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

    String sql = "DELETE FROM invoice WHERE ID=?";

    try (Connection con = DriverManager.getConnection(host, user, password);
            PreparedStatement preparedStatement = con.prepareStatement(sql);) {

        preparedStatement.setString(1, this.name);
        preparedStatement.setInt(2, this.amount);
        preparedStatement.setInt(3, this.due_date);
        preparedStatement.setInt(4, this.account_id);
        preparedStatement.setInt(5, this.transaction_id);
       
        
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

    String sql = "SELECT * FROM invoice";

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



