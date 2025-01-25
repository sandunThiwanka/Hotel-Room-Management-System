package com.sandun;

import java.util.Scanner;
public class Operation {
    private Room[] rooms = new Room[100];
    private int roomCount = 0;
    private Scanner scanner = new Scanner(System.in);

    private void validateRange(double value, double min, double max) {
        if(value < min || value > max)
            System.out.println("Please enter a number between " + min + " and " + max);
    }
    public void taskList(){
        while(true){
            System.out.println("===Hotel Room Management System===");
            System.out.println("1. Add Room");
            System.out.println("2. Display All Rooms");
            System.out.println("3. Search Room by Type");
            System.out.println("4. Book a Room");
            System.out.println("5. Cansel Booking");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            validateRange(choice, 1,6);
            if (choice == 6) break;
            switch(choice){
                case 1:
                    addRoom();
                    break;
                case 2:
                    displayAllRooms();
                    break;
                case 3:
                    searchRoom();
                    break;
                case 4:
                    bookRoom();
                    break;
                case 5:
                    cancelBooking();
                    break;
            }
        }
    }

    private void addRoom() {
        System.out.println("=== Add Room ===");
        System.out.print("Enter Room Number: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine();
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
            boolean wifi = true;
            if (isWiFiIncluded.equalsIgnoreCase("no")) {
                wifi = false;
            }
            System.out.print("Is Breakfast Included? (yes/no): ");
            String isBreakfastIncluded = scanner.nextLine();
            boolean breakfast = true;
            if (isBreakfastIncluded.equalsIgnoreCase("no")) {
                breakfast = false;
            }
            room = new DeluxeRoom(roomNumber, roomType, pricePerNight, wifi, breakfast);
        } else {
            room = new Room(roomNumber, roomType, pricePerNight);
        }
        storeRoom(room);
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

    private void displayAllRooms() {
        if (roomCount == 0) {
            System.out.println("No rooms available.");
            return;
        }
        System.out.println("=== All Room Details ===");
        for (int i = 0; i < roomCount; i++) {
            rooms[i].displayDetails();
        }
    }
    private void searchRoom() {
        System.out.println("=== Search Room ===");
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("Enter Room Type (Single, Double, Suite): ");
        String roomType = scanner1.nextLine();
        scanner.nextLine();
        boolean roomFound = false;

        System.out.println("--- Search Results ---");
        for (int i = 0; i < roomCount; i++) {
            Room room = rooms[i];
            if (room.getRoomType().equalsIgnoreCase(roomType)) {
                room.displayDetails();
                roomFound = true;
            }
        }

        if (!roomFound) {
            System.out.println("No available rooms found for the specified type.");
        }
    }

    private void bookRoom() {
        System.out.println("=== Book Room ===");
        System.out.print("Enter Room Number: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine();
        boolean roomBooked = false;

        for (int i = 0; i < roomCount; i++) {
            Room room = rooms[i];
            if (room.getRoomNumber() == roomNumber) {
                if (room.isAvailable()) {
                    room.setAvailable(false);
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
    private void cancelBooking() {
        System.out.println("=== Cancel Booking ===");
        System.out.print("Enter Room Number to Cancel Booking: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine();
        boolean bookingCancelled = false;

        for (int i = 0; i < roomCount; i++) {
            Room room = rooms[i];
            if (room.getRoomNumber() == roomNumber) {
                if (!room.isAvailable()) {
                    room.setAvailable(true);
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
