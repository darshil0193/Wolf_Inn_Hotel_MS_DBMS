import java.sql.*;

public class TasksAndOperations {
	
	static final String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/psinha";
	
	public static void main(String[] args) {
        try {

            // Load the driver. This creates an instance of the driver
            // and calls the registerDriver method to make MariaDB Thin
            // driver, available to clients.

            Class.forName("org.mariadb.jdbc.Driver");

            String user = "psinha";
            String passwd = "200204393";

            Connection conn = null;
            Statement stmt = null;
            ResultSet rs = null;

            try {
                // Get a connection from the first driver in the
                // DriverManager list that recognizes the URL jdbcURL

                conn = DriverManager.getConnection(jdbcURL, user, passwd);

                // Create a statement object that will be sending your
                // SQL statements to the DBMS

                stmt = conn.createStatement();

                // Tasks and Operations Methods to be implemented.
                
                // 1. Hotel
                // a. Enter Hotel Information
                // EnterHotelInformation(stmt, name, phone_number, hotel_address);
                
                // b. Update Hotel Information
                // UpdateHotelInformation(stmt, hotel_id, parameter, value);
                
                // c. Delete Hotel Information
                // DeleteHotelInformation(stmt, hotel_id);
                
                // 2. Rooms
                // a. Enter Room Information
                // EnterRoomInformation(stmt, room_number, category, rate, availability, max_occupancy, hotel_id);
                
                // b. Update Room Information
                // UpdateRoomInformation(stmt, hotel_id, room_number, parameter, value);
                
                // c. Delete Room Information
                // DeleteRoomInformation(stmt, hotel_id, room_number);
                
                // 3. Staff
                // a. Enter Staff Information
                // EnterStaffInformation(stmt, staff_address, age, phone_number, job_title, hotel_id, name);
                
                // b. Update Staff Information
                // UpdateStaffInformation(stmt, staff_id, parameter, value);
                
                // c. Delete Staff Information
                // DeleteStaffInformation(stmt, staff_id);
                
                // 4. Customers
                // a. Enter customer Information
                // EnterCustomerInformation(stmt, ssn, name, dob, email, phone)
                
                // b. Update customer Information
                // UpdateCustomerInformation(stmt, parameter, value, ssn); 
                
                // c. Delete customer Information
                // DeleteCustomerInformation(stmt, ssn);
                
                // 5. Availability of Room
                // a. Room availability
                // ResultSet allAvailableRooms = AvailableRooms(availability = true);
                
                // b. Room Type availability
                // ResultSet AvailableRoomsForRoomType = AvailableRoomsRoomType(availability = true, category);
                
                // c. Assign Room
                	// i. Create Check in
                	// CreateCheckin(stmt, number_of_guests, check_in_date_time, check_out_date_time, room_number, ssn, staff_id);
                
                	// ii. Change availability of room to be FALSE
                	// ReserveRoom(stmt, room_number, hotel_id);
                
                // d. Release room
                	// i. Update check out date time
                	// UpdateCheckin(stmt, check_in_id, check_out_date_time);
                
                	// ii. Create bill
                	// CreateBill(stmt, total_charge, card_number, billing_address, is_hotel_card, check_in_id);
                
                	// iii. Update room availability to TRUE
                	// ReleaseRoom(stmt, room_number, hotel_id);
                
                // 6. Maintaining Service Records
                // a. Enter service
                // InsertServiceForCheckin(stmt, staff_id, check_in_id, service_id);
                
                // b. Update service
                // UpdateService(stmt, parameter, value, service_id);
                
                // 7. Maintaining billing accounts
                // a. Create billing account
                // CreateBillingEntry(stmt, total_charge, card_number, billing_address, is_hotel_card, check_in_id);
                
                // b. Paid using hotel card
                // BillPaidUsingHotelCard(stmt, total_charge, card_number, billing_address, is_hotel_card, check_in_id);
                
                // c. Paid using other card
                // BillPaidUsingCard(stmt, total_charge, card_number, billing_address, is_hotel_card, check_in_id);
                
                // d. Paid using cash
                // BillPaidUsingCash(stmt, total_charge, card_number, billing_address, is_hotel_card, check_in_id);
                
                // e. Retrieve bill amount
                // ResultSet BillAmount =  RetriveBillAmount(stmt, check_in_id);
                
                // 8. Reports
                // a. Report occupancy by hotel
                // ResultSet OccupancyByHotel =  ReportOccupancyByHotel(stmt);
                
                // b. Report occupancy by room type
                // ResultSet OccupancyByRoomType =  ReportOccupancyByRoomType(stmt);
                
                // c. Report occupancy by date range (grouped by hotel)
                // ResultSet OccupancyByDateRangeGroupedByHotel =  ReportOccupancyByDateRangeGroupedByHotel(stmt, to, from);
                
                // d. Report occupancy by date range
                // ResultSet OccupancyByDateRange =  ReportOccupancyByDateRange(stmt, to, from);
                
                // e. Report occupancy by city
                // ResultSet OccupancyByCity =  ReportOccupancyByCity(stmt);
                
                // f. Report total occupancy
                // ResultSet TotalOccupancy =  ReportTotalOccupancy(stmt);
                
                // g. Report percentage of room occupied
                // ResultSet PercentageOfRoomOccupied =  ReportPercentageOfRoomOccupied(stmt);
                
                // h. Information on staff grouped by their role
                // ResultSet InfoOnServingStaff = ReportInfoOnServingStaff(stmt);
                
                // i. Staff members serving a particular customer
                // ResultSet StaffServingCustomer = ReportStaffServingCustomer(stmt, ssn)
                
                // j. Revenue generated by hotels
                // ResultSet RevenueByHotels = ReportRevenueByHotels(stmt);
                
                // k. Create Itemized Bill Receipt
                // ResultSet ItemizedBill = CreateItemizedBill(stmt, check_in_id);
                
                
               
            } finally {
                close(rs);
                close(stmt);
                close(conn);
            }

        } catch(Throwable oops) {
            oops.printStackTrace();
        }
    }

