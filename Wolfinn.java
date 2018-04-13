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
        st.executeUpdate("INSERT INTO hotels(hotel_id, name, phone_number, hotel_address) VALUES(1, 'Hotel A', '919', '21 ABC St, Raleigh NC 27')");
        st.executeUpdate("INSERT INTO hotels(hotel_id, name, phone_number, hotel_address) VALUES(2, 'Hotel B', '718', '25 XYZ St, Rochester NY 54')");
        st.executeUpdate("INSERT INTO hotels(hotel_id, name, phone_number, hotel_address) VALUES(3, 'Hotel C', '984', '29 PQR St, Greensboro NC 27')");
        st.executeUpdate("INSERT INTO hotels(hotel_id, name, phone_number, hotel_address) VALUES(4, 'Hotel D', '920', '28 GHW St, Raleigh NC 32')");

        System.out.println("Adding into rooms");
        st.executeUpdate("INSERT INTO rooms(room_number, category, rate, availability, max_occupancy, hotel_id) VALUES(1, 'Economy', 100.00, TRUE, 1, 1)");
        st.executeUpdate("INSERT INTO rooms(room_number, category, rate, availability, max_occupancy, hotel_id) VALUES(2, 'Deluxe', 200.00, TRUE, 2, 1)");
        st.executeUpdate("INSERT INTO rooms(room_number, category, rate, availability, max_occupancy, hotel_id) VALUES(3, 'Economy', 100.00, TRUE, 1, 2)");
        st.executeUpdate("INSERT INTO rooms(room_number, category, rate, availability, max_occupancy, hotel_id) VALUES(2, 'Executive', 1000.00, FALSE, 3, 3)");
        st.executeUpdate("INSERT INTO rooms(room_number, category, rate, availability, max_occupancy, hotel_id) VALUES(1, 'Presidential', 5000.00, TRUE, 4, 4)");
        st.executeUpdate("INSERT INTO rooms(room_number, category, rate, availability, max_occupancy, hotel_id) VALUES(5, 'Deluxe', 200.00, TRUE, 2, 1)");

        System.out.println("Adding into staff");
        st.executeUpdate("INSERT INTO staff(staff_id, staff_address, age, phone_number, job_title, hotel_id, name) VALUES(100, '90 ABC St, Raleigh NC 27', 40, 654, 'Manager', 1, 'Mary')");
        st.executeUpdate("INSERT INTO staff(staff_id, staff_address, age, phone_number, job_title, hotel_id, name) VALUES(101, '798 XYZ St, Rochester NY 54', 45, 564, 'Manager', 2, 'John')");
        st.executeUpdate("INSERT INTO staff(staff_id, staff_address, age, phone_number, job_title, hotel_id, name) VALUES(102, '351 MH St, Greensboro NC 27', 55, 546, 'Manager', 3, 'Carol')");
        st.executeUpdate("INSERT INTO staff(staff_id, staff_address, age, phone_number, job_title, hotel_id, name) VALUES(103, '49 ABC St, Raleigh NC 27', 55, 546, 'Front Desk', 1, 'Emma')");
        st.executeUpdate("INSERT INTO staff(staff_id, staff_address, age, phone_number, job_title, hotel_id, name) VALUES(104, '425 RG St, Raleigh NC 27', 55, 777, 'Catering', 1, 'Ava')");
        st.executeUpdate("INSERT INTO staff(staff_id, staff_address, age, phone_number, job_title, hotel_id, name) VALUES(105, '475 RG St, Raleigh NC 27', 52, 724, 'Manager', 4, 'Peter')");
        st.executeUpdate("INSERT INTO staff(staff_id, staff_address, age, phone_number, job_title, hotel_id, name) VALUES(106, '325 PD St, Raleigh NC 27', 27, 799, 'Front Desk', 4, 'Olivia')");

        System.out.println("Adding into customers");
        st.executeUpdate("INSERT INTO customers(ssn, name, dob, email, phone) VALUES(5939846, 'David', '1980-01-30', 'david@gmail.com', 123)");
        st.executeUpdate("INSERT INTO customers(ssn, name, dob, email, phone) VALUES(7778352, 'Sarah', '1971-01-30', 'sarah@gmail.com', 456)");
        st.executeUpdate("INSERT INTO customers(ssn, name, dob, email, phone) VALUES(8589430, 'Joseph', '1987-01-30', 'joseph@gmail.com', 789)");
        st.executeUpdate("INSERT INTO customers(ssn, name, dob, email, phone) VALUES(4409328, 'Lucy', '1985-01-30', 'lucy@gmail.com', 213)");

        System.out.println("Adding into check ins");
        st.executeUpdate("INSERT INTO check_in(check_in_id, number_of_guests, check_in_date_time, check_out_date_time, room_number, ssn, staff_id) VALUES(1, 1, '2017-05-10 15:17:00', '2017-05-13 10:22:00', 1, 5939846, 103)");
        st.executeUpdate("INSERT INTO check_in(check_in_id, number_of_guests, check_in_date_time, check_out_date_time, room_number, ssn, staff_id) VALUES(2, 2, '2017-05-10 16:11:00', '2017-05-13 09:27:00', 2, 7778352, 103)");
        st.executeUpdate("INSERT INTO check_in(check_in_id, number_of_guests, check_in_date_time, check_out_date_time, room_number, ssn, staff_id) VALUES(3, 1, '2016-05-10 15:45:00', '2016-05-14 11:10:00', 3, 8589430, 101)");
        st.executeUpdate("INSERT INTO check_in(check_in_id, number_of_guests, check_in_date_time, check_out_date_time, room_number, ssn, staff_id) VALUES(4, 2, '2018-05-10 14:30:00', '2018-05-12 10:00:00', 2, 4409328, 102)");

        System.out.println("Adding into presidential suites");
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
                    "phone_number VARCHAR(10) NOT NULL," +
                    "hotel_address VARCHAR(255) NOT NULL UNIQUE" +
                    ");");

            st.executeUpdate("CREATE TABLE rooms(" +
                    "room_number INT," +
                    "category VARCHAR(50) NOT NULL," +
                    "rate FLOAT NOT NULL," +
                    "availability BOOLEAN DEFAULT TRUE NOT NULL," +
                    "max_occupancy INT NOT NULL," +
                    "hotel_id INT," +
                    "CONSTRAINT hotels_table_fk FOREIGN KEY(hotel_id) REFERENCES hotels(hotel_id) ON DELETE CASCADE," +
                    "CONSTRAINT rooms_key_constraint PRIMARY KEY(room_number, hotel_id)" +
                    ");");

            st.executeUpdate("CREATE TABLE staff(" +
                    "staff_id INT PRIMARY KEY," +
                    "staff_address VARCHAR(255) NOT NULL," +
                    "age INT NOT NULL," +
                    "phone_number VARCHAR(10) NOT NULL," +
                    "job_title VARCHAR(50) NOT NULL," +
                    "hotel_id INT," +
                    "name VARCHAR(50) NOT NULL," +
                    "CONSTRAINT hotels_id_fk FOREIGN KEY(hotel_id) REFERENCES hotels(hotel_id) ON DELETE CASCADE" +
                    ");");

            st.executeUpdate("CREATE TABLE customers(" +
                    "ssn INT PRIMARY KEY," +
                    "name VARCHAR(50) NOT NULL," +
                    "dob DATE NOT NULL," +
                    "email VARCHAR(50) NOT NULL," +
                    "phone VARCHAR(10) NOT NULL" +
                    ");");

            st.executeUpdate("CREATE TABLE check_in(" +
                    "check_in_id INT PRIMARY KEY," +
                    "number_of_guests INT NOT NULL," +
                    "check_in_date_time DATETIME NOT NULL," +
                    "check_out_date_time DATETIME," +
                    "room_number INT," +
                    "ssn INT," +
                    "staff_id INT," +
                    "CONSTRAINT room_number_fk FOREIGN KEY(room_number) REFERENCES rooms(room_number) ON DELETE CASCADE," +
                    "CONSTRAINT customer_ssn_fk FOREIGN KEY(ssn) REFERENCES customers(ssn) ON DELETE CASCADE," +
                    "CONSTRAINT staff_id_fk FOREIGN KEY(staff_id) REFERENCES staff(staff_id) ON DELETE CASCADE" +
                    ");");

            st.executeUpdate("CREATE TABLE presidential_suite(" +
                    "room_number INT," +
                    "hotel_id INT," +
                    "room_service_staff INT," +
                    "catering_staff INT," +
                    "CONSTRAINT room_number_presidential_fk FOREIGN KEY(room_number) REFERENCES rooms(room_number) ON DELETE CASCADE," +
                    "CONSTRAINT hotels_id_presidential_fk FOREIGN KEY(hotel_id) REFERENCES hotels(hotel_id) ON DELETE CASCADE," +
                    "CONSTRAINT room_service_staff_fk FOREIGN KEY(room_service_staff) REFERENCES staff(staff_id) ON DELETE CASCADE," +
                    "CONSTRAINT catering_staff_presidential_fk FOREIGN KEY(catering_staff) REFERENCES staff(staff_id) ON DELETE CASCADE," +
                    "CONSTRAINT presidential_suite_key_fk PRIMARY KEY(room_number, hotel_id)" +
                    ");");

            st.executeUpdate("CREATE TABLE billing(" +
                    "bill_id INT PRIMARY KEY," +
                    "total_charge FLOAT NOT NULL," +
                    "card_number VARCHAR(16)," +
                    "billing_address VARCHAR(255)," +
                    "is_hotel_card BOOLEAN DEFAULT FALSE, check_in_id INT," +
                    "CONSTRAINT check_in_table_fk FOREIGN KEY(check_in_id) REFERENCES check_in(check_in_id) ON DELETE CASCADE" +
                    ");");

            st.executeUpdate("CREATE TABLE address_gives_city(" +
                    "address VARCHAR(255)," +
                    "CONSTRAINT address_to_city_fk FOREIGN KEY (address) REFERENCES hotels(hotel_address) ON DELETE CASCADE," +
                    "city VARCHAR(50) NOT NULL," +
                    "CONSTRAINT address_is_primary_key PRIMARY KEY (address)" +
                    ");");

            st.executeUpdate("CREATE TABLE check_in_services(" +
                    "staff_id INT," +
                    "check_in_id INT," +
                    "service_id INT, quantity INT NOT NULL," +
                    "CONSTRAINT staff_id_fk_service FOREIGN KEY(staff_id) REFERENCES staff(staff_id) ON DELETE CASCADE," +
                    "CONSTRAINT check_in_id_fk FOREIGN KEY (check_in_id) REFERENCES check_in(check_in_id) ON DELETE CASCADE," +
                    "CONSTRAINT service_id_fk FOREIGN KEY(service_id) REFERENCES services(service_id) ON DELETE CASCADE," +
                    "CONSTRAINT check_in_services PRIMARY KEY(staff_id, check_in_id, service_id)" +
                    ");");

            st.executeUpdate("CREATE TABLE managed_by(" +
                    "hotel_id INT," +
                    "staff_id INT," +
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