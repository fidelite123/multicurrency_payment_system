package Form;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Transaction_CurrencyForm implements ActionListener {
	JFrame frame;
	JLabel code_lb=new JLabel("CODE");
	JLabel exchange_rate_lb=new JLabel("EXCHANGE_RATE");
	JLabel user_id_lb=new JLabel("USER_ID");
	
	JTextField code_txf=new JTextField();
	JTextField exchange_rate_txf=new JTextField();
	JTextField user_id_txf=new JTextField();
	
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	JButton update_btn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();
	public Transaction_CurrencyForm() {
		createForm();
	}	


	private void createForm() {
		frame=new JFrame();
		frame.setTitle("                         Transaction_Currency Form            ");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		setLocationandSize();	
		
		
	}
		
	private void setLocationandSize() {
		code_lb.setBounds(10, 10, 150, 30);
		exchange_rate_lb.setBounds(10, 50, 150, 30);
		user_id_lb.setBounds(10, 90, 150, 30);
		code_txf.setBounds(200, 10, 200, 30);
		exchange_rate_txf.setBounds(200, 50, 200, 30);
		user_id_txf.setBounds(200, 90, 200, 30);
		insert_btn.setBounds(10,290, 100, 30);
		Read_btn.setBounds(100,290, 100, 30);
		update_btn.setBounds(190,290, 100, 30);
		delete_btn.setBounds(280,290, 100, 30);
		setFontforall();
		
	}

	private void setFontforall() {
		Font font=new Font("Times New Roman", Font.BOLD, 20);
		code_lb.setFont(font);
		exchange_rate_lb.setFont(font);
		user_id_lb.setFont(font);
		code_txf.setFont(font);
		exchange_rate_txf.setFont(font);
		user_id_txf.setFont(font);
		insert_btn.setFont(font);
		Read_btn.setFont(font);
		update_btn.setFont(font);
		delete_btn.setFont(font);
		addcomponentforFrame();
		
		
	}
		
	private void addcomponentforFrame() {
		frame.add(code_lb);
		frame.add(exchange_rate_lb);
		frame.add(user_id_lb);
		frame.add(code_txf);
		frame.add(exchange_rate_txf);
		frame.add(user_id_txf);
		frame.add(insert_btn);
		frame.add(Read_btn);
		frame.add(update_btn);
		frame.add(delete_btn);
		ActionEvent();	
		
	}

	private void ActionEvent() {
		insert_btn.addActionListener(this);
		Read_btn.addActionListener(this);
		update_btn.addActionListener(this);
		delete_btn.addActionListener(this);	
	}

	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
if(e.getSource() == insert_btn) {
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/benegusenga_mbabazi_fidelite_mps","222003083","");
				String sql="INSERT INTO transaction_currency (transaction_code,exchange_rate,user_id) VALUES(?,?,?)";
				PreparedStatement stm=con.prepareStatement(sql);
				stm.setString(1,code_txf.getText());
				stm.setString(2,exchange_rate_txf.getText());
				stm.setString(3,user_id_txf.getText());
				int rowAffected = stm.executeUpdate();
				if(rowAffected > 0) {
				JOptionPane.showMessageDialog(insert_btn,  "insertion succeed!!!!!!!!");
				System.out.print("insertion succeed!!!!!!!!");
				} else {
					JOptionPane.showMessageDialog(null,"Fail to insert data","After insert",JOptionPane.ERROR_MESSAGE);
				}
				con.close();
				stm.close();
				
				
			}
			
			catch(SQLException e2)
			// TODO Auto-generated method stub
			{
				e2.printStackTrace();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
}
else if (e.getSource() == update_btn) {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/benegusenga_mbabazi_fidelite_mps", "222003083",
                "");
        String sql = "UPDATE transaction_currency SET transaction_code=?, exchange_rate=?, user_id=? WHERE transaction_currency_id=?";
        PreparedStatement stm = connection.prepareStatement(sql);

        stm.setString(1, code_txf.getText());
        stm.setInt(3, Integer.parseInt(exchange_rate_txf.getText()));
        stm.setInt(4, Integer.parseInt(user_id_txf.getText()));
 
        stm.executeUpdate();
        JOptionPane.showMessageDialog(update_btn, "Data updated successfully!");
        stm.close();
        connection.close();
    } catch (Exception e2) {
        System.out.println(e2.getMessage());
    }
} else if (e.getSource() == delete_btn) {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/benegusenga_mbabazi_fidelite_mps", "222003083",
                "");
        String sql = "DELETE FROM transaction_currency  WHERE transaction_id=?";
        int transactionidIdToDelete = Integer.parseInt(JOptionPane.showInputDialog("Enter transaction_id to delete:"));
        PreparedStatement pStatement = connection.prepareStatement(sql);

        pStatement.setInt(1, transactionidIdToDelete);
        pStatement.executeUpdate();
        JOptionPane.showMessageDialog(delete_btn, "Record deleted successfully!");
        pStatement.close();
        connection.close();
    } catch (Exception e2) {
        System.out.println(e2.getMessage());
    }
} else if (e.getSource() == Read_btn) {
    // Perform action for view button here
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/benegusenga_mbabazi_fidelite_mps", "222003083",
                "");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM transaction_currency");

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("transaction_code");
        model.addColumn("exchange_rate");
        model.addColumn("user_id");

        while (resultSet.next()) {
            Object[] row = new Object[4];
            row[0] = resultSet.getInt("transaction_code");
            row[1] = resultSet.getString("exchange_rate");
            row[2] = resultSet.getString("user_id");
            model.addRow(row);
        }

        JTable table = new JTable(model);
        JOptionPane.showMessageDialog(Read_btn, table);
        resultSet.close();
        statement.close();
        connection.close();
    } catch (Exception e2) {
        System.out.println(e2.getMessage());
    }
}
}

public static void main(String[] args) {
Transaction_CurrencyForm PF = new Transaction_CurrencyForm();
}}


	
		
	



	







