package org.example;

import java.sql.*;
import static org.example.Constants.*;

public class Main {
//    public void addProduct(int product_id, String name, int price, int quantity) {
//        try (Connection conn = DriverManager.getConnection(url, user, password)) {
//            String insertQuery = "INSERT INTO company.product (product_id, name, price, quantity) VALUES (?,?, ?, ?)";
//            try (PreparedStatement preparedStatement = conn.prepareStatement(insertQuery)) {
//                preparedStatement.setInt(1, product_id);
//                preparedStatement.setString(2, name);
//                preparedStatement.setInt(3, price);
//                preparedStatement.setInt(4, quantity);
//                preparedStatement.executeUpdate();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
    public void viewProducts() {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String selectQuery = "SELECT * FROM company.Product";
            try (PreparedStatement preparedStatement = conn.prepareStatement(selectQuery);
                 ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int productId = resultSet.getInt("product_id");
                    String name = resultSet.getString("name");
                    int price = resultSet.getInt("price");
                    int quantity = resultSet.getInt("quantity");
                    System.out.println("ID: " + productId + ", Name: " + name + ", Price: " + price + ", Quantity: " + quantity);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Main main = new Main();
        // Test the addProduct method
//        main.addProduct(7, "chocolate",10,400 );
        main.viewProducts();
        System.out.println("add succesfully");

    }
}
