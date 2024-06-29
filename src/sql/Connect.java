package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
	private String url = "jdbc:mysql://localhost:3306/to_do_app";
	private String user = "root";
	private String password = "";
	private Connection connection;
	
	public void openConnection() {
		try {
			System.out.println("[Connect] Connecting... ");
			connection = DriverManager.getConnection(url, user, password);
			System.out.println("[Connect] Connected successfully!");

			
			} catch (SQLException e) {
			System.out.println("[Connect] Connection failed!");
			e.printStackTrace();
		}
	}
	
	public void closeConnection() {
        try {
                connection.close();
                System.out.println("[Connect] Connection closed.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public Connection getConnection() {
		return connection;
	}

}
