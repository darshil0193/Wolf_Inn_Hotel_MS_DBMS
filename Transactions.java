import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class Transactions {
	static final String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/psinha";
	
	private static Connection connection = null;
	private static Statement statement = null;
	private static ResultSet result = null;
	
	public static void main(String[] args) {

		initialize();

		
	}

	
	
	private static void initialize() {
		try {
			connectToDatabase();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void connectToDatabase() throws ClassNotFoundException, SQLException {
		Class.forName("org.mariadb.jdbc.Driver");

		String user = "psinha";
		String password = "200204393";
		try {
		connection = DriverManager.getConnection(jdbcURL, user, password);
		statement = connection.createStatement();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
