package menu;

import java.util.Scanner;

public class MenuHandler {
    public static void showMainMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n==== Adom Logistics Fleet System ====");
            System.out.println("1. Manage Vehicles");
            System.out.println("2. Assign Driver");
            System.out.println("3. Track Deliveries");
            System.out.println("4. Maintenance Scheduler");
            System.out.println("5. Fuel Efficiency Reports");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Vehicle Management - Coming soon...");
                    break;
                case 2:
                    System.out.println("Driver Assignment - Coming soon...");
                    break;
                case 3:
                    System.out.println("Delivery Tracking - Coming soon...");
                    break;
                case 4:
                    System.out.println("Maintenance Scheduler - Coming soon...");
                    break;
                case 5:
                    System.out.println("Fuel Efficiency Reports - Coming soon...");
                    break;
                case 6:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (choice != 6);

        scanner.close();
    }
}