	static void EnterHotelInformation(Statement stmt, String name, String phone_number, String hotel_address) throws SQLException{
		
		System.out.println("Adding a New Hotel");
		stmt.execute("INSERT INTO hotels(name, phone_number, hotel_address) VALUES(" + name + ", " + phone_number + ", " + hotel_address + ");");	
	}
	
	static void UpdateHotelInformation(Statement stmt, String hotel_id, String parameter, String value) throws SQLException{
		
		System.out.println("Updating Hotel information with Hotel ID :" + hotel_id);
		stmt.executeUpdate("UPDATE hotels SET " + parameter + " = " + value + " where hotel_id = " + hotel_id + ";");
	}
	
	static void DeleteHotelInformation(Statement stmt, String hotel_id) throws SQLException {
		
		System.out.println("Deleting Hotel Information with Hotel ID: " + hotel_id);
		stmt.execute("DELETE from hotels WHERE hotel_id=" + hotel_id + ";");
	}
	
	static void EnterRoomInformation(Statement stmt, String room_number, String category, int rate, boolean availability, String max_occupancy, String hotel_id) throws SQLException{
		
		System.out.println("Adding a new Room to Hotel ID:" + hotel_id);
		stmt.execute("INSERT INTO rooms(room_number, category, rate, availability, max_occupancy, hotel_id) VALUES(" + room_number + "," + category + ", " + rate + ", " + availability + ", " + max_occupancy + ", " + hotel_id + ");");
	}
	
	static void UpdateRoomInformation(Statement stmt, String hotel_id, String room_number,String parameter,String value) throws SQLException{

		System.out.println("Updating Room Information for Hotel ID: " + hotel_id + " and Room number" + room_number);
		stmt.executeUpdate("UPDATE rooms SET " + parameter + " = " + value + " where room_number = " + room_number + " AND hotel_id = " + hotel_id + ";");
	}

	static void DeleteRoomInformation(Statement stmt, String hotel_id, String room_number) throws SQLException{

		System.out.println("Deleting Room Information for Hotel ID: " + hotel_id + " and Room Number: " + room_number);
		stmt.execute("DELETE from rooms WHERE room_number=" + room_number + " AND hotel_id=" + hotel_id + ";");
	}

