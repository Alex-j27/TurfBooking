package turfbooking;

public class TurfBooking {
    private int id;
    private String name;
    private String date;
    private String timeSlot;

    public TurfBooking(String name, String date, String timeSlot) {
        this.name = name;
        this.date = date;
        this.timeSlot = timeSlot;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public String getDate() { return date; }
    public String getTimeSlot() { return timeSlot; }
}