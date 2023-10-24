package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javax.security.auth.callback.TextInputCallback;
import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class users {
	
	//Database connection initializing code
	Connection con=null;
	PreparedStatement pst;
	ResultSet rs;
	Statement st;
	
	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/vikramusermanagement";
			String username = "root";
			String password = "Vikram@5554";
			con = DriverManager.getConnection(url, username, password);
			
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	//to load the datas from DB, it should be return as a user list 
	public ObservableList<userModel> getUserList(){
		ObservableList<userModel> userlist = FXCollections.observableArrayList();
		String sql = "Select Id, Name, Age, City from users";
		try {
			st=con.createStatement();
			rs=st.executeQuery(sql);
			userModel user;
			while(rs.next()) {
				user = new userModel(rs.getInt("Id"), rs.getString("Name"), rs.getInt("Age"), rs.getString("City"));
				userlist.add(user);
			}
		}
		catch (Exception e) {
				e.printStackTrace();
		}
		return userlist;
	}
	
	//show user details:
	public void loadData() {
		ObservableList<userModel> list = getUserList();
		colId.setCellValueFactory(new PropertyValueFactory<userModel, Integer>("id"));
		colName.setCellValueFactory(new PropertyValueFactory<userModel, String>("name"));
		colAge.setCellValueFactory(new PropertyValueFactory<userModel, Integer>("age"));
		colCity.setCellValueFactory(new PropertyValueFactory<userModel, String>("city"));
		table.setItems(list);
	}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnUpdate;
    
    @FXML
    private TableView<userModel> table;
    
    @FXML
    private TableColumn<userModel, Integer> colAge;

    @FXML
    private TableColumn<userModel, String> colCity;

    @FXML
    private TableColumn<userModel, Integer> colId;

    @FXML
    private TableColumn<userModel, String> colName;

    @FXML
    private Label lblAge;

    @FXML
    private Label lblCity;

    @FXML
    private VBox lblId;

    @FXML
    private Label lblName;

    @FXML
    private TextField txtAge;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtName;

    @FXML
    void btnClearClicked(ActionEvent event) {
    	txtId.setText("");
    	txtName.setText("");
    	txtAge.setText("");
    	txtCity.setText("");
    }

    @FXML
    void btnDeleteClicked(ActionEvent event) {
    	//Delete details
    	String id=txtId.getText();
    	if(!txtId.getText().isEmpty()) {
    		int result = JOptionPane.showConfirmDialog(null, "Sure? DO you want to Delete?", "Delete", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
    		
    		if(result == JOptionPane.YES_OPTION) {
    			try {
    				String sql = "delete from users where Id=?";
    				pst=con.prepareStatement(sql);
    				pst.setString(1, id);
    				pst.executeUpdate();
    				JOptionPane.showMessageDialog(null, "Data Deleted Success");
    				btnClearClicked(event);
    				loadData();
    			}
    			catch (Exception e) {
					// TODO: handle exception
    				e.printStackTrace();
				}
    		}
    	}
    }

    @FXML
    void btnSaveClicked(ActionEvent event) {
    	//save details
    	String name = txtName.getText();
    	String age = txtAge.getText();
    	String city = txtCity.getText();
    	
    	if(name==null || name.isEmpty() || name.trim().isEmpty()) {
    		JOptionPane.showMessageDialog(null, "Please enter the Name");
    		txtName.requestFocus();
    		return;
    	}
    	if(age==null || age.isEmpty() || age.trim().isEmpty()) {
    		JOptionPane.showMessageDialog(null, "Please enter the Age");
    		txtAge.requestFocus();
    		return;
    	}
    	if(city==null || city.isEmpty() || city.trim().isEmpty()) {
    		JOptionPane.showMessageDialog(null, "Please enter the City");
    		txtCity.requestFocus();
    		return;
    	}
    	if(txtId.getText().isEmpty()) {
    		try {
    			String sql = "insert into users (Name, Age, City) values(?,?,?)";
    			pst=con.prepareStatement(sql);
    			pst.setString(1, name);
    			pst.setString(2, age);
    			pst.setString(3, city);
    			pst.executeUpdate();
    			JOptionPane.showMessageDialog(null, "Data Insert Success");
    			btnClearClicked(event);
    			loadData();
    		}
    		catch (Exception e) {
				// TODO: handle exception
    			e.printStackTrace();
			}
    	}
    }

    @FXML
    void btnUpdateClicked(ActionEvent event) {
    	//Update details
    	String id = txtId.getText();
    	String name = txtName.getText();
    	String age = txtAge.getText();
    	String city = txtCity.getText();
    	
    	if(name==null || name.isEmpty() || name.trim().isEmpty()) {
    		JOptionPane.showMessageDialog(null, "Please enter the Name");
    		txtName.requestFocus();
    		return;
    	}
    	if(age==null || age.isEmpty() || age.trim().isEmpty()) {
    		JOptionPane.showMessageDialog(null, "Please enter the Age");
    		txtAge.requestFocus();
    		return;
    	}
    	if(city==null || city.isEmpty() || city.trim().isEmpty()) {
    		JOptionPane.showMessageDialog(null, "Please enter the City");
    		txtCity.requestFocus();
    		return;
    	}
    	if(!txtId.getText().isEmpty()) {
    		try {
    			String sql = "update users set Name=?, Age=?, City=? where Id=?";
    			pst=con.prepareStatement(sql);
    			pst.setString(1, name);
    			pst.setString(2, age);
    			pst.setString(3, city);
    			pst.setString(4, id);
    			pst.executeUpdate();
    			JOptionPane.showMessageDialog(null, "Data Update Success");
    			btnClearClicked(event);
    			loadData();
    		}
    		catch (Exception e) {
				// TODO: handle exception
    			e.printStackTrace();
			}
    	}
    
    }

    @FXML
    void tableClicked(MouseEvent event) {
    	userModel user = table.getSelectionModel().getSelectedItem();
    	txtId.setText(String.valueOf(user.getId()));
    	txtName.setText(user.getName());
    	txtAge.setText(String.valueOf(user.getAge()));
    	txtCity.setText(user.getCity());
    	
    }

    @FXML
    void initialize() {
       connect();
       loadData();
    }

}
