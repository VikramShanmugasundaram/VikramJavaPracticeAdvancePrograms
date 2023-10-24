package sqliteDemo;

import java.sql.*;
import java.util.Scanner;

public class CRUDOperationUsingSQLite {

	public static void main(String[] args) throws Exception {
		
		Class.forName("org.sqlite.JDBC");
		Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\91978\\SQLite/vikramDBSQLite.db");
		Statement stmt= con.createStatement();//used for select operation
		ResultSet rs;//used to save the selected above stmt
		PreparedStatement st;//used for insert update delete operations
		
		String qry="";
		int id, age, choice;
		String name, city;
		
		Scanner in = new Scanner(System.in); 
		//sometime there'll be issue in getting int and string using same scanner
		Scanner str = new Scanner(System.in);
		
		while(true) {  //infinity loop and comes only when the user not providing the input
			System.out.println("SQLite Java CRUD Operation");
			System.out.println("1. Insert");
			System.out.println("2. Update");
			System.out.println("3. Delete");
			System.out.println("4. Select");
			System.out.println("5. Exit");
			System.out.println("Enter your choice: ");
			choice = in.nextInt();
			System.out.println("----------------------------------");
			
			switch(choice) {
			
			case 1:
				System.out.println("1. Insert new data");
				
				System.out.println("Enter Name");
				name=str.nextLine();
				System.out.println("Enter Age");
				age=in.nextInt();
				System.out.println("Enter City");
				city=str.nextLine();
				
				qry="insert into users (Name, Age, City) values (?,?,?)";
				st=con.prepareStatement(qry);
				st.setString(1, name);
				st.setInt(2, age);
				st.setString(3, city);
				st.executeUpdate();
				System.out.println("Data Insert Update");
				break;
			
			case 2:
				System.out.println("2. Updating a data");
				
				System.out.println("Enter Id");
				id=in.nextInt();
				System.out.println("Enter Name");
				name=str.nextLine();
				System.out.println("Enter Age");
				age=in.nextInt();
				System.out.println("Enter City");
				city=str.nextLine();
				
				qry="update users set Name=?, Age=?, City=? where Id=?";
				st=con.prepareStatement(qry);
				st.setString(1, name);
				st.setInt(2, age);
				st.setString(3, city);
				st.setInt(4, id);
				st.executeUpdate();
				System.out.println("Data update Success");
				break;
			
			case 3:
				System.out.println("3. Deleting a data");
				
				System.out.println("Enter the Id");
				id=in.nextInt();
				
				qry="delete from users where Id=?";
				st=con.prepareStatement(qry);
				st.setInt(1, id);
				st.executeUpdate();
				System.out.println("Data Delete Success");
				break;
			
			case 4:
				System.out.println("4. Print all records");
				//code to get the data from DB
				qry="Select Id, Name, Age, City from users";
				rs=stmt.executeQuery(qry);
				while(rs.next()) {
					id=rs.getInt("Id");//this will select the Id column
					name=rs.getString("Name");
					age=rs.getInt("Age");
					city=rs.getString("City");
					
					System.out.print(id+" ");
					System.out.print(name+" ");
					System.out.print(age+" ");
					System.out.println(city+" ");
				}
				break;
			
			case 5:
				System.out.println("Thank You!");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Selection");
				break;	
			}
			System.out.println("----------------------------------");
					}
		
		
	}

}
