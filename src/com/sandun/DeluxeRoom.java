package com.sandun;

public class DeluxeRoom extends Room {
    private boolean wifiIncluded = false;
    private boolean breakfastIncluded = false;

    public DeluxeRoom(int roomNumber, String roomType, double pricePerNight,boolean wifiIncluded, boolean breakfastIncluded) {
        super(roomNumber, roomType, pricePerNight);
        this.wifiIncluded = false;
        this.breakfastIncluded = false;
    }
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Wifi: " + wifiIncluded);
        System.out.println("Breakfast: " + breakfastIncluded);
    }
}
