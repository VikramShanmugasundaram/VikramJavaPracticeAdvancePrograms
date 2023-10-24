package awtCrud;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;

class myApp extends Frame implements ActionListener{
	//variables for frame
	Label lblTitle, lblId, lblName, lblCity, lblAge, lblStatus;
	TextField txtName, txtId, txtCity, txtAge;
	Button btnSave, btnClear, btnDelete;
	
	//variables for JDBC connection
	String qry="";
	Connection con = null;//for DB connection
	PreparedStatement st = null;//used for insert, update, delete
	ResultSet rs = null;//used to get the datas
	Statement stmt = null;//used for select query
	
	//Database Connection code
	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/vikramusermanagement";
			String username="root";
			String password="Vikram@5554";
			con=DriverManager.getConnection(url, username, password);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	//Clear form details
	public void clear() {
		txtId.setText("");
		txtName.setText("");
		txtAge.setText("");
		txtCity.setText("");
		txtName.requestFocus();//bringing back the cursor 
	}
	myApp(){
		
		super("User Management System");
		connect();//calling this method when the constructor is called
		setSize(1000,600);
		setLayout(null);
		setVisible(true);
		
		//background color creation
		Color formColor = new Color(53,59,72);
		this.setBackground(formColor);
		
		//Font creation
		Font titleFont = new Font("arial", Font.BOLD,25);
		Font labelFont = new Font("arial", Font.PLAIN,18);
		Font textFont = new Font("arial", Font.PLAIN,18);
		
		//title label
		lblTitle = new Label("User Management System");
		lblTitle.setBounds(250, 40, 400, 50);
		lblTitle.setFont(titleFont);
		lblTitle.setForeground(Color.YELLOW);
		add(lblTitle);
		
		//Id label and text field
		lblId = new Label("ID");
		lblId.setBounds(250, 100, 150, 30);
		lblId.setFont(labelFont);
		lblId.setForeground(Color.white);
		add(lblId);
		
		txtId = new TextField();
		txtId.setBounds(400, 100, 400, 30);
		txtId.setFont(textFont);
		txtId.addActionListener(this);//adding the action listener as once 
		//we provide the input some action has to perform
		add(txtId);
		
		//Name label and text field
		lblName = new Label("Name");
		lblName.setBounds(250, 150, 150, 30);
		lblName.setFont(labelFont);
		lblName.setForeground(Color.white);
		add(lblName);
		
		txtName = new TextField();
		txtName.setBounds(400, 150, 400, 30);
		txtName.setFont(textFont);
		add(txtName);
		
		//Age label and text field
		lblAge = new Label("Age");
		lblAge.setBounds(250, 200, 150, 30);
		lblAge.setFont(labelFont);
		lblAge.setForeground(Color.white);
		add(lblAge);
		
		txtAge = new TextField();
		txtAge.setBounds(400, 200, 400, 30);
		txtAge.setFont(textFont);
		add(txtAge);
		
		//City label and text field
		lblCity = new Label("City");
		lblCity.setBounds(250, 250, 150, 30);
		lblCity.setFont(labelFont);
		lblCity.setForeground(Color.white);
		add(lblCity);
		
		txtCity = new TextField();
		txtCity.setBounds(400, 250, 400, 30);
		txtCity.setFont(textFont);
		add(txtCity);
		
		//Save button
		btnSave= new Button("Save");
		btnSave.setBounds(400, 300, 100, 30);
		btnSave.setBackground(Color.blue);
		btnSave.setForeground(Color.white);
		btnSave.setFont(labelFont);
		btnSave.addActionListener(this);
		add(btnSave);
		
		//Clear button
		btnClear= new Button("Clear");
		btnClear.setBounds(520, 300, 100, 30);
		btnClear.setBackground(Color.orange);
		btnClear.setForeground(Color.white);
		btnClear.setFont(labelFont);
		btnClear.addActionListener(this);
		add(btnClear);
		
		//Delete button
		btnDelete= new Button("Delete");
		btnDelete.setBounds(640, 300, 100, 30);
		btnDelete.setBackground(Color.red);
		btnDelete.setForeground(Color.white);
		btnDelete.setFont(labelFont);
		btnDelete.addActionListener(this);
		add(btnDelete);
		
		//status label
		lblStatus = new Label("--------------");
		lblStatus.setBounds(400, 350, 300, 30);
		lblStatus.setFont(labelFont);
		lblStatus.setForeground(Color.white);
		add(lblStatus);
		
		
		//close button code
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//code for clear button
		try
		{	
			//fetching the text values from the objects
			String id=txtId.getText();
			String name=txtName.getText();
			String age=txtAge.getText();
			String city=txtCity.getText();
			
			//code to load the existing data
			if(e.getSource().equals(txtId)) {
				//get user details by Id
				qry="Select Id, Name, Age, City from users where Id="+txtId.getText();
				stmt=con.createStatement();
				rs=stmt.executeQuery(qry);
				if(rs.next()) { //it takes that particular row
					txtId.setText(rs.getString("Id"));
					txtName.setText(rs.getString("Name"));
					txtAge.setText(rs.getString("Age"));
					txtCity.setText(rs.getString("City"));
				}
				else {
					clear();
					lblStatus.setText("Invalid ID");
				}
			}
			
			//code for each buttons
			if(e.getSource().equals(btnClear)) { //this getSource() method will take the object's name and match
				clear();
			}
			else if(e.getSource().equals(btnSave)) {
				if(id.isEmpty()||id.equals("")) {
			
					//insert details save
					qry="insert into users (Name, Age, City) values(?,?,?)";
					st=con.prepareStatement(qry);
					st.setString(1, name);//1 for 1st qn mark
					st.setString(2, age);//2 for 2nd qn mark
					st.setString(3, city);//3 for 3rd qn mark
					st.executeUpdate();//executing the query
					clear();
					
					lblStatus.setText("Data Insert Success");
				}
				else {
					
					//update details save
					qry="update users set Name=?, Age=?, City=? where Id=?";
					st=con.prepareStatement(qry);
					st.setString(1, name);//1 for 1st qn mark
					st.setString(2, age);//2 for 2nd qn mark
					st.setString(3, city);//3 for 3rd qn mark
					st.setString(4, id);
					st.executeUpdate();//executing the query
					clear();
					lblStatus.setText("Data Update Success");
				}
				
			}
			else if(e.getSource().equals(btnDelete)) {
				
				//delete details
				if(!id.isEmpty()||!id.equals("")) {
					qry="delete from users where Id=?";
					st=con.prepareStatement(qry);
					st.setString(1, id);
					st.executeUpdate();
					clear();
					lblStatus.setText("Data Deleted Success");
				}
				else {
					lblStatus.setText("Please Enter the Correct ID");
				}
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
public class users {

	public static void main(String[] args) {
		myApp app = new myApp();
	}

}
