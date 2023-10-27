package org.example;

import java.sql.*;
import static org.example.Constants.*;

public class Main {
    public void addProduct(int product_id, String name, int price, int quantity) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String insertQuery = "INSERT INTO company.product (product_id, name, price, quantity) VALUES (?,?, ?, ?)";
            try (PreparedStatement preparedStatement = conn.prepareStatement(insertQuery)) {
                preparedStatement.setInt(1, product_id);
                preparedStatement.setString(2, name);
                preparedStatement.setInt(3, price);
                preparedStatement.setInt(4, quantity);
                preparedStatement.executeUpdate();
        System.out.println("add succesfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
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

    public void updateProduct(int productId, String name, int Price, int Quantity) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String updateQuery = "UPDATE company.Product SET Name = ?, Price = ?, Quantity = ? WHERE Product_id = ?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(updateQuery)) {
                preparedStatement.setInt(1, productId);
                preparedStatement.setString(2, name);
                preparedStatement.setDouble(3, Price);
                preparedStatement.setInt(4, Quantity);
                preparedStatement.executeUpdate();
                System.out.println("Product updated successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteProduct(int productId) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String deleteQuery = "DELETE FROM company.Product WHERE product_id = ?";
            try (PreparedStatement preparedStatement = conn.prepareStatement(deleteQuery)) {
                preparedStatement.setInt(1, productId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Main main = new Main();
        // Test the addProduct method
//        main.addProduct(8, "chocolate",10,500 );
        main.viewProducts();
//          main.updateProduct(7, "new_chocolate", 12, 450);
          main.deleteProduct(8);
    }
}
