package Java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
public class Account {
private String name;
private String type ;
private String currency;
private int balance;
private int date;
private int user_id;
public Account() {}
public Account(int id, String name, String type, String currency, int balance, int date, int user_id) {
	super();
	this.name = name;
	this.type = type;
	this.currency = currency;
	this.balance = balance;
	this.date = date;
	this.user_id = user_id;

}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getCurrency() {
	return currency;
}
public void setCurrency(String currency) {
	this.currency = currency;
}
public int getBalance() {
	return balance;
}
public void setBalance(int balance) {
	this.balance = balance;
}
public int getDate() {
	return date;
}
public void setDate(int date) {
	this.date = date;
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

        String sql = "INSERT INTO account ( account_name, account_type, currency, balance, date, user_id ) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DriverManager.getConnection(host, user, password);
                PreparedStatement preparedStatement = con.prepareStatement(sql);) {

            preparedStatement.setString(1, this.name);
            preparedStatement.setString(2, this.type);
            preparedStatement.setString(3, this.currency);
            preparedStatement.setInt(4, this.balance);
            preparedStatement.setInt(5, this.date);
            preparedStatement.setInt(6, this.user_id);

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
    String host = "jdbc:mysql://benegusenga_mbabazi_fidelite_mps";
    String user = "222003083";
    String password = "";

    String sql = "UPDATE account SET name=?, type=?, currency=?, balance=?, date=?, user_id=? WHERE ID=?";

    try (Connection con = DriverManager.getConnection(host, user, password);
            PreparedStatement preparedStatement = con.prepareStatement(sql);) {

        preparedStatement.setString(1, this.name);
        preparedStatement.setString(2, this.type);
        preparedStatement.setString(3, this.currency);
        preparedStatement.setInt(4, this.balance);
        preparedStatement.setInt(5, this.date);
        preparedStatement.setInt(6, this.user_id);
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

    String sql = "DELETE FROM account WHERE ID=?";

    try (Connection con = DriverManager.getConnection(host, user, password);
            PreparedStatement preparedStatement = con.prepareStatement(sql);) {

        preparedStatement.setString(1, this.name);
        preparedStatement.setString(2, this.type);
        preparedStatement.setString(3, this.currency);
        preparedStatement.setInt(4, this.balance);
        preparedStatement.setInt(5, this.date);
        preparedStatement.setInt(6, this.user_id);
        
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

    String sql = "SELECT * FROM account";

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

