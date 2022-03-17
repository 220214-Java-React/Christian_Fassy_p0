package com.revature.bank.application;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.apache.logging.log4j.Logger;

public class UserRepository {
    private static final Logger logger = LogManager.getLogger(UserRepository.class);


    public void create(User user) {
        // here we write our SQL to create a user
        Connection connection = null;

        try {
            connection = ConnectionFactory.getConnection();
            String sql = "insert into users(username, password, balance) values (?, ?, ?)";

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setDouble(3, user.getBalance());

            ResultSet resultSet = stmt.executeQuery();
        } catch (SQLException e) {
            logger.warn(e.getMessage(), e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public User getByUsername(String username) {
        User user = null;

        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "select * from users where username = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, username);

            // this
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                user = new User(
                        resultSet.getString("username"),
                        resultSet.getString("password")
                );
            }
        } catch (SQLException e) {
            logger.warn(e.getMessage(), e);
        }
        return user;
    }
}
