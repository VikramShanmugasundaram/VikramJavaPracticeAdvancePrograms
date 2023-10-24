package sqliteDemo;

import java.sql.*;

public class dbPro {

	public static void main(String[] args) throws Exception {
		
			Class.forName("org.sqlite.JDBC");
			Connection con = DriverManager.getConnection("jdbc:sqlite:C:/Users/91978/SQLite/vikramDBSQLite.db");
			Statement stmt = con.createStatement();
			String qry = "Select Id, Name, Age, City from users";
			ResultSet rs = stmt.executeQuery(qry);
			//to assign the values into the java variables
			int id, age;
			String name, city;
			while(rs.next())
			{
				id=rs.getInt("Id");
				name=rs.getString("Name");
				age=rs.getInt("Age");
				city=rs.getString("City");
				
				System.out.print(id+" ");
				System.out.print(name+" ");
				System.out.print(age+" ");
				System.out.println(city+"");
			}
			stmt.close();
			con.close();
	}

}
