package Java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Transaction_Currency {
	private String code;
	private int exchange_rate;
	private int user_id;
	public Transaction_Currency() {}
	public Transaction_Currency(int id, String code, int exchange_rate, int user_id) {
		super();
		this.code = code;
		this.exchange_rate = exchange_rate;
		this.user_id = user_id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getExchange_rate() {
		return exchange_rate;
	}
	public void setExchange_rate(int exchange_rate) {
		this.exchange_rate = exchange_rate;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	

	public void insertData() {
        String host = "jdbc:mysql://localhost/benegusenga_mbabazi_fidelite_mps";
        String user = "222003083";
        String password = "";

        String sql = "INSERT INTO transaction_currency ( transaction_code, exchange_rate,user_id ) VALUES (?, ?, ?)";

        try (Connection con = DriverManager.getConnection(host, user, password);
                PreparedStatement preparedStatement = con.prepareStatement(sql);) {

            preparedStatement.setString(1, this.code);
            preparedStatement.setInt(2, this.exchange_rate);
            preparedStatement.setInt(3, this.user_id);
            

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

    String sql = "UPDATE transaction_currency SET code=?, exchange_rate=?, user_id=? WHERE ID=?";

    try (Connection con = DriverManager.getConnection(host, user, password);
            PreparedStatement preparedStatement = con.prepareStatement(sql);) {

        preparedStatement.setString(1, this.code);
        preparedStatement.setInt(2, this.exchange_rate);
        preparedStatement.setInt(3, this.user_id);
        
      
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

    String sql = "DELETE FROM transaction_currency WHERE ID=?";

    try (Connection con = DriverManager.getConnection(host, user, password);
            PreparedStatement preparedStatement = con.prepareStatement(sql);) {

        preparedStatement.setString(1, this.code);
        preparedStatement.setInt(2, this.exchange_rate);
        preparedStatement.setInt(3, this.user_id);
   
        
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

    String sql = "SELECT * FROM transaction_currency";

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

		
	
	


