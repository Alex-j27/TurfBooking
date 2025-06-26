package trufbooking;

import java.util.Scanner;

public class TurfMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TurfBookingSystem system = new TurfBookingSystem();

        while (true) {
            System.out.println("\n===== Turf Booking Menu =====");
            System.out.println("1. Book Slot");
            System.out.println("2. View Bookings");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Check Available Slots");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    system.bookSlot();
                    break;
                case 2:
                    system.viewBookings();
                    break;
                case 3:
                    system.cancelBooking();
                    break;
                case 4:
                    system.checkAvailableSlots();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}