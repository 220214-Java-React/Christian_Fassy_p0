package com.revature.bank.application;

import java.util.Scanner;

public class MoneyMenu {

    MoneyDealings update = new MoneyDealings();

    protected double withdraw;
    protected double deposit;

    Scanner scanner = new Scanner(System.in);
    public void BankApp() {
        boolean exit = true;

        while (exit) {
            System.out.println("Welcome to your account!\n" +
                    "How can I help you today?\n" +
                    "1 - Check Balance\n" +
                    "2 - Deposit\n" +
                    "3 - Withdraw\n" +
                    "4 - Exit\n");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1://CURRENT BALANCE
                    System.out.println("Your current balance is $" + update.getBalance() + "\n");
                    break;

                case 2://DEPOSIT
                    System.out.println("How much would you like to deposit?\n");
                    deposit = scanner.nextDouble();
                    update.deposit(deposit);
                    break;

                case 3://WITHDRAW
                    System.out.println("How much would you like to withdraw?\n");
                    withdraw = scanner.nextDouble();
                    System.out.println("You would like to withdraw $" + withdraw + "\n");
                    update.withdraw(withdraw);
                    break;

                case 4://EXIT
                    exit = false;
                    break;
            }

        }
    }
}
