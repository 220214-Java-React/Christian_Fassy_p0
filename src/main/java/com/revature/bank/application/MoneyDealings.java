package com.revature.bank.application;

import java.util.Scanner;

public class MoneyDealings {
    Scanner scanner = new Scanner(System.in);

    protected double withdraw;
    protected double deposit;
    protected double balance;

    boolean exit = true;

    public void BankApp() {
        while (exit) {
            System.out.println("Hello! Welcome to your interesting bank application!\n" +
                    "How can I help you today?\n" +
                    "1 - Check Balance\n" +
                    "2 - Deposit\n" +
                    "3 - Withdraw\n" +
                    "4 - Exit\n");
            int choice = scanner.nextInt();

            switch (choice) {

                case 1://CURRENT BALANCE
                    System.out.println("Your current balance is $" + balance + "\n");
                    break;

                case 2://DEPOSIT
                    System.out.println("How much would you like to deposit?\n");
                    deposit = scanner.nextDouble();

                    if(deposit <= 0) {
                        System.out.println("Unusable value...Try again\n");
                        break;
                    } else {
                        System.out.println("You have deposited $" + deposit + "\n");
                        balance += deposit;
                        System.out.println("Your new balance is $" + balance + "\n");
                        break;
                    }

                case 3://WITHDRAW
                    System.out.println("How much would you like to withdraw?\n");
                    withdraw = scanner.nextDouble();
                    System.out.println("You would like to withdraw $" + withdraw + "\n");
                    if (balance - withdraw < 0) {
                        System.out.println("Insufficient Funds");
                        break;
                    } else if (withdraw <= 0) {
                        System.out.println("Unusable value...Try again\n");
                        break;
                    } else {
                        System.out.println("You have withdrawn $" + withdraw + "\n");
                        balance -= withdraw;
                        System.out.println("Your new balance is $" + balance + "\n");
                        break;
                    }

                case 4://EXIT
                    exit = false;
                    break;
            }

        }
        System.out.println("we exited");
    }
}
