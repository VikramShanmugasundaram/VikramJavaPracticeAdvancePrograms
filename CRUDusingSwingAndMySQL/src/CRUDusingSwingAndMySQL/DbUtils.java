package CRUDusingSwingAndMySQL;

import java.sql.*;
import java.util.*;
import javax.swing.table.*;

public class DbUtils {
	//code that returns the table model for the result set
	public static TableModel resultSetToTableModel(ResultSet rs) {
		// TODO Auto-generated method stub
			try {
				ResultSetMetaData metaData = rs.getMetaData();
				int numberOfColumns = metaData.getColumnCount();
				Vector columnNames = new Vector();
				
				//get the column names
				for(int column=0; column<numberOfColumns;column++) {
					columnNames.addElement(metaData.getColumnLabel(column+1));
				}
				//get all rows
				Vector rows = new Vector();
				while(rs.next()) {
					Vector newRow = new Vector();
					for(int i=1;i<=numberOfColumns;i++) {
						newRow.addElement(rs.getObject(i));
					}
					rows.addElement(newRow);
				}
				return new DefaultTableModel(rows, columnNames);
			}
			catch(Exception ex){
				ex.printStackTrace();
				return null;
			}
	}

}
