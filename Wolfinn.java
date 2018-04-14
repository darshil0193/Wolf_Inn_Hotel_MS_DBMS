// Acknowledgments: This example is a modification of code provided
// by Dimitri Rakitine. Further modified by Shrikanth N C for MySql(MariaDB) support
// Relpace all $USER$ with your unity id and $PASSWORD$ with your 9 digit student id or updated password (if changed)

import java.sql.*;

public class Wolfinn {

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

                dropTables(stmt);
                createTables(stmt);
                populateData(stmt);

            } finally {
                close(rs);
                close(stmt);
                close(conn);
            }

        } catch(Throwable oops) {
            oops.printStackTrace();
        }
    }

    static void populateData(Statement st) throws SQLException {

        System.out.println("Adding into services");
        st.executeUpdate("INSERT INTO services(service_id, name, price) VALUES(1, 'phone bills', 5.00)");
        st.executeUpdate("INSERT INTO services(service_id, name, price) VALUES(2, 'dry cleaning', 16.00)");
        st.executeUpdate("INSERT INTO services(service_id, name, price) VALUES(3, 'gyms', 15.00)");
        st.executeUpdate("INSERT INTO services(service_id, name, price) VALUES(4, 'room service', 10.00)");
        st.executeUpdate("INSERT INTO services(service_id, name, price) VALUES(5, 'special requests', 20.00)");

        System.out.println("Adding into hotels");
        st.executeUpdate("INSERT INTO hotels(hotel_id, name, hotel_address, phone_number) VALUES(1, 'Hotel A', '21 ABC St, Raleigh NC 27', '919')");
        st.executeUpdate("INSERT INTO hotels(hotel_id, name, hotel_address, phone_number) VALUES(2, 'Hotel B', '25 XYZ St, Rochester NY 54', '718')");
        st.executeUpdate("INSERT INTO hotels(hotel_id, name, hotel_address, phone_number) VALUES(3, 'Hotel C', '29 PQR St, Greensboro NC 27', '984')");
        st.executeUpdate("INSERT INTO hotels(hotel_id, name, hotel_address, phone_number) VALUES(4, 'Hotel D', '28 GHW St, Raleigh NC 32', '920')");

        System.out.println("Adding into rooms");
        st.executeUpdate("INSERT INTO rooms(room_number, hotel_id, category, max_occupancy, rate, availability) VALUES(1, 1, 'Economy', 1, 100.00, TRUE)");
        st.executeUpdate("INSERT INTO rooms(room_number, hotel_id, category, max_occupancy, rate, availability) VALUES(2, 1, 'Deluxe', 2, 200.00, TRUE)");
        st.executeUpdate("INSERT INTO rooms(room_number, hotel_id, category, max_occupancy, rate, availability) VALUES(3, 2, 'Economy', 1, 100.00, TRUE)");
        st.executeUpdate("INSERT INTO rooms(room_number, hotel_id, category, max_occupancy, rate, availability) VALUES(2, 3, 'Executive', 3, 1000.00, FALSE)");
        st.executeUpdate("INSERT INTO rooms(room_number, hotel_id, category, max_occupancy, rate, availability) VALUES(1, 4, 'Presidential', 4, 5000.00, TRUE)");
        st.executeUpdate("INSERT INTO rooms(room_number, hotel_id, category, max_occupancy, rate, availability) VALUES(5, 1, 'Deluxe', 2, 200.00, TRUE)");

        System.out.println("Adding into staff");
        st.executeUpdate("INSERT INTO staff(staff_id, name, age, job_title, hotel_id, department, phone_number, staff_address) VALUES(100, 'Mary', 40, 'Manager', 1, 'Management', 654, '90 ABC St, Raleigh NC 27')");
        st.executeUpdate("INSERT INTO staff(staff_id, name, age, job_title, hotel_id, department, phone_number, staff_address) VALUES(101, 'John', 45, 'Manager', 2, 'Management', 564, '798 XYZ St, Rochester NY 54')");
        st.executeUpdate("INSERT INTO staff(staff_id, name, age, job_title, hotel_id, department, phone_number, staff_address) VALUES(102, 'Carol', 55, 'Manager', 3, 'Management', 546, '351 MH St, Greensboro NC 27')");
        st.executeUpdate("INSERT INTO staff(staff_id, name, age, job_title, hotel_id, department, phone_number, staff_address) VALUES(103, 'Emma', 55, 'Front Desk', 1, 'Management', 546, '49 ABC St, Raleigh NC 27')");
        st.executeUpdate("INSERT INTO staff(staff_id, name, age, job_title, hotel_id, department, phone_number, staff_address) VALUES(104, 'Ava', 55, 'Catering Staff', 1, 'Catering', 777, '425 RG St, Raleigh NC 27')");
        st.executeUpdate("INSERT INTO staff(staff_id, name, age, job_title, hotel_id, department, phone_number, staff_address) VALUES(105, 'Peter', 52, 'Manager', 4, 'Management', 724, '475 RG St, Raleigh NC 27')");
        st.executeUpdate("INSERT INTO staff(staff_id, name, age, job_title, hotel_id, department, phone_number, staff_address) VALUES(106, 'Olivia', 27, 'Front Desk', 4, 'Management', 799, '325 PD St, Raleigh NC 27')");

        System.out.println("Adding into customers");
        st.executeUpdate("INSERT INTO customers(ssn, name, dob, phone, email) VALUES(5939846, 'David', '1980-01-30', 123, 'david@gmail.com')");
        st.executeUpdate("INSERT INTO customers(ssn, name, dob, phone, email) VALUES(7778352, 'Sarah', '1971-01-30', 456, 'sarah@gmail.com')");
        st.executeUpdate("INSERT INTO customers(ssn, name, dob, phone, email) VALUES(8589430, 'Joseph', '1987-01-30', 789, 'joseph@gmail.com')");
        st.executeUpdate("INSERT INTO customers(ssn, name, dob, phone, email) VALUES(4409328, 'Lucy', '1985-01-30', 213, 'lucy@gmail.com')");

        System.out.println("Adding into check ins");
        st.executeUpdate("INSERT INTO check_in(check_in_id, ssn, staff_id, room_number, number_of_guests, check_in_date_time, check_out_date_time) VALUES(1, 5939846, 103, 1, 1, '2017-05-10 15:17:00', '2017-05-13 10:22:00')");
        st.executeUpdate("INSERT INTO check_in(check_in_id, ssn, staff_id, room_number, number_of_guests, check_in_date_time, check_out_date_time) VALUES(2, 7778352, 103, 2, 2, '2017-05-10 16:11:00', '2017-05-13 09:27:00')");
        st.executeUpdate("INSERT INTO check_in(check_in_id, ssn, staff_id, room_number, number_of_guests, check_in_date_time, check_out_date_time) VALUES(3, 8589430, 101, 3, 1, '2016-05-10 15:45:00', '2016-05-14 11:10:00')");
        st.executeUpdate("INSERT INTO check_in(check_in_id, ssn, staff_id, room_number, number_of_guests, check_in_date_time, check_out_date_time) VALUES(4, 4409328, 102, 2, 2, '2018-05-10 14:30:00', '2018-05-12 10:00:00')");

        System.out.println("Adding into presidential suites");

        System.out.println("Adding into billing");
        st.executeUpdate("INSERT INTO billing(bill_id, check_in_id, total_charge, billing_address, card_number, is_hotel_card) VALUES(1, 1, 375.68, '980 TRT St, Raleigh NC', '1052', FALSE)");
        st.executeUpdate("INSERT INTO billing(bill_id, check_in_id, total_charge, billing_address, card_number, is_hotel_card) VALUES(2, 2, 663.12, '7720 MHT St, Greensboro NC', '3020', TRUE)");
        st.executeUpdate("INSERT INTO billing(bill_id, check_in_id, total_charge, billing_address, card_number, is_hotel_card) VALUES(3, 3, 465.35, '231 DRY St, Rochester NY 78', '2497', FALSE)");
        st.executeUpdate("INSERT INTO billing(bill_id, check_in_id, total_charge, billing_address) VALUES(4, 4, 2275.68, '24 BST Dr, Dallas TX 14')");

        System.out.println("Adding into address gives city");
        st.executeUpdate("INSERT INTO address_gives_city(address, city) VALUES('21 ABC St, Raleigh NC 27', 'Raleigh')");
        st.executeUpdate("INSERT INTO address_gives_city(address, city) VALUES('25 XYZ St, Rochester NY 54', 'Rochester')");
        st.executeUpdate("INSERT INTO address_gives_city(address, city) VALUES('29 PQR St, Greensboro NC 27', 'Greensboro')");
        st.executeUpdate("INSERT INTO address_gives_city(address, city) VALUES('28 GHW St, Raleigh NC 32', 'Raleigh')");

        System.out.println("Adding into check in services");
        st.executeUpdate("INSERT INTO check_in_services(staff_id, check_in_id, service_id) VALUES(103, 1, 2)");
        st.executeUpdate("INSERT INTO check_in_services(staff_id, check_in_id, service_id) VALUES(103, 1, 3)");
        st.executeUpdate("INSERT INTO check_in_services(staff_id, check_in_id, service_id) VALUES(103, 2, 3)");
        st.executeUpdate("INSERT INTO check_in_services(staff_id, check_in_id, service_id) VALUES(101, 3, 4)");
        st.executeUpdate("INSERT INTO check_in_services(staff_id, check_in_id, service_id) VALUES(102, 4, 1)");

        System.out.println("Adding into managed by");
        st.executeUpdate("INSERT INTO managed_by(hotel_id, staff_id) VALUES(1, 100)");
        st.executeUpdate("INSERT INTO managed_by(hotel_id, staff_id) VALUES(2, 101)");
        st.executeUpdate("INSERT INTO managed_by(hotel_id, staff_id) VALUES(3, 102)");
        st.executeUpdate("INSERT INTO managed_by(hotel_id, staff_id) VALUES(4, 105)");
    }

    static void dropTables(Statement st) throws SQLException {

            System.out.println("Starting DROP tables.");
            st.executeUpdate("DROP TABLE managed_by CASCADE;");
            st.executeUpdate("DROP TABLE check_in_services CASCADE;");
            st.executeUpdate("DROP TABLE address_gives_city CASCADE;");
            st.executeUpdate("DROP TABLE billing CASCADE;");
            st.executeUpdate("DROP TABLE presidential_suite CASCADE;");
            st.executeUpdate("DROP TABLE check_in CASCADE;");
            st.executeUpdate("DROP TABLE customers CASCADE;");
            st.executeUpdate("DROP TABLE staff CASCADE;");
            st.executeUpdate("DROP TABLE rooms CASCADE;");
            st.executeUpdate("DROP TABLE hotels CASCADE;");
            st.executeUpdate("DROP TABLE services CASCADE;");
            System.out.println("DROP tables done.");

    }

    static void createTables(Statement st) throws SQLException {

            System.out.println("Starting CREATE Tables.");

            //Creating services table
            st.executeUpdate("CREATE TABLE services(" +
                    "service_id INT PRIMARY KEY," +
                    "name VARCHAR(50) NOT NULL," +
                    "price FLOAT NOT NULL" +
                    ")");

            st.executeUpdate("CREATE TABLE hotels(" +
                    "hotel_id INT PRIMARY KEY," +
                    "name VARCHAR(50) NOT NULL," +
                    "hotel_address VARCHAR(255) NOT NULL UNIQUE," +
                    "phone_number VARCHAR(10) NOT NULL" +
                    ");");

            st.executeUpdate("CREATE TABLE rooms(" +
                    "room_number INT NOT NULL," +
                    "hotel_id INT NOT NULL," +
                    "category VARCHAR(50) NOT NULL," +
                    "max_occupancy INT NOT NULL," +
                    "rate FLOAT NOT NULL," +
                    "availability BOOLEAN DEFAULT TRUE NOT NULL," +
                    "CONSTRAINT hotels_table_fk FOREIGN KEY(hotel_id) REFERENCES hotels(hotel_id) ON DELETE CASCADE," +
                    "CONSTRAINT rooms_key_constraint PRIMARY KEY(room_number, hotel_id)" +
                    ");");

            st.executeUpdate("CREATE TABLE staff(" +
                    "staff_id INT PRIMARY KEY," +
                    "name VARCHAR(50) NOT NULL," +
                    "age INT NOT NULL," +
                    "job_title VARCHAR(50) NOT NULL," +
                    "hotel_id INT NOT NULL," +
                    "department VARCHAR(50) NOT NULL," +
                    "phone_number VARCHAR(10) NOT NULL," +
                    "staff_address VARCHAR(255) NOT NULL," +
                    "CONSTRAINT hotels_id_fk FOREIGN KEY(hotel_id) REFERENCES hotels(hotel_id) ON DELETE CASCADE" +
                    ");");

            st.executeUpdate("CREATE TABLE customers(" +
                    "ssn INT PRIMARY KEY," +
                    "name VARCHAR(50) NOT NULL," +
                    "dob DATE NOT NULL," +
                    "phone VARCHAR(10) NOT NULL," +
                    "email VARCHAR(50) NOT NULL" +
                    ");");

            st.executeUpdate("CREATE TABLE check_in(" +
                    "check_in_id INT PRIMARY KEY," +
                    "ssn INT NOT NULL," +
                    "staff_id INT NOT NULL," +
                    "room_number INT NOT NULL," +
                    "number_of_guests INT NOT NULL," +
                    "check_in_date_time DATETIME NOT NULL," +
                    "check_out_date_time DATETIME," +
                    "CONSTRAINT room_number_fk FOREIGN KEY(room_number) REFERENCES rooms(room_number) ON DELETE CASCADE," +
                    "CONSTRAINT customer_ssn_fk FOREIGN KEY(ssn) REFERENCES customers(ssn) ON DELETE CASCADE," +
                    "CONSTRAINT staff_id_fk FOREIGN KEY(staff_id) REFERENCES staff(staff_id) ON DELETE CASCADE" +
                    ");");

            st.executeUpdate("CREATE TABLE presidential_suite(" +
                    "room_number INT NOT NULL," +
                    "hotel_id INT NOT NULL," +
                    "room_service_staff INT NOT NULL," +
                    "catering_staff INT NOT NULL," +
                    "CONSTRAINT room_number_presidential_fk FOREIGN KEY(room_number) REFERENCES rooms(room_number) ON DELETE CASCADE," +
                    "CONSTRAINT hotels_id_presidential_fk FOREIGN KEY(hotel_id) REFERENCES hotels(hotel_id) ON DELETE CASCADE," +
                    "CONSTRAINT room_service_staff_fk FOREIGN KEY(room_service_staff) REFERENCES staff(staff_id) ON DELETE CASCADE," +
                    "CONSTRAINT catering_staff_presidential_fk FOREIGN KEY(catering_staff) REFERENCES staff(staff_id) ON DELETE CASCADE," +
                    "CONSTRAINT presidential_suite_key_fk PRIMARY KEY(room_number, hotel_id)" +
                    ");");

            st.executeUpdate("CREATE TABLE billing(" +
                    "bill_id INT PRIMARY KEY," +
                    "check_in_id INT NOT NULL," +
                    "total_charge FLOAT NOT NULL," +
                    "billing_address VARCHAR(255) NOT NULL," +
                    "card_number VARCHAR(16)," +
                    "is_hotel_card BOOLEAN DEFAULT FALSE NOT NULL," +
                    "CONSTRAINT check_in_table_fk FOREIGN KEY(check_in_id) REFERENCES check_in(check_in_id) ON DELETE CASCADE" +
                    ");");

            st.executeUpdate("CREATE TABLE address_gives_city(" +
                    "address VARCHAR(255)," +
                    "city VARCHAR(50) NOT NULL," +
                    "CONSTRAINT address_to_city_fk FOREIGN KEY (address) REFERENCES hotels(hotel_address) ON DELETE CASCADE," +
                    "CONSTRAINT address_is_primary_key PRIMARY KEY (address)" +
                    ");");

            st.executeUpdate("CREATE TABLE check_in_services(" +
                    "staff_id INT NOT NULL," +
                    "check_in_id INT NOT NULL," +
                    "service_id INT NOT NULL," +
                    "quantity INT DEFAULT 1 NOT NULL," +
                    "CONSTRAINT staff_id_fk_service FOREIGN KEY(staff_id) REFERENCES staff(staff_id) ON DELETE CASCADE," +
                    "CONSTRAINT check_in_id_fk FOREIGN KEY (check_in_id) REFERENCES check_in(check_in_id) ON DELETE CASCADE," +
                    "CONSTRAINT service_id_fk FOREIGN KEY(service_id) REFERENCES services(service_id) ON DELETE CASCADE," +
                    "CONSTRAINT check_in_services PRIMARY KEY(staff_id, check_in_id, service_id)" +
                    ");");

            st.executeUpdate("CREATE TABLE managed_by(" +
                    "hotel_id INT NOT NULL," +
                    "staff_id INT NOT NULL," +
                    "CONSTRAINT hotel_managed_fk FOREIGN KEY(hotel_id) REFERENCES hotels(hotel_id)," +
                    "CONSTRAINT staff_managed_fk FOREIGN KEY(staff_id) REFERENCES staff(staff_id)," +
                    "CONSTRAINT managed_by_key PRIMARY KEY(hotel_id, staff_id)" +
                    ");");

            System.out.println("CREATE tables done.");

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