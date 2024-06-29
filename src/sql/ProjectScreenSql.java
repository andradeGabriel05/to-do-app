package sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class ProjectScreenSql extends Connect {
	public void addProject(String name, String description) {

		try {
			System.out.println("[ProjectScreenSql] Opening connection...");
			openConnection();

			System.out.println("[ProjectScreenSql] Inserting project into database...");
			String insertProjectSql = "INSERT INTO project (name, description)" + "VALUES (?, ?)";

			PreparedStatement stmt = getConnection().prepareStatement(insertProjectSql);

			stmt.setString(1, name);
			stmt.setString(2, description);

			int sqlInsertProjectQuery = stmt.executeUpdate();

			if (sqlInsertProjectQuery > 0) {
				System.out.println("[ProjectScreenSql] Project was inserted successfully!");
				JOptionPane.showMessageDialog(null, "Project was inserted successfully!");
			}
			
			System.out.println("[ProjectScreenSql] Closing connection...");
			closeConnection();
			
		} catch (SQLException e) {
			System.out.println("Something went wrong... " + e.getMessage());
		}
	}
}
