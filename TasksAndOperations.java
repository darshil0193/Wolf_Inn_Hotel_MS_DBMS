import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class TasksAndOperations {
	
	static final String jdbcURL = "jdbc:mariadb://classdb2.csc.ncsu.edu:3306/psinha";
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
            	while(true) {
            		
            		System.out.println("1. Hotel \n"
            				+ "2. Rooms \n"
            				+ "3. Staff \n"
            				+ "4. Customers \n"
            				+ "5. Availability of Rooms \n"
            				+ "6. Maintaining Service Records \n"
            				+ "7. Maintaning Billing Accounts \n"
            				+ "8. Reports");
            		String input = br.readLine();
            		if(input.matches("[1-8]")) {
            			System.out.println(getSubMenuItems(Integer.parseInt(input)));
            			int input1 = Integer.parseInt(br.readLine());
            			findAction(Integer.parseInt(input), input1, stmt);
            		}

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
                // EnterStaffInformation(stmt, staff_address, age, phone_number, job_title, hotel_id, name, management);
                
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
            	}
                
                
               
            } finally {
                close(rs);
                close(stmt);
                close(conn);
            }

        } catch(Throwable oops) {
            oops.printStackTrace();
        }
    }
	
	static String getSubMenuItems(int choice) {
		switch(choice) {
		case 1 : return "1. Enter Hotel Information \n" +  
						"2. Update Hotel Information \n" +  
						"3. Delete Hotel Information \n" ;
		case 2 : return "1. Enter Room Information \n" + 
						"2. Update Room Information \n" +  
						"3. Delete Room Information \n";
		case 3 : return "1. Enter Staff Information \n" +
						"2. Update Staff Information \n" + 
						"3. Delete Staff Information \n";
		case 4 : return "1. Enter customer Information \n" +
						"2. Update customer Information \n" + 
						"3. Delete customer Information \n";
		case 5 : return "1. Room availability \n" + 
						"2. Room Type availability \n" +  
						"3. Assign Room \n";
		case 6 : return "1. Enter service \n" + 
						"2. Update service \n";
		case 7 : return "1. Create billing account \n" + 
						"2. Paid using hotel card \n" +  	
						"3. Paid using other card \n" + 
						"4. Paid using cash \n" +  
						"5. Retrieve bill amount \n";
		case 8 : return "1. Report occupancy by hotel \n" +
						"2. Report occupancy by room type \n" +
						"3. Report occupancy by date range (grouped by hotel) \n" +
						"4. Report occupancy by date range \n" + 
						"5. Report occupancy by city \n" +
						"6. Report total occupancy \n" + 
						"7. Report percentage of room occupied \n" + 
						"8. Information on staff grouped by their role \n" +
						"9. Staff members serving a particular customer \n" + 
						"10. Revenue generated by hotels \n" + 
						"11. Create Itemized Bill Receipt \n"; 
		}
		return "";
	}
	
	static void findAction(int choice1, int choice2, Statement stmt) throws IOException {
		
		switch(choice1) {
		case 1 : if(choice2 == 1) {
				System.out.println("Enter Hotel name : \n");
				String name = br.readLine();
				System.out.println("Enter Phone number \n");
				String number = br.readLine();
				System.out.println("Enter Address \n");
				String address = br.readLine();
				try {
				EnterHotelInformation(stmt, name, number, address);
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
				if(choice2 == 2) {
					System.out.println("Enter hotel id :");
					String id = br.readLine();
					System.out.println("Enter the column name to update");
					String parameter = br.readLine();
					System.out.println("Enter new value");
					String value = br.readLine();
					try {
						UpdateHotelInformation(stmt, id, parameter, value);
						} catch(SQLException e) {
							e.printStackTrace();
						}
					
				}
				if(choice2 == 3){
					System.out.println("Enter Hotel id:");
					String id = br.readLine();
					try {
						DeleteHotelInformation(stmt, id);
						} catch(SQLException e) {
							e.printStackTrace();
						}
				}
				
		case 2 : if(choice2 == 1) {
					System.out.println("Enter Room Number : ");
					String number = br.readLine();
					System.out.println("Enter category: ");
					String category = br.readLine();
					System.out.println("Enter rate");
					String rate = br.readLine();
					System.out.println("Enter Availability [T/F]");
					String avail = br.readLine();
					boolean availability = false;
					if(avail.equalsIgnoreCase("t")) {
						availability = true;
					}
					System.out.println("Enter max occupancy");
					String max_occupancy = br.readLine();
					System.out.println("Enter Hotel ID");
					String id = br.readLine();
					try {
					EnterRoomInformation(stmt, number, category, Integer.parseInt(rate), availability, max_occupancy, id);
					} catch(SQLException e) {
						e.printStackTrace();
					}
				}
			if(choice2 == 2) {
				System.out.println("Enter Hotel id : ");
				String id = br.readLine();
				System.out.println("Enter Room Number : ");
				String number = br.readLine();
				System.out.println("Enter Column name : ");
				String parameter = br.readLine();
				System.out.println("Enter value : ");
				String value = br.readLine();
				try {
					UpdateRoomInformation(stmt, id, number, parameter, value);
					} catch(SQLException e) {
						e.printStackTrace();
					}
				
			}
			
			if(choice2 == 3) {
				System.out.println("Enter Hotel id : ");
				String id = br.readLine();
				System.out.println("Enter Room Number : ");
				String number = br.readLine();
				try {
					DeleteRoomInformation(stmt, id, number);
					} catch(SQLException e) {
						e.printStackTrace();
					}
			}
		case 3 : 
				if(choice2 == 1) {
				System.out.println("Enter staff address : ");
				String address = br.readLine();
				System.out.println("Enter age: ");
				String age = br.readLine();
				System.out.println("Enter phone number");
				String number = br.readLine();
				System.out.println("Enter job title");
				String job_title = br.readLine();
				System.out.println("Enter hotel id");
				String id = br.readLine();
				System.out.println("Enter name");
				String name = br.readLine();
				System.out.println("Enter management");
				String management = br.readLine();
				try {
				EnterStaffInformation(stmt, address, age, number, job_title, id, name, management);
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
//				static void UpdateStaffInformation(Statement stmt, String staff_id, String parameter, String value) throws SQLException{
				if(choice2 == 2) {
				System.out.println("Enter staff id : ");
				String id = br.readLine();
				System.out.println("Enter Column Name : ");
				String parameter = br.readLine();
				System.out.println("Enter value : ");
				String value = br.readLine();
				try {
					UpdateStaffInformation(stmt, id, parameter, value);
					} catch(SQLException e) {
						e.printStackTrace();
					}
				
			}
				if(choice2 == 3) {
					System.out.println("Enter staff id : ");
					String id = br.readLine();
					try {
						DeleteStaffInformation(stmt, id);
						} catch(SQLException e) {
							e.printStackTrace();
						}
					
				}
		case 4 :  
        // a. Enter customer Information
        // EnterCustomerInformation(stmt, ssn, name, dob, email, phone)
        
        // b. Update customer Information
        // UpdateCustomerInformation(stmt, parameter, value, ssn); 
        
        // c. Delete customer Information
        // DeleteCustomerInformation(stmt, ssn);
        		
				if(choice2 == 1) {
					System.out.println("Enter SSN : ");
					int ssn = Integer.parseInt(br.readLine());
					System.out.println("Enter Name : ");
					String name = br.readLine();
					System.out.println("Enter DOB: ");
					String dob = br.readLine();
					System.out.println("Enter Email: ");
					String email = br.readLine();
					System.out.println("Enter phone number: ");
					String number = br.readLine();
					try {
						EnterCustomerInformation(stmt, ssn, name, dob, email, number);
						} catch(SQLException e) {
							e.printStackTrace();
						}
					
				}
				
				if(choice2 == 2) {
					System.out.println("Enter Coulmn Name : ");
					String parameter = br.readLine();
					System.out.println("Enter value : ");
					String value = br.readLine();
					System.out.println("Enter SSN: ");
					String ssn = br.readLine();
					try {
						UpdateCustomerInformation(stmt, parameter, value, ssn);
						} catch(SQLException e) {
							e.printStackTrace();
						}
				}
				if(choice2 == 3) {
					System.out.println("Enter SSN: ");
					String ssn = br.readLine();
					try {
						DeleteCustomerInformation(stmt, ssn);
						} catch(SQLException e) {
							e.printStackTrace();
						}
				}
		case 5 : // a. Room availability
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
			if(choice2 == 1) {
				try {
				ResultSet allAvailableRooms = AvailableRooms(stmt, true);
				while(allAvailableRooms.next()) {
					System.out.print(allAvailableRooms.getString("room_number"));
					System.out.println(allAvailableRooms.getString("hotel_id"));
					}
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(choice2 == 2) {
				System.out.println("Enter category: ");
				String category = br.readLine();
				try {
					ResultSet AvailableRoomsForRoomType =  AvailableRoomsRoomType(stmt, true, category);
					while(AvailableRoomsForRoomType.next()) {
						System.out.print(AvailableRoomsForRoomType.getString("room_number"));
						System.out.println(AvailableRoomsForRoomType.getString("hotel_id"));
					}
					
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(choice2 == 3) {
				// i. Create Check in
            	// CreateCheckin(stmt, number_of_guests, check_in_date_time, check_out_date_time, room_number, ssn, staff_id);
            
            	
				System.out.println("1. Create check-in \n"
						+ "2. Change availability of room to be FALSE");
				int option = Integer.parseInt(br.readLine());
				if(option == 1) {
					System.out.println("Number of guests : ");
					int number_guests = Integer.parseInt(br.readLine());
					System.out.println("check-in datetime : ");
					String check_in_datetime = br.readLine();
					System.out.println("Enter check_out_datetime: ");
					String check_out_datetime = br.readLine();
					System.out.println("Enter room number: ");
					String room_number = br.readLine();
					System.out.println("Enter SSN: ");
					String ssn = br.readLine();
					System.out.println("Enter Staff id: ");
					String staff_id = br.readLine();
					try {
						CreateCheckin(stmt, number_guests, check_in_datetime, check_out_datetime, room_number, ssn, staff_id);
						} catch(SQLException e) {
							e.printStackTrace();
						}
				}
				// ii. Change availability of room to be FALSE
            	// ReserveRoom(stmt, room_number, hotel_id);
				if(option == 2) {
					System.out.println("Enter room number: ");
					String room_number = br.readLine();
					
					System.out.println("Enter Hotel id: ");
					String hotel_id = br.readLine();
					try {
						ReserveRoom(stmt, room_number, hotel_id);
						} catch(SQLException e) {
							e.printStackTrace();
						}
				}
				
			}
			
			if(choice2 == 4) {
				
				System.out.println("1. Update check out date time \n"
						+ "2. Create Bill \n"
						+ "3. Update room Availability");
				int option = Integer.parseInt(br.readLine());
				// d. Release room
            	// i. Update check out date time
            	// UpdateCheckin(stmt, check_in_id, check_out_date_time);
				if(option == 1) {
					System.out.println("Enter check_in_id: ");
					String check_in_id = br.readLine();
					System.out.println("Enter check_out_datetime: ");
					String check_out_datetime = br.readLine();
					try {
						UpdateCheckin(stmt, check_in_id, check_out_datetime);
						} catch(SQLException e) {
							e.printStackTrace();
						}
				}
				
            
            	// ii. Create bill
            	// CreateBill(stmt, total_charge, card_number, billing_address, is_hotel_card, check_in_id);
				if(option == 2) {
					System.out.println("Enter total charge: ");
					String total_charge = br.readLine();
					System.out.println("Enter Card Number: ");
					String card_number = br.readLine();
					System.out.println("Enter Billing Address: ");
					String address = br.readLine();
					System.out.println("Is hotel Card [Y/N]");
					String hotel_card = br.readLine();
					boolean is_hotel_card = false;
					if(hotel_card.equalsIgnoreCase("t")) {
						is_hotel_card = true;
					}
					System.out.println("Enter Check-in id");
					String check_in_id = br.readLine();
					
					try {
						CreateBill(stmt, total_charge, card_number, address, is_hotel_card, check_in_id);
						} catch(SQLException e) {
							e.printStackTrace();
						}
				}
				
            	// iii. Update room availability to TRUE
            	// ReleaseRoom(stmt, room_number, hotel_id);
				if(option == 3) {
					System.out.println("Enter room number: ");
					String room_number = br.readLine();
					System.out.println("Enter Hotel id: ");
					String hotel_id = br.readLine();
					try {
						ReleaseRoom(stmt, room_number, hotel_id);
						} catch(SQLException e) {
							e.printStackTrace();
						}
				}
			}
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

	static void EnterStaffInformation(Statement stmt, String staff_address, String age, String phone_number, String job_title, String hotel_id, String name, String management) throws SQLException{

		System.out.println("Adding new Staff Information");
		stmt.execute("INSERT INTO staff(staff_address, age, phone_number, job_title, hotel_id, name, management) VALUES(" + staff_address + ", " + age + ", " + phone_number + ", " + job_title + ", " + hotel_id + ",  " + name + ", " + management + ");");
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
