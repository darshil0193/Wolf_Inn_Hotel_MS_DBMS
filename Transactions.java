import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class Transactions {
	static final String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/psinha";

	private static Connection connection = null;
	private static Statement statement = null;

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws SQLException {

		initialize();
		try {
			System.out.println("Checking in");
			connection.setAutoCommit(false);
//************ Auto Commit set to false before starting entire check-in process***********
			checkIn();
			connection.commit();
//************** If no SQLException, commit as all the inputs are valid****************

		} catch(SQLException e) {
			e.printStackTrace();
			connection.rollback();
//************** Roll back if any input is found to be invalid and throws an SQLException ***************
			System.out.println("Changes not saved due to invalid inputs");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			connection.setAutoCommit(true);
//*************** Finally set auto commit to true *******************
		}

		try {
			System.out.println("Checking out");
			connection.setAutoCommit(false);
//************ Auto Commit set to false before starting entire check-out process***********
			checkOut();
			connection.commit();
//************** If no SQLException, commit as all the inputs are valid****************
		} catch(SQLException e) {
			e.printStackTrace();
			connection.rollback();
//************** Roll back if any input is found to be invalid and throws an SQLException ***************
			System.out.println("Changes not saved due to invalid inputs");
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			connection.setAutoCommit(true);
//*************** Finally set auto commit to true *******************
		}

		close(statement);
		close(connection);

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

	private static void checkIn() throws IOException, SQLException{
//****** Starting the process of checking proper inputs expected from the user********
		System.out.println("Enter Customer Info");
		System.out.println("Enter SSN");
		int ssn = Integer.parseInt(br.readLine());
		System.out.println("Enter name");
		String name = br.readLine();
		System.out.println("Enter Date of Birth");
		String dob = br.readLine();
		System.out.println("Enter email address");
		String email = br.readLine();
		System.out.println("Enter phone number");
		String number = br.readLine();
// *********** Adding the new customer to customers table ***************
		statement.execute("INSERT INTO customers(ssn, name, dob, email, phone) VALUES('" + ssn + "', '" + name + "', '" + dob + "', '" + email + "', '" + number + "');");

		System.out.println("Enter Number of Guests");
		int number_of_guests = Integer.parseInt(br.readLine());
		System.out.println("Enter check in date & time");
		String check_in_datetime = br.readLine();
		System.out.println("Enter check in room number");
		String room_number = br.readLine();
		System.out.println("Enter staff id");
		String staff_id = br.readLine();

//********** Adding the new check-in to the check_in table ************
		statement.execute("INSERT INTO check_in(number_of_guests, check_in_date_time, check_out_date_time, room_number, ssn, staff_id) VALUES('" + number_of_guests + "', '" + check_in_datetime + "', NULL, '" + room_number + "', '" + ssn + "', '" + staff_id + "');");

		System.out.println("Enter hotel id");
		String hotel_id = br.readLine();
//******** Setting room availability to false *************
		statement.executeUpdate("UPDATE rooms SET availability = FALSE where room_number = " + room_number + " AND hotel_id = " + hotel_id + ";");

	}

	private static void checkOut() throws IOException, SQLException {
//******** Starting the process of checking out with proper inputs from the user *******
		System.out.println("Enter hotel id");
		String hotel_id = br.readLine();
		System.out.println("Enter room number");
		String room_number= br.readLine();
// ******* Setting room availability to true *********
		statement.executeUpdate("UPDATE rooms SET availability = TRUE WHERE room_number = " + room_number + " AND hotel_id = " + hotel_id + ";");

		System.out.println("Enter check-in id");
		String check_in_id= br.readLine();

		statement.execute("( select name, quantity * price as amount from check_in " +
				"INNER JOIN check_in_services ON check_in.check_in_id = check_in_services.check_in_id " +
				"INNER JOIN services ON services.service_id = check_in_services.service_id " +
				"where check_in.check_in_id = " + check_in_id + " ) " +
				"UNION " +
				"( select \"Room Amount\" as name, CEIL(TIMESTAMPDIFF( SECOND, check_in.check_in_date_time, check_in.check_out_date_time ) / 86400 ) * rooms.rate as amount from check_in, rooms, staff " +
				"where check_in.staff_id = staff.staff_id and rooms.room_number = check_in.room_number and staff.hotel_id = rooms.hotel_id and check_in.check_in_id = " + check_in_id + ") " +
				"UNION " +
				"( select \"Tax\", ( CASE WHEN ( select is_hotel_card from billing where billing.check_in_id = " + check_in_id + " ) = 0 THEN ROUND(SUM(A.amount)*0.135, 2) ELSE ROUND(SUM(A.amount) * 0.95 * 0.135, 2) END ) from ( ( select \"Room Amount\" as name, CEIL( TIMESTAMPDIFF(SECOND, check_in.check_in_date_time, check_in.check_out_date_time ) / 86400 ) * rooms.rate as amount from check_in, rooms, staff where check_in.staff_id = staff.staff_id and rooms.room_number = check_in.room_number and staff.hotel_id = rooms.hotel_id and check_in.check_in_id = " + check_in_id + ") " +
				"UNION " +
				"(select name, quantity * price as amount from check_in " +
				"INNER JOIN check_in_services ON check_in.check_in_id = check_in_services.check_in_id " +
				"INNER JOIN services ON services.service_id = check_in_services.service_id " +
				"Where check_in.check_in_id = " + check_in_id + ")) as A) " +
				"UNION " +
				"( select \"Total Amount Including Tax\", ( CASE WHEN ( select is_hotel_card from billing where billing.check_in_id = " + check_in_id + " ) = 0 THEN ROUND(SUM(B.amount)*1.135, 2) ELSE ROUND(SUM(B.amount) * 0.95 * 1.135, 2) END ) from ( ( select \"Room Amount\" as name, CEIL( TIMESTAMPDIFF(SECOND, check_in.check_in_date_time, check_in.check_out_date_time ) / 86400 ) * rooms.rate as amount from check_in, rooms, staff where check_in.staff_id = staff.staff_id and rooms.room_number = check_in.room_number and staff.hotel_id = rooms.hotel_id and check_in.check_in_id = " + check_in_id + ") " +
				"UNION (select name, quantity * price as amount from check_in " +
				"INNER JOIN check_in_services ON check_in.check_in_id = check_in_services.check_in_id " +
				"INNER JOIN services ON services.service_id = check_in_services.service_id " +
				"Where check_in.check_in_id = " + check_in_id + ")) as B);");
		System.out.println("Enter total charge");
		String total_charge = br.readLine();
		System.out.println("Enter card number");
		String card_number = br.readLine();
		System.out.println("Enter billing address");
		String billing_address = br.readLine();
		System.out.println("Hotel Card? [Y/N]");
		boolean is_hotel_card = false;
		String card = br.readLine();
		if(card.equalsIgnoreCase("y")) {
			is_hotel_card = true;
		}
// ************ Creating billing info for the customer who is checking out ***********
		statement.execute("INSERT INTO billing(total_charge, card_number, billing_address, is_hotel_card, check_in_id) VALUES ('" + total_charge + "', '" + card_number + "', '" + billing_address + "', " + is_hotel_card + ", '" + check_in_id + "');");

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

	//Closing the connection
	static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (Throwable whatever) {
				whatever.printStackTrace();
			}
		}
	}

	//Closing the statement
	static void close(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (Throwable whatever) {
				whatever.printStackTrace();
			}
		}
	}
}
