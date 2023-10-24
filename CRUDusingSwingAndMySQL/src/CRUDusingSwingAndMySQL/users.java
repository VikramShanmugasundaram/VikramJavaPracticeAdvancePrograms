package CRUDusingSwingAndMySQL;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class users {

	private JFrame frmCrudOperationSwing;
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtAge;
	private JTextField txtCity;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					users window = new users();
					window.frmCrudOperationSwing.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public users() {
		initialize();
		connect();//call the connection method while initating the constructor
		loadData();//to load the existing data from DB to frame
	}
	
	//Data base connection
	Connection con=null;
	PreparedStatement pst;
	ResultSet rs;
	
	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/vikramusermanagement";
			String username="root";
			String password="Vikram@5554";
			con=DriverManager.getConnection(url, username, password);
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	//clearing the data in the frame
	public void clear() {
		txtId.setText("");
		txtName.setText("");
		txtAge.setText("");
		txtCity.setText("");
		txtName.requestFocus();//get back the control to name field
	}
	//loading the table data into the frame
	public void loadData() {
		try {
		pst=con.prepareStatement("select * from users");
		rs=pst.executeQuery();
		table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCrudOperationSwing = new JFrame();
		frmCrudOperationSwing.setTitle("CRUD Operation Swing MySQL");
		frmCrudOperationSwing.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmCrudOperationSwing.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Management System");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 23, 261, 56);
		frmCrudOperationSwing.getContentPane().add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(4, 74, 388, 348);
		frmCrudOperationSwing.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 376, 327);
		panel_1.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(12, 67, 63, 33);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(12, 110, 63, 33);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Age");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(12, 162, 63, 33);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("City");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(12, 205, 63, 33);
		panel.add(lblNewLabel_1_3);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtId.setBounds(87, 67, 271, 33);
		panel.add(txtId);
		txtId.setColumns(10);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtName.setColumns(10);
		txtName.setBounds(87, 110, 271, 33);
		panel.add(txtName);
		
		txtAge = new JTextField();
		txtAge.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAge.setColumns(10);
		txtAge.setBounds(87, 162, 271, 33);
		panel.add(txtAge);
		
		txtCity = new JTextField();
		txtCity.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCity.setColumns(10);
		txtCity.setBounds(87, 205, 271, 33);
		panel.add(txtCity);
		//save button code to insert a new records
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtId.getText();
				String name = txtName.getText();
				String age = txtAge.getText();
				String city = txtCity.getText();
				
				//incase user hits save without any input details then its should throw the warning dialog 
				if(name==null || name.isEmpty() || name.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter Name");//for dialog box
					txtName.requestFocus();
					return;
				}
				if(age==null || age.isEmpty() || age.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter Age");//for dialog box
					txtAge.requestFocus();
					return;
				}
				
				if(city==null || city.isEmpty() || city.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter City");//for dialog box
					txtCity.requestFocus();
					return;
				}
				
				//if the Id is empty then need to add the new records
				if(txtId.getText().isEmpty()) {
					try {
						String qry="insert into users (Name, Age, City) values (?,?,?)";
						pst=con.prepareStatement(qry);
						pst.setString(1, name);
						pst.setString(2, age);
						pst.setString(3, city);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Data Insert Success");
						clear();
						loadData();
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
				}
				
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSave.setBounds(83, 261, 85, 21);
		panel.add(btnSave);
		
		//Update button code to update data for the particular id row
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String id = txtId.getText();
				String name = txtName.getText();
				String age = txtAge.getText();
				String city = txtCity.getText();
				
				//incase user hits save without any input details then its should throw the warning dialog 
				if(name==null || name.isEmpty() || name.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter Name");//for dialog box
					txtName.requestFocus();
					return;
				}
				if(age==null || age.isEmpty() || age.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter Age");//for dialog box
					txtAge.requestFocus();
					return;
				}
				
				if(city==null || city.isEmpty() || city.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Enter City");//for dialog box
					txtCity.requestFocus();
					return;
				}
				//when user provide the id to select then perform update
				if(!id.isEmpty()) {
					try {
						String qry = "update users set Name=?, Age=?, City=? where Id=?";
						pst=con.prepareStatement(qry);
						pst.setString(1, name);
						pst.setString(2, age);
						pst.setString(3, city);
						pst.setString(4, id);
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Data Update Success");
						clear();
						loadData();
						
					}
					catch(Exception ex){
						ex.printStackTrace();
					}
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnUpdate.setBounds(177, 263, 85, 21);
		panel.add(btnUpdate);
		//Delete the data from table for the id row
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Delete Details
				String id = txtId.getText();
				if(!txtId.getText().isEmpty()) {
					//getting confirmation to delete the data
					int result=JOptionPane.showConfirmDialog(null, "Sure? you want to Delete?", "Delete", 							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					if(result==JOptionPane.YES_OPTION) {
						try {
							String qry="delete from users where Id=?";
							pst=con.prepareStatement(qry);
							pst.setString(1, id);
							pst.executeUpdate();
							JOptionPane.showMessageDialog(null, "Data Deleted Success");
							clear();
							loadData();
						}
						catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.setBounds(273, 263, 85, 21);
		panel.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(423, 72, 458, 352);
		frmCrudOperationSwing.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			//this is the code to load the existing data of the row, the row we've clicked
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				TableModel model = table.getModel();
				//setting Id, name, age, city from table to the text field of selected row
				txtId.setText(model.getValueAt(index, 0).toString());
				txtName.setText(model.getValueAt(index, 1).toString());
				txtAge.setText(model.getValueAt(index, 2).toString());
				txtCity.setText(model.getValueAt(index, 3).toString());
				
			}
		});
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		frmCrudOperationSwing.setBounds(100, 100, 915, 684);
		frmCrudOperationSwing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
