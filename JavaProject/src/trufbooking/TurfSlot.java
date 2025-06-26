package trufbooking;

public class TurfSlot {
    private int slotId;
    private String userName;
    private String date;
    private String time;

    public TurfSlot(int slotId, String userName, String date, String time) {
        this.slotId = slotId;
        this.userName = userName;
        this.date = date;
        this.time = time;
    }
    public int getSlotId() {
        return slotId;
    }
    public String getUserName() {
        return userName;
    }
    public String getDate() {
        return date;
    }
    public String getTime() {
        return time;
    }
    @Override
    public String toString() {
        return "Slot ID: " + slotId + ", Name: " + userName + ", Date: " 
    + date + ", Time: " + time;
    }
}
