package fooddelivery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Order {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter user ID: ");
        int userId = sc.nextInt();

        System.out.print("Enter food ID: ");
        int foodId = sc.nextInt();

        System.out.print("Enter quantity: ");
        int quantity = sc.nextInt();

        try {
            Connection con = DBConnection.getConnection();

            // Get food price
            String foodSql = "SELECT price FROM food_items WHERE food_id = ?";
            PreparedStatement foodPs = con.prepareStatement(foodSql);
            foodPs.setInt(1, foodId);

            var rs = foodPs.executeQuery();

            if (rs.next()) {

                double price = rs.getDouble("price");
                double total = price * quantity;

                // Insert order
                String orderSql =
                    "INSERT INTO orders (user_id, total_amount) VALUES (?, ?)";

                PreparedStatement orderPs =
                    con.prepareStatement(orderSql,
                    java.sql.Statement.RETURN_GENERATED_KEYS);

                orderPs.setInt(1, userId);
                orderPs.setDouble(2, total);

                orderPs.executeUpdate();

                var keys = orderPs.getGeneratedKeys();

                if (keys.next()) {

                    int orderId = keys.getInt(1);

                    // Insert order item
                    String itemSql =
                        "INSERT INTO order_items " +
                        "(order_id, food_id, quantity, price) " +
                        "VALUES (?, ?, ?, ?)";

                    PreparedStatement itemPs =
                        con.prepareStatement(itemSql);

                    itemPs.setInt(1, orderId);
                    itemPs.setInt(2, foodId);
                    itemPs.setInt(3, quantity);
                    itemPs.setDouble(4, price);

                    itemPs.executeUpdate();

                    System.out.println("Order placed successfully!");
                    System.out.println("Order ID: " + orderId);
                    System.out.println("Total Amount: ₹" + total);
                }

            } else {
                System.out.println("Food item not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}