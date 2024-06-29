package sql;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.mysql.cj.xdevapi.Result;

public class TaskScreenSql extends Connect {
	
	
	
	public void addTask(String name, String description, String period) {
		try {
			System.out.println("[TaskScreenSql] Opening connection...");
			openConnection();
			
			System.out.println("[TaskScreenSql] Insetinng task into database...");
			String sqlInsertTask = "INSERT INTO task (name, description, period)" + "VALUES (?, ?, ?)";
			

			PreparedStatement stmt = getConnection().prepareStatement(sqlInsertTask);
			stmt.setString(1, name);
			stmt.setString(2, description);
			stmt.setString(3, period);
			
			int sqlInsertTaskQuery = stmt.executeUpdate();
			
			if(sqlInsertTaskQuery > 0) {
				System.out.println("[TaskScreenSql] Task was inserted successfully!");
				JOptionPane.showMessageDialog(null, "Task was inserted successfully!");
			}
			
			System.out.println("[TaskScreenSql] Closing connection...");
			closeConnection();			
		} catch (SQLException e) {
			System.out.println("Something went wrong... " + e.getMessage());
		}
	}
//	
//	public void readTask() {
//		try {
//			openConnection();
//			System.out.println("[TaskScreenSql] Reading all tasks...");
//			
//			String readSql = "SELECT * FROM task";
//			Statement stmt = getConnection().createStatement();
//			
//			ResultSet rs = stmt.executeQuery(readSql);
//			
//			while(rs.next()) {
//				String name = rs.getString(1);
//				String description = rs.getString(2);
//				String period = rs.getString(3);
//				
//				System.out.println(name + " " + description + " " + period);
//			}
//			
//			
//		} catch (SQLException e) {
//			System.out.println("Something went wrong... " + e.getMessage());
//		}
//	}
}
