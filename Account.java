// TASK-04 ATM INTERFACE

import java.util.Scanner;
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. \nNew Balance: " + balance);
        } else {
            System.out.println("Invalid Deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal Successful. \nNew Balance: " + balance);
        } else {
            System.out.println("-- Insufficient Balance --");
        }
    }
}

class ATM {
    private BankAccount account;
    private Scanner sc;

    public ATM(BankAccount account) {
        this.account = account;
        sc = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        System.out.println("---------------------------------------------------------------------------");

    }

    public void processOption() {
        int choice;
        do {
            displayMenu();
            System.out.print("Select any one option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: " + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter Deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter Withdrawal amount: ");
                    double withdrawalAmount = sc.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("-- ERROR --");
            }
        } while (choice != 4);
    }

    public void closeScanner() {
        sc.close();
    }
}

public class Account {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(20000.0);
        ATM atm = new ATM(userAccount);

        System.out.println("--------------------------- WELCOME TO THE ATM! ---------------------------");
        atm.processOption();

        atm.closeScanner();
    }
}
