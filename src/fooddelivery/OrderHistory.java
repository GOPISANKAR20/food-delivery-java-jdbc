package fooddelivery;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class OrderHistory {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter user ID: ");
        int userId = sc.nextInt();

        try {
            Connection con = DBConnection.getConnection();

            String sql = "SELECT o.order_id, oi.food_id, oi.quantity, oi.price, " +
                         "o.total_amount, o.order_date " +
                         "FROM orders o " +
                         "JOIN order_items oi ON o.order_id = oi.order_id " +
                         "WHERE o.user_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                System.out.println("-------------------------");
                System.out.println("Order ID: " + rs.getInt("order_id"));
                System.out.println("Food ID: " + rs.getInt("food_id"));
                System.out.println("Quantity: " + rs.getInt("quantity"));
                System.out.println("Price: ₹" + rs.getDouble("price"));
                System.out.println("Total: ₹" + rs.getDouble("total_amount"));
                System.out.println("Date: " + rs.getTimestamp("order_date"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}