package com.sandun;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("===Hotel Room Booking System===");
        System.out.println("1.Add Room");
        System.out.print("Enter Room Number: ");
        int roomNumber = scanner.nextInt();
        System.out.println("Enter Room Type (Single, Double, Suite): ");
        String roomType = scanner.nextLine();
        System.out.println("Enter Price Per Night:");
        double pricePerNight = scanner.nextDouble();
        System.out.println("Is this a Deluxe Room? (yes/no): ");
        String isDeluxeRoom = scanner.nextLine();
        boolean isBreakfastIncludedYes = false;
        boolean isWiFiIncludedYes = false;
        boolean isLunchIncludedYes = false;
        switch (isDeluxeRoom){
            case "yes":
                System.out.println("Is WiFi Included? (yes/no):");
                String isWiFiIncluded = scanner.nextLine();
                switch(isWiFiIncluded){
                    case "yes":
                        isWiFiIncludedYes = true;
                        break;
                    case "no":
                        isWiFiIncludedYes = false;
                        break;
                }
                System.out.println(" Is Breakfast Included? (yes/no):");
                String isBreakfastIncluded = scanner.nextLine();
                switch(isBreakfastIncluded){
                    case "yes":
                        isBreakfastIncludedYes = true;
                        break;
                    case "no":
                        isBreakfastIncludedYes = false;
                        break;
                }


            case "no":

        }


    }
}