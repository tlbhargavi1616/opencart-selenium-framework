package com.opencart.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBUtil {

    private static final String DB_URL ="jdbc:mariadb://localhost:3307/opencart";


    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = ""; 

    public static boolean isCustomerPresent(String email) {

        boolean isPresent = false;

        String query =
                "SELECT email FROM oc_customer WHERE email = ?";

        try (Connection con =
                     DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

             PreparedStatement ps =
                     con.prepareStatement(query)) {

            ps.setString(1, email);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                isPresent = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return isPresent;
    }
}
