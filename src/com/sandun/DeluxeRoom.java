package com.sandun;

public class DeluxeRoom extends Room {
    private boolean wifiIncluded;
    private boolean breakfastIncluded;

    public DeluxeRoom(int roomNumber, String roomType, double pricePerNight,boolean wifiIncluded, boolean breakfastIncluded) {
        super(roomNumber, roomType, pricePerNight);
        this.wifiIncluded = wifiIncluded;
        this.breakfastIncluded = breakfastIncluded;
    }
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Wifi: " + wifiIncluded);
        System.out.println("Breakfast: " + breakfastIncluded);
    }
}
