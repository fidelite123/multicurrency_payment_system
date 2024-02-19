package Form;

import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.awt.Component;
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

public class InvoiceForm implements ActionListener {
	DefaultTableModel model;
	JFrame frame;
	JLabel name_lb=new JLabel("NAME");
	JLabel amount_lb=new JLabel("AMOUNT");
	JLabel due_date_lb=new JLabel("DUE_DATE");
	JLabel account_id_lb=new JLabel("ACCOUNT_ID");
	JLabel transaction_id_lb=new JLabel("TRANSACTION_ID");
	
	JTextField name_txf=new JTextField();
	JTextField amount_txf=new JTextField();
	JTextField due_date_txf=new JTextField();
	JTextField account_id_txf=new JTextField();
	JTextField transaction_id_txf=new JTextField();
	
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	JButton update_btn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();
	public InvoiceForm() {
		createForm();
		 model = new DefaultTableModel();
		
	}
	private void createForm() {
		frame=new JFrame();
		frame.setTitle("                         Invoice Form            ");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		setLocationandSize();	
		
		
	}
	private void setLocationandSize() {
		
		name_lb.setBounds(10, 10, 150, 30);
		amount_lb.setBounds(10, 50, 150, 30);
		due_date_lb.setBounds(10, 90, 150, 30);
		account_id_lb.setBounds(10, 130, 150, 30);
		transaction_id_lb.setBounds(10, 170, 150, 30);
		name_txf.setBounds(160, 10, 200, 30);
		amount_txf.setBounds(160, 50, 200, 30);
		due_date_txf.setBounds(160, 90, 200, 30);
		account_id_txf.setBounds(160, 130, 200, 30);
		transaction_id_txf.setBounds(160, 170, 200, 30);
		insert_btn.setBounds(10,290, 100, 30);
		Read_btn.setBounds(100,290, 100, 30);
		update_btn.setBounds(190,290, 100, 30);
		delete_btn.setBounds(280,290, 100, 30);
		setFontforall();
		
	}
	private void setFontforall() {
		Font font=new Font("Times New Roman", Font.BOLD, 20);
		name_lb.setFont(font);
		amount_lb.setFont(font);
		due_date_lb.setFont(font);
		account_id_lb.setFont(font);
		transaction_id_lb.setFont(font);
		name_txf.setFont(font);
		amount_txf.setFont(font);
		due_date_txf.setFont(font);
		account_id_txf.setFont(font);
		transaction_id_txf.setFont(font);
		insert_btn.setFont(font);
		Read_btn.setFont(font);
		update_btn.setFont(font);
		delete_btn.setFont(font);
		addcomponentforFrame();
		
	}
	private void addcomponentforFrame() {
		
		frame.add(name_lb);
		frame.add(amount_lb);
		frame.add(due_date_lb);
		frame.add(account_id_lb);
		frame.add(transaction_id_lb);
		frame.add(name_txf);
		frame.add(amount_txf);
		frame.add(due_date_txf);
		frame.add(account_id_txf);
		frame.add(transaction_id_txf);
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
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
if(e.getSource() == insert_btn) {
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/benegusenga_mbabazi_fidelite_mps","222003083","");
				String sql="INSERT INTO invoice (invoice_name,invoice_amount,due_date,account_id,transaction_id) VALUES(?,?,?,?,?)";
				PreparedStatement stm=con.prepareStatement(sql);
				stm.setString(1,name_txf.getText());
				stm.setString(2,amount_txf.getText());
				stm.setString(3,due_date_txf.getText());
				stm.setString(4,account_id_txf.getText());
				stm.setString(5,transaction_id_txf.getText());
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

else if (e.getSource() == Read_btn) {
    // Perform action for view button here
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/benegusenga_mbabazi_fidelite_mps", "222003083",
                "");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM invoice");

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("invoice_name");
        model.addColumn("invoice_amount");
        model.addColumn("due_date");
        model.addColumn("account_id");
        model.addColumn("transaction_id");
        
        while (resultSet.next()) {
            Object[] row = new Object[5];
            row[1] = resultSet.getInt("invoice_name");
            row[2] = resultSet.getString("invoice_amount");
            row[3] = resultSet.getString("due_date");
            row[4] = resultSet.getInt("account_id");
            row[5] = resultSet.getInt("transaction_id");
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

else if (e.getSource() == delete_btn) {
try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/benegusenga_mbabazi_fidelite_mps", "222003083",
            "");
    String sql = "DELETE FROM invoice  WHERE invoice_id_id=?";
    int accountToDelete = Integer.parseInt(JOptionPane.showInputDialog("Enter account_id to delete:"));
    PreparedStatement pStatement = connection.prepareStatement(sql);

    pStatement.setInt(1, accountToDelete);
    pStatement.executeUpdate();
    JOptionPane.showMessageDialog(delete_btn, "Record deleted successfully!");
    pStatement.close();
    connection.close();
} catch (Exception e2) {
    System.out.println(e2.getMessage());
}
}
else if (e.getSource() == update_btn) {
try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/benegusenga_mbabazi_fidelite_mps", "222003083",
            "");
    String sql = "UPDATE books SET invoice_name=?, invoice_amount=?, due_date=?, account_id=?, transaction_id=? WHERE invoice_id=?";
    PreparedStatement stm = connection.prepareStatement(sql);

    stm.setString(1, name_txf.getText());
    stm.setString(2, amount_txf.getText());
    stm.setString(3, due_date_txf.getText());
    stm.setInt(4,Integer.parseInt(due_date_txf.getText()));
    stm.setInt(4,Integer.parseInt(account_id_txf.getText()));
    stm.setInt(4,Integer.parseInt(transaction_id_txf.getText()));
    stm.executeUpdate();
    JOptionPane.showMessageDialog(update_btn, "Data updated successfully!");
    stm.close();
    connection.close();
} catch (Exception e2) {
    System.out.println(e2.getMessage());
}}}
public static void main(String[] args) {
InvoiceForm IF = new InvoiceForm();
}
public void setVisible(boolean b) {
	// TODO Auto-generated method stub
	
}}


	
	