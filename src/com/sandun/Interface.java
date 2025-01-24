package com.sandun;

import java.util.Scanner;

public class Interface {
    public void tasks(){
        Scanner scanner = new Scanner(System.in);
        Operation operation = new Operation();
        InputValidator numberValidator = new InputValidator();
        while(true){
            System.out.println("1. Add Room");
            System.out.println("2. Display All Rooms");
            System.out.println("3. Search Room by Type");
            System.out.println("4. Book a Room");
            System.out.println("5. Cansel Booking");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            numberValidator.validateNumber(choice, 1,6);
            if (choice == 6) break;
            switch(choice){
                case 1:
                    operation.addRoom(scanner);
                    break;
                case 2:
                    operation.displayAllRooms();
                    break;
                case 3:
                    operation.searchRoom(scanner);
                    break;
                case 4:
                    operation.bookRoom(scanner);
                    break;
                case 5:
                    operation.cancelBooking(scanner);
                    break;
            }
        }

    }
}
