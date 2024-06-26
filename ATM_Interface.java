package com.internpe;

import java.util.Scanner;
 class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
        }
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}
 class ATM {
    private BankAccount account;

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        while (option != 4) {




            System.out.println("ATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

    }

    private void checkBalance() {
        System.out.printf("Current Balance: %.2f%n", account.getBalance());
    }

    private void deposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            account.deposit(amount);
            System.out.printf("Successfully deposited %.2f. Current Balance: %.2f%n", amount, account.getBalance());
        } else {
            System.out.println("Invalid amount. Please try again.");
        }
    }

    private void withdraw(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            if (account.withdraw(amount)) {
                System.out.printf("Successfully withdrew %.2f. Current Balance: %.2f%n", amount, account.getBalance());
            } else {
                System.out.println("Insufficient funds. Please try again.");
            }
        } else {
            System.out.println("Invalid amount. Please try again.");
        }
    }
}

public class ATM_Interface {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000);  // Initial balance
        ATM atm = new ATM(account);
        atm.displayMenu();
    }
}
