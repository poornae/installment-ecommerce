/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tables;

/**
 *
 * @author poornae
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Util {
        
    public static Customer[] getCustomer() {
        String url = "jdbc:mysql://localhost:3306/ecommerceDB?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String user = "root";
        String password = "f949d8254b17db414e5f9d8b28c1676fef9a1c172f564b0f7cab2a24a14525e3";
        
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT * FROM customer";
            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {
                List<Customer> customerList = new ArrayList<>();
                while (rs.next()) {
                    String customerId = rs.getString("customerID");
                    String fullName = rs.getString("full_name");
                    String email = rs.getString("email");
                    String dob = rs.getString("dob");
                    String nicNo = rs.getString("nicNo");
                    String profileImage = rs.getString("profile_image");
                    String contactNo = rs.getString("contact_no");
                    String address = rs.getString("address");
                    String createdAt = rs.getString("created_at");
                    String updatedAt = rs.getString("updated_at");
                    String loginAt = rs.getString("login_at");
                    customerList.add(new Customer(customerId, fullName, email, dob, nicNo, profileImage, contactNo, address, createdAt, updatedAt, loginAt));
                }
                return customerList.toArray(new Customer[customerList.size()]);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static boolean authenticate(String username, String password) {
        if (username == null && password == null) {
           return false;
        }
        return username.equals("poorna") && password.equals("9e55f53dcfdbb95d0550f839a6e5caf22d25646563395505510a7c12feea7ed6");
    }
}

