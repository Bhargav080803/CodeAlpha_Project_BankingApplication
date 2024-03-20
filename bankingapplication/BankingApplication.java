import java.util.Scanner;

public class BankingApplication {
    private static double balance = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("Welcome to Simple Banking Application");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Please select an option: ");

            // Ensure input is valid
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        deposit();
                        break;
                    case 2:
                        withdraw();
                        break;
                    case 3:
                        checkBalance();
                        break;
                    case 4:
                        System.out.println("Thank you for using our banking application!");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please select again.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume invalid input
            }
        }
        scanner.close(); // Close scanner when done
    }

    private static void deposit() {
        System.out.print("Enter deposit amount: ");
        if (scanner.hasNextDouble()) {
            double amount = scanner.nextDouble();
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposit successful.");
            } else {
                System.out.println("Invalid amount. Please enter a positive number.");
            }
        } else {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Consume invalid input
        }
    }

    private static void withdraw() {
        System.out.print("Enter withdrawal amount: ");
        if (scanner.hasNextDouble()) {
            double amount = scanner.nextDouble();
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawal successful.");
            } else {
                System.out.println("Invalid amount or insufficient balance.");
            }
        } else {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next(); // Consume invalid input
        }
    }

    private static void checkBalance() {
        System.out.println("Your balance is: " + balance);
    }
}
