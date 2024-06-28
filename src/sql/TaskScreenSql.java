package sql;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class TaskScreenSql extends Connect {
	
	
	
	public void addTask(String name, String description, String period) {
		try {
			System.out.println("[TaskScreenSql] Opening connection...");
			openConnection();
			
			System.out.println("[TaskScreenSql] Inserting task...");
			String sqlInsertTask = "INSERT INTO task (name, description, period)" + "VALUES (?, ?, ?)";
			
			System.out.println("[TaskScreenSql] Sending task to database...");
			
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
}
