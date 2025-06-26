package turfbooking;

import java.util.Scanner;

public class TurfBookingMain {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            TurfBookingImplementation impl = new TurfBookingImplementation();
            int choice;

            do {
                System.out.println("\n=== Turf Booking System ===");
                System.out.println("1. Book Turf Slot");
                System.out.println("2. View All Bookings");
                System.out.println("3. Cancel Booking");
                System.out.println("4. Check Available Slots");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();
                sc.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Date (YYYY-MM-DD): ");
                        String date = sc.nextLine();
                        System.out.print("Enter Time Slot (Morning/Afternoon/Evening): ");
                        String slot = sc.nextLine();
                        TurfBooking tb = new TurfBooking(name, date, slot);
                        impl.bookSlot(tb);
                        break;
                    case 2:
                        impl.viewBookings();
                        break;
                    case 3:
                        System.out.print("Enter Booking ID to cancel: ");
                        int id = sc.nextInt();
                        impl.cancelBooking(id);
                        break;
                    case 4:
                        System.out.print("Enter Date to check availability (YYYY-MM-DD): ");
                        String checkDate = sc.nextLine();
                        impl.checkAvailableSlots(checkDate);
                        break;
                    case 5:
                        System.out.println("Thank you for using Turf Booking System.");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }

            } while (choice != 5);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
