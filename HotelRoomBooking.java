import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class HotelRoomBooking {
    static Map<String, Integer> availableRooms = new HashMap<>();

    public static void main(String[] args) {
        initializeRooms();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Hotel Room Booking System");

        while (true) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Book Room");
            System.out.println("2. Check Available Rooms");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    bookRoom(scanner);
                    break;
                case 2:
                    checkAvailableRooms();
                    break;
                case 3:
                    System.out.println("Thank you for using the Hotel Room Booking System.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    static void initializeRooms() {
        availableRooms.put("Single", 10);
        availableRooms.put("Double", 10);
        availableRooms.put("Suite", 5);
    }

    static void bookRoom(Scanner scanner) {
        System.out.print("Enter room type (Single/Double/Suite): ");
        String roomType = scanner.next();

        if (!availableRooms.containsKey(roomType)) {
            System.out.println("Invalid room type. Please enter Single, Double, or Suite.");
            return;
        }

        System.out.print("Enter number of nights: ");
        int numNights = scanner.nextInt();

        int availableCount = availableRooms.get(roomType);
        if (availableCount == 0) {
            System.out.println("Sorry, no " + roomType + " rooms available.");
            return;
        }

        if (numNights <= 0) {
            System.out.println("Invalid number of nights. Please enter a positive number.");
            return;
        }

        availableRooms.put(roomType, availableCount - 1);
        System.out.println("Room booked successfully. Enjoy your stay!");
    }

    static void checkAvailableRooms() {
        System.out.println("Available Rooms:");
        for (Map.Entry<String, Integer> entry : availableRooms.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
