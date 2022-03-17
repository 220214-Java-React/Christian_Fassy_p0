package com.revature.bank.application;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class AccountDealings {

    Scanner scanner = new Scanner(System.in);


    public static UserService userService;
    private static Logger logger;
    private static User currentUser;


    public void AccountApp() {
        boolean exit = true;
        configure();

        while(exit)
        {
            System.out.println("\nHello! Welcome to Bank of Fassy!\n" +
                    "How can I help you today?\n" +
                    "1 - Who is logged in?\n" +
                    "2 - Register Account\n" +
                    "3 - Login\n" +
                    "4 - Proceed to banking\n" +
                    "5 - Exit\n");
            int choice = scanner.nextInt();

            switch(choice)
            {
                case 1://Who is logged in?
                    if(currentUser == null) {
                        System.out.println("\n Nobody is logged in right now...");
                    }else{
                        System.out.println("\n" + currentUser.username + " is currently logged in!");

                    }
                   break;
                case 2:
                    userService.register();
                    System.out.println("Registered a new user!");
                    break;
                case 3:
                    currentUser = userService.login();
                    System.out.println("\n" + currentUser.username + " is now logged in!");
                    break;
                case 4:
                    MoneyMenu money = new MoneyMenu();
                    money.BankApp();

                    break;
                case 5:
                    exit = false;
                    break;

            }
        }
    }
    private static void configure(){
        currentUser = null;
        logger = LogManager.getLogger(AccountDealings.class);

        try {
            userService = new UserService();
        } catch (NoSuchAlgorithmException e) {
            logger.warn(e.getMessage(), e);
        }
    }

    public String getCurr() {
        return currentUser.username;
    }
}
