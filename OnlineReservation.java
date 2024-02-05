import java.util.Scanner;

public class OnlineReservation {

    private static boolean[] seats = new boolean[50]; 
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nPlease select an option:");
            System.out.println("\n1. View Seat Map");
            System.out.println("\n2. Reserve Seat");
            System.out.println("\n3. Cancel Reservation");
            System.out.println("\n4. Exit");

        
            int option = scanner.nextInt();

            switch (option) {

                case 1:
                    viewSeats();
                    break;

                case 2:
                    reserveSeats();
                    break;

                case 3:
                    cancelSeats();
                    break;

                case 4:
                    System.exit(0); // exit the program

                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    private static void viewSeats() {
        System.out.println("\nCurrent Seats:");
        for (int i = 0; i < seats.length; i++) {
            if (seats[i]) {
                System.out.print("X "); // print "X" if the seat is alread reserved
            } else {
                System.out.print((i + 1) + " "); // print the seat number if it's empty
            }
        }
        System.out.println();
    }

    private static void reserveSeats() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter seat number (1-50): ");
        int seatNumber = scanner.nextInt();
        if (seatNumber < 1 || seatNumber > 50) {
            System.out.println("Invalid seat number!");
        } else if (seats[seatNumber - 1]) {
            System.out.println("Seat already reserved!");
        } else {
            seats[seatNumber - 1] = true; // reserve the seat
            System.out.println("Seat reserved!");
        }
    }

    private static void cancelSeats() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter seat number (1-50): ");
        int seatNumber = scanner.nextInt();
        if (seatNumber < 1 || seatNumber > 50) {
            System.out.println("Invalid seat number!");
        } else if (!seats[seatNumber - 1]) {
            System.out.println("Seat not reserved!");
        } else {
            seats[seatNumber - 1] = false; // unreserve the seat
            System.out.println("Reservation canceled!");
        }
    }
}