	static void EnterStaffInformation(Statement stmt, String staff_address, String age, String phone_number, String job_title, String hotel_id, String name) throws SQLException{

		System.out.println("Adding new Staff Information");
		stmt.execute("INSERT INTO staff(staff_address, age, phone_number, job_title, hotel_id, name) VALUES(" + staff_address + ", " + age + ", " + phone_number + ", " + job_title + ", " + hotel_id + ",  " + name + ");");
	}

	static void UpdateStaffInformation(Statement stmt, String staff_id, String parameter, String value) throws SQLException{

		System.out.println("Updating Staff Information for Staff ID: " + staff_id);
		stmt.executeUpdate("UPDATE staff SET " + parameter + " = " + value + " where staff_id = " + staff_id + ";");
	}

	static void DeleteStaffInformation(Statement stmt, String staff_id) throws SQLException{

		System.out.println("Deleting Staff Information for Staff ID: " + staff_id);
		stmt.execute("DELETE from staff WHERE staff_id=" + staff_id);
	}

	static void EnterCustomerInformation(Statement stmt, int ssn, String name, String dob, String email, String phone) throws SQLException{

		System.out.println("Adding new Customer Information");
		stmt.execute("INSERT INTO customers(ssn, name, dob, email, phone) VALUES(" + ssn + ", " + name + ", " + dob + ", " + email + ", " + phone + ");");
	}

	static void UpdateCustomerInformation(Statement stmt, String parameter, String value, String ssn) throws SQLException{

		System.out.println("Updating Customer Information for SSN: " + ssn);
		stmt.executeUpdate("UPDATE customers SET " + parameter + " = " + value + " WHERE ssn = " + ssn + ";");
	}

	static void DeleteCustomerInformation(Statement stmt, String ssn) throws SQLException{

		System.out.println("Deleting Customer Information for SSN: " + ssn);
		stmt.execute("DELETE from customers WHERE ssn = " + ssn + ";");
	}

	static ResultSet AvailableRooms(Statement stmt, boolean availability) throws SQLException{

		System.out.println("Checking available rooms");
		ResultSet rs = stmt.executeQuery("SELECT room_number, hotel_id FROM rooms where availability = " + availability + ";");
		return rs;
	}

	static ResultSet AvailableRoomsRoomType(Statement stmt, boolean availability, String category) throws SQLException{

		System.out.println("Checking all available rooms for category: " + category);
		ResultSet rs = stmt.executeQuery("SELECT room_number, hotel_id FROM rooms where availability = " + availability + " AND category=" + category + ";");
		return rs;
	}

	static void CreateCheckin(Statement stmt, int number_of_guests, String check_in_date_time, String check_out_date_time, String room_number, String ssn, String staff_id) throws SQLException{

		System.out.println("Creating a new Checking");
		stmt.execute("INSERT INTO check_in(number_of_guests, check_in_date_time, check_out_date_time, room_number, ssn, staff_id) VALUES(" + number_of_guests + ", " + check_in_date_time + ", NULL, " + room_number + ", " + ssn + ", " + staff_id + ");");
	}

	static void ReserveRoom(Statement stmt, String room_number, String hotel_id) throws SQLException{

		System.out.println("Reserving Room Number: " + room_number + " for Hotel ID: " + hotel_id);
		stmt.executeUpdate("UPDATE rooms SET availability = FALSE where room_number = " + room_number + " AND hotel_id = " + hotel_id + ";");
	}

	static void UpdateCheckin(Statement stmt, String check_in_id, String check_out_date_time) throws SQLException{

		System.out.println("Updating Check-In to indicate that customer has checked-out");
		stmt.executeUpdate("UPDATE check_in SET check_out_date_time = " + check_out_date_time + " where check_in_id = " + check_in_id + ";");
	}

	static void CreateBill(Statement stmt, String total_charge, String card_number, String billing_address, boolean is_hotel_card, String check_in_id) throws SQLException{

		System.out.println("Creating Bill for Check-In ID: "+ check_in_id);
		stmt.execute("INSERT INTO billing(total_charge, card_number, billing_address, is_hotel_card, check_in_id) VALUES (" + total_charge + ", " + card_number + ", " + billing_address + ", " + is_hotel_card + ", " + check_in_id + ");");
	}

