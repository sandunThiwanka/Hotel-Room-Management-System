package com.sandun;

import java.util.Scanner;
public class Operation {
    private Room[] rooms = new Room[100]; // Array to store room objects
    private int roomCount = 0; // Counter to track the number of stored rooms
    //Scanner scanner = new Scanner(System.in);

    public void addRoom(Scanner scanner) { // Pass Scanner object from outside
        System.out.println("=== Hotel Room Booking System ===");
        System.out.print("Enter Room Number: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the leftover newline

        System.out.print("Enter Room Type (Single, Double, Suite): ");
        String roomType = scanner.nextLine();

        System.out.print("Enter Price Per Night: ");
        double pricePerNight = scanner.nextDouble();
        scanner.nextLine(); // Consume the leftover newline

        System.out.print("Is this a Deluxe Room? (yes/no): ");
        String isDeluxeRoom = scanner.nextLine();

        Room room;
        if (isDeluxeRoom.equalsIgnoreCase("yes")) {
            System.out.print("Is WiFi Included? (yes/no): ");
            String isWiFiIncluded = scanner.nextLine();
            boolean wifi = isWiFiIncluded.equalsIgnoreCase("no");

            System.out.print("Is Breakfast Included? (yes/no): ");
            String isBreakfastIncluded = scanner.nextLine();
            boolean breakfast = isBreakfastIncluded.equalsIgnoreCase("no");

            room = new DeluxeRoom(roomNumber, roomType, pricePerNight, wifi, breakfast);
            System.out.println("Deluxe Room Details:");
        } else {
            room = new Room(roomNumber, roomType, pricePerNight);
        }
        storeRoom(room); // Store the room object
    }

    private void storeRoom(Room room) {
        if (roomCount < rooms.length) {
            rooms[roomCount] = room;
            roomCount++;
            System.out.println("Room successfully added. Total rooms: " + roomCount);
        } else {
            System.out.println("Error: Room storage is full!");
        }
    }

    public void displayAllRooms() {
        if (roomCount == 0) {
            System.out.println("No rooms available.");
            return;
        }
        System.out.println("=== All Room Details ===");
        for (int i = 0; i < roomCount; i++) {
            rooms[i].displayDetails();
        }
    }
    public void searchRoom(Scanner scanner) {
        System.out.print("Enter Room Type (Single, Double, Suite): ");
        String roomType = scanner.nextLine(); // Correctly read the input
        scanner.nextLine();
        boolean roomFound = false; // Track if any matching room is found

        System.out.println("=== Search Results ===");
        for (int i = 0; i < roomCount; i++) { // Only iterate through added rooms
            Room room = rooms[i];
            if (room != null && room.getRoomType().equalsIgnoreCase(roomType)) {
                room.displayDetails();
                roomFound = true;
            }
        }

        if (!roomFound) {
            System.out.println("No available rooms found for the specified type.");
        }
    }


    public void bookRoom(Scanner scanner) {
        System.out.println("Enter Room Number: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the leftover newline
        boolean roomBooked = false; // Track if the room is successfully booked

        for (int i = 0; i < roomCount; i++) { // Only iterate through added rooms
            Room room = rooms[i];
            if (room.getRoomNumber() == roomNumber) {
                if (room.isAvailable()) {
                    room.setAvailable(false); // Book the room
                    System.out.println("Room " + roomNumber + " successfully booked.");
                    roomBooked = true;
                    break;
                } else {
                    System.out.println("Room " + roomNumber + " is already booked.");
                    roomBooked = true;
                    break;
                }
            }
        }

        if (!roomBooked) {
            System.out.println("Room number " + roomNumber + " not found.");
        }
    }
    public void cancelBooking(Scanner scanner) {
        System.out.println("Enter Room Number to Cancel Booking: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the leftover newline
        boolean bookingCancelled = false; // Track if the booking is successfully canceled

        for (int i = 0; i < roomCount; i++) { // Only iterate through added rooms
            Room room = rooms[i];
            if (room.getRoomNumber() == roomNumber) {
                if (!room.isAvailable()) {
                    room.setAvailable(true); // Mark the room as available
                    System.out.println("Booking for Room " + roomNumber + " has been successfully canceled.");
                    bookingCancelled = true;
                    break;
                } else {
                    System.out.println("Room " + roomNumber + " is not currently booked.");
                    bookingCancelled = true;
                    break;
                }
            }
        }

        if (!bookingCancelled) {
            System.out.println("Room number " + roomNumber + " not found.");
        }
    }
}
