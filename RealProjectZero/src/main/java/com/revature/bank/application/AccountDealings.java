package com.revature.bank.application;
import java.sql.SQLOutput;
import java.util.Scanner;

public class AccountDealings {

    Users user = new Users();

    Scanner scanner = new Scanner(System.in);
    String loggedIn = null;
    String password = null;


    boolean exit = true;

    public void AccountApp() {
        while(exit)
        {
            System.out.println("\nHello! Welcome!\n" +
                    "How can I help you today?\n" +
                    "1 - Who is logged in?\n" +
                    "2 - Register Account\n" +
                    "3 - Login\n" +
                    "4 - Proceed to banking\n" +
                    "5 - Exit\n");
            int choice = scanner.nextInt();

            switch(choice)
            {
                case 1:
                    if (user.getUsernames() == null)
                    {
                        System.out.println("Nobody is logged in...");
                        break;
                    }
                    else
                    {
                        System.out.println(user.getUsernames() + " is currently logged in!\n");
                        break;
                    }
                case 2:
                    System.out.println("What would you like your Username to be?");
                    loggedIn = scanner.next();
                    System.out.println("What would you like your Password to be?");
                    password = scanner.next();

                    user.SignUp(loggedIn, password);
                    break;
                case 3:
                    break;
                case 4:

                    MoneyDealings bank = new MoneyDealings();
                    bank.BankApp();
                    break;
                case 5:
                    exit = false;
                    break;

            }
        }
    }
}
