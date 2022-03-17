package com.revature.bank.application;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MoneyDealings {
    private static final Logger logger = LogManager.getLogger(MoneyDealings.class);
    private double balance;

    AccountDealings account = new AccountDealings();

    public double getBalance() {

        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "select distinct balance from users where username = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, account.getCurr());
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                balance = resultSet.getDouble("balance");
            }
        } catch (SQLException e) {
            logger.warn(e.getMessage(), e);
        }
        return balance;
    }

    public void balancePatch() {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "update users set balance = ? where username = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setDouble(1, balance);
            stmt.setString(2, account.getCurr());
            stmt.executeUpdate();
        } catch (SQLException e) {
            logger.warn(e.getMessage(), e);
        }

    }

    public void withdraw(double withdraw) {
        if (withdraw <= 0)
        {
            System.out.println("Cannot use this value... Try again");
            return;
        }
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "select distinct balance from users where username = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, account.getCurr());
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                balance = resultSet.getDouble("balance");
            }

            if (balance >= withdraw) {
                balance -= withdraw;
                System.out.println("Withdrew $" + withdraw +
                        "\nCurrent balance- $" + balance + "\n");
            }else {
                try {
                    System.out.println("Insufficient funds... \n " +
                            "Current balance- $" + balance + "\n");
                } catch (ExceptionInInitializerError E) {
                    System.out.println("Withdraw Failed");
                }
                ;
            }
        } catch (SQLException e) {
            logger.warn(e.getMessage(), e);
        }
        balancePatch();
    }

    public void deposit(double deposit) {
        if (deposit <= 0)
        {
            System.out.println("Cannot use this value... Try again");
            return;
        }
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "select distinct balance from users where username = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, account.getCurr());
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                balance = resultSet.getDouble("balance");
            }
            balance += deposit;
            System.out.println("Deposited $" + deposit +
                    "\nCurrent balance- $" + balance + "\n");
        } catch (SQLException e) {
            logger.warn(e.getMessage(), e);
        }
        balancePatch();
    }
}
