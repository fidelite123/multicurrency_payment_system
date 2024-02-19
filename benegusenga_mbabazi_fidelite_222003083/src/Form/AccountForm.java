package Form;

import java.awt.Color;
import java.awt.Color;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.management.modelmbean.ModelMBean;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.mysql.cj.x.protobuf.MysqlxCrud.DataModel;

public class AccountForm implements ActionListener{
	private static final DefaultTableModel model = null;
	private static final DefaultTableModel Model = null;
	JFrame frame;
	JLabel name_lb=new JLabel("NAME");
	JLabel type_lb=new JLabel("TYPE");
	JLabel currency_lb=new JLabel("CURRENCY");
	JLabel balance_lb=new JLabel("BALANCE");
	JLabel date_lb=new JLabel("DATE");
	JLabel user_id_lb=new JLabel("USER_ID");
	
	JTextField name_txf=new JTextField();
	JTextField type_txf=new JTextField();
	JTextField currency_txf=new JTextField();
	JTextField balance_txf=new JTextField();
	JTextField date_txf=new JTextField();
	JTextField user_id_txf=new JTextField();
	
	JButton insert_btn=new JButton("Insert");
	JButton Read_btn=new JButton("View");
	JButton update_btn=new JButton("Update");
	JButton delete_btn=new JButton("Delete");
	Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize();
	int w=(int) screensize.getWidth();
	int h=(int) screensize.getHeight();
	public AccountForm() {
		createForm();
	}

	private void createForm() {
		frame=new JFrame();
		frame.setTitle("                         ACCOUNT Form            ");
		frame.setBounds(0, 0, w/2, h/2);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		setLocationandSize();	
	}

	private void setLocationandSize() {
		
		name_lb.setBounds(10, 50, 150, 30);
		type_lb.setBounds(10, 90, 150, 30);
		currency_lb.setBounds(10, 130, 150, 30);
		balance_lb.setBounds(10, 170, 150, 30);
		date_lb.setBounds(10, 210, 150, 30);
		user_id_lb.setBounds(10, 250, 150, 30);
		name_txf.setBounds(160, 50, 200, 30);
		type_txf.setBounds(160, 90, 200, 30);
		currency_txf.setBounds(160, 130, 200, 30);
		balance_txf.setBounds(160,170 ,200 , 30);
		date_txf.setBounds(160,210 ,200 ,30 );
		user_id_txf.setBounds(160,250 ,200 ,30 );
		
		insert_btn.setBounds(10,290, 100, 30);
		Read_btn.setBounds(100,290, 100, 30);
		update_btn.setBounds(190,290, 100, 30);
		delete_btn.setBounds(280,290, 100, 30);
		setFontforall();	
		
	}

	private void setFontforall() {
		Font font=new Font("Times New Roman", Font.BOLD, 20);
		name_lb.setFont(font);
		type_lb.setFont(font);
		currency_lb.setFont(font);
		balance_lb.setFont(font);
		date_lb.setFont(font);
		user_id_lb.setFont(font);
		name_txf.setFont(font);
		type_txf.setFont(font);
		currency_txf.setFont(font);
		balance_txf.setFont(font);
		date_txf.setFont(font);
		user_id_txf.setFont(font);
		insert_btn.setFont(font);
		Read_btn.setFont(font);
		update_btn.setFont(font);
		delete_btn.setFont(font);
		addcomponentforFrame();
	}
		
	private void addcomponentforFrame() {
		frame.add(name_lb);
		frame.add(type_lb);
		frame.add(currency_lb);
		frame.add(balance_lb);
		frame.add(date_lb);
		frame.add(user_id_lb);
		frame.add(name_txf);
		frame.add(type_txf);
		frame.add(currency_txf);
		frame.add(balance_txf);
		frame.add(date_txf);
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



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == insert_btn) {
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/benegusenga_mbabazi_fidelite_mps","222003083","");
				String sql="INSERT INTO account (account_name,account_type,currency,balance,date,user_id) VALUES(?,?,?,?,?,?)";
				PreparedStatement stm=con.prepareStatement(sql);
				stm.setString(1,name_txf.getText());
				stm.setString(2,type_txf.getText());
				stm.setString(3,currency_txf.getText());
				stm.setString(4,balance_txf.getText());
				stm.setString(5,date_txf.getText());
				stm.setString(6, user_id_txf.getText());
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
                ResultSet resultSet = statement.executeQuery("SELECT * FROM account");

                DefaultTableModel model = new DefaultTableModel();
                model.setColumnCount(0);
                model.setRowCount(1);
                model.addColumn("account_name");
                model.addColumn("account_type");
                model.addColumn("currency");
                model.addColumn("date");
                model.addColumn("user_id");
                
                while (resultSet.next()) {
                    Object[] row = new Object[5];
                    row[1] = resultSet.getInt("account_name");
                    row[2] = resultSet.getString("account_type");
                    row[3] = resultSet.getString("currency");
                    row[4] = resultSet.getInt("date");
                    row[5] = resultSet.getInt("user_id");
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
            String sql = "DELETE FROM account  WHERE account_id=?";
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
            String sql = "UPDATE books SET account_name=?, account_type=?, currency=?, date=?, user_id=? WHERE account_id=?";
            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setString(1, name_txf.getText());
            stm.setString(2, type_txf.getText());
            stm.setString(3, currency_txf.getText());
            stm.setInt(4,Integer.parseInt(date_txf.getText()));
            stm.setInt(4,Integer.parseInt(user_id_txf.getText()));
            stm.executeUpdate();
            JOptionPane.showMessageDialog(update_btn, "Data updated successfully!");
            stm.close();
            connection.close();
        } catch (Exception e2) {
            System.out.println(e2.getMessage());
        }}}
    public static void main(String[] args) {
        AccountForm AF = new AccountForm();
    }}


			
			
		