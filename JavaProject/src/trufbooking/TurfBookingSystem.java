package trufbooking;

import java.util.ArrayList;
import java.util.Scanner;

public class TurfBookingSystem {
    Scanner scanner = new Scanner(System.in);
    ArrayList<TurfSlot> bookings = new ArrayList<>();
    int nextSlotId = 1;

    public void bookSlot() {
        System.out.print("Enter your name: ");
        String name = scanner.next();
        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = scanner.next();
        System.out.print("Enter time (e.g., 6PM-7PM): ");
        String time = scanner.next();

        bookings.add(new TurfSlot(nextSlotId++, name, date, time));
        System.out.println("Booking successful!");
    }

    public void viewBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings found.");
        } else {
            for (TurfSlot slot : bookings) {
                System.out.println(slot);
            }
        }
    }

    public void cancelBooking() {
        System.out.print("Enter Slot ID to cancel: ");
        int id = scanner.nextInt();

        boolean removed = bookings.removeIf(slot -> slot.getSlotId() == id);

        if (removed) {
            System.out.println("Booking cancelled successfully!");
        } else {
            System.out.println("Booking not found.");
        }
    }

    public void checkAvailableSlots() {
        System.out.println("Available slots (example):");
        System.out.println("6AM - 7AM");
        System.out.println("7AM - 8AM");
        System.out.println("5PM - 6PM");
        System.out.println("6PM - 7PM");
    }
}