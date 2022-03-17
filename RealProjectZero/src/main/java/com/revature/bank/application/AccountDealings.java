package com.revature.bank.application;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class AccountDealings {

    Scanner scanner = new Scanner(System.in);

    boolean exit = true;

    public static UserService userService;
    private static Logger logger;
    private static User currentUser;

    public void AccountApp() {
        configure();
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
                   currentUser = userService.login();
                   break;
                case 2:
                    userService.register();
                    break;
                case 3:
                    System.out.println(currentUser);
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
    private static void configure(){
        currentUser = null;
        logger = LogManager.getLogger(AccountDealings.class);

        try {
            userService = new UserService();
        } catch (NoSuchAlgorithmException e) {
            logger.warn(e.getMessage(), e);
        }
    }

}