	static void ReleaseRoom(Statement stmt, String room_number, String hotel_id) throws SQLException{

		System.out.println("Releasing Room Number: " + room_number + " for Hotel ID: " + hotel_id + " as the customer has checked-out");
		stmt.executeUpdate("UPDATE rooms SET availability = TRUE WHERE room_number = " + room_number + " AND hotel_id = " + hotel_id + ";");
	}

	static void InsertServiceForCheckin(Statement stmt, String staff_id, String check_in_id, String service_id) throws SQLException{

		System.out.println("Adding a service record for check-in ID: " + check_in_id);
		stmt.execute("INSERT INTO check_in_services(staff_id, check_in_id, service_id) VALUES(" + staff_id + ", " + check_in_id + ", " + service_id + ");");
	}

	static void CreateBillingEntry(Statement stmt, String total_charge, String card_number, String billing_address, boolean is_hotel_card, String check_in_id) throws SQLException{

		System.out.println("Creating Billing Record for Check-In ID: " + check_in_id);
		stmt.execute("INSERT INTO billing(total_charge, card_number, billing_address, is_hotel_card, check_in_id) VALUES (" + total_charge + ", NULL, NULL, FALSE, " + check_in_id + ");");
	}

	static void BillPaidUsingHotelCard(Statement stmt, String total_charge, String card_number, String billing_address, boolean is_hotel_card, String check_in_id) throws SQLException{

		System.out.println("The bill is paid using Hotel Card for Check-In ID: " + check_in_id);
		stmt.execute("INSERT INTO billing(total_charge, card_number, billing_address, is_hotel_card, check_in_id) VALUES (" + total_charge + ", " + card_number + ", " + billing_address +" , TRUE, " + check_in_id + ");");
	}

	static void BillPaidUsingCard(Statement stmt, String total_charge, String card_number, String billing_address, boolean is_hotel_card, String check_in_id) throws SQLException{

		System.out.println("Bill paid using card for Check-In ID: " + check_in_id);
		stmt.execute("INSERT INTO billing(total_charge, card_number, billing_address, is_hotel_card, check_in_id) VALUES (" + total_charge + ", " + card_number + ", " + billing_address + ", FALSE, " + check_in_id + ");");
	}

	static void BillPaidUsingCash(Statement stmt, String total_charge, String card_number, String billing_address, boolean is_hotel_card, String check_in_id) throws SQLException{

		System.out.println("Bill is paid using cash for Check-In ID: " + check_in_id);
		stmt.execute("INSERT INTO billing(total_charge, card_number, billing_address, is_hotel_card, check_in_id) VALUES (" + total_charge + ", NULL, " + billing_address + ", FALSE, " + check_in_id + ");");
	}

	static ResultSet RetriveBillAmount(Statement stmt, String check_in_id) throws SQLException{

		System.out.println("Retrieving bill amount for Check-In ID: " + check_in_id);
		ResultSet rs = stmt.executeQuery("SELECT total_charge FROM billing WHERE check_in_id = " + check_in_id + ";");
		return rs;
	}

	static ResultSet ReportOccupancyByHotel(Statement stmt) throws SQLException{

		System.out.println("Report Occupancy By Hotel");
		ResultSet rs = stmt.executeQuery("SELECT hotel_id, SUM(number_of_guests) FROM check_in INNER JOIN staff ON check_in.staff_id = staff.staff_id WHERE check_out_date_time IS NULL GROUP BY staff.hotel_id;");
		return rs;
	}

	static ResultSet ReportOccupancyByRoomType(Statement stmt) throws SQLException{

		System.out.println("Report occupancy by room type");
		ResultSet rs = stmt.executeQuery("SELECT category, SUM(number_of_guests) FROM check_in INNER JOIN staff ON check_in.staff_id = staff.staff_id INNER JOIN hotels ON staff.hotel_id = hotels.hotel_id INNER JOIN rooms ON check_in.room_number = rooms.room_number AND hotels.hotel_id = rooms.hotel_id WHERE check_out_date_time IS NULL GROUP BY category;");
		return rs;
	}

