package turfbooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TurfBookingImplementation {
    private Connection con;

    // Constructor to connect to MySQL database
    public TurfBookingImplementation() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver"); // MySQL driver
        con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/turf_booking", // DB URL
            "root",     // username (change if needed)
            "password"  // password (change if needed)
        );
    }

    // Method to insert a booking
    public void bookSlot(TurfBooking tb) throws SQLException {
        String sql = "INSERT INTO bookings (name, date, time_slot) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, tb.getName());
        ps.setString(2, tb.getDate());
        ps.setString(3, tb.getTimeSlot());
        ps.executeUpdate();
        System.out.println("Slot booked successfully.");
    }

    // Method to view all bookings
    public void viewBookings() throws SQLException {
        String sql = "SELECT * FROM bookings";
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id") +
                ", Name: " + rs.getString("name") +
                ", Date: " + rs.getString("date") +
                ", Time Slot: " + rs.getString("time_slot") +
                ", Status: " + rs.getString("status"));
        }
    }

    // Method to cancel a booking
    public void cancelBooking(int id) throws SQLException {
        String sql = "UPDATE bookings SET status = 'Cancelled' WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        int result = ps.executeUpdate();
        if (result > 0) {
            System.out.println("Booking cancelled successfully.");
        } else {
            System.out.println("Booking ID not found.");
        }
    }

    // Method to check available slots for a date
    public void checkAvailableSlots(String date) throws SQLException {
        String[] slots = {"Morning", "Afternoon", "Evening"};
        for (String slot : slots) {
            String sql = "SELECT COUNT(*) FROM bookings WHERE date = ? AND time_slot = ? AND status = 'Booked'";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, date);
            ps.setString(2, slot);
            ResultSet rs = ps.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            if (count == 0) {
                System.out.println(slot + " is Available");
            } else {
                System.out.println(slot + " is Booked");
            }
        }
    }
}