package ATMProject;
import java.util.Scanner;

// Represents a simple bank account
class Account {
    private double balance;

    public Account(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
        }
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }
}

// Represents the ATM machine
class ATM {
    private Account account;
    private Scanner input;

    public ATM(Account account) {
        this.account = account;
        this.input = new Scanner(System.in);
    }

    public void showMenu() {
        int choice;
        do {
            System.out.println("\n======= ATM INTERFACE =======");
            System.out.println("1. Withdraw Funds");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            // Validate numeric input
            while (!input.hasNextInt()) {
                System.out.print("Invalid input. Enter a number: ");
                input.next();
            }
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    performWithdrawal();
                    break;
                case 2:
                    performDeposit();
                    break;
                case 3:
                    displayBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using our ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        } while (choice != 4);
    }

    private void performWithdrawal() {
        System.out.print("Enter amount to withdraw: ");
        double amount = input.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful! Remaining balance: ₹" + account.getBalance());
        } else {
            System.out.println("Withdrawal failed! Check amount and balance.");
        }
    }

    private void performDeposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = input.nextDouble();
        if (account.deposit(amount)) {
            System.out.println("Deposit successful! New balance: ₹" + account.getBalance());
        } else {
            System.out.println("Deposit failed! Please enter a valid amount.");
        }
    }

    private void displayBalance() {
        System.out.println("Current balance: ₹" + account.getBalance());
    }
}

// Main class to start the program
public class ATMInterface {
    public static void main(String[] args) {
        Account userAccount = new Account(1000.0); // Initial balance
        ATM atmMachine = new ATM(userAccount);
        atmMachine.showMenu();
    }}


    