	static ResultSet ReportOccupancyByDateRangeGroupedByHotel(Statement stmt, String to, String from) throws SQLException{

		System.out.println("Report occupancy by date range (grouped by hotel)");
		ResultSet rs = stmt.executeQuery("SELECT hotel_id, check_in_date_time, check_out_date_time, sum(number_of_guests) FROM check_in INNER JOIN staff ON check_in.staff_id = staff.staff_id WHERE check_in.check_in_date_time > " + from + " AND check_in.check_out_date_time < " + to + " GROUP BY staff.hotel_id;");
		return rs;
	}

	static ResultSet ReportOccupancyByDateRange(Statement stmt, String to, String from) throws SQLException{

		System.out.println("Report occupancy by date range");
		ResultSet rs = stmt.executeQuery("select sum(number_of_guests) from check_in where check_in_date_time > " + from + " AND check_out_date_time < " + to + ";");
		return rs;
	}

	static ResultSet ReportOccupancyByCity(Statement stmt) throws SQLException{

		System.out.println("Report occupancy by city");
		ResultSet rs = stmt.executeQuery("SELECT city, sum(number_of_guests) FROM check_in INNER JOIN staff ON check_in.staff_id = staff.staff_id INNER JOIN hotels ON staff.hotel_id = hotels.hotel_id INNER JOIN address_gives_city ON hotels.hotel_address = address_gives_city.address WHERE check_out_date_time IS NULL GROUP BY address_gives_city.city;");
		return rs;
	}

	static ResultSet ReportTotalOccupancy(Statement stmt) throws SQLException{

		System.out.println("Report total occupancy");
		ResultSet rs = stmt.executeQuery("select sum(number_of_guests) from check_in WHERE check_out_date_time IS NULL;");
		return rs;
	}

	static ResultSet ReportPercentageOfRoomOccupied(Statement stmt) throws SQLException{

		System.out.println("Report percentage of room occupied");
		ResultSet rs = stmt.executeQuery("SELECT (SELECT COUNT(*) FROM rooms WHERE availability = FALSE) / (SELECT COUNT(*) FROM rooms) * 100 AS percentage_rooms_occupied;");
		return rs;
	}

	static ResultSet ReportInfoOnServingStaff(Statement stmt) throws SQLException{

		System.out.println("Information on staff grouped by their role");
		ResultSet rs = stmt.executeQuery("SELECT job_title, count(*), avg(age) FROM staff GROUP BY job_title;");
		return rs;
	}

	static ResultSet ReportStaffServingCustomer(Statement stmt, String ssn) throws SQLException{

		System.out.println("Staff members serving a particular customer");
		ResultSet rs = stmt.executeQuery("SELECT name from staff INNER JOIN check_in_services on staff.staff_id = check_in_services.staff_id INNER JOIN check_in on check_in_services.check_in_id = check_in.check_in_id WHERE ssn = " + ssn + ";");
		return rs;
	}

	static ResultSet ReportRevenueByHotels(Statement stmt) throws SQLException{

		System.out.println("Revenue generated by hotels");
		ResultSet rs = stmt.executeQuery("SELECT hotels.hotel_id, hotels.name, sum(total_charge) FROM billing INNER JOIN check_in ON billing.check_in_id = check_in.check_in_id INNER JOIN staff ON check_in.staff_id = staff.staff_id INNER JOIN hotels ON staff.hotel_id = hotels.hotel_id GROUP BY hotels.hotel_id;");
		return rs;
	}

	static ResultSet CreateItemizedBill(Statement stmt, String check_in_id) throws SQLException{

		System.out.println("Creating Itemized Bill for Check-In ID: " + check_in_id);
		ResultSet rs = stmt.executeQuery("( select name, quantity * price as amount from check_in " +
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
		return rs;
	}

	static void close(Connection conn) {
        if(conn != null) {
            try { conn.close(); } catch(Throwable whatever) {}
        }
    }

    static void close(Statement st) {
        if(st != null) {
            try { st.close(); } catch(Throwable whatever) {}
        }
    }

    static void close(ResultSet rs) {
        if(rs != null) {
            try { rs.close(); } catch(Throwable whatever) {}
        }
    }

}
